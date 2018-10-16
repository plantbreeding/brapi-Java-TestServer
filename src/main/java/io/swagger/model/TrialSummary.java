package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.TrialStudies;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * TrialSummary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class TrialSummary   {
  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("endDate")
  private LocalDate endDate = null;

  @JsonProperty("programDbId")
  private String programDbId = null;

  @JsonProperty("programName")
  private String programName = null;

  @JsonProperty("startDate")
  private LocalDate startDate = null;

  @JsonProperty("studies")
  @Valid
  private List<TrialStudies> studies = null;

  @JsonProperty("trialDbId")
  private String trialDbId = null;

  @JsonProperty("trialName")
  private String trialName = null;

  public TrialSummary active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Is this trail currently active
   * @return active
  **/
  @ApiModelProperty(value = "Is this trail currently active")


  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public TrialSummary additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public TrialSummary putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = new HashMap<String, String>();
    }
    this.additionalInfo.put(key, additionalInfoItem);
    return this;
  }

   /**
   * Additional arbitrary info
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Additional arbitrary info")


  public Map<String, String> getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public TrialSummary endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

   /**
   * The date this trial ends
   * @return endDate
  **/
  @ApiModelProperty(value = "The date this trial ends")

  @Valid

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public TrialSummary programDbId(String programDbId) {
    this.programDbId = programDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies a program
   * @return programDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a program")


  public String getProgramDbId() {
    return programDbId;
  }

  public void setProgramDbId(String programDbId) {
    this.programDbId = programDbId;
  }

  public TrialSummary programName(String programName) {
    this.programName = programName;
    return this;
  }

   /**
   * The human readable name of a program
   * @return programName
  **/
  @ApiModelProperty(value = "The human readable name of a program")


  public String getProgramName() {
    return programName;
  }

  public void setProgramName(String programName) {
    this.programName = programName;
  }

  public TrialSummary startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * The date this trial started
   * @return startDate
  **/
  @ApiModelProperty(value = "The date this trial started")

  @Valid

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public TrialSummary studies(List<TrialStudies> studies) {
    this.studies = studies;
    return this;
  }

  public TrialSummary addStudiesItem(TrialStudies studiesItem) {
    if (this.studies == null) {
      this.studies = new ArrayList<TrialStudies>();
    }
    this.studies.add(studiesItem);
    return this;
  }

   /**
   * List of studies inside this trial
   * @return studies
  **/
  @ApiModelProperty(value = "List of studies inside this trial")

  @Valid

  public List<TrialStudies> getStudies() {
    return studies;
  }

  public void setStudies(List<TrialStudies> studies) {
    this.studies = studies;
  }

  public TrialSummary trialDbId(String trialDbId) {
    this.trialDbId = trialDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies a trial
   * @return trialDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a trial")


  public String getTrialDbId() {
    return trialDbId;
  }

  public void setTrialDbId(String trialDbId) {
    this.trialDbId = trialDbId;
  }

  public TrialSummary trialName(String trialName) {
    this.trialName = trialName;
    return this;
  }

   /**
   * The human readable name of a trial
   * @return trialName
  **/
  @ApiModelProperty(value = "The human readable name of a trial")


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
    TrialSummary trialSummary = (TrialSummary) o;
    return Objects.equals(this.active, trialSummary.active) &&
        Objects.equals(this.additionalInfo, trialSummary.additionalInfo) &&
        Objects.equals(this.endDate, trialSummary.endDate) &&
        Objects.equals(this.programDbId, trialSummary.programDbId) &&
        Objects.equals(this.programName, trialSummary.programName) &&
        Objects.equals(this.startDate, trialSummary.startDate) &&
        Objects.equals(this.studies, trialSummary.studies) &&
        Objects.equals(this.trialDbId, trialSummary.trialDbId) &&
        Objects.equals(this.trialName, trialSummary.trialName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, additionalInfo, endDate, programDbId, programName, startDate, studies, trialDbId, trialName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrialSummary {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    programDbId: ").append(toIndentedString(programDbId)).append("\n");
    sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    studies: ").append(toIndentedString(studies)).append("\n");
    sb.append("    trialDbId: ").append(toIndentedString(trialDbId)).append("\n");
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

