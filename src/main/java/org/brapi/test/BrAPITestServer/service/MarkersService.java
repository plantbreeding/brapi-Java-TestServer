package org.brapi.test.BrAPITestServer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.MarkerEntity;
import org.brapi.test.BrAPITestServer.model.rest.Marker;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.MarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MarkersService {

	MarkerRepository markerRepository;

	@Autowired
	public MarkersService(MarkerRepository markerRepository) {
		this.markerRepository = markerRepository;
	}

	public List<Marker> getMarkers(String name, String type, List<String> markerDbIds, String matchMethod,
			 boolean includeSynonyms, MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		boolean ignoreCase = !matchMethod.equalsIgnoreCase("exact");
		String namePattern = generateNamePattern(name, matchMethod);

		Page<MarkerEntity> entities = runAppropriateQuery(namePattern, type, markerDbIds, ignoreCase, includeSynonyms,
				pageReq);

		List<Marker> markers = entities.map((entity) -> {
			return convertFromEntity(entity, includeSynonyms);
		}).getContent();

		PagingUtility.calculateMetaData(metaData, entities);
		return markers;
	}

	private Page<MarkerEntity> runAppropriateQuery(String namePattern, String type, List<String> markerDbIds,
			boolean ignoreCase, boolean includeSynonyms, Pageable pageReq) {
		Page<MarkerEntity> entities = null;
		if (markerDbIds == null || markerDbIds.isEmpty()) {
			entities = markerRepository.findAllByIdIn(markerDbIds, pageReq);
			//TODO: missing rare case when both name and ID list are used to search
		} else {
			if (namePattern != null && type != null) {
				if (ignoreCase) {
					entities = markerRepository
							.findAllByMarkerNameLikeIgnoreCaseOrSynonyms_SynonymLikeIgnoreCaseAndType(namePattern,
									namePattern, type, pageReq);
				} else {
					entities = markerRepository.findAllByMarkerNameOrSynonyms_SynonymAndType(namePattern, namePattern,
							type, pageReq);
				}
			} else if (namePattern != null) {
				if (ignoreCase) {
					entities = markerRepository.findAllByMarkerNameLikeIgnoreCaseOrSynonyms_SynonymLikeIgnoreCase(
							namePattern, namePattern, pageReq);
				} else {
					entities = markerRepository.findAllByMarkerNameOrSynonyms_Synonym(namePattern, namePattern,
							pageReq);
				}
			} else if (type != null) {
				entities = markerRepository.findAllByType(type, pageReq);
			} else {
				entities = markerRepository.findAll(pageReq);
			}
		}
		return entities;
	}

	private String generateNamePattern(String name, String matchMethod) {
		String namePattern;
		if (name == null) {
			namePattern = null;
		} else {
			namePattern = name;
			switch (matchMethod) {
			case "wildcard":
				namePattern = namePattern.replaceAll("[\\*\\%]", "%");
				namePattern = namePattern.replaceAll("\\?", "_");
				break;
			case "exact":
			case "case_insensitive":
			default:
				break;
			}
		}
		return namePattern;
	}

	public Marker getMarker(String markerDbId) {
		Optional<MarkerEntity> markerEntity = markerRepository.findById(markerDbId);
		Marker marker = null;
		if (markerEntity.isPresent()) {
			marker = convertFromEntity(markerEntity.get(), true);
		}
		return marker;
	}

	private Marker convertFromEntity(MarkerEntity markerEntity, boolean includeSynonyms) {
		Marker marker = new Marker();
		marker.setDefaultDisplayName(markerEntity.getMarkerName());
		marker.setMarkerDbId(markerEntity.getId());
		marker.setType(markerEntity.getType());
		marker.setAnalysisMethods(markerEntity.getAnalysisMethods().stream().map(entity -> entity.getMethodName())
				.collect(Collectors.toList()));
		marker.setRefAlt(
				markerEntity.getRefAlt().stream().map(entity -> entity.getReference()).collect(Collectors.toList()));

		if (includeSynonyms) {
			marker.setSynonyms(markerEntity.getSynonyms().stream().map(entity -> entity.getSynonym())
					.collect(Collectors.toList()));
		}

		return marker;
	}

}
