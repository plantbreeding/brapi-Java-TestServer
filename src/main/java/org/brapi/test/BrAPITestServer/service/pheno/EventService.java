package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.List;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.pheno.EventEntity;
import org.brapi.test.BrAPITestServer.repository.pheno.EventRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;

import io.swagger.model.Metadata;
import io.swagger.model.pheno.Event;
import io.swagger.model.pheno.EventEventParameters;

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
			searchQuery = searchQuery.join("observationUnits", "observationUnit")
					.appendSingle(observationUnitDbId,	"*observationUnit.id");
		}
		if (dateRangeStart != null || dateRangeEnd != null) {
			searchQuery = searchQuery.join("dates", "dateOccured")
					.appendDateRange(dateRangeStart, dateRangeEnd,	"*dateOccured");
		}

		Page<EventEntity> page = eventRepository.findAllBySearch(searchQuery, pageReq);
		List<Event> crossingProjects = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return crossingProjects;
	}

	private Event convertFromEntity(EventEntity entity) {
		Event event = new Event();
		event.setAdditionalInfo(entity.getAdditionalInfoMap());
		if (entity.getDates() != null) {
			event.setDate(entity.getDates().stream().map(d -> {
				return DateUtility.toOffsetDateTime(d);
			}).collect(Collectors.toList()));
		}
		event.setEventDbId(entity.getId());
		event.setEventDescription(entity.getEventDescription());
		if (entity.getEventParameters() != null) {
			event.setEventParameters(entity.getEventParameters().stream().map(p -> {
				EventEventParameters param = new EventEventParameters();
				param.setKey(p.getKey());
				param.setRdfValue(p.getRdfValue());
				param.setValue(p.getValue());
				return param;
			}).collect(Collectors.toList()));
		}
		event.setEventType(entity.getEventType());
		event.setEventTypeDbId(entity.getEventTypeDbId());
		if (entity.getObservationUnits() != null) {
			event.setObservationUnitDbIds(entity.getObservationUnits().stream().map(ou -> {
				return ou.getId();
			}).collect(Collectors.toList()));
		}
		if (entity.getStudy() != null)
			event.setStudyDbId(entity.getStudy().getId());

		return event;
	}

}
