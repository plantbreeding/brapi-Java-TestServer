package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Contact;
import io.swagger.model.DataLink;
import io.swagger.model.Location;
import io.swagger.model.StudyLastUpdate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * Study
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class Study   {
  @JsonProperty("active")
  private String active = null;

  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("commonCropName")
  private String commonCropName = null;

  @JsonProperty("contacts")
  @Valid
  private List<Contact> contacts = null;

  @JsonProperty("dataLinks")
  @Valid
  private List<DataLink> dataLinks = null;

  @JsonProperty("documentationURL")
  private String documentationURL = null;

  @JsonProperty("endDate")
  private LocalDate endDate = null;

  @JsonProperty("lastUpdate")
  private StudyLastUpdate lastUpdate = null;

  @JsonProperty("license")
  private String license = null;

  @JsonProperty("location")
  private Location location = null;

  @JsonProperty("seasons")
  @Valid
  private List<String> seasons = null;

  @JsonProperty("startDate")
  private LocalDate startDate = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  @JsonProperty("studyDescription")
  private String studyDescription = null;

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

  public Study active(String active) {
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

  public Study additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public Study putAdditionalInfoItem(String key, String additionalInfoItem) {
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

  public Study commonCropName(String commonCropName) {
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

  public Study contacts(List<Contact> contacts) {
    this.contacts = contacts;
    return this;
  }

  public Study addContactsItem(Contact contactsItem) {
    if (this.contacts == null) {
      this.contacts = new ArrayList<Contact>();
    }
    this.contacts.add(contactsItem);
    return this;
  }

  /**
   * List of contact entities associated with this study
   * @return contacts
  **/
  @ApiModelProperty(value = "List of contact entities associated with this study")

  @Valid

  public List<Contact> getContacts() {
    return contacts;
  }

  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  public Study dataLinks(List<DataLink> dataLinks) {
    this.dataLinks = dataLinks;
    return this;
  }

  public Study addDataLinksItem(DataLink dataLinksItem) {
    if (this.dataLinks == null) {
      this.dataLinks = new ArrayList<DataLink>();
    }
    this.dataLinks.add(dataLinksItem);
    return this;
  }

  /**
   * List of links to extra data files associated with this study. Extra data could include notes, images, and reference data.
   * @return dataLinks
  **/
  @ApiModelProperty(value = "List of links to extra data files associated with this study. Extra data could include notes, images, and reference data.")

  @Valid

  public List<DataLink> getDataLinks() {
    return dataLinks;
  }

  public void setDataLinks(List<DataLink> dataLinks) {
    this.dataLinks = dataLinks;
  }

  public Study documentationURL(String documentationURL) {
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

  public Study endDate(LocalDate endDate) {
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

  public Study lastUpdate(StudyLastUpdate lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Get lastUpdate
   * @return lastUpdate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public StudyLastUpdate getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(StudyLastUpdate lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public Study license(String license) {
    this.license = license;
    return this;
  }

  /**
   * The usage license associated with the study data
   * @return license
  **/
  @ApiModelProperty(value = "The usage license associated with the study data")


  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  public Study location(Location location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Study seasons(List<String> seasons) {
    this.seasons = seasons;
    return this;
  }

  public Study addSeasonsItem(String seasonsItem) {
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

  public Study startDate(LocalDate startDate) {
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

  public Study studyDbId(String studyDbId) {
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

  public Study studyDescription(String studyDescription) {
    this.studyDescription = studyDescription;
    return this;
  }

  /**
   * The description of this study
   * @return studyDescription
  **/
  @ApiModelProperty(value = "The description of this study")


  public String getStudyDescription() {
    return studyDescription;
  }

  public void setStudyDescription(String studyDescription) {
    this.studyDescription = studyDescription;
  }

  public Study studyName(String studyName) {
    this.studyName = studyName;
    return this;
  }

  /**
   * The human readable name for a study
   * @return studyName
  **/
  @ApiModelProperty(value = "The human readable name for a study")


  public String getStudyName() {
    return studyName;
  }

  public void setStudyName(String studyName) {
    this.studyName = studyName;
  }

  public Study studyType(String studyType) {
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

  public Study studyTypeDbId(String studyTypeDbId) {
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

  public Study studyTypeName(String studyTypeName) {
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

  public Study trialDbId(String trialDbId) {
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

  public Study trialName(String trialName) {
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
    Study study = (Study) o;
    return Objects.equals(this.active, study.active) &&
        Objects.equals(this.additionalInfo, study.additionalInfo) &&
        Objects.equals(this.commonCropName, study.commonCropName) &&
        Objects.equals(this.contacts, study.contacts) &&
        Objects.equals(this.dataLinks, study.dataLinks) &&
        Objects.equals(this.documentationURL, study.documentationURL) &&
        Objects.equals(this.endDate, study.endDate) &&
        Objects.equals(this.lastUpdate, study.lastUpdate) &&
        Objects.equals(this.license, study.license) &&
        Objects.equals(this.location, study.location) &&
        Objects.equals(this.seasons, study.seasons) &&
        Objects.equals(this.startDate, study.startDate) &&
        Objects.equals(this.studyDbId, study.studyDbId) &&
        Objects.equals(this.studyDescription, study.studyDescription) &&
        Objects.equals(this.studyName, study.studyName) &&
        Objects.equals(this.studyType, study.studyType) &&
        Objects.equals(this.studyTypeDbId, study.studyTypeDbId) &&
        Objects.equals(this.studyTypeName, study.studyTypeName) &&
        Objects.equals(this.trialDbId, study.trialDbId) &&
        Objects.equals(this.trialName, study.trialName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, additionalInfo, commonCropName, contacts, dataLinks, documentationURL, endDate, lastUpdate, license, location, seasons, startDate, studyDbId, studyDescription, studyName, studyType, studyTypeDbId, studyTypeName, trialDbId, trialName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Study {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
    sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
    sb.append("    dataLinks: ").append(toIndentedString(dataLinks)).append("\n");
    sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    license: ").append(toIndentedString(license)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    seasons: ").append(toIndentedString(seasons)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
    sb.append("    studyDescription: ").append(toIndentedString(studyDescription)).append("\n");
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

