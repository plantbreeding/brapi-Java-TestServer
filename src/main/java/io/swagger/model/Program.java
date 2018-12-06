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
 * Program
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class Program   {
  @JsonProperty("abbreviation")
  private String abbreviation = null;

  @JsonProperty("commonCropName")
  private String commonCropName = null;

  @JsonProperty("documentationURL")
  private String documentationURL = null;

  @JsonProperty("leadPerson")
  private String leadPerson = null;

  @JsonProperty("leadPersonDbId")
  private String leadPersonDbId = null;

  @JsonProperty("leadPersonName")
  private String leadPersonName = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("objective")
  private String objective = null;

  @JsonProperty("programDbId")
  private String programDbId = null;

  @JsonProperty("programName")
  private String programName = null;

  public Program abbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
    return this;
  }

  /**
   * An abbreviation which represnts this program
   * @return abbreviation
  **/
  @ApiModelProperty(value = "An abbreviation which represnts this program")


  public String getAbbreviation() {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public Program commonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
    return this;
  }

  /**
   * Common name for the crop which this program is for
   * @return commonCropName
  **/
  @ApiModelProperty(value = "Common name for the crop which this program is for")


  public String getCommonCropName() {
    return commonCropName;
  }

  public void setCommonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
  }

  public Program documentationURL(String documentationURL) {
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

  public Program leadPerson(String leadPerson) {
    this.leadPerson = leadPerson;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - see \"leadPersonName\" or \"leadPersonDbId\"
   * @return leadPerson
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - see \"leadPersonName\" or \"leadPersonDbId\"")


  public String getLeadPerson() {
    return leadPerson;
  }

  public void setLeadPerson(String leadPerson) {
    this.leadPerson = leadPerson;
  }

  public Program leadPersonDbId(String leadPersonDbId) {
    this.leadPersonDbId = leadPersonDbId;
    return this;
  }

  /**
   * The unique identifier of the program leader
   * @return leadPersonDbId
  **/
  @ApiModelProperty(value = "The unique identifier of the program leader")


  public String getLeadPersonDbId() {
    return leadPersonDbId;
  }

  public void setLeadPersonDbId(String leadPersonDbId) {
    this.leadPersonDbId = leadPersonDbId;
  }

  public Program leadPersonName(String leadPersonName) {
    this.leadPersonName = leadPersonName;
    return this;
  }

  /**
   * The name of the program leader
   * @return leadPersonName
  **/
  @ApiModelProperty(value = "The name of the program leader")


  public String getLeadPersonName() {
    return leadPersonName;
  }

  public void setLeadPersonName(String leadPersonName) {
    this.leadPersonName = leadPersonName;
  }

  public Program name(String name) {
    this.name = name;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - Use \"programName\"
   * @return name
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - Use \"programName\"")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Program objective(String objective) {
    this.objective = objective;
    return this;
  }

  /**
   * The primary objective of the program
   * @return objective
  **/
  @ApiModelProperty(value = "The primary objective of the program")


  public String getObjective() {
    return objective;
  }

  public void setObjective(String objective) {
    this.objective = objective;
  }

  public Program programDbId(String programDbId) {
    this.programDbId = programDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies the program
   * @return programDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies the program")


  public String getProgramDbId() {
    return programDbId;
  }

  public void setProgramDbId(String programDbId) {
    this.programDbId = programDbId;
  }

  public Program programName(String programName) {
    this.programName = programName;
    return this;
  }

  /**
   * Human readable name of the program
   * @return programName
  **/
  @ApiModelProperty(value = "Human readable name of the program")


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
    Program program = (Program) o;
    return Objects.equals(this.abbreviation, program.abbreviation) &&
        Objects.equals(this.commonCropName, program.commonCropName) &&
        Objects.equals(this.documentationURL, program.documentationURL) &&
        Objects.equals(this.leadPerson, program.leadPerson) &&
        Objects.equals(this.leadPersonDbId, program.leadPersonDbId) &&
        Objects.equals(this.leadPersonName, program.leadPersonName) &&
        Objects.equals(this.name, program.name) &&
        Objects.equals(this.objective, program.objective) &&
        Objects.equals(this.programDbId, program.programDbId) &&
        Objects.equals(this.programName, program.programName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(abbreviation, commonCropName, documentationURL, leadPerson, leadPersonDbId, leadPersonName, name, objective, programDbId, programName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Program {\n");
    
    sb.append("    abbreviation: ").append(toIndentedString(abbreviation)).append("\n");
    sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
    sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
    sb.append("    leadPerson: ").append(toIndentedString(leadPerson)).append("\n");
    sb.append("    leadPersonDbId: ").append(toIndentedString(leadPersonDbId)).append("\n");
    sb.append("    leadPersonName: ").append(toIndentedString(leadPersonName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    objective: ").append(toIndentedString(objective)).append("\n");
    sb.append("    programDbId: ").append(toIndentedString(programDbId)).append("\n");
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

