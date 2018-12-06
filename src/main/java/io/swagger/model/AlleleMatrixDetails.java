package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AlleleMatrixDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class AlleleMatrixDetails   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("lastUpdated")
  private OffsetDateTime lastUpdated = null;

  @JsonProperty("matrixDbId")
  private String matrixDbId = null;

  @JsonProperty("matrixName")
  private String matrixName = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  public AlleleMatrixDetails description(String description) {
    this.description = description;
    return this;
  }

  /**
   * How the matrix was generated
   * @return description
  **/
  @ApiModelProperty(value = "How the matrix was generated")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AlleleMatrixDetails lastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * A date format
   * @return lastUpdated
  **/
  @ApiModelProperty(value = "A date format")

  @Valid

  public OffsetDateTime getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public AlleleMatrixDetails matrixDbId(String matrixDbId) {
    this.matrixDbId = matrixDbId;
    return this;
  }

  /**
   * ID of the matrix
   * @return matrixDbId
  **/
  @ApiModelProperty(value = "ID of the matrix")


  public String getMatrixDbId() {
    return matrixDbId;
  }

  public void setMatrixDbId(String matrixDbId) {
    this.matrixDbId = matrixDbId;
  }

  public AlleleMatrixDetails matrixName(String matrixName) {
    this.matrixName = matrixName;
    return this;
  }

  /**
   * Name of the matrix
   * @return matrixName
  **/
  @ApiModelProperty(value = "Name of the matrix")


  public String getMatrixName() {
    return matrixName;
  }

  public void setMatrixName(String matrixName) {
    this.matrixName = matrixName;
  }

  public AlleleMatrixDetails name(String name) {
    this.name = name;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - Use \"matrixName\"
   * @return name
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - Use \"matrixName\"")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AlleleMatrixDetails studyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
    return this;
  }

  /**
   * Link to the study where the matrix was produced
   * @return studyDbId
  **/
  @ApiModelProperty(value = "Link to the study where the matrix was produced")


  public String getStudyDbId() {
    return studyDbId;
  }

  public void setStudyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlleleMatrixDetails alleleMatrixDetails = (AlleleMatrixDetails) o;
    return Objects.equals(this.description, alleleMatrixDetails.description) &&
        Objects.equals(this.lastUpdated, alleleMatrixDetails.lastUpdated) &&
        Objects.equals(this.matrixDbId, alleleMatrixDetails.matrixDbId) &&
        Objects.equals(this.matrixName, alleleMatrixDetails.matrixName) &&
        Objects.equals(this.name, alleleMatrixDetails.name) &&
        Objects.equals(this.studyDbId, alleleMatrixDetails.studyDbId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, lastUpdated, matrixDbId, matrixName, name, studyDbId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlleleMatrixDetails {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    matrixDbId: ").append(toIndentedString(matrixDbId)).append("\n");
    sb.append("    matrixName: ").append(toIndentedString(matrixName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
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

