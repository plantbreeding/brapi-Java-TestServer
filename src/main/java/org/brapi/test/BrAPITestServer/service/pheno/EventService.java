package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.List;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.pheno.EventEntity;
import org.brapi.test.BrAPITestServer.repository.pheno.EventRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;

import io.swagger.model.Metadata;
import io.swagger.model.pheno.Event;
import io.swagger.model.pheno.EventDateRange;
import io.swagger.model.pheno.EventParameters;

@Service
public class EventService {

	private final EventRepository eventRepository;

	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public List<Event> findEvents(String eventDbId, String studyDbId, String observationUnitDbId, String eventType,
			OffsetDateTime dateRangeStart, OffsetDateTime dateRangeEnd, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<EventEntity> searchQuery = new SearchQueryBuilder<EventEntity>(EventEntity.class);

		searchQuery = searchQuery.appendSingle(eventDbId, "id");
		searchQuery = searchQuery.appendSingle(studyDbId, "study.id");
		searchQuery = searchQuery.appendSingle(eventType, "eventType");
		if (observationUnitDbId != null) {
			searchQuery = searchQuery.join("observationUnits", "observationUnit").appendSingle(observationUnitDbId,
					"*observationUnit.id");
		}
		if (dateRangeStart != null || dateRangeEnd != null) {
			searchQuery = searchQuery.join("dates", "dateOccured").appendDateRange(dateRangeStart, dateRangeEnd,
					"*dateOccured");
		}

		Page<EventEntity> page = eventRepository.findAllBySearch(searchQuery, pageReq);
		List<Event> crossingProjects = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return crossingProjects;
	}

	private Event convertFromEntity(EventEntity entity) {
		Event event = new Event();
		UpdateUtility.convertFromEntity(entity, event);

		event.setEventDbId(entity.getId());
		event.setEventDescription(entity.getEventDescription());
		event.setEventType(entity.getEventType());
		event.setEventTypeDbId(entity.getEventTypeDbId());

		if (entity.getDates() != null) {
			event.setDate(
					entity.getDates().stream().map(d -> DateUtility.toOffsetDateTime(d)).collect(Collectors.toList()));
		}
		if (entity.getDates() != null) {
			event.setEventDateRange(new EventDateRange());
			event.getEventDateRange().setDiscreteDates(
					entity.getDates().stream().map(d -> DateUtility.toOffsetDateTime(d)).collect(Collectors.toList()));
		}
		if (entity.getEventParameters() != null) {
			event.setEventParameters(entity.getEventParameters().stream().map(p -> {
				EventParameters param = new EventParameters();
				param.setKey(p.getKey());
				param.setRdfValue(p.getRdfValue());
				param.setValue(p.getValue());
				param.setCode(p.getCode());
				param.setDescription(p.getDescription());
				param.setName(p.getName());
				param.setUnits(p.getUnits());
				param.setValueDescription(p.getValueDescription());
				param.setValuesByDate(p.getValuesByDate());
				return param;
			}).collect(Collectors.toList()));
		}
		if (entity.getObservationUnits() != null) {
			event.setObservationUnitDbIds(
					entity.getObservationUnits().stream().map(ou -> ou.getId()).collect(Collectors.toList()));
		}
		if (entity.getStudy() != null) {
			event.setStudyDbId(entity.getStudy().getId());
			event.setStudyName(entity.getStudy().getStudyName());
		}

		return event;
	}

}
