package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.germ.GermplasmAttributeValueNewRequest;
import org.springframework.validation.annotation.Validated;


/**
 * GermplasmAttributeValue
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class GermplasmAttributeValue extends GermplasmAttributeValueNewRequest  {
  @JsonProperty("attributeValueDbId")
  private String attributeValueDbId = null;

  public GermplasmAttributeValue attributeValueDbId(String attributeValueDbId) {
    this.attributeValueDbId = attributeValueDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies this attribute value within the given database server
   * @return attributeValueDbId
  **/
  @ApiModelProperty(example = "33edbab7", required = true, value = "The ID which uniquely identifies this attribute value within the given database server")
      

    public String getAttributeValueDbId() {
    return attributeValueDbId;
  }

  public void setAttributeValueDbId(String attributeValueDbId) {
    this.attributeValueDbId = attributeValueDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GermplasmAttributeValue germplasmAttributeValue = (GermplasmAttributeValue) o;
    return Objects.equals(this.attributeValueDbId, germplasmAttributeValue.attributeValueDbId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeValueDbId, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmAttributeValue {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    attributeValueDbId: ").append(toIndentedString(attributeValueDbId)).append("\n");
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
