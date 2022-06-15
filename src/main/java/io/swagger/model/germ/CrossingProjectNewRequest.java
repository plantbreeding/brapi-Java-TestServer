package io.swagger.model.germ;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;

public class CrossingProjectNewRequest extends BrAPIDataModel {

	@JsonProperty("commonCropName")
	private String commonCropName = null;

	@JsonProperty("crossingProjectDescription")
	private String crossingProjectDescription = null;

	@JsonProperty("crossingProjectName")
	private String crossingProjectName = null;

	@JsonProperty("programDbId")
	private String programDbId = null;

	@JsonProperty("programName")
	private String programName = null;

	@JsonProperty("potentialParents")
	private List<CrossParent> potentialParents = null;

	public List<CrossParent> getPotentialParents() {
		return potentialParents;
	}

	public void setPotentialParents(List<CrossParent> potentialParents) {
		this.potentialParents = potentialParents;
	}

	public CrossingProjectNewRequest commonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
		return this;
	}

	public String getCommonCropName() {
		return commonCropName;
	}

	public void setCommonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
	}

	public CrossingProjectNewRequest crossingProjectDescription(String crossingProjectDescription) {
		this.crossingProjectDescription = crossingProjectDescription;
		return this;
	}

	public String getCrossingProjectDescription() {
		return crossingProjectDescription;
	}

	public void setCrossingProjectDescription(String crossingProjectDescription) {
		this.crossingProjectDescription = crossingProjectDescription;
	}

	public CrossingProjectNewRequest crossingProjectName(String crossingProjectName) {
		this.crossingProjectName = crossingProjectName;
		return this;
	}

	public String getCrossingProjectName() {
		return crossingProjectName;
	}

	public void setCrossingProjectName(String crossingProjectName) {
		this.crossingProjectName = crossingProjectName;
	}

	public CrossingProjectNewRequest programDbId(String programDbId) {
		this.programDbId = programDbId;
		return this;
	}

	public String getProgramDbId() {
		return programDbId;
	}

	public void setProgramDbId(String programDbId) {
		this.programDbId = programDbId;
	}

	public CrossingProjectNewRequest programName(String programName) {
		this.programName = programName;
		return this;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CrossingProjectNewRequest crossingProjectNewRequest = (CrossingProjectNewRequest) o;
		return Objects.equals(this.commonCropName, crossingProjectNewRequest.commonCropName)
				&& Objects.equals(this.crossingProjectDescription, crossingProjectNewRequest.crossingProjectDescription)
				&& Objects.equals(this.crossingProjectName, crossingProjectNewRequest.crossingProjectName)
				&& Objects.equals(this.externalReferences, crossingProjectNewRequest.externalReferences)
				&& Objects.equals(this.programDbId, crossingProjectNewRequest.programDbId)
				&& Objects.equals(this.programName, crossingProjectNewRequest.programName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(commonCropName, crossingProjectDescription, crossingProjectName, externalReferences,
				programDbId, programName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CrossingProjectNewRequest {\n");

		sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
		sb.append("    crossingProjectDescription: ").append(toIndentedString(crossingProjectDescription)).append("\n");
		sb.append("    crossingProjectName: ").append(toIndentedString(crossingProjectName)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    programDbId: ").append(toIndentedString(programDbId)).append("\n");
		sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
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
