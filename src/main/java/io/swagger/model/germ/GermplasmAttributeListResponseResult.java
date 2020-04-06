package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.BrAPIResponseResult;
import io.swagger.model.germ.GermplasmAttribute;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GermplasmAttributeListResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class GermplasmAttributeListResponseResult implements BrAPIResponseResult<GermplasmAttribute> {
	@JsonProperty("data")
	@Valid
	private List<GermplasmAttribute> data = new ArrayList<GermplasmAttribute>();

	public GermplasmAttributeListResponseResult data(List<GermplasmAttribute> data) {
		this.data = data;
		return this;
	}

	public GermplasmAttributeListResponseResult addDataItem(GermplasmAttribute dataItem) {
		this.data.add(dataItem);
		return this;
	}

	/**
	 * Get data
	 * 
	 * @return data
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull
	@Valid
	public List<GermplasmAttribute> getData() {
		return data;
	}

	public void setData(List<GermplasmAttribute> data) {
		this.data = data;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GermplasmAttributeListResponseResult germplasmAttributeListResponseResult = (GermplasmAttributeListResponseResult) o;
		return Objects.equals(this.data, germplasmAttributeListResponseResult.data);
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GermplasmAttributeListResponseResult {\n");

		sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
