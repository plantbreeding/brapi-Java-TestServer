package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;

public class ReferencesSearchRequest extends SearchRequest {
	@JsonProperty("accessions")
	private List<String> accessions = null;

	@JsonProperty("isDerived")
	private Boolean isDerived = null;

	@JsonProperty("maxLength")
	private Integer maxLength = null;

	@JsonProperty("md5checksums")
	private List<String> md5checksums = null;

	@JsonProperty("minLength")
	private Integer minLength = null;

	@JsonProperty("referenceDbIds")
	private List<String> referenceDbIds = null;

	@JsonProperty("referenceSetDbIds")
	private List<String> referenceSetDbIds = null;

	public ReferencesSearchRequest accessions(List<String> accessions) {
		this.accessions = accessions;
		return this;
	}

	public ReferencesSearchRequest addAccessionsItem(String accessionsItem) {
		if (this.accessions == null) {
			this.accessions = new ArrayList<String>();
		}
		this.accessions.add(accessionsItem);
		return this;
	}

	public List<String> getAccessions() {
		return accessions;
	}

	public void setAccessions(List<String> accessions) {
		this.accessions = accessions;
	}

	public ReferencesSearchRequest isDerived(Boolean isDerived) {
		this.isDerived = isDerived;
		return this;
	}

	public Boolean isIsDerived() {
		return isDerived;
	}

	public void setIsDerived(Boolean isDerived) {
		this.isDerived = isDerived;
	}

	public ReferencesSearchRequest maxLength(Integer maxLength) {
		this.maxLength = maxLength;
		return this;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public ReferencesSearchRequest md5checksums(List<String> md5checksums) {
		this.md5checksums = md5checksums;
		return this;
	}

	public ReferencesSearchRequest addMd5checksumsItem(String md5checksumsItem) {
		if (this.md5checksums == null) {
			this.md5checksums = new ArrayList<String>();
		}
		this.md5checksums.add(md5checksumsItem);
		return this;
	}

	public List<String> getMd5checksums() {
		return md5checksums;
	}

	public void setMd5checksums(List<String> md5checksums) {
		this.md5checksums = md5checksums;
	}

	public ReferencesSearchRequest minLength(Integer minLength) {
		this.minLength = minLength;
		return this;
	}

	public Integer getMinLength() {
		return minLength;
	}

	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}

	public ReferencesSearchRequest referenceDbIds(List<String> referenceDbIds) {
		this.referenceDbIds = referenceDbIds;
		return this;
	}

	public ReferencesSearchRequest addReferenceDbIdsItem(String referenceDbIdsItem) {
		if (this.referenceDbIds == null) {
			this.referenceDbIds = new ArrayList<String>();
		}
		this.referenceDbIds.add(referenceDbIdsItem);
		return this;
	}

	public List<String> getReferenceDbIds() {
		return referenceDbIds;
	}

	public void setReferenceDbIds(List<String> referenceDbIds) {
		this.referenceDbIds = referenceDbIds;
	}

	public ReferencesSearchRequest referenceSetDbIds(List<String> referenceSetDbIds) {
		this.referenceSetDbIds = referenceSetDbIds;
		return this;
	}

	public ReferencesSearchRequest addReferenceSetDbIdsItem(String referenceSetDbIdsItem) {
		if (this.referenceSetDbIds == null) {
			this.referenceSetDbIds = new ArrayList<String>();
		}
		this.referenceSetDbIds.add(referenceSetDbIdsItem);
		return this;
	}

	public List<String> getReferenceSetDbIds() {
		return referenceSetDbIds;
	}

	public void setReferenceSetDbIds(List<String> referenceSetDbIds) {
		this.referenceSetDbIds = referenceSetDbIds;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ReferencesSearchRequest referencesSearchRequest = (ReferencesSearchRequest) o;
		return Objects.equals(this.accessions, referencesSearchRequest.accessions)
				&& Objects.equals(this.isDerived, referencesSearchRequest.isDerived)
				&& Objects.equals(this.maxLength, referencesSearchRequest.maxLength)
				&& Objects.equals(this.md5checksums, referencesSearchRequest.md5checksums)
				&& Objects.equals(this.minLength, referencesSearchRequest.minLength)
				&& Objects.equals(this.referenceDbIds, referencesSearchRequest.referenceDbIds)
				&& Objects.equals(this.referenceSetDbIds, referencesSearchRequest.referenceSetDbIds) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessions, isDerived, maxLength, md5checksums, minLength, referenceDbIds,
				referenceSetDbIds, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ReferencesSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    accessions: ").append(toIndentedString(accessions)).append("\n");
		sb.append("    isDerived: ").append(toIndentedString(isDerived)).append("\n");
		sb.append("    maxLength: ").append(toIndentedString(maxLength)).append("\n");
		sb.append("    md5checksums: ").append(toIndentedString(md5checksums)).append("\n");
		sb.append("    minLength: ").append(toIndentedString(minLength)).append("\n");
		sb.append("    referenceDbIds: ").append(toIndentedString(referenceDbIds)).append("\n");
		sb.append("    referenceSetDbIds: ").append(toIndentedString(referenceSetDbIds)).append("\n");
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
		if (this.accessions != null)
			count += this.accessions.size();
		if (this.isDerived != null)
			count += 1;
		if (this.maxLength != null)
			count += 1;
		if (this.md5checksums != null)
			count += this.md5checksums.size();
		if (this.minLength != null)
			count += 1;
		if (this.referenceDbIds != null)
			count += this.referenceDbIds.size();
		if (this.referenceSetDbIds != null)
			count += this.referenceSetDbIds.size();
		return count;
	}
}
