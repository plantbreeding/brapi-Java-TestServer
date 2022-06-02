package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExternalReferencesInner {
	@JsonProperty("referenceID")
	private String referenceID = null;
	@JsonProperty("referenceId")
	private String referenceId = null;
	@JsonProperty("referenceSource")
	private String referenceSource = null;

	public ExternalReferencesInner referenceID(String referenceID) {
		this.referenceID = referenceID;
		this.referenceId = referenceID;
		return this;
	}

	public String getReferenceID() {
		return referenceID;
	}

	public void setReferenceID(String referenceID) {
		this.referenceID = referenceID;
		this.referenceId = referenceID;
	}

	public ExternalReferencesInner referenceId(String referenceId) {
		this.referenceID = referenceId;
		this.referenceId = referenceId;
		return this;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceID = referenceId;
		this.referenceId = referenceId;
	}

	public ExternalReferencesInner referenceSource(String referenceSource) {
		this.referenceSource = referenceSource;
		return this;
	}

	public String getReferenceSource() {
		return referenceSource;
	}

	public void setReferenceSource(String referenceSource) {
		this.referenceSource = referenceSource;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ExternalReferencesInner externalReferencesInner = (ExternalReferencesInner) o;
		return Objects.equals(this.referenceID, externalReferencesInner.referenceID)
				&& Objects.equals(this.referenceId, externalReferencesInner.referenceId)
				&& Objects.equals(this.referenceSource, externalReferencesInner.referenceSource);
	}

	@Override
	public int hashCode() {
		return Objects.hash(referenceID, referenceId, referenceSource);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ExternalReferencesInner {\n");

		sb.append("    referenceID: ").append(toIndentedString(referenceID)).append("\n");
		sb.append("    referenceID: ").append(toIndentedString(referenceId)).append("\n");
		sb.append("    referenceSource: ").append(toIndentedString(referenceSource)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
