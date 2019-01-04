package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * AlleleMatrixSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class AlleleMatrixSearchRequest   {
  @JsonProperty("expandHomozygotes")
  private Boolean expandHomozygotes = null;

  @JsonProperty("format")
  private String format = null;

  @JsonProperty("markerDbId")
  @Valid
  private List<String> markerDbId = null;

  @JsonProperty("markerProfileDbId")
  @Valid
  private List<String> markerProfileDbId = null;

  @JsonProperty("markerprofileDbId")
  @Valid
  private List<String> markerprofileDbId = null;

  @JsonProperty("matrixDbId")
  @Valid
  private List<String> matrixDbId = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("pageSize")
  private Integer pageSize = null;

  @JsonProperty("sepPhased")
  private String sepPhased = null;

  @JsonProperty("sepUnphased")
  private String sepUnphased = null;

  @JsonProperty("unknownString")
  private String unknownString = null;

  public AlleleMatrixSearchRequest expandHomozygotes(Boolean expandHomozygotes) {
    this.expandHomozygotes = expandHomozygotes;
    return this;
  }

  /**
   * Should homozygotes be expanded (true) or collapsed into a single occurence (false)
   * @return expandHomozygotes
  **/
  @ApiModelProperty(value = "Should homozygotes be expanded (true) or collapsed into a single occurence (false)")


  public Boolean isExpandHomozygotes() {
    return expandHomozygotes;
  }

  public void setExpandHomozygotes(Boolean expandHomozygotes) {
    this.expandHomozygotes = expandHomozygotes;
  }

  public AlleleMatrixSearchRequest format(String format) {
    this.format = format;
    return this;
  }

  /**
   * The data format of the response data. ie \"json\", \"tsv\", etc
   * @return format
  **/
  @ApiModelProperty(value = "The data format of the response data. ie \"json\", \"tsv\", etc")


  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public AlleleMatrixSearchRequest markerDbId(List<String> markerDbId) {
    this.markerDbId = markerDbId;
    return this;
  }

  public AlleleMatrixSearchRequest addMarkerDbIdItem(String markerDbIdItem) {
    if (this.markerDbId == null) {
      this.markerDbId = new ArrayList<String>();
    }
    this.markerDbId.add(markerDbIdItem);
    return this;
  }

  /**
   * An ID which uniquely identifies a Marker
   * @return markerDbId
  **/
  @ApiModelProperty(value = "An ID which uniquely identifies a Marker")


  public List<String> getMarkerDbId() {
    return markerDbId;
  }

  public void setMarkerDbId(List<String> markerDbId) {
    this.markerDbId = markerDbId;
  }

  public AlleleMatrixSearchRequest markerProfileDbId(List<String> markerProfileDbId) {
    this.markerProfileDbId = markerProfileDbId;
    return this;
  }

  public AlleleMatrixSearchRequest addMarkerProfileDbIdItem(String markerProfileDbIdItem) {
    if (this.markerProfileDbId == null) {
      this.markerProfileDbId = new ArrayList<String>();
    }
    this.markerProfileDbId.add(markerProfileDbIdItem);
    return this;
  }

  /**
   * An ID which uniquely identifies a Marker Profile
   * @return markerProfileDbId
  **/
  @ApiModelProperty(value = "An ID which uniquely identifies a Marker Profile")


  public List<String> getMarkerProfileDbId() {
    return markerProfileDbId;
  }

  public void setMarkerProfileDbId(List<String> markerProfileDbId) {
    this.markerProfileDbId = markerProfileDbId;
  }

  public AlleleMatrixSearchRequest markerprofileDbId(List<String> markerprofileDbId) {
    this.markerprofileDbId = markerprofileDbId;
    return this;
  }

  public AlleleMatrixSearchRequest addMarkerprofileDbIdItem(String markerprofileDbIdItem) {
    if (this.markerprofileDbId == null) {
      this.markerprofileDbId = new ArrayList<String>();
    }
    this.markerprofileDbId.add(markerprofileDbIdItem);
    return this;
  }

  /**
   * DEPRECATED in v1.3 - see \"markerProfileDbId\" (camel case)
   * @return markerprofileDbId
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - see \"markerProfileDbId\" (camel case)")


  public List<String> getMarkerprofileDbId() {
    return markerprofileDbId;
  }

  public void setMarkerprofileDbId(List<String> markerprofileDbId) {
    this.markerprofileDbId = markerprofileDbId;
  }

  public AlleleMatrixSearchRequest matrixDbId(List<String> matrixDbId) {
    this.matrixDbId = matrixDbId;
    return this;
  }

  public AlleleMatrixSearchRequest addMatrixDbIdItem(String matrixDbIdItem) {
    if (this.matrixDbId == null) {
      this.matrixDbId = new ArrayList<String>();
    }
    this.matrixDbId.add(matrixDbIdItem);
    return this;
  }

  /**
   * An ID which uniquely identifies an Allele Matrix
   * @return matrixDbId
  **/
  @ApiModelProperty(value = "An ID which uniquely identifies an Allele Matrix")


  public List<String> getMatrixDbId() {
    return matrixDbId;
  }

  public void setMatrixDbId(List<String> matrixDbId) {
    this.matrixDbId = matrixDbId;
  }

  public AlleleMatrixSearchRequest page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Which page of the \"data\" array to return. The page indexing starts at 0 (page=0 will return the first page). Default is 0.
   * @return page
  **/
  @ApiModelProperty(value = "Which page of the \"data\" array to return. The page indexing starts at 0 (page=0 will return the first page). Default is 0.")


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public AlleleMatrixSearchRequest pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * The maximum number of items to return per page of the \"data\" array. Default is 1000.
   * @return pageSize
  **/
  @ApiModelProperty(value = "The maximum number of items to return per page of the \"data\" array. Default is 1000.")


  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public AlleleMatrixSearchRequest sepPhased(String sepPhased) {
    this.sepPhased = sepPhased;
    return this;
  }

  /**
   * The string to use as a separator for phased allele calls.
   * @return sepPhased
  **/
  @ApiModelProperty(value = "The string to use as a separator for phased allele calls.")


  public String getSepPhased() {
    return sepPhased;
  }

  public void setSepPhased(String sepPhased) {
    this.sepPhased = sepPhased;
  }

  public AlleleMatrixSearchRequest sepUnphased(String sepUnphased) {
    this.sepUnphased = sepUnphased;
    return this;
  }

  /**
   * The string to use as a separator for unphased allele calls.
   * @return sepUnphased
  **/
  @ApiModelProperty(value = "The string to use as a separator for unphased allele calls.")


  public String getSepUnphased() {
    return sepUnphased;
  }

  public void setSepUnphased(String sepUnphased) {
    this.sepUnphased = sepUnphased;
  }

  public AlleleMatrixSearchRequest unknownString(String unknownString) {
    this.unknownString = unknownString;
    return this;
  }

  /**
   * The string to use as a representation for missing data.
   * @return unknownString
  **/
  @ApiModelProperty(value = "The string to use as a representation for missing data.")


  public String getUnknownString() {
    return unknownString;
  }

  public void setUnknownString(String unknownString) {
    this.unknownString = unknownString;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlleleMatrixSearchRequest alleleMatrixSearchRequest = (AlleleMatrixSearchRequest) o;
    return Objects.equals(this.expandHomozygotes, alleleMatrixSearchRequest.expandHomozygotes) &&
        Objects.equals(this.format, alleleMatrixSearchRequest.format) &&
        Objects.equals(this.markerDbId, alleleMatrixSearchRequest.markerDbId) &&
        Objects.equals(this.markerProfileDbId, alleleMatrixSearchRequest.markerProfileDbId) &&
        Objects.equals(this.markerprofileDbId, alleleMatrixSearchRequest.markerprofileDbId) &&
        Objects.equals(this.matrixDbId, alleleMatrixSearchRequest.matrixDbId) &&
        Objects.equals(this.page, alleleMatrixSearchRequest.page) &&
        Objects.equals(this.pageSize, alleleMatrixSearchRequest.pageSize) &&
        Objects.equals(this.sepPhased, alleleMatrixSearchRequest.sepPhased) &&
        Objects.equals(this.sepUnphased, alleleMatrixSearchRequest.sepUnphased) &&
        Objects.equals(this.unknownString, alleleMatrixSearchRequest.unknownString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expandHomozygotes, format, markerDbId, markerProfileDbId, markerprofileDbId, matrixDbId, page, pageSize, sepPhased, sepUnphased, unknownString);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlleleMatrixSearchRequest {\n");
    
    sb.append("    expandHomozygotes: ").append(toIndentedString(expandHomozygotes)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    markerDbId: ").append(toIndentedString(markerDbId)).append("\n");
    sb.append("    markerProfileDbId: ").append(toIndentedString(markerProfileDbId)).append("\n");
    sb.append("    markerprofileDbId: ").append(toIndentedString(markerprofileDbId)).append("\n");
    sb.append("    matrixDbId: ").append(toIndentedString(matrixDbId)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    sepPhased: ").append(toIndentedString(sepPhased)).append("\n");
    sb.append("    sepUnphased: ").append(toIndentedString(sepUnphased)).append("\n");
    sb.append("    unknownString: ").append(toIndentedString(unknownString)).append("\n");
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

