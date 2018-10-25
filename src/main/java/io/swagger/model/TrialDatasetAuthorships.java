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
 * TrialDatasetAuthorships
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class TrialDatasetAuthorships   {
  @JsonProperty("datasetPUI")
  private String datasetPUI = null;

  @JsonProperty("license")
  private String license = null;

  public TrialDatasetAuthorships datasetPUI(String datasetPUI) {
    this.datasetPUI = datasetPUI;
    return this;
  }

  /**
   * Get datasetPUI
   * @return datasetPUI
  **/
  @ApiModelProperty(value = "")


  public String getDatasetPUI() {
    return datasetPUI;
  }

  public void setDatasetPUI(String datasetPUI) {
    this.datasetPUI = datasetPUI;
  }

  public TrialDatasetAuthorships license(String license) {
    this.license = license;
    return this;
  }

  /**
   * Get license
   * @return license
  **/
  @ApiModelProperty(value = "")


  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrialDatasetAuthorships trialDatasetAuthorships = (TrialDatasetAuthorships) o;
    return Objects.equals(this.datasetPUI, trialDatasetAuthorships.datasetPUI) &&
        Objects.equals(this.license, trialDatasetAuthorships.license);
  }

  @Override
  public int hashCode() {
    return Objects.hash(datasetPUI, license);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrialDatasetAuthorships {\n");
    
    sb.append("    datasetPUI: ").append(toIndentedString(datasetPUI)).append("\n");
    sb.append("    license: ").append(toIndentedString(license)).append("\n");
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

