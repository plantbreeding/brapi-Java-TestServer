package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * An analysis contains an interpretation of one or several experiments. (e.g. SNVs, copy number variations, methylation status) together with information about the methodology used.
 */
@ApiModel(description = "An analysis contains an interpretation of one or several experiments. (e.g. SNVs, copy number variations, methylation status) together with information about the methodology used.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class Analysis   {
  @JsonProperty("analysisDbId")
  private String analysisDbId = null;

  @JsonProperty("analysisName")
  private String analysisName = null;

  @JsonProperty("created")
  private OffsetDateTime created = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("software")
  @Valid
  private List<String> software = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("updated")
  private OffsetDateTime updated = null;

  public Analysis analysisDbId(String analysisDbId) {
    this.analysisDbId = analysisDbId;
    return this;
  }

  /**
   * Unique identifier for this analysis description
   * @return analysisDbId
  **/
  @ApiModelProperty(example = "6191a6bd", value = "Unique identifier for this analysis description")
  
    public String getAnalysisDbId() {
    return analysisDbId;
  }

  public void setAnalysisDbId(String analysisDbId) {
    this.analysisDbId = analysisDbId;
  }

  public Analysis analysisName(String analysisName) {
    this.analysisName = analysisName;
    return this;
  }

  /**
   * A human readable name for this analysis
   * @return analysisName
  **/
  @ApiModelProperty(example = "Standard QC", value = "A human readable name for this analysis")
  
    public String getAnalysisName() {
    return analysisName;
  }

  public void setAnalysisName(String analysisName) {
    this.analysisName = analysisName;
  }

  public Analysis created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * The time at which this record was created, in ISO 8601 format.
   * @return created
  **/
  @ApiModelProperty(value = "The time at which this record was created, in ISO 8601 format.")
  
    @Valid
    public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public Analysis description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A human readable description of the analysis
   * @return description
  **/
  @ApiModelProperty(example = "This is a formal description of a QC methodology. Blah blah blah ...", value = "A human readable description of the analysis")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Analysis software(List<String> software) {
    this.software = software;
    return this;
  }

  public Analysis addSoftwareItem(String softwareItem) {
    if (this.software == null) {
      this.software = new ArrayList<String>();
    }
    this.software.add(softwareItem);
    return this;
  }

  /**
   * The software run to generate this analysis.
   * @return software
  **/
  @ApiModelProperty(example = "[\"https://github.com/genotyping/QC\"]", value = "The software run to generate this analysis.")
  
    public List<String> getSoftware() {
    return software;
  }

  public void setSoftware(List<String> software) {
    this.software = software;
  }

  public Analysis type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The type of analysis.
   * @return type
  **/
  @ApiModelProperty(example = "QC", value = "The type of analysis.")
  
    public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Analysis updated(OffsetDateTime updated) {
    this.updated = updated;
    return this;
  }

  /**
   * The time at which this record was last updated, in ISO 8601 format.
   * @return updated
  **/
  @ApiModelProperty(value = "The time at which this record was last updated, in ISO 8601 format.")
  
    @Valid
    public OffsetDateTime getUpdated() {
    return updated;
  }

  public void setUpdated(OffsetDateTime updated) {
    this.updated = updated;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Analysis analysis = (Analysis) o;
    return Objects.equals(this.analysisDbId, analysis.analysisDbId) &&
        Objects.equals(this.analysisName, analysis.analysisName) &&
        Objects.equals(this.created, analysis.created) &&
        Objects.equals(this.description, analysis.description) &&
        Objects.equals(this.software, analysis.software) &&
        Objects.equals(this.type, analysis.type) &&
        Objects.equals(this.updated, analysis.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(analysisDbId, analysisName, created, description, software, type, updated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Analysis {\n");
    
    sb.append("    analysisDbId: ").append(toIndentedString(analysisDbId)).append("\n");
    sb.append("    analysisName: ").append(toIndentedString(analysisName)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    software: ").append(toIndentedString(software)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
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
