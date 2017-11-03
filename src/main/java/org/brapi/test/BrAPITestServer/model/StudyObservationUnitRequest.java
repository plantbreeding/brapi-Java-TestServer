package org.brapi.test.BrAPITestServer.model;

import org.brapi.test.BrAPITestServer.model.metadata.MetaData;

public class StudyObservationUnitRequest {
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
