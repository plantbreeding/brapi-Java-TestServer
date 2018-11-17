package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Contact;
import io.swagger.model.TrialDatasetAuthorship;
import io.swagger.model.TrialDatasetAuthorships;
import io.swagger.model.TrialPublications;
import io.swagger.model.TrialStudies;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Trial
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-06T17:40:52.157-05:00[America/New_York]")

public class Trial   {
  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("commonCropName")
  private String commonCropName = null;

  @JsonProperty("contacts")
  @Valid
  private List<Contact> contacts = null;

  @JsonProperty("datasetAuthorship")
  private TrialDatasetAuthorship datasetAuthorship = null;

  @JsonProperty("datasetAuthorships")
  @Valid
  private List<TrialDatasetAuthorships> datasetAuthorships = null;

  @JsonProperty("documentationURL")
  private String documentationURL = null;

  @JsonProperty("endDate")
  private LocalDate endDate = null;

  @JsonProperty("programDbId")
  private String programDbId = null;

  @JsonProperty("programName")
  private String programName = null;

  @JsonProperty("publications")
  @Valid
  private List<TrialPublications> publications = null;

  @JsonProperty("startDate")
  private LocalDate startDate = null;

  @JsonProperty("studies")
  @Valid
  private List<TrialStudies> studies = null;

  @JsonProperty("trialDbId")
  private String trialDbId = null;

  @JsonProperty("trialName")
  private String trialName = null;

  public Trial active(Boolean active) {
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

  public Trial additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public Trial putAdditionalInfoItem(String key, String additionalInfoItem) {
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

  public Trial commonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
    return this;
  }

  /**
   * Common name for the crop associated with this trial
   * @return commonCropName
  **/
  @ApiModelProperty(value = "Common name for the crop associated with this trial")


  public String getCommonCropName() {
    return commonCropName;
  }

  public void setCommonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
  }

  public Trial contacts(List<Contact> contacts) {
    this.contacts = contacts;
    return this;
  }

  public Trial addContactsItem(Contact contactsItem) {
    if (this.contacts == null) {
      this.contacts = new ArrayList<Contact>();
    }
    this.contacts.add(contactsItem);
    return this;
  }

  /**
   * List of contact entities associated with this trial
   * @return contacts
  **/
  @ApiModelProperty(value = "List of contact entities associated with this trial")

  @Valid

  public List<Contact> getContacts() {
    return contacts;
  }

  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  public Trial datasetAuthorship(TrialDatasetAuthorship datasetAuthorship) {
    this.datasetAuthorship = datasetAuthorship;
    return this;
  }

  /**
   * Get datasetAuthorship
   * @return datasetAuthorship
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TrialDatasetAuthorship getDatasetAuthorship() {
    return datasetAuthorship;
  }

  public void setDatasetAuthorship(TrialDatasetAuthorship datasetAuthorship) {
    this.datasetAuthorship = datasetAuthorship;
  }

  public Trial datasetAuthorships(List<TrialDatasetAuthorships> datasetAuthorships) {
    this.datasetAuthorships = datasetAuthorships;
    return this;
  }

  public Trial addDatasetAuthorshipsItem(TrialDatasetAuthorships datasetAuthorshipsItem) {
    if (this.datasetAuthorships == null) {
      this.datasetAuthorships = new ArrayList<TrialDatasetAuthorships>();
    }
    this.datasetAuthorships.add(datasetAuthorshipsItem);
    return this;
  }

  /**
   * License and citation information for the data in this trial
   * @return datasetAuthorships
  **/
  @ApiModelProperty(value = "License and citation information for the data in this trial")

  @Valid

  public List<TrialDatasetAuthorships> getDatasetAuthorships() {
    return datasetAuthorships;
  }

  public void setDatasetAuthorships(List<TrialDatasetAuthorships> datasetAuthorships) {
    this.datasetAuthorships = datasetAuthorships;
  }

  public Trial documentationURL(String documentationURL) {
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

  public Trial endDate(LocalDate endDate) {
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

  public Trial programDbId(String programDbId) {
    this.programDbId = programDbId;
    return this;
  }

  /**
   * A program identifier to search for
   * @return programDbId
  **/
  @ApiModelProperty(value = "A program identifier to search for")


  public String getProgramDbId() {
    return programDbId;
  }

  public void setProgramDbId(String programDbId) {
    this.programDbId = programDbId;
  }

  public Trial programName(String programName) {
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

  public Trial publications(List<TrialPublications> publications) {
    this.publications = publications;
    return this;
  }

  public Trial addPublicationsItem(TrialPublications publicationsItem) {
    if (this.publications == null) {
      this.publications = new ArrayList<TrialPublications>();
    }
    this.publications.add(publicationsItem);
    return this;
  }

  /**
   * Get publications
   * @return publications
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<TrialPublications> getPublications() {
    return publications;
  }

  public void setPublications(List<TrialPublications> publications) {
    this.publications = publications;
  }

  public Trial startDate(LocalDate startDate) {
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

  public Trial studies(List<TrialStudies> studies) {
    this.studies = studies;
    return this;
  }

  public Trial addStudiesItem(TrialStudies studiesItem) {
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

  public Trial trialDbId(String trialDbId) {
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

  public Trial trialName(String trialName) {
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
    Trial trial = (Trial) o;
    return Objects.equals(this.active, trial.active) &&
        Objects.equals(this.additionalInfo, trial.additionalInfo) &&
        Objects.equals(this.commonCropName, trial.commonCropName) &&
        Objects.equals(this.contacts, trial.contacts) &&
        Objects.equals(this.datasetAuthorship, trial.datasetAuthorship) &&
        Objects.equals(this.datasetAuthorships, trial.datasetAuthorships) &&
        Objects.equals(this.documentationURL, trial.documentationURL) &&
        Objects.equals(this.endDate, trial.endDate) &&
        Objects.equals(this.programDbId, trial.programDbId) &&
        Objects.equals(this.programName, trial.programName) &&
        Objects.equals(this.publications, trial.publications) &&
        Objects.equals(this.startDate, trial.startDate) &&
        Objects.equals(this.studies, trial.studies) &&
        Objects.equals(this.trialDbId, trial.trialDbId) &&
        Objects.equals(this.trialName, trial.trialName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, additionalInfo, commonCropName, contacts, datasetAuthorship, datasetAuthorships, documentationURL, endDate, programDbId, programName, publications, startDate, studies, trialDbId, trialName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Trial {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
    sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
    sb.append("    datasetAuthorship: ").append(toIndentedString(datasetAuthorship)).append("\n");
    sb.append("    datasetAuthorships: ").append(toIndentedString(datasetAuthorships)).append("\n");
    sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    programDbId: ").append(toIndentedString(programDbId)).append("\n");
    sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
    sb.append("    publications: ").append(toIndentedString(publications)).append("\n");
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

