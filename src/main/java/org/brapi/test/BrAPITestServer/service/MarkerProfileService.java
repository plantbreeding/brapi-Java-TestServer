package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.brapi.test.BrAPITestServer.model.entity.AlleleEntity;
import org.brapi.test.BrAPITestServer.model.entity.MarkerProfileEntity;
import org.brapi.test.BrAPITestServer.model.rest.AlleleFormatParams;
import org.brapi.test.BrAPITestServer.model.rest.AlleleMatrixSearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.MarkerProfileDetails;
import org.brapi.test.BrAPITestServer.model.rest.MarkerProfileSummary;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.AlleleRepository;
import org.brapi.test.BrAPITestServer.repository.MarkerProfileRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MarkerProfileService {

	private MarkerProfileRepository markerProfileRepository;
	private AlleleRepository alleleRepository;

	public MarkerProfileService(MarkerProfileRepository markerProfileRepository, AlleleRepository alleleRepository) {
		this.markerProfileRepository = markerProfileRepository;
		this.alleleRepository = alleleRepository;
	}

	public List<MarkerProfileSummary> getMarkerProfileSummeries(String germplasmDbId, String studyDbId,
			String sampleDbId, String extractDbId, String analysisMethod, MetaData metaData) {

		Page<MarkerProfileEntity> profilePage = markerProfileRepository.findBySearchOptions(germplasmDbId, studyDbId,
				sampleDbId, extractDbId, analysisMethod, PagingUtility.getPageRequest(metaData));
		
		List<MarkerProfileSummary> summaries = profilePage.map((entity) -> {
					MarkerProfileSummary summary = new MarkerProfileSummary();
					summary.setAnalysisMethod(entity.getAnalysisMethod());
					summary.setExtractDbId(entity.getExtractDbId());
					summary.setGermplasmDbId(entity.getGermplasmDbId());
					summary.setMarkerprofileDbId(entity.getId());
					summary.setResultCount(entity.getResultCount());
					summary.setSampleDbId(entity.getSampleDbId());
					summary.setUniqueDisplayName(entity.getUniqueDisplayName());
					return summary;
				}).getContent();

		PagingUtility.calculateMetaData(metaData, profilePage);
		return summaries;
	}

	public MarkerProfileDetails getMarkerProfileDetails(String markerProfileDbId, AlleleFormatParams params,
			MetaData metaData) {
		Optional<MarkerProfileEntity> entity = markerProfileRepository.findById(markerProfileDbId);
		MarkerProfileDetails markerProfile = null;
		if (entity.isPresent()) {
			markerProfile = new MarkerProfileDetails();
			markerProfile.setAnalysisMethod(entity.get().getAnalysisMethod());
			markerProfile.setData(buildAlleleDataMap(params, markerProfileDbId, metaData));
			markerProfile.setExtractDbId(entity.get().getExtractDbId());
			markerProfile.setGermplasmDbId(entity.get().getGermplasmDbId());
			markerProfile.setMarkerprofileDbId(entity.get().getId());
			markerProfile.setUniqueDisplayName(entity.get().getUniqueDisplayName());
		}

		return markerProfile;
	}

	private List<Map<String, String>> buildAlleleDataMap(AlleleFormatParams params, String markerProfileDbId,
			MetaData metaData) {
		
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<AlleleEntity> allelePage = alleleRepository.findAllByMarkerProfileDbId(markerProfileDbId, pageReq);
		PagingUtility.calculateMetaData(metaData, allelePage);
		List<Map<String, String>> alleleMap = new ArrayList<>();

		allelePage.forEach((allele) -> {
			Map<String, String> alleleObj = new HashMap<>();
			alleleObj.put(allele.getMarker().getMarkerName(),
					applyAlleleFormattingRules(allele.getAlleleCode(), params));
			alleleMap.add(alleleObj);
		});
		return alleleMap;
	}

	private String applyAlleleFormattingRules(final String alleleCode, AlleleFormatParams params) {
		String value = alleleCode;
		value = value.replaceAll("\\|", params.getSepPhased());
		value = value.replaceAll("/", params.getSepUnphased());
		value = value.replaceAll("N", params.getUnknownString());
		if (params.isExpandHomozygotes()) {
			value = value.replaceAll("(?<=[^A-Z]|^)([A-Z])(?=[^A-Z]|$)", "$1$1");
		}
		return value;
	}

	public List<List<String>> getAlleleMatrix(String format, AlleleFormatParams params, MetaData metaData) {
		List<List<String>> matrix = new ArrayList<>();

		markerProfileRepository.findAll(PagingUtility.getPageRequest(metaData)).forEach((profile) -> {
			profile.getAlleles().forEach((allele) -> {
				List<String> alleleEntry = new ArrayList<>();
				alleleEntry.add(profile.getId());
				alleleEntry.add(allele.getMarker().getId());
				alleleEntry.add(applyAlleleFormattingRules(allele.getAlleleCode(), params));
				matrix.add(alleleEntry);
			});
		});

		return matrix;
	}

	public List<List<String>> getAlleleMatrix(AlleleMatrixSearchRequest request, MetaData metaData) {
		AlleleFormatParams params = buildFormatParams(request.isExpandHomozygotes(), request.getSepPhased(),
				request.getSepUnphased(), request.getUnknownString());
		List<List<String>> matrix = new ArrayList<>();

		markerProfileRepository.findAll(PagingUtility.getPageRequest(metaData)).forEach((profile) -> {
			profile.getAlleles().forEach((allele) -> {
				List<String> alleleEntry = new ArrayList<>();
				alleleEntry.add(profile.getId());
				alleleEntry.add(allele.getMarker().getId());
				alleleEntry.add(applyAlleleFormattingRules(allele.getAlleleCode(), params));
				matrix.add(alleleEntry);
			});
		});

		return matrix;
	}

	public AlleleFormatParams buildFormatParams(boolean expandHomozygotes, String sepPhased, String sepUnphased,
			String unknownString) {
		AlleleFormatParams params = new AlleleFormatParams();
		params.setExpandHomozygotes(expandHomozygotes);
		params.setSepPhased(sepPhased);
		params.setSepUnphased(sepUnphased);
		params.setUnknownString(unknownString);
		return params;
	}

}
