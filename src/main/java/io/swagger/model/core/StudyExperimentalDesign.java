package io.swagger.model.core;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudyExperimentalDesign {
	@JsonProperty("PUI")
	private String PUI = null;

	@JsonProperty("description")
	private String description = null;

	public StudyExperimentalDesign PUI(String PUI) {
		this.PUI = PUI;
		return this;
	}

	@JsonIgnore
	public String getPUI() {
		return PUI;
	}

	public void setPUI(String PUI) {
		this.PUI = PUI;
	}

	public StudyExperimentalDesign description(String description) {
		this.description = description;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		StudyExperimentalDesign studyNewRequestExperimentalDesign = (StudyExperimentalDesign) o;
		return Objects.equals(this.PUI, studyNewRequestExperimentalDesign.PUI)
				&& Objects.equals(this.description, studyNewRequestExperimentalDesign.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(PUI, description);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class StudyNewRequestExperimentalDesign {\n");

		sb.append("    PUI: ").append(toIndentedString(PUI)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
