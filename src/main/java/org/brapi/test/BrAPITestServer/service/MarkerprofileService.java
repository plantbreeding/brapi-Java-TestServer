package org.brapi.test.BrAPITestServer.service;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.AlleleMatrixSearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.MarkerprofileDetails;
import org.brapi.test.BrAPITestServer.model.rest.MarkerprofileSummary;
import org.springframework.stereotype.Service;

@Service
public class MarkerprofileService {

	public List<MarkerprofileSummary> getMarkerprofileSummeries(String germplasmDbId, String studyDbId,
			String sampleDbId, String extractDbId, String methodDbId, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public MarkerprofileDetails getMarkerprofileDetails(String markerprofileDbId, boolean expandHomozygotes,
			String unknownString, String sepPhased, String sepUnphased, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<List<String>> getAlleleMatrix(String format, boolean expandHomozygotes, String unknownString,
			String sepPhased, String sepUnphased, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<List<String>> getAlleleMatrix(AlleleMatrixSearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
