package org.brapi.test.BrAPITestServer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.MethodEntity;
import org.brapi.test.BrAPITestServer.model.entity.OntologyEntity;
import org.brapi.test.BrAPITestServer.model.entity.OntologyInterface;
import org.brapi.test.BrAPITestServer.model.entity.OntologyReferenceEntity;
import org.brapi.test.BrAPITestServer.model.entity.OntologyReferenceEntity.OntologyReferenceTypeEnum;
import org.brapi.test.BrAPITestServer.model.entity.ScaleEntity;
import org.brapi.test.BrAPITestServer.model.entity.ScaleValidValueCategoryEntity;
import org.brapi.test.BrAPITestServer.model.entity.TraitAbbreviationEntity;
import org.brapi.test.BrAPITestServer.model.entity.TraitEntity;
import org.brapi.test.BrAPITestServer.model.entity.TraitSynonymEntity;
import org.brapi.test.BrAPITestServer.repository.MethodRepository;
import org.brapi.test.BrAPITestServer.repository.OntologyRepository;
import org.brapi.test.BrAPITestServer.repository.ScaleRepository;
import org.brapi.test.BrAPITestServer.repository.TraitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.Method;
import io.swagger.model.NewMethodRequest;
import io.swagger.model.NewScaleRequest;
import io.swagger.model.NewTraitRequest;
import io.swagger.model.Ontology;
import io.swagger.model.OntologyReference;
import io.swagger.model.OntologyReferenceDocumentationLinks;
import io.swagger.model.OntologyReferenceDocumentationLinks.TypeEnum;
import io.swagger.model.Scale;
import io.swagger.model.Trait;
import io.swagger.model.TraitDataType;
import io.swagger.model.TraitSummary;
import io.swagger.model.ValidValues;

@Service
public class OntologyService {
	private OntologyRepository ontologyRepository;
	private TraitRepository traitRepository;
	private ScaleRepository scaleRepository;
	private MethodRepository methodRepository;

	@Autowired
	public OntologyService(OntologyRepository ontologyRepository, TraitRepository traitRepository,
			ScaleRepository scaleRepository, MethodRepository methodRepository) {
		this.ontologyRepository = ontologyRepository;
		this.traitRepository = traitRepository;
		this.scaleRepository = scaleRepository;
		this.methodRepository = methodRepository;
	}

	public Method convertFromEntity(MethodEntity entity) {
		Method method = new Method();
		method.setDescription(entity.getDescription());
		method.setFormula(entity.getFormula());
		method.setPropertyClass(entity.getMethodClass());
		method.setMethodDbId(entity.getId());
		method.setMethodName(entity.getName());
		method.setName(entity.getName());
		method.setReference(entity.getReference());
		method.setOntologyReference(convertFromEntity(entity.getOntology(), entity.getOntologyReference()));
		return method;
	}

	public Ontology convertFromEntity(OntologyEntity entity) {
		Ontology ontology = new Ontology();
		ontology.setAuthors(entity.getAuthors());
		ontology.setCopyright(entity.getCopyright());
		ontology.setDescription(entity.getDescription());
		ontology.setLicence(entity.getLicence());
		ontology.setOntologyDbId(entity.getId());
		ontology.setOntologyName(entity.getOntologyName());
		ontology.setVersion(entity.getVersion());
		ontology.setDocumentationURL(entity.getDocumentationURL());
		return ontology;
	}

	public OntologyReference convertFromEntity(OntologyEntity ontology, List<OntologyReferenceEntity> ontologyReference) {
		OntologyReference oRef = null;
		if (ontology != null && ontologyReference != null && !ontologyReference.isEmpty()) {
			oRef = new OntologyReference();
			oRef.setOntologyDbId(ontology.getId());
			oRef.setOntologyName(ontology.getOntologyName());
			oRef.setVersion(ontology.getVersion());
			oRef.setDocumentationLinks(ontologyReference.stream().map((entity -> {
				OntologyReferenceDocumentationLinks link = new OntologyReferenceDocumentationLinks();
				link.setType(TypeEnum.fromValue(entity.getType().toString()));
				link.setURL(entity.getURL());
				return link;
			})).collect(Collectors.toList()));
		}
		return oRef;
	}

	public Scale convertFromEntity(ScaleEntity entity) {
		Scale scale = new Scale();
		scale.setDataType(TraitDataType.fromValue(entity.getDataType()));
		scale.setDecimalPlaces(entity.getDecimalPlaces());
		scale.setScaleName(entity.getName());
		scale.setName(entity.getName());
		scale.setScaleDbId(entity.getId());
		scale.setXref(entity.getXref());
		scale.setOntologyReference(convertFromEntity(entity.getOntology(), entity.getOntologyReference()));

		ValidValues validValues = new ValidValues();
		validValues.setMax(entity.getValidValueMax());
		validValues.setMin(entity.getValidValueMin());
		validValues.setCategories(
				entity.getValidValueCategories().stream().map(e -> e.getCategory()).collect(Collectors.toList()));
		scale.setValidValues(validValues);
		return scale;
	}

