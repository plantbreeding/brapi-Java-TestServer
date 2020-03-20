package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * An ontology term describing an attribute.
 */
@ApiModel(description = "An ontology term describing an attribute.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class OntologyTerm   {
  @JsonProperty("term")
  private String term = null;

  @JsonProperty("termURI")
  private String termURI = null;

  public OntologyTerm term(String term) {
    this.term = term;
    return this;
  }

  /**
   * Ontology term - the label of the ontology term the termId is pointing to.
   * @return term
  **/
  @ApiModelProperty(value = "Ontology term - the label of the ontology term the termId is pointing to.")
  
    public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }

  public OntologyTerm termURI(String termURI) {
    this.termURI = termURI;
    return this;
  }

  /**
   * Ontology term identifier - the CURIE for an ontology term. It differs from the standard GA4GH schema's :ref:`id ` in that it is a CURIE pointing to an information resource outside of the scope of the schema or its resource implementation.
   * @return termURI
  **/
  @ApiModelProperty(value = "Ontology term identifier - the CURIE for an ontology term. It differs from the standard GA4GH schema's :ref:`id ` in that it is a CURIE pointing to an information resource outside of the scope of the schema or its resource implementation.")
  
    public String getTermURI() {
    return termURI;
  }

  public void setTermURI(String termURI) {
    this.termURI = termURI;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OntologyTerm ontologyTerm = (OntologyTerm) o;
    return Objects.equals(this.term, ontologyTerm.term) &&
        Objects.equals(this.termURI, ontologyTerm.termURI);
  }

  @Override
  public int hashCode() {
    return Objects.hash(term, termURI);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OntologyTerm {\n");
    
    sb.append("    term: ").append(toIndentedString(term)).append("\n");
    sb.append("    termURI: ").append(toIndentedString(termURI)).append("\n");
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
