package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;

public class ListSearchRequest extends SearchRequest {
	@JsonProperty("dateCreatedRangeEnd")
	private OffsetDateTime dateCreatedRangeEnd = null;

	@JsonProperty("dateCreatedRangeStart")
	private OffsetDateTime dateCreatedRangeStart = null;

	@JsonProperty("dateModifiedRangeEnd")
	private OffsetDateTime dateModifiedRangeEnd = null;

	@JsonProperty("dateModifiedRangeStart")
	private OffsetDateTime dateModifiedRangeStart = null;

	@JsonProperty("listDbIds")
	private List<String> listDbIds = null;

	@JsonProperty("listNames")
	private List<String> listNames = null;

	@JsonProperty("listOwnerNames")
	private List<String> listOwnerNames = null;

	@JsonProperty("listOwnerPersonDbIds")
	private List<String> listOwnerPersonDbIds = null;

	@JsonProperty("listSources")
	private List<String> listSources = null;

	@JsonProperty("programDbIds")
	private List<String> programDbIds = null;

	@JsonProperty("commonCropNames")
	private List<String> commonCropNames = null;

	@JsonProperty("listType")
	private ListTypes listType = null;

	public ListSearchRequest dateCreatedRangeEnd(OffsetDateTime dateCreatedRangeEnd) {
		this.dateCreatedRangeEnd = dateCreatedRangeEnd;
		return this;
	}

	public OffsetDateTime getDateCreatedRangeEnd() {
		return dateCreatedRangeEnd;
	}

	public void setDateCreatedRangeEnd(OffsetDateTime dateCreatedRangeEnd) {
		this.dateCreatedRangeEnd = dateCreatedRangeEnd;
	}

	public ListSearchRequest dateCreatedRangeStart(OffsetDateTime dateCreatedRangeStart) {
		this.dateCreatedRangeStart = dateCreatedRangeStart;
		return this;
	}

	public OffsetDateTime getDateCreatedRangeStart() {
		return dateCreatedRangeStart;
	}

	public void setDateCreatedRangeStart(OffsetDateTime dateCreatedRangeStart) {
		this.dateCreatedRangeStart = dateCreatedRangeStart;
	}

	public ListSearchRequest dateModifiedRangeEnd(OffsetDateTime dateModifiedRangeEnd) {
		this.dateModifiedRangeEnd = dateModifiedRangeEnd;
		return this;
	}

	public OffsetDateTime getDateModifiedRangeEnd() {
		return dateModifiedRangeEnd;
	}

	public void setDateModifiedRangeEnd(OffsetDateTime dateModifiedRangeEnd) {
		this.dateModifiedRangeEnd = dateModifiedRangeEnd;
	}

	public ListSearchRequest dateModifiedRangeStart(OffsetDateTime dateModifiedRangeStart) {
		this.dateModifiedRangeStart = dateModifiedRangeStart;
		return this;
	}

	public OffsetDateTime getDateModifiedRangeStart() {
		return dateModifiedRangeStart;
	}

	public void setDateModifiedRangeStart(OffsetDateTime dateModifiedRangeStart) {
		this.dateModifiedRangeStart = dateModifiedRangeStart;
	}

	public ListSearchRequest listDbIds(List<String> listDbIds) {
		this.listDbIds = listDbIds;
		return this;
	}

	public ListSearchRequest addListDbIdsItem(String listDbIdsItem) {
		if (this.listDbIds == null) {
			this.listDbIds = new ArrayList<String>();
		}
		this.listDbIds.add(listDbIdsItem);
		return this;
	}

	public List<String> getListDbIds() {
		return listDbIds;
	}

	public void setListDbIds(List<String> listDbIds) {
		this.listDbIds = listDbIds;
	}

	public ListSearchRequest listNames(List<String> listNames) {
		this.listNames = listNames;
		return this;
	}

	public ListSearchRequest addListNamesItem(String listNamesItem) {
		if (this.listNames == null) {
			this.listNames = new ArrayList<String>();
		}
		this.listNames.add(listNamesItem);
		return this;
	}

	public List<String> getListNames() {
		return listNames;
	}

	public void setListNames(List<String> listNames) {
		this.listNames = listNames;
	}

	public ListSearchRequest listOwnerNames(List<String> listOwnerNames) {
		this.listOwnerNames = listOwnerNames;
		return this;
	}

	public ListSearchRequest addListOwnerNamesItem(String listOwnerNamesItem) {
		if (this.listOwnerNames == null) {
			this.listOwnerNames = new ArrayList<String>();
		}
		this.listOwnerNames.add(listOwnerNamesItem);
		return this;
	}

	public List<String> getListOwnerNames() {
		return listOwnerNames;
	}

	public void setListOwnerNames(List<String> listOwnerNames) {
		this.listOwnerNames = listOwnerNames;
	}

	public ListSearchRequest listOwnerPersonDbIds(List<String> listOwnerPersonDbIds) {
		this.listOwnerPersonDbIds = listOwnerPersonDbIds;
		return this;
	}

	public ListSearchRequest addListOwnerPersonDbIdsItem(String listOwnerPersonDbIdsItem) {
		if (this.listOwnerPersonDbIds == null) {
			this.listOwnerPersonDbIds = new ArrayList<String>();
		}
		this.listOwnerPersonDbIds.add(listOwnerPersonDbIdsItem);
		return this;
	}

