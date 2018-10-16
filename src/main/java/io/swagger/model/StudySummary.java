package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * StudySummary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class StudySummary   {
  @JsonProperty("active")
  private String active = null;

  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("endDate")
  private LocalDate endDate = null;

  @JsonProperty("locationDbId")
  private String locationDbId = null;

  @JsonProperty("locationName")
  private String locationName = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("programDbId")
  private String programDbId = null;

  @JsonProperty("programName")
  private String programName = null;

  @JsonProperty("seasons")
  @Valid
  private List<String> seasons = null;

  @JsonProperty("startDate")
  private LocalDate startDate = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  @JsonProperty("studyType")
  private String studyType = null;

  @JsonProperty("trialDbId")
  private String trialDbId = null;

  @JsonProperty("trialName")
  private String trialName = null;


  public String getActive() {
	return active;
}

public void setActive(String active) {
	this.active = active;
}

public StudySummary additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public StudySummary putAdditionalInfoItem(String key, String additionalInfoItem) {
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

  public StudySummary endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

   /**
   * The date the study ends
   * @return endDate
  **/
  @ApiModelProperty(value = "The date the study ends")

  @Valid

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public StudySummary locationDbId(String locationDbId) {
    this.locationDbId = locationDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies a location
   * @return locationDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a location")


  public String getLocationDbId() {
    return locationDbId;
  }

  public void setLocationDbId(String locationDbId) {
    this.locationDbId = locationDbId;
  }

  public StudySummary locationName(String locationName) {
    this.locationName = locationName;
    return this;
  }

   /**
   * The human readable name for a location
   * @return locationName
  **/
  @ApiModelProperty(value = "The human readable name for a location")


  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public StudySummary name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The humane readable name of a study
   * @return name
  **/
  @ApiModelProperty(value = "The humane readable name of a study")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public StudySummary programDbId(String programDbId) {
    this.programDbId = programDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies a program within the given database server
   * @return programDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a program within the given database server")


  public String getProgramDbId() {
    return programDbId;
  }

  public void setProgramDbId(String programDbId) {
    this.programDbId = programDbId;
  }

  public StudySummary programName(String programName) {
    this.programName = programName;
    return this;
  }

   /**
   * The humane readable name of a program
   * @return programName
  **/
  @ApiModelProperty(value = "The humane readable name of a program")


  public String getProgramName() {
    return programName;
  }

  public void setProgramName(String programName) {
    this.programName = programName;
  }

  public StudySummary seasons(List<String> seasons) {
    this.seasons = seasons;
    return this;
  }

  public StudySummary addSeasonsItem(String seasonsItem) {
    if (this.seasons == null) {
      this.seasons = new ArrayList<String>();
    }
    this.seasons.add(seasonsItem);
    return this;
  }

   /**
   * List of seasons over which this study was performed.
   * @return seasons
  **/
  @ApiModelProperty(value = "List of seasons over which this study was performed.")


  public List<String> getSeasons() {
    return seasons;
  }

  public void setSeasons(List<String> seasons) {
    this.seasons = seasons;
  }

  public StudySummary startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * The date this study started
   * @return startDate
  **/
  @ApiModelProperty(value = "The date this study started")

  @Valid

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public StudySummary studyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies a study within the given database server
   * @return studyDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a study within the given database server")


  public String getStudyDbId() {
    return studyDbId;
  }

  public void setStudyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
  }

  public StudySummary studyType(String studyType) {
    this.studyType = studyType;
    return this;
  }

   /**
   * The type of study being performed. ex. \"Yeald Trial\", etc
   * @return studyType
  **/
  @ApiModelProperty(value = "The type of study being performed. ex. \"Yeald Trial\", etc")


  public String getStudyType() {
    return studyType;
  }

  public void setStudyType(String studyType) {
    this.studyType = studyType;
  }

  public StudySummary trialDbId(String trialDbId) {
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

  public StudySummary trialName(String trialName) {
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
    StudySummary studySummary = (StudySummary) o;
    return Objects.equals(this.active, studySummary.active) &&
        Objects.equals(this.additionalInfo, studySummary.additionalInfo) &&
        Objects.equals(this.endDate, studySummary.endDate) &&
        Objects.equals(this.locationDbId, studySummary.locationDbId) &&
        Objects.equals(this.locationName, studySummary.locationName) &&
        Objects.equals(this.name, studySummary.name) &&
        Objects.equals(this.programDbId, studySummary.programDbId) &&
        Objects.equals(this.programName, studySummary.programName) &&
        Objects.equals(this.seasons, studySummary.seasons) &&
        Objects.equals(this.startDate, studySummary.startDate) &&
        Objects.equals(this.studyDbId, studySummary.studyDbId) &&
        Objects.equals(this.studyType, studySummary.studyType) &&
        Objects.equals(this.trialDbId, studySummary.trialDbId) &&
        Objects.equals(this.trialName, studySummary.trialName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, additionalInfo, endDate, locationDbId, locationName, name, programDbId, programName, seasons, startDate, studyDbId, studyType, trialDbId, trialName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudySummary {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    locationDbId: ").append(toIndentedString(locationDbId)).append("\n");
    sb.append("    locationName: ").append(toIndentedString(locationName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    programDbId: ").append(toIndentedString(programDbId)).append("\n");
    sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
    sb.append("    seasons: ").append(toIndentedString(seasons)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
    sb.append("    studyType: ").append(toIndentedString(studyType)).append("\n");
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

