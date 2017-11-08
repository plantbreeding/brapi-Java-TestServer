package org.brapi.test.BrAPITestServer.model.rest;

import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;

public class StudyObservationUnitRequest {
	//TODO why does a request need metadata
	private MetaData metadata;
	private StudyObservationUnitWrapper results;
	public MetaData getMetadata() {
		return metadata;
	}
	public void setMetadata(MetaData metadata) {
		this.metadata = metadata;
	}
	public StudyObservationUnitWrapper getResults() {
		return results;
	}
	public void setResults(StudyObservationUnitWrapper results) {
		this.results = results;
	}
}
