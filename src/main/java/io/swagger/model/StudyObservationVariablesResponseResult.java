package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ObservationVariable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * StudyObservationVariablesResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class StudyObservationVariablesResponseResult   {
  @JsonProperty("data")
  @Valid
  private List<ObservationVariable> data = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  @JsonProperty("trialName")
  private String trialName = null;

  public StudyObservationVariablesResponseResult data(List<ObservationVariable> data) {
    this.data = data;
    return this;
  }

  public StudyObservationVariablesResponseResult addDataItem(ObservationVariable dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<ObservationVariable>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ObservationVariable> getData() {
    return data;
  }

  public void setData(List<ObservationVariable> data) {
    this.data = data;
  }

  public StudyObservationVariablesResponseResult studyDbId(String studyDbId) {
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

  public StudyObservationVariablesResponseResult trialName(String trialName) {
    this.trialName = trialName;
    return this;
  }

   /**
   * Get trialName
   * @return trialName
  **/
  @ApiModelProperty(value = "")


  public String getTrialName() {
    return trialName;
  }

  public void setTrialName(String trialName) {
    this.trialName = trialName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudyObservationVariablesResponseResult studyObservationVariablesResponseResult = (StudyObservationVariablesResponseResult) o;
    return Objects.equals(this.data, studyObservationVariablesResponseResult.data) &&
        Objects.equals(this.studyDbId, studyObservationVariablesResponseResult.studyDbId) &&
        Objects.equals(this.trialName, studyObservationVariablesResponseResult.trialName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, studyDbId, trialName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudyObservationVariablesResponseResult {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
    sb.append("    trialName: ").append(toIndentedString(trialName)).append("\n");
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

