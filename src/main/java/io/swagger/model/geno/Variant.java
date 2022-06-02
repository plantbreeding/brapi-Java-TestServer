package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;

import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;

public class Variant extends BrAPIDataModel {
	@JsonProperty("alternate_bases")
	private List<String> alternateBases = null;

	@JsonProperty("ciend")
	private List<Integer> ciend = null;

	@JsonProperty("cipos")
	private List<Integer> cipos = null;

	@JsonProperty("created")
	private OffsetDateTime created = null;

	@JsonProperty("end")
	private Integer end = null;

	@JsonProperty("filtersApplied")
	private Boolean filtersApplied = null;

	@JsonProperty("filtersFailed")
	private List<String> filtersFailed = null;

	@JsonProperty("filtersPassed")
	private Boolean filtersPassed = null;

	@JsonProperty("referenceBases")
	private String referenceBases = null;

	@JsonProperty("referenceName")
	private String referenceName = null;

	@JsonProperty("referenceDbId")
	private String referenceDbId = null;

	@JsonProperty("referenceSetName")
	private String referenceSetName = null;

	@JsonProperty("referenceSetDbId")
	private String referenceSetDbId = null;

	@JsonProperty("start")
	private Integer start = null;

	@JsonProperty("svlen")
	private Integer svlen = null;

	@JsonProperty("updated")
	private OffsetDateTime updated = null;

	@JsonProperty("variantDbId")
	private String variantDbId = null;

	@JsonProperty("variantNames")
	private List<String> variantNames = null;

	@JsonProperty("variantSetDbId")
	private List<String> variantSetDbId = null;

	@JsonProperty("variantType")
	private String variantType = null;

	public String getReferenceDbId() {
		return referenceDbId;
	}

	public void setReferenceDbId(String referenceDbId) {
		this.referenceDbId = referenceDbId;
	}

	public String getReferenceSetName() {
		return referenceSetName;
	}

	public void setReferenceSetName(String referenceSetName) {
		this.referenceSetName = referenceSetName;
	}

	public String getReferenceSetDbId() {
		return referenceSetDbId;
	}

	public void setReferenceSetDbId(String referenceSetDbId) {
		this.referenceSetDbId = referenceSetDbId;
	}

	public Boolean getFiltersApplied() {
		return filtersApplied;
	}

	public Boolean getFiltersPassed() {
		return filtersPassed;
	}

	public Variant alternateBases(List<String> alternateBases) {
		this.alternateBases = alternateBases;
		return this;
	}

	public Variant addAlternateBasesItem(String alternateBasesItem) {
		if (this.alternateBases == null) {
			this.alternateBases = new ArrayList<String>();
		}
		this.alternateBases.add(alternateBasesItem);
		return this;
	}

	public List<String> getAlternateBases() {
		return alternateBases;
	}

	public void setAlternateBases(List<String> alternateBases) {
		this.alternateBases = alternateBases;
	}

	public Variant ciend(List<Integer> ciend) {
		this.ciend = ciend;
		return this;
	}

	public Variant addCiendItem(Integer ciendItem) {
		if (this.ciend == null) {
			this.ciend = new ArrayList<Integer>();
		}
		this.ciend.add(ciendItem);
		return this;
	}

	public List<Integer> getCiend() {
		return ciend;
	}

	public void setCiend(List<Integer> ciend) {
		this.ciend = ciend;
	}

	public Variant cipos(List<Integer> cipos) {
		this.cipos = cipos;
		return this;
	}

	public Variant addCiposItem(Integer ciposItem) {
		if (this.cipos == null) {
			this.cipos = new ArrayList<Integer>();
		}
		this.cipos.add(ciposItem);
		return this;
	}

	public List<Integer> getCipos() {
		return cipos;
	}

	public void setCipos(List<Integer> cipos) {
		this.cipos = cipos;
	}

	public Variant created(OffsetDateTime created) {
		this.created = created;
		return this;
	}

	public OffsetDateTime getCreated() {
		return created;
	}

	public void setCreated(OffsetDateTime created) {
		this.created = created;
	}

