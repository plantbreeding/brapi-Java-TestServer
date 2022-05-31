package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SearchRequest;
import io.swagger.model.SearchRequestParametersPaging;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * ReferencesSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-24T19:42:22.574Z[GMT]")
public class ReferencesSearchRequest extends SearchRequestParametersPaging implements SearchRequest {
	@JsonProperty("accessions")
	@Valid
	private List<String> accessions = null;

	@JsonProperty("isDerived")
	private Boolean isDerived = null;

	@JsonProperty("maxLength")
	private Integer maxLength = null;

	@JsonProperty("md5checksums")
	@Valid
	private List<String> md5checksums = null;

	@JsonProperty("minLength")
	private Integer minLength = null;

	@JsonProperty("referenceDbIds")
	@Valid
	private List<String> referenceDbIds = null;

	@JsonProperty("referenceSetDbIds")
	@Valid
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

	/**
	 * If specified, return the references for which the `accession` matches this
	 * string (case-sensitive, exact match).
	 * 
	 * @return accessions
	 **/
	@ApiModelProperty(example = "[\"A0009283\",\"A0006657\"]", value = "If specified, return the references for which the `accession` matches this string (case-sensitive, exact match).")

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

	/**
	 * A sequence X is said to be derived from source sequence Y, if X and Y are of
	 * the same length and the per-base sequence divergence at A/C/G/T bases is
	 * sufficiently small. Two sequences derived from the same official sequence
	 * share the same coordinates and annotations, and can be replaced with the
	 * official sequence for certain use cases.
	 * 
	 * @return isDerived
	 **/
	@ApiModelProperty(value = "A sequence X is said to be derived from source sequence Y, if X and Y are of the same length and the per-base sequence divergence at A/C/G/T bases is sufficiently small. Two sequences derived from the same official sequence share the same coordinates and annotations, and can be replaced with the official sequence for certain use cases.")

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

	/**
	 * The minimum length of this reference's sequence.
	 * 
	 * @return maxLength
	 **/
	@ApiModelProperty(example = "90000", value = "The minimum length of this reference's sequence.")

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

	/**
	 * If specified, return the references for which the `md5checksum` matches this
	 * string (case-sensitive, exact match).
	 * 
	 * @return md5checksums
	 **/
	@ApiModelProperty(example = "[\"c2365e900c81a89cf74d83dab60df146\"]", value = "If specified, return the references for which the `md5checksum` matches this string (case-sensitive, exact match).")

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

	/**
	 * The minimum length of this reference's sequence.
	 * 
	 * @return minLength
	 **/
	@ApiModelProperty(example = "4000", value = "The minimum length of this reference's sequence.")

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

	/**
	 * The `References` to search.
	 * 
	 * @return referenceDbIds
	 **/
	@ApiModelProperty(example = "[\"04c83ea7\",\"d0998a34\"]", value = "The `References` to search.")

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

	/**
	 * The `ReferenceSets` to search.
	 * 
	 * @return referenceSetDbIds
	 **/
	@ApiModelProperty(example = "[\"32a19dd7\",\"2c182c18\"]", value = "The `ReferenceSets` to search.")

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
