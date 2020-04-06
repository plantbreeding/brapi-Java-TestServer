package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * ExternalReferencesInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class ExternalReferencesInner   {
  @JsonProperty("referenceID")
  private String referenceID = null;

  @JsonProperty("referenceSource")
  private String referenceSource = null;

  public ExternalReferencesInner referenceID(String referenceID) {
    this.referenceID = referenceID;
    return this;
  }

  /**
   * The external reference ID. Could be a simple string or a URI.
   * @return referenceID
  **/
  @ApiModelProperty(value = "The external reference ID. Could be a simple string or a URI.")
  
    public String getReferenceID() {
    return referenceID;
  }

  public void setReferenceID(String referenceID) {
    this.referenceID = referenceID;
  }

  public ExternalReferencesInner referenceSource(String referenceSource) {
    this.referenceSource = referenceSource;
    return this;
  }

  /**
   * An identifier for the source system or database of this reference
   * @return referenceSource
  **/
  @ApiModelProperty(value = "An identifier for the source system or database of this reference")
  
    public String getReferenceSource() {
    return referenceSource;
  }

  public void setReferenceSource(String referenceSource) {
    this.referenceSource = referenceSource;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExternalReferencesInner externalReferencesInner = (ExternalReferencesInner) o;
    return Objects.equals(this.referenceID, externalReferencesInner.referenceID) &&
        Objects.equals(this.referenceSource, externalReferencesInner.referenceSource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referenceID, referenceSource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExternalReferencesInner {\n");
    
    sb.append("    referenceID: ").append(toIndentedString(referenceID)).append("\n");
    sb.append("    referenceSource: ").append(toIndentedString(referenceSource)).append("\n");
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
