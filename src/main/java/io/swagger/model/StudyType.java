package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * StudyType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class StudyType   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  public StudyType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of this study type
   * @return description
  **/
  @ApiModelProperty(value = "The description of this study type")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public StudyType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The human readable name of a study type
   * @return name
  **/
  @ApiModelProperty(value = "The human readable name of a study type")


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
    StudyType studyType = (StudyType) o;
    return Objects.equals(this.description, studyType.description) &&
        Objects.equals(this.name, studyType.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudyType {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

