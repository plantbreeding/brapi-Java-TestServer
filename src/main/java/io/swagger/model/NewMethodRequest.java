package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.OntologyReference;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * new Method request
 */
@ApiModel(description = "new Method request")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class NewMethodRequest   {
  @JsonProperty("class")
  private String propertyClass = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("formula")
  private String formula = null;

  @JsonProperty("methodName")
  private String methodName = null;

  @JsonProperty("ontologyReference")
  private OntologyReference ontologyReference = null;

  @JsonProperty("reference")
  private String reference = null;

  public NewMethodRequest propertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
    return this;
  }

  /**
   * Method class (examples: \"Measurement\", \"Counting\", \"Estimation\", \"Computation\", etc.)
   * @return propertyClass
  **/
  @ApiModelProperty(value = "Method class (examples: \"Measurement\", \"Counting\", \"Estimation\", \"Computation\", etc.)")


  public String getPropertyClass() {
    return propertyClass;
  }

  public void setPropertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
  }

  public NewMethodRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Method description.
   * @return description
  **/
  @ApiModelProperty(value = "Method description.")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public NewMethodRequest formula(String formula) {
    this.formula = formula;
    return this;
  }

  /**
   * For computational methods i.e., when the method consists in assessing the trait by computing measurements, write the generic formula used for the calculation
   * @return formula
  **/
  @ApiModelProperty(value = "For computational methods i.e., when the method consists in assessing the trait by computing measurements, write the generic formula used for the calculation")


  public String getFormula() {
    return formula;
  }

  public void setFormula(String formula) {
    this.formula = formula;
  }

  public NewMethodRequest methodName(String methodName) {
    this.methodName = methodName;
    return this;
  }

  /**
   * Human readable name for the method
   * @return methodName
  **/
  @ApiModelProperty(value = "Human readable name for the method")


  public String getMethodName() {
    return methodName;
  }

  public void setMethodName(String methodName) {
    this.methodName = methodName;
  }

  public NewMethodRequest ontologyReference(OntologyReference ontologyReference) {
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

  public NewMethodRequest reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Bibliographical reference describing the method.
   * @return reference
  **/
  @ApiModelProperty(value = "Bibliographical reference describing the method.")


  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewMethodRequest newMethodRequest = (NewMethodRequest) o;
    return Objects.equals(this.propertyClass, newMethodRequest.propertyClass) &&
        Objects.equals(this.description, newMethodRequest.description) &&
        Objects.equals(this.formula, newMethodRequest.formula) &&
        Objects.equals(this.methodName, newMethodRequest.methodName) &&
        Objects.equals(this.ontologyReference, newMethodRequest.ontologyReference) &&
        Objects.equals(this.reference, newMethodRequest.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(propertyClass, description, formula, methodName, ontologyReference, reference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewMethodRequest {\n");
    
    sb.append("    propertyClass: ").append(toIndentedString(propertyClass)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    formula: ").append(toIndentedString(formula)).append("\n");
    sb.append("    methodName: ").append(toIndentedString(methodName)).append("\n");
    sb.append("    ontologyReference: ").append(toIndentedString(ontologyReference)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
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

