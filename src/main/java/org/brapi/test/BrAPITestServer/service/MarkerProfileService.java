package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.brapi.test.BrAPITestServer.model.entity.AlleleEntity;
import org.brapi.test.BrAPITestServer.model.entity.AlleleFormatParams;
import org.brapi.test.BrAPITestServer.model.entity.AlleleMatrixEntity;
import org.brapi.test.BrAPITestServer.model.entity.MarkerProfileEntity;
import org.brapi.test.BrAPITestServer.repository.AlleleMatrixRepository;
import org.brapi.test.BrAPITestServer.repository.AlleleRepository;
import org.brapi.test.BrAPITestServer.repository.MarkerProfileRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.AlleleMatrixDetails;
import io.swagger.model.MarkerProfile;
import io.swagger.model.MarkerProfileDescription;
import io.swagger.model.Metadata;

@Service
public class MarkerProfileService {

	private MarkerProfileRepository markerProfileRepository;
	private AlleleMatrixRepository alleleMatrixRepository;
	private AlleleRepository alleleRepository;

	public MarkerProfileService(MarkerProfileRepository markerProfileRepository,
			AlleleMatrixRepository alleleMatrixRepository, AlleleRepository alleleRepository) {
		this.markerProfileRepository = markerProfileRepository;
		this.alleleMatrixRepository = alleleMatrixRepository;
		this.alleleRepository = alleleRepository;
	}

	public List<MarkerProfileDescription> getMarkerProfileSummeries(String germplasmDbId, String studyDbId,
			String sampleDbId, String extractDbId, Metadata metaData) {

		Page<MarkerProfileEntity> profilePage = markerProfileRepository.findBySearchOptions(germplasmDbId, studyDbId,
				sampleDbId, extractDbId, PagingUtility.getPageRequest(metaData));

		List<MarkerProfileDescription> summaries = profilePage.map((entity) -> {
			MarkerProfileDescription summary = new MarkerProfileDescription();
			summary.setAnalysisMethod(entity.getAnalysisMethod());
			summary.setExtractDbId(entity.getExtractDbId());
			summary.setGermplasmDbId(entity.getGermplasmDbId());
			summary.setMarkerprofileDbId(entity.getId());
			summary.setMarkerProfileDbId(entity.getId());
			summary.setResultCount(entity.getResultCount());
			summary.setSampleDbId(entity.getSampleDbId());
			summary.setUniqueDisplayName(entity.getUniqueDisplayName());
			return summary;
		}).getContent();

		PagingUtility.calculateMetaData(metaData, profilePage);
		return summaries;
	}

	public MarkerProfile getMarkerProfileDetails(String markerProfileDbId, AlleleFormatParams params,
			Metadata metaData) {
		Optional<MarkerProfileEntity> entity = markerProfileRepository.findById(markerProfileDbId);
		MarkerProfile markerProfile = null;
		if (entity.isPresent()) {
			markerProfile = new MarkerProfile();
			markerProfile.setAnalysisMethod(entity.get().getAnalysisMethod());
			markerProfile.setData(buildAlleleDataMap(params, markerProfileDbId, metaData));
			markerProfile.setExtractDbId(entity.get().getExtractDbId());
			markerProfile.setGermplasmDbId(entity.get().getGermplasmDbId());
			markerProfile.setMarkerprofileDbId(entity.get().getId());
			markerProfile.setMarkerProfileDbId(entity.get().getId());
			markerProfile.setUniqueDisplayName(entity.get().getUniqueDisplayName());
		}

		return markerProfile;
	}

	private List<Map<String, String>> buildAlleleDataMap(AlleleFormatParams params, String markerProfileDbId,
			Metadata metaData) {

		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<AlleleEntity> allelePage = alleleRepository.findAllByMarkerProfile_Id(markerProfileDbId, pageReq);
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
		value = value.replaceAll("-", params.getUnknownString());
		if (params.isExpandHomozygotes()) {
			value = value.replaceAll("(?<=[^A-Z]|^)([A-Z])(?=[^A-Z]|$)", "$1$1");
		}
		return value;
	}

	public AlleleFormatParams buildFormatParams(Boolean expandHomozygotes, String sepPhased, String sepUnphased,
			String unknownString) {
		AlleleFormatParams params = new AlleleFormatParams();
		params.setExpandHomozygotes(expandHomozygotes != null && expandHomozygotes);
		params.setSepPhased(sepPhased == null ? "\\|" : sepPhased);
		params.setSepUnphased(sepUnphased == null ? "/" : sepUnphased);
		params.setUnknownString(unknownString == null ? "-" : unknownString);
		return params;
	}

	public List<List<String>> getAlleleMatrix(List<String> markerProfileDbIds, List<String> markerDbIds,
			List<String> matrixDbIds, AlleleFormatParams params, Metadata metaData) {

		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		List<List<String>> matrix = new ArrayList<>();
		Page<AlleleEntity> allelePage;

		if (markerProfileDbIds != null && !markerProfileDbIds.isEmpty()) {
			allelePage = alleleRepository.findAllByMarkerProfile_IdIn(markerProfileDbIds, pageReq);
		} else if (markerDbIds != null && !markerDbIds.isEmpty()) {
			allelePage = alleleRepository.findAllByMarker_IdIn(markerDbIds, pageReq);
		} else if (matrixDbIds != null && !matrixDbIds.isEmpty()) {
			allelePage = alleleRepository.findAllByMatrix_IdIn(matrixDbIds, pageReq);
		} else {
			allelePage = alleleRepository.findAll(pageReq);
		}

		allelePage.forEach((allele) -> {
			List<String> alleleEntry = new ArrayList<>();
			alleleEntry.add(allele.getMarker().getId());
			alleleEntry.add(allele.getMarkerProfile().getId());
			alleleEntry.add(applyAlleleFormattingRules(allele.getAlleleCode(), params));
			matrix.add(alleleEntry);
		});

		PagingUtility.calculateMetaData(metaData, allelePage);

		return matrix;
	}

	public List<AlleleMatrixDetails> getAlleleMatrixDetailsByStudyDbId(String studyDbId, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<AlleleMatrixEntity> page;
		if (studyDbId == null || studyDbId.isEmpty()) {
			page = alleleMatrixRepository.findAll(pageReq);
		} else {
			page = alleleMatrixRepository.findAllByStudy_Id(studyDbId, pageReq);
		}

		PagingUtility.calculateMetaData(metaData, page);

		List<AlleleMatrixDetails> details = page.map((entity) -> {
			AlleleMatrixDetails detail = new AlleleMatrixDetails();
			detail.setDescription(entity.getDescription());
			detail.setLastUpdated(DateUtility.toOffsetDateTime(entity.getLastUpdated()));
			detail.setMatrixDbId(entity.getId());
			detail.setMatrixName(entity.getName());
			detail.setName(entity.getName());
			if (entity.getStudy() != null)
				detail.setStudyDbId(entity.getStudy().getId());
			return detail;
		}).getContent();

		return details;
	}

}
