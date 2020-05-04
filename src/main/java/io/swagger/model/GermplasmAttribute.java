package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * GermplasmAttribute
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class GermplasmAttribute   {
  @JsonProperty("attributeCode")
  private String attributeCode = null;

  @JsonProperty("attributeDbId")
  private String attributeDbId = null;

  @JsonProperty("attributeName")
  private String attributeName = null;

  @JsonProperty("determinedDate")
  private LocalDate determinedDate = null;

  @JsonProperty("value")
  private String value = null;

  public GermplasmAttribute attributeCode(String attributeCode) {
    this.attributeCode = attributeCode;
    return this;
  }

  /**
   * Short abbreviation which represents this attribute
   * @return attributeCode
  **/
  @ApiModelProperty(value = "Short abbreviation which represents this attribute")


  public String getAttributeCode() {
    return attributeCode;
  }

  public void setAttributeCode(String attributeCode) {
    this.attributeCode = attributeCode;
  }

  public GermplasmAttribute attributeDbId(String attributeDbId) {
    this.attributeDbId = attributeDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies this attribute within the given database server
   * @return attributeDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies this attribute within the given database server")


  public String getAttributeDbId() {
    return attributeDbId;
  }

  public void setAttributeDbId(String attributeDbId) {
    this.attributeDbId = attributeDbId;
  }

  public GermplasmAttribute attributeName(String attributeName) {
    this.attributeName = attributeName;
    return this;
  }

  /**
   * The human readable name of this attribute
   * @return attributeName
  **/
  @ApiModelProperty(value = "The human readable name of this attribute")


  public String getAttributeName() {
    return attributeName;
  }

  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }

  public GermplasmAttribute determinedDate(LocalDate determinedDate) {
    this.determinedDate = determinedDate;
    return this;
  }

  /**
   * The date the value of this attribute was determined for a given germplasm
   * @return determinedDate
  **/
  @ApiModelProperty(value = "The date the value of this attribute was determined for a given germplasm")

  @Valid

  public LocalDate getDeterminedDate() {
    return determinedDate;
  }

  public void setDeterminedDate(LocalDate determinedDate) {
    this.determinedDate = determinedDate;
  }

  public GermplasmAttribute value(String value) {
    this.value = value;
    return this;
  }

  /**
   * The value of this attribute for a given germplasm
   * @return value
  **/
  @ApiModelProperty(value = "The value of this attribute for a given germplasm")


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GermplasmAttribute germplasmAttribute = (GermplasmAttribute) o;
    return Objects.equals(this.attributeCode, germplasmAttribute.attributeCode) &&
        Objects.equals(this.attributeDbId, germplasmAttribute.attributeDbId) &&
        Objects.equals(this.attributeName, germplasmAttribute.attributeName) &&
        Objects.equals(this.determinedDate, germplasmAttribute.determinedDate) &&
        Objects.equals(this.value, germplasmAttribute.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeCode, attributeDbId, attributeName, determinedDate, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmAttribute {\n");
    
    sb.append("    attributeCode: ").append(toIndentedString(attributeCode)).append("\n");
    sb.append("    attributeDbId: ").append(toIndentedString(attributeDbId)).append("\n");
    sb.append("    attributeName: ").append(toIndentedString(attributeName)).append("\n");
    sb.append("    determinedDate: ").append(toIndentedString(determinedDate)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

