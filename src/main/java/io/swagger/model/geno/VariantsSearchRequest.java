package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.common.SearchRequestParametersTokenPaging;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * VariantsSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class VariantsSearchRequest extends SearchRequestParametersTokenPaging  {
  @JsonProperty("callSetDbIds")
  @Valid
  private List<String> callSetDbIds = null;

  @JsonProperty("end")
  private Integer end = null;

  @JsonProperty("referenceDbId")
  private String referenceDbId = null;

  @JsonProperty("start")
  private Integer start = null;

  @JsonProperty("variantSetDbIds")
  @Valid
  private List<String> variantSetDbIds = null;

  public VariantsSearchRequest callSetDbIds(List<String> callSetDbIds) {
    this.callSetDbIds = callSetDbIds;
    return this;
  }

  public VariantsSearchRequest addCallSetDbIdsItem(String callSetDbIdsItem) {
    if (this.callSetDbIds == null) {
      this.callSetDbIds = new ArrayList<String>();
    }
    this.callSetDbIds.add(callSetDbIdsItem);
    return this;
  }

  /**
   * Only return variant calls which belong to call sets with these IDs. If unspecified, return all variants and no variant call objects.
   * @return callSetDbIds
  **/
  @ApiModelProperty(example = "[\"4639fe3e\",\"b60d900b\"]", value = "Only return variant calls which belong to call sets with these IDs. If unspecified, return all variants and no variant call objects.")
  
    public List<String> getCallSetDbIds() {
    return callSetDbIds;
  }

  public void setCallSetDbIds(List<String> callSetDbIds) {
    this.callSetDbIds = callSetDbIds;
  }

  public VariantsSearchRequest end(Integer end) {
    this.end = end;
    return this;
  }

  /**
   * The end of the window (0-based, exclusive) for which overlapping variants should be returned.
   * @return end
  **/
  @ApiModelProperty(example = "1500", value = "The end of the window (0-based, exclusive) for which overlapping variants should be returned.")
  
    public Integer getEnd() {
    return end;
  }

  public void setEnd(Integer end) {
    this.end = end;
  }

  public VariantsSearchRequest referenceDbId(String referenceDbId) {
    this.referenceDbId = referenceDbId;
    return this;
  }

  /**
   * Only return variants on this reference.
   * @return referenceDbId
  **/
  @ApiModelProperty(example = "120a2d5c", value = "Only return variants on this reference.")
  
    public String getReferenceDbId() {
    return referenceDbId;
  }

  public void setReferenceDbId(String referenceDbId) {
    this.referenceDbId = referenceDbId;
  }

  public VariantsSearchRequest start(Integer start) {
    this.start = start;
    return this;
  }

  /**
   * The beginning of the window (0-based, inclusive) for which overlapping variants should be returned. Genomic positions are non-negative integers less than reference length. Requests spanning the join of circular genomes are represented as two requests one on each side of the join (position 0).
   * @return start
  **/
  @ApiModelProperty(example = "100", value = "The beginning of the window (0-based, inclusive) for which overlapping variants should be returned. Genomic positions are non-negative integers less than reference length. Requests spanning the join of circular genomes are represented as two requests one on each side of the join (position 0).")
  
    public Integer getStart() {
    return start;
  }

  public void setStart(Integer start) {
    this.start = start;
  }

  public VariantsSearchRequest variantSetDbIds(List<String> variantSetDbIds) {
    this.variantSetDbIds = variantSetDbIds;
    return this;
  }

  public VariantsSearchRequest addVariantSetDbIdsItem(String variantSetDbIdsItem) {
    if (this.variantSetDbIds == null) {
      this.variantSetDbIds = new ArrayList<String>();
    }
    this.variantSetDbIds.add(variantSetDbIdsItem);
    return this;
  }

  /**
   * The `VariantSet` to search.
   * @return variantSetDbIds
  **/
  @ApiModelProperty(example = "[\"ba63d810\",\"434d1760\"]", value = "The `VariantSet` to search.")
  
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
    VariantsSearchRequest variantsSearchRequest = (VariantsSearchRequest) o;
    return Objects.equals(this.callSetDbIds, variantsSearchRequest.callSetDbIds) &&
        Objects.equals(this.end, variantsSearchRequest.end) &&
        Objects.equals(this.referenceDbId, variantsSearchRequest.referenceDbId) &&
        Objects.equals(this.start, variantsSearchRequest.start) &&
        Objects.equals(this.variantSetDbIds, variantsSearchRequest.variantSetDbIds) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callSetDbIds, end, referenceDbId, start, variantSetDbIds, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VariantsSearchRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    callSetDbIds: ").append(toIndentedString(callSetDbIds)).append("\n");
    sb.append("    end: ").append(toIndentedString(end)).append("\n");
    sb.append("    referenceDbId: ").append(toIndentedString(referenceDbId)).append("\n");
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    variantSetDbIds: ").append(toIndentedString(variantSetDbIds)).append("\n");
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
