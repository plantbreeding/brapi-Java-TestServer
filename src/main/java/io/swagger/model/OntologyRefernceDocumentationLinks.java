package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OntologyRefernceDocumentationLinks
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class OntologyRefernceDocumentationLinks   {
  @JsonProperty("URL")
  private String URL = null;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    OBO("OBO"),
    
    RDF("RDF"),
    
    WEBPAGE("WEBPAGE");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("type")
  private TypeEnum type = null;

  public OntologyRefernceDocumentationLinks URL(String URL) {
    this.URL = URL;
    return this;
  }

  /**
   * Get URL
   * @return URL
  **/
  @ApiModelProperty(value = "")


  public String getURL() {
    return URL;
  }

  public void setURL(String URL) {
    this.URL = URL;
  }

  public OntologyRefernceDocumentationLinks type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OntologyRefernceDocumentationLinks ontologyRefernceDocumentationLinks = (OntologyRefernceDocumentationLinks) o;
    return Objects.equals(this.URL, ontologyRefernceDocumentationLinks.URL) &&
        Objects.equals(this.type, ontologyRefernceDocumentationLinks.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(URL, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OntologyRefernceDocumentationLinks {\n");
    
    sb.append("    URL: ").append(toIndentedString(URL)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

