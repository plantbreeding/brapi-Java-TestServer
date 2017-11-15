package org.brapi.test.BrAPITestServer.service;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.GenomeMapData;
import org.brapi.test.BrAPITestServer.model.rest.GenomeMapDetail;
import org.brapi.test.BrAPITestServer.model.rest.GenomeMapSummary;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.springframework.stereotype.Service;

@Service
public class GenomeMapService {

	public List<GenomeMapSummary> getMapSummaries(String speciesId, String type, MetaData metaData) {
		// TODO Auto-generated method stub
		return null;
	}

	public GenomeMapDetail getMapDetail(String mapDbId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GenomeMapData> getMapPositions(String mapDbId, String linkageGroupId, int minPosition, int maxPosition, MetaData metaData) {
		// TODO Auto-generated method stub
		return null;
	}

}
