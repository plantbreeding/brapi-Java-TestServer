package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * GermplasmAttributeCategory
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class GermplasmAttributeCategory   {
  @JsonProperty("attributeCategoryDbId")
  private String attributeCategoryDbId = null;

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

  public GermplasmAttributeCategory name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A human readable name for this attribute category
   * @return name
  **/
  @ApiModelProperty(value = "A human readable name for this attribute category")


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
        Objects.equals(this.name, germplasmAttributeCategory.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeCategoryDbId, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmAttributeCategory {\n");
    
    sb.append("    attributeCategoryDbId: ").append(toIndentedString(attributeCategoryDbId)).append("\n");
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

