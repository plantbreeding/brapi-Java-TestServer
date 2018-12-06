package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Ontology reference details
 */
@ApiModel(description = "Ontology reference details")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class VendorOntologyReference   {
  @JsonProperty("ontologyID")
  private String ontologyID = null;

  @JsonProperty("ontologyPrefix")
  private String ontologyPrefix = null;

  @JsonProperty("ontologyTerm")
  private String ontologyTerm = null;

  public VendorOntologyReference ontologyID(String ontologyID) {
    this.ontologyID = ontologyID;
    return this;
  }

  /**
   * Ontology unique ID (example: \"0025034\" or \"4577\")
   * @return ontologyID
  **/
  @ApiModelProperty(value = "Ontology unique ID (example: \"0025034\" or \"4577\")")


  public String getOntologyID() {
    return ontologyID;
  }

  public void setOntologyID(String ontologyID) {
    this.ontologyID = ontologyID;
  }

  public VendorOntologyReference ontologyPrefix(String ontologyPrefix) {
    this.ontologyPrefix = ontologyPrefix;
    return this;
  }

  /**
   * Ontology identifier prefix (example: \"PO\" or \"NCBITaxon\")
   * @return ontologyPrefix
  **/
  @ApiModelProperty(value = "Ontology identifier prefix (example: \"PO\" or \"NCBITaxon\")")


  public String getOntologyPrefix() {
    return ontologyPrefix;
  }

  public void setOntologyPrefix(String ontologyPrefix) {
    this.ontologyPrefix = ontologyPrefix;
  }

  public VendorOntologyReference ontologyTerm(String ontologyTerm) {
    this.ontologyTerm = ontologyTerm;
    return this;
  }

  /**
   * Ontology term string (example: \"leaf\" or \"Zea mays\")
   * @return ontologyTerm
  **/
  @ApiModelProperty(value = "Ontology term string (example: \"leaf\" or \"Zea mays\")")


  public String getOntologyTerm() {
    return ontologyTerm;
  }

  public void setOntologyTerm(String ontologyTerm) {
    this.ontologyTerm = ontologyTerm;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorOntologyReference vendorOntologyReference = (VendorOntologyReference) o;
    return Objects.equals(this.ontologyID, vendorOntologyReference.ontologyID) &&
        Objects.equals(this.ontologyPrefix, vendorOntologyReference.ontologyPrefix) &&
        Objects.equals(this.ontologyTerm, vendorOntologyReference.ontologyTerm);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ontologyID, ontologyPrefix, ontologyTerm);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorOntologyReference {\n");
    
    sb.append("    ontologyID: ").append(toIndentedString(ontologyID)).append("\n");
    sb.append("    ontologyPrefix: ").append(toIndentedString(ontologyPrefix)).append("\n");
    sb.append("    ontologyTerm: ").append(toIndentedString(ontologyTerm)).append("\n");
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

