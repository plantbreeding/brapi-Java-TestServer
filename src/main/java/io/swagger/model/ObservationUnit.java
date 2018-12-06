package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ObservationSummary;
import io.swagger.model.ObservationTreatment;
import io.swagger.model.ObservationUnitXref;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ObservationUnit
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class ObservationUnit   {
  @JsonProperty("X")
  private String X = null;

  @JsonProperty("Y")
  private String Y = null;

  @JsonProperty("blockNumber")
  private String blockNumber = null;

  @JsonProperty("entryNumber")
  private String entryNumber = null;

  @JsonProperty("entryType")
  private String entryType = null;

  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("germplasmName")
  private String germplasmName = null;

  @JsonProperty("locationDbId")
  private String locationDbId = null;

  @JsonProperty("locationName")
  private String locationName = null;

  @JsonProperty("observationLevel")
  private String observationLevel = null;

  @JsonProperty("observationLevels")
  private String observationLevels = null;

  @JsonProperty("observationUnitDbId")
  private String observationUnitDbId = null;

  @JsonProperty("observationUnitName")
  private String observationUnitName = null;

  @JsonProperty("observationUnitXref")
  @Valid
  private List<ObservationUnitXref> observationUnitXref = null;

  @JsonProperty("observations")
  @Valid
  private List<ObservationSummary> observations = null;

  @JsonProperty("pedigree")
  private String pedigree = null;

  @JsonProperty("plantNumber")
  private String plantNumber = null;

  @JsonProperty("plotNumber")
  private String plotNumber = null;

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

  @JsonProperty("programDbId")
  private String programDbId = null;

  @JsonProperty("programName")
  private String programName = null;

  @JsonProperty("replicate")
  private String replicate = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  @JsonProperty("studyLocation")
  private String studyLocation = null;

  @JsonProperty("studyLocationDbId")
  private String studyLocationDbId = null;

  @JsonProperty("studyName")
  private String studyName = null;

  @JsonProperty("treatments")
  @Valid
  private List<ObservationTreatment> treatments = null;

  @JsonProperty("trialDbId")
  private String trialDbId = null;

  @JsonProperty("trialName")
  private String trialName = null;

  public ObservationUnit X(String X) {
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

  public ObservationUnit Y(String Y) {
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

  public ObservationUnit blockNumber(String blockNumber) {
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

  public ObservationUnit entryNumber(String entryNumber) {
    this.entryNumber = entryNumber;
    return this;
  }

  /**
   * The entry number for an observation unit. Different systems may use different entry systems.
   * @return entryNumber
  **/
  @ApiModelProperty(value = "The entry number for an observation unit. Different systems may use different entry systems.")


  public String getEntryNumber() {
    return entryNumber;
  }

  public void setEntryNumber(String entryNumber) {
    this.entryNumber = entryNumber;
  }

  public ObservationUnit entryType(String entryType) {
    this.entryType = entryType;
    return this;
  }

  /**
   * The type of entry for this observation unit. ex. \"check\", \"test\", \"filler\"
   * @return entryType
  **/
  @ApiModelProperty(value = "The type of entry for this observation unit. ex. \"check\", \"test\", \"filler\"")


  public String getEntryType() {
    return entryType;
  }

  public void setEntryType(String entryType) {
    this.entryType = entryType;
  }

  public ObservationUnit germplasmDbId(String germplasmDbId) {
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

  public ObservationUnit germplasmName(String germplasmName) {
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

  public ObservationUnit locationDbId(String locationDbId) {
    this.locationDbId = locationDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a location, associated with this study
   * @return locationDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a location, associated with this study")


  public String getLocationDbId() {
    return locationDbId;
  }

  public void setLocationDbId(String locationDbId) {
    this.locationDbId = locationDbId;
  }

  public ObservationUnit locationName(String locationName) {
    this.locationName = locationName;
    return this;
  }

  /**
   * The human readable name of a location associated with this study
   * @return locationName
  **/
  @ApiModelProperty(value = "The human readable name of a location associated with this study")


  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public ObservationUnit observationLevel(String observationLevel) {
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

  public ObservationUnit observationLevels(String observationLevels) {
    this.observationLevels = observationLevels;
    return this;
  }

  /**
   * Concatenation of the levels of this observationUnit. Used to handle non canonical level structures. Format levelType:levelID,levelType:levelID
   * @return observationLevels
  **/
  @ApiModelProperty(value = "Concatenation of the levels of this observationUnit. Used to handle non canonical level structures. Format levelType:levelID,levelType:levelID")


  public String getObservationLevels() {
    return observationLevels;
  }

  public void setObservationLevels(String observationLevels) {
    this.observationLevels = observationLevels;
  }

  public ObservationUnit observationUnitDbId(String observationUnitDbId) {
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

  public ObservationUnit observationUnitName(String observationUnitName) {
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

  public ObservationUnit observationUnitXref(List<ObservationUnitXref> observationUnitXref) {
    this.observationUnitXref = observationUnitXref;
    return this;
  }

  public ObservationUnit addObservationUnitXrefItem(ObservationUnitXref observationUnitXrefItem) {
    if (this.observationUnitXref == null) {
      this.observationUnitXref = new ArrayList<ObservationUnitXref>();
    }
    this.observationUnitXref.add(observationUnitXrefItem);
    return this;
  }

  /**
   * A list of external references to this observation unit
   * @return observationUnitXref
  **/
  @ApiModelProperty(value = "A list of external references to this observation unit")

  @Valid

  public List<ObservationUnitXref> getObservationUnitXref() {
    return observationUnitXref;
  }

  public void setObservationUnitXref(List<ObservationUnitXref> observationUnitXref) {
    this.observationUnitXref = observationUnitXref;
  }

  public ObservationUnit observations(List<ObservationSummary> observations) {
    this.observations = observations;
    return this;
  }

  public ObservationUnit addObservationsItem(ObservationSummary observationsItem) {
    if (this.observations == null) {
      this.observations = new ArrayList<ObservationSummary>();
    }
    this.observations.add(observationsItem);
    return this;
  }

  /**
   * List of observations associated with this observation unit
   * @return observations
  **/
  @ApiModelProperty(value = "List of observations associated with this observation unit")

  @Valid

  public List<ObservationSummary> getObservations() {
    return observations;
  }

  public void setObservations(List<ObservationSummary> observations) {
    this.observations = observations;
  }

  public ObservationUnit pedigree(String pedigree) {
    this.pedigree = pedigree;
    return this;
  }

  /**
   * The string representation of the pedigree of this observation unit
   * @return pedigree
  **/
  @ApiModelProperty(value = "The string representation of the pedigree of this observation unit")


  public String getPedigree() {
    return pedigree;
  }

  public void setPedigree(String pedigree) {
    this.pedigree = pedigree;
  }

  public ObservationUnit plantNumber(String plantNumber) {
    this.plantNumber = plantNumber;
    return this;
  }

  /**
   * The plant number in a field. Applicable for observationLevel: \"plant\"
   * @return plantNumber
  **/
  @ApiModelProperty(value = "The plant number in a field. Applicable for observationLevel: \"plant\"")


  public String getPlantNumber() {
    return plantNumber;
  }

  public void setPlantNumber(String plantNumber) {
    this.plantNumber = plantNumber;
  }

  public ObservationUnit plotNumber(String plotNumber) {
    this.plotNumber = plotNumber;
    return this;
  }

  /**
   * The plot number in a field. Applicable for observationLevel: \"plot\"
   * @return plotNumber
  **/
  @ApiModelProperty(value = "The plot number in a field. Applicable for observationLevel: \"plot\"")


  public String getPlotNumber() {
    return plotNumber;
  }

  public void setPlotNumber(String plotNumber) {
    this.plotNumber = plotNumber;
  }

  public ObservationUnit positionCoordinateX(String positionCoordinateX) {
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

  public ObservationUnit positionCoordinateXType(PositionCoordinateXTypeEnum positionCoordinateXType) {
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

  public ObservationUnit positionCoordinateY(String positionCoordinateY) {
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

  public ObservationUnit positionCoordinateYType(PositionCoordinateYTypeEnum positionCoordinateYType) {
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

  public ObservationUnit programDbId(String programDbId) {
    this.programDbId = programDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a program
   * @return programDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a program")


  public String getProgramDbId() {
    return programDbId;
  }

  public void setProgramDbId(String programDbId) {
    this.programDbId = programDbId;
  }

  public ObservationUnit programName(String programName) {
    this.programName = programName;
    return this;
  }

  /**
   * The human readable name of a program
   * @return programName
  **/
  @ApiModelProperty(value = "The human readable name of a program")


  public String getProgramName() {
    return programName;
  }

  public void setProgramName(String programName) {
    this.programName = programName;
  }

  public ObservationUnit replicate(String replicate) {
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

  public ObservationUnit studyDbId(String studyDbId) {
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

  public ObservationUnit studyLocation(String studyLocation) {
    this.studyLocation = studyLocation;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - see \"locationName\"
   * @return studyLocation
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - see \"locationName\"")


  public String getStudyLocation() {
    return studyLocation;
  }

  public void setStudyLocation(String studyLocation) {
    this.studyLocation = studyLocation;
  }

  public ObservationUnit studyLocationDbId(String studyLocationDbId) {
    this.studyLocationDbId = studyLocationDbId;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - see \"locationDbId\"
   * @return studyLocationDbId
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - see \"locationDbId\"")


  public String getStudyLocationDbId() {
    return studyLocationDbId;
  }

  public void setStudyLocationDbId(String studyLocationDbId) {
    this.studyLocationDbId = studyLocationDbId;
  }

  public ObservationUnit studyName(String studyName) {
    this.studyName = studyName;
    return this;
  }

  /**
   * The human readable name for a study
   * @return studyName
  **/
  @ApiModelProperty(value = "The human readable name for a study")


  public String getStudyName() {
    return studyName;
  }

  public void setStudyName(String studyName) {
    this.studyName = studyName;
  }

  public ObservationUnit treatments(List<ObservationTreatment> treatments) {
    this.treatments = treatments;
    return this;
  }

  public ObservationUnit addTreatmentsItem(ObservationTreatment treatmentsItem) {
    if (this.treatments == null) {
      this.treatments = new ArrayList<ObservationTreatment>();
    }
    this.treatments.add(treatmentsItem);
    return this;
  }

  /**
   * List of treatments applied to an observation unit.
   * @return treatments
  **/
  @ApiModelProperty(value = "List of treatments applied to an observation unit.")

  @Valid

  public List<ObservationTreatment> getTreatments() {
    return treatments;
  }

  public void setTreatments(List<ObservationTreatment> treatments) {
    this.treatments = treatments;
  }

  public ObservationUnit trialDbId(String trialDbId) {
    this.trialDbId = trialDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a trial
   * @return trialDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a trial")


  public String getTrialDbId() {
    return trialDbId;
  }

  public void setTrialDbId(String trialDbId) {
    this.trialDbId = trialDbId;
  }

  public ObservationUnit trialName(String trialName) {
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
    ObservationUnit observationUnit = (ObservationUnit) o;
    return Objects.equals(this.X, observationUnit.X) &&
        Objects.equals(this.Y, observationUnit.Y) &&
        Objects.equals(this.blockNumber, observationUnit.blockNumber) &&
        Objects.equals(this.entryNumber, observationUnit.entryNumber) &&
        Objects.equals(this.entryType, observationUnit.entryType) &&
        Objects.equals(this.germplasmDbId, observationUnit.germplasmDbId) &&
        Objects.equals(this.germplasmName, observationUnit.germplasmName) &&
        Objects.equals(this.locationDbId, observationUnit.locationDbId) &&
        Objects.equals(this.locationName, observationUnit.locationName) &&
        Objects.equals(this.observationLevel, observationUnit.observationLevel) &&
        Objects.equals(this.observationLevels, observationUnit.observationLevels) &&
        Objects.equals(this.observationUnitDbId, observationUnit.observationUnitDbId) &&
        Objects.equals(this.observationUnitName, observationUnit.observationUnitName) &&
        Objects.equals(this.observationUnitXref, observationUnit.observationUnitXref) &&
        Objects.equals(this.observations, observationUnit.observations) &&
        Objects.equals(this.pedigree, observationUnit.pedigree) &&
        Objects.equals(this.plantNumber, observationUnit.plantNumber) &&
        Objects.equals(this.plotNumber, observationUnit.plotNumber) &&
        Objects.equals(this.positionCoordinateX, observationUnit.positionCoordinateX) &&
        Objects.equals(this.positionCoordinateXType, observationUnit.positionCoordinateXType) &&
        Objects.equals(this.positionCoordinateY, observationUnit.positionCoordinateY) &&
        Objects.equals(this.positionCoordinateYType, observationUnit.positionCoordinateYType) &&
        Objects.equals(this.programDbId, observationUnit.programDbId) &&
        Objects.equals(this.programName, observationUnit.programName) &&
        Objects.equals(this.replicate, observationUnit.replicate) &&
        Objects.equals(this.studyDbId, observationUnit.studyDbId) &&
        Objects.equals(this.studyLocation, observationUnit.studyLocation) &&
        Objects.equals(this.studyLocationDbId, observationUnit.studyLocationDbId) &&
        Objects.equals(this.studyName, observationUnit.studyName) &&
        Objects.equals(this.treatments, observationUnit.treatments) &&
        Objects.equals(this.trialDbId, observationUnit.trialDbId) &&
        Objects.equals(this.trialName, observationUnit.trialName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(X, Y, blockNumber, entryNumber, entryType, germplasmDbId, germplasmName, locationDbId, locationName, observationLevel, observationLevels, observationUnitDbId, observationUnitName, observationUnitXref, observations, pedigree, plantNumber, plotNumber, positionCoordinateX, positionCoordinateXType, positionCoordinateY, positionCoordinateYType, programDbId, programName, replicate, studyDbId, studyLocation, studyLocationDbId, studyName, treatments, trialDbId, trialName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationUnit {\n");
    
    sb.append("    X: ").append(toIndentedString(X)).append("\n");
    sb.append("    Y: ").append(toIndentedString(Y)).append("\n");
    sb.append("    blockNumber: ").append(toIndentedString(blockNumber)).append("\n");
    sb.append("    entryNumber: ").append(toIndentedString(entryNumber)).append("\n");
    sb.append("    entryType: ").append(toIndentedString(entryType)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
    sb.append("    locationDbId: ").append(toIndentedString(locationDbId)).append("\n");
    sb.append("    locationName: ").append(toIndentedString(locationName)).append("\n");
    sb.append("    observationLevel: ").append(toIndentedString(observationLevel)).append("\n");
    sb.append("    observationLevels: ").append(toIndentedString(observationLevels)).append("\n");
    sb.append("    observationUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
    sb.append("    observationUnitName: ").append(toIndentedString(observationUnitName)).append("\n");
    sb.append("    observationUnitXref: ").append(toIndentedString(observationUnitXref)).append("\n");
    sb.append("    observations: ").append(toIndentedString(observations)).append("\n");
    sb.append("    pedigree: ").append(toIndentedString(pedigree)).append("\n");
    sb.append("    plantNumber: ").append(toIndentedString(plantNumber)).append("\n");
    sb.append("    plotNumber: ").append(toIndentedString(plotNumber)).append("\n");
    sb.append("    positionCoordinateX: ").append(toIndentedString(positionCoordinateX)).append("\n");
    sb.append("    positionCoordinateXType: ").append(toIndentedString(positionCoordinateXType)).append("\n");
    sb.append("    positionCoordinateY: ").append(toIndentedString(positionCoordinateY)).append("\n");
    sb.append("    positionCoordinateYType: ").append(toIndentedString(positionCoordinateYType)).append("\n");
    sb.append("    programDbId: ").append(toIndentedString(programDbId)).append("\n");
    sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
    sb.append("    replicate: ").append(toIndentedString(replicate)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
    sb.append("    studyLocation: ").append(toIndentedString(studyLocation)).append("\n");
    sb.append("    studyLocationDbId: ").append(toIndentedString(studyLocationDbId)).append("\n");
    sb.append("    studyName: ").append(toIndentedString(studyName)).append("\n");
    sb.append("    treatments: ").append(toIndentedString(treatments)).append("\n");
    sb.append("    trialDbId: ").append(toIndentedString(trialDbId)).append("\n");
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

