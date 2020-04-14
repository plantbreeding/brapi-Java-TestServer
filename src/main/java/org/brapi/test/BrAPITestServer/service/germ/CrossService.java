package org.brapi.test.BrAPITestServer.service.germ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.germ.CrossEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.CrossParentEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.CrossingProjectEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.repository.germ.CrossRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.pheno.ObservationUnitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.germ.Cross;
import io.swagger.model.germ.CrossNewRequest;
import io.swagger.model.germ.CrossNewRequestCrossAttributes;
import io.swagger.model.germ.CrossParent;
import io.swagger.model.germ.PlannedCross;
import io.swagger.model.germ.PlannedCrossNewRequest;

@Service
public class CrossService {

	private final CrossRepository crossRepository;
	private final CrossingProjectService crossingProjectService;
	private final GermplasmService germplasmService;
	private final ObservationUnitService observationUnitService;

	public CrossService(CrossRepository crossRepository, CrossingProjectService crossingProjectService,
			GermplasmService germplasmService, ObservationUnitService observationUnitService) {
		this.crossRepository = crossRepository;
		this.crossingProjectService = crossingProjectService;
		this.germplasmService = germplasmService;
		this.observationUnitService = observationUnitService;
	}

	public List<Cross> findCrosses(@Valid String crossingProjectDbId, @Valid String externalReferenceID,
			@Valid String externalReferenceSource, Metadata metadata) {
		List<Cross> crosses = findCrosses(crossingProjectDbId, externalReferenceID, externalReferenceSource, false,
				metadata).map(this::convertToCross).getContent();
		return crosses;
	}

	public List<PlannedCross> findPlannedCrosses(@Valid String crossingProjectDbId, @Valid String externalReferenceID,
			@Valid String externalReferenceSource, Metadata metadata) {
		List<PlannedCross> crosses = findCrosses(crossingProjectDbId, externalReferenceID, externalReferenceSource,
				true, metadata).map(this::convertToPlanned).getContent();
		return crosses;
	}

