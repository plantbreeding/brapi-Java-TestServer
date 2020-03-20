package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * VendorSpecificationServiceSpecificRequirements
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class VendorSpecificationServiceSpecificRequirements   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("key")
  private String key = null;

  public VendorSpecificationServiceSpecificRequirements description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public VendorSpecificationServiceSpecificRequirements key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Get key
   * @return key
  **/
  @ApiModelProperty(value = "")
  
    public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorSpecificationServiceSpecificRequirements vendorSpecificationServiceSpecificRequirements = (VendorSpecificationServiceSpecificRequirements) o;
    return Objects.equals(this.description, vendorSpecificationServiceSpecificRequirements.description) &&
        Objects.equals(this.key, vendorSpecificationServiceSpecificRequirements.key);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, key);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorSpecificationServiceSpecificRequirements {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
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
