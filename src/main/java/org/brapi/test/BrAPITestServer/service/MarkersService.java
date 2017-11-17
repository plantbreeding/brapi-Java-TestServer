package org.brapi.test.BrAPITestServer.service;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.Marker;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.springframework.stereotype.Service;

@Service
public class MarkersService {

	public List<Marker> getMarkers(String name, String type, String matchMethod, String synonyms, MetaData metaData) {
		// TODO Auto-generated method stub
		return null;
	}

	public Marker getMarker(String markerDbId) {
		// TODO Auto-generated method stub
		return null;
	}

}
