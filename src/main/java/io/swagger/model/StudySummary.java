package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Season;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StudySummary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-06T17:40:52.157-05:00[America/New_York]")

public class StudySummary   {
  @JsonProperty("active")
  private String active = null;

  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("commonCropName")
  private String commonCropName = null;

  @JsonProperty("documentationURL")
  private String documentationURL = null;

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
  private List<Season> seasons = null;

  @JsonProperty("startDate")
  private LocalDate startDate = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  @JsonProperty("studyName")
  private String studyName = null;

  @JsonProperty("studyType")
  private String studyType = null;

  @JsonProperty("studyTypeDbId")
  private String studyTypeDbId = null;

  @JsonProperty("studyTypeName")
  private String studyTypeName = null;

  @JsonProperty("trialDbId")
  private String trialDbId = null;

  @JsonProperty("trialName")
  private String trialName = null;

  public StudySummary active(String active) {
    this.active = active;
    return this;
  }

  /**
   * Is this study currently active
   * @return active
  **/
  @ApiModelProperty(value = "Is this study currently active")


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
      this.additionalInfo = null;
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

  public StudySummary commonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
    return this;
  }

  /**
   * Common name for the crop associated with this study
   * @return commonCropName
  **/
  @ApiModelProperty(value = "Common name for the crop associated with this study")


  public String getCommonCropName() {
    return commonCropName;
  }

  public void setCommonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
  }

  public StudySummary documentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
    return this;
  }

  /**
   * A URL to the human readable documentation of this object
   * @return documentationURL
  **/
  @ApiModelProperty(value = "A URL to the human readable documentation of this object")


  public String getDocumentationURL() {
    return documentationURL;
  }

  public void setDocumentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
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
   * DEPRECATED in v1.3 - Use \"studyName\"
   * @return name
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - Use \"studyName\"")


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

  public StudySummary seasons(List<Season> seasons) {
    this.seasons = seasons;
    return this;
  }

  public StudySummary addSeasonsItem(Season seasonsItem) {
    if (this.seasons == null) {
      this.seasons = new ArrayList<Season>();
    }
    this.seasons.add(seasonsItem);
    return this;
  }

  /**
   * List of seasons over which this study was performed.
   * @return seasons
  **/
  @ApiModelProperty(value = "List of seasons over which this study was performed.")

  @Valid

  public List<Season> getSeasons() {
    return seasons;
  }

  public void setSeasons(List<Season> seasons) {
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

  public StudySummary studyName(String studyName) {
    this.studyName = studyName;
    return this;
  }

  /**
   * The humane readable name of a study
   * @return studyName
  **/
  @ApiModelProperty(value = "The humane readable name of a study")


  public String getStudyName() {
    return studyName;
  }

  public void setStudyName(String studyName) {
    this.studyName = studyName;
  }

  public StudySummary studyType(String studyType) {
    this.studyType = studyType;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - See \"studyTypeName\"
   * @return studyType
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - See \"studyTypeName\"")


  public String getStudyType() {
    return studyType;
  }

  public void setStudyType(String studyType) {
    this.studyType = studyType;
  }

  public StudySummary studyTypeDbId(String studyTypeDbId) {
    this.studyTypeDbId = studyTypeDbId;
    return this;
  }

  /**
   * The unique identifier of the type of study being performed.
   * @return studyTypeDbId
  **/
  @ApiModelProperty(value = "The unique identifier of the type of study being performed.")


  public String getStudyTypeDbId() {
    return studyTypeDbId;
  }

  public void setStudyTypeDbId(String studyTypeDbId) {
    this.studyTypeDbId = studyTypeDbId;
  }

  public StudySummary studyTypeName(String studyTypeName) {
    this.studyTypeName = studyTypeName;
    return this;
  }

  /**
   * The name of the type of study being performed. ex. \"Yield Trial\", etc
   * @return studyTypeName
  **/
  @ApiModelProperty(value = "The name of the type of study being performed. ex. \"Yield Trial\", etc")


  public String getStudyTypeName() {
    return studyTypeName;
  }

  public void setStudyTypeName(String studyTypeName) {
    this.studyTypeName = studyTypeName;
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
        Objects.equals(this.commonCropName, studySummary.commonCropName) &&
        Objects.equals(this.documentationURL, studySummary.documentationURL) &&
        Objects.equals(this.endDate, studySummary.endDate) &&
        Objects.equals(this.locationDbId, studySummary.locationDbId) &&
        Objects.equals(this.locationName, studySummary.locationName) &&
        Objects.equals(this.name, studySummary.name) &&
        Objects.equals(this.programDbId, studySummary.programDbId) &&
        Objects.equals(this.programName, studySummary.programName) &&
        Objects.equals(this.seasons, studySummary.seasons) &&
        Objects.equals(this.startDate, studySummary.startDate) &&
        Objects.equals(this.studyDbId, studySummary.studyDbId) &&
        Objects.equals(this.studyName, studySummary.studyName) &&
        Objects.equals(this.studyType, studySummary.studyType) &&
        Objects.equals(this.studyTypeDbId, studySummary.studyTypeDbId) &&
        Objects.equals(this.studyTypeName, studySummary.studyTypeName) &&
        Objects.equals(this.trialDbId, studySummary.trialDbId) &&
        Objects.equals(this.trialName, studySummary.trialName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, additionalInfo, commonCropName, documentationURL, endDate, locationDbId, locationName, name, programDbId, programName, seasons, startDate, studyDbId, studyName, studyType, studyTypeDbId, studyTypeName, trialDbId, trialName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudySummary {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
    sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    locationDbId: ").append(toIndentedString(locationDbId)).append("\n");
    sb.append("    locationName: ").append(toIndentedString(locationName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    programDbId: ").append(toIndentedString(programDbId)).append("\n");
    sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
    sb.append("    seasons: ").append(toIndentedString(seasons)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
    sb.append("    studyName: ").append(toIndentedString(studyName)).append("\n");
    sb.append("    studyType: ").append(toIndentedString(studyType)).append("\n");
    sb.append("    studyTypeDbId: ").append(toIndentedString(studyTypeDbId)).append("\n");
    sb.append("    studyTypeName: ").append(toIndentedString(studyTypeName)).append("\n");
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

