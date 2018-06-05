package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GermplasmSummary;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GermplasmSummaryList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

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

  public GermplasmSummaryList trialName(String trialName) {
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

