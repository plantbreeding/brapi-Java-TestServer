package org.brapi.test.BrAPITestServer.service.germ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Map.Entry;

import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.germ.CrossEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.CrossPollinationEventEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.CrossingProjectEntity;
import org.brapi.test.BrAPITestServer.repository.germ.CrossRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.germ.Cross;
import io.swagger.model.germ.CrossInterface;
import io.swagger.model.germ.CrossNewRequest;
import io.swagger.model.germ.CrossNewRequestCrossAttributes;
import io.swagger.model.germ.CrossPollinationEvents;
import io.swagger.model.germ.PlannedCross;
import io.swagger.model.germ.PlannedCrossNewRequest;

@Service
public class CrossService {

	private final CrossRepository crossRepository;
	private final CrossingProjectService crossingProjectService;
	private final CrossParentService crossParentService;

	public CrossService(CrossRepository crossRepository, CrossingProjectService crossingProjectService,
			CrossParentService crossParentService) {
		this.crossRepository = crossRepository;
		this.crossingProjectService = crossingProjectService;
		this.crossParentService = crossParentService;
	}

	public List<Cross> findCrosses(String crossingProjectDbId, String crossingProjectName, String crossDbId,
			String crossName, String commonCropName, String programDbId, String externalReferenceId,
			String externalReferenceID, String externalReferenceSource, Metadata metadata) {
		List<Cross> crosses = findCrossEntities(crossingProjectDbId, crossingProjectName, crossDbId, crossName, null,
				commonCropName, programDbId, externalReferenceId, externalReferenceID, externalReferenceSource, false,
				metadata).map(this::convertToCross).getContent();
		return crosses;
	}

	public List<PlannedCross> findPlannedCrosses(String crossingProjectDbId, String crossingProjectName,
			String crossDbId, String crossName, String status, String commonCropName, String programDbId,
			String externalReferenceId, String externalReferenceID, String externalReferenceSource, Metadata metadata) {
		List<PlannedCross> crosses = findCrossEntities(crossingProjectDbId, crossingProjectName, crossDbId, crossName, status,
				commonCropName, programDbId, externalReferenceId, externalReferenceID, externalReferenceSource, true,
				metadata).map(this::convertToPlanned).getContent();
		return crosses;
	}

	public Page<CrossEntity> findCrossEntities(String crossingProjectDbId, String crossingProjectName, String crossDbId,
			String crossName, String status, String commonCropName, String programDbId, String externalReferenceId,
			String externalReferenceID, String externalReferenceSource, Boolean plannedCross, Metadata metadata) {

		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<CrossEntity> searchQuery = new SearchQueryBuilder<CrossEntity>(CrossEntity.class);
		if (crossDbId != null)
			searchQuery = searchQuery.appendSingle(crossDbId, "id");
		if (crossingProjectDbId != null)
			searchQuery = searchQuery.appendSingle(crossingProjectDbId, "crossingProject.id");
		if (externalReferenceID != null && externalReferenceSource != null)
			searchQuery = searchQuery.withExRefs(Arrays.asList(externalReferenceID),
					Arrays.asList(externalReferenceSource));
		if (plannedCross != null)
			searchQuery = searchQuery.appendSingle(plannedCross, "planned");

		Page<CrossEntity> page = crossRepository.findAllBySearch(searchQuery, pageReq);
		PagingUtility.calculateMetaData(metadata, page);
		return page;
	}

	public CrossEntity getCrossEntity(String crossDbId, Boolean isPlanned) {
		if(isPlanned == null) {
			isPlanned = false;
		}
		if(crossDbId == null) {
			crossDbId = "";
		}
		return crossRepository.findByIdAndPlanned(crossDbId, isPlanned);
	}
	
	public List<Cross> saveCrosses(@Valid List<CrossNewRequest> body) throws BrAPIServerException {
		List<Cross> savedValues = new ArrayList<>();

		for (CrossNewRequest cross : body) {

			CrossEntity entity = new CrossEntity();
			updateEntity(entity, cross);

			CrossEntity savedEntity = crossRepository.save(entity);

			savedValues.add(convertToCross(savedEntity));
		}

		return savedValues;
	}

