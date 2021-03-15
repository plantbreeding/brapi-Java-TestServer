package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.pheno.MethodEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationVariableEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ScaleEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.TraitEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.VariableBaseEntity;
import org.brapi.test.BrAPITestServer.repository.pheno.ObservationVariableRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.core.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.pheno.ObservationVariable;
import io.swagger.model.pheno.ObservationVariableNewRequest;
import io.swagger.model.pheno.ObservationVariableSearchRequest;
import io.swagger.model.pheno.VariableBaseClass;

@Service
public class ObservationVariableService {
	private final ObservationVariableRepository observationVariableRepository;
	private final CropService cropService;
	private final OntologyService ontologyService;
	private final MethodService methodService;
	private final ScaleService scaleService;
	private final TraitService traitService;

	@Autowired
	public ObservationVariableService(ObservationVariableRepository observationVariableRepository,
			OntologyService ontologyService, CropService cropService, MethodService methodService,
			ScaleService scaleService, TraitService traitService) {
		this.observationVariableRepository = observationVariableRepository;
		this.ontologyService = ontologyService;
		this.cropService = cropService;
		this.methodService = methodService;
		this.scaleService = scaleService;
		this.traitService = traitService;
	}

	public List<ObservationVariable> findObservationVariables(@Valid String observationVariableDbId,
			@Valid String traitClass, @Valid String studyDbId, @Valid String externalReferenceID,
			@Valid String externalReferenceSource, Metadata metadata) {
		ObservationVariableSearchRequest request = new ObservationVariableSearchRequest();
		if (traitClass != null)
			request.addTraitClassesItem(traitClass);
		if (studyDbId != null)
			request.addStudyDbIdItem(studyDbId);
		if (observationVariableDbId != null)
			request.addObservationVariableDbIdsItem(observationVariableDbId);
		if (externalReferenceID != null)
			request.addExternalReferenceIDsItem(externalReferenceID);
		if (externalReferenceSource != null)
			request.addExternalReferenceSourcesItem(externalReferenceSource);

		return findObservationVariables(request, metadata);
	}
	
	public List<ObservationVariable> findObservationVariables(ObservationVariableSearchRequest request,	Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<ObservationVariableEntity> searchQuery = new SearchQueryBuilder<ObservationVariableEntity>(ObservationVariableEntity.class);
		if (request.getStudyDbId() != null) {
			searchQuery = searchQuery.join("observations", "observation")
					.appendList(request.getStudyDbId(), "*observation.observationUnit.study.id");
		}
		searchQuery.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getMethodDbIds(), "method.id")
				.appendList(request.getObservationVariableDbIds(), "id")
				.appendList(request.getObservationVariableNames(), "name")
				.appendList(request.getOntologyDbIds(), "ontology.id")
				.appendList(request.getScaleDbIds(), "scale.id")				
				.appendList(request.getTraitClasses(), "trait.traitClass")
				.appendList(request.getTraitDbIds(), "trait.id")
				.appendEnumList(request.getDataTypes(), "scale.dataType");

