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
 * ReferenceSetsSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-24T19:42:22.574Z[GMT]")
public class ReferenceSetsSearchRequest extends SearchRequestParametersPaging implements SearchRequest {
	@JsonProperty("accessions")
	@Valid
	private List<String> accessions = null;

	@JsonProperty("assemblyPUIs")
	@Valid
	private List<String> assemblyPUIs = null;

	@JsonProperty("md5checksum")
	@Valid
	private List<String> md5checksums = null;

	@JsonProperty("referenceSetDbIds")
	@Valid
	private List<String> referenceSetDbIds = null;

	public ReferenceSetsSearchRequest accessions(List<String> accessions) {
		this.accessions = accessions;
		return this;
	}

	public ReferenceSetsSearchRequest addAccessionsItem(String accessionsItem) {
		if (this.accessions == null) {
			this.accessions = new ArrayList<String>();
		}
		this.accessions.add(accessionsItem);
		return this;
	}

	/**
	 * If set, return the reference sets for which the `accession` matches this
	 * string (case-sensitive, exact match).
	 * 
	 * @return accession
	 **/
	@ApiModelProperty(example = "[\"A0009283\",\"A0006657\"]", value = "If set, return the reference sets for which the `accession` matches this string (case-sensitive, exact match).")

	public List<String> getAccessions() {
		return accessions;
	}

	public void setAccessions(List<String> accessions) {
		this.accessions = accessions;
	}

	public ReferenceSetsSearchRequest assemblyPUIs(List<String> assemblyPUIs) {
		this.assemblyPUIs = assemblyPUIs;
		return this;
	}

	public ReferenceSetsSearchRequest addAssemblyPUIsItem(String assemblyPUIsItem) {
		if (this.assemblyPUIs == null) {
			this.assemblyPUIs = new ArrayList<String>();
		}
		this.assemblyPUIs.add(assemblyPUIsItem);
		return this;
	}

	/**
	 * If set, return the reference sets for which the `assemblyId` matches this
	 * string (case-sensitive, exact match).
	 * 
	 * @return assemblyPUI
	 **/
	@ApiModelProperty(example = "[\"doi:10.15454/312953986E3\",\"doi:10.15454/312953986E3\"]", value = "If set, return the reference sets for which the `assemblyId` matches this string (case-sensitive, exact match).")

	public List<String> getAssemblyPUIs() {
		return assemblyPUIs;
	}

	public void setAssemblyPUIs(List<String> assemblyPUIs) {
		this.assemblyPUIs = assemblyPUIs;
	}

	public ReferenceSetsSearchRequest md5checksums(List<String> md5checksums) {
		this.md5checksums = md5checksums;
		return this;
	}

	public ReferenceSetsSearchRequest addMd5checksumsItem(String md5checksumsItem) {
		if (this.md5checksums == null) {
			this.md5checksums = new ArrayList<String>();
		}
		this.md5checksums.add(md5checksumsItem);
		return this;
	}

	/**
	 * If set, return the reference sets for which the `md5checksum` matches this
	 * string (case-sensitive, exact match).
	 * 
	 * @return md5checksum
	 **/
	@ApiModelProperty(example = "[\"c2365e900c81a89cf74d83dab60df146\"]", value = "If set, return the reference sets for which the `md5checksum` matches this string (case-sensitive, exact match).")

	public List<String> getMd5checksums() {
		return md5checksums;
	}

	public void setMd5checksums(List<String> md5checksums) {
		this.md5checksums = md5checksums;
	}

	public ReferenceSetsSearchRequest referenceSetDbIds(List<String> referenceSetDbIds) {
		this.referenceSetDbIds = referenceSetDbIds;
		return this;
	}

	public ReferenceSetsSearchRequest addReferenceSetDbIdsItem(String referenceSetDbIdsItem) {
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
		ReferenceSetsSearchRequest referenceSetsSearchRequest = (ReferenceSetsSearchRequest) o;
		return Objects.equals(this.accessions, referenceSetsSearchRequest.accessions)
				&& Objects.equals(this.assemblyPUIs, referenceSetsSearchRequest.assemblyPUIs)
				&& Objects.equals(this.md5checksums, referenceSetsSearchRequest.md5checksums)
				&& Objects.equals(this.referenceSetDbIds, referenceSetsSearchRequest.referenceSetDbIds)
				&& super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessions, assemblyPUIs, md5checksums, referenceSetDbIds, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ReferenceSetsSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    accession: ").append(toIndentedString(accessions)).append("\n");
		sb.append("    assemblyPUI: ").append(toIndentedString(assemblyPUIs)).append("\n");
		sb.append("    md5checksum: ").append(toIndentedString(md5checksums)).append("\n");
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
		if (this.assemblyPUIs != null)
			count += this.assemblyPUIs.size();
		if (this.md5checksums != null)
			count += this.md5checksums.size();
		if (this.referenceSetDbIds != null)
			count += this.referenceSetDbIds.size();
		return count;
	}
}
