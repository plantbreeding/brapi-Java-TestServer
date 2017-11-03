package org.brapi.test.BrAPITestServer.model;

import java.util.List;

public class TraitSummary {
	// TODO should be the same as Trait
	private String traitDbId;
	private String traitId;
	private String name;
	private String description;
	private List<String> observationVariables;
	private String defaultValue;
	public String getTraitDbId() {
		return traitDbId;
	}
	public void setTraitDbId(String traitDbId) {
		this.traitDbId = traitDbId;
	}
	public String getTraitId() {
		return traitId;
	}
	public void setTraitId(String traitId) {
		this.traitId = traitId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getObservationVariables() {
		return observationVariables;
	}
	public void setObservationVariables(List<String> observationVariables) {
		this.observationVariables = observationVariables;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
