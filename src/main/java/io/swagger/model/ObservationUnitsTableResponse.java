package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ObservationUnitsTableResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class ObservationUnitsTableResponse   {
  @JsonProperty("data")
  @Valid
  private List<List<String>> data = null;

  @JsonProperty("headerRow")
  @Valid
  private List<String> headerRow = null;

  @JsonProperty("observationVariableDbIds")
  @Valid
  private List<String> observationVariableDbIds = null;

  @JsonProperty("observationVariableNames")
  @Valid
  private List<String> observationVariableNames = null;

  public ObservationUnitsTableResponse data(List<List<String>> data) {
    this.data = data;
    return this;
  }

  public ObservationUnitsTableResponse addDataItem(List<String> dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<List<String>>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * Matrix of observation meta-data and recorded values. Each inner array represents 1 row of data.
   * @return data
  **/
  @ApiModelProperty(value = "Matrix of observation meta-data and recorded values. Each inner array represents 1 row of data.")

  @Valid

  public List<List<String>> getData() {
    return data;
  }

  public void setData(List<List<String>> data) {
    this.data = data;
  }

  public ObservationUnitsTableResponse headerRow(List<String> headerRow) {
    this.headerRow = headerRow;
    return this;
  }

  public ObservationUnitsTableResponse addHeaderRowItem(String headerRowItem) {
    if (this.headerRow == null) {
      this.headerRow = new ArrayList<String>();
    }
    this.headerRow.add(headerRowItem);
    return this;
  }

   /**
   * Names of the columns included in the data matrix. Any or All of [ \"year\",\"studyDbId\",\"studyName\",\"locationDbId\",\"locationName\",\"germplasmDbId\",\"germplasmName\",\"observationUnitDbId\",\"plotNumber\",\"replicate\",\"blockNumber\", \"observationTimestamp\", \"entryType\", \"X\", \"Y\"]
   * @return headerRow
  **/
  @ApiModelProperty(value = "Names of the columns included in the data matrix. Any or All of [ \"year\",\"studyDbId\",\"studyName\",\"locationDbId\",\"locationName\",\"germplasmDbId\",\"germplasmName\",\"observationUnitDbId\",\"plotNumber\",\"replicate\",\"blockNumber\", \"observationTimestamp\", \"entryType\", \"X\", \"Y\"]")


  public List<String> getHeaderRow() {
    return headerRow;
  }

  public void setHeaderRow(List<String> headerRow) {
    this.headerRow = headerRow;
  }

  public ObservationUnitsTableResponse observationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
    return this;
  }

  public ObservationUnitsTableResponse addObservationVariableDbIdsItem(String observationVariableDbIdsItem) {
    if (this.observationVariableDbIds == null) {
      this.observationVariableDbIds = new ArrayList<String>();
    }
    this.observationVariableDbIds.add(observationVariableDbIdsItem);
    return this;
  }

   /**
   * Array of observation variable DbIds for the collected data. This array is appended to the \"headerRow\" to get the complete header of the data matrix
   * @return observationVariableDbIds
  **/
  @ApiModelProperty(value = "Array of observation variable DbIds for the collected data. This array is appended to the \"headerRow\" to get the complete header of the data matrix")


  public List<String> getObservationVariableDbIds() {
    return observationVariableDbIds;
  }

  public void setObservationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
  }

  public ObservationUnitsTableResponse observationVariableNames(List<String> observationVariableNames) {
    this.observationVariableNames = observationVariableNames;
    return this;
  }

  public ObservationUnitsTableResponse addObservationVariableNamesItem(String observationVariableNamesItem) {
    if (this.observationVariableNames == null) {
      this.observationVariableNames = new ArrayList<String>();
    }
    this.observationVariableNames.add(observationVariableNamesItem);
    return this;
  }

   /**
   * Human readable names of the observation variables for the collected data. This array should match 1 to 1 with the \"observationVariableDbIds\" array.
   * @return observationVariableNames
  **/
  @ApiModelProperty(value = "Human readable names of the observation variables for the collected data. This array should match 1 to 1 with the \"observationVariableDbIds\" array.")


  public List<String> getObservationVariableNames() {
    return observationVariableNames;
  }

  public void setObservationVariableNames(List<String> observationVariableNames) {
    this.observationVariableNames = observationVariableNames;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationUnitsTableResponse observationUnitsTableResponse = (ObservationUnitsTableResponse) o;
    return Objects.equals(this.data, observationUnitsTableResponse.data) &&
        Objects.equals(this.headerRow, observationUnitsTableResponse.headerRow) &&
        Objects.equals(this.observationVariableDbIds, observationUnitsTableResponse.observationVariableDbIds) &&
        Objects.equals(this.observationVariableNames, observationUnitsTableResponse.observationVariableNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, headerRow, observationVariableDbIds, observationVariableNames);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationUnitsTableResponse {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    headerRow: ").append(toIndentedString(headerRow)).append("\n");
    sb.append("    observationVariableDbIds: ").append(toIndentedString(observationVariableDbIds)).append("\n");
    sb.append("    observationVariableNames: ").append(toIndentedString(observationVariableNames)).append("\n");
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

