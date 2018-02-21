package org.brapi.test.BrAPITestServer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.TraitEntity;
import org.brapi.test.BrAPITestServer.model.rest.TraitSummary;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.TraitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TraitService {
	private TraitRepository traitRepository;

	@Autowired
	public TraitService(TraitRepository traitRepository) {
		this.traitRepository = traitRepository;
	}

	public List<TraitSummary> getTraits(MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<TraitSummary> traits = traitRepository.findAll(pageReq).map(this::convertFromEntity);
		PagingUtility.calculateMetaData(metaData, traits);
		return traits.getContent();
	}

	public TraitSummary getTrait(String traitDbId) {
		TraitEntity entity = traitRepository.findById(traitDbId).orElse(new TraitEntity());

		return convertFromEntity(entity);
	}

	private TraitSummary convertFromEntity(TraitEntity entity) {
		TraitSummary summary = new TraitSummary();
		summary.setDefaultValue(entity.getDefaultValue());
		summary.setDescription(entity.getDescription());
		summary.setName(entity.getName());
		summary.setTraitDbId(entity.getId());
		// TODO not sure if this is as intended
		summary.setTraitId(entity.getXref());
		
		if (entity.getObservationVariables() != null) {
			summary.setObservationVariables(
					entity.getObservationVariables().stream().map(e -> e.getId()).collect(Collectors.toList()));
		}
		
		return summary;
	}
}
