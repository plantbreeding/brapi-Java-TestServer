package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class AlleleMatrix {
	@JsonProperty("callSetDbIds")
	private List<String> callSetDbIds = null;

	@JsonProperty("dataMatrices")
	private List<AlleleMatrixDataMatrices> dataMatrices = null;

	@JsonProperty("expandHomozygotes")
	private Boolean expandHomozygotes = null;

	@JsonProperty("pagination")
	private List<AlleleMatrixPagination> pagination = null;

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

	public AlleleMatrix callSetDbIds(List<String> callSetDbIds) {
		this.callSetDbIds = callSetDbIds;
		return this;
	}

	public AlleleMatrix addCallSetDbIdsItem(String callSetDbIdsItem) {
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

	public AlleleMatrix dataMatrices(List<AlleleMatrixDataMatrices> dataMatrices) {
		this.dataMatrices = dataMatrices;
		return this;
	}

	public AlleleMatrix addDataMatricesItem(AlleleMatrixDataMatrices dataMatricesItem) {
		if (this.dataMatrices == null) {
			this.dataMatrices = new ArrayList<AlleleMatrixDataMatrices>();
		}
		this.dataMatrices.add(dataMatricesItem);
		return this;
	}

	public List<AlleleMatrixDataMatrices> getDataMatrices() {
		return dataMatrices;
	}

	public void setDataMatrices(List<AlleleMatrixDataMatrices> dataMatrices) {
		this.dataMatrices = dataMatrices;
	}

	public AlleleMatrix expandHomozygotes(Boolean expandHomozygotes) {
		this.expandHomozygotes = expandHomozygotes;
		return this;
	}

	public Boolean isExpandHomozygotes() {
		return expandHomozygotes;
	}

	public void setExpandHomozygotes(Boolean expandHomozygotes) {
		this.expandHomozygotes = expandHomozygotes;
	}

	public AlleleMatrix pagination(List<AlleleMatrixPagination> pagination) {
		this.pagination = pagination;
		return this;
	}

	public AlleleMatrix addPaginationItem(AlleleMatrixPagination paginationItem) {
		if (this.pagination == null) {
			this.pagination = new ArrayList<AlleleMatrixPagination>();
		}
		this.pagination.add(paginationItem);
		return this;
	}

	public List<AlleleMatrixPagination> getPagination() {
		return pagination;
	}

	public void setPagination(List<AlleleMatrixPagination> pagination) {
		this.pagination = pagination;
	}

	public AlleleMatrix sepPhased(String sepPhased) {
		this.sepPhased = sepPhased;
		return this;
	}

	public String getSepPhased() {
		return sepPhased;
	}

	public void setSepPhased(String sepPhased) {
		this.sepPhased = sepPhased;
	}

	public AlleleMatrix sepUnphased(String sepUnphased) {
		this.sepUnphased = sepUnphased;
		return this;
	}

	public String getSepUnphased() {
		return sepUnphased;
	}

	public void setSepUnphased(String sepUnphased) {
		this.sepUnphased = sepUnphased;
	}

	public AlleleMatrix unknownString(String unknownString) {
		this.unknownString = unknownString;
		return this;
	}

	public String getUnknownString() {
		return unknownString;
	}

	public void setUnknownString(String unknownString) {
		this.unknownString = unknownString;
	}

	public AlleleMatrix variantDbIds(List<String> variantDbIds) {
		this.variantDbIds = variantDbIds;
		return this;
	}

	public AlleleMatrix addVariantDbIdsItem(String variantDbIdsItem) {
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

	public AlleleMatrix variantSetDbIds(List<String> variantSetDbIds) {
		this.variantSetDbIds = variantSetDbIds;
		return this;
	}

	public AlleleMatrix addVariantSetDbIdsItem(String variantSetDbIdsItem) {
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
		AlleleMatrix alleleMatrix = (AlleleMatrix) o;
		return Objects.equals(this.callSetDbIds, alleleMatrix.callSetDbIds)
				&& Objects.equals(this.dataMatrices, alleleMatrix.dataMatrices)
				&& Objects.equals(this.expandHomozygotes, alleleMatrix.expandHomozygotes)
				&& Objects.equals(this.pagination, alleleMatrix.pagination)
				&& Objects.equals(this.sepPhased, alleleMatrix.sepPhased)
				&& Objects.equals(this.sepUnphased, alleleMatrix.sepUnphased)
				&& Objects.equals(this.unknownString, alleleMatrix.unknownString)
				&& Objects.equals(this.variantDbIds, alleleMatrix.variantDbIds)
				&& Objects.equals(this.variantSetDbIds, alleleMatrix.variantSetDbIds);
	}

	@Override
	public int hashCode() {
		return Objects.hash(callSetDbIds, dataMatrices, expandHomozygotes, pagination, sepPhased, sepUnphased,
				unknownString, variantDbIds, variantSetDbIds);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AlleleMatrix {\n");

		sb.append("    callSetDbIds: ").append(toIndentedString(callSetDbIds)).append("\n");
		sb.append("    dataMatrices: ").append(toIndentedString(dataMatrices)).append("\n");
		sb.append("    expandHomozygotes: ").append(toIndentedString(expandHomozygotes)).append("\n");
		sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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
}
