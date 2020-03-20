package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.common.SearchRequestParametersPaging;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ProgramSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class ProgramSearchRequest extends SearchRequestParametersPaging  {
  @JsonProperty("commonCropNames")
  @Valid
  private List<String> commonCropNames = null;

  @JsonProperty("programDbIds")
  @Valid
  private List<String> programDbIds = null;

  @JsonProperty("programNames")
  @Valid
  private List<String> programNames = null;

  @JsonProperty("externalReferenceIDs")
  @Valid
  private List<String> externalReferenceIDs = null;

  @JsonProperty("externalReferenceSources")
  @Valid
  private List<String> externalReferenceSources = null;

  @JsonProperty("abbreviations")
  @Valid
  private List<String> abbreviations = null;

  @JsonProperty("leadPersonDbIds")
  @Valid
  private List<String> leadPersonDbIds = null;

  @JsonProperty("leadPersonNames")
  @Valid
  private List<String> leadPersonNames = null;

  @JsonProperty("objectives")
  @Valid
  private List<String> objectives = null;

  public ProgramSearchRequest commonCropNames(List<String> commonCropNames) {
    this.commonCropNames = commonCropNames;
    return this;
  }

  public ProgramSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
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
  @ApiModelProperty(example = "[\"Tomatillo\",\"Paw Paw\"]", value = "Common name for the crop which this program is for")
  
    public List<String> getCommonCropNames() {
    return commonCropNames;
  }

  public void setCommonCropNames(List<String> commonCropNames) {
    this.commonCropNames = commonCropNames;
  }

  public ProgramSearchRequest programDbIds(List<String> programDbIds) {
    this.programDbIds = programDbIds;
    return this;
  }

  public ProgramSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
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
  @ApiModelProperty(example = "[\"8f5de35b\",\"0e2d4a13\"]", value = "A program identifier to search for")
  
    public List<String> getProgramDbIds() {
    return programDbIds;
  }

  public void setProgramDbIds(List<String> programDbIds) {
    this.programDbIds = programDbIds;
  }

  public ProgramSearchRequest programNames(List<String> programNames) {
    this.programNames = programNames;
    return this;
  }

  public ProgramSearchRequest addProgramNamesItem(String programNamesItem) {
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
  @ApiModelProperty(example = "[\"Better Breeding Program\",\"Best Breeding Program\"]", value = "A name of a program to search for")
  
    public List<String> getProgramNames() {
    return programNames;
  }

  public void setProgramNames(List<String> programNames) {
    this.programNames = programNames;
  }

  public ProgramSearchRequest externalReferenceIDs(List<String> externalReferenceIDs) {
    this.externalReferenceIDs = externalReferenceIDs;
    return this;
  }

  public ProgramSearchRequest addExternalReferenceIDsItem(String externalReferenceIDsItem) {
    if (this.externalReferenceIDs == null) {
      this.externalReferenceIDs = new ArrayList<String>();
    }
    this.externalReferenceIDs.add(externalReferenceIDsItem);
    return this;
  }

  /**
   * List of external references for the trait to search for
   * @return externalReferenceIDs
  **/
  @ApiModelProperty(example = "[\"http://purl.obolibrary.org/obo/ro.owl\",\"14a19841\"]", value = "List of external references for the trait to search for")
  
    public List<String> getExternalReferenceIDs() {
    return externalReferenceIDs;
  }

  public void setExternalReferenceIDs(List<String> externalReferenceIDs) {
    this.externalReferenceIDs = externalReferenceIDs;
  }

  public ProgramSearchRequest externalReferenceSources(List<String> externalReferenceSources) {
    this.externalReferenceSources = externalReferenceSources;
    return this;
  }

  public ProgramSearchRequest addExternalReferenceSourcesItem(String externalReferenceSourcesItem) {
    if (this.externalReferenceSources == null) {
      this.externalReferenceSources = new ArrayList<String>();
    }
    this.externalReferenceSources.add(externalReferenceSourcesItem);
    return this;
  }

  /**
   * List of external references sources for the trait to search for
   * @return externalReferenceSources
  **/
  @ApiModelProperty(example = "[\"OBO Library\",\"Field App Name\"]", value = "List of external references sources for the trait to search for")
  
    public List<String> getExternalReferenceSources() {
    return externalReferenceSources;
  }

  public void setExternalReferenceSources(List<String> externalReferenceSources) {
    this.externalReferenceSources = externalReferenceSources;
  }

  public ProgramSearchRequest abbreviations(List<String> abbreviations) {
    this.abbreviations = abbreviations;
    return this;
  }

  public ProgramSearchRequest addAbbreviationsItem(String abbreviationsItem) {
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
  @ApiModelProperty(example = "[\"P1\",\"P2\"]", value = "An abbreviation of a program to search for")
  
    public List<String> getAbbreviations() {
    return abbreviations;
  }

  public void setAbbreviations(List<String> abbreviations) {
    this.abbreviations = abbreviations;
  }

  public ProgramSearchRequest leadPersonDbIds(List<String> leadPersonDbIds) {
    this.leadPersonDbIds = leadPersonDbIds;
    return this;
  }

  public ProgramSearchRequest addLeadPersonDbIdsItem(String leadPersonDbIdsItem) {
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
  @ApiModelProperty(example = "[\"d8bd96c7\",\"a2b9c8e7\"]", value = "The person DbIds of the program leader to search for")
  
    public List<String> getLeadPersonDbIds() {
    return leadPersonDbIds;
  }

  public void setLeadPersonDbIds(List<String> leadPersonDbIds) {
    this.leadPersonDbIds = leadPersonDbIds;
  }

  public ProgramSearchRequest leadPersonNames(List<String> leadPersonNames) {
    this.leadPersonNames = leadPersonNames;
    return this;
  }

  public ProgramSearchRequest addLeadPersonNamesItem(String leadPersonNamesItem) {
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
  @ApiModelProperty(example = "[\"Bob Robertson\",\"Rob Robertson\"]", value = "The names of the program leader to search for")
  
    public List<String> getLeadPersonNames() {
    return leadPersonNames;
  }

  public void setLeadPersonNames(List<String> leadPersonNames) {
    this.leadPersonNames = leadPersonNames;
  }

  public ProgramSearchRequest objectives(List<String> objectives) {
    this.objectives = objectives;
    return this;
  }

  public ProgramSearchRequest addObjectivesItem(String objectivesItem) {
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
  @ApiModelProperty(example = "[\"Objective Code One\",\"This is a longer objective search query\"]", value = "A program objective to search for")
  
    public List<String> getObjectives() {
    return objectives;
  }

  public void setObjectives(List<String> objectives) {
    this.objectives = objectives;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProgramSearchRequest programSearchRequest = (ProgramSearchRequest) o;
    return Objects.equals(this.commonCropNames, programSearchRequest.commonCropNames) &&
        Objects.equals(this.programDbIds, programSearchRequest.programDbIds) &&
        Objects.equals(this.programNames, programSearchRequest.programNames) &&
        Objects.equals(this.externalReferenceIDs, programSearchRequest.externalReferenceIDs) &&
        Objects.equals(this.externalReferenceSources, programSearchRequest.externalReferenceSources) &&
        Objects.equals(this.abbreviations, programSearchRequest.abbreviations) &&
        Objects.equals(this.leadPersonDbIds, programSearchRequest.leadPersonDbIds) &&
        Objects.equals(this.leadPersonNames, programSearchRequest.leadPersonNames) &&
        Objects.equals(this.objectives, programSearchRequest.objectives) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commonCropNames, programDbIds, programNames, externalReferenceIDs, externalReferenceSources, abbreviations, leadPersonDbIds, leadPersonNames, objectives, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgramSearchRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
    sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
    sb.append("    programNames: ").append(toIndentedString(programNames)).append("\n");
    sb.append("    externalReferenceIDs: ").append(toIndentedString(externalReferenceIDs)).append("\n");
    sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
    sb.append("    abbreviations: ").append(toIndentedString(abbreviations)).append("\n");
    sb.append("    leadPersonDbIds: ").append(toIndentedString(leadPersonDbIds)).append("\n");
    sb.append("    leadPersonNames: ").append(toIndentedString(leadPersonNames)).append("\n");
    sb.append("    objectives: ").append(toIndentedString(objectives)).append("\n");
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
