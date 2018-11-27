package org.brapi.test.BrAPITestServer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.MarkerEntity;
import org.brapi.test.BrAPITestServer.repository.MarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Marker;
import io.swagger.model.MarkersSearchRequest;
import io.swagger.model.MarkersSearchRequest.MatchMethodEnum;
import io.swagger.model.Metadata;

@Service
public class MarkersService {

	MarkerRepository markerRepository;
	SearchService searchService;

	@Autowired
	public MarkersService(MarkerRepository markerRepository, SearchService searchService) {
		this.markerRepository = markerRepository;
		this.searchService = searchService;
		
	}

	public List<Marker> getMarkers(String name, String type, List<String> markerDbIds, MatchMethodEnum matchMethod,
			 Boolean includeSynonyms, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		MarkersSearchRequest request = new MarkersSearchRequest();
		if(name != null)
			request.addMarkerNamesItem(name);
		if(type != null)
			request.addTypesItem(type);
		request.setIncludeSynonyms(includeSynonyms);
		request.setMarkerDbIds(markerDbIds);
		request.setMatchMethod(matchMethod);

		Page<MarkerEntity> entities = markerRepository.findBySearch(request, pageReq);

		List<Marker> markers = entities.map(m -> convertFromEntity(m, includeSynonyms)).getContent();

		PagingUtility.calculateMetaData(metaData, entities);
		return markers;
	}

	public Marker getMarker(String markerDbId) {
		Optional<MarkerEntity> markerEntity = markerRepository.findById(markerDbId);
		Marker marker = null;
		if (markerEntity.isPresent()) {
			marker = convertFromEntity(markerEntity.get(), true);
		}
		return marker;
	}

	private Marker convertFromEntity(MarkerEntity markerEntity, Boolean includeSynonyms) {
		Marker marker = new Marker();
		marker.setDefaultDisplayName(markerEntity.getMarkerName());
		marker.setMarkerName(markerEntity.getMarkerName());
		marker.setMarkerDbId(markerEntity.getId());
		marker.setType(markerEntity.getType());
		marker.setAnalysisMethods(markerEntity.getAnalysisMethods().stream().map(entity -> entity.getMethodName())
				.collect(Collectors.toList()));
		marker.setRefAlt(
				markerEntity.getRefAlt().stream().map(entity -> entity.getReference()).collect(Collectors.toList()));

		if (includeSynonyms == null || includeSynonyms) {
			marker.setSynonyms(markerEntity.getSynonyms().stream().map(entity -> entity.getSynonym())
					.collect(Collectors.toList()));
		}

		return marker;
	}

	public List<Marker> searchBySearchRequestDbId(String searchResultsDbId, Metadata metadata) throws BrAPIServerException {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		MarkersSearchRequest request = searchService.findById(searchResultsDbId).getParameters(MarkersSearchRequest.class);
		Page<MarkerEntity> page = markerRepository.findBySearch(request, pageReq);
		PagingUtility.calculateMetaData(metadata, page);
		List<Marker> markers = page.map(m -> convertFromEntity(m, request.isIncludeSynonyms())).getContent();
		return markers;
	}

}
