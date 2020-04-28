package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.germ.GermplasmNewRequest;
import org.springframework.validation.annotation.Validated;


/**
 * Germplasm
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class Germplasm extends GermplasmNewRequest {
	@JsonProperty("germplasmDbId")
	private String germplasmDbId = null;

	public Germplasm germplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
		return this;
	}

	/**
	 * The ID which uniquely identifies a germplasm within the given database server
	 * MIAPPE V1.1 (DM-41) Biological material ID - Code used to identify the
	 * biological material in the data file. Should be unique within the
	 * Investigation. Can correspond to experimental plant ID, seed lot ID, etc.
	 * This material identification is different from a BiosampleID which
	 * corresponds to Observation Unit or Samples sections below.
	 * 
	 * @return germplasmDbId
	 **/
	@ApiModelProperty(example = "d4076594", required = true, value = "The ID which uniquely identifies a germplasm within the given database server  MIAPPE V1.1 (DM-41) Biological material ID - Code used to identify the biological material in the data file. Should be unique within the Investigation. Can correspond to experimental plant ID, seed lot ID, etc. This material identification is different from a BiosampleID which corresponds to Observation Unit or Samples sections below.")
	

	public String getGermplasmDbId() {
		return germplasmDbId;
	}

	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Germplasm germplasm = (Germplasm) o;
		return Objects.equals(this.germplasmDbId, germplasm.germplasmDbId) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(germplasmDbId, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Germplasm {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
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
