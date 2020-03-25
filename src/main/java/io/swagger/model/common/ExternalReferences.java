package io.swagger.model.common;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.model.common.ExternalReferencesInner;
import java.util.ArrayList;
import org.springframework.validation.annotation.Validated;

/**
 * An array of external reference ids. These are references to this piece of
 * data in an external system. Could be a simple string or a URI.
 */
@ApiModel(description = "An array of external reference ids. These are references to this piece of data in an external system. Could be a simple string or a URI.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class ExternalReferences extends ArrayList<ExternalReferencesInner> {

	private static final long serialVersionUID = -4795437173672218910L;
	
	public ExternalReferences addReference(String referenceId, String referenceSource) {
		ExternalReferencesInner inner = new ExternalReferencesInner()
				.referenceID(referenceId).referenceSource(referenceSource);
		this.add(inner);
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ExternalReferences {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
