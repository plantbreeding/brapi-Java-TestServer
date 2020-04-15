package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.pheno.TraitEntity;
import org.brapi.test.BrAPITestServer.repository.core.TraitRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
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

			savedEntity = traitRepository.save(entity);
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found: " + traitDbId);
		}

		return convertFromEntity(savedEntity);
	}

	public List<Trait> saveTraits(@Valid List<TraitBaseClass> body) throws BrAPIServerException {
		List<Trait> savedTraits = new ArrayList<>();
		for (TraitBaseClass request : body) {
			TraitEntity newEntity = new TraitEntity();
			updateEntity(newEntity, request);
			TraitEntity saved = traitRepository.save(newEntity);
			savedTraits.add(convertFromEntity(saved));
		}

		return savedTraits;
	}

	public TraitEntity getTraitEntity(String traitDbId) throws BrAPIServerException {
		TraitEntity trait = null;
		if (traitDbId != null) {
			Optional<TraitEntity> entityOpt = traitRepository.findById(traitDbId);
			if (entityOpt.isPresent()) {
				trait = entityOpt.get();
			} else {
				throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found " + traitDbId);
			}
		}
		return trait;
	}

	public Trait getTrait(String traitDbId) throws BrAPIServerException {
		return convertFromEntity(getTraitEntity(traitDbId));
	}

	public TraitEntity updateEntity(TraitEntity entity, @Valid TraitBaseClass trait) throws BrAPIServerException {
		if (trait.getAdditionalInfo() != null)
			entity.setAdditionalInfo(trait.getAdditionalInfo());
		if (trait.getAlternativeAbbreviations() != null)
			entity.setAlternativeAbbreviations(trait.getAlternativeAbbreviations());
		if (trait.getAttribute() != null)
			entity.setAttribute(trait.getAttribute());
		if (trait.getEntity() != null)
			entity.setEntity(trait.getEntity());
		if (trait.getExternalReferences() != null)
			entity.setExternalReferences(trait.getExternalReferences());
		if (trait.getMainAbbreviation() != null)
			entity.setMainAbbreviation(trait.getMainAbbreviation());
		if (trait.getOntologyReference() != null)
			ontologyService.updateOntologyReference(entity, trait.getOntologyReference());
		if (trait.getStatus() != null)
			entity.setStatus(trait.getStatus());
		if (trait.getSynonyms() != null)
			entity.setSynonyms(trait.getSynonyms());
		if (trait.getTraitClass() != null)
			entity.setTraitClass(trait.getTraitClass());		
		if (trait.getTraitDescription() != null)
			entity.setTraitDescription(trait.getTraitDescription());
		if (trait.getTraitName() != null)
			entity.setTraitName(trait.getTraitName());
		
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
