package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SearchRequest;
import io.swagger.model.SearchRequestParametersPaging;

import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * ListSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class ListSearchRequest extends SearchRequestParametersPaging implements SearchRequest {
	@JsonProperty("externalReferenceIDs")
	@Valid
	private List<String> externalReferenceIDs = null;

	@JsonProperty("externalReferenceSources")
	@Valid
	private List<String> externalReferenceSources = null;

	@JsonProperty("dateCreatedRangeEnd")
	private OffsetDateTime dateCreatedRangeEnd = null;

	@JsonProperty("dateCreatedRangeStart")
	private OffsetDateTime dateCreatedRangeStart = null;

	@JsonProperty("dateModifiedRangeEnd")
	private OffsetDateTime dateModifiedRangeEnd = null;

	@JsonProperty("dateModifiedRangeStart")
	private OffsetDateTime dateModifiedRangeStart = null;

	@JsonProperty("listDbIds")
	@Valid
	private List<String> listDbIds = null;

	@JsonProperty("listNames")
	@Valid
	private List<String> listNames = null;

	@JsonProperty("listOwnerNames")
	@Valid
	private List<String> listOwnerNames = null;

	@JsonProperty("listOwnerPersonDbIds")
	@Valid
	private List<String> listOwnerPersonDbIds = null;

	@JsonProperty("listSources")
	@Valid
	private List<String> listSources = null;

	@JsonProperty("listType")
	private ListTypes listType = null;

	public ListSearchRequest externalReferenceIDs(List<String> externalReferenceIDs) {
		this.externalReferenceIDs = externalReferenceIDs;
		return this;
	}

	public ListSearchRequest addExternalReferenceIDsItem(String externalReferenceIDsItem) {
		if (this.externalReferenceIDs == null) {
			this.externalReferenceIDs = new ArrayList<String>();
		}
		this.externalReferenceIDs.add(externalReferenceIDsItem);
		return this;
	}

	/**
	 * List of external references for the trait to search for
	 * 
	 * @return externalReferenceIDs
	 **/
	@ApiModelProperty(example = "[\"http://purl.obolibrary.org/obo/ro.owl\",\"14a19841\"]", value = "List of external references for the trait to search for")

	public List<String> getExternalReferenceIDs() {
		return externalReferenceIDs;
	}

	public void setExternalReferenceIDs(List<String> externalReferenceIDs) {
		this.externalReferenceIDs = externalReferenceIDs;
	}

	public ListSearchRequest externalReferenceSources(List<String> externalReferenceSources) {
		this.externalReferenceSources = externalReferenceSources;
		return this;
	}

	public ListSearchRequest addExternalReferenceSourcesItem(String externalReferenceSourcesItem) {
		if (this.externalReferenceSources == null) {
			this.externalReferenceSources = new ArrayList<String>();
		}
		this.externalReferenceSources.add(externalReferenceSourcesItem);
		return this;
	}

	/**
	 * List of external references sources for the trait to search for
	 * 
	 * @return externalReferenceSources
	 **/
	@ApiModelProperty(example = "[\"OBO Library\",\"Field App Name\"]", value = "List of external references sources for the trait to search for")

	public List<String> getExternalReferenceSources() {
		return externalReferenceSources;
	}

	public void setExternalReferenceSources(List<String> externalReferenceSources) {
		this.externalReferenceSources = externalReferenceSources;
	}

	public ListSearchRequest dateCreatedRangeEnd(OffsetDateTime dateCreatedRangeEnd) {
		this.dateCreatedRangeEnd = dateCreatedRangeEnd;
		return this;
	}

	/**
	 * Get dateCreatedRangeEnd
	 * 
	 * @return dateCreatedRangeEnd
	 **/
	@ApiModelProperty(value = "")

	@Valid
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

	/**
	 * Get dateCreatedRangeStart
	 * 
	 * @return dateCreatedRangeStart
	 **/
	@ApiModelProperty(value = "")

	@Valid
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

	/**
	 * Get dateModifiedRangeEnd
	 * 
	 * @return dateModifiedRangeEnd
	 **/
	@ApiModelProperty(value = "")

	@Valid
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

	/**
	 * Get dateModifiedRangeStart
	 * 
	 * @return dateModifiedRangeStart
	 **/
	@ApiModelProperty(value = "")

	@Valid
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

	/**
	 * Get listDbIds
	 * 
	 * @return listDbIds
	 **/
	@ApiModelProperty(example = "[\"55f20cf6\",\"3193ca3d\"]", value = "")

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

	/**
	 * Get listNames
	 * 
	 * @return listNames
	 **/
	@ApiModelProperty(example = "[\"Planing List 1\",\"Bobs List\"]", value = "")

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

	/**
	 * Get listOwnerNames
	 * 
	 * @return listOwnerNames
	 **/
	@ApiModelProperty(example = "[\"Bob Robertson\",\"Rob Robertson\"]", value = "")

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

	/**
	 * Get listOwnerPersonDbIds
	 * 
	 * @return listOwnerPersonDbIds
	 **/
	@ApiModelProperty(example = "[\"bob@bob.com\",\"rob@bob.com\"]", value = "")

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

	/**
	 * Get listSources
	 * 
	 * @return listSources
	 **/
	@ApiModelProperty(example = "[\"USER\",\"SYSTEM\",\"EXTERNAL\"]", value = "")

	public List<String> getListSources() {
		return listSources;
	}

	public void setListSources(List<String> listSources) {
		this.listSources = listSources;
	}

	public ListSearchRequest listType(ListTypes listType) {
		this.listType = listType;
		return this;
	}

	/**
	 * Get listType
	 * 
	 * @return listType
	 **/
	@ApiModelProperty(value = "")

	@Valid
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
		return Objects.equals(this.externalReferenceIDs, listSearchRequest.externalReferenceIDs)
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
		return Objects.hash(externalReferenceIDs, externalReferenceSources, dateCreatedRangeEnd, dateCreatedRangeStart,
				dateModifiedRangeEnd, dateModifiedRangeStart, listDbIds, listNames, listOwnerNames,
				listOwnerPersonDbIds, listSources, listType, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ListSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    externalReferenceIDs: ").append(toIndentedString(externalReferenceIDs)).append("\n");
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
		if (this.externalReferenceIDs != null) {
			count += this.externalReferenceIDs.size();
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
