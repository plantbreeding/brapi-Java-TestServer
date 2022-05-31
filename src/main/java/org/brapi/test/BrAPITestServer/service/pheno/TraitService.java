package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.pheno.TraitEntity;
import org.brapi.test.BrAPITestServer.repository.core.TraitRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.pheno.Trait;
import io.swagger.model.pheno.TraitBaseClass;

@Service
public class TraitService {
	private final TraitRepository traitRepository;
	private final OntologyService ontologyService;

	@Autowired
	public TraitService(TraitRepository traitRepository, OntologyService ontologyService) {
		this.traitRepository = traitRepository;
		this.ontologyService = ontologyService;
	}

	public List<Trait> findTraits(@Valid String traitDbId, @Valid String observationVariableDbId,
			@Valid String externalReferenceID, @Valid String externalReferenceSource, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<TraitEntity> searchQuery = new SearchQueryBuilder<TraitEntity>(TraitEntity.class);
		if (observationVariableDbId != null) {
			searchQuery = searchQuery.join("variables", "variable").appendSingle(observationVariableDbId,
					"*variable.id");
		}
		searchQuery = searchQuery.appendSingle(traitDbId, "id").withExRefs(externalReferenceID,
				externalReferenceSource);
		Page<TraitEntity> traitPage = traitRepository.findAllBySearch(searchQuery, pageReq);
		PagingUtility.calculateMetaData(metadata, traitPage);

		List<Trait> traits = traitPage.map(this::convertFromEntity).getContent();
		return traits;
	}

	public Trait updateTrait(String traitDbId, @Valid TraitBaseClass body) throws BrAPIServerException {
		TraitEntity savedEntity;
		Optional<TraitEntity> entityOpt = traitRepository.findById(traitDbId);
		if (entityOpt.isPresent()) {
			TraitEntity entity = entityOpt.get();
			updateEntity(entity, body);

			savedEntity = saveTraitEntity(entity);
		} else {
			throw new BrAPIServerDbIdNotFoundException("trait", traitDbId);
		}

		return convertFromEntity(savedEntity);
	}

	public List<Trait> saveTraits(@Valid List<TraitBaseClass> body) throws BrAPIServerException {
		List<Trait> savedTraits = new ArrayList<>();
		for (TraitBaseClass request : body) {
			TraitEntity newEntity = new TraitEntity();
			updateEntity(newEntity, request);
			TraitEntity saved = saveTraitEntity(newEntity);
			savedTraits.add(convertFromEntity(saved));
		}

		return savedTraits;
	}

	public TraitEntity saveTraitEntity(TraitEntity traitEntity) {
		return traitRepository.save(traitEntity);
	}

	public Trait getTrait(String traitDbId) throws BrAPIServerException {
		return convertFromEntity(getTraitEntity(traitDbId, HttpStatus.NOT_FOUND));
	}

	public TraitEntity getTraitEntity(String traitDbId) throws BrAPIServerException {
		return getTraitEntity(traitDbId, HttpStatus.BAD_REQUEST);
	}

	public TraitEntity getTraitEntity(String traitDbId, HttpStatus errorStatus) throws BrAPIServerException {
		TraitEntity trait = null;
		if (traitDbId != null) {
			Optional<TraitEntity> entityOpt = traitRepository.findById(traitDbId);
			if (entityOpt.isPresent()) {
				trait = entityOpt.get();
			} else {
				throw new BrAPIServerDbIdNotFoundException("trait", traitDbId);
			}
		}
		return trait;
	}

	public TraitEntity updateEntity(TraitEntity entity, @Valid TraitBaseClass trait) throws BrAPIServerException {

		entity.setAdditionalInfo(UpdateUtility.replaceField(trait.getAdditionalInfo(), entity.getAdditionalInfoMap()));
		entity.setAlternativeAbbreviations(UpdateUtility.replaceField(trait.getAlternativeAbbreviations(), entity.getAlternativeAbbreviations()));
		entity.setAttribute(UpdateUtility.replaceField(trait.getAttribute(), entity.getAttribute()));
		entity.setEntity(UpdateUtility.replaceField(trait.getEntity(), entity.getEntity()));
		entity.setExternalReferences(UpdateUtility.replaceField(trait.getExternalReferences(), entity.getExternalReferencesMap()));
		entity.setMainAbbreviation(UpdateUtility.replaceField(trait.getMainAbbreviation(), entity.getMainAbbreviation()));
		ontologyService.updateOntologyReference(entity, trait.getOntologyReference());
		entity.setStatus(UpdateUtility.replaceField(trait.getStatus(), entity.getStatus()));
		entity.setSynonyms(UpdateUtility.replaceField(trait.getSynonyms(), entity.getSynonyms()));
		entity.setTraitClass(UpdateUtility.replaceField(trait.getTraitClass(), entity.getTraitClass()));
		entity.setTraitDescription(UpdateUtility.replaceField(trait.getTraitDescription(), entity.getTraitDescription()));
		entity.setTraitName(UpdateUtility.replaceField(trait.getTraitName(), entity.getTraitName()));
		
		return entity;
	}

	public Trait convertFromEntity(TraitEntity entity) {
		Trait trait = null;
		if (entity != null) {
			trait = new Trait();
			trait.setAdditionalInfo(entity.getAdditionalInfoMap());
			trait.setAlternativeAbbreviations(entity.getAlternativeAbbreviations());
			trait.setAttribute(entity.getAttribute());
			trait.setEntity(entity.getEntity());
			trait.setExternalReferences(entity.getExternalReferencesMap());
			trait.setMainAbbreviation(entity.getMainAbbreviation());
			trait.setOntologyReference(ontologyService.convertFromEntity(entity));
			trait.setStatus(entity.getStatus());
			trait.setSynonyms(entity.getSynonyms());
			trait.setTraitClass(entity.getTraitClass());
			trait.setTraitDbId(entity.getId());
			trait.setTraitDescription(entity.getTraitDescription());
			trait.setTraitName(entity.getTraitName());
		}
		return trait;
	}
}