	public List<PlannedCross> savePlannedCrosses(@Valid List<PlannedCrossNewRequest> body) throws BrAPIServerException {
		List<PlannedCross> savedValues = new ArrayList<>();

		for (PlannedCrossNewRequest cross : body) {

			CrossEntity entity = new CrossEntity();
			updateEntity(entity, cross);

			CrossEntity savedEntity = crossRepository.save(entity);

			savedValues.add(convertToPlanned(savedEntity));
		}

		return savedValues;
	}

	public List<Cross> updateCrosses(@Valid Map<String, CrossNewRequest> body) throws BrAPIServerException {
		List<Cross> savedValues = new ArrayList<>();

		for (Entry<String, CrossNewRequest> crossEntry : body.entrySet()) {
			Optional<CrossEntity> entityOpt = crossRepository.findById(crossEntry.getKey());
			if (entityOpt.isPresent()) {
				CrossEntity entity = entityOpt.get();
				updateEntity(entity, crossEntry.getValue());
				savedValues.add(convertToCross(crossRepository.save(entity)));
			} else {
				throw new BrAPIServerException(HttpStatus.NOT_FOUND, "The cross \"" + crossEntry.getKey()
						+ "\" is not available in this database. \nPlease choose a different crossDbId or contact the server administrator to resolve this issue.");
			}
		}

		return savedValues;
	}

	public List<PlannedCross> updatePlannedCrosses(@Valid Map<String, PlannedCrossNewRequest> body)
			throws BrAPIServerException {
		List<PlannedCross> savedValues = new ArrayList<>();

		for (Entry<String, PlannedCrossNewRequest> crossEntry : body.entrySet()) {
			Optional<CrossEntity> entityOpt = crossRepository.findById(crossEntry.getKey());
			if (entityOpt.isPresent()) {
				CrossEntity entity = entityOpt.get();
				updateEntity(entity, crossEntry.getValue());
				savedValues.add(convertToPlanned(crossRepository.save(entity)));
			} else {
				throw new BrAPIServerException(HttpStatus.NOT_FOUND, "The planned cross \"" + crossEntry.getKey()
						+ "\" is not available in this database. \nPlease choose a different plannedCrossDbId or contact the server administrator to resolve this issue.");
			}
		}

		return savedValues;
	}

	private Cross convertToCross(CrossEntity entity) {
		Cross cross = new Cross();
		if (entity != null) {
			UpdateUtility.convertFromEntity(entity, cross);
			convertFromEntity(entity, cross);
			cross.setCrossAttributes(convertFromEntity(entity.getCrossAttributes()));
			cross.setCrossDbId(entity.getId());
			cross.setCrossName(entity.getName());
			if (entity.getPollinationEvents() != null && !entity.getPollinationEvents().isEmpty()) {
				cross.setPollinationTimeStamp(
						DateUtility.toOffsetDateTime(entity.getPollinationEvents().get(0).getPollinationTimeStamp()));
			}
			if (entity.getPlannedCross() != null) {
				cross.setPlannedCrossDbId(entity.getPlannedCross().getId());
				cross.setPlannedCrossName(entity.getPlannedCross().getName());
			}
			if (entity.getPollinationEvents() != null) {
				cross.setPollinationEvents(entity.getPollinationEvents().stream().map(eventEntity -> {
					CrossPollinationEvents event = new CrossPollinationEvents();
					event.setPollinationNumber(eventEntity.getPollinationNumber());
					event.setPollinationSuccessful(eventEntity.getPollinationSuccessful());
					event.setPollinationTimeStamp(DateUtility.toOffsetDateTime(eventEntity.getPollinationTimeStamp()));
					return event;
				}).collect(Collectors.toList()));
			}
		}
		return cross;
	}

