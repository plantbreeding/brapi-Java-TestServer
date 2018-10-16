package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * VendorSpecificationReferenceSystem
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class VendorSpecificationReferenceSystem   {
  @JsonProperty("URI")
  private String URI = null;

  @JsonProperty("name")
  private String name = null;

  public VendorSpecificationReferenceSystem URI(String URI) {
    this.URI = URI;
    return this;
  }

   /**
   * The primary URI for this reference system
   * @return URI
  **/
  @ApiModelProperty(value = "The primary URI for this reference system")


  public String getURI() {
    return URI;
  }

  public void setURI(String URI) {
    this.URI = URI;
  }

  public VendorSpecificationReferenceSystem name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The human readable name for this reference system
   * @return name
  **/
  @ApiModelProperty(value = "The human readable name for this reference system")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorSpecificationReferenceSystem vendorSpecificationReferenceSystem = (VendorSpecificationReferenceSystem) o;
    return Objects.equals(this.URI, vendorSpecificationReferenceSystem.URI) &&
        Objects.equals(this.name, vendorSpecificationReferenceSystem.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(URI, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorSpecificationReferenceSystem {\n");
    
    sb.append("    URI: ").append(toIndentedString(URI)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

