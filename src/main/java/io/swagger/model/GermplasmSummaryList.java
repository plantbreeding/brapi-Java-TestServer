package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GermplasmSummary;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * GermplasmSummaryList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class GermplasmSummaryList   {
  @JsonProperty("data")
  @Valid
  private List<GermplasmSummary> data = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  @JsonProperty("trialName")
  private String trialName = null;

  public GermplasmSummaryList data(List<GermplasmSummary> data) {
    this.data = data;
    return this;
  }

  public GermplasmSummaryList addDataItem(GermplasmSummary dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<GermplasmSummary>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * List of germplasm associated with a given trial and study
   * @return data
  **/
  @ApiModelProperty(value = "List of germplasm associated with a given trial and study")

  @Valid

  public List<GermplasmSummary> getData() {
    return data;
  }

  public void setData(List<GermplasmSummary> data) {
    this.data = data;
  }

  public GermplasmSummaryList studyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
    return this;
  }

  /**
   * ** Deprecated ** The request contains the studyDbId The ID which uniquely identifies a study within the given database server
   * @return studyDbId
  **/
  @ApiModelProperty(value = "** Deprecated ** The request contains the studyDbId The ID which uniquely identifies a study within the given database server")


  public String getStudyDbId() {
    return studyDbId;
  }

  public void setStudyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
  }

  public GermplasmSummaryList trialName(String trialName) {
    this.trialName = trialName;
    return this;
  }

  /**
   * ** Deprecated ** trialName not relevent  The human readable name of a trial
   * @return trialName
  **/
  @ApiModelProperty(value = "** Deprecated ** trialName not relevent  The human readable name of a trial")


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
    GermplasmSummaryList germplasmSummaryList = (GermplasmSummaryList) o;
    return Objects.equals(this.data, germplasmSummaryList.data) &&
        Objects.equals(this.studyDbId, germplasmSummaryList.studyDbId) &&
        Objects.equals(this.trialName, germplasmSummaryList.trialName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, studyDbId, trialName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmSummaryList {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
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

