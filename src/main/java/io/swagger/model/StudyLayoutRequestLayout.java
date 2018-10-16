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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class StudyLayoutRequestLayout   {
  @JsonProperty("X")
  private Integer X = null;

  @JsonProperty("Y")
  private Integer Y = null;

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

  @JsonProperty("replicate")
  private Integer replicate = null;

  public StudyLayoutRequestLayout X(Integer X) {
    this.X = X;
    return this;
  }

   /**
   * Get X
   * @return X
  **/
  @ApiModelProperty(value = "")


  public Integer getX() {
    return X;
  }

  public void setX(Integer X) {
    this.X = X;
  }

  public StudyLayoutRequestLayout Y(Integer Y) {
    this.Y = Y;
    return this;
  }

   /**
   * Get Y
   * @return Y
  **/
  @ApiModelProperty(value = "")


  public Integer getY() {
    return Y;
  }

  public void setY(Integer Y) {
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
        Objects.equals(this.replicate, studyLayoutRequestLayout.replicate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(X, Y, blockNumber, entryType, observationUnitDbId, replicate);
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

