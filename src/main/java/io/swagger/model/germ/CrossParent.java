package io.swagger.model.germ;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * CrossParent
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class CrossParent   {
  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("germplasmName")
  private String germplasmName = null;

  @JsonProperty("observationUnitDbId")
  private String observationUnitDbId = null;

  @JsonProperty("observationUnitName")
  private String observationUnitName = null;

  /**
   * The type of parent ex. 'MALE', 'FEMALE', 'SELF', 'POPULATION', etc.
   */
  public enum ParentTypeEnum {
    MALE("MALE"),
    
    FEMALE("FEMALE"),
    
    SELF("SELF"),
    
    POPULATION("POPULATION");

    private String value;

    ParentTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ParentTypeEnum fromValue(String text) {
      for (ParentTypeEnum b : ParentTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("parentType")
  private ParentTypeEnum parentType = null;

  public CrossParent germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

  /**
   * the unique identifier for a germplasm
   * @return germplasmDbId
  **/
  @ApiModelProperty(example = "d34b10c3", value = "the unique identifier for a germplasm")
  
    public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public CrossParent germplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
    return this;
  }

  /**
   * the human readable name for a germplasm
   * @return germplasmName
  **/
  @ApiModelProperty(example = "TME_419", value = "the human readable name for a germplasm")
  
    public String getGermplasmName() {
    return germplasmName;
  }

  public void setGermplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
  }

  public CrossParent observationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
    return this;
  }

  /**
   * the unique identifier for an observation unit
   * @return observationUnitDbId
  **/
  @ApiModelProperty(example = "2e1926a7", value = "the unique identifier for an observation unit")
  
    public String getObservationUnitDbId() {
    return observationUnitDbId;
  }

  public void setObservationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
  }

  public CrossParent observationUnitName(String observationUnitName) {
    this.observationUnitName = observationUnitName;
    return this;
  }

  /**
   * the human readable name for an observation unit
   * @return observationUnitName
  **/
  @ApiModelProperty(example = "my_Ibadan_Plot_9001", value = "the human readable name for an observation unit")
  
    public String getObservationUnitName() {
    return observationUnitName;
  }

  public void setObservationUnitName(String observationUnitName) {
    this.observationUnitName = observationUnitName;
  }

  public CrossParent parentType(ParentTypeEnum parentType) {
    this.parentType = parentType;
    return this;
  }

  /**
   * The type of parent ex. 'MALE', 'FEMALE', 'SELF', 'POPULATION', etc.
   * @return parentType
  **/
  @ApiModelProperty(example = "MALE", value = "The type of parent ex. 'MALE', 'FEMALE', 'SELF', 'POPULATION', etc.")
  
    public ParentTypeEnum getParentType() {
    return parentType;
  }

  public void setParentType(ParentTypeEnum parentType) {
    this.parentType = parentType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CrossParent crossParent = (CrossParent) o;
    return Objects.equals(this.germplasmDbId, crossParent.germplasmDbId) &&
        Objects.equals(this.germplasmName, crossParent.germplasmName) &&
        Objects.equals(this.observationUnitDbId, crossParent.observationUnitDbId) &&
        Objects.equals(this.observationUnitName, crossParent.observationUnitName) &&
        Objects.equals(this.parentType, crossParent.parentType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(germplasmDbId, germplasmName, observationUnitDbId, observationUnitName, parentType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrossParent {\n");
    
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
    sb.append("    observationUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
    sb.append("    observationUnitName: ").append(toIndentedString(observationUnitName)).append("\n");
    sb.append("    parentType: ").append(toIndentedString(parentType)).append("\n");
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
