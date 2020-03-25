package org.brapi.test.BrAPITestServer.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.ObservationVariableEntity;
import org.brapi.test.BrAPITestServer.model.entity.VariableBaseEntity;
import org.brapi.test.BrAPITestServer.repository.ObservationVariableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.common.Metadata;
import io.swagger.model.pheno.Method;
import io.swagger.model.pheno.ObservationVariable;
import io.swagger.model.pheno.ObservationVariableSearchRequest;
import io.swagger.model.pheno.Scale;
import io.swagger.model.pheno.Trait;
import io.swagger.model.pheno.VariableBaseClass;

@Service
public class ObservationVariableService {
	private ObservationVariableRepository observationVariableRepository;
	private SearchService searchService;
	private OntologyService ontologyService;

	@Autowired
	public ObservationVariableService(ObservationVariableRepository observationVariableRepository,
			OntologyService ontologyService, SearchService searchService) {
		this.observationVariableRepository = observationVariableRepository;
		this.ontologyService = ontologyService;
		this.searchService = searchService;
	}

	public List<String> getDataTypes(Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		Page<String> dataTypesPage = observationVariableRepository.findDistinctScale_DatatypeAll(pageReq);

		PagingUtility.calculateMetaData(metaData, dataTypesPage);
		return dataTypesPage.getContent();
	}

	public List<ObservationVariable> getVariables(String traitClass, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		Page<ObservationVariableEntity> variablesPage;
		if (traitClass == null) {
			variablesPage = observationVariableRepository.findAll(pageReq);
		} else {
			variablesPage = observationVariableRepository.findAllByTrait_TraitClass(traitClass, pageReq);
		}
		List<ObservationVariable> variables = variablesPage.map(this::convertFromEntity).getContent();

		PagingUtility.calculateMetaData(metaData, variablesPage);

		return variables;
	}

	public ObservationVariable getVariable(String observationVariableDbId) {
		Optional<ObservationVariableEntity> entityOption = observationVariableRepository
				.findById(observationVariableDbId);
		ObservationVariable var = null;
		if (entityOption.isPresent()) {
			var = convertFromEntity(entityOption.get());
		}
		return var;
	}

	public List<ObservationVariable> getVariables(ObservationVariableSearchRequest request, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		ObservationVariableSearchRequest req = convertSearchRequest(request);
		Page<ObservationVariableEntity> variablesPage = observationVariableRepository.findBySearch(req, pageReq);

		PagingUtility.calculateMetaData(metaData, variablesPage);
		return variablesPage.map(this::convertFromEntity).getContent();
	}

	private ObservationVariableSearchRequest convertSearchRequest(ObservationVariableSearchRequest request) {
		ObservationVariableSearchRequest req = new ObservationVariableSearchRequest();
		req.setDataTypes(request.getDataTypes());
		req.setMethodDbIds(request.getMethodDbIds());
		req.setObservationVariableDbIds(request.getObservationVariableDbIds());
//		req.setObservationVariableXrefs(request.getObservationVariableXrefs());
		req.setOntologyDbIds(request.getOntologyDbIds());
		req.setScaleDbIds(request.getScaleDbIds());
		req.setTraitClasses(request.getTraitClasses());
		return req;
	}

	private ObservationVariable convertFromEntity(ObservationVariableEntity entity) {
		ObservationVariable var = new ObservationVariable();
		convertFromBaseEntity(entity, var);
//		var.setDate(DateUtility.toDateString(new Date()));
//		var.setName(entity.getName());
		var.setObservationVariableName(entity.getName());
		var.setObservationVariableDbId(entity.getId());

		return var;
	}

	public void convertFromBaseEntity(VariableBaseEntity entity, VariableBaseClass var) {
		var.setContextOfUse(entity.getContextOfUse().stream().map(e -> e.getContext()).collect(Collectors.toList()));
//		var.setCrop(entity.getCrop());
		var.setDefaultValue(entity.getDefaultValue());
		var.setDocumentationURL(entity.getDocumentationURL());
		var.setGrowthStage(entity.getGrowthStage());
		var.setInstitution(entity.getGrowthStage());
		var.setLanguage(entity.getLanguage());
//		var.setOntologyDbId(entity.getOntology().getId());
//		var.setOntologyName(entity.getOntology().getOntologyName());
		var.setScientist(entity.getScientist());
		var.setStatus(entity.getStatus());
		var.setSubmissionTimestamp(DateUtility.toOffsetDateTime(entity.getSubmissionTimestamp()));
		var.setSynonyms(entity.getSynonyms().stream().map(e -> e.getSynonym()).collect(Collectors.toList()));
//		var.setXref(entity.getXref());

//		OntologyReference oRef = ontologyService.convertFromEntity(entity.getOntology(), entity.getOntologyReference());
//		if (oRef != null) {
//			oRef.setDocumentationLinks(Arrays.asList(new OntologyReferenceDocumentationLinks()
//					.URL(entity.getOntology().getXref()).type(TypeEnum.WEBPAGE)));
//			var.setOntologyReference(oRef);
//		}

		Method method = ontologyService.convertFromEntity(entity.getMethod());
		var.setMethod(method);

		Scale scale = ontologyService.convertFromEntity(entity.getScale());
		var.setScale(scale);

		Trait trait = ontologyService.convertFromEntity(entity.getTrait());
		var.setTrait(trait);
	}

	public List<ObservationVariable> getVariablesForStudy(String studyDbId, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		Page<ObservationVariableEntity> page = observationVariableRepository.findAllForStudy(studyDbId, pageReq);
		PagingUtility.calculateMetaData(metadata, page);
		return page.map(this::convertFromEntity).getContent();
	}

	public ObservationVariableEntity getVariableEntity(String observationVariableDbId) {
		return observationVariableRepository.findById(observationVariableDbId).orElse(null);
	}

	public List<ObservationVariable> search(ObservationVariableSearchRequest request, Metadata metadata) throws BrAPIServerException {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		Page<ObservationVariableEntity> page = observationVariableRepository.findBySearch(request, pageReq);
		List<ObservationVariable> programs = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return programs;
	}

}
