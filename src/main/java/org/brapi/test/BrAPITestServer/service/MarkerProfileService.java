package org.brapi.test.BrAPITestServer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.brapi.test.BrAPITestServer.model.entity.MarkerProfileEntity;
import org.brapi.test.BrAPITestServer.model.rest.AlleleMatrixSearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.MarkerProfileDetails;
import org.brapi.test.BrAPITestServer.model.rest.MarkerProfileSummary;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.MarkerProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class MarkerProfileService {

	private MarkerProfileRepository markerProfileRepository;

	public MarkerProfileService(MarkerProfileRepository markerProfileRepository) {
		this.markerProfileRepository = markerProfileRepository;
	}

	public List<MarkerProfileSummary> getMarkerProfileSummeries(String germplasmDbId, String studyDbId,
			String sampleDbId, String extractDbId, String analysisMethod, MetaData metaData) {

		List<MarkerProfileSummary> summaries = markerProfileRepository.findBySearchOptions(germplasmDbId, studyDbId,
				sampleDbId, extractDbId, analysisMethod, PagingUtility.getPageRequest(metaData))
				.map((entity) -> {
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
		
		metaData.getPagination().setTotalCount((int) markerProfileRepository.countBySearchOptions(germplasmDbId, studyDbId,
				sampleDbId, extractDbId, analysisMethod));
		
		PagingUtility.calculateMetaData(metaData);
		return summaries;
	}

	public MarkerProfileDetails getMarkerProfileDetails(String markerProfileDbId, boolean expandHomozygotes,
			String unknownString, String sepPhased, String sepUnphased, MetaData metaData) {
		MarkerProfileEntity entity = markerProfileRepository.findById(markerProfileDbId).get();
		MarkerProfileDetails markerProfile = new MarkerProfileDetails();
		markerProfile.setAnalysisMethod(entity.getAnalysisMethod());
		markerProfile.setData(buildAlleleDataMap(expandHomozygotes, unknownString, sepPhased, sepUnphased, entity, metaData));
		markerProfile.setExtractDbId(entity.getExtractDbId());
		markerProfile.setGermplasmDbId(entity.getGermplasmDbId());
		markerProfile.setMarkerProfileDbId(entity.getId());
		markerProfile.setUniqueDisplayName(entity.getUniqueDisplayName());
		return markerProfile;
	}

	private Map<String, String> buildAlleleDataMap(boolean expandHomozygotes, String unknownString, String sepPhased,
			String sepUnphased, MarkerProfileEntity entity, MetaData metaData) {
		Map<String, String> alleleMap = new HashMap<>();
		
		//TODO this paging should be moved to the query
		int pageStartPos = metaData.getPagination().getCurrentPage() * metaData.getPagination().getPageSize();
		int pageEndPos = (metaData.getPagination().getCurrentPage() * metaData.getPagination().getPageSize()) + metaData.getPagination().getPageSize() - 1;
		entity.getAlleles().subList(pageStartPos, pageEndPos).forEach((allele) -> {
			String value = allele.getAllele();
			value = value.replaceAll("|", sepPhased);
			value = value.replaceAll("/", sepUnphased);
			value = value.replaceAll("N", unknownString);
			if(expandHomozygotes) {
				value = value.replaceAll("[^A-Z]([A-Z])[^A-Z]", "$1$1");
			}
			
			alleleMap.put(allele.getMarkerName(), value);
		});
		return alleleMap;
	}

	public List<List<String>> getAlleleMatrix(String format, boolean expandHomozygotes, String unknownString,
			String sepPhased, String sepUnphased, MetaData metaData) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<List<String>> getAlleleMatrix(AlleleMatrixSearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
