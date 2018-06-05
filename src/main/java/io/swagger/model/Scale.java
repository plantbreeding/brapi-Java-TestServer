package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ValidValues;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Scale metadata
 */
@ApiModel(description = "Scale metadata")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class Scale   {
  @JsonProperty("dataType")
  private String dataType = null;

  @JsonProperty("decimalPlaces")
  private Integer decimalPlaces = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("scaleDbId")
  private String scaleDbId = null;

  @JsonProperty("validValues")
  private ValidValues validValues = null;

  @JsonProperty("xref")
  private String xref = null;

  public Scale dataType(String dataType) {
    this.dataType = dataType;
    return this;
  }

   /**
   * Class of the scale, entries can be \"Numerical\", \"Nominal\", \"Ordinal\", \"Text\", \"Code\", \"Time\", \"Duration\"
   * @return dataType
  **/
  @ApiModelProperty(value = "Class of the scale, entries can be \"Numerical\", \"Nominal\", \"Ordinal\", \"Text\", \"Code\", \"Time\", \"Duration\"")


  public String getDataType() {
    return dataType;
  }

  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  public Scale decimalPlaces(Integer decimalPlaces) {
    this.decimalPlaces = decimalPlaces;
    return this;
  }

   /**
   * For numerical, number of decimal places to be reported
   * @return decimalPlaces
  **/
  @ApiModelProperty(value = "For numerical, number of decimal places to be reported")


  public Integer getDecimalPlaces() {
    return decimalPlaces;
  }

  public void setDecimalPlaces(Integer decimalPlaces) {
    this.decimalPlaces = decimalPlaces;
  }

  public Scale name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the scale
   * @return name
  **/
  @ApiModelProperty(value = "Name of the scale")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Scale scaleDbId(String scaleDbId) {
    this.scaleDbId = scaleDbId;
    return this;
  }

   /**
   * Unique identifier of the scale. If left blank, the upload system will automatically generate a scale ID.
   * @return scaleDbId
  **/
  @ApiModelProperty(value = "Unique identifier of the scale. If left blank, the upload system will automatically generate a scale ID.")


  public String getScaleDbId() {
    return scaleDbId;
  }

  public void setScaleDbId(String scaleDbId) {
    this.scaleDbId = scaleDbId;
  }

  public Scale validValues(ValidValues validValues) {
    this.validValues = validValues;
    return this;
  }

   /**
   * List of valid values expected for non-numeric data
   * @return validValues
  **/
  @ApiModelProperty(value = "List of valid values expected for non-numeric data")

  @Valid

  public ValidValues getValidValues() {
    return validValues;
  }

  public void setValidValues(ValidValues validValues) {
    this.validValues = validValues;
  }

  public Scale xref(String xref) {
    this.xref = xref;
    return this;
  }

   /**
   * Cross reference to the scale, for example to a unit ontology such as UO or to a unit of an external major database
   * @return xref
  **/
  @ApiModelProperty(value = "Cross reference to the scale, for example to a unit ontology such as UO or to a unit of an external major database")


  public String getXref() {
    return xref;
  }

  public void setXref(String xref) {
    this.xref = xref;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Scale scale = (Scale) o;
    return Objects.equals(this.dataType, scale.dataType) &&
        Objects.equals(this.decimalPlaces, scale.decimalPlaces) &&
        Objects.equals(this.name, scale.name) &&
        Objects.equals(this.scaleDbId, scale.scaleDbId) &&
        Objects.equals(this.validValues, scale.validValues) &&
        Objects.equals(this.xref, scale.xref);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataType, decimalPlaces, name, scaleDbId, validValues, xref);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Scale {\n");
    
    sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
    sb.append("    decimalPlaces: ").append(toIndentedString(decimalPlaces)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    scaleDbId: ").append(toIndentedString(scaleDbId)).append("\n");
    sb.append("    validValues: ").append(toIndentedString(validValues)).append("\n");
    sb.append("    xref: ").append(toIndentedString(xref)).append("\n");
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

