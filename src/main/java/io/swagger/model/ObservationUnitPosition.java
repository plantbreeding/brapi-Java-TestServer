package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ObservationUnitPosition
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class ObservationUnitPosition   {
  @JsonProperty("X")
  private String X = null;

  @JsonProperty("Y")
  private String Y = null;

  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("blockNumber")
  private String blockNumber = null;

  /**
   * The type of entry for this observation unit. ex. \"check\", \"test\", \"filler\"
   */
  public enum EntryTypeEnum {
    CHECK("CHECK"),
    
    TEST("TEST"),
    
    FILLER("FILLER");

    private String value;

    EntryTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EntryTypeEnum fromValue(String text) {
      for (EntryTypeEnum b : EntryTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("entryType")
  private EntryTypeEnum entryType = null;

  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("germplasmName")
  private String germplasmName = null;

  @JsonProperty("observationLevel")
  private String observationLevel = null;

  @JsonProperty("observationUnitDbId")
  private String observationUnitDbId = null;

  @JsonProperty("observationUnitName")
  private String observationUnitName = null;

  @JsonProperty("positionCoordinateX")
  private String positionCoordinateX = null;

  /**
   * The type of positional coordinate used. Must be one of the following values LONGITUDE - ISO 6709 standard, WGS84 geodetic datum. See \"Location Coordinate Encoding\" for details LATITUDE - ISO 6709 standard, WGS84 geodetic datum. See \"Location Coordinate Encoding\" for details PLANTED_ROW - The physical planted row number  PLANTED_INDIVIDUAl - The physical counted number, could be independant or within a planted row GRID_ROW - The row index number of a square grid overlay GRID_COL - The column index number of a square grid overlay MEASURED_ROW - The distance in meters from a defined 0th row MEASURED_COL - The distance in meters from a defined 0th column 
   */
  public enum PositionCoordinateXTypeEnum {
    LONGITUDE("LONGITUDE"),
    
    LATITUDE("LATITUDE"),
    
    PLANTED_ROW("PLANTED_ROW"),
    
    PLANTED_INDIVIDUAL("PLANTED_INDIVIDUAl"),
    
    GRID_ROW("GRID_ROW"),
    
    GRID_COL("GRID_COL"),
    
    MEASURED_ROW("MEASURED_ROW"),
    
    MEASURED_COL("MEASURED_COL");

    private String value;

    PositionCoordinateXTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PositionCoordinateXTypeEnum fromValue(String text) {
      for (PositionCoordinateXTypeEnum b : PositionCoordinateXTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("positionCoordinateXType")
  private PositionCoordinateXTypeEnum positionCoordinateXType = null;

  @JsonProperty("positionCoordinateY")
  private String positionCoordinateY = null;

  /**
   * The type of positional coordinate used. Must be one of the following values LONGITUDE - ISO 6709 standard, WGS84 geodetic datum. See \"Location Coordinate Encoding\" for details LATITUDE - ISO 6709 standard, WGS84 geodetic datum. See \"Location Coordinate Encoding\" for details PLANTED_ROW - The physical planted row number  PLANTED_INDIVIDUAl - The physical counted number, could be independant or within a planted row GRID_ROW - The row index number of a square grid overlay GRID_COL - The column index number of a square grid overlay MEASURED_ROW - The distance in meters from a defined 0th row MEASURED_COL - The distance in meters from a defined 0th column 
   */
  public enum PositionCoordinateYTypeEnum {
    LONGITUDE("LONGITUDE"),
    
    LATITUDE("LATITUDE"),
    
    PLANTED_ROW("PLANTED_ROW"),
    
    PLANTED_INDIVIDUAL("PLANTED_INDIVIDUAl"),
    
    GRID_ROW("GRID_ROW"),
    
    GRID_COL("GRID_COL"),
    
    MEASURED_ROW("MEASURED_ROW"),
    
    MEASURED_COL("MEASURED_COL");

    private String value;

    PositionCoordinateYTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PositionCoordinateYTypeEnum fromValue(String text) {
      for (PositionCoordinateYTypeEnum b : PositionCoordinateYTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("positionCoordinateYType")
  private PositionCoordinateYTypeEnum positionCoordinateYType = null;

  @JsonProperty("replicate")
  private String replicate = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  public ObservationUnitPosition X(String X) {
    this.X = X;
    return this;
  }

  /**
   * DEPRECATED - use \"positionCoordinateX\"
   * @return X
  **/
  @ApiModelProperty(value = "DEPRECATED - use \"positionCoordinateX\"")


  public String getX() {
    return X;
  }

  public void setX(String X) {
    this.X = X;
  }

  public ObservationUnitPosition Y(String Y) {
    this.Y = Y;
    return this;
  }

  /**
   * DEPRECATED - use \"positionCoordinateY\"
   * @return Y
  **/
  @ApiModelProperty(value = "DEPRECATED - use \"positionCoordinateY\"")


  public String getY() {
    return Y;
  }

  public void setY(String Y) {
    this.Y = Y;
  }

  public ObservationUnitPosition additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public ObservationUnitPosition putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = null;
    }
    this.additionalInfo.put(key, additionalInfoItem);
    return this;
  }

  /**
   * Additional arbitrary info
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Additional arbitrary info")


  public Map<String, String> getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public ObservationUnitPosition blockNumber(String blockNumber) {
    this.blockNumber = blockNumber;
    return this;
  }

  /**
   * The block number for an observation unit. Different systems may use different block designs.
   * @return blockNumber
  **/
  @ApiModelProperty(value = "The block number for an observation unit. Different systems may use different block designs.")


  public String getBlockNumber() {
    return blockNumber;
  }

  public void setBlockNumber(String blockNumber) {
    this.blockNumber = blockNumber;
  }

  public ObservationUnitPosition entryType(EntryTypeEnum entryType) {
    this.entryType = entryType;
    return this;
  }

  /**
   * The type of entry for this observation unit. ex. \"check\", \"test\", \"filler\"
   * @return entryType
  **/
  @ApiModelProperty(value = "The type of entry for this observation unit. ex. \"check\", \"test\", \"filler\"")


  public EntryTypeEnum getEntryType() {
    return entryType;
  }

  public void setEntryType(EntryTypeEnum entryType) {
    this.entryType = entryType;
  }

  public ObservationUnitPosition germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

  /**
   *  The ID which uniquely identifies a germplasm
   * @return germplasmDbId
  **/
  @ApiModelProperty(value = " The ID which uniquely identifies a germplasm")


  public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public ObservationUnitPosition germplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
    return this;
  }

  /**
   * Name of the germplasm. It can be the prefered name and does not have to be unique.
   * @return germplasmName
  **/
  @ApiModelProperty(value = "Name of the germplasm. It can be the prefered name and does not have to be unique.")


  public String getGermplasmName() {
    return germplasmName;
  }

  public void setGermplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
  }

  public ObservationUnitPosition observationLevel(String observationLevel) {
    this.observationLevel = observationLevel;
    return this;
  }

  /**
   * The level of an observation unit. ex. \"plot\", \"plant\"
   * @return observationLevel
  **/
  @ApiModelProperty(value = "The level of an observation unit. ex. \"plot\", \"plant\"")


  public String getObservationLevel() {
    return observationLevel;
  }

  public void setObservationLevel(String observationLevel) {
    this.observationLevel = observationLevel;
  }

  public ObservationUnitPosition observationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies an observation unit
   * @return observationUnitDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies an observation unit")


  public String getObservationUnitDbId() {
    return observationUnitDbId;
  }

  public void setObservationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
  }

  public ObservationUnitPosition observationUnitName(String observationUnitName) {
    this.observationUnitName = observationUnitName;
    return this;
  }

  /**
   * A human readable name for an observation unit
   * @return observationUnitName
  **/
  @ApiModelProperty(value = "A human readable name for an observation unit")


  public String getObservationUnitName() {
    return observationUnitName;
  }

  public void setObservationUnitName(String observationUnitName) {
    this.observationUnitName = observationUnitName;
  }

  public ObservationUnitPosition positionCoordinateX(String positionCoordinateX) {
    this.positionCoordinateX = positionCoordinateX;
    return this;
  }

  /**
   * The X position coordinate for an observation unit. Different systems may use different coordinate systems.
   * @return positionCoordinateX
  **/
  @ApiModelProperty(value = "The X position coordinate for an observation unit. Different systems may use different coordinate systems.")


  public String getPositionCoordinateX() {
    return positionCoordinateX;
  }

  public void setPositionCoordinateX(String positionCoordinateX) {
    this.positionCoordinateX = positionCoordinateX;
  }

  public ObservationUnitPosition positionCoordinateXType(PositionCoordinateXTypeEnum positionCoordinateXType) {
    this.positionCoordinateXType = positionCoordinateXType;
    return this;
  }

  /**
   * The type of positional coordinate used. Must be one of the following values LONGITUDE - ISO 6709 standard, WGS84 geodetic datum. See \"Location Coordinate Encoding\" for details LATITUDE - ISO 6709 standard, WGS84 geodetic datum. See \"Location Coordinate Encoding\" for details PLANTED_ROW - The physical planted row number  PLANTED_INDIVIDUAl - The physical counted number, could be independant or within a planted row GRID_ROW - The row index number of a square grid overlay GRID_COL - The column index number of a square grid overlay MEASURED_ROW - The distance in meters from a defined 0th row MEASURED_COL - The distance in meters from a defined 0th column 
   * @return positionCoordinateXType
  **/
  @ApiModelProperty(value = "The type of positional coordinate used. Must be one of the following values LONGITUDE - ISO 6709 standard, WGS84 geodetic datum. See \"Location Coordinate Encoding\" for details LATITUDE - ISO 6709 standard, WGS84 geodetic datum. See \"Location Coordinate Encoding\" for details PLANTED_ROW - The physical planted row number  PLANTED_INDIVIDUAl - The physical counted number, could be independant or within a planted row GRID_ROW - The row index number of a square grid overlay GRID_COL - The column index number of a square grid overlay MEASURED_ROW - The distance in meters from a defined 0th row MEASURED_COL - The distance in meters from a defined 0th column ")


  public PositionCoordinateXTypeEnum getPositionCoordinateXType() {
    return positionCoordinateXType;
  }

  public void setPositionCoordinateXType(PositionCoordinateXTypeEnum positionCoordinateXType) {
    this.positionCoordinateXType = positionCoordinateXType;
  }

  public ObservationUnitPosition positionCoordinateY(String positionCoordinateY) {
    this.positionCoordinateY = positionCoordinateY;
    return this;
  }

  /**
   * The Y position coordinate for an observation unit. Different systems may use different coordinate systems.
   * @return positionCoordinateY
  **/
  @ApiModelProperty(value = "The Y position coordinate for an observation unit. Different systems may use different coordinate systems.")


  public String getPositionCoordinateY() {
    return positionCoordinateY;
  }

  public void setPositionCoordinateY(String positionCoordinateY) {
    this.positionCoordinateY = positionCoordinateY;
  }

  public ObservationUnitPosition positionCoordinateYType(PositionCoordinateYTypeEnum positionCoordinateYType) {
    this.positionCoordinateYType = positionCoordinateYType;
    return this;
  }

  /**
   * The type of positional coordinate used. Must be one of the following values LONGITUDE - ISO 6709 standard, WGS84 geodetic datum. See \"Location Coordinate Encoding\" for details LATITUDE - ISO 6709 standard, WGS84 geodetic datum. See \"Location Coordinate Encoding\" for details PLANTED_ROW - The physical planted row number  PLANTED_INDIVIDUAl - The physical counted number, could be independant or within a planted row GRID_ROW - The row index number of a square grid overlay GRID_COL - The column index number of a square grid overlay MEASURED_ROW - The distance in meters from a defined 0th row MEASURED_COL - The distance in meters from a defined 0th column 
   * @return positionCoordinateYType
  **/
  @ApiModelProperty(value = "The type of positional coordinate used. Must be one of the following values LONGITUDE - ISO 6709 standard, WGS84 geodetic datum. See \"Location Coordinate Encoding\" for details LATITUDE - ISO 6709 standard, WGS84 geodetic datum. See \"Location Coordinate Encoding\" for details PLANTED_ROW - The physical planted row number  PLANTED_INDIVIDUAl - The physical counted number, could be independant or within a planted row GRID_ROW - The row index number of a square grid overlay GRID_COL - The column index number of a square grid overlay MEASURED_ROW - The distance in meters from a defined 0th row MEASURED_COL - The distance in meters from a defined 0th column ")


  public PositionCoordinateYTypeEnum getPositionCoordinateYType() {
    return positionCoordinateYType;
  }

  public void setPositionCoordinateYType(PositionCoordinateYTypeEnum positionCoordinateYType) {
    this.positionCoordinateYType = positionCoordinateYType;
  }

  public ObservationUnitPosition replicate(String replicate) {
    this.replicate = replicate;
    return this;
  }

  /**
   * The replicate number of an observation unit. May be the same as blockNumber.
   * @return replicate
  **/
  @ApiModelProperty(value = "The replicate number of an observation unit. May be the same as blockNumber.")


  public String getReplicate() {
    return replicate;
  }

  public void setReplicate(String replicate) {
    this.replicate = replicate;
  }

  public ObservationUnitPosition studyDbId(String studyDbId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationUnitPosition observationUnitPosition = (ObservationUnitPosition) o;
    return Objects.equals(this.X, observationUnitPosition.X) &&
        Objects.equals(this.Y, observationUnitPosition.Y) &&
        Objects.equals(this.additionalInfo, observationUnitPosition.additionalInfo) &&
        Objects.equals(this.blockNumber, observationUnitPosition.blockNumber) &&
        Objects.equals(this.entryType, observationUnitPosition.entryType) &&
        Objects.equals(this.germplasmDbId, observationUnitPosition.germplasmDbId) &&
        Objects.equals(this.germplasmName, observationUnitPosition.germplasmName) &&
        Objects.equals(this.observationLevel, observationUnitPosition.observationLevel) &&
        Objects.equals(this.observationUnitDbId, observationUnitPosition.observationUnitDbId) &&
        Objects.equals(this.observationUnitName, observationUnitPosition.observationUnitName) &&
        Objects.equals(this.positionCoordinateX, observationUnitPosition.positionCoordinateX) &&
        Objects.equals(this.positionCoordinateXType, observationUnitPosition.positionCoordinateXType) &&
        Objects.equals(this.positionCoordinateY, observationUnitPosition.positionCoordinateY) &&
        Objects.equals(this.positionCoordinateYType, observationUnitPosition.positionCoordinateYType) &&
        Objects.equals(this.replicate, observationUnitPosition.replicate) &&
        Objects.equals(this.studyDbId, observationUnitPosition.studyDbId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(X, Y, additionalInfo, blockNumber, entryType, germplasmDbId, germplasmName, observationLevel, observationUnitDbId, observationUnitName, positionCoordinateX, positionCoordinateXType, positionCoordinateY, positionCoordinateYType, replicate, studyDbId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationUnitPosition {\n");
    
    sb.append("    X: ").append(toIndentedString(X)).append("\n");
    sb.append("    Y: ").append(toIndentedString(Y)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    blockNumber: ").append(toIndentedString(blockNumber)).append("\n");
    sb.append("    entryType: ").append(toIndentedString(entryType)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
    sb.append("    observationLevel: ").append(toIndentedString(observationLevel)).append("\n");
    sb.append("    observationUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
    sb.append("    observationUnitName: ").append(toIndentedString(observationUnitName)).append("\n");
    sb.append("    positionCoordinateX: ").append(toIndentedString(positionCoordinateX)).append("\n");
    sb.append("    positionCoordinateXType: ").append(toIndentedString(positionCoordinateXType)).append("\n");
    sb.append("    positionCoordinateY: ").append(toIndentedString(positionCoordinateY)).append("\n");
    sb.append("    positionCoordinateYType: ").append(toIndentedString(positionCoordinateYType)).append("\n");
    sb.append("    replicate: ").append(toIndentedString(replicate)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
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

