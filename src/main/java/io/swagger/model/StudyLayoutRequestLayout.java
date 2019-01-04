package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * StudyLayoutRequestLayout
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class StudyLayoutRequestLayout   {
  @JsonProperty("X")
  private String X = null;

  @JsonProperty("Y")
  private String Y = null;

  @JsonProperty("blockNumber")
  private Integer blockNumber = null;

  /**
   * Gets or Sets entryType
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

  @JsonProperty("observationUnitDbId")
  private String observationUnitDbId = null;

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
  private Integer replicate = null;

  public StudyLayoutRequestLayout X(String X) {
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

  public StudyLayoutRequestLayout Y(String Y) {
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

  public StudyLayoutRequestLayout blockNumber(Integer blockNumber) {
    this.blockNumber = blockNumber;
    return this;
  }

  /**
   * Get blockNumber
   * @return blockNumber
  **/
  @ApiModelProperty(value = "")


  public Integer getBlockNumber() {
    return blockNumber;
  }

  public void setBlockNumber(Integer blockNumber) {
    this.blockNumber = blockNumber;
  }

  public StudyLayoutRequestLayout entryType(EntryTypeEnum entryType) {
    this.entryType = entryType;
    return this;
  }

  /**
   * Get entryType
   * @return entryType
  **/
  @ApiModelProperty(value = "")


  public EntryTypeEnum getEntryType() {
    return entryType;
  }

  public void setEntryType(EntryTypeEnum entryType) {
    this.entryType = entryType;
  }

  public StudyLayoutRequestLayout observationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
    return this;
  }

  /**
   * Get observationUnitDbId
   * @return observationUnitDbId
  **/
  @ApiModelProperty(value = "")


  public String getObservationUnitDbId() {
    return observationUnitDbId;
  }

  public void setObservationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
  }

  public StudyLayoutRequestLayout positionCoordinateX(String positionCoordinateX) {
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

  public StudyLayoutRequestLayout positionCoordinateXType(PositionCoordinateXTypeEnum positionCoordinateXType) {
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

  public StudyLayoutRequestLayout positionCoordinateY(String positionCoordinateY) {
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

  public StudyLayoutRequestLayout positionCoordinateYType(PositionCoordinateYTypeEnum positionCoordinateYType) {
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

  public StudyLayoutRequestLayout replicate(Integer replicate) {
    this.replicate = replicate;
    return this;
  }

  /**
   * Get replicate
   * @return replicate
  **/
  @ApiModelProperty(value = "")


  public Integer getReplicate() {
    return replicate;
  }

  public void setReplicate(Integer replicate) {
    this.replicate = replicate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudyLayoutRequestLayout studyLayoutRequestLayout = (StudyLayoutRequestLayout) o;
    return Objects.equals(this.X, studyLayoutRequestLayout.X) &&
        Objects.equals(this.Y, studyLayoutRequestLayout.Y) &&
        Objects.equals(this.blockNumber, studyLayoutRequestLayout.blockNumber) &&
        Objects.equals(this.entryType, studyLayoutRequestLayout.entryType) &&
        Objects.equals(this.observationUnitDbId, studyLayoutRequestLayout.observationUnitDbId) &&
        Objects.equals(this.positionCoordinateX, studyLayoutRequestLayout.positionCoordinateX) &&
        Objects.equals(this.positionCoordinateXType, studyLayoutRequestLayout.positionCoordinateXType) &&
        Objects.equals(this.positionCoordinateY, studyLayoutRequestLayout.positionCoordinateY) &&
        Objects.equals(this.positionCoordinateYType, studyLayoutRequestLayout.positionCoordinateYType) &&
        Objects.equals(this.replicate, studyLayoutRequestLayout.replicate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(X, Y, blockNumber, entryType, observationUnitDbId, positionCoordinateX, positionCoordinateXType, positionCoordinateY, positionCoordinateYType, replicate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudyLayoutRequestLayout {\n");
    
    sb.append("    X: ").append(toIndentedString(X)).append("\n");
    sb.append("    Y: ").append(toIndentedString(Y)).append("\n");
    sb.append("    blockNumber: ").append(toIndentedString(blockNumber)).append("\n");
    sb.append("    entryType: ").append(toIndentedString(entryType)).append("\n");
    sb.append("    observationUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
    sb.append("    positionCoordinateX: ").append(toIndentedString(positionCoordinateX)).append("\n");
    sb.append("    positionCoordinateXType: ").append(toIndentedString(positionCoordinateXType)).append("\n");
    sb.append("    positionCoordinateY: ").append(toIndentedString(positionCoordinateY)).append("\n");
    sb.append("    positionCoordinateYType: ").append(toIndentedString(positionCoordinateYType)).append("\n");
    sb.append("    replicate: ").append(toIndentedString(replicate)).append("\n");
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

