package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.common.ExternalReferences;
import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ProgramNewRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class ProgramNewRequest   {
  @JsonProperty("abbreviation")
  private String abbreviation = null;

  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("commonCropName")
  private String commonCropName = null;

  @JsonProperty("documentationURL")
  private String documentationURL = null;

  @JsonProperty("externalReferences")
  private ExternalReferences externalReferences = null;

  @JsonProperty("leadPersonDbId")
  private String leadPersonDbId = null;

  @JsonProperty("leadPersonName")
  private String leadPersonName = null;

  @JsonProperty("objective")
  private String objective = null;

  @JsonProperty("programName")
  private String programName = null;

  public ProgramNewRequest abbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
    return this;
  }

  /**
   * An abbreviation which represents this program
   * @return abbreviation
  **/
  @ApiModelProperty(example = "P1", value = "An abbreviation which represents this program")
  
    public String getAbbreviation() {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public ProgramNewRequest additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public ProgramNewRequest putAdditionalInfoItem(String key, String additionalInfoItem) {
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

  public ProgramNewRequest commonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
    return this;
  }

  /**
   * Common name for the crop which this program is for
   * @return commonCropName
  **/
  @ApiModelProperty(example = "Tomatillo", value = "Common name for the crop which this program is for")
  
    public String getCommonCropName() {
    return commonCropName;
  }

  public void setCommonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
  }

  public ProgramNewRequest documentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
    return this;
  }

  /**
   * A URL to the human readable documentation of this object
   * @return documentationURL
  **/
  @ApiModelProperty(example = "https://wiki.brapi.org", value = "A URL to the human readable documentation of this object")
  
    public String getDocumentationURL() {
    return documentationURL;
  }

  public void setDocumentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
  }

  public ProgramNewRequest externalReferences(ExternalReferences externalReferences) {
    this.externalReferences = externalReferences;
    return this;
  }

  /**
   * Get externalReferences
   * @return externalReferences
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ExternalReferences getExternalReferences() {
    return externalReferences;
  }

  public void setExternalReferences(ExternalReferences externalReferences) {
    this.externalReferences = externalReferences;
  }

  public ProgramNewRequest leadPersonDbId(String leadPersonDbId) {
    this.leadPersonDbId = leadPersonDbId;
    return this;
  }

  /**
   * The unique identifier of the program leader
   * @return leadPersonDbId
  **/
  @ApiModelProperty(example = "fe6f5c50", value = "The unique identifier of the program leader")
  
    public String getLeadPersonDbId() {
    return leadPersonDbId;
  }

  public void setLeadPersonDbId(String leadPersonDbId) {
    this.leadPersonDbId = leadPersonDbId;
  }

  public ProgramNewRequest leadPersonName(String leadPersonName) {
    this.leadPersonName = leadPersonName;
    return this;
  }

  /**
   * The name of the program leader
   * @return leadPersonName
  **/
  @ApiModelProperty(example = "Bob Robertson", value = "The name of the program leader")
  
    public String getLeadPersonName() {
    return leadPersonName;
  }

  public void setLeadPersonName(String leadPersonName) {
    this.leadPersonName = leadPersonName;
  }

  public ProgramNewRequest objective(String objective) {
    this.objective = objective;
    return this;
  }

  /**
   * The primary objective of the program
   * @return objective
  **/
  @ApiModelProperty(example = "Make a better tomatillo", value = "The primary objective of the program")
  
    public String getObjective() {
    return objective;
  }

  public void setObjective(String objective) {
    this.objective = objective;
  }

  public ProgramNewRequest programName(String programName) {
    this.programName = programName;
    return this;
  }

  /**
   * Human readable name of the program
   * @return programName
  **/
  @ApiModelProperty(example = "Tomatillo_Breeding_Program", value = "Human readable name of the program")
  
    public String getProgramName() {
    return programName;
  }

  public void setProgramName(String programName) {
    this.programName = programName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProgramNewRequest programNewRequest = (ProgramNewRequest) o;
    return Objects.equals(this.abbreviation, programNewRequest.abbreviation) &&
        Objects.equals(this.additionalInfo, programNewRequest.additionalInfo) &&
        Objects.equals(this.commonCropName, programNewRequest.commonCropName) &&
        Objects.equals(this.documentationURL, programNewRequest.documentationURL) &&
        Objects.equals(this.externalReferences, programNewRequest.externalReferences) &&
        Objects.equals(this.leadPersonDbId, programNewRequest.leadPersonDbId) &&
        Objects.equals(this.leadPersonName, programNewRequest.leadPersonName) &&
        Objects.equals(this.objective, programNewRequest.objective) &&
        Objects.equals(this.programName, programNewRequest.programName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(abbreviation, additionalInfo, commonCropName, documentationURL, externalReferences, leadPersonDbId, leadPersonName, objective, programName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgramNewRequest {\n");
    
    sb.append("    abbreviation: ").append(toIndentedString(abbreviation)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
    sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
    sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
    sb.append("    leadPersonDbId: ").append(toIndentedString(leadPersonDbId)).append("\n");
    sb.append("    leadPersonName: ").append(toIndentedString(leadPersonName)).append("\n");
    sb.append("    objective: ").append(toIndentedString(objective)).append("\n");
    sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
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
