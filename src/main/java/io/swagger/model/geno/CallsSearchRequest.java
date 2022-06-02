package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;

public class CallsSearchRequest extends SearchRequest {
	@JsonProperty("callSetDbIds")
	private List<String> callSetDbIds = null;

	@JsonProperty("expandHomozygotes")
	private Boolean expandHomozygotes = null;

	@JsonProperty("sepPhased")
	private String sepPhased = null;

	@JsonProperty("sepUnphased")
	private String sepUnphased = null;

	@JsonProperty("unknownString")
	private String unknownString = null;

	@JsonProperty("variantDbIds")
	private List<String> variantDbIds = null;

	@JsonProperty("variantSetDbIds")
	private List<String> variantSetDbIds = null;

	public CallsSearchRequest callSetDbIds(List<String> callSetDbIds) {
		this.callSetDbIds = callSetDbIds;
		return this;
	}

	public CallsSearchRequest addCallSetDbIdsItem(String callSetDbIdsItem) {
		if (this.callSetDbIds == null) {
			this.callSetDbIds = new ArrayList<String>();
		}
		this.callSetDbIds.add(callSetDbIdsItem);
		return this;
	}

	public List<String> getCallSetDbIds() {
		return callSetDbIds;
	}

	public void setCallSetDbIds(List<String> callSetDbIds) {
		this.callSetDbIds = callSetDbIds;
	}

	public CallsSearchRequest expandHomozygotes(Boolean expandHomozygotes) {
		this.expandHomozygotes = expandHomozygotes;
		return this;
	}

	public Boolean isExpandHomozygotes() {
		return expandHomozygotes;
	}

	public void setExpandHomozygotes(Boolean expandHomozygotes) {
		this.expandHomozygotes = expandHomozygotes;
	}

	public CallsSearchRequest sepPhased(String sepPhased) {
		this.sepPhased = sepPhased;
		return this;
	}

	public String getSepPhased() {
		return sepPhased;
	}

	public void setSepPhased(String sepPhased) {
		this.sepPhased = sepPhased;
	}

	public CallsSearchRequest sepUnphased(String sepUnphased) {
		this.sepUnphased = sepUnphased;
		return this;
	}

	public String getSepUnphased() {
		return sepUnphased;
	}

	public void setSepUnphased(String sepUnphased) {
		this.sepUnphased = sepUnphased;
	}

	public CallsSearchRequest unknownString(String unknownString) {
		this.unknownString = unknownString;
		return this;
	}

	public String getUnknownString() {
		return unknownString;
	}

	public void setUnknownString(String unknownString) {
		this.unknownString = unknownString;
	}

	public CallsSearchRequest variantDbIds(List<String> variantDbIds) {
		this.variantDbIds = variantDbIds;
		return this;
	}

	public CallsSearchRequest addVariantDbIdsItem(String variantDbIdsItem) {
		if (this.variantDbIds == null) {
			this.variantDbIds = new ArrayList<String>();
		}
		this.variantDbIds.add(variantDbIdsItem);
		return this;
	}

	public List<String> getVariantDbIds() {
		return variantDbIds;
	}

	public void setVariantDbIds(List<String> variantDbIds) {
		this.variantDbIds = variantDbIds;
	}

	public CallsSearchRequest variantSetDbIds(List<String> variantSetDbIds) {
		this.variantSetDbIds = variantSetDbIds;
		return this;
	}

	public CallsSearchRequest addVariantSetDbIdsItem(String variantSetDbIdsItem) {
		if (this.variantSetDbIds == null) {
			this.variantSetDbIds = new ArrayList<String>();
		}
		this.variantSetDbIds.add(variantSetDbIdsItem);
		return this;
	}

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
		CallsSearchRequest callsSearchRequest = (CallsSearchRequest) o;
		return Objects.equals(this.callSetDbIds, callsSearchRequest.callSetDbIds)
				&& Objects.equals(this.expandHomozygotes, callsSearchRequest.expandHomozygotes)
				&& Objects.equals(this.sepPhased, callsSearchRequest.sepPhased)
				&& Objects.equals(this.sepUnphased, callsSearchRequest.sepUnphased)
				&& Objects.equals(this.unknownString, callsSearchRequest.unknownString)
				&& Objects.equals(this.variantDbIds, callsSearchRequest.variantDbIds)
				&& Objects.equals(this.variantSetDbIds, callsSearchRequest.variantSetDbIds) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(callSetDbIds, expandHomozygotes, sepPhased, sepUnphased, unknownString, variantDbIds,
				variantSetDbIds, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CallsSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    callSetDbIds: ").append(toIndentedString(callSetDbIds)).append("\n");
		sb.append("    expandHomozygotes: ").append(toIndentedString(expandHomozygotes)).append("\n");
		sb.append("    sepPhased: ").append(toIndentedString(sepPhased)).append("\n");
		sb.append("    sepUnphased: ").append(toIndentedString(sepUnphased)).append("\n");
		sb.append("    unknownString: ").append(toIndentedString(unknownString)).append("\n");
		sb.append("    variantDbIds: ").append(toIndentedString(variantDbIds)).append("\n");
		sb.append("    variantSetDbIds: ").append(toIndentedString(variantSetDbIds)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	@Override
	public Integer getTotalParameterCount() {
		Integer count = 0;
		if (this.callSetDbIds != null)
			count += this.callSetDbIds.size();
		if (this.expandHomozygotes != null)
			count += 1;
		if (this.sepPhased != null)
			count += 1;
		if (this.sepUnphased != null)
			count += 1;
		if (this.unknownString != null)
			count += 1;
		if (this.variantDbIds != null)
			count += this.variantDbIds.size();
		if (this.variantSetDbIds != null)
			count += this.variantSetDbIds.size();
		return count;
	}
}
