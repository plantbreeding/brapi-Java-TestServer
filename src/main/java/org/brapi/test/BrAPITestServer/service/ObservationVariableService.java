package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.ObservationVariableEntity;
import org.brapi.test.BrAPITestServer.model.entity.VariableBaseEntity;
import org.brapi.test.BrAPITestServer.repository.ObservationVariableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.Method;
import io.swagger.model.ObservationVariable;
import io.swagger.model.ObservationVariableSearchRequestDep;
import io.swagger.model.OntologyRefernce;
import io.swagger.model.OntologyRefernceDocumentationLinks;
import io.swagger.model.OntologyRefernceDocumentationLinks.TypeEnum;
import io.swagger.model.Scale;
import io.swagger.model.Trait;
import io.swagger.model.VariableBaseClass;

@Service
public class ObservationVariableService {
	private ObservationVariableRepository observationVariableRepository;
	private OntologyService ontologyService;

	@Autowired
	public ObservationVariableService(ObservationVariableRepository observationVariableRepository, OntologyService ontologyService) {
		this.observationVariableRepository = observationVariableRepository;
		this.ontologyService = ontologyService;
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

	public List<ObservationVariable> getVariables(ObservationVariableSearchRequestDep request, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		request = fixReqestArrays(request);
		List<String> traitDataTypes = stringifyDataTypes(request);
		

		Page<ObservationVariableEntity> variablesPage = observationVariableRepository
				.findAllBySearch(traitDataTypes, request.getMethodDbIds(), request.getNames(),
						request.getObservationVariableDbIds(), request.getOntologyDbIds(), request.getOntologyXrefs(),
						request.getScaleDbIds(), request.getTraitClasses(), pageReq);

		PagingUtility.calculateMetaData(metaData, variablesPage);
		return variablesPage.map(this::convertFromEntity).getContent();
	}

	private List<String> stringifyDataTypes(ObservationVariableSearchRequestDep request) {
		List<String> dataTypes = new ArrayList<>();
		if (request.getDatatypes() == null || request.getDatatypes().isEmpty()) {
			dataTypes.add("");
		} else {
			dataTypes = request.getDatatypes()
					.stream()
					.map((dt) -> {return dt.toString();})
					.collect(Collectors.toList());
		}
		return dataTypes;
	}

	private ObservationVariableSearchRequestDep fixReqestArrays(ObservationVariableSearchRequestDep request) {
		List<String> emptyPlaceHolder = new ArrayList<>();
		emptyPlaceHolder.add("");
		if (request.getMethodDbIds() == null || request.getMethodDbIds().isEmpty()) {
			request.setMethodDbIds(emptyPlaceHolder);
		}
		if (request.getNames() == null || request.getNames().isEmpty()) {
			request.setNames(emptyPlaceHolder);
		}
		if (request.getObservationVariableDbIds() == null || request.getObservationVariableDbIds().isEmpty()) {
			request.setObservationVariableDbIds(emptyPlaceHolder);
		}
		if (request.getOntologyDbIds() == null || request.getOntologyDbIds().isEmpty()) {
			request.setOntologyDbIds(emptyPlaceHolder);
		}
		if (request.getOntologyXrefs() == null || request.getOntologyXrefs().isEmpty()) {
			request.setOntologyXrefs(emptyPlaceHolder);
		}
		if (request.getScaleDbIds() == null || request.getScaleDbIds().isEmpty()) {
			request.setScaleDbIds(emptyPlaceHolder);
		}
		if (request.getTraitClasses() == null || request.getTraitClasses().isEmpty()) {
			request.setTraitClasses(emptyPlaceHolder);
		}
		return request;
	}


	private ObservationVariable convertFromEntity(ObservationVariableEntity entity) {
		ObservationVariable var = new ObservationVariable(); 
		convertFromBaseEntity(entity, var);
		var.setDate(DateUtility.toDateString(new Date()));
		var.setName(entity.getName());
		var.setObservationVariableName(entity.getName());
		var.setObservationVariableDbId(entity.getId());
		
		return var;
	}

	public void convertFromBaseEntity(VariableBaseEntity entity, VariableBaseClass var) {
		var.setContextOfUse(entity.getContextOfUse().stream().map(e -> e.getContext()).collect(Collectors.toList()));
		var.setCrop(entity.getCrop());
		var.setDefaultValue(entity.getDefaultValue());
		var.setDocumentationURL(entity.getDocumentationURL());
		var.setGrowthStage(entity.getGrowthStage());
		var.setInstitution(entity.getGrowthStage());
		var.setLanguage(entity.getLanguage());
		var.setOntologyDbId(entity.getOntology().getId());
		var.setOntologyName(entity.getOntology().getOntologyName());
		var.setScientist(entity.getScientist());
		var.setStatus(entity.getStatus());
		var.setSubmissionTimestamp(DateUtility.toOffsetDateTime(entity.getSubmissionTimestamp()));
		var.setSynonyms(entity.getSynonyms().stream().map(e -> e.getSynonym()).collect(Collectors.toList()));
		var.setXref(entity.getXref());
		
		OntologyRefernce oRef = ontologyService.convertFromEntity(entity.getOntology(), entity.getOntologyRefernce());
		if (oRef != null) {
			oRef.setDocumentationLinks(
					Arrays.asList(
							new OntologyRefernceDocumentationLinks()
							.URL(entity.getOntology().getXref())
							.type(TypeEnum.WEBPAGE)));
			var.setOntologyRefernce(oRef);
		}

		Method method = ontologyService.convertFromEntity(entity.getMethod());
		var.setMethod(method);

		Scale scale = ontologyService.convertFromEntity(entity.getScale());
		var.setScale(scale);

		Trait trait = ontologyService.convertFromEntity(entity.getTrait());
		var.setTrait(trait);
	}

	public List<ObservationVariable> getVariablesForStudy(String studyDbId) {
		return observationVariableRepository.findAllForStudy(studyDbId).stream().map(this::convertFromEntity)
				.collect(Collectors.toList());
	}

	public ObservationVariableEntity getVariableEntity(String observationVariableDbId) {
		return observationVariableRepository.findById(observationVariableDbId).orElse(null);
	}

}