		Page<ObservationVariableEntity> page = observationVariableRepository.findAllBySearch(searchQuery, pageReq);
		List<ObservationVariable> observationVariables = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return observationVariables;
	}

	public List<ObservationVariable> saveObservationVariables(@Valid List<ObservationVariableNewRequest> body) throws BrAPIServerException {
		List<ObservationVariable> savedObservationVariables = new ArrayList<>();

		for (ObservationVariableNewRequest list : body) {
			ObservationVariableEntity entity = new ObservationVariableEntity();
			updateEntity(entity, list);
			ObservationVariableEntity savedEntity = observationVariableRepository.save(entity);
			savedObservationVariables.add(convertFromEntity(savedEntity));
		}

		return savedObservationVariables;
	}

	public ObservationVariable updateObservationVariable(String observationVariableDbId,
			@Valid ObservationVariableNewRequest body) throws BrAPIServerException {
		ObservationVariableEntity savedEntity;
		Optional<ObservationVariableEntity> entityOpt = observationVariableRepository.findById(observationVariableDbId);
		if (entityOpt.isPresent()) {
			ObservationVariableEntity entity = entityOpt.get();
			updateEntity(entity, body);

			savedEntity = observationVariableRepository.save(entity);
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "observationVariableDbId not found: " + observationVariableDbId);
		}

		return convertFromEntity(savedEntity);
	}

	public ObservationVariable getObservationVariable(String observationVariableDbId) throws BrAPIServerException {
		return convertFromEntity(getObservationVariableEntity(observationVariableDbId, HttpStatus.NOT_FOUND));
	}

	public ObservationVariableEntity getObservationVariableEntity(String observationVariableDbId) throws BrAPIServerException {
		return getObservationVariableEntity(observationVariableDbId, HttpStatus.NOT_FOUND);
	}

	public ObservationVariableEntity getObservationVariableEntity(String observationVariableDbId, HttpStatus errorStatus) throws BrAPIServerException {
		ObservationVariableEntity observationVariable = null;
		Optional<ObservationVariableEntity> entityOpt = observationVariableRepository.findById(observationVariableDbId);
		if (entityOpt.isPresent()) {
			observationVariable = entityOpt.get();
		} else {
			throw new BrAPIServerException(errorStatus, "observationVariableDbId not found: " + observationVariableDbId);
		}
		return observationVariable;
	}

	private ObservationVariable convertFromEntity(ObservationVariableEntity entity) {
		ObservationVariable var = new ObservationVariable();
		convertFromBaseEntity(entity, var);
		var.setObservationVariableName(entity.getName());
		var.setObservationVariableDbId(entity.getId());

		return var;
	}

	public void convertFromBaseEntity(VariableBaseEntity entity, VariableBaseClass var) {
		var.setAdditionalInfo(entity.getAdditionalInfoMap());
		if (entity.getCrop() != null)
			var.setCommonCropName(entity.getCrop().getCropName());
		var.setContextOfUse(entity.getContextOfUse());
		var.setDefaultValue(entity.getDefaultValue());
		var.setDocumentationURL(entity.getDocumentationURL());
		var.setExternalReferences(entity.getExternalReferencesMap());
		var.setGrowthStage(entity.getGrowthStage());
		var.setInstitution(entity.getInstitution());
		var.setLanguage(entity.getLanguage());
		var.setMethod(methodService.convertFromEntity(entity.getMethod()));
		var.setOntologyReference(ontologyService.convertFromEntity(entity));
		var.setScale(scaleService.convertFromEntity(entity.getScale()));
		var.setScientist(entity.getScientist());
		var.setStatus(entity.getStatus());
		var.setSubmissionTimestamp(DateUtility.toOffsetDateTime(entity.getSubmissionTimestamp()));
		var.setSynonyms(entity.getSynonyms());
		var.setTrait(traitService.convertFromEntity(entity.getTrait()));
	}


	private void updateEntity(ObservationVariableEntity entity, ObservationVariableNewRequest request) throws BrAPIServerException {
		updateBaseEntity(entity, request);
		if(request.getObservationVariableName() != null)
			entity.setName(request.getObservationVariableName());
	}
	
	public void updateBaseEntity(VariableBaseEntity entity, @Valid VariableBaseClass request)
			throws BrAPIServerException {

		if (request.getAdditionalInfo() != null)
			entity.setAdditionalInfo(request.getAdditionalInfo());
		if (request.getCommonCropName() != null)
			entity.setCrop(cropService.getCropEntity(request.getCommonCropName()));
		if (request.getContextOfUse() != null)
			entity.setContextOfUse(request.getContextOfUse());
		if (request.getDefaultValue() != null)
			entity.setDefaultValue(request.getDefaultValue());
		if (request.getDocumentationURL() != null)
			entity.setDocumentationURL(request.getDocumentationURL());
		if (request.getExternalReferences() != null)
			entity.setExternalReferences(request.getExternalReferences());
		if (request.getGrowthStage() != null)
			entity.setGrowthStage(request.getGrowthStage());
		if (request.getInstitution() != null)
			entity.setInstitution(request.getInstitution());
		if (request.getLanguage() != null)
			entity.setLanguage(request.getLanguage());
		if (request.getMethod() != null) {
			MethodEntity methodEntity;
			if(request.getMethod().getMethodDbId() == null) {
				methodEntity = new MethodEntity();
				methodService.updateEntity(methodEntity, request.getMethod());
				methodEntity = methodService.saveMethodEntity(methodEntity);
			}else {
				methodEntity = methodService.getMethodEntity(request.getMethod().getMethodDbId());
			}
			entity.setMethod(methodEntity);
		}
		if (request.getOntologyReference() != null)
			ontologyService.updateOntologyReference(entity, request.getOntologyReference());
		if (request.getScale() != null) {
			ScaleEntity scaleEntity;
			if(request.getScale().getScaleDbId() == null) {
				scaleEntity = new ScaleEntity();
				scaleService.updateEntity(scaleEntity, request.getScale());
				scaleEntity = scaleService.saveScaleEntity(scaleEntity);
			}else {
				scaleEntity = scaleService.getScaleEntity(request.getScale().getScaleDbId());
			}
			entity.setScale(scaleEntity);
		}
		if (request.getScientist() != null)
			entity.setScientist(request.getScientist());
		if (request.getStatus() != null)
			entity.setStatus(request.getStatus());
		if (request.getSubmissionTimestamp() != null)
			entity.setSubmissionTimestamp(DateUtility.toDate(request.getSubmissionTimestamp()));
		if (request.getSynonyms() != null)
			entity.setSynonyms(request.getSynonyms());
		if (request.getTrait() != null){
			TraitEntity traitEntity;
			if(request.getTrait().getTraitDbId() == null) {
				traitEntity = new TraitEntity();
				traitService.updateEntity(traitEntity, request.getTrait());
				traitEntity = traitService.saveTraitEntity(traitEntity);
			}else {
				traitEntity = traitService.getTraitEntity(request.getTrait().getTraitDbId());
			}
			entity.setTrait(traitEntity);
		}
	}
}
