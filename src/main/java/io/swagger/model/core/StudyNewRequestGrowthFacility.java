package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Short description of the facility in which the study was carried out.
 */
@ApiModel(description = "Short description of the facility in which the study was carried out.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class StudyNewRequestGrowthFacility   {
  @JsonProperty("PUI")
  private String PUI = null;

  @JsonProperty("description")
  private String description = null;

  public StudyNewRequestGrowthFacility PUI(String PUI) {
    this.PUI = PUI;
    return this;
  }

  /**
   * MIAPPE V1.1 (DM-27) Type of growth facility - Type of growth facility in which the study was carried out, in the form of an accession number from the Crop Ontology.
   * @return PUI
  **/
  @ApiModelProperty(example = "CO_715:0000162", value = "MIAPPE V1.1 (DM-27) Type of growth facility - Type of growth facility in which the study was carried out, in the form of an accession number from the Crop Ontology.")
  
    public String getPUI() {
    return PUI;
  }

  public void setPUI(String PUI) {
    this.PUI = PUI;
  }

  public StudyNewRequestGrowthFacility description(String description) {
    this.description = description;
    return this;
  }

  /**
   * MIAPPE V1.1 (DM-26) Description of growth facility - Short description of the facility in which the study was carried out.
   * @return description
  **/
  @ApiModelProperty(example = "field environment condition, greenhouse", value = "MIAPPE V1.1 (DM-26) Description of growth facility - Short description of the facility in which the study was carried out.")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudyNewRequestGrowthFacility studyNewRequestGrowthFacility = (StudyNewRequestGrowthFacility) o;
    return Objects.equals(this.PUI, studyNewRequestGrowthFacility.PUI) &&
        Objects.equals(this.description, studyNewRequestGrowthFacility.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(PUI, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudyNewRequestGrowthFacility {\n");
    
    sb.append("    PUI: ").append(toIndentedString(PUI)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
