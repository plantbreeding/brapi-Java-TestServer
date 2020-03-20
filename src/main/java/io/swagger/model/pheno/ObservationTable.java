package io.swagger.model.pheno;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.pheno.ObservationTableObservationVariables;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ObservationTable
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class ObservationTable   {
  @JsonProperty("data")
  @Valid
  private List<List<String>> data = null;

  /**
   * valid header fields
   */
  public enum HeaderRowEnum {
    OBSERVATIONTIMESTAMP("observationTimeStamp"),
    
    OBSERVATIONUNITDBID("observationUnitDbId"),
    
    OBSERVATIONUNITNAME("observationUnitName"),
    
    STUDYDBID("studyDbId"),
    
    STUDYNAME("studyName"),
    
    GERMPLASMDBID("germplasmDbId"),
    
    GERMPLASMNAME("germplasmName"),
    
    POSITIONCOORDINATEX("positionCoordinateX"),
    
    POSITIONCOORDINATEY("positionCoordinateY"),
    
    YEAR("year"),
    
    FIELD("field"),
    
    PLOT("plot"),
    
    SUB_PLOT("sub-plot"),
    
    PLANT("plant"),
    
    POT("pot"),
    
    BLOCK("block"),
    
    ENTRY("entry"),
    
    REP("rep");

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

  @JsonProperty("observationVariables")
  @Valid
  private List<ObservationTableObservationVariables> observationVariables = null;

  public ObservationTable data(List<List<String>> data) {
    this.data = data;
    return this;
  }

  public ObservationTable addDataItem(List<String> dataItem) {
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
  @ApiModelProperty(example = "[[\"2019-09-10T18:13:27.223Z\",\"f3a8a3db\",\"Plant Alpha\",\"0fe3e48b\",\"2017 Plant Study\",\"06307ec0\",\"A0043001\",\"76.50106681\",\"42.44409301\",\"2017\",\"Field_1\",\"Plot_11\",\"SubPlot_111\",\"Plant_1111\",\"Pot_1111\",\"Block_11\",\"Entry_11\",\"Rep_11\",\"25.3\",\"\",\"\",\"\"],[\"2019-09-10T18:14:27.223Z\",\"f3a8a3db\",\"Plant Alpha\",\"0fe3e48b\",\"2017 Plant Study\",\"06307ec0\",\"A0043001\",\"76.50106681\",\"42.44409301\",\"2017\",\"Field_1\",\"Plot_11\",\"SubPlot_111\",\"Plant_1111\",\"Pot_1111\",\"Block_11\",\"Entry_11\",\"Rep_11\",\"\",\"3\",\"\",\"\"],[\"2019-09-10T18:15:54.868Z\",\"05d1b011\",\"Plant Beta\",\"0fe3e48b\",\"2017 Plant Study\",\"59d435cd\",\"A0043002\",\"76.50106683\",\"42.44409301\",\"2017\",\"Field_1\",\"Plot_11\",\"SubPlot_112\",\"Plant_1122\",\"Pot_1122\",\"Block_11\",\"Entry_11\",\"Rep_12\",\"27.9\",\"\",\"\",\"\"],[\"2019-09-10T18:16:54.868Z\",\"05d1b011\",\"Plant Beta\",\"0fe3e48b\",\"2017 Plant Study\",\"59d435cd\",\"A0043002\",\"76.50106683\",\"42.44409301\",\"2017\",\"Field_1\",\"Plot_11\",\"SubPlot_112\",\"Plant_1122\",\"Pot_1122\",\"Block_11\",\"Entry_11\",\"Rep_12\",\"\",\"1\",\"\",\"\"],[\"2019-09-10T18:17:34.433Z\",\"67e2d87c\",\"Plant Gamma\",\"0fe3e48b\",\"2017 Plant Study\",\"06307ec0\",\"A0043001\",\"76.50106681\",\"42.44409356\",\"2017\",\"Field_1\",\"Plot_12\",\"SubPlot_123\",\"Plant_1233\",\"Pot_1233\",\"Block_12\",\"Entry_12\",\"Rep_11\",\"\",\"3\",\"\",\"\"],[\"2019-09-10T18:18:34.433Z\",\"67e2d87c\",\"Plant Gamma\",\"0fe3e48b\",\"2017 Plant Study\",\"06307ec0\",\"A0043001\",\"76.50106681\",\"42.44409356\",\"2017\",\"Field_1\",\"Plot_12\",\"SubPlot_123\",\"Plant_1233\",\"Pot_1233\",\"Block_12\",\"Entry_12\",\"Rep_11\",\"25.5\",\"\",\"\",\"\"],[\"2019-09-10T18:19:15.629Z\",\"d98d0d4c\",\"Plant Epsilon\",\"0fe3e48b\",\"2017 Plant Study\",\"59d435cd\",\"A0043002\",\"76.50106683\",\"42.44409356\",\"2017\",\"Field_1\",\"Plot_12\",\"SubPlot_124\",\"Plant_1244\",\"Pot_1244\",\"Block_12\",\"Entry_12\",\"Rep_12\",\"28.9\",\"\",\"\",\"\"],[\"2019-09-10T18:20:15.629Z\",\"d98d0d4c\",\"Plant Epsilon\",\"0fe3e48b\",\"2017 Plant Study\",\"59d435cd\",\"A0043002\",\"76.50106683\",\"42.44409356\",\"2017\",\"Field_1\",\"Plot_12\",\"SubPlot_124\",\"Plant_1244\",\"Pot_1244\",\"Block_12\",\"Entry_12\",\"Rep_12\",\"\",\"0\",\"\",\"\"]]", value = "Matrix of observation data recorded for different observation variables across different observation units")
      @Valid
    public List<List<String>> getData() {
    return data;
  }

  public void setData(List<List<String>> data) {
    this.data = data;
  }

  public ObservationTable headerRow(List<HeaderRowEnum> headerRow) {
    this.headerRow = headerRow;
    return this;
  }

  public ObservationTable addHeaderRowItem(HeaderRowEnum headerRowItem) {
    if (this.headerRow == null) {
      this.headerRow = new ArrayList<HeaderRowEnum>();
    }
    this.headerRow.add(headerRowItem);
    return this;
  }

  /**
   * <p>The table is REQUIRED to have the following columns</p> <ul>   <li>observationUnitDbId - Each row is related to one Observation Unit</li>   <li>observationTimeStamp - Each row is has a time stamp for when the observation was taken</li>   <li>At least one column with an observationVariableDbId</li> </ul> <p>The table may have any or all of the following OPTIONAL columns. Included columns are decided by the server developer</p> <ul>   <li>observationUnitName</li>   <li>studyDbId</li>   <li>studyName</li>   <li>germplasmDbId</li>   <li>germplasmName</li>   <li>positionCoordinateX</li>   <li>positionCoordinateY</li>   <li>year</li> </ul> <p>The table also may have any number of Observation Unit Hierarchy Level columns. For example:</p> <ul>   <li>field</li>   <li>plot</li>   <li>sub-plot</li>   <li>plant</li>   <li>pot</li>   <li>block</li>   <li>entry</li>   <li>rep</li> </ul> <p>The JSON representation provides a pair of extra arrays for defining the headers of the table.  The first array \"headerRow\" will always contain \"observationUnitDbId\" and any or all of the OPTIONAL column header names.  The second array \"observationVariables\" contains the names and DbIds for the Observation Variables represented in the table.  By appending the two arrays, you can construct the complete header row of the table. </p>
   * @return headerRow
  **/
  @ApiModelProperty(example = "[\"observationTimeStamp\",\"observationUnitDbId\",\"observationUnitName\",\"studyDbId\",\"studyName\",\"germplasmDbId\",\"germplasmName\",\"positionCoordinateX\",\"positionCoordinateY\",\"year\",\"field\",\"plot\",\"sub-plot\",\"plant\",\"pot\",\"block\",\"entry\",\"rep\"]", value = "<p>The table is REQUIRED to have the following columns</p> <ul>   <li>observationUnitDbId - Each row is related to one Observation Unit</li>   <li>observationTimeStamp - Each row is has a time stamp for when the observation was taken</li>   <li>At least one column with an observationVariableDbId</li> </ul> <p>The table may have any or all of the following OPTIONAL columns. Included columns are decided by the server developer</p> <ul>   <li>observationUnitName</li>   <li>studyDbId</li>   <li>studyName</li>   <li>germplasmDbId</li>   <li>germplasmName</li>   <li>positionCoordinateX</li>   <li>positionCoordinateY</li>   <li>year</li> </ul> <p>The table also may have any number of Observation Unit Hierarchy Level columns. For example:</p> <ul>   <li>field</li>   <li>plot</li>   <li>sub-plot</li>   <li>plant</li>   <li>pot</li>   <li>block</li>   <li>entry</li>   <li>rep</li> </ul> <p>The JSON representation provides a pair of extra arrays for defining the headers of the table.  The first array \"headerRow\" will always contain \"observationUnitDbId\" and any or all of the OPTIONAL column header names.  The second array \"observationVariables\" contains the names and DbIds for the Observation Variables represented in the table.  By appending the two arrays, you can construct the complete header row of the table. </p>")
  
    public List<HeaderRowEnum> getHeaderRow() {
    return headerRow;
  }

  public void setHeaderRow(List<HeaderRowEnum> headerRow) {
    this.headerRow = headerRow;
  }

  public ObservationTable observationVariables(List<ObservationTableObservationVariables> observationVariables) {
    this.observationVariables = observationVariables;
    return this;
  }

  public ObservationTable addObservationVariablesItem(ObservationTableObservationVariables observationVariablesItem) {
    if (this.observationVariables == null) {
      this.observationVariables = new ArrayList<ObservationTableObservationVariables>();
    }
    this.observationVariables.add(observationVariablesItem);
    return this;
  }

  /**
   * The list of observation variables which have values recorded for them in the data matrix. Append to the 'headerRow' for complete header row of the table.
   * @return observationVariables
  **/
  @ApiModelProperty(example = "[{\"observationVariableDbId\":\"367aa1a9\",\"observationVariableName\":\"Plant height\"},{\"observationVariableDbId\":\"2acb934c\",\"observationVariableName\":\"Carotenoid\"},{\"observationVariableDbId\":\"85a21ce1\",\"observationVariableName\":\"Root color\"},{\"observationVariableDbId\":\"46f590e5\",\"observationVariableName\":\"Virus severity\"}]", value = "The list of observation variables which have values recorded for them in the data matrix. Append to the 'headerRow' for complete header row of the table.")
      @Valid
    public List<ObservationTableObservationVariables> getObservationVariables() {
    return observationVariables;
  }

  public void setObservationVariables(List<ObservationTableObservationVariables> observationVariables) {
    this.observationVariables = observationVariables;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationTable observationTable = (ObservationTable) o;
    return Objects.equals(this.data, observationTable.data) &&
        Objects.equals(this.headerRow, observationTable.headerRow) &&
        Objects.equals(this.observationVariables, observationTable.observationVariables);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, headerRow, observationVariables);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationTable {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    headerRow: ").append(toIndentedString(headerRow)).append("\n");
    sb.append("    observationVariables: ").append(toIndentedString(observationVariables)).append("\n");
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
