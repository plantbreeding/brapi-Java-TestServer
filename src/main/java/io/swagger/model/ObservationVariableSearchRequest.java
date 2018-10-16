package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ObservationVariableSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class ObservationVariableSearchRequest   {
  @JsonProperty("datatypes")
  @Valid
  private List<String> datatypes = null;

  @JsonProperty("methodDbIds")
  @Valid
  private List<String> methodDbIds = null;

  @JsonProperty("names")
  @Valid
  private List<String> names = null;

  @JsonProperty("observationVariableDbIds")
  @Valid
  private List<String> observationVariableDbIds = null;

  @JsonProperty("ontologyDbIds")
  @Valid
  private List<String> ontologyDbIds = null;

  @JsonProperty("ontologyXrefs")
  @Valid
  private List<String> ontologyXrefs = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("pageSize")
  private Integer pageSize = null;

  @JsonProperty("scaleDbIds")
  @Valid
  private List<String> scaleDbIds = null;

  @JsonProperty("traitClasses")
  @Valid
  private List<String> traitClasses = null;

  public ObservationVariableSearchRequest datatypes(List<String> datatypes) {
    this.datatypes = datatypes;
    return this;
  }

  public ObservationVariableSearchRequest addDatatypesItem(String datatypesItem) {
    if (this.datatypes == null) {
      this.datatypes = new ArrayList<String>();
    }
    this.datatypes.add(datatypesItem);
    return this;
  }

   /**
   * List of scale data types to filter search results
   * @return datatypes
  **/
  @ApiModelProperty(value = "List of scale data types to filter search results")


  public List<String> getDatatypes() {
    return datatypes;
  }

  public void setDatatypes(List<String> datatypes) {
    this.datatypes = datatypes;
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

  public ObservationVariableSearchRequest names(List<String> names) {
    this.names = names;
    return this;
  }

  public ObservationVariableSearchRequest addNamesItem(String namesItem) {
    if (this.names == null) {
      this.names = new ArrayList<String>();
    }
    this.names.add(namesItem);
    return this;
  }

   /**
   * List of human readable observation variable names to search for
   * @return names
  **/
  @ApiModelProperty(value = "List of human readable observation variable names to search for")


  public List<String> getNames() {
    return names;
  }

  public void setNames(List<String> names) {
    this.names = names;
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

  public ObservationVariableSearchRequest ontologyXrefs(List<String> ontologyXrefs) {
    this.ontologyXrefs = ontologyXrefs;
    return this;
  }

  public ObservationVariableSearchRequest addOntologyXrefsItem(String ontologyXrefsItem) {
    if (this.ontologyXrefs == null) {
      this.ontologyXrefs = new ArrayList<String>();
    }
    this.ontologyXrefs.add(ontologyXrefsItem);
    return this;
  }

   /**
   * List of ontology IDs to search for
   * @return ontologyXrefs
  **/
  @ApiModelProperty(value = "List of ontology IDs to search for")


  public List<String> getOntologyXrefs() {
    return ontologyXrefs;
  }

  public void setOntologyXrefs(List<String> ontologyXrefs) {
    this.ontologyXrefs = ontologyXrefs;
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationVariableSearchRequest observationVariableSearchRequest = (ObservationVariableSearchRequest) o;
    return Objects.equals(this.datatypes, observationVariableSearchRequest.datatypes) &&
        Objects.equals(this.methodDbIds, observationVariableSearchRequest.methodDbIds) &&
        Objects.equals(this.names, observationVariableSearchRequest.names) &&
        Objects.equals(this.observationVariableDbIds, observationVariableSearchRequest.observationVariableDbIds) &&
        Objects.equals(this.ontologyDbIds, observationVariableSearchRequest.ontologyDbIds) &&
        Objects.equals(this.ontologyXrefs, observationVariableSearchRequest.ontologyXrefs) &&
        Objects.equals(this.page, observationVariableSearchRequest.page) &&
        Objects.equals(this.pageSize, observationVariableSearchRequest.pageSize) &&
        Objects.equals(this.scaleDbIds, observationVariableSearchRequest.scaleDbIds) &&
        Objects.equals(this.traitClasses, observationVariableSearchRequest.traitClasses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(datatypes, methodDbIds, names, observationVariableDbIds, ontologyDbIds, ontologyXrefs, page, pageSize, scaleDbIds, traitClasses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationVariableSearchRequest {\n");
    
    sb.append("    datatypes: ").append(toIndentedString(datatypes)).append("\n");
    sb.append("    methodDbIds: ").append(toIndentedString(methodDbIds)).append("\n");
    sb.append("    names: ").append(toIndentedString(names)).append("\n");
    sb.append("    observationVariableDbIds: ").append(toIndentedString(observationVariableDbIds)).append("\n");
    sb.append("    ontologyDbIds: ").append(toIndentedString(ontologyDbIds)).append("\n");
    sb.append("    ontologyXrefs: ").append(toIndentedString(ontologyXrefs)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    scaleDbIds: ").append(toIndentedString(scaleDbIds)).append("\n");
    sb.append("    traitClasses: ").append(toIndentedString(traitClasses)).append("\n");
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

