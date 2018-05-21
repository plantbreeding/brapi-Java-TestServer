package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.ObservationVariableEntity;
import org.brapi.test.BrAPITestServer.model.rest.Method;
import org.brapi.test.BrAPITestServer.model.rest.ObservationVariable;
import org.brapi.test.BrAPITestServer.model.rest.ObservationVariableSearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.Ontology;
import org.brapi.test.BrAPITestServer.model.rest.Scale;
import org.brapi.test.BrAPITestServer.model.rest.Trait;
import org.brapi.test.BrAPITestServer.model.rest.ValidValue;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.ObservationVariableRepository;
import org.brapi.test.BrAPITestServer.repository.OntologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ObservationVariableService {
	private ObservationVariableRepository observationVariableRepository;
	private OntologyRepository ontologyRepository;

	@Autowired
	public ObservationVariableService(ObservationVariableRepository observationVariableRepository,
			OntologyRepository ontologyRepository) {
		this.observationVariableRepository = observationVariableRepository;
		this.ontologyRepository = ontologyRepository;
	}

	public List<String> getDataTypes(MetaData metaData) {
		// TODO why is this needed?
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		List<String> dataTypes = observationVariableRepository.findDistinctScale_DatatypeAll(pageReq).getContent();
		metaData.getPagination().setTotalCount((int) observationVariableRepository.countDistinctScale_DatatypeAll());

		PagingUtility.calculateMetaData(metaData);
		return dataTypes;
	}

	public List<ObservationVariable> getVariables(String traitClass, MetaData metaData) {
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

	public List<ObservationVariable> getVariables(ObservationVariableSearchRequest request, MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		request = fixReqestArrays(request);

		List<ObservationVariable> variables = observationVariableRepository
				.findAllBySearch(request.getDatatypes(), request.getMethodDbIds(), request.getNames(),
						request.getObservationVariableDbIds(), request.getOntologyDbIds(), request.getOntologyXrefs(),
						request.getScaleDbIds(), request.getTraitClasses(), pageReq)
				.map(this::convertFromEntity).getContent();
		metaData.getPagination()
				.setTotalCount((int) observationVariableRepository.countBySearch(request.getDatatypes(),
						request.getMethodDbIds(), request.getNames(), request.getObservationVariableDbIds(),
						request.getOntologyDbIds(), request.getOntologyXrefs(), request.getScaleDbIds(),
						request.getTraitClasses()));

		return variables;
	}

	private ObservationVariableSearchRequest fixReqestArrays(ObservationVariableSearchRequest request) {
		List<String> emptyPlaceHolder = new ArrayList<>();
		emptyPlaceHolder.add("");
		if (request.getDatatypes() == null || request.getDatatypes().isEmpty()) {
			request.setDatatypes(emptyPlaceHolder);
		}
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

	public List<Ontology> getOntologies(MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		List<Ontology> ontologies = ontologyRepository.findAll(pageReq).map((entity) -> {
			Ontology ontology = new Ontology();
			ontology.setAuthors(entity.getAuthors());
			ontology.setCopyright(entity.getCopyright());
			ontology.setDescription(entity.getDescription());
			ontology.setLicence(entity.getLicence());
			ontology.setOntologyDbId(entity.getId());
			ontology.setOntologyName(entity.getOntologyName());
			ontology.setVersion(entity.getVersion());
			return ontology;
		}).getContent();
		metaData.getPagination().setTotalCount((int) ontologyRepository.count());
		return ontologies;
	}

	private ObservationVariable convertFromEntity(ObservationVariableEntity entity) {
		ObservationVariable var = new ObservationVariable();
		var.setContextOfUse(entity.getContextOfUse().stream().map(e -> e.getContext()).collect(Collectors.toList()));
		var.setCrop(entity.getCrop());
		var.setDefaultValue(entity.getDefaultValue());
		var.setGrowthStage(entity.getGrowthStage());
		var.setInstitution(entity.getGrowthStage());
		var.setLanguage(entity.getLanguage());
		var.setName(entity.getName());
		var.setObservationVariableDbId(entity.getId());
		var.setOntologyDbId(entity.getOntology().getId());
		var.setOntologyName(entity.getOntology().getOntologyName());
		var.setScientist(entity.getScientist());
		var.setStatus(entity.getStatus());
		var.setSubmissionTimestamp(entity.getSubmissionTimestamp());
		var.setSynonyms(entity.getSynonyms().stream().map(e -> e.getSynonym()).collect(Collectors.toList()));
		var.setXref(entity.getXref());

		Method method = new Method();
		method.setDescription(entity.getMethod().getDescription());
		method.setFormula(entity.getMethod().getFormula());
		method.setMethodClass(entity.getMethod().getMethodClass());
		method.setMethodDbId(entity.getMethod().getId());
		method.setName(entity.getMethod().getName());
		method.setReference(entity.getMethod().getReference());
		var.setMethod(method);

		Scale scale = new Scale();
		scale.setDataType(entity.getScale().getDataType());
		scale.setDecimalPlaces(entity.getScale().getDecimalPlaces());
		scale.setName(entity.getScale().getName());
		scale.setScaleDbId(entity.getScale().getId());
		scale.setXref(entity.getScale().getXref());

		ValidValue validValues = new ValidValue();
		validValues.setMax(entity.getScale().getValidValues().getMax());
		validValues.setMin(entity.getScale().getValidValues().getMin());
		validValues.setCategories(entity.getScale().getValidValues().getCategories().stream().map(e -> e.getCategory())
				.collect(Collectors.toList()));
		scale.setValidValues(validValues);
		var.setScale(scale);

		Trait trait = new Trait();
		trait.setAlternativeAbbreviations(entity.getTrait().getAlternativeAbbreviations().stream()
				.map(e -> e.getAbbreviation()).collect(Collectors.toList()));
		trait.setAttribute(entity.getTrait().getAttribute());
		trait.setDescription(entity.getTrait().getDescription());
		trait.setEntity(entity.getTrait().getEntity());
		trait.setMainAbbreviation(entity.getTrait().getMainAbbreviation());
		trait.setName(entity.getTrait().getName());
		trait.setStatus(entity.getTrait().getStatus());
		trait.setSynonyms(
				entity.getTrait().getSynonyms().stream().map(e -> e.getSynonym()).collect(Collectors.toList()));
		trait.setTraitClass(entity.getTrait().getTraitClass());
		trait.setTraitDbId(entity.getTrait().getId());
		trait.setXref(entity.getTrait().getXref());
		var.setTrait(trait);

		return var;
	}

	public List<ObservationVariable> getVariablesForStudy(String studyDbId) {
		return observationVariableRepository.findAllForStudy(studyDbId).stream().map(this::convertFromEntity)
				.collect(Collectors.toList());
	}

	public ObservationVariableEntity getVariableEntity(String observationVariableDbId) {
		return observationVariableRepository.findById(observationVariableDbId).get();
	}

}
