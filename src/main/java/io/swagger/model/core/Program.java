package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Program extends ProgramNewRequest {
	@JsonProperty("programDbId")
	private String programDbId = null;

	public Program programDbId(String programDbId) {
		this.programDbId = programDbId;
		return this;
	}

	public String getProgramDbId() {
		return programDbId;
	}

	public void setProgramDbId(String programDbId) {
		this.programDbId = programDbId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Program program = (Program) o;
		return Objects.equals(this.programDbId, program.programDbId) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(programDbId, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Program {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    programDbId: ").append(toIndentedString(programDbId)).append("\n");
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
