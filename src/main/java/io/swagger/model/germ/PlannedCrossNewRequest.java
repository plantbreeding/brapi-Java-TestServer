package io.swagger.model.germ;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ExternalReferences;
import io.swagger.model.germ.CrossParent;

import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * PlannedCrossNewRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class PlannedCrossNewRequest   {
  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("crossType")
  private CrossType crossType = null;

  @JsonProperty("crossingProjectDbId")
  private String crossingProjectDbId = null;

  @JsonProperty("crossingProjectName")
  private String crossingProjectName = null;

  @JsonProperty("externalReferences")
  private ExternalReferences externalReferences = null;

  @JsonProperty("parent1")
  private CrossParent parent1 = null;

  @JsonProperty("parent2")
  private CrossParent parent2 = null;

  @JsonProperty("plannedCrossName")
  private String plannedCrossName = null;

  public PlannedCrossNewRequest additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public PlannedCrossNewRequest putAdditionalInfoItem(String key, String additionalInfoItem) {
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

  public PlannedCrossNewRequest crossType(CrossType crossType) {
    this.crossType = crossType;
    return this;
  }

  /**
   * the type of cross
   * @return crossType
  **/
  @ApiModelProperty(example = "BIPARENTAL", value = "the type of cross")
  
    public CrossType getCrossType() {
    return crossType;
  }

  public void setCrossType(CrossType crossType) {
    this.crossType = crossType;
  }

  public PlannedCrossNewRequest crossingProjectDbId(String crossingProjectDbId) {
    this.crossingProjectDbId = crossingProjectDbId;
    return this;
  }

  /**
   * the unique identifier for a crossing project
   * @return crossingProjectDbId
  **/
  @ApiModelProperty(example = "696d7c92", value = "the unique identifier for a crossing project")
  
    public String getCrossingProjectDbId() {
    return crossingProjectDbId;
  }

  public void setCrossingProjectDbId(String crossingProjectDbId) {
    this.crossingProjectDbId = crossingProjectDbId;
  }

  public PlannedCrossNewRequest crossingProjectName(String crossingProjectName) {
    this.crossingProjectName = crossingProjectName;
    return this;
  }

  /**
   * the human readable name for a crossing project
   * @return crossingProjectName
  **/
  @ApiModelProperty(example = "my_Ibadan_Crosses_2018", value = "the human readable name for a crossing project")
  
    public String getCrossingProjectName() {
    return crossingProjectName;
  }

  public void setCrossingProjectName(String crossingProjectName) {
    this.crossingProjectName = crossingProjectName;
  }

  public PlannedCrossNewRequest externalReferences(ExternalReferences externalReferences) {
    this.externalReferences = externalReferences;
    return this;
  }

  /**
   * Get externalReferences
   * @return externalReferences
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ExternalReferences getExternalReferences() {
    return externalReferences;
  }

  public void setExternalReferences(ExternalReferences externalReferences) {
    this.externalReferences = externalReferences;
  }

  public PlannedCrossNewRequest parent1(CrossParent parent1) {
    this.parent1 = parent1;
    return this;
  }

  /**
   * Get parent1
   * @return parent1
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public CrossParent getParent1() {
    return parent1;
  }

  public void setParent1(CrossParent parent1) {
    this.parent1 = parent1;
  }

  public PlannedCrossNewRequest parent2(CrossParent parent2) {
    this.parent2 = parent2;
    return this;
  }

  /**
   * Get parent2
   * @return parent2
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public CrossParent getParent2() {
    return parent2;
  }

  public void setParent2(CrossParent parent2) {
    this.parent2 = parent2;
  }

  public PlannedCrossNewRequest plannedCrossName(String plannedCrossName) {
    this.plannedCrossName = plannedCrossName;
    return this;
  }

  /**
   * the human readable name for a cross
   * @return plannedCrossName
  **/
  @ApiModelProperty(example = "my_Ibadan_Crosses_2018_01", value = "the human readable name for a cross")
  
    public String getPlannedCrossName() {
    return plannedCrossName;
  }

  public void setPlannedCrossName(String plannedCrossName) {
    this.plannedCrossName = plannedCrossName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlannedCrossNewRequest plannedCrossNewRequest = (PlannedCrossNewRequest) o;
    return Objects.equals(this.additionalInfo, plannedCrossNewRequest.additionalInfo) &&
        Objects.equals(this.crossType, plannedCrossNewRequest.crossType) &&
        Objects.equals(this.crossingProjectDbId, plannedCrossNewRequest.crossingProjectDbId) &&
        Objects.equals(this.crossingProjectName, plannedCrossNewRequest.crossingProjectName) &&
        Objects.equals(this.externalReferences, plannedCrossNewRequest.externalReferences) &&
        Objects.equals(this.parent1, plannedCrossNewRequest.parent1) &&
        Objects.equals(this.parent2, plannedCrossNewRequest.parent2) &&
        Objects.equals(this.plannedCrossName, plannedCrossNewRequest.plannedCrossName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, crossType, crossingProjectDbId, crossingProjectName, externalReferences, parent1, parent2, plannedCrossName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlannedCrossNewRequest {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    crossType: ").append(toIndentedString(crossType)).append("\n");
    sb.append("    crossingProjectDbId: ").append(toIndentedString(crossingProjectDbId)).append("\n");
    sb.append("    crossingProjectName: ").append(toIndentedString(crossingProjectName)).append("\n");
    sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
    sb.append("    parent1: ").append(toIndentedString(parent1)).append("\n");
    sb.append("    parent2: ").append(toIndentedString(parent2)).append("\n");
    sb.append("    plannedCrossName: ").append(toIndentedString(plannedCrossName)).append("\n");
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
