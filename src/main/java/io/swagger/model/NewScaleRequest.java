package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.OntologyReference;
import io.swagger.model.TraitDataType;
import io.swagger.model.ValidValues;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * New scale request object
 */
@ApiModel(description = "New scale request object")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class NewScaleRequest   {
  @JsonProperty("dataType")
  private TraitDataType dataType = null;

  @JsonProperty("decimalPlaces")
  private Integer decimalPlaces = null;

  @JsonProperty("ontologyReference")
  private OntologyReference ontologyReference = null;

  @JsonProperty("scaleName")
  private String scaleName = null;

  @JsonProperty("validValues")
  private ValidValues validValues = null;

  @JsonProperty("xref")
  private String xref = null;

  public NewScaleRequest dataType(TraitDataType dataType) {
    this.dataType = dataType;
    return this;
  }

  /**
   * Get dataType
   * @return dataType
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TraitDataType getDataType() {
    return dataType;
  }

  public void setDataType(TraitDataType dataType) {
    this.dataType = dataType;
  }

  public NewScaleRequest decimalPlaces(Integer decimalPlaces) {
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

  public NewScaleRequest ontologyReference(OntologyReference ontologyReference) {
    this.ontologyReference = ontologyReference;
    return this;
  }

  /**
   * Get ontologyReference
   * @return ontologyReference
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OntologyReference getOntologyReference() {
    return ontologyReference;
  }

  public void setOntologyReference(OntologyReference ontologyReference) {
    this.ontologyReference = ontologyReference;
  }

  public NewScaleRequest scaleName(String scaleName) {
    this.scaleName = scaleName;
    return this;
  }

  /**
   * Name of the scale
   * @return scaleName
  **/
  @ApiModelProperty(value = "Name of the scale")


  public String getScaleName() {
    return scaleName;
  }

  public void setScaleName(String scaleName) {
    this.scaleName = scaleName;
  }

  public NewScaleRequest validValues(ValidValues validValues) {
    this.validValues = validValues;
    return this;
  }

  /**
   * Get validValues
   * @return validValues
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ValidValues getValidValues() {
    return validValues;
  }

  public void setValidValues(ValidValues validValues) {
    this.validValues = validValues;
  }

  public NewScaleRequest xref(String xref) {
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
    NewScaleRequest newScaleRequest = (NewScaleRequest) o;
    return Objects.equals(this.dataType, newScaleRequest.dataType) &&
        Objects.equals(this.decimalPlaces, newScaleRequest.decimalPlaces) &&
        Objects.equals(this.ontologyReference, newScaleRequest.ontologyReference) &&
        Objects.equals(this.scaleName, newScaleRequest.scaleName) &&
        Objects.equals(this.validValues, newScaleRequest.validValues) &&
        Objects.equals(this.xref, newScaleRequest.xref);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataType, decimalPlaces, ontologyReference, scaleName, validValues, xref);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewScaleRequest {\n");
    
    sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
    sb.append("    decimalPlaces: ").append(toIndentedString(decimalPlaces)).append("\n");
    sb.append("    ontologyReference: ").append(toIndentedString(ontologyReference)).append("\n");
    sb.append("    scaleName: ").append(toIndentedString(scaleName)).append("\n");
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