	public List<String> getListOwnerPersonDbIds() {
		return listOwnerPersonDbIds;
	}

	public void setListOwnerPersonDbIds(List<String> listOwnerPersonDbIds) {
		this.listOwnerPersonDbIds = listOwnerPersonDbIds;
	}

	public ListSearchRequest listSources(List<String> listSources) {
		this.listSources = listSources;
		return this;
	}

	public ListSearchRequest addListSourcesItem(String listSourcesItem) {
		if (this.listSources == null) {
			this.listSources = new ArrayList<String>();
		}
		this.listSources.add(listSourcesItem);
		return this;
	}

	public List<String> getListSources() {
		return listSources;
	}

	public void setListSources(List<String> listSources) {
		this.listSources = listSources;
	}

	public ListSearchRequest programDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
		return this;
	}

	public ListSearchRequest addprogramDbIdsItem(String programDbIdsItem) {
		if (this.programDbIds == null) {
			this.programDbIds = new ArrayList<String>();
		}
		this.programDbIds.add(programDbIdsItem);
		return this;
	}

	public List<String> getProgramDbIds() {
		return programDbIds;
	}

	public void setProgramDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
	}

	public ListSearchRequest commonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
		return this;
	}

	public ListSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
		if (this.commonCropNames == null) {
			this.commonCropNames = new ArrayList<String>();
		}
		this.commonCropNames.add(commonCropNamesItem);
		return this;
	}

	public List<String> getCommonCropNames() {
		return commonCropNames;
	}

	public void setCommonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
	}

	public ListSearchRequest listType(ListTypes listType) {
		this.listType = listType;
		return this;
	}

	public ListTypes getListType() {
		return listType;
	}

	public void setListType(ListTypes listType) {
		this.listType = listType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ListSearchRequest listSearchRequest = (ListSearchRequest) o;
		return Objects.equals(this.externalReferenceIds, listSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources, listSearchRequest.externalReferenceSources)
				&& Objects.equals(this.dateCreatedRangeEnd, listSearchRequest.dateCreatedRangeEnd)
				&& Objects.equals(this.dateCreatedRangeStart, listSearchRequest.dateCreatedRangeStart)
				&& Objects.equals(this.dateModifiedRangeEnd, listSearchRequest.dateModifiedRangeEnd)
				&& Objects.equals(this.dateModifiedRangeStart, listSearchRequest.dateModifiedRangeStart)
				&& Objects.equals(this.listDbIds, listSearchRequest.listDbIds)
				&& Objects.equals(this.listNames, listSearchRequest.listNames)
				&& Objects.equals(this.listOwnerNames, listSearchRequest.listOwnerNames)
				&& Objects.equals(this.listOwnerPersonDbIds, listSearchRequest.listOwnerPersonDbIds)
				&& Objects.equals(this.listSources, listSearchRequest.listSources)
				&& Objects.equals(this.listType, listSearchRequest.listType) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(externalReferenceIds, externalReferenceSources, dateCreatedRangeEnd, dateCreatedRangeStart,
				dateModifiedRangeEnd, dateModifiedRangeStart, listDbIds, listNames, listOwnerNames,
				listOwnerPersonDbIds, listSources, listType, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ListSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    externalReferenceIDs: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    dateCreatedRangeEnd: ").append(toIndentedString(dateCreatedRangeEnd)).append("\n");
		sb.append("    dateCreatedRangeStart: ").append(toIndentedString(dateCreatedRangeStart)).append("\n");
		sb.append("    dateModifiedRangeEnd: ").append(toIndentedString(dateModifiedRangeEnd)).append("\n");
		sb.append("    dateModifiedRangeStart: ").append(toIndentedString(dateModifiedRangeStart)).append("\n");
		sb.append("    listDbIds: ").append(toIndentedString(listDbIds)).append("\n");
		sb.append("    listNames: ").append(toIndentedString(listNames)).append("\n");
		sb.append("    listOwnerNames: ").append(toIndentedString(listOwnerNames)).append("\n");
		sb.append("    listOwnerPersonDbIds: ").append(toIndentedString(listOwnerPersonDbIds)).append("\n");
		sb.append("    listSources: ").append(toIndentedString(listSources)).append("\n");
		sb.append("    listType: ").append(toIndentedString(listType)).append("\n");
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
		if (this.externalReferenceIds != null) {
			count += this.externalReferenceIds.size();
		}
		if (this.externalReferenceSources != null) {
			count += this.externalReferenceSources.size();
		}
		if (this.dateCreatedRangeEnd != null) {
			count += 1;
		}
		if (this.dateCreatedRangeStart != null) {
			count += 1;
		}
		if (this.dateModifiedRangeEnd != null) {
			count += 1;
		}
		if (this.dateModifiedRangeStart != null) {
			count += 1;
		}
		if (this.listDbIds != null) {
			count += this.listDbIds.size();
		}
		if (this.listNames != null) {
			count += this.listNames.size();
		}
		if (this.listOwnerNames != null) {
			count += this.listOwnerNames.size();
		}
		if (this.listOwnerPersonDbIds != null) {
			count += this.listOwnerPersonDbIds.size();
		}
		if (this.listSources != null) {
			count += this.listSources.size();
		}
		if (this.listType != null) {
			count += 1;
		}
		return count;
	}
}
