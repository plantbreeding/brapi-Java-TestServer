package io.swagger.model.core;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Observation levels indicate the granularity level at which the measurements are taken. &#x60;levelName&#x60; defines the level, &#x60;levelOrder&#x60; defines where that level exists in the hierarchy of levels. &#x60;levelOrder&#x60;s lower numbers are at the top of the hierarchy (ie field &gt; 0) and higher numbers are at the bottom of the hierarchy (ie plant &gt; 6). 
 */
@ApiModel(description = "Observation levels indicate the granularity level at which the measurements are taken. `levelName` defines the level, `levelOrder` defines where that level exists in the hierarchy of levels. `levelOrder`s lower numbers are at the top of the hierarchy (ie field > 0) and higher numbers are at the bottom of the hierarchy (ie plant > 6). ")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class ObservationUnitHierarchyLevel   {
  /**
   * A name for this level
   */
  public enum LevelNameEnum {
    STUDY("study"),
    
    FIELD("field"),
    
    ENTRY("entry"),
    
    REP("rep"),
    
    BLOCK("block"),
    
    SUB_BLOCK("sub-block"),
    
    PLOT("plot"),
    
    SUB_PLOT("sub-plot"),
    
    PLANT("plant"),
    
    POT("pot"),
    
    SAMPLE("sample");

    private String value;

    LevelNameEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LevelNameEnum fromValue(String text) {
      for (LevelNameEnum b : LevelNameEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("levelName")
  private LevelNameEnum levelName = null;

  @JsonProperty("levelOrder")
  private Integer levelOrder = null;

  public ObservationUnitHierarchyLevel levelName(LevelNameEnum levelName) {
    this.levelName = levelName;
    return this;
  }

  /**
   * A name for this level
   * @return levelName
  **/
  @ApiModelProperty(example = "plot", value = "A name for this level")
  
    public LevelNameEnum getLevelName() {
    return levelName;
  }

  public void setLevelName(LevelNameEnum levelName) {
    this.levelName = levelName;
  }

  public ObservationUnitHierarchyLevel levelOrder(Integer levelOrder) {
    this.levelOrder = levelOrder;
    return this;
  }

  /**
   * `levelOrder` defines where that level exists in the hierarchy of levels. `levelOrder`'s lower numbers are at the top of the hierarchy (ie field -> 1) and higher numbers are at the bottom of the hierarchy (ie plant -> 9).
   * @return levelOrder
  **/
  @ApiModelProperty(example = "2", value = "`levelOrder` defines where that level exists in the hierarchy of levels. `levelOrder`'s lower numbers are at the top of the hierarchy (ie field -> 1) and higher numbers are at the bottom of the hierarchy (ie plant -> 9).")
  
    public Integer getLevelOrder() {
    return levelOrder;
  }

  public void setLevelOrder(Integer levelOrder) {
    this.levelOrder = levelOrder;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationUnitHierarchyLevel observationUnitHierarchyLevel = (ObservationUnitHierarchyLevel) o;
    return Objects.equals(this.levelName, observationUnitHierarchyLevel.levelName) &&
        Objects.equals(this.levelOrder, observationUnitHierarchyLevel.levelOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(levelName, levelOrder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationUnitHierarchyLevel {\n");
    
    sb.append("    levelName: ").append(toIndentedString(levelName)).append("\n");
    sb.append("    levelOrder: ").append(toIndentedString(levelOrder)).append("\n");
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