	public Variant end(Integer end) {
		this.end = end;
		return this;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Variant filtersApplied(Boolean filtersApplied) {
		this.filtersApplied = filtersApplied;
		return this;
	}

	public Boolean isFiltersApplied() {
		return filtersApplied;
	}

	public void setFiltersApplied(Boolean filtersApplied) {
		this.filtersApplied = filtersApplied;
	}

	public Variant filtersFailed(List<String> filtersFailed) {
		this.filtersFailed = filtersFailed;
		return this;
	}

	public Variant addFiltersFailedItem(String filtersFailedItem) {
		if (this.filtersFailed == null) {
			this.filtersFailed = new ArrayList<String>();
		}
		this.filtersFailed.add(filtersFailedItem);
		return this;
	}

	public List<String> getFiltersFailed() {
		return filtersFailed;
	}

	public void setFiltersFailed(List<String> filtersFailed) {
		this.filtersFailed = filtersFailed;
	}

	public Variant filtersPassed(Boolean filtersPassed) {
		this.filtersPassed = filtersPassed;
		return this;
	}

	public Boolean isFiltersPassed() {
		return filtersPassed;
	}

	public void setFiltersPassed(Boolean filtersPassed) {
		this.filtersPassed = filtersPassed;
	}

	public Variant referenceBases(String referenceBases) {
		this.referenceBases = referenceBases;
		return this;
	}

	public String getReferenceBases() {
		return referenceBases;
	}

	public void setReferenceBases(String referenceBases) {
		this.referenceBases = referenceBases;
	}

	public Variant referenceName(String referenceName) {
		this.referenceName = referenceName;
		return this;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public Variant start(Integer start) {
		this.start = start;
		return this;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Variant svlen(Integer svlen) {
		this.svlen = svlen;
		return this;
	}

	public Integer getSvlen() {
		return svlen;
	}

	public void setSvlen(Integer svlen) {
		this.svlen = svlen;
	}

	public Variant updated(OffsetDateTime updated) {
		this.updated = updated;
		return this;
	}

	public OffsetDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(OffsetDateTime updated) {
		this.updated = updated;
	}

	public Variant variantDbId(String variantDbId) {
		this.variantDbId = variantDbId;
		return this;
	}

	public String getVariantDbId() {
		return variantDbId;
	}

	public void setVariantDbId(String variantDbId) {
		this.variantDbId = variantDbId;
	}

	public Variant variantNames(List<String> variantNames) {
		this.variantNames = variantNames;
		return this;
	}

	public Variant addVariantNamesItem(String variantNamesItem) {
		if (this.variantNames == null) {
			this.variantNames = new ArrayList<String>();
		}
		this.variantNames.add(variantNamesItem);
		return this;
	}

	public List<String> getVariantNames() {
		return variantNames;
	}

	public void setVariantNames(List<String> variantNames) {
		this.variantNames = variantNames;
	}

	public Variant variantSetDbId(List<String> variantSetDbId) {
		this.variantSetDbId = variantSetDbId;
		return this;
	}

	public Variant addVariantSetDbIdItem(String variantSetDbIdItem) {
		if (this.variantSetDbId == null) {
			this.variantSetDbId = new ArrayList<String>();
		}
		this.variantSetDbId.add(variantSetDbIdItem);
		return this;
	}

	public List<String> getVariantSetDbId() {
		return variantSetDbId;
	}

	public void setVariantSetDbId(List<String> variantSetDbId) {
		this.variantSetDbId = variantSetDbId;
	}

	public Variant variantType(String variantType) {
		this.variantType = variantType;
		return this;
	}

	public String getVariantType() {
		return variantType;
	}

	public void setVariantType(String variantType) {
		this.variantType = variantType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Variant variant = (Variant) o;
		return Objects.equals(this.additionalInfo, variant.additionalInfo)
				&& Objects.equals(this.alternateBases, variant.alternateBases)
				&& Objects.equals(this.ciend, variant.ciend) && Objects.equals(this.cipos, variant.cipos)
				&& Objects.equals(this.created, variant.created) && Objects.equals(this.end, variant.end)
				&& Objects.equals(this.filtersApplied, variant.filtersApplied)
				&& Objects.equals(this.filtersFailed, variant.filtersFailed)
				&& Objects.equals(this.filtersPassed, variant.filtersPassed)
				&& Objects.equals(this.referenceBases, variant.referenceBases)
				&& Objects.equals(this.referenceName, variant.referenceName)
				&& Objects.equals(this.start, variant.start) && Objects.equals(this.svlen, variant.svlen)
				&& Objects.equals(this.updated, variant.updated)
				&& Objects.equals(this.variantDbId, variant.variantDbId)
				&& Objects.equals(this.variantNames, variant.variantNames)
				&& Objects.equals(this.variantSetDbId, variant.variantSetDbId)
				&& Objects.equals(this.variantType, variant.variantType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, alternateBases, ciend, cipos, created, end, filtersApplied, filtersFailed,
				filtersPassed, referenceBases, referenceName, start, svlen, updated, variantDbId, variantNames,
				variantSetDbId, variantType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Variant {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    alternateBases: ").append(toIndentedString(alternateBases)).append("\n");
		sb.append("    ciend: ").append(toIndentedString(ciend)).append("\n");
		sb.append("    cipos: ").append(toIndentedString(cipos)).append("\n");
		sb.append("    created: ").append(toIndentedString(created)).append("\n");
		sb.append("    end: ").append(toIndentedString(end)).append("\n");
		sb.append("    filtersApplied: ").append(toIndentedString(filtersApplied)).append("\n");
		sb.append("    filtersFailed: ").append(toIndentedString(filtersFailed)).append("\n");
		sb.append("    filtersPassed: ").append(toIndentedString(filtersPassed)).append("\n");
		sb.append("    referenceBases: ").append(toIndentedString(referenceBases)).append("\n");
		sb.append("    referenceName: ").append(toIndentedString(referenceName)).append("\n");
		sb.append("    start: ").append(toIndentedString(start)).append("\n");
		sb.append("    svlen: ").append(toIndentedString(svlen)).append("\n");
		sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
		sb.append("    variantDbId: ").append(toIndentedString(variantDbId)).append("\n");
		sb.append("    variantNames: ").append(toIndentedString(variantNames)).append("\n");
		sb.append("    variantSetDbId: ").append(toIndentedString(variantSetDbId)).append("\n");
		sb.append("    variantType: ").append(toIndentedString(variantType)).append("\n");
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
