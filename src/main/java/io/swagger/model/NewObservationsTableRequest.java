package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * NewObservationsTableRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class NewObservationsTableRequest   {
  @JsonProperty("data")
  @Valid
  private List<List<String>> data = null;

  @JsonProperty("headerRow")
  @Valid
  private List<String> headerRow = null;

  @JsonProperty("metadata")
  private String metadata = null;

  @JsonProperty("observationVariableDbIds")
  @Valid
  private List<String> observationVariableDbIds = null;

  @JsonProperty("result")
  private String result = null;

  public NewObservationsTableRequest data(List<List<String>> data) {
    this.data = data;
    return this;
  }

  public NewObservationsTableRequest addDataItem(List<String> dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<List<String>>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * Matrix of observation data recorded for different observation variables across different observation units
   * @return data
  **/
  @ApiModelProperty(value = "Matrix of observation data recorded for different observation variables across different observation units")

  @Valid

  public List<List<String>> getData() {
    return data;
  }

  public void setData(List<List<String>> data) {
    this.data = data;
  }

  public NewObservationsTableRequest headerRow(List<String> headerRow) {
    this.headerRow = headerRow;
    return this;
  }

  public NewObservationsTableRequest addHeaderRowItem(String headerRowItem) {
    if (this.headerRow == null) {
      this.headerRow = new ArrayList<String>();
    }
    this.headerRow.add(headerRowItem);
    return this;
  }

   /**
   * The header row describing the data matrix. Append 'observationVariableDbIds' for complete header row.
   * @return headerRow
  **/
  @ApiModelProperty(value = "The header row describing the data matrix. Append 'observationVariableDbIds' for complete header row.")


  public List<String> getHeaderRow() {
    return headerRow;
  }

  public void setHeaderRow(List<String> headerRow) {
    this.headerRow = headerRow;
  }

  public NewObservationsTableRequest metadata(String metadata) {
    this.metadata = metadata;
    return this;
  }

   /**
   * DEPRECATED
   * @return metadata
  **/
  @ApiModelProperty(value = "DEPRECATED")


  public String getMetadata() {
    return metadata;
  }

  public void setMetadata(String metadata) {
    this.metadata = metadata;
  }

  public NewObservationsTableRequest observationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
    return this;
  }

  public NewObservationsTableRequest addObservationVariableDbIdsItem(String observationVariableDbIdsItem) {
    if (this.observationVariableDbIds == null) {
      this.observationVariableDbIds = new ArrayList<String>();
    }
    this.observationVariableDbIds.add(observationVariableDbIdsItem);
    return this;
  }

   /**
   * The list of observation variables which have values recorded for them in the data matrix. Append to the 'headerRow' for comlete header row.
   * @return observationVariableDbIds
  **/
  @ApiModelProperty(value = "The list of observation variables which have values recorded for them in the data matrix. Append to the 'headerRow' for comlete header row.")


  public List<String> getObservationVariableDbIds() {
    return observationVariableDbIds;
  }

  public void setObservationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
  }

  public NewObservationsTableRequest result(String result) {
    this.result = result;
    return this;
  }

   /**
   * DEPRECATED
   * @return result
  **/
  @ApiModelProperty(value = "DEPRECATED")


  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewObservationsTableRequest newObservationsTableRequest = (NewObservationsTableRequest) o;
    return Objects.equals(this.data, newObservationsTableRequest.data) &&
        Objects.equals(this.headerRow, newObservationsTableRequest.headerRow) &&
        Objects.equals(this.metadata, newObservationsTableRequest.metadata) &&
        Objects.equals(this.observationVariableDbIds, newObservationsTableRequest.observationVariableDbIds) &&
        Objects.equals(this.result, newObservationsTableRequest.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, headerRow, metadata, observationVariableDbIds, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewObservationsTableRequest {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    headerRow: ").append(toIndentedString(headerRow)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    observationVariableDbIds: ").append(toIndentedString(observationVariableDbIds)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

