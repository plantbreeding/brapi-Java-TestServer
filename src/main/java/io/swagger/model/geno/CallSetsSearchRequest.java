package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SearchRequest;
import io.swagger.model.SearchRequestParametersPaging;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * CallSetsSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class CallSetsSearchRequest extends SearchRequestParametersPaging implements SearchRequest {
	@JsonProperty("germplasmDbIds")
	@Valid
	private List<String> germplasmDbIds = null;

	@JsonProperty("germplasmNames")
	@Valid
	private List<String> germplasmNames = null;

	@JsonProperty("callSetDbIds")
	@Valid
	private List<String> callSetDbIds = null;

	@JsonProperty("callSetNames")
	@Valid
	private List<String> callSetNames = null;

	@JsonProperty("sampleDbIds")
	@Valid
	private List<String> sampleDbIds = null;

	@JsonProperty("sampleNames")
	@Valid
	private List<String> sampleNames = null;

	@JsonProperty("variantSetDbIds")
	@Valid
	private List<String> variantSetDbIds = null;

	public CallSetsSearchRequest germplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
		return this;
	}

	public CallSetsSearchRequest addGermplasmDbIdsItem(String germplasmDbIdsItem) {
		if (this.germplasmDbIds == null) {
			this.germplasmDbIds = new ArrayList<String>();
		}
		this.germplasmDbIds.add(germplasmDbIdsItem);
		return this;
	}

	/**
	 * List of IDs which uniquely identify germplasm to search for
	 * 
	 * @return germplasmDbIds
	 **/
	@ApiModelProperty(example = "[\"e9c6edd7\",\"1b1df4a6\"]", value = "List of IDs which uniquely identify germplasm to search for")

	public List<String> getGermplasmDbIds() {
		return germplasmDbIds;
	}

	public void setGermplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
	}

	public CallSetsSearchRequest germplasmNames(List<String> germplasmNames) {
		this.germplasmNames = germplasmNames;
		return this;
	}

	public CallSetsSearchRequest addGermplasmNamesItem(String germplasmNamesItem) {
		if (this.germplasmNames == null) {
			this.germplasmNames = new ArrayList<String>();
		}
		this.germplasmNames.add(germplasmNamesItem);
		return this;
	}

	/**
	 * List of human readable names to identify germplasm to search for
	 * 
	 * @return germplasmNames
	 **/
	@ApiModelProperty(example = "[\"A0000003\",\"A0000477\"]", value = "List of human readable names to identify germplasm to search for")

	public List<String> getGermplasmNames() {
		return germplasmNames;
	}

	public void setGermplasmNames(List<String> germplasmNames) {
		this.germplasmNames = germplasmNames;
	}

	public CallSetsSearchRequest callSetDbIds(List<String> callSetDbIds) {
		this.callSetDbIds = callSetDbIds;
		return this;
	}

	public CallSetsSearchRequest addCallSetDbIdsItem(String callSetDbIdsItem) {
		if (this.callSetDbIds == null) {
			this.callSetDbIds = new ArrayList<String>();
		}
		this.callSetDbIds.add(callSetDbIdsItem);
		return this;
	}

	/**
	 * Only return call sets with these DbIds (case-sensitive, exact match).
	 * 
	 * @return callSetDbIds
	 **/
	@ApiModelProperty(example = "[\"6c7486b2\",\"49c36a73\"]", value = "Only return call sets with these DbIds (case-sensitive, exact match).")

	public List<String> getCallSetDbIds() {
		return callSetDbIds;
	}

	public void setCallSetDbIds(List<String> callSetDbIds) {
		this.callSetDbIds = callSetDbIds;
	}

	public CallSetsSearchRequest callSetNames(List<String> callSetNames) {
		this.callSetNames = callSetNames;
		return this;
	}

	public CallSetsSearchRequest addCallSetNamesItem(String callSetNamesItem) {
		if (this.callSetNames == null) {
			this.callSetNames = new ArrayList<String>();
		}
		this.callSetNames.add(callSetNamesItem);
		return this;
	}

	/**
	 * Only return call sets with these names (case-sensitive, exact match).
	 * 
	 * @return callSetNames
	 **/
	@ApiModelProperty(example = "[\"Sample_123_DNA_Run_456\",\"Sample_789_DNA_Run_101\"]", value = "Only return call sets with these names (case-sensitive, exact match).")

	public List<String> getCallSetNames() {
		return callSetNames;
	}

	public void setCallSetNames(List<String> callSetNames) {
		this.callSetNames = callSetNames;
	}

	public CallSetsSearchRequest sampleDbIds(List<String> sampleDbIds) {
		this.sampleDbIds = sampleDbIds;
		return this;
	}

	public CallSetsSearchRequest addSampleDbIdsItem(String sampleDbIdsItem) {
		if (this.sampleDbIds == null) {
			this.sampleDbIds = new ArrayList<String>();
		}
		this.sampleDbIds.add(sampleDbIdsItem);
		return this;
	}

	/**
	 * Return only call sets generated from the provided Biosample IDs.
	 * 
	 * @return sampleDbIds
	 **/
	@ApiModelProperty(example = "[\"758d3f6d\",\"39c0a3f7\"]", value = "Return only call sets generated from the provided Biosample IDs.")

	public List<String> getSampleDbIds() {
		return sampleDbIds;
	}

	public void setSampleDbIds(List<String> sampleDbIds) {
		this.sampleDbIds = sampleDbIds;
	}

	public CallSetsSearchRequest sampleNames(List<String> sampleNames) {
		this.sampleNames = sampleNames;
		return this;
	}

	public CallSetsSearchRequest addSampleNamesItem(String sampleNamesItem) {
		if (this.sampleNames == null) {
			this.sampleNames = new ArrayList<String>();
		}
		this.sampleNames.add(sampleNamesItem);
		return this;
	}

	/**
	 * Return only call sets generated from the provided Biosample human readable
	 * names.
	 * 
	 * @return sampleNames
	 **/
	@ApiModelProperty(example = "[\"Sample_123\",\"Sample_789\"]", value = "Return only call sets generated from the provided Biosample human readable names.")

	public List<String> getSampleNames() {
		return sampleNames;
	}

	public void setSampleNames(List<String> sampleNames) {
		this.sampleNames = sampleNames;
	}

	public CallSetsSearchRequest variantSetDbIds(List<String> variantSetDbIds) {
		this.variantSetDbIds = variantSetDbIds;
		return this;
	}

	public CallSetsSearchRequest addVariantSetDbIdsItem(String variantSetDbIdsItem) {
		if (this.variantSetDbIds == null) {
			this.variantSetDbIds = new ArrayList<String>();
		}
		this.variantSetDbIds.add(variantSetDbIdsItem);
		return this;
	}

	/**
	 * The VariantSet to search.
	 * 
	 * @return variantSetDbIds
	 **/
	@ApiModelProperty(example = "[\"8a9a8972\",\"32a2649a\"]", value = "The VariantSet to search.")

	public List<String> getVariantSetDbIds() {
		return variantSetDbIds;
	}

	public void setVariantSetDbIds(List<String> variantSetDbIds) {
		this.variantSetDbIds = variantSetDbIds;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CallSetsSearchRequest callSetsSearchRequest = (CallSetsSearchRequest) o;
		return Objects.equals(this.germplasmDbIds, callSetsSearchRequest.germplasmDbIds)
				&& Objects.equals(this.germplasmNames, callSetsSearchRequest.germplasmNames)
				&& Objects.equals(this.callSetDbIds, callSetsSearchRequest.callSetDbIds)
				&& Objects.equals(this.callSetNames, callSetsSearchRequest.callSetNames)
				&& Objects.equals(this.sampleDbIds, callSetsSearchRequest.sampleDbIds)
				&& Objects.equals(this.sampleNames, callSetsSearchRequest.sampleNames)
				&& Objects.equals(this.variantSetDbIds, callSetsSearchRequest.variantSetDbIds) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(germplasmDbIds, germplasmNames, callSetDbIds, callSetNames, sampleDbIds, sampleNames,
				variantSetDbIds, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CallSetsSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    germplasmDbIds: ").append(toIndentedString(germplasmDbIds)).append("\n");
		sb.append("    germplasmNames: ").append(toIndentedString(germplasmNames)).append("\n");
		sb.append("    callSetDbIds: ").append(toIndentedString(callSetDbIds)).append("\n");
		sb.append("    callSetNames: ").append(toIndentedString(callSetNames)).append("\n");
		sb.append("    sampleDbIds: ").append(toIndentedString(sampleDbIds)).append("\n");
		sb.append("    sampleNames: ").append(toIndentedString(sampleNames)).append("\n");
		sb.append("    variantSetDbIds: ").append(toIndentedString(variantSetDbIds)).append("\n");
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

	@Override
	public Integer getTotalParameterCount() {
		Integer count = 0;
		if (this.germplasmDbIds != null)
			count += this.germplasmDbIds.size();
		if (this.germplasmNames != null)
			count += this.germplasmNames.size();
		if (this.callSetDbIds != null)
			count += this.callSetDbIds.size();
		if (this.callSetNames != null)
			count += this.callSetNames.size();
		if (this.sampleDbIds != null)
			count += this.sampleDbIds.size();
		if (this.sampleNames != null)
			count += this.sampleNames.size();
		if (this.variantSetDbIds != null)
			count += this.variantSetDbIds.size();
		return count;
	}
}
