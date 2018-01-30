package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericRequest;

public class SampleSearchRequest extends GenericRequest{
	private List<String> sampleDbId;
	private List<String> observationUnitDbId;
	private List<String> plateDbId;
	private List<String> germplasmDbId;
	
	public List<String> getSampleDbId() {
		return sampleDbId;
	}
	public void setSampleDbId(List<String> sampleDbId) {
		this.sampleDbId = sampleDbId;
	}
	public List<String> getObservationUnitDbId() {
		return observationUnitDbId;
	}
	public void setObservationUnitDbId(List<String> observationUnitDbId) {
		this.observationUnitDbId = observationUnitDbId;
	}
	public List<String> getPlateDbId() {
		return plateDbId;
	}
	public void setPlateDbId(List<String> plateDbId) {
		this.plateDbId = plateDbId;
	}
	public List<String> getGermplasmDbId() {
		return germplasmDbId;
	}
	public void setGermplasmDbId(List<String> germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}
}
