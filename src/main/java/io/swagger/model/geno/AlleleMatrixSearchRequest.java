package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.SearchRequest;

import java.util.ArrayList;
import java.util.List;

public class AlleleMatrixSearchRequest extends SearchRequest {
	@JsonProperty("callSetDbIds")
	private List<String> callSetDbIds = null;

	@JsonProperty("dataMatrixAbbreviations")
	private List<String> dataMatrixAbbreviations = null;

	@JsonProperty("dataMatrixNames")
	private List<String> dataMatrixNames = null;

	@JsonProperty("expandHomozygotes")
	private Boolean expandHomozygotes = null;

	@JsonProperty("germplasmDbIds")
	private List<String> germplasmDbIds = null;

	@JsonProperty("germplasmNames")
	private List<String> germplasmNames = null;

	@JsonProperty("germplasmPUIs")
	private List<String> germplasmPUIs = null;

	@JsonProperty("pagination")
	private List<AlleleMatrixSearchRequestPagination> pagination = null;

	@JsonProperty("positionRanges")
	private List<String> positionRanges = null;

	@JsonProperty("preview")
	private Boolean preview = false;

	@JsonProperty("sampleDbIds")
	private List<String> sampleDbIds = null;

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

	public AlleleMatrixSearchRequest callSetDbIds(List<String> callSetDbIds) {
		this.callSetDbIds = callSetDbIds;
		return this;
	}

	public AlleleMatrixSearchRequest addCallSetDbIdsItem(String callSetDbIdsItem) {
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

	public AlleleMatrixSearchRequest dataMatrixAbbreviations(List<String> dataMatrixAbbreviations) {
		this.dataMatrixAbbreviations = dataMatrixAbbreviations;
		return this;
	}

	public AlleleMatrixSearchRequest addDataMatrixAbbreviationsItem(String dataMatrixAbbreviationsItem) {
		if (this.dataMatrixAbbreviations == null) {
			this.dataMatrixAbbreviations = new ArrayList<String>();
		}
		this.dataMatrixAbbreviations.add(dataMatrixAbbreviationsItem);
		return this;
	}

	public List<String> getDataMatrixAbbreviations() {
		return dataMatrixAbbreviations;
	}

	public void setDataMatrixAbbreviations(List<String> dataMatrixAbbreviations) {
		this.dataMatrixAbbreviations = dataMatrixAbbreviations;
	}

	public AlleleMatrixSearchRequest dataMatrixNames(List<String> dataMatrixNames) {
		this.dataMatrixNames = dataMatrixNames;
		return this;
	}

	public AlleleMatrixSearchRequest addDataMatrixNamesItem(String dataMatrixNamesItem) {
		if (this.dataMatrixNames == null) {
			this.dataMatrixNames = new ArrayList<String>();
		}
		this.dataMatrixNames.add(dataMatrixNamesItem);
		return this;
	}

	public List<String> getDataMatrixNames() {
		return dataMatrixNames;
	}

	public void setDataMatrixNames(List<String> dataMatrixNames) {
		this.dataMatrixNames = dataMatrixNames;
	}

	public AlleleMatrixSearchRequest expandHomozygotes(Boolean expandHomozygotes) {
		this.expandHomozygotes = expandHomozygotes;
		return this;
	}

	public Boolean isExpandHomozygotes() {
		return expandHomozygotes;
	}

	public void setExpandHomozygotes(Boolean expandHomozygotes) {
		this.expandHomozygotes = expandHomozygotes;
	}

	public AlleleMatrixSearchRequest germplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
		return this;
	}

	public AlleleMatrixSearchRequest addGermplasmDbIdsItem(String germplasmDbIdsItem) {
		if (this.germplasmDbIds == null) {
			this.germplasmDbIds = new ArrayList<String>();
		}
		this.germplasmDbIds.add(germplasmDbIdsItem);
		return this;
	}

	public List<String> getGermplasmDbIds() {
		return germplasmDbIds;
	}

