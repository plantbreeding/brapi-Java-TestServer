package io.swagger.model.germ;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * ProgenyNodeProgeny
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class ProgenyNodeProgeny   {
  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("germplasmName")
  private String germplasmName = null;

  /**
   * Given a germplasm A having a progeny B and C, 'parentType' for progeny B item refers to the 'parentType' of A toward B.
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

  public ProgenyNodeProgeny germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

  /**
   * The unique identifier of a progeny germplasm
   * @return germplasmDbId
  **/
  @ApiModelProperty(example = "e8d5dad7", required = true, value = "The unique identifier of a progeny germplasm")
      @NotNull

    public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public ProgenyNodeProgeny germplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
    return this;
  }

  /**
   * The human readable name of a progeny germplasm
   * @return germplasmName
  **/
  @ApiModelProperty(example = "A0021011", value = "The human readable name of a progeny germplasm")
  
    public String getGermplasmName() {
    return germplasmName;
  }

  public void setGermplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
  }

  public ProgenyNodeProgeny parentType(ParentTypeEnum parentType) {
    this.parentType = parentType;
    return this;
  }

  /**
   * Given a germplasm A having a progeny B and C, 'parentType' for progeny B item refers to the 'parentType' of A toward B.
   * @return parentType
  **/
  @ApiModelProperty(example = "FEMALE", required = true, value = "Given a germplasm A having a progeny B and C, 'parentType' for progeny B item refers to the 'parentType' of A toward B.")
      @NotNull

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
    ProgenyNodeProgeny progenyNodeProgeny = (ProgenyNodeProgeny) o;
    return Objects.equals(this.germplasmDbId, progenyNodeProgeny.germplasmDbId) &&
        Objects.equals(this.germplasmName, progenyNodeProgeny.germplasmName) &&
        Objects.equals(this.parentType, progenyNodeProgeny.parentType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(germplasmDbId, germplasmName, parentType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgenyNodeProgeny {\n");
    
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
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
