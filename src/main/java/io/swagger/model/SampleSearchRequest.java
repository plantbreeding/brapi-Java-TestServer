package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SampleSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class SampleSearchRequest   {
  @JsonProperty("germplasmDbId")
  @Valid
  private List<String> germplasmDbId = null;

  @JsonProperty("observationUnitDbId")
  @Valid
  private List<String> observationUnitDbId = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("pageSize")
  private Integer pageSize = null;

  @JsonProperty("plateDbId")
  @Valid
  private List<String> plateDbId = null;

  @JsonProperty("sampleDbId")
  @Valid
  private List<String> sampleDbId = null;

  public SampleSearchRequest germplasmDbId(List<String> germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

  public SampleSearchRequest addGermplasmDbIdItem(String germplasmDbIdItem) {
    if (this.germplasmDbId == null) {
      this.germplasmDbId = new ArrayList<String>();
    }
    this.germplasmDbId.add(germplasmDbIdItem);
    return this;
  }

   /**
   *  The ID which uniquely identifies a germplasm
   * @return germplasmDbId
  **/
  @ApiModelProperty(value = " The ID which uniquely identifies a germplasm")


  public List<String> getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(List<String> germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public SampleSearchRequest observationUnitDbId(List<String> observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
    return this;
  }

  public SampleSearchRequest addObservationUnitDbIdItem(String observationUnitDbIdItem) {
    if (this.observationUnitDbId == null) {
      this.observationUnitDbId = new ArrayList<String>();
    }
    this.observationUnitDbId.add(observationUnitDbIdItem);
    return this;
  }

   /**
   * The ID which uniquely identifies an observation unit
   * @return observationUnitDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies an observation unit")


  public List<String> getObservationUnitDbId() {
    return observationUnitDbId;
  }

  public void setObservationUnitDbId(List<String> observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
  }

  public SampleSearchRequest page(Integer page) {
    this.page = page;
    return this;
  }

   /**
   * Which result page is requested. The page indexing starts at 0 (the first page is 'page'= 0). Default is 0.
   * @return page
  **/
  @ApiModelProperty(value = "Which result page is requested. The page indexing starts at 0 (the first page is 'page'= 0). Default is 0.")


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public SampleSearchRequest pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

   /**
   * The size of the pages to be returned. Default is 1000.
   * @return pageSize
  **/
  @ApiModelProperty(value = "The size of the pages to be returned. Default is 1000.")


  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public SampleSearchRequest plateDbId(List<String> plateDbId) {
    this.plateDbId = plateDbId;
    return this;
  }

  public SampleSearchRequest addPlateDbIdItem(String plateDbIdItem) {
    if (this.plateDbId == null) {
      this.plateDbId = new ArrayList<String>();
    }
    this.plateDbId.add(plateDbIdItem);
    return this;
  }

   /**
   * The ID which uniquely identifies a plate of samples
   * @return plateDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a plate of samples")


  public List<String> getPlateDbId() {
    return plateDbId;
  }

  public void setPlateDbId(List<String> plateDbId) {
    this.plateDbId = plateDbId;
  }

  public SampleSearchRequest sampleDbId(List<String> sampleDbId) {
    this.sampleDbId = sampleDbId;
    return this;
  }

  public SampleSearchRequest addSampleDbIdItem(String sampleDbIdItem) {
    if (this.sampleDbId == null) {
      this.sampleDbId = new ArrayList<String>();
    }
    this.sampleDbId.add(sampleDbIdItem);
    return this;
  }

   /**
   * The ID which uniquely identifies a sample
   * @return sampleDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a sample")


  public List<String> getSampleDbId() {
    return sampleDbId;
  }

  public void setSampleDbId(List<String> sampleDbId) {
    this.sampleDbId = sampleDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SampleSearchRequest sampleSearchRequest = (SampleSearchRequest) o;
    return Objects.equals(this.germplasmDbId, sampleSearchRequest.germplasmDbId) &&
        Objects.equals(this.observationUnitDbId, sampleSearchRequest.observationUnitDbId) &&
        Objects.equals(this.page, sampleSearchRequest.page) &&
        Objects.equals(this.pageSize, sampleSearchRequest.pageSize) &&
        Objects.equals(this.plateDbId, sampleSearchRequest.plateDbId) &&
        Objects.equals(this.sampleDbId, sampleSearchRequest.sampleDbId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(germplasmDbId, observationUnitDbId, page, pageSize, plateDbId, sampleDbId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SampleSearchRequest {\n");
    
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    observationUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    plateDbId: ").append(toIndentedString(plateDbId)).append("\n");
    sb.append("    sampleDbId: ").append(toIndentedString(sampleDbId)).append("\n");
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

