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
 * MarkerPositionSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class MarkerPositionSearchRequest extends SearchRequestParametersPaging implements SearchRequest {
	@JsonProperty("linkageGroupNames")
	@Valid
	private List<String> linkageGroupNames = null;

	@JsonProperty("mapDbIds")
	@Valid
	private List<String> mapDbIds = null;

	@JsonProperty("maxPosition")
	private Integer maxPosition = null;

	@JsonProperty("minPosition")
	private Integer minPosition = null;

	@JsonProperty("variantDbIds")
	@Valid
	private List<String> variantDbIds = null;

	public MarkerPositionSearchRequest linkageGroupNames(List<String> linkageGroupNames) {
		this.linkageGroupNames = linkageGroupNames;
		return this;
	}

	public MarkerPositionSearchRequest addLinkageGroupNamesItem(String linkageGroupNamesItem) {
		if (this.linkageGroupNames == null) {
			this.linkageGroupNames = new ArrayList<String>();
		}
		this.linkageGroupNames.add(linkageGroupNamesItem);
		return this;
	}

	/**
	 * The Uniquely Identifiable name of this linkage group
	 * 
	 * @return linkageGroupNames
	 **/
	@ApiModelProperty(example = "[\"Chromosome 2\",\"Chromosome 3\"]", value = "The Uniquely Identifiable name of this linkage group")

	public List<String> getLinkageGroupNames() {
		return linkageGroupNames;
	}

	public void setLinkageGroupNames(List<String> linkageGroupNames) {
		this.linkageGroupNames = linkageGroupNames;
	}

	public MarkerPositionSearchRequest mapDbIds(List<String> mapDbIds) {
		this.mapDbIds = mapDbIds;
		return this;
	}

	public MarkerPositionSearchRequest addMapDbIdsItem(String mapDbIdsItem) {
		if (this.mapDbIds == null) {
			this.mapDbIds = new ArrayList<String>();
		}
		this.mapDbIds.add(mapDbIdsItem);
		return this;
	}

	/**
	 * The unique ID of the map
	 * 
	 * @return mapDbIds
	 **/
	@ApiModelProperty(example = "[\"7e6fa8aa\",\"bedc418c\"]", value = "The unique ID of the map")

	public List<String> getMapDbIds() {
		return mapDbIds;
	}

	public void setMapDbIds(List<String> mapDbIds) {
		this.mapDbIds = mapDbIds;
	}

	public MarkerPositionSearchRequest maxPosition(Integer maxPosition) {
		this.maxPosition = maxPosition;
		return this;
	}

	/**
	 * The maximum position
	 * 
	 * @return maxPosition
	 **/
	@ApiModelProperty(example = "4000", value = "The maximum position")

	public Integer getMaxPosition() {
		return maxPosition;
	}

	public void setMaxPosition(Integer maxPosition) {
		this.maxPosition = maxPosition;
	}

	public MarkerPositionSearchRequest minPosition(Integer minPosition) {
		this.minPosition = minPosition;
		return this;
	}

	/**
	 * The minimum position
	 * 
	 * @return minPosition
	 **/
	@ApiModelProperty(example = "250", value = "The minimum position")

	public Integer getMinPosition() {
		return minPosition;
	}

	public void setMinPosition(Integer minPosition) {
		this.minPosition = minPosition;
	}

	public MarkerPositionSearchRequest variantDbIds(List<String> variantDbIds) {
		this.variantDbIds = variantDbIds;
		return this;
	}

	public MarkerPositionSearchRequest addVariantDbIdsItem(String variantDbIdsItem) {
		if (this.variantDbIds == null) {
			this.variantDbIds = new ArrayList<String>();
		}
		this.variantDbIds.add(variantDbIdsItem);
		return this;
	}

	/**
	 * Internal db identifier
	 * 
	 * @return variantDbIds
	 **/
	@ApiModelProperty(example = "[\"a0caa928\",\"f8894a26\"]", value = "Internal db identifier")

	public List<String> getVariantDbIds() {
		return variantDbIds;
	}

	public void setVariantDbIds(List<String> variantDbIds) {
		this.variantDbIds = variantDbIds;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MarkerPositionSearchRequest markerPositionSearchRequest = (MarkerPositionSearchRequest) o;
		return Objects.equals(this.linkageGroupNames, markerPositionSearchRequest.linkageGroupNames)
				&& Objects.equals(this.mapDbIds, markerPositionSearchRequest.mapDbIds)
				&& Objects.equals(this.maxPosition, markerPositionSearchRequest.maxPosition)
				&& Objects.equals(this.minPosition, markerPositionSearchRequest.minPosition)
				&& Objects.equals(this.variantDbIds, markerPositionSearchRequest.variantDbIds) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(linkageGroupNames, mapDbIds, maxPosition, minPosition, variantDbIds, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MarkerPositionSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    linkageGroupNames: ").append(toIndentedString(linkageGroupNames)).append("\n");
		sb.append("    mapDbIds: ").append(toIndentedString(mapDbIds)).append("\n");
		sb.append("    maxPosition: ").append(toIndentedString(maxPosition)).append("\n");
		sb.append("    minPosition: ").append(toIndentedString(minPosition)).append("\n");
		sb.append("    variantDbIds: ").append(toIndentedString(variantDbIds)).append("\n");
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
		if (this.linkageGroupNames != null)
			count += this.linkageGroupNames.size();
		if (this.mapDbIds != null)
			count += this.mapDbIds.size();
		if (this.maxPosition != null)
			count += 1;
		if (this.minPosition != null)
			count += 1;
		if (this.variantDbIds != null)
			count += this.variantDbIds.size();
		return count;
	}
}