	public Trait convertFromEntity(TraitEntity entity) {
		Trait trait = new Trait();
		trait.setAlternativeAbbreviations(entity.getAlternativeAbbreviations().stream().map(e -> e.getAbbreviation())
				.collect(Collectors.toList()));
		trait.setAttribute(entity.getAttribute());
		trait.setDescription(entity.getDescription());
		trait.setEntity(entity.getEntity());
		trait.setMainAbbreviation(entity.getMainAbbreviation());
		trait.setTraitName(entity.getName());
		trait.setName(entity.getName());
		trait.setStatus(entity.getStatus());
		trait.setSynonyms(entity.getSynonyms().stream().map(e -> e.getSynonym()).collect(Collectors.toList()));
		trait.setPropertyClass(entity.getTraitClass());
		trait.setTraitDbId(entity.getId());
		trait.setXref(entity.getXref());
		trait.setOntologyReference(convertFromEntity(entity.getOntology(), entity.getOntologyReference()));

		return trait;
	}

	public TraitSummary convertFromEntitySummary(TraitEntity entity) {
		TraitSummary summary = new TraitSummary();
		summary.setDefaultValue(entity.getDefaultValue());
		summary.setDescription(entity.getDescription());
		summary.setTraitName(entity.getName());
		summary.setName(entity.getName());
		summary.setTraitDbId(entity.getId());
		summary.setTraitId(entity.getId());

		if (entity.getVariables() != null) {
			summary.setObservationVariables(
					entity.getVariables().stream().map(e -> e.getId()).collect(Collectors.toList()));
		}

		return summary;
	}

	public Method getMethod(String methodDbId) throws BrAPIServerException {

		Optional<MethodEntity> entityOpt = methodRepository.findById(methodDbId);
		if (!entityOpt.isPresent()) {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "MethodDbId not found");
		}

