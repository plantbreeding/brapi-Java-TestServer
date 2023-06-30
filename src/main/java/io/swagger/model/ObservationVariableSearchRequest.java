package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.TraitDataType;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * ObservationVariableSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class ObservationVariableSearchRequest   {
  @JsonProperty("dataTypes")
  @Valid
  private List<TraitDataType> dataTypes = null;

  @JsonProperty("methodDbIds")
  @Valid
  private List<String> methodDbIds = null;

  @JsonProperty("observationVariableDbIds")
  @Valid
  private List<String> observationVariableDbIds = null;

  @JsonProperty("observationVariableNames")
  @Valid
  private List<String> observationVariableNames = null;

  @JsonProperty("observationVariableXrefs")
  @Valid
  private List<String> observationVariableXrefs = null;

  @JsonProperty("ontologyDbIds")
  @Valid
  private List<String> ontologyDbIds = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("pageSize")
  private Integer pageSize = null;

  @JsonProperty("scaleDbIds")
  @Valid
  private List<String> scaleDbIds = null;

  @JsonProperty("scaleXrefs")
  @Valid
  private List<String> scaleXrefs = null;

  @JsonProperty("traitClasses")
  @Valid
  private List<String> traitClasses = null;

  @JsonProperty("traitDbIds")
  @Valid
  private List<String> traitDbIds = null;

  @JsonProperty("traitXrefs")
  @Valid
  private List<String> traitXrefs = null;

  public ObservationVariableSearchRequest dataTypes(List<TraitDataType> dataTypes) {
    this.dataTypes = dataTypes;
    return this;
  }

  public ObservationVariableSearchRequest addDataTypesItem(TraitDataType dataTypesItem) {
    if (this.dataTypes == null) {
      this.dataTypes = new ArrayList<TraitDataType>();
    }
    this.dataTypes.add(dataTypesItem);
    return this;
  }

  /**
   * List of scale data types to filter search results
   * @return dataTypes
  **/
  @ApiModelProperty(value = "List of scale data types to filter search results")

  @Valid

  public List<TraitDataType> getDataTypes() {
    return dataTypes;
  }

  public void setDataTypes(List<TraitDataType> dataTypes) {
    this.dataTypes = dataTypes;
  }

  public ObservationVariableSearchRequest methodDbIds(List<String> methodDbIds) {
    this.methodDbIds = methodDbIds;
    return this;
  }

  public ObservationVariableSearchRequest addMethodDbIdsItem(String methodDbIdsItem) {
    if (this.methodDbIds == null) {
      this.methodDbIds = new ArrayList<String>();
    }
    this.methodDbIds.add(methodDbIdsItem);
    return this;
  }

  /**
   * List of methods to filter search results
   * @return methodDbIds
  **/
  @ApiModelProperty(value = "List of methods to filter search results")


  public List<String> getMethodDbIds() {
    return methodDbIds;
  }

  public void setMethodDbIds(List<String> methodDbIds) {
    this.methodDbIds = methodDbIds;
  }

  public ObservationVariableSearchRequest observationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
    return this;
  }

  public ObservationVariableSearchRequest addObservationVariableDbIdsItem(String observationVariableDbIdsItem) {
    if (this.observationVariableDbIds == null) {
      this.observationVariableDbIds = new ArrayList<String>();
    }
    this.observationVariableDbIds.add(observationVariableDbIdsItem);
    return this;
  }

  /**
   * List of observation variable IDs to search for
   * @return observationVariableDbIds
  **/
  @ApiModelProperty(value = "List of observation variable IDs to search for")


  public List<String> getObservationVariableDbIds() {
    return observationVariableDbIds;
  }

  public void setObservationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
  }

  public ObservationVariableSearchRequest observationVariableNames(List<String> observationVariableNames) {
    this.observationVariableNames = observationVariableNames;
    return this;
  }

  public ObservationVariableSearchRequest addObservationVariableNamesItem(String observationVariableNamesItem) {
    if (this.observationVariableNames == null) {
      this.observationVariableNames = new ArrayList<String>();
    }
    this.observationVariableNames.add(observationVariableNamesItem);
    return this;
  }

  /**
   * List of human readable observation variable names to search for
   * @return observationVariableNames
  **/
  @ApiModelProperty(value = "List of human readable observation variable names to search for")


  public List<String> getObservationVariableNames() {
    return observationVariableNames;
  }

  public void setObservationVariableNames(List<String> observationVariableNames) {
    this.observationVariableNames = observationVariableNames;
  }

  public ObservationVariableSearchRequest observationVariableXrefs(List<String> observationVariableXrefs) {
    this.observationVariableXrefs = observationVariableXrefs;
    return this;
  }

  public ObservationVariableSearchRequest addObservationVariableXrefsItem(String observationVariableXrefsItem) {
    if (this.observationVariableXrefs == null) {
      this.observationVariableXrefs = new ArrayList<String>();
    }
    this.observationVariableXrefs.add(observationVariableXrefsItem);
    return this;
  }

  /**
   * List of cross references for the observation variable to search for
   * @return observationVariableXrefs
  **/
  @ApiModelProperty(value = "List of cross references for the observation variable to search for")


  public List<String> getObservationVariableXrefs() {
    return observationVariableXrefs;
  }

  public void setObservationVariableXrefs(List<String> observationVariableXrefs) {
    this.observationVariableXrefs = observationVariableXrefs;
  }

  public ObservationVariableSearchRequest ontologyDbIds(List<String> ontologyDbIds) {
    this.ontologyDbIds = ontologyDbIds;
    return this;
  }

  public ObservationVariableSearchRequest addOntologyDbIdsItem(String ontologyDbIdsItem) {
    if (this.ontologyDbIds == null) {
      this.ontologyDbIds = new ArrayList<String>();
    }
    this.ontologyDbIds.add(ontologyDbIdsItem);
    return this;
  }

  /**
   * List of ontology IDs to search for
   * @return ontologyDbIds
  **/
  @ApiModelProperty(value = "List of ontology IDs to search for")


  public List<String> getOntologyDbIds() {
    return ontologyDbIds;
  }

  public void setOntologyDbIds(List<String> ontologyDbIds) {
    this.ontologyDbIds = ontologyDbIds;
  }

  public ObservationVariableSearchRequest page(Integer page) {
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

  public ObservationVariableSearchRequest pageSize(Integer pageSize) {
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

  public ObservationVariableSearchRequest scaleDbIds(List<String> scaleDbIds) {
    this.scaleDbIds = scaleDbIds;
    return this;
  }

  public ObservationVariableSearchRequest addScaleDbIdsItem(String scaleDbIdsItem) {
    if (this.scaleDbIds == null) {
      this.scaleDbIds = new ArrayList<String>();
    }
    this.scaleDbIds.add(scaleDbIdsItem);
    return this;
  }

  /**
   * List of scales to filter search results
   * @return scaleDbIds
  **/
  @ApiModelProperty(value = "List of scales to filter search results")


  public List<String> getScaleDbIds() {
    return scaleDbIds;
  }

  public void setScaleDbIds(List<String> scaleDbIds) {
    this.scaleDbIds = scaleDbIds;
  }

  public ObservationVariableSearchRequest scaleXrefs(List<String> scaleXrefs) {
    this.scaleXrefs = scaleXrefs;
    return this;
  }

  public ObservationVariableSearchRequest addScaleXrefsItem(String scaleXrefsItem) {
    if (this.scaleXrefs == null) {
      this.scaleXrefs = new ArrayList<String>();
    }
    this.scaleXrefs.add(scaleXrefsItem);
    return this;
  }

  /**
   * List of cross references for the scale to search for
   * @return scaleXrefs
  **/
  @ApiModelProperty(value = "List of cross references for the scale to search for")


  public List<String> getScaleXrefs() {
    return scaleXrefs;
  }

  public void setScaleXrefs(List<String> scaleXrefs) {
    this.scaleXrefs = scaleXrefs;
  }

  public ObservationVariableSearchRequest traitClasses(List<String> traitClasses) {
    this.traitClasses = traitClasses;
    return this;
  }

  public ObservationVariableSearchRequest addTraitClassesItem(String traitClassesItem) {
    if (this.traitClasses == null) {
      this.traitClasses = new ArrayList<String>();
    }
    this.traitClasses.add(traitClassesItem);
    return this;
  }

  /**
   * List of trait classes to filter search results
   * @return traitClasses
  **/
  @ApiModelProperty(value = "List of trait classes to filter search results")


  public List<String> getTraitClasses() {
    return traitClasses;
  }

  public void setTraitClasses(List<String> traitClasses) {
    this.traitClasses = traitClasses;
  }

  public ObservationVariableSearchRequest traitDbIds(List<String> traitDbIds) {
    this.traitDbIds = traitDbIds;
    return this;
  }

  public ObservationVariableSearchRequest addTraitDbIdsItem(String traitDbIdsItem) {
    if (this.traitDbIds == null) {
      this.traitDbIds = new ArrayList<String>();
    }
    this.traitDbIds.add(traitDbIdsItem);
    return this;
  }

  /**
   * List of trait unique ID to filter search results
   * @return traitDbIds
  **/
  @ApiModelProperty(value = "List of trait unique ID to filter search results")


  public List<String> getTraitDbIds() {
    return traitDbIds;
  }

  public void setTraitDbIds(List<String> traitDbIds) {
    this.traitDbIds = traitDbIds;
  }

  public ObservationVariableSearchRequest traitXrefs(List<String> traitXrefs) {
    this.traitXrefs = traitXrefs;
    return this;
  }

  public ObservationVariableSearchRequest addTraitXrefsItem(String traitXrefsItem) {
    if (this.traitXrefs == null) {
      this.traitXrefs = new ArrayList<String>();
    }
    this.traitXrefs.add(traitXrefsItem);
    return this;
  }

  /**
   * List of cross references for the trait to search for
   * @return traitXrefs
  **/
  @ApiModelProperty(value = "List of cross references for the trait to search for")


  public List<String> getTraitXrefs() {
    return traitXrefs;
  }

  public void setTraitXrefs(List<String> traitXrefs) {
    this.traitXrefs = traitXrefs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationVariableSearchRequest observationVariableSearchRequest = (ObservationVariableSearchRequest) o;
    return Objects.equals(this.dataTypes, observationVariableSearchRequest.dataTypes) &&
        Objects.equals(this.methodDbIds, observationVariableSearchRequest.methodDbIds) &&
        Objects.equals(this.observationVariableDbIds, observationVariableSearchRequest.observationVariableDbIds) &&
        Objects.equals(this.observationVariableNames, observationVariableSearchRequest.observationVariableNames) &&
        Objects.equals(this.observationVariableXrefs, observationVariableSearchRequest.observationVariableXrefs) &&
        Objects.equals(this.ontologyDbIds, observationVariableSearchRequest.ontologyDbIds) &&
        Objects.equals(this.page, observationVariableSearchRequest.page) &&
        Objects.equals(this.pageSize, observationVariableSearchRequest.pageSize) &&
        Objects.equals(this.scaleDbIds, observationVariableSearchRequest.scaleDbIds) &&
        Objects.equals(this.scaleXrefs, observationVariableSearchRequest.scaleXrefs) &&
        Objects.equals(this.traitClasses, observationVariableSearchRequest.traitClasses) &&
        Objects.equals(this.traitDbIds, observationVariableSearchRequest.traitDbIds) &&
        Objects.equals(this.traitXrefs, observationVariableSearchRequest.traitXrefs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataTypes, methodDbIds, observationVariableDbIds, observationVariableNames, observationVariableXrefs, ontologyDbIds, page, pageSize, scaleDbIds, scaleXrefs, traitClasses, traitDbIds, traitXrefs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationVariableSearchRequest {\n");
    
    sb.append("    dataTypes: ").append(toIndentedString(dataTypes)).append("\n");
    sb.append("    methodDbIds: ").append(toIndentedString(methodDbIds)).append("\n");
    sb.append("    observationVariableDbIds: ").append(toIndentedString(observationVariableDbIds)).append("\n");
    sb.append("    observationVariableNames: ").append(toIndentedString(observationVariableNames)).append("\n");
    sb.append("    observationVariableXrefs: ").append(toIndentedString(observationVariableXrefs)).append("\n");
    sb.append("    ontologyDbIds: ").append(toIndentedString(ontologyDbIds)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    scaleDbIds: ").append(toIndentedString(scaleDbIds)).append("\n");
    sb.append("    scaleXrefs: ").append(toIndentedString(scaleXrefs)).append("\n");
    sb.append("    traitClasses: ").append(toIndentedString(traitClasses)).append("\n");
    sb.append("    traitDbIds: ").append(toIndentedString(traitDbIds)).append("\n");
    sb.append("    traitXrefs: ").append(toIndentedString(traitXrefs)).append("\n");
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

