package io.swagger.model.pheno;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GeoJSON;
import io.swagger.model.pheno.ObservationUnitLevelRelationship;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * All positional and layout information related to this Observation Unit  MIAPPE V1.1 (DM-73) Spatial distribution - Type and value of a spatial coordinate (georeference or relative) or level of observation (plot 45, subblock 7, block 2) provided as a key-value pair of the form type:value. Levels of observation must be consistent with those listed in the Study section.
 */
@ApiModel(description = "All positional and layout information related to this Observation Unit  MIAPPE V1.1 (DM-73) Spatial distribution - Type and value of a spatial coordinate (georeference or relative) or level of observation (plot 45, subblock 7, block 2) provided as a key-value pair of the form type:value. Levels of observation must be consistent with those listed in the Study section.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class ObservationUnitPosition   {
  /**
   * The type of entry for this observation unit. ex. \"CHECK\", \"TEST\", \"FILLER\"
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

  @JsonProperty("geoCoordinates")
  private GeoJSON geoCoordinates = null;

  @JsonProperty("observationLevel")
  private Object observationLevel = null;

  @JsonProperty("observationLevelRelationships")
  @Valid
  private List<ObservationUnitLevelRelationship> observationLevelRelationships = null;

  @JsonProperty("positionCoordinateX")
  private String positionCoordinateX = null;

  /**
   * The type of positional coordinate used. Must be one of the following values  LONGITUDE - ISO 6709 standard, WGS84 geodetic datum. See 'Location Coordinate Encoding' for details  LATITUDE - ISO 6709 standard, WGS84 geodetic datum. See 'Location Coordinate Encoding' for details  PLANTED_ROW - The physical planted row number   PLANTED_INDIVIDUAL - The physical counted number, could be independant or within a planted row  GRID_ROW - The row index number of a square grid overlay  GRID_COL - The column index number of a square grid overlay  MEASURED_ROW - The distance in meters from a defined 0-th row  MEASURED_COL - The distance in meters from a defined 0-th column
   */
  public enum PositionCoordinateXTypeEnum {
    LONGITUDE("LONGITUDE"),
    
    LATITUDE("LATITUDE"),
    
    PLANTED_ROW("PLANTED_ROW"),
    
    PLANTED_INDIVIDUAL("PLANTED_INDIVIDUAL"),
    
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
   * The type of positional coordinate used. Must be one of the following values  LONGITUDE - ISO 6709 standard, WGS84 geodetic datum. See 'Location Coordinate Encoding' for details  LATITUDE - ISO 6709 standard, WGS84 geodetic datum. See 'Location Coordinate Encoding' for details  PLANTED_ROW - The physical planted row number   PLANTED_INDIVIDUAL - The physical counted number, could be independant or within a planted row  GRID_ROW - The row index number of a square grid overlay  GRID_COL - The column index number of a square grid overlay  MEASURED_ROW - The distance in meters from a defined 0-th row  MEASURED_COL - The distance in meters from a defined 0-th column
   */
  public enum PositionCoordinateYTypeEnum {
    LONGITUDE("LONGITUDE"),
    
    LATITUDE("LATITUDE"),
    
    PLANTED_ROW("PLANTED_ROW"),
    
    PLANTED_INDIVIDUAL("PLANTED_INDIVIDUAL"),
    
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

  public ObservationUnitPosition entryType(EntryTypeEnum entryType) {
    this.entryType = entryType;
    return this;
  }

  /**
   * The type of entry for this observation unit. ex. \"CHECK\", \"TEST\", \"FILLER\"
   * @return entryType
  **/
  @ApiModelProperty(example = "TEST", value = "The type of entry for this observation unit. ex. \"CHECK\", \"TEST\", \"FILLER\"")
  
    public EntryTypeEnum getEntryType() {
    return entryType;
  }

  public void setEntryType(EntryTypeEnum entryType) {
    this.entryType = entryType;
  }

  public ObservationUnitPosition geoCoordinates(GeoJSON geoCoordinates) {
    this.geoCoordinates = geoCoordinates;
    return this;
  }

  /**
   * Get geoCoordinates
   * @return geoCoordinates
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public GeoJSON getGeoCoordinates() {
    return geoCoordinates;
  }

  public void setGeoCoordinates(GeoJSON geoCoordinates) {
    this.geoCoordinates = geoCoordinates;
  }

  public ObservationUnitPosition observationLevel(Object observationLevel) {
    this.observationLevel = observationLevel;
    return this;
  }

  /**
   * Get observationLevel
   * @return observationLevel
  **/
  @ApiModelProperty(value = "")
  
    public Object getObservationLevel() {
    return observationLevel;
  }

  public void setObservationLevel(Object observationLevel) {
    this.observationLevel = observationLevel;
  }

  public ObservationUnitPosition observationLevelRelationships(List<ObservationUnitLevelRelationship> observationLevelRelationships) {
    this.observationLevelRelationships = observationLevelRelationships;
    return this;
  }

  public ObservationUnitPosition addObservationLevelRelationshipsItem(ObservationUnitLevelRelationship observationLevelRelationshipsItem) {
    if (this.observationLevelRelationships == null) {
      this.observationLevelRelationships = new ArrayList<ObservationUnitLevelRelationship>();
    }
    this.observationLevelRelationships.add(observationLevelRelationshipsItem);
    return this;
  }

  /**
   * Observation levels indicate the granularity level at which the measurements are taken.   `levelName` defines the level   `levelOrder` defines where that level exists in the hierarchy of levels. `levelOrder`s lower numbers are at the top of the hierarchy (ie field > 0) and higher numbers are at the bottom of the hierarchy (ie plant > 6).   `levelCode` is an ID code for this level tag. Identify this observation unit by each level of the hierarchy where it exists
   * @return observationLevelRelationships
  **/
  @ApiModelProperty(example = "[{\"levelCode\":\"Field_1\",\"levelName\":\"field\",\"levelOrder\":0},{\"levelCode\":\"Block_12\",\"levelName\":\"block\",\"levelOrder\":1},{\"levelCode\":\"Plot_123\",\"levelName\":\"plot\",\"levelOrder\":2}]", value = "Observation levels indicate the granularity level at which the measurements are taken.   `levelName` defines the level   `levelOrder` defines where that level exists in the hierarchy of levels. `levelOrder`s lower numbers are at the top of the hierarchy (ie field > 0) and higher numbers are at the bottom of the hierarchy (ie plant > 6).   `levelCode` is an ID code for this level tag. Identify this observation unit by each level of the hierarchy where it exists")
      @Valid
    public List<ObservationUnitLevelRelationship> getObservationLevelRelationships() {
    return observationLevelRelationships;
  }

  public void setObservationLevelRelationships(List<ObservationUnitLevelRelationship> observationLevelRelationships) {
    this.observationLevelRelationships = observationLevelRelationships;
  }

  public ObservationUnitPosition positionCoordinateX(String positionCoordinateX) {
    this.positionCoordinateX = positionCoordinateX;
    return this;
  }

  /**
   * The X position coordinate for an observation unit. Different systems may use different coordinate systems.
   * @return positionCoordinateX
  **/
  @ApiModelProperty(example = "74", value = "The X position coordinate for an observation unit. Different systems may use different coordinate systems.")
  
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
   * The type of positional coordinate used. Must be one of the following values  LONGITUDE - ISO 6709 standard, WGS84 geodetic datum. See 'Location Coordinate Encoding' for details  LATITUDE - ISO 6709 standard, WGS84 geodetic datum. See 'Location Coordinate Encoding' for details  PLANTED_ROW - The physical planted row number   PLANTED_INDIVIDUAL - The physical counted number, could be independant or within a planted row  GRID_ROW - The row index number of a square grid overlay  GRID_COL - The column index number of a square grid overlay  MEASURED_ROW - The distance in meters from a defined 0-th row  MEASURED_COL - The distance in meters from a defined 0-th column
   * @return positionCoordinateXType
  **/
  @ApiModelProperty(example = "GRID_COL", value = "The type of positional coordinate used. Must be one of the following values  LONGITUDE - ISO 6709 standard, WGS84 geodetic datum. See 'Location Coordinate Encoding' for details  LATITUDE - ISO 6709 standard, WGS84 geodetic datum. See 'Location Coordinate Encoding' for details  PLANTED_ROW - The physical planted row number   PLANTED_INDIVIDUAL - The physical counted number, could be independant or within a planted row  GRID_ROW - The row index number of a square grid overlay  GRID_COL - The column index number of a square grid overlay  MEASURED_ROW - The distance in meters from a defined 0-th row  MEASURED_COL - The distance in meters from a defined 0-th column")
  
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
  @ApiModelProperty(example = "03", value = "The Y position coordinate for an observation unit. Different systems may use different coordinate systems.")
  
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
   * The type of positional coordinate used. Must be one of the following values  LONGITUDE - ISO 6709 standard, WGS84 geodetic datum. See 'Location Coordinate Encoding' for details  LATITUDE - ISO 6709 standard, WGS84 geodetic datum. See 'Location Coordinate Encoding' for details  PLANTED_ROW - The physical planted row number   PLANTED_INDIVIDUAL - The physical counted number, could be independant or within a planted row  GRID_ROW - The row index number of a square grid overlay  GRID_COL - The column index number of a square grid overlay  MEASURED_ROW - The distance in meters from a defined 0-th row  MEASURED_COL - The distance in meters from a defined 0-th column
   * @return positionCoordinateYType
  **/
  @ApiModelProperty(example = "GRID_ROW", value = "The type of positional coordinate used. Must be one of the following values  LONGITUDE - ISO 6709 standard, WGS84 geodetic datum. See 'Location Coordinate Encoding' for details  LATITUDE - ISO 6709 standard, WGS84 geodetic datum. See 'Location Coordinate Encoding' for details  PLANTED_ROW - The physical planted row number   PLANTED_INDIVIDUAL - The physical counted number, could be independant or within a planted row  GRID_ROW - The row index number of a square grid overlay  GRID_COL - The column index number of a square grid overlay  MEASURED_ROW - The distance in meters from a defined 0-th row  MEASURED_COL - The distance in meters from a defined 0-th column")
  
    public PositionCoordinateYTypeEnum getPositionCoordinateYType() {
    return positionCoordinateYType;
  }

  public void setPositionCoordinateYType(PositionCoordinateYTypeEnum positionCoordinateYType) {
    this.positionCoordinateYType = positionCoordinateYType;
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
    return Objects.equals(this.entryType, observationUnitPosition.entryType) &&
        Objects.equals(this.geoCoordinates, observationUnitPosition.geoCoordinates) &&
        Objects.equals(this.observationLevel, observationUnitPosition.observationLevel) &&
        Objects.equals(this.observationLevelRelationships, observationUnitPosition.observationLevelRelationships) &&
        Objects.equals(this.positionCoordinateX, observationUnitPosition.positionCoordinateX) &&
        Objects.equals(this.positionCoordinateXType, observationUnitPosition.positionCoordinateXType) &&
        Objects.equals(this.positionCoordinateY, observationUnitPosition.positionCoordinateY) &&
        Objects.equals(this.positionCoordinateYType, observationUnitPosition.positionCoordinateYType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entryType, geoCoordinates, observationLevel, observationLevelRelationships, positionCoordinateX, positionCoordinateXType, positionCoordinateY, positionCoordinateYType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationUnitPosition {\n");
    
    sb.append("    entryType: ").append(toIndentedString(entryType)).append("\n");
    sb.append("    geoCoordinates: ").append(toIndentedString(geoCoordinates)).append("\n");
    sb.append("    observationLevel: ").append(toIndentedString(observationLevel)).append("\n");
    sb.append("    observationLevelRelationships: ").append(toIndentedString(observationLevelRelationships)).append("\n");
    sb.append("    positionCoordinateX: ").append(toIndentedString(positionCoordinateX)).append("\n");
    sb.append("    positionCoordinateXType: ").append(toIndentedString(positionCoordinateXType)).append("\n");
    sb.append("    positionCoordinateY: ").append(toIndentedString(positionCoordinateY)).append("\n");
    sb.append("    positionCoordinateYType: ").append(toIndentedString(positionCoordinateYType)).append("\n");
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
