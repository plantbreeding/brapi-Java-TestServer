package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * ObservationsTable
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class ObservationsTable   {
  @JsonProperty("data")
  @Valid
  private List<List<String>> data = null;

  /**
   * valid header fields
   */
  public enum HeaderRowEnum {
    YEAR("year"),
    
    STUDYDBID("studyDbId"),
    
    STUDYNAME("studyName"),
    
    LOCATIONDBID("locationDbId"),
    
    LOCATIONNAME("locationName"),
    
    GERMPLASMDBID("germplasmDbId"),
    
    GERMPLASMNAME("germplasmName"),
    
    OBSERVATIONUNITDBID("observationUnitDbId"),
    
    PLOTNUMBER("plotNumber"),
    
    REPLICATE("replicate"),
    
    BLOCKNUMBER("blockNumber"),
    
    OBSERVATIONTIMESTAMP("observationTimestamp"),
    
    ENTRYTYPE("entryType"),
    
    X("X"),
    
    Y("Y");

    private String value;

    HeaderRowEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static HeaderRowEnum fromValue(String text) {
      for (HeaderRowEnum b : HeaderRowEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("headerRow")
  @Valid
  private List<HeaderRowEnum> headerRow = null;

  @JsonProperty("observationVariableDbIds")
  @Valid
  private List<String> observationVariableDbIds = null;

  @JsonProperty("observationVariableNames")
  @Valid
  private List<String> observationVariableNames = null;

  public ObservationsTable data(List<List<String>> data) {
    this.data = data;
    return this;
  }

  public ObservationsTable addDataItem(List<String> dataItem) {
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

  public ObservationsTable headerRow(List<HeaderRowEnum> headerRow) {
    this.headerRow = headerRow;
    return this;
  }

  public ObservationsTable addHeaderRowItem(HeaderRowEnum headerRowItem) {
    if (this.headerRow == null) {
      this.headerRow = new ArrayList<HeaderRowEnum>();
    }
    this.headerRow.add(headerRowItem);
    return this;
  }

  /**
   * The header row describing observation unit fields. Append 'observationVariableDbIds' for complete header row of the table. This array should contain any or all of the following strings; year, studyDbId, studyName, locationDbId, locationName, germplasmDbId, germplasmName, observationUnitDbId, plotNumber, replicate, blockNumber, observationTimestamp (DEPRECATED in V1.3), entryType, X, Y
   * @return headerRow
  **/
  @ApiModelProperty(value = "The header row describing observation unit fields. Append 'observationVariableDbIds' for complete header row of the table. This array should contain any or all of the following strings; year, studyDbId, studyName, locationDbId, locationName, germplasmDbId, germplasmName, observationUnitDbId, plotNumber, replicate, blockNumber, observationTimestamp (DEPRECATED in V1.3), entryType, X, Y")


  public List<HeaderRowEnum> getHeaderRow() {
    return headerRow;
  }

  public void setHeaderRow(List<HeaderRowEnum> headerRow) {
    this.headerRow = headerRow;
  }

  public ObservationsTable observationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
    return this;
  }

  public ObservationsTable addObservationVariableDbIdsItem(String observationVariableDbIdsItem) {
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

  public ObservationsTable observationVariableNames(List<String> observationVariableNames) {
    this.observationVariableNames = observationVariableNames;
    return this;
  }

  public ObservationsTable addObservationVariableNamesItem(String observationVariableNamesItem) {
    if (this.observationVariableNames == null) {
      this.observationVariableNames = new ArrayList<String>();
    }
    this.observationVariableNames.add(observationVariableNamesItem);
    return this;
  }

  /**
   * The list of observation variable names which have values recorded for them in the data matrix. Order should match 'observationVariableDbIds'.
   * @return observationVariableNames
  **/
  @ApiModelProperty(value = "The list of observation variable names which have values recorded for them in the data matrix. Order should match 'observationVariableDbIds'.")


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
    ObservationsTable observationsTable = (ObservationsTable) o;
    return Objects.equals(this.data, observationsTable.data) &&
        Objects.equals(this.headerRow, observationsTable.headerRow) &&
        Objects.equals(this.observationVariableDbIds, observationsTable.observationVariableDbIds) &&
        Objects.equals(this.observationVariableNames, observationsTable.observationVariableNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, headerRow, observationVariableDbIds, observationVariableNames);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationsTable {\n");
    
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

