package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.brapi.test.BrAPITestServer.model.entity.MarkerProfileEntity;
import org.brapi.test.BrAPITestServer.model.rest.AlleleFormatParams;
import org.brapi.test.BrAPITestServer.model.rest.AlleleMatrixSearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.MarkerProfileDetails;
import org.brapi.test.BrAPITestServer.model.rest.MarkerProfileSummary;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.MarkerProfileRepository;
import org.springframework.stereotype.Service;

import javassist.expr.NewArray;

@Service
public class MarkerProfileService {

	private MarkerProfileRepository markerProfileRepository;

	public MarkerProfileService(MarkerProfileRepository markerProfileRepository) {
		this.markerProfileRepository = markerProfileRepository;
	}

	public List<MarkerProfileSummary> getMarkerProfileSummeries(String germplasmDbId, String studyDbId,
			String sampleDbId, String extractDbId, String analysisMethod, MetaData metaData) {

		List<MarkerProfileSummary> summaries = markerProfileRepository.findBySearchOptions(germplasmDbId, studyDbId,
				sampleDbId, extractDbId, analysisMethod, PagingUtility.getPageRequest(metaData)).map((entity) -> {
					MarkerProfileSummary summary = new MarkerProfileSummary();
					summary.setAnalysisMethod(entity.getAnalysisMethod());
					summary.setExtractDbId(entity.getExtractDbId());
					summary.setGermplasmDbId(entity.getGermplasmDbId());
					summary.setMarkerProfileDbId(entity.getId());
					summary.setResultCount(entity.getResultCount());
					summary.setSampleDbId(entity.getSampleDbId());
					summary.setUniqueDisplayName(entity.getUniqueDisplayName());
					return summary;
				}).getContent();

		metaData.getPagination().setTotalCount((int) markerProfileRepository.countBySearchOptions(germplasmDbId,
				studyDbId, sampleDbId, extractDbId, analysisMethod));

		PagingUtility.calculateMetaData(metaData);
		return summaries;
	}

	public MarkerProfileDetails getMarkerProfileDetails(String markerProfileDbId, AlleleFormatParams params,
			MetaData metaData) {
		MarkerProfileEntity entity = markerProfileRepository.findById(markerProfileDbId).get();
		MarkerProfileDetails markerProfile = new MarkerProfileDetails();
		markerProfile.setAnalysisMethod(entity.getAnalysisMethod());
		markerProfile.setData(buildAlleleDataMap(params, entity, metaData));
		markerProfile.setExtractDbId(entity.getExtractDbId());
		markerProfile.setGermplasmDbId(entity.getGermplasmDbId());
		markerProfile.setMarkerProfileDbId(entity.getId());
		markerProfile.setUniqueDisplayName(entity.getUniqueDisplayName());
		return markerProfile;
	}

	private Map<String, String> buildAlleleDataMap(AlleleFormatParams params, MarkerProfileEntity entity,
			MetaData metaData) {
		Map<String, String> alleleMap = new HashMap<>();

		// TODO this paging should be moved to the query
		int pageStartPos = metaData.getPagination().getCurrentPage() * metaData.getPagination().getPageSize();
		int pageEndPos = (metaData.getPagination().getCurrentPage() * metaData.getPagination().getPageSize())
				+ metaData.getPagination().getPageSize() - 1;

		entity.getAlleles().subList(pageStartPos, pageEndPos).forEach((allele) -> {
			alleleMap.put(allele.getMarker().getMarkerName(),
					applyAlleleFormattingRules(allele.getAlleleCode(), params));
		});
		return alleleMap;
	}

	private String applyAlleleFormattingRules(final String alleleCode, AlleleFormatParams params) {
		String value = alleleCode;
		value = value.replaceAll("|", params.getSepPhased());
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
