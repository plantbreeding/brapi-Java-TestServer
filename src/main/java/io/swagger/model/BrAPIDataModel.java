package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BrAPIDataModel {

	@JsonProperty("additionalInfo")
	protected Object additionalInfo = null;

	@JsonProperty("externalReferences")
	protected ExternalReferences externalReferences = null;

	final public BrAPIDataModel additionalInfo(Object additionalInfo) {
		this.additionalInfo = additionalInfo;
		return this;
	}

	final public Object getAdditionalInfo() {
		return additionalInfo;
	}

	final public void setAdditionalInfo(Object additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	

	final public BrAPIDataModel externalReferences(ExternalReferences externalReferences) {
		this.externalReferences = externalReferences;
		return this;
	}

	final public ExternalReferences getExternalReferences() {
		return externalReferences;
	}

	final public void setExternalReferences(ExternalReferences externalReferences) {
		this.externalReferences = externalReferences;
	}
}
