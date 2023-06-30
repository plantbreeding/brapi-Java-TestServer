package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.OntologyReference;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * Method metadata
 */
@ApiModel(description = "Method metadata")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class Method   {
  @JsonProperty("class")
  private String propertyClass = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("formula")
  private String formula = null;

  @JsonProperty("methodDbId")
  private String methodDbId = null;

  @JsonProperty("methodName")
  private String methodName = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("ontologyReference")
  private OntologyReference ontologyReference = null;

  @JsonProperty("reference")
  private String reference = null;

  public Method propertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
    return this;
  }

  /**
   * Method class (examples: \"Measurement\", \"Counting\", \"Estimation\", \"Computation\", etc.
   * @return propertyClass
  **/
  @ApiModelProperty(value = "Method class (examples: \"Measurement\", \"Counting\", \"Estimation\", \"Computation\", etc.")


  public String getPropertyClass() {
    return propertyClass;
  }

  public void setPropertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
  }

  public Method description(String description) {
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

  public Method formula(String formula) {
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

  public Method methodDbId(String methodDbId) {
    this.methodDbId = methodDbId;
    return this;
  }

  /**
   * Method unique identifier
   * @return methodDbId
  **/
  @ApiModelProperty(value = "Method unique identifier")


  public String getMethodDbId() {
    return methodDbId;
  }

  public void setMethodDbId(String methodDbId) {
    this.methodDbId = methodDbId;
  }

  public Method methodName(String methodName) {
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

  public Method name(String name) {
    this.name = name;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - Use \"methodName\"
   * @return name
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - Use \"methodName\"")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Method ontologyReference(OntologyReference ontologyReference) {
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

  public Method reference(String reference) {
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
    Method method = (Method) o;
    return Objects.equals(this.propertyClass, method.propertyClass) &&
        Objects.equals(this.description, method.description) &&
        Objects.equals(this.formula, method.formula) &&
        Objects.equals(this.methodDbId, method.methodDbId) &&
        Objects.equals(this.methodName, method.methodName) &&
        Objects.equals(this.name, method.name) &&
        Objects.equals(this.ontologyReference, method.ontologyReference) &&
        Objects.equals(this.reference, method.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(propertyClass, description, formula, methodDbId, methodName, name, ontologyReference, reference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Method {\n");
    
    sb.append("    propertyClass: ").append(toIndentedString(propertyClass)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    formula: ").append(toIndentedString(formula)).append("\n");
    sb.append("    methodDbId: ").append(toIndentedString(methodDbId)).append("\n");
    sb.append("    methodName: ").append(toIndentedString(methodName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

