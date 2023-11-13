package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.*;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.ExternalReferenceEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.CropEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.*;
import org.brapi.test.BrAPITestServer.repository.core.TraitRepository;
import org.brapi.test.BrAPITestServer.repository.pheno.MethodRepository;
import org.brapi.test.BrAPITestServer.repository.pheno.ObservationVariableRepository;
import org.brapi.test.BrAPITestServer.repository.pheno.ScaleRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.brapi.test.BrAPITestServer.service.core.CropService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	private static final Logger log = LoggerFactory.getLogger(ObservationVariableService.class);
	private final ObservationVariableRepository observationVariableRepository;
	private final MethodRepository methodRepository;
	private final ScaleRepository scaleRepository;
	private final TraitRepository traitRepository;
	private final CropService cropService;
	private final OntologyService ontologyService;
	private final MethodService methodService;
	private final ScaleService scaleService;
	private final TraitService traitService;

	@Autowired
	public ObservationVariableService(ObservationVariableRepository observationVariableRepository,
									  OntologyService ontologyService, CropService cropService, MethodService methodService,
									  ScaleService scaleService, TraitService traitService, MethodRepository methodRepository, ScaleRepository scaleRepository, TraitRepository traitRepository) {
		this.observationVariableRepository = observationVariableRepository;
		this.methodRepository = methodRepository;
		this.scaleRepository = scaleRepository;
		this.traitRepository = traitRepository;
		this.ontologyService = ontologyService;
		this.cropService = cropService;
		this.methodService = methodService;
		this.scaleService = scaleService;
		this.traitService = traitService;
	}

	public List<ObservationVariable> findObservationVariables(String observationVariableDbId,
			String observationVariableName, String observationVariablePUI, String methodDbId, String methodName,
			String methodPUI, String scaleDbId, String scaleName, String scalePUI, String traitDbId, String traitName,
			String traitPUI, String traitClass, String ontologyDbId, String commonCropName, String programDbId,
			String trialDbId, String studyDbId, String externalReferenceId, String externalReferenceID,
			String externalReferenceSource, Metadata metadata) {

		ObservationVariableSearchRequest request = new ObservationVariableSearchRequest();

		if (observationVariableDbId != null)
			request.addObservationVariableDbIdsItem(observationVariableDbId);
		if (observationVariableName != null)
			request.addObservationVariableNamesItem(observationVariableName);
		if (methodDbId != null)
			request.addMethodDbIdsItem(methodDbId);
		if (methodName != null)
			request.addMethodNamesItem(methodName);
		if (methodPUI != null)
			request.addMethodPUIsItem(methodPUI);
		if (scaleDbId != null)
			request.addScaleDbIdsItem(scaleDbId);
		if (scaleName != null)
			request.addScaleNamesItem(scaleName);
		if (scalePUI != null)
			request.addScalePUIsItem(scalePUI);
		if (traitDbId != null)
			request.addTraitDbIdsItem(traitDbId);
		if (traitName != null)
			request.addTraitNamesItem(traitName);
		if (traitPUI != null)
			request.addTraitPUIsItem(traitPUI);
		if (traitClass != null)
			request.addTraitClassesItem(traitClass);
		if (ontologyDbId != null)
			request.addOntologyDbIdsItem(ontologyDbId);
		if (commonCropName != null)
			request.addCommonCropNamesItem(commonCropName);
		if (programDbId != null)
			request.addProgramDbIdsItem(programDbId);
		if (trialDbId != null)
			request.addTrialDbIdsItem(trialDbId);
		if (studyDbId != null)
			request.addStudyDbIdsItem(studyDbId);

		request.addExternalReferenceItem(externalReferenceId, externalReferenceID, externalReferenceSource);

		return findObservationVariables(request, metadata);
	}

	public List<ObservationVariable> findObservationVariables(ObservationVariableSearchRequest request,
			Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<ObservationVariableEntity> searchQuery = new SearchQueryBuilder<ObservationVariableEntity>(
				ObservationVariableEntity.class);
		searchQuery.leftJoinFetch("contextOfUse", "contextOfUse")
				   .leftJoinFetch("crop", "varCrop")
				   .leftJoinFetch("method", "varMethod")
				   .leftJoinFetch("ontology", "varOntology")
				   .leftJoinFetch("scale", "varScale")
				   .leftJoinFetch("trait", "varTrait");
		if (request.getStudyDbId() != null) {
			searchQuery = searchQuery.join("observations", "observation").appendList(request.getStudyDbId(),
					"*observation.observationUnit.study.id");
		}
		searchQuery.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getMethodDbIds(), "method.id")
				.appendList(request.getObservationVariableDbIds(), "id")
				.appendList(request.getObservationVariableNames(), "name")
				.appendList(request.getOntologyDbIds(), "ontology.id").appendList(request.getScaleDbIds(), "scale.id")
				.appendList(request.getTraitClasses(), "trait.traitClass")
				.appendList(request.getTraitDbIds(), "trait.id")
				.appendEnumList(request.getDataTypes(), "scale.dataType");

		log.debug("Starting variable search");
		Page<ObservationVariableEntity> page = observationVariableRepository.findAllBySearch(searchQuery, pageReq);
		log.debug("Variable search complete");
		if(!page.isEmpty()) {
			observationVariableRepository.fetchXrefs(page, ObservationVariableEntity.class);
			fetchSynonyms(page);
			fetchMethodXrefs(page);
			fetchScaleXrefs(page);
			fetchScaleValidValueCategories(page);
			fetchTraitXrefs(page);
		}

		log.debug("converting "+page.getSize()+" entities");
		List<ObservationVariable> observationVariables = page.map(this::convertFromEntity).getContent();
		log.debug("done converting entities");
		PagingUtility.calculateMetaData(metadata, page);
		return observationVariables;
	}

	public void fetchSynonyms(Page<ObservationVariableEntity> page) {
		SearchQueryBuilder<ObservationVariableEntity> searchQuery = new SearchQueryBuilder<>(ObservationVariableEntity.class);
		searchQuery.leftJoinFetch("synonyms", "synonyms")
				   .appendList(page.stream().map(BrAPIBaseEntity::getId).collect(Collectors.toList()), "id");

		Page<ObservationVariableEntity> synonyms = observationVariableRepository.findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, List<String>> synonymsByVar = new HashMap<>();
		synonyms.forEach(entity -> synonymsByVar.put(entity.getId(), entity.getSynonyms()));

		page.forEach(entity -> entity.setSynonyms(synonymsByVar.get(entity.getMethod().getId())));
	}

	public void fetchMethodXrefs(Page<ObservationVariableEntity> page) {
		SearchQueryBuilder<MethodEntity> searchQuery = new SearchQueryBuilder<>(MethodEntity.class);
		searchQuery.leftJoinFetch("externalReferences", "externalReferences")
				   .join("variables", "variables")
				   .appendList(page.stream().map(BrAPIBaseEntity::getId).collect(Collectors.toList()), "*variables.id");

		Page<MethodEntity> xrefs = methodRepository.findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, List<ExternalReferenceEntity>> xrefByEntity = new HashMap<>();
		xrefs.forEach(entity -> xrefByEntity.put(entity.getId(), entity.getExternalReferences()));

		page.forEach(entity -> entity.getMethod().setExternalReferences(xrefByEntity.get(entity.getMethod().getId())));
	}

	public void fetchScaleXrefs(Page<ObservationVariableEntity> page) {
		SearchQueryBuilder<ScaleEntity> searchQuery = new SearchQueryBuilder<>(ScaleEntity.class);
		searchQuery.leftJoinFetch("externalReferences", "externalReferences")
				   .join("variables", "variables")
				   .appendList(page.stream().map(BrAPIBaseEntity::getId).collect(Collectors.toList()), "*variables.id");

		Page<ScaleEntity> xrefs = scaleRepository.findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, List<ExternalReferenceEntity>> xrefByEntity = new HashMap<>();
		xrefs.forEach(entity -> xrefByEntity.put(entity.getId(), entity.getExternalReferences()));

		page.forEach(entity -> entity.getScale().setExternalReferences(xrefByEntity.get(entity.getMethod().getId())));
	}

	public void fetchScaleValidValueCategories(Page<ObservationVariableEntity> page) {
		SearchQueryBuilder<ScaleEntity> searchQuery = new SearchQueryBuilder<>(ScaleEntity.class);
		searchQuery.leftJoinFetch("validValueCategories", "validValueCategories")
				   .join("variables", "variables")
				   .appendList(page.stream().map(BrAPIBaseEntity::getId).collect(Collectors.toList()), "*variables.id");

		Page<ScaleEntity> validValueCategories = scaleRepository.findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, List<ScaleValidValueCategoryEntity>> infoByEntity = new HashMap<>();
		validValueCategories.forEach(entity -> infoByEntity.put(entity.getId(), entity.getValidValueCategories()));

		page.forEach(entity -> entity.getScale().setValidValueCategories(infoByEntity.get(entity.getId())));
	}

	public void fetchTraitXrefs(Page<ObservationVariableEntity> page) {
		SearchQueryBuilder<TraitEntity> searchQuery = new SearchQueryBuilder<>(TraitEntity.class);
		searchQuery.leftJoinFetch("externalReferences", "externalReferences")
				   .join("variables", "variables")
				   .appendList(page.stream().map(BrAPIBaseEntity::getId).collect(Collectors.toList()), "*variables.id");

		Page<TraitEntity> xrefs = traitRepository.findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, List<ExternalReferenceEntity>> xrefByEntity = new HashMap<>();
		xrefs.forEach(entity -> xrefByEntity.put(entity.getId(), entity.getExternalReferences()));

		page.forEach(entity -> entity.getTrait().setExternalReferences(xrefByEntity.get(entity.getMethod().getId())));
	}

	public List<ObservationVariable> saveObservationVariables(@Valid List<ObservationVariableNewRequest> body)
			throws BrAPIServerException {
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
			ObservationVariableNewRequest body) throws BrAPIServerException {
		ObservationVariableEntity entity = getObservationVariableEntity(observationVariableDbId, HttpStatus.NOT_FOUND);
		updateEntity(entity, body);
		ObservationVariableEntity savedEntity = observationVariableRepository.save(entity);

		return convertFromEntity(savedEntity);
	}

	public ObservationVariable getObservationVariable(String observationVariableDbId) throws BrAPIServerException {
		return convertFromEntity(getObservationVariableEntity(observationVariableDbId, HttpStatus.NOT_FOUND));
	}

	public ObservationVariableEntity getObservationVariableEntity(String observationVariableDbId)
			throws BrAPIServerException {
		return getObservationVariableEntity(observationVariableDbId, HttpStatus.NOT_FOUND);
	}

	public ObservationVariableEntity getObservationVariableEntity(String observationVariableDbId,
			HttpStatus errorStatus) throws BrAPIServerException {
		ObservationVariableEntity observationVariable = null;
		Optional<ObservationVariableEntity> entityOpt = observationVariableRepository.findById(observationVariableDbId);
		if (entityOpt.isPresent()) {
			observationVariable = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("observationVariable", observationVariableDbId, errorStatus);
		}
		return observationVariable;
	}

	private ObservationVariable convertFromEntity(ObservationVariableEntity entity) {
		log.trace("converting variable: " + entity.getId());
		ObservationVariable var = new ObservationVariable();
		convertFromBaseEntity(entity, var);
		var.setObservationVariableName(entity.getName());
		var.setObservationVariableDbId(entity.getId());

		return var;
	}

	public void convertFromBaseEntity(VariableBaseEntity entity, VariableBaseClass var) {

		UpdateUtility.convertFromEntity(entity, var);

		if (entity.getCrop() != null)
			var.setCommonCropName(entity.getCrop().getCropName());
		var.setContextOfUse(entity.getContextOfUse());
		var.setDefaultValue(entity.getDefaultValue());
		var.setDocumentationURL(entity.getDocumentationURL());
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

	private void updateEntity(ObservationVariableEntity entity, ObservationVariableNewRequest request)
			throws BrAPIServerException {
		updateBaseEntity(entity, request);
		entity.setName(UpdateUtility.replaceField(request.getObservationVariableName(), entity.getName()));
	}

	public void updateBaseEntity(VariableBaseEntity entity, VariableBaseClass request) throws BrAPIServerException {

		UpdateUtility.updateEntity(request, entity);

		entity.setContextOfUse(UpdateUtility.replaceField(request.getContextOfUse(), entity.getContextOfUse()));
		entity.setDefaultValue(UpdateUtility.replaceField(request.getDefaultValue(), entity.getDefaultValue()));
		entity.setDocumentationURL(
				UpdateUtility.replaceField(request.getDocumentationURL(), entity.getDocumentationURL()));
		entity.setGrowthStage(UpdateUtility.replaceField(request.getGrowthStage(), entity.getGrowthStage()));
		entity.setInstitution(UpdateUtility.replaceField(request.getInstitution(), entity.getInstitution()));
		entity.setLanguage(UpdateUtility.replaceField(request.getLanguage(), entity.getLanguage()));
		entity.setScientist(UpdateUtility.replaceField(request.getScientist(), entity.getScientist()));
		entity.setStatus(UpdateUtility.replaceField(request.getStatus(), entity.getStatus()));
		entity.setSynonyms(UpdateUtility.replaceField(request.getSynonyms(), entity.getSynonyms()));

		Date submissionTimeStamp = entity.getSubmissionTimestamp();
		if (request.getSubmissionTimestamp() != null) {
			if (request.getSubmissionTimestamp().isPresent()) {
				submissionTimeStamp = DateUtility.toDate(request.getSubmissionTimestamp().get());
			} else {
				submissionTimeStamp = null;
			}
		}
		entity.setSubmissionTimestamp(submissionTimeStamp);

		ontologyService.updateOntologyReference(entity, request.getOntologyReference());

		String commonCropName = entity.getCrop() == null ? UpdateUtility.replaceField(request.getCommonCropName(), null)
				: UpdateUtility.replaceField(request.getCommonCropName(), entity.getCrop().getCropName());
		CropEntity crop = cropService.getCropEntity(commonCropName);
		entity.setCrop(crop);

		if (request.getMethod() != null) {
			if (request.getMethod().isPresent()) {
				Method requestMethod = request.getMethod().get();
				MethodEntity methodEntity;
				if (requestMethod.getMethodDbId() == null) {
					methodEntity = new MethodEntity();
				} else {
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
				if (requestScale.getScaleDbId() == null) {
					scaleEntity = new ScaleEntity();
				} else {
					scaleEntity = scaleService.getScaleEntity(requestScale.getScaleDbId());
				}
				scaleService.updateEntity(scaleEntity, requestScale);
				scaleEntity = scaleService.saveScaleEntity(scaleEntity);
				entity.setScale(scaleEntity);
			} else {
				entity.setScale(null);
			}
		}

		if (request.getTrait() != null) {
			if (request.getTrait().isPresent()) {
				Trait requestTrait = request.getTrait().get();
				TraitEntity traitEntity;
				if (requestTrait.getTraitDbId() == null) {
					traitEntity = new TraitEntity();
				} else {
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