	public Page<CrossEntity> findCrosses(@Valid String crossingProjectDbId, @Valid String externalReferenceID,
			@Valid String externalReferenceSource, Boolean plannedCross, Metadata metadata) {

		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<CrossEntity> searchQuery = new SearchQueryBuilder<CrossEntity>(CrossEntity.class);
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
				throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found: " + crossEntry.getKey());
			}
		}

		return savedValues;
	}

	public List<PlannedCross> updatePlannedCrosses(@Valid Map<String, PlannedCrossNewRequest> body) throws BrAPIServerException {
		List<PlannedCross> savedValues = new ArrayList<>();

		for (Entry<String, PlannedCrossNewRequest> crossEntry : body.entrySet()) {
			Optional<CrossEntity> entityOpt = crossRepository.findById(crossEntry.getKey());
			if (entityOpt.isPresent()) {
				CrossEntity entity = entityOpt.get();
				updateEntity(entity, crossEntry.getValue());
				savedValues.add(convertToPlanned(crossRepository.save(entity)));
			} else {
				throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found: " + crossEntry.getKey());
			}
		}

		return savedValues;
	}

	private Cross convertToCross(CrossEntity entity) {
		Cross cross = new Cross();
		if (entity != null) {
			cross.setAdditionalInfo(entity.getAdditionalInfoMap());
			cross.setCrossAttributes(convertFromEntity(entity.getCrossAttributes()));
			cross.setCrossDbId(entity.getId());
			if (entity.getCrossingProject() != null) {
				cross.setCrossingProjectDbId(entity.getCrossingProject().getId());
				cross.setCrossingProjectName(entity.getCrossingProject().getName());
			}
			cross.setCrossName(entity.getName());
			cross.setCrossType(entity.getCrossType());
			cross.setExternalReferences(entity.getExternalReferencesMap());
			if (entity.getParents() != null && entity.getParents().size() >= 1)
				cross.setParent1(convertFromEntity(entity.getParents().get(0)));
			if (entity.getParents() != null && entity.getParents().size() >= 2)
				cross.setParent2(convertFromEntity(entity.getParents().get(1)));
			cross.setPollinationTimeStamp(DateUtility.toOffsetDateTime(entity.getPollinationTimeStamp()));
		}
		return cross;
	}

	private PlannedCross convertToPlanned(CrossEntity entity) {
		PlannedCross cross = new PlannedCross();
		if (entity != null) {
			cross.setAdditionalInfo(entity.getAdditionalInfoMap());
			cross.setPlannedCrossDbId(entity.getId());
			if (entity.getCrossingProject() != null) {
				cross.setCrossingProjectDbId(entity.getCrossingProject().getId());
				cross.setCrossingProjectName(entity.getCrossingProject().getName());
			}
			cross.setPlannedCrossName(entity.getName());
			cross.setCrossType(entity.getCrossType());
			cross.setExternalReferences(entity.getExternalReferencesMap());
			if (entity.getParents() != null && entity.getParents().size() >= 1)
				cross.setParent1(convertFromEntity(entity.getParents().get(0)));
			if (entity.getParents() != null && entity.getParents().size() >= 2)
				cross.setParent2(convertFromEntity(entity.getParents().get(1)));
		}
		return cross;
	}

	private void updateEntity(CrossEntity entity, CrossNewRequest cross) throws BrAPIServerException {
		if (cross.getAdditionalInfo() != null)
			entity.setAdditionalInfo(cross.getAdditionalInfo());
		if (cross.getCrossAttributes() != null)
			entity.setCrossAttributes(convertToEntity(cross.getCrossAttributes()));
		if (cross.getCrossingProjectDbId() != null) {
			CrossingProjectEntity project = crossingProjectService
					.getCrossingProjectEntity(cross.getCrossingProjectDbId());
			entity.setCrossingProject(project);
		}
		if (cross.getCrossName() != null)
			entity.setName(cross.getCrossName());
		if (cross.getCrossType() != null)
			entity.setCrossType(cross.getCrossType());
		if (cross.getExternalReferences() != null)
			entity.setExternalReferences(entity.getExternalReferences());
		if (cross.getParent1() != null)
			entity.addParentItem(convertToEntity(cross.getParent1()));
		if (cross.getParent2() != null)
			entity.addParentItem(convertToEntity(cross.getParent2()));
		if (cross.getPollinationTimeStamp() != null)
			entity.setPollinationTimeStamp(DateUtility.toDate(cross.getPollinationTimeStamp()));
		entity.setPlanned(false);

	}

	private void updateEntity(CrossEntity entity, PlannedCrossNewRequest cross) throws BrAPIServerException {
		if (cross.getAdditionalInfo() != null)
			entity.setAdditionalInfo(cross.getAdditionalInfo());
		if (cross.getCrossingProjectDbId() != null) {
			CrossingProjectEntity project = crossingProjectService
					.getCrossingProjectEntity(cross.getCrossingProjectDbId());
			entity.setCrossingProject(project);
		}
		if (cross.getPlannedCrossName() != null)
			entity.setName(cross.getPlannedCrossName());
		if (cross.getCrossType() != null)
			entity.setCrossType(cross.getCrossType());
		if (cross.getExternalReferences() != null)
			entity.setExternalReferences(entity.getExternalReferences());
		if (cross.getParent1() != null)
			entity.addParentItem(convertToEntity(cross.getParent1()));
		if (cross.getParent2() != null)
			entity.addParentItem(convertToEntity(cross.getParent2()));
		entity.setPlanned(true);
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

	private CrossParent convertFromEntity(CrossParentEntity entity) {
		CrossParent parent = new CrossParent();
		if (entity != null) {
			if (entity.getGermplasm() != null) {
				parent.setGermplasmDbId(entity.getGermplasm().getId());
				parent.setGermplasmName(entity.getGermplasm().getGermplasmName());
			}
			if (entity.getObservationUnit() != null) {
				parent.setObservationUnitDbId(entity.getObservationUnit().getId());
				parent.setObservationUnitName(entity.getObservationUnit().getObservationUnitName());
			}
			parent.setParentType(entity.getParentType());
		}
		return parent;
	}

	private CrossParentEntity convertToEntity(@Valid CrossParent parent) throws BrAPIServerException {
		CrossParentEntity entity = new CrossParentEntity();
		if (parent.getGermplasmDbId() != null) {
			GermplasmEntity germ = germplasmService.getGermplasmEntity(parent.getGermplasmDbId());
			entity.setGermplasm(germ);
		}
		if (parent.getObservationUnitDbId() != null) {
			ObservationUnitEntity obsUnit = observationUnitService
					.getObservationUnitEntity(parent.getObservationUnitDbId());
			entity.setObservationUnit(obsUnit);
		}
		if (parent.getParentType() != null) {
			entity.setParentType(parent.getParentType());
		}
		return entity;
	}
}
