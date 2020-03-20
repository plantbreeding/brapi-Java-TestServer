package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.common.SearchRequestParametersPaging;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * SampleSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class SampleSearchRequest extends SearchRequestParametersPaging  {
  @JsonProperty("germplasmDbIds")
  @Valid
  private List<String> germplasmDbIds = null;

  @JsonProperty("germplasmNames")
  @Valid
  private List<String> germplasmNames = null;

  @JsonProperty("studyDbIds")
  @Valid
  private List<String> studyDbIds = null;

  @JsonProperty("studyNames")
  @Valid
  private List<String> studyNames = null;

  @JsonProperty("externalReferenceIDs")
  @Valid
  private List<String> externalReferenceIDs = null;

  @JsonProperty("externalReferenceSources")
  @Valid
  private List<String> externalReferenceSources = null;

  @JsonProperty("observationUnitDbIds")
  @Valid
  private List<String> observationUnitDbIds = null;

  @JsonProperty("plateDbIds")
  @Valid
  private List<String> plateDbIds = null;

  @JsonProperty("sampleDbIds")
  @Valid
  private List<String> sampleDbIds = null;

  public SampleSearchRequest germplasmDbIds(List<String> germplasmDbIds) {
    this.germplasmDbIds = germplasmDbIds;
    return this;
  }

  public SampleSearchRequest addGermplasmDbIdsItem(String germplasmDbIdsItem) {
    if (this.germplasmDbIds == null) {
      this.germplasmDbIds = new ArrayList<String>();
    }
    this.germplasmDbIds.add(germplasmDbIdsItem);
    return this;
  }

  /**
   * List of IDs which uniquely identify germplasm to search for
   * @return germplasmDbIds
  **/
  @ApiModelProperty(example = "[\"e9c6edd7\",\"1b1df4a6\"]", value = "List of IDs which uniquely identify germplasm to search for")
  
    public List<String> getGermplasmDbIds() {
    return germplasmDbIds;
  }

  public void setGermplasmDbIds(List<String> germplasmDbIds) {
    this.germplasmDbIds = germplasmDbIds;
  }

  public SampleSearchRequest germplasmNames(List<String> germplasmNames) {
    this.germplasmNames = germplasmNames;
    return this;
  }

  public SampleSearchRequest addGermplasmNamesItem(String germplasmNamesItem) {
    if (this.germplasmNames == null) {
      this.germplasmNames = new ArrayList<String>();
    }
    this.germplasmNames.add(germplasmNamesItem);
    return this;
  }

  /**
   * List of human readable names to identify germplasm to search for
   * @return germplasmNames
  **/
  @ApiModelProperty(example = "[\"A0000003\",\"A0000477\"]", value = "List of human readable names to identify germplasm to search for")
  
    public List<String> getGermplasmNames() {
    return germplasmNames;
  }

  public void setGermplasmNames(List<String> germplasmNames) {
    this.germplasmNames = germplasmNames;
  }

  public SampleSearchRequest studyDbIds(List<String> studyDbIds) {
    this.studyDbIds = studyDbIds;
    return this;
  }

  public SampleSearchRequest addStudyDbIdsItem(String studyDbIdsItem) {
    if (this.studyDbIds == null) {
      this.studyDbIds = new ArrayList<String>();
    }
    this.studyDbIds.add(studyDbIdsItem);
    return this;
  }

  /**
   * List of study identifiers to search for
   * @return studyDbIds
  **/
  @ApiModelProperty(example = "[\"cf6c4bd4\",\"691e69d6\"]", value = "List of study identifiers to search for")
  
    public List<String> getStudyDbIds() {
    return studyDbIds;
  }

  public void setStudyDbIds(List<String> studyDbIds) {
    this.studyDbIds = studyDbIds;
  }

  public SampleSearchRequest studyNames(List<String> studyNames) {
    this.studyNames = studyNames;
    return this;
  }

  public SampleSearchRequest addStudyNamesItem(String studyNamesItem) {
    if (this.studyNames == null) {
      this.studyNames = new ArrayList<String>();
    }
    this.studyNames.add(studyNamesItem);
    return this;
  }

  /**
   * List of study names to filter search results
   * @return studyNames
  **/
  @ApiModelProperty(example = "[\"The First Bob Study 2017\",\"Wheat Yield Trial 246\"]", value = "List of study names to filter search results")
  
    public List<String> getStudyNames() {
    return studyNames;
  }

  public void setStudyNames(List<String> studyNames) {
    this.studyNames = studyNames;
  }

  public SampleSearchRequest externalReferenceIDs(List<String> externalReferenceIDs) {
    this.externalReferenceIDs = externalReferenceIDs;
    return this;
  }

  public SampleSearchRequest addExternalReferenceIDsItem(String externalReferenceIDsItem) {
    if (this.externalReferenceIDs == null) {
      this.externalReferenceIDs = new ArrayList<String>();
    }
    this.externalReferenceIDs.add(externalReferenceIDsItem);
    return this;
  }

  /**
   * List of external references for the trait to search for
   * @return externalReferenceIDs
  **/
  @ApiModelProperty(example = "[\"http://purl.obolibrary.org/obo/ro.owl\",\"14a19841\"]", value = "List of external references for the trait to search for")
  
    public List<String> getExternalReferenceIDs() {
    return externalReferenceIDs;
  }

  public void setExternalReferenceIDs(List<String> externalReferenceIDs) {
    this.externalReferenceIDs = externalReferenceIDs;
  }

  public SampleSearchRequest externalReferenceSources(List<String> externalReferenceSources) {
    this.externalReferenceSources = externalReferenceSources;
    return this;
  }

  public SampleSearchRequest addExternalReferenceSourcesItem(String externalReferenceSourcesItem) {
    if (this.externalReferenceSources == null) {
      this.externalReferenceSources = new ArrayList<String>();
    }
    this.externalReferenceSources.add(externalReferenceSourcesItem);
    return this;
  }

  /**
   * List of external references sources for the trait to search for
   * @return externalReferenceSources
  **/
  @ApiModelProperty(example = "[\"OBO Library\",\"Field App Name\"]", value = "List of external references sources for the trait to search for")
  
    public List<String> getExternalReferenceSources() {
    return externalReferenceSources;
  }

  public void setExternalReferenceSources(List<String> externalReferenceSources) {
    this.externalReferenceSources = externalReferenceSources;
  }

  public SampleSearchRequest observationUnitDbIds(List<String> observationUnitDbIds) {
    this.observationUnitDbIds = observationUnitDbIds;
    return this;
  }

  public SampleSearchRequest addObservationUnitDbIdsItem(String observationUnitDbIdsItem) {
    if (this.observationUnitDbIds == null) {
      this.observationUnitDbIds = new ArrayList<String>();
    }
    this.observationUnitDbIds.add(observationUnitDbIdsItem);
    return this;
  }

  /**
   * The ID which uniquely identifies an observation unit
   * @return observationUnitDbIds
  **/
  @ApiModelProperty(example = "[\"3cd0ca36\",\"983f3b14\"]", value = "The ID which uniquely identifies an observation unit")
  
    public List<String> getObservationUnitDbIds() {
    return observationUnitDbIds;
  }

  public void setObservationUnitDbIds(List<String> observationUnitDbIds) {
    this.observationUnitDbIds = observationUnitDbIds;
  }

  public SampleSearchRequest plateDbIds(List<String> plateDbIds) {
    this.plateDbIds = plateDbIds;
    return this;
  }

  public SampleSearchRequest addPlateDbIdsItem(String plateDbIdsItem) {
    if (this.plateDbIds == null) {
      this.plateDbIds = new ArrayList<String>();
    }
    this.plateDbIds.add(plateDbIdsItem);
    return this;
  }

  /**
   * The ID which uniquely identifies a plate of samples
   * @return plateDbIds
  **/
  @ApiModelProperty(example = "[\"0cac98b8\",\"b96125fb\"]", value = "The ID which uniquely identifies a plate of samples")
  
    public List<String> getPlateDbIds() {
    return plateDbIds;
  }

  public void setPlateDbIds(List<String> plateDbIds) {
    this.plateDbIds = plateDbIds;
  }

  public SampleSearchRequest sampleDbIds(List<String> sampleDbIds) {
    this.sampleDbIds = sampleDbIds;
    return this;
  }

  public SampleSearchRequest addSampleDbIdsItem(String sampleDbIdsItem) {
    if (this.sampleDbIds == null) {
      this.sampleDbIds = new ArrayList<String>();
    }
    this.sampleDbIds.add(sampleDbIdsItem);
    return this;
  }

  /**
   * The ID which uniquely identifies a sample
   * @return sampleDbIds
  **/
  @ApiModelProperty(example = "[\"3bece2ca\",\"dd286cc6\"]", value = "The ID which uniquely identifies a sample")
  
    public List<String> getSampleDbIds() {
    return sampleDbIds;
  }

  public void setSampleDbIds(List<String> sampleDbIds) {
    this.sampleDbIds = sampleDbIds;
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
    return Objects.equals(this.germplasmDbIds, sampleSearchRequest.germplasmDbIds) &&
        Objects.equals(this.germplasmNames, sampleSearchRequest.germplasmNames) &&
        Objects.equals(this.studyDbIds, sampleSearchRequest.studyDbIds) &&
        Objects.equals(this.studyNames, sampleSearchRequest.studyNames) &&
        Objects.equals(this.externalReferenceIDs, sampleSearchRequest.externalReferenceIDs) &&
        Objects.equals(this.externalReferenceSources, sampleSearchRequest.externalReferenceSources) &&
        Objects.equals(this.observationUnitDbIds, sampleSearchRequest.observationUnitDbIds) &&
        Objects.equals(this.plateDbIds, sampleSearchRequest.plateDbIds) &&
        Objects.equals(this.sampleDbIds, sampleSearchRequest.sampleDbIds) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(germplasmDbIds, germplasmNames, studyDbIds, studyNames, externalReferenceIDs, externalReferenceSources, observationUnitDbIds, plateDbIds, sampleDbIds, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SampleSearchRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    germplasmDbIds: ").append(toIndentedString(germplasmDbIds)).append("\n");
    sb.append("    germplasmNames: ").append(toIndentedString(germplasmNames)).append("\n");
    sb.append("    studyDbIds: ").append(toIndentedString(studyDbIds)).append("\n");
    sb.append("    studyNames: ").append(toIndentedString(studyNames)).append("\n");
    sb.append("    externalReferenceIDs: ").append(toIndentedString(externalReferenceIDs)).append("\n");
    sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
    sb.append("    observationUnitDbIds: ").append(toIndentedString(observationUnitDbIds)).append("\n");
    sb.append("    plateDbIds: ").append(toIndentedString(plateDbIds)).append("\n");
    sb.append("    sampleDbIds: ").append(toIndentedString(sampleDbIds)).append("\n");
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
