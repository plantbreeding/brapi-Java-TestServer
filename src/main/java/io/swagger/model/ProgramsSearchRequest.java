package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProgramsSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class ProgramsSearchRequest   {
  @JsonProperty("abbreviations")
  @Valid
  private List<String> abbreviations = null;

  @JsonProperty("commonCropNames")
  @Valid
  private List<String> commonCropNames = null;

  @JsonProperty("leadPersonDbIds")
  @Valid
  private List<String> leadPersonDbIds = null;

  @JsonProperty("leadPersonNames")
  @Valid
  private List<String> leadPersonNames = null;

  @JsonProperty("objectives")
  @Valid
  private List<String> objectives = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("pageSize")
  private Integer pageSize = null;

  @JsonProperty("programDbIds")
  @Valid
  private List<String> programDbIds = null;

  @JsonProperty("programNames")
  @Valid
  private List<String> programNames = null;

  public ProgramsSearchRequest abbreviations(List<String> abbreviations) {
    this.abbreviations = abbreviations;
    return this;
  }

  public ProgramsSearchRequest addAbbreviationsItem(String abbreviationsItem) {
    if (this.abbreviations == null) {
      this.abbreviations = new ArrayList<String>();
    }
    this.abbreviations.add(abbreviationsItem);
    return this;
  }

  /**
   * An abbreviation of a program to search for
   * @return abbreviations
  **/
  @ApiModelProperty(value = "An abbreviation of a program to search for")


  public List<String> getAbbreviations() {
    return abbreviations;
  }

  public void setAbbreviations(List<String> abbreviations) {
    this.abbreviations = abbreviations;
  }

  public ProgramsSearchRequest commonCropNames(List<String> commonCropNames) {
    this.commonCropNames = commonCropNames;
    return this;
  }

  public ProgramsSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
    if (this.commonCropNames == null) {
      this.commonCropNames = new ArrayList<String>();
    }
    this.commonCropNames.add(commonCropNamesItem);
    return this;
  }

  /**
   * Common name for the crop which this program is for
   * @return commonCropNames
  **/
  @ApiModelProperty(value = "Common name for the crop which this program is for")


  public List<String> getCommonCropNames() {
    return commonCropNames;
  }

  public void setCommonCropNames(List<String> commonCropNames) {
    this.commonCropNames = commonCropNames;
  }

  public ProgramsSearchRequest leadPersonDbIds(List<String> leadPersonDbIds) {
    this.leadPersonDbIds = leadPersonDbIds;
    return this;
  }

  public ProgramsSearchRequest addLeadPersonDbIdsItem(String leadPersonDbIdsItem) {
    if (this.leadPersonDbIds == null) {
      this.leadPersonDbIds = new ArrayList<String>();
    }
    this.leadPersonDbIds.add(leadPersonDbIdsItem);
    return this;
  }

  /**
   * The person DbIds of the program leader to search for
   * @return leadPersonDbIds
  **/
  @ApiModelProperty(value = "The person DbIds of the program leader to search for")


  public List<String> getLeadPersonDbIds() {
    return leadPersonDbIds;
  }

  public void setLeadPersonDbIds(List<String> leadPersonDbIds) {
    this.leadPersonDbIds = leadPersonDbIds;
  }

  public ProgramsSearchRequest leadPersonNames(List<String> leadPersonNames) {
    this.leadPersonNames = leadPersonNames;
    return this;
  }

  public ProgramsSearchRequest addLeadPersonNamesItem(String leadPersonNamesItem) {
    if (this.leadPersonNames == null) {
      this.leadPersonNames = new ArrayList<String>();
    }
    this.leadPersonNames.add(leadPersonNamesItem);
    return this;
  }

  /**
   * The names of the program leader to search for
   * @return leadPersonNames
  **/
  @ApiModelProperty(value = "The names of the program leader to search for")


  public List<String> getLeadPersonNames() {
    return leadPersonNames;
  }

  public void setLeadPersonNames(List<String> leadPersonNames) {
    this.leadPersonNames = leadPersonNames;
  }

  public ProgramsSearchRequest objectives(List<String> objectives) {
    this.objectives = objectives;
    return this;
  }

  public ProgramsSearchRequest addObjectivesItem(String objectivesItem) {
    if (this.objectives == null) {
      this.objectives = new ArrayList<String>();
    }
    this.objectives.add(objectivesItem);
    return this;
  }

  /**
   * A program objective to search for
   * @return objectives
  **/
  @ApiModelProperty(value = "A program objective to search for")


  public List<String> getObjectives() {
    return objectives;
  }

  public void setObjectives(List<String> objectives) {
    this.objectives = objectives;
  }

  public ProgramsSearchRequest page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Which page of the \"data\" array to return. The page indexing starts at 0 (page=0 will return the first page). Default is 0.
   * @return page
  **/
  @ApiModelProperty(value = "Which page of the \"data\" array to return. The page indexing starts at 0 (page=0 will return the first page). Default is 0.")


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public ProgramsSearchRequest pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * The maximum number of items to return per page of the \"data\" array. Default is 1000.
   * @return pageSize
  **/
  @ApiModelProperty(value = "The maximum number of items to return per page of the \"data\" array. Default is 1000.")


  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public ProgramsSearchRequest programDbIds(List<String> programDbIds) {
    this.programDbIds = programDbIds;
    return this;
  }

  public ProgramsSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
    if (this.programDbIds == null) {
      this.programDbIds = new ArrayList<String>();
    }
    this.programDbIds.add(programDbIdsItem);
    return this;
  }

  /**
   * A program identifier to search for
   * @return programDbIds
  **/
  @ApiModelProperty(value = "A program identifier to search for")


  public List<String> getProgramDbIds() {
    return programDbIds;
  }

  public void setProgramDbIds(List<String> programDbIds) {
    this.programDbIds = programDbIds;
  }

  public ProgramsSearchRequest programNames(List<String> programNames) {
    this.programNames = programNames;
    return this;
  }

  public ProgramsSearchRequest addProgramNamesItem(String programNamesItem) {
    if (this.programNames == null) {
      this.programNames = new ArrayList<String>();
    }
    this.programNames.add(programNamesItem);
    return this;
  }

  /**
   * A name of a program to search for
   * @return programNames
  **/
  @ApiModelProperty(value = "A name of a program to search for")


  public List<String> getProgramNames() {
    return programNames;
  }

  public void setProgramNames(List<String> programNames) {
    this.programNames = programNames;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProgramsSearchRequest programsSearchRequest = (ProgramsSearchRequest) o;
    return Objects.equals(this.abbreviations, programsSearchRequest.abbreviations) &&
        Objects.equals(this.commonCropNames, programsSearchRequest.commonCropNames) &&
        Objects.equals(this.leadPersonDbIds, programsSearchRequest.leadPersonDbIds) &&
        Objects.equals(this.leadPersonNames, programsSearchRequest.leadPersonNames) &&
        Objects.equals(this.objectives, programsSearchRequest.objectives) &&
        Objects.equals(this.page, programsSearchRequest.page) &&
        Objects.equals(this.pageSize, programsSearchRequest.pageSize) &&
        Objects.equals(this.programDbIds, programsSearchRequest.programDbIds) &&
        Objects.equals(this.programNames, programsSearchRequest.programNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(abbreviations, commonCropNames, leadPersonDbIds, leadPersonNames, objectives, page, pageSize, programDbIds, programNames);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgramsSearchRequest {\n");
    
    sb.append("    abbreviations: ").append(toIndentedString(abbreviations)).append("\n");
    sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
    sb.append("    leadPersonDbIds: ").append(toIndentedString(leadPersonDbIds)).append("\n");
    sb.append("    leadPersonNames: ").append(toIndentedString(leadPersonNames)).append("\n");
    sb.append("    objectives: ").append(toIndentedString(objectives)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
    sb.append("    programNames: ").append(toIndentedString(programNames)).append("\n");
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