		return convertFromEntity(entityOpt.get());
	}

	public List<Method> getMethods(Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<Method> methodsPage = methodRepository.findAll(pageReq).map(this::convertFromEntity);
		PagingUtility.calculateMetaData(metaData, methodsPage);
		return methodsPage.getContent();
	}

	public List<Ontology> getOntologies(Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<Ontology> ontologiesPage = ontologyRepository.findAll(pageReq).map(this::convertFromEntity);
		PagingUtility.calculateMetaData(metaData, ontologiesPage);
		return ontologiesPage.getContent();
	}

	public Scale getScale(String scaleDbId) throws BrAPIServerException {
		Optional<ScaleEntity> entityOpt = scaleRepository.findById(scaleDbId);
		if (!entityOpt.isPresent()) {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "scaleDbId not found");
		}

		return convertFromEntity(entityOpt.get());
	}

	public List<Scale> getScales(Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<Scale> scalesPage = scaleRepository.findAll(pageReq).map(this::convertFromEntity);
		PagingUtility.calculateMetaData(metaData, scalesPage);
		return scalesPage.getContent();
	}

	public TraitSummary getTrait(String traitDbId) throws BrAPIServerException {
		TraitSummary trait;
		Optional<TraitEntity> entityOpt = traitRepository.findById(traitDbId);
		if (entityOpt.isPresent()) {
			trait = convertFromEntitySummary(entityOpt.get());
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "TraitDbId not found!");
		}

		return trait;
	}

	public List<TraitSummary> getTraits(Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<TraitSummary> traits = traitRepository.findAll(pageReq).map(this::convertFromEntitySummary);
		PagingUtility.calculateMetaData(metaData, traits);
		return traits.getContent();
	}

	public Method saveNewMethod(@Valid NewMethodRequest body) {
		MethodEntity entity = updateEntity(new MethodEntity(), body);
		MethodEntity savedEntity = methodRepository.save(entity);
		savedEntity = methodRepository.save(savedEntity);
		return convertFromEntity(savedEntity);
	}

	private MethodEntity updateEntity(MethodEntity entity, @Valid NewMethodRequest method) {
		entity.setDescription(method.getDescription());
		entity.setFormula(method.getFormula());
		entity.setMethodClass(method.getPropertyClass());
		entity.setName(method.getMethodName());
		entity.setReference(method.getReference());
		updateOntologyReference(entity, method.getOntologyReference());

		return entity;
	}

	private void updateOntologyReference(OntologyInterface entity, OntologyReference ontologyReference) {
		if (entity != null && ontologyReference != null) {
			Optional<OntologyEntity> ontologyOpt = ontologyRepository.findById(ontologyReference.getOntologyDbId());
			if (ontologyOpt.isPresent()) {
				// if (ontologyOpt.isPresent() && entity.getId() != null &&
				// !entity.getId().isEmpty()) {
				entity.setOntology(ontologyOpt.get());
				entity.setOntologyReference(ontologyReference.getDocumentationLinks().stream().map((link) -> {
					OntologyReferenceEntity e = new OntologyReferenceEntity();
					e.setType(OntologyReferenceTypeEnum.fromValue(link.getType().toString()));
					e.setURL(link.getURL());
					return e;
				}).collect(Collectors.toList()));
			}
		}
	}

	public Scale saveNewScale(@Valid NewScaleRequest body) {
		ScaleEntity entity = updateEntity(new ScaleEntity(), body);
		ScaleEntity savedEntity = scaleRepository.save(entity);
		return convertFromEntity(savedEntity);
	}

	private ScaleEntity updateEntity(ScaleEntity entity, @Valid NewScaleRequest scale) {
		entity.setDataType(scale.getDataType().toString());
		entity.setDecimalPlaces(scale.getDecimalPlaces());
		entity.setName(scale.getScaleName());
		entity.setXref(scale.getXref());
		entity.setValidValueMax(scale.getValidValues().getMax());
		entity.setValidValueMin(scale.getValidValues().getMin());
		entity.setValidValueCategories(scale.getValidValues().getCategories().stream().map((categoryString) -> {
			ScaleValidValueCategoryEntity e = new ScaleValidValueCategoryEntity();
			e.setCategory(categoryString);
			e.setScale(entity);
			return e;
		}).collect(Collectors.toList()));

		updateOntologyReference(entity, scale.getOntologyReference());

		return entity;
	}

	public Trait saveNewTrait(@Valid NewTraitRequest body) {
		TraitEntity entity = updateEntity(new TraitEntity(), body);
		TraitEntity savedEntity = traitRepository.save(entity);
		return convertFromEntity(savedEntity);
	}

	private TraitEntity updateEntity(TraitEntity entity, @Valid NewTraitRequest trait) {
		entity.setAlternativeAbbreviations(trait.getAlternativeAbbreviations().stream().map((aa) -> {
			TraitAbbreviationEntity e = new TraitAbbreviationEntity();
			e.setAbbreviation(aa);
			e.setTrait(entity);
			return e;
		}).collect(Collectors.toList()));
		entity.setAttribute(trait.getAttribute());
		entity.setDescription(trait.getDescription());
		entity.setEntity(trait.getEntity());
		entity.setMainAbbreviation(trait.getMainAbbreviation());
		entity.setName(trait.getTraitName());
		entity.setStatus(trait.getStatus());
		entity.setSynonyms(trait.getSynonyms().stream().map(syn -> {
			TraitSynonymEntity e = new TraitSynonymEntity();
			e.setSynonym(syn);
			e.setTrait(entity);
			return e;
		}).collect(Collectors.toList()));
		entity.setTraitClass(trait.getPropertyClass());
		entity.setXref(trait.getXref());
		updateOntologyReference(entity, trait.getOntologyReference());
		return entity;
	}

	public Method updateMethod(String methodDbId, @Valid NewMethodRequest body) throws BrAPIServerException {
		Method method;
		Optional<MethodEntity> entityOpt = methodRepository.findById(methodDbId);
		if (entityOpt.isPresent()) {
			MethodEntity entity = updateEntity(entityOpt.get(), body);
			MethodEntity savedEntity = methodRepository.save(entity);
			method = convertFromEntity(savedEntity);
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "MethodDbId not found");
		}
		return method;
	}

	public Scale updateScale(String scaleDbId, @Valid NewScaleRequest body) throws BrAPIServerException {
		Scale scale;
		Optional<ScaleEntity> entityOpt = scaleRepository.findById(scaleDbId);
		if (entityOpt.isPresent()) {
			ScaleEntity entity = updateEntity(entityOpt.get(), body);
			ScaleEntity savedEntity = scaleRepository.save(entity);
			scale = convertFromEntity(savedEntity);
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "scaleDbId not found");
		}
		return scale;
	}

	public Trait updateTrait(String traitDbId, @Valid NewTraitRequest body) throws BrAPIServerException {
		Trait trait;
		Optional<TraitEntity> entityOpt = traitRepository.findById(traitDbId);
		if (entityOpt.isPresent()) {
			TraitEntity entity = updateEntity(entityOpt.get(), body);
			TraitEntity savedEntity = traitRepository.save(entity);
			trait = convertFromEntity(savedEntity);
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "traitDbId not found");
		}
		return trait;
	}
}
