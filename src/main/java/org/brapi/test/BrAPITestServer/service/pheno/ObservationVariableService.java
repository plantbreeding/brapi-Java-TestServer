package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.CropEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.MethodEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationVariableEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ScaleEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.TraitEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.VariableBaseEntity;
import org.brapi.test.BrAPITestServer.repository.pheno.ObservationVariableRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.brapi.test.BrAPITestServer.service.core.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.pheno.Method;
import io.swagger.model.pheno.ObservationVariable;
import io.swagger.model.pheno.ObservationVariableNewRequest;
import io.swagger.model.pheno.ObservationVariableSearchRequest;
import io.swagger.model.pheno.Scale;
import io.swagger.model.pheno.Trait;
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
			throw new BrAPIServerDbIdNotFoundException("observationVariable", observationVariableDbId);
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
			throw new BrAPIServerDbIdNotFoundException("observationVariable", observationVariableDbId);
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
		entity.setName(UpdateUtility.replaceField(request.getObservationVariableName(), entity.getName()));
	}
	
	public void updateBaseEntity(VariableBaseEntity entity, @Valid VariableBaseClass request)
			throws BrAPIServerException {

		entity.setAdditionalInfo(UpdateUtility.replaceField(request.getAdditionalInfo(), entity.getAdditionalInfoMap()));
		entity.setContextOfUse(UpdateUtility.replaceField(request.getContextOfUse(), entity.getContextOfUse()));
		entity.setDefaultValue(UpdateUtility.replaceField(request.getDefaultValue(), entity.getDefaultValue()));
		entity.setDocumentationURL(UpdateUtility.replaceField(request.getDocumentationURL(), entity.getDocumentationURL()));
		entity.setExternalReferences(UpdateUtility.replaceField(request.getExternalReferences(), entity.getExternalReferencesMap()));
		entity.setGrowthStage(UpdateUtility.replaceField(request.getGrowthStage(), entity.getGrowthStage()));
		entity.setInstitution(UpdateUtility.replaceField(request.getInstitution(), entity.getInstitution()));
		entity.setLanguage(UpdateUtility.replaceField(request.getLanguage(), entity.getLanguage()));
		entity.setScientist(UpdateUtility.replaceField(request.getScientist(), entity.getScientist()));
		entity.setStatus(UpdateUtility.replaceField(request.getStatus(), entity.getStatus()));
		entity.setSynonyms(UpdateUtility.replaceField(request.getSynonyms(), entity.getSynonyms()));
		
		Date submissionTimeStamp = entity.getSubmissionTimestamp();
		if(request.getSubmissionTimestamp() != null) {
			if(request.getSubmissionTimestamp().isPresent()) {
				submissionTimeStamp = DateUtility.toDate(request.getSubmissionTimestamp().get());
			}else {
				submissionTimeStamp = null;
			}
		}
		entity.setSubmissionTimestamp(submissionTimeStamp);

		ontologyService.updateOntologyReference(entity, request.getOntologyReference());
		
		String commonCropName = entity.getCrop() == null 
				? UpdateUtility.replaceField(request.getCommonCropName(), null)
				: UpdateUtility.replaceField(request.getCommonCropName(), entity.getCrop().getCropName());
		CropEntity crop = cropService.getCropEntity(commonCropName);
		entity.setCrop(crop);
			
		if (request.getMethod() != null) {
			if (request.getMethod().isPresent()) {
				Method requestMethod = request.getMethod().get();
				MethodEntity methodEntity;
				if(requestMethod.getMethodDbId() == null) {
					methodEntity = new MethodEntity();
				}else {
					methodEntity = methodService.getMethodEntity(requestMethod.getMethodDbId());
				}
				methodService.updateEntity(methodEntity, requestMethod);
				methodEntity = methodService.saveMethodEntity(methodEntity);
				entity.setMethod(methodEntity);
			} else {
				entity.setMethod(null);
			}
		}
		
		if (request.getScale() != null) {
			if (request.getScale().isPresent()) {
				Scale requestScale = request.getScale().get();
				ScaleEntity scaleEntity;
				if(requestScale.getScaleDbId() == null) {
					scaleEntity = new ScaleEntity();
				}else {
					scaleEntity = scaleService.getScaleEntity(requestScale.getScaleDbId());
				}
				scaleService.updateEntity(scaleEntity, requestScale);
				scaleEntity = scaleService.saveScaleEntity(scaleEntity);
				entity.setScale(scaleEntity);
			} else {
				entity.setScale(null);
			}
		}
		
		if (request.getTrait() != null){
			if (request.getTrait().isPresent()) {
				Trait requestTrait = request.getTrait().get();
				TraitEntity traitEntity;
				if(requestTrait.getTraitDbId() == null) {
					traitEntity = new TraitEntity();
				}else {
					traitEntity = traitService.getTraitEntity(requestTrait.getTraitDbId());
				}
				traitService.updateEntity(traitEntity, requestTrait);
				traitEntity = traitService.saveTraitEntity(traitEntity);
				entity.setTrait(traitEntity);
			} else {
				entity.setTrait(null);
			}
		}
	}
}
