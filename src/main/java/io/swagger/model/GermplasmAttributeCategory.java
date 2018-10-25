package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GermplasmAttributeCategory
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class GermplasmAttributeCategory   {
  @JsonProperty("attributeCategoryDbId")
  private String attributeCategoryDbId = null;

  @JsonProperty("attributeCategoryName")
  private String attributeCategoryName = null;

  @JsonProperty("name")
  private String name = null;

  public GermplasmAttributeCategory attributeCategoryDbId(String attributeCategoryDbId) {
    this.attributeCategoryDbId = attributeCategoryDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies this attribute category within the given database server
   * @return attributeCategoryDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies this attribute category within the given database server")


  public String getAttributeCategoryDbId() {
    return attributeCategoryDbId;
  }

  public void setAttributeCategoryDbId(String attributeCategoryDbId) {
    this.attributeCategoryDbId = attributeCategoryDbId;
  }

  public GermplasmAttributeCategory attributeCategoryName(String attributeCategoryName) {
    this.attributeCategoryName = attributeCategoryName;
    return this;
  }

  /**
   * A human readable name for this attribute category. Very similar to Trait class. (examples: \"morphologic\", \"phenologic\", \"agronomic\", \"physiologic\", \"abiotic stress\", \"biotic stress\", \"biochemic\", \"quality traits\", \"fertility\", etc.)
   * @return attributeCategoryName
  **/
  @ApiModelProperty(value = "A human readable name for this attribute category. Very similar to Trait class. (examples: \"morphologic\", \"phenologic\", \"agronomic\", \"physiologic\", \"abiotic stress\", \"biotic stress\", \"biochemic\", \"quality traits\", \"fertility\", etc.)")


  public String getAttributeCategoryName() {
    return attributeCategoryName;
  }

  public void setAttributeCategoryName(String attributeCategoryName) {
    this.attributeCategoryName = attributeCategoryName;
  }

  public GermplasmAttributeCategory name(String name) {
    this.name = name;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - Use \"attributeCategoryName\"
   * @return name
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - Use \"attributeCategoryName\"")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GermplasmAttributeCategory germplasmAttributeCategory = (GermplasmAttributeCategory) o;
    return Objects.equals(this.attributeCategoryDbId, germplasmAttributeCategory.attributeCategoryDbId) &&
        Objects.equals(this.attributeCategoryName, germplasmAttributeCategory.attributeCategoryName) &&
        Objects.equals(this.name, germplasmAttributeCategory.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeCategoryDbId, attributeCategoryName, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmAttributeCategory {\n");
    
    sb.append("    attributeCategoryDbId: ").append(toIndentedString(attributeCategoryDbId)).append("\n");
    sb.append("    attributeCategoryName: ").append(toIndentedString(attributeCategoryName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

