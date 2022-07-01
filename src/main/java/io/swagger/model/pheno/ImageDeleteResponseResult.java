package io.swagger.model.pheno;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIResponseResult;

import java.util.ArrayList;
import java.util.List;

public class ImageDeleteResponseResult implements BrAPIResponseResult<String>{
	@JsonProperty("imageDbIds")

	private List<String> imageDbIds = new ArrayList<String>();

	public ImageDeleteResponseResult imageDbIds(List<String> imageDbIds) {
		this.imageDbIds = imageDbIds;
		return this;
	}

	public ImageDeleteResponseResult addImageDbIdsItem(String imageDbIdsItem) {
		this.imageDbIds.add(imageDbIdsItem);
		return this;
	}

	public List<String> getImageDbIds() {
		return imageDbIds;
	}

	public void setImageDbIds(List<String> imageDbIds) {
		this.imageDbIds = imageDbIds;
	}

	@Override
	@JsonIgnore
	public List<String> getData() {
		return imageDbIds;
	}

	@Override
	@JsonIgnore
	public void setData(List<String> data) {
		this.imageDbIds = data;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ImageDeleteResponseResult imageDeleteResponseResult = (ImageDeleteResponseResult) o;
		return Objects.equals(this.imageDbIds, imageDeleteResponseResult.imageDbIds);
	}

	@Override
	public int hashCode() {
		return Objects.hash(imageDbIds);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ImageDeleteResponseResult {\n");

		sb.append("    imageDbIds: ").append(toIndentedString(imageDbIds)).append("\n");
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