	public void setGermplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
	}

	public AlleleMatrixSearchRequest germplasmNames(List<String> germplasmNames) {
		this.germplasmNames = germplasmNames;
		return this;
	}

	public AlleleMatrixSearchRequest addGermplasmNamesItem(String germplasmNamesItem) {
		if (this.germplasmNames == null) {
			this.germplasmNames = new ArrayList<String>();
		}
		this.germplasmNames.add(germplasmNamesItem);
		return this;
	}

	public List<String> getGermplasmNames() {
		return germplasmNames;
	}

	public void setGermplasmNames(List<String> germplasmNames) {
		this.germplasmNames = germplasmNames;
	}

	public AlleleMatrixSearchRequest germplasmPUIs(List<String> germplasmPUIs) {
		this.germplasmPUIs = germplasmPUIs;
		return this;
	}

	public AlleleMatrixSearchRequest addGermplasmPUIsItem(String germplasmPUIsItem) {
		if (this.germplasmPUIs == null) {
			this.germplasmPUIs = new ArrayList<String>();
		}
		this.germplasmPUIs.add(germplasmPUIsItem);
		return this;
	}

	public List<String> getGermplasmPUIs() {
		return germplasmPUIs;
	}

	public void setGermplasmPUIs(List<String> germplasmPUIs) {
		this.germplasmPUIs = germplasmPUIs;
	}

	public AlleleMatrixSearchRequest pagination(List<AlleleMatrixSearchRequestPagination> pagination) {
		this.pagination = pagination;
		return this;
	}

	public AlleleMatrixSearchRequest addPaginationItem(AlleleMatrixSearchRequestPagination paginationItem) {
		if (this.pagination == null) {
			this.pagination = new ArrayList<AlleleMatrixSearchRequestPagination>();
		}
		this.pagination.add(paginationItem);
		return this;
	}

	public List<AlleleMatrixSearchRequestPagination> getPagination() {
		return pagination;
	}

	public void setPagination(List<AlleleMatrixSearchRequestPagination> pagination) {
		this.pagination = pagination;
	}

	public AlleleMatrixSearchRequest positionRanges(List<String> positionRanges) {
		this.positionRanges = positionRanges;
		return this;
	}

	public AlleleMatrixSearchRequest addPositionRangesItem(String positionRangesItem) {
		if (this.positionRanges == null) {
			this.positionRanges = new ArrayList<String>();
		}
		this.positionRanges.add(positionRangesItem);
		return this;
	}

	public List<String> getPositionRanges() {
		return positionRanges;
	}

	public void setPositionRanges(List<String> positionRanges) {
		this.positionRanges = positionRanges;
	}

	public AlleleMatrixSearchRequest preview(Boolean preview) {
		this.preview = preview;
		return this;
	}

	public Boolean isPreview() {
		return preview;
	}

	public void setPreview(Boolean preview) {
		this.preview = preview;
	}

	public AlleleMatrixSearchRequest sampleDbIds(List<String> sampleDbIds) {
		this.sampleDbIds = sampleDbIds;
		return this;
	}

	public AlleleMatrixSearchRequest addSampleDbIdsItem(String sampleDbIdsItem) {
		if (this.sampleDbIds == null) {
			this.sampleDbIds = new ArrayList<String>();
		}
		this.sampleDbIds.add(sampleDbIdsItem);
		return this;
	}

	public List<String> getSampleDbIds() {
		return sampleDbIds;
	}

	public void setSampleDbIds(List<String> sampleDbIds) {
		this.sampleDbIds = sampleDbIds;
	}

	public AlleleMatrixSearchRequest sepPhased(String sepPhased) {
		this.sepPhased = sepPhased;
		return this;
	}

	public String getSepPhased() {
		return sepPhased;
	}

	public void setSepPhased(String sepPhased) {
		this.sepPhased = sepPhased;
	}

	public AlleleMatrixSearchRequest sepUnphased(String sepUnphased) {
		this.sepUnphased = sepUnphased;
		return this;
	}

	public String getSepUnphased() {
		return sepUnphased;
	}

	public void setSepUnphased(String sepUnphased) {
		this.sepUnphased = sepUnphased;
	}

	public AlleleMatrixSearchRequest unknownString(String unknownString) {
		this.unknownString = unknownString;
		return this;
	}

	public String getUnknownString() {
		return unknownString;
	}

	public void setUnknownString(String unknownString) {
		this.unknownString = unknownString;
	}

	public AlleleMatrixSearchRequest variantDbIds(List<String> variantDbIds) {
		this.variantDbIds = variantDbIds;
		return this;
	}

	public AlleleMatrixSearchRequest addVariantDbIdsItem(String variantDbIdsItem) {
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

	public AlleleMatrixSearchRequest variantSetDbIds(List<String> variantSetDbIds) {
		this.variantSetDbIds = variantSetDbIds;
		return this;
	}

	public AlleleMatrixSearchRequest addVariantSetDbIdsItem(String variantSetDbIdsItem) {
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
		AlleleMatrixSearchRequest alleleMatrixSearchRequest = (AlleleMatrixSearchRequest) o;
		return Objects.equals(this.callSetDbIds, alleleMatrixSearchRequest.callSetDbIds)
				&& Objects.equals(this.dataMatrixAbbreviations, alleleMatrixSearchRequest.dataMatrixAbbreviations)
				&& Objects.equals(this.dataMatrixNames, alleleMatrixSearchRequest.dataMatrixNames)
				&& Objects.equals(this.expandHomozygotes, alleleMatrixSearchRequest.expandHomozygotes)
				&& Objects.equals(this.germplasmDbIds, alleleMatrixSearchRequest.germplasmDbIds)
				&& Objects.equals(this.germplasmNames, alleleMatrixSearchRequest.germplasmNames)
				&& Objects.equals(this.germplasmPUIs, alleleMatrixSearchRequest.germplasmPUIs)
				&& Objects.equals(this.pagination, alleleMatrixSearchRequest.pagination)
				&& Objects.equals(this.positionRanges, alleleMatrixSearchRequest.positionRanges)
				&& Objects.equals(this.preview, alleleMatrixSearchRequest.preview)
				&& Objects.equals(this.sampleDbIds, alleleMatrixSearchRequest.sampleDbIds)
				&& Objects.equals(this.sepPhased, alleleMatrixSearchRequest.sepPhased)
				&& Objects.equals(this.sepUnphased, alleleMatrixSearchRequest.sepUnphased)
				&& Objects.equals(this.unknownString, alleleMatrixSearchRequest.unknownString)
				&& Objects.equals(this.variantDbIds, alleleMatrixSearchRequest.variantDbIds)
				&& Objects.equals(this.variantSetDbIds, alleleMatrixSearchRequest.variantSetDbIds);
	}

	@Override
	public int hashCode() {
		return Objects.hash(callSetDbIds, dataMatrixAbbreviations, dataMatrixNames, expandHomozygotes, germplasmDbIds,
				germplasmNames, germplasmPUIs, pagination, positionRanges, preview, sampleDbIds, sepPhased, sepUnphased,
				unknownString, variantDbIds, variantSetDbIds);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AlleleMatrixSearchRequest {\n");

		sb.append("    callSetDbIds: ").append(toIndentedString(callSetDbIds)).append("\n");
		sb.append("    dataMatrixAbbreviations: ").append(toIndentedString(dataMatrixAbbreviations)).append("\n");
		sb.append("    dataMatrixNames: ").append(toIndentedString(dataMatrixNames)).append("\n");
		sb.append("    expandHomozygotes: ").append(toIndentedString(expandHomozygotes)).append("\n");
		sb.append("    germplasmDbIds: ").append(toIndentedString(germplasmDbIds)).append("\n");
		sb.append("    germplasmNames: ").append(toIndentedString(germplasmNames)).append("\n");
		sb.append("    germplasmPUIs: ").append(toIndentedString(germplasmPUIs)).append("\n");
		sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
		sb.append("    positionRanges: ").append(toIndentedString(positionRanges)).append("\n");
		sb.append("    preview: ").append(toIndentedString(preview)).append("\n");
		sb.append("    sampleDbIds: ").append(toIndentedString(sampleDbIds)).append("\n");
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
		if (this.dataMatrixAbbreviations != null)
			count += this.dataMatrixAbbreviations.size();
		if (this.dataMatrixNames != null)
			count += this.dataMatrixNames.size();
		if (this.expandHomozygotes != null)
			count += 1;
		if (this.germplasmDbIds != null)
			count += this.germplasmDbIds.size();
		if (this.germplasmNames != null)
			count += this.germplasmNames.size();
		if (this.germplasmPUIs != null)
			count += this.germplasmPUIs.size();
		if (this.pagination != null)
			count += this.pagination.size();
		if (this.positionRanges != null)
			count += this.positionRanges.size();
		if (this.preview != null)
			count += 1;
		if (this.sampleDbIds != null)
			count += this.sampleDbIds.size();
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
