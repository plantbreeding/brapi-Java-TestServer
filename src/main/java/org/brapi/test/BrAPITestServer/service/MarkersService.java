package org.brapi.test.BrAPITestServer.service;

import java.util.List;
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

	public List<Marker> getMarkers(String name, String type, String matchMethod, String synonyms, MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		boolean includeSynonyms = synonyms.equalsIgnoreCase("synonyms");
		boolean ignoreCase = !matchMethod.equalsIgnoreCase("exact");
		String namePattern = generateNamePattern(name, matchMethod);

		Page<MarkerEntity> entities;

		if (namePattern != null && type != null) {
			if (ignoreCase) {
				entities = markerRepository.findAllByMarkerNameLikeIgnoreCaseOrSynonyms_SynonymLikeIgnoreCaseAndType(
						namePattern, namePattern, type, pageReq);
				metaData.getPagination()
						.setTotalCount((int) markerRepository
								.countByMarkerNameLikeIgnoreCaseOrSynonyms_SynonymLikeIgnoreCaseAndType(namePattern,
										namePattern, type));
			} else {
				entities = markerRepository.findAllByMarkerNameOrSynonyms_SynonymAndType(namePattern, namePattern, type,
						pageReq);
				metaData.getPagination().setTotalCount((int) markerRepository
						.countByMarkerNameOrSynonyms_SynonymAndType(namePattern, namePattern, type));
			}
		} else if (namePattern != null) {
			if (ignoreCase) {
				entities = markerRepository.findAllByMarkerNameLikeIgnoreCaseOrSynonyms_SynonymLikeIgnoreCase(
						namePattern, namePattern, pageReq);
				metaData.getPagination().setTotalCount((int) markerRepository
						.countByMarkerNameLikeIgnoreCaseOrSynonyms_SynonymLikeIgnoreCase(namePattern, namePattern));
			} else {
				entities = markerRepository.findAllByMarkerNameOrSynonyms_Synonym(namePattern, namePattern, pageReq);
				metaData.getPagination().setTotalCount(
						(int) markerRepository.countByMarkerNameOrSynonyms_Synonym(namePattern, namePattern));
			}
		} else if (type != null) {
			entities = markerRepository.findAllByType(type, pageReq);
			metaData.getPagination().setTotalCount((int) markerRepository.countByType(type));
		} else {
			entities = markerRepository.findAll(pageReq);
			metaData.getPagination().setTotalCount((int) markerRepository.count());
		}

		List<Marker> markers = entities.map((entity) -> {
			return convertFromEntity(entity, includeSynonyms);
		}).getContent();

		PagingUtility.calculateMetaData(metaData);
		return markers;
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
		MarkerEntity markerEntity = markerRepository.findById(markerDbId).get();
		Marker marker = convertFromEntity(markerEntity, true);
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
