package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Method;
import io.swagger.model.OntologyRefernce;
import io.swagger.model.Scale;
import io.swagger.model.Trait;
import io.swagger.model.VariableBaseClass;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GermplasmAttributeDef
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class GermplasmAttributeDef extends VariableBaseClass  {
  @JsonProperty("attributeCategoryDbId")
  private String attributeCategoryDbId = null;

  @JsonProperty("attributeDbId")
  private String attributeDbId = null;

  @JsonProperty("attributeName")
  private String attributeName = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("datatype")
  private String datatype = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("uri")
  private String uri = null;

  @JsonProperty("values")
  private String values = null;

  public GermplasmAttributeDef attributeCategoryDbId(String attributeCategoryDbId) {
    this.attributeCategoryDbId = attributeCategoryDbId;
    return this;
  }

  /**
   * General category for the attribute. very similar to Trait class.
   * @return attributeCategoryDbId
  **/
  @ApiModelProperty(value = "General category for the attribute. very similar to Trait class.")


  public String getAttributeCategoryDbId() {
    return attributeCategoryDbId;
  }

  public void setAttributeCategoryDbId(String attributeCategoryDbId) {
    this.attributeCategoryDbId = attributeCategoryDbId;
  }

  public GermplasmAttributeDef attributeDbId(String attributeDbId) {
    this.attributeDbId = attributeDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies this attribute within the given database server
   * @return attributeDbId
  **/
  @ApiModelProperty(required = true, value = "The ID which uniquely identifies this attribute within the given database server")
  @NotNull


  public String getAttributeDbId() {
    return attributeDbId;
  }

  public void setAttributeDbId(String attributeDbId) {
    this.attributeDbId = attributeDbId;
  }

  public GermplasmAttributeDef attributeName(String attributeName) {
    this.attributeName = attributeName;
    return this;
  }

  /**
   * A human readable name for this attribute
   * @return attributeName
  **/
  @ApiModelProperty(required = true, value = "A human readable name for this attribute")
  @NotNull


  public String getAttributeName() {
    return attributeName;
  }

  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }

  public GermplasmAttributeDef code(String code) {
    this.code = code;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - see \"this.trait.alternativeAbbreviations\"
   * @return code
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - see \"this.trait.alternativeAbbreviations\"")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public GermplasmAttributeDef datatype(String datatype) {
    this.datatype = datatype;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - see \"this.scale.dataType\"
   * @return datatype
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - see \"this.scale.dataType\"")


  public String getDatatype() {
    return datatype;
  }

  public void setDatatype(String datatype) {
    this.datatype = datatype;
  }

  public GermplasmAttributeDef description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A human readable description of this attribute
   * @return description
  **/
  @ApiModelProperty(value = "A human readable description of this attribute")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GermplasmAttributeDef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - Use \"this.attributeName\"
   * @return name
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - Use \"this.attributeName\"")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GermplasmAttributeDef uri(String uri) {
    this.uri = uri;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - see \"this.xref\"
   * @return uri
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - see \"this.xref\"")


  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public GermplasmAttributeDef values(String values) {
    this.values = values;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - see \"this.scale.validValues\"
   * @return values
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - see \"this.scale.validValues\"")


  public String getValues() {
    return values;
  }

  public void setValues(String values) {
    this.values = values;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GermplasmAttributeDef germplasmAttributeDef = (GermplasmAttributeDef) o;
    return Objects.equals(this.attributeCategoryDbId, germplasmAttributeDef.attributeCategoryDbId) &&
        Objects.equals(this.attributeDbId, germplasmAttributeDef.attributeDbId) &&
        Objects.equals(this.attributeName, germplasmAttributeDef.attributeName) &&
        Objects.equals(this.code, germplasmAttributeDef.code) &&
        Objects.equals(this.datatype, germplasmAttributeDef.datatype) &&
        Objects.equals(this.description, germplasmAttributeDef.description) &&
        Objects.equals(this.name, germplasmAttributeDef.name) &&
        Objects.equals(this.uri, germplasmAttributeDef.uri) &&
        Objects.equals(this.values, germplasmAttributeDef.values) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeCategoryDbId, attributeDbId, attributeName, code, datatype, description, name, uri, values, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmAttributeDef {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    attributeCategoryDbId: ").append(toIndentedString(attributeCategoryDbId)).append("\n");
    sb.append("    attributeDbId: ").append(toIndentedString(attributeDbId)).append("\n");
    sb.append("    attributeName: ").append(toIndentedString(attributeName)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    datatype: ").append(toIndentedString(datatype)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
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

