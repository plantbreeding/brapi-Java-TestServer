package io.swagger.model.common;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * SearchRequestParametersTrials
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class SearchRequestParametersTrials   {
  @JsonProperty("trialDbIds")
  @Valid
  private List<String> trialDbIds = null;

  @JsonProperty("trialNames")
  @Valid
  private List<String> trialNames = null;

  public SearchRequestParametersTrials trialDbIds(List<String> trialDbIds) {
    this.trialDbIds = trialDbIds;
    return this;
  }

  public SearchRequestParametersTrials addTrialDbIdsItem(String trialDbIdsItem) {
    if (this.trialDbIds == null) {
      this.trialDbIds = new ArrayList<String>();
    }
    this.trialDbIds.add(trialDbIdsItem);
    return this;
  }

  /**
   * The ID which uniquely identifies a trial to search for
   * @return trialDbIds
  **/
  @ApiModelProperty(example = "[\"d2593dc2\",\"9431a731\"]", value = "The ID which uniquely identifies a trial to search for")
  
    public List<String> getTrialDbIds() {
    return trialDbIds;
  }

  public void setTrialDbIds(List<String> trialDbIds) {
    this.trialDbIds = trialDbIds;
  }

  public SearchRequestParametersTrials trialNames(List<String> trialNames) {
    this.trialNames = trialNames;
    return this;
  }

  public SearchRequestParametersTrials addTrialNamesItem(String trialNamesItem) {
    if (this.trialNames == null) {
      this.trialNames = new ArrayList<String>();
    }
    this.trialNames.add(trialNamesItem);
    return this;
  }

  /**
   * The human readable name of a trial to search for
   * @return trialNames
  **/
  @ApiModelProperty(example = "[\"All Yield Trials 2016\",\"Disease Resistance Study Comparison Group\"]", value = "The human readable name of a trial to search for")
  
    public List<String> getTrialNames() {
    return trialNames;
  }

  public void setTrialNames(List<String> trialNames) {
    this.trialNames = trialNames;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchRequestParametersTrials searchRequestParametersTrials = (SearchRequestParametersTrials) o;
    return Objects.equals(this.trialDbIds, searchRequestParametersTrials.trialDbIds) &&
        Objects.equals(this.trialNames, searchRequestParametersTrials.trialNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trialDbIds, trialNames);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchRequestParametersTrials {\n");
    
    sb.append("    trialDbIds: ").append(toIndentedString(trialDbIds)).append("\n");
    sb.append("    trialNames: ").append(toIndentedString(trialNames)).append("\n");
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