	private PlannedCross convertToPlanned(CrossEntity entity) {
		PlannedCross planned = new PlannedCross();
		if (entity != null) {
			UpdateUtility.convertFromEntity(entity, planned);
			convertFromEntity(entity, planned);
			planned.setPlannedCrossDbId(entity.getId());
			planned.setPlannedCrossName(entity.getName());
			planned.setStatus(entity.getStatus());
		}
		return planned;
	}

	private void convertFromEntity(CrossEntity entity, CrossInterface cross) {
		if (entity.getCrossingProject() != null) {
			cross.setCrossingProjectDbId(entity.getCrossingProject().getId());
			cross.setCrossingProjectName(entity.getCrossingProject().getName());
		}
		cross.setCrossType(entity.getCrossType());

		crossParentService.convertParentsFromEntity(entity, cross);
	}

	private void updateEntity(CrossEntity entity, CrossNewRequest cross) throws BrAPIServerException {
		UpdateUtility.updateEntity(cross, entity);
		updateBaseEntity(entity, cross);
		if (cross.getCrossAttributes() != null)
			entity.setCrossAttributes(convertToEntity(cross.getCrossAttributes()));
		if (cross.getCrossName() != null)
			entity.setName(cross.getCrossName());
		if (cross.getPlannedCrossDbId() != null) {
			List<CrossEntity> plannedEntity = findCrossEntities(null, null, cross.getPlannedCrossDbId(), null, null, null, null, null, null, null, true, null).getContent();
			entity.setPlannedCross(plannedEntity.get(0));
		}
		if (cross.getPollinationEvents() != null) {
			entity.setPollinationEvents(cross.getPollinationEvents().stream().map(event -> {
				CrossPollinationEventEntity eventEntity = new CrossPollinationEventEntity();
				eventEntity.setPollinationNumber(event.getPollinationNumber());
				eventEntity.setPollinationSuccessful(event.isPollinationSuccessful());
				eventEntity.setPollinationTimeStamp(DateUtility.toDate(event.getPollinationTimeStamp()));
				return eventEntity;
			}).collect(Collectors.toList()));
		}

		entity.setPlanned(false);

	}

	private void updateEntity(CrossEntity entity, PlannedCrossNewRequest cross) throws BrAPIServerException {
		UpdateUtility.updateEntity(cross, entity);
		updateBaseEntity(entity, cross);
		if (cross.getPlannedCrossName() != null)
			entity.setName(cross.getPlannedCrossName());
		if (cross.getStatus() != null)
			entity.setStatus(cross.getStatus());

		entity.setPlanned(true);
	}

	private void updateBaseEntity(CrossEntity entity, CrossInterface cross) throws BrAPIServerException {
		if (cross.getCrossingProjectDbId() != null) {
			CrossingProjectEntity project = crossingProjectService
					.getCrossingProjectEntity(cross.getCrossingProjectDbId());
			entity.setCrossingProject(project);
		}
		if (cross.getCrossType() != null)
			entity.setCrossType(cross.getCrossType());

		crossParentService.addParentsToEntity(cross, entity);
	}

	private List<CrossNewRequestCrossAttributes> convertFromEntity(List<String> entities) {
		List<CrossNewRequestCrossAttributes> attributes = new ArrayList<>();
		if (entities != null) {
			for (String entity : entities) {
				CrossNewRequestCrossAttributes attrib = new CrossNewRequestCrossAttributes();
				String[] attribStr = entity.split(":");
				attrib.setCrossAttributeName(attribStr[0].trim());
				attrib.setCrossAttributeValue(attribStr[1].trim());
				attributes.add(attrib);
			}
		}
		return attributes;
	}

	private List<String> convertToEntity(@Valid List<CrossNewRequestCrossAttributes> attributes) {
		List<String> entities = new ArrayList<>();

		if (attributes != null) {
			for (CrossNewRequestCrossAttributes attrib : attributes) {
				entities.add(attrib.getCrossAttributeName() + ":" + attrib.getCrossAttributeValue());
			}
		}

		return entities;
	}
}
