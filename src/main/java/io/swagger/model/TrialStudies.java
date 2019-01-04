package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * TrialStudies
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class TrialStudies   {
  @JsonProperty("locationDbId")
  private String locationDbId = null;

  @JsonProperty("locationName")
  private String locationName = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  @JsonProperty("studyName")
  private String studyName = null;

  public TrialStudies locationDbId(String locationDbId) {
    this.locationDbId = locationDbId;
    return this;
  }

  /**
   * Get locationDbId
   * @return locationDbId
  **/
  @ApiModelProperty(value = "")


  public String getLocationDbId() {
    return locationDbId;
  }

  public void setLocationDbId(String locationDbId) {
    this.locationDbId = locationDbId;
  }

  public TrialStudies locationName(String locationName) {
    this.locationName = locationName;
    return this;
  }

  /**
   * Get locationName
   * @return locationName
  **/
  @ApiModelProperty(value = "")


  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public TrialStudies studyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
    return this;
  }

  /**
   * Get studyDbId
   * @return studyDbId
  **/
  @ApiModelProperty(value = "")


  public String getStudyDbId() {
    return studyDbId;
  }

  public void setStudyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
  }

  public TrialStudies studyName(String studyName) {
    this.studyName = studyName;
    return this;
  }

  /**
   * Get studyName
   * @return studyName
  **/
  @ApiModelProperty(value = "")


  public String getStudyName() {
    return studyName;
  }

  public void setStudyName(String studyName) {
    this.studyName = studyName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrialStudies trialStudies = (TrialStudies) o;
    return Objects.equals(this.locationDbId, trialStudies.locationDbId) &&
        Objects.equals(this.locationName, trialStudies.locationName) &&
        Objects.equals(this.studyDbId, trialStudies.studyDbId) &&
        Objects.equals(this.studyName, trialStudies.studyName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locationDbId, locationName, studyDbId, studyName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrialStudies {\n");
    
    sb.append("    locationDbId: ").append(toIndentedString(locationDbId)).append("\n");
    sb.append("    locationName: ").append(toIndentedString(locationName)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
    sb.append("    studyName: ").append(toIndentedString(studyName)).append("\n");
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

