package org.brapi.test.BrAPITestServer.service;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.GenomeMapData;
import org.brapi.test.BrAPITestServer.model.rest.GenomeMapDetail;
import org.brapi.test.BrAPITestServer.model.rest.GenomeMapSummary;
import org.springframework.stereotype.Service;

@Service
public class GenomeMapService {

	public List<GenomeMapSummary> getMapSummaries(String speciesId, String type, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public GenomeMapDetail getMapDetail(String mapDbId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GenomeMapData> getMapPositions(String mapDbId, String linkageGroupId, int minPosition, int maxPosition, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
