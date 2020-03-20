package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * A &#x60;Variant&#x60; represents a change in DNA sequence relative to some reference. For example, a variant could represent a SNP or an insertion. Variants belong to a &#x60;VariantSet&#x60;. This is equivalent to a row in VCF.
 */
@ApiModel(description = "A `Variant` represents a change in DNA sequence relative to some reference. For example, a variant could represent a SNP or an insertion. Variants belong to a `VariantSet`. This is equivalent to a row in VCF.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class Variant   {
  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("alternate_bases")
  @Valid
  private List<String> alternateBases = null;

  @JsonProperty("ciend")
  @Valid
  private List<Integer> ciend = null;

  @JsonProperty("cipos")
  @Valid
  private List<Integer> cipos = null;

  @JsonProperty("created")
  private OffsetDateTime created = null;

  @JsonProperty("end")
  private Integer end = null;

  @JsonProperty("filtersApplied")
  private Boolean filtersApplied = null;

  @JsonProperty("filtersFailed")
  @Valid
  private List<String> filtersFailed = null;

  @JsonProperty("filtersPassed")
  private Boolean filtersPassed = null;

  @JsonProperty("referenceBases")
  private String referenceBases = null;

  @JsonProperty("referenceName")
  private String referenceName = null;

  @JsonProperty("start")
  private Integer start = null;

  @JsonProperty("svlen")
  private Integer svlen = null;

  @JsonProperty("updated")
  private OffsetDateTime updated = null;

  @JsonProperty("variantDbId")
  private String variantDbId = null;

  @JsonProperty("variantNames")
  @Valid
  private List<String> variantNames = null;

  @JsonProperty("variantSetDbId")
  @Valid
  private List<String> variantSetDbId = null;

  @JsonProperty("variantType")
  private String variantType = null;

  public Variant additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public Variant putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = new HashMap<String, String>();
    }
    this.additionalInfo.put(key, additionalInfoItem);
    return this;
  }

  /**
   * Additional arbitrary info
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Additional arbitrary info")
  
    public Map<String, String> getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
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

  /**
   * The bases that appear instead of the reference bases. Multiple alternate alleles are possible.
   * @return alternateBases
  **/
  @ApiModelProperty(example = "[\"TAGGATTGAGCTCTATAT\"]", value = "The bases that appear instead of the reference bases. Multiple alternate alleles are possible.")
  
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

  /**
   * Similar to \"cipos\", but for the variant's end position (which is derived from start + svlen).
   * @return ciend
  **/
  @ApiModelProperty(example = "[-1000,0]", value = "Similar to \"cipos\", but for the variant's end position (which is derived from start + svlen).")
  
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

  /**
   * In the case of structural variants, start and end of the variant may not be known with an exact base position. \"cipos\" provides an interval with high confidence for the start position. The interval is provided by 0 or 2 signed integers which are added to the start position. Based on the use in VCF v4.2
   * @return cipos
  **/
  @ApiModelProperty(example = "[-12000,1000]", value = "In the case of structural variants, start and end of the variant may not be known with an exact base position. \"cipos\" provides an interval with high confidence for the start position. The interval is provided by 0 or 2 signed integers which are added to the start position. Based on the use in VCF v4.2")
  
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

  /**
   * The timestamp when this variant was created.
   * @return created
  **/
  @ApiModelProperty(value = "The timestamp when this variant was created.")
  
    @Valid
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

  /**
   * This field is optional and may be ignored if there is no relevant map or reference to be associated with.  The end position (exclusive), resulting in [start, end) closed-open interval. This is typically calculated  by `start + referenceBases.length`.
   * @return end
  **/
  @ApiModelProperty(example = "518", value = "This field is optional and may be ignored if there is no relevant map or reference to be associated with.  The end position (exclusive), resulting in [start, end) closed-open interval. This is typically calculated  by `start + referenceBases.length`.")
  
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

  /**
   * True if filters were applied for this variant. VCF column 7 \"FILTER\" any value other than the missing value.
   * @return filtersApplied
  **/
  @ApiModelProperty(example = "true", value = "True if filters were applied for this variant. VCF column 7 \"FILTER\" any value other than the missing value.")
  
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

  /**
   * Zero or more filters that failed for this variant. VCF column 7 \"FILTER\" shared across all alleles in the same VCF record.
   * @return filtersFailed
  **/
  @ApiModelProperty(example = "[\"d629a669\",\"3f14f578\"]", value = "Zero or more filters that failed for this variant. VCF column 7 \"FILTER\" shared across all alleles in the same VCF record.")
  
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

  /**
   * True if all filters for this variant passed. VCF column 7 \"FILTER\" value PASS.
   * @return filtersPassed
  **/
  @ApiModelProperty(example = "true", value = "True if all filters for this variant passed. VCF column 7 \"FILTER\" value PASS.")
  
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

  /**
   * The reference bases for this variant. They start at the given start position.
   * @return referenceBases
  **/
  @ApiModelProperty(example = "TAGGATTGAGCTCTATAT", value = "The reference bases for this variant. They start at the given start position.")
  
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

  /**
   * The reference on which this variant occurs. (e.g. `chr_20` or `X`)
   * @return referenceName
  **/
  @ApiModelProperty(example = "chr_20", value = "The reference on which this variant occurs. (e.g. `chr_20` or `X`)")
  
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

  /**
   * This field is optional and may be ignored if there is no relevant map or reference to be associated with.  The start position at which this variant occurs (0-based). This corresponds to the first base of the string  of reference bases. Genomic positions are non-negative integers less than reference length. Variants spanning  the join of circular genomes are represented as two variants one on each side of the join (position 0).
   * @return start
  **/
  @ApiModelProperty(example = "500", value = "This field is optional and may be ignored if there is no relevant map or reference to be associated with.  The start position at which this variant occurs (0-based). This corresponds to the first base of the string  of reference bases. Genomic positions are non-negative integers less than reference length. Variants spanning  the join of circular genomes are represented as two variants one on each side of the join (position 0).")
  
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

  /**
   * Length of the - if labeled as such in variant_type - structural variation. Based on the use in VCF v4.2
   * @return svlen
  **/
  @ApiModelProperty(example = "1500", value = "Length of the - if labeled as such in variant_type - structural variation. Based on the use in VCF v4.2")
  
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

  /**
   * The time at which this variant was last updated.
   * @return updated
  **/
  @ApiModelProperty(value = "The time at which this variant was last updated.")
  
    @Valid
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

  /**
   * The variant ID.
   * @return variantDbId
  **/
  @ApiModelProperty(example = "628e89c5", value = "The variant ID.")
  
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

  /**
   * Names for the variant, for example a RefSNP ID.
   * @return variantNames
  **/
  @ApiModelProperty(example = "[\"RefSNP_ID_1\",\"06ea312e\"]", value = "Names for the variant, for example a RefSNP ID.")
  
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

  /**
   * An array of `VariantSet` IDs this variant belongs to. This also defines the `ReferenceSet` against which the `Variant` is to be interpreted.
   * @return variantSetDbId
  **/
  @ApiModelProperty(example = "[\"c8ae400b\",\"ef2c204b\"]", value = "An array of `VariantSet` IDs this variant belongs to. This also defines the `ReferenceSet` against which the `Variant` is to be interpreted.")
  
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

  /**
   * The \"variant_type\" is used to denote e.g. structural variants. Examples:   DUP  : duplication of sequence following \"start\"   DEL  : deletion of sequence following \"start\"
   * @return variantType
  **/
  @ApiModelProperty(example = "DUP", value = "The \"variant_type\" is used to denote e.g. structural variants. Examples:   DUP  : duplication of sequence following \"start\"   DEL  : deletion of sequence following \"start\"")
  
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
    return Objects.equals(this.additionalInfo, variant.additionalInfo) &&
        Objects.equals(this.alternateBases, variant.alternateBases) &&
        Objects.equals(this.ciend, variant.ciend) &&
        Objects.equals(this.cipos, variant.cipos) &&
        Objects.equals(this.created, variant.created) &&
        Objects.equals(this.end, variant.end) &&
        Objects.equals(this.filtersApplied, variant.filtersApplied) &&
        Objects.equals(this.filtersFailed, variant.filtersFailed) &&
        Objects.equals(this.filtersPassed, variant.filtersPassed) &&
        Objects.equals(this.referenceBases, variant.referenceBases) &&
        Objects.equals(this.referenceName, variant.referenceName) &&
        Objects.equals(this.start, variant.start) &&
        Objects.equals(this.svlen, variant.svlen) &&
        Objects.equals(this.updated, variant.updated) &&
        Objects.equals(this.variantDbId, variant.variantDbId) &&
        Objects.equals(this.variantNames, variant.variantNames) &&
        Objects.equals(this.variantSetDbId, variant.variantSetDbId) &&
        Objects.equals(this.variantType, variant.variantType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, alternateBases, ciend, cipos, created, end, filtersApplied, filtersFailed, filtersPassed, referenceBases, referenceName, start, svlen, updated, variantDbId, variantNames, variantSetDbId, variantType);
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
}
