package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GermplasmAttributeDef
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class GermplasmAttributeDef   {
  @JsonProperty("attributeCategoryDbId")
  private String attributeCategoryDbId = null;

  @JsonProperty("attributeDbId")
  private String attributeDbId = null;

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
  @Valid
  private List<String> values = null;

  public GermplasmAttributeDef attributeCategoryDbId(String attributeCategoryDbId) {
    this.attributeCategoryDbId = attributeCategoryDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies this attribute category within the given database server
   * @return attributeCategoryDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies this attribute category within the given database server")


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
  @ApiModelProperty(value = "The ID which uniquely identifies this attribute within the given database server")


  public String getAttributeDbId() {
    return attributeDbId;
  }

  public void setAttributeDbId(String attributeDbId) {
    this.attributeDbId = attributeDbId;
  }

  public GermplasmAttributeDef code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Short abbreviation which represents this attribute
   * @return code
  **/
  @ApiModelProperty(value = "Short abbreviation which represents this attribute")


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
   * The type of data represented by this attribute
   * @return datatype
  **/
  @ApiModelProperty(value = "The type of data represented by this attribute")


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
   * A human readable name for this attribute
   * @return name
  **/
  @ApiModelProperty(value = "A human readable name for this attribute")


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
   * The URI reference some external documentation or ontology for this attribute
   * @return uri
  **/
  @ApiModelProperty(value = "The URI reference some external documentation or ontology for this attribute")


  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public GermplasmAttributeDef values(List<String> values) {
    this.values = values;
    return this;
  }

  public GermplasmAttributeDef addValuesItem(String valuesItem) {
    if (this.values == null) {
      this.values = new ArrayList<String>();
    }
    this.values.add(valuesItem);
    return this;
  }

   /**
   * List of acceptable values for this attribute
   * @return values
  **/
  @ApiModelProperty(value = "List of acceptable values for this attribute")


  public List<String> getValues() {
    return values;
  }

  public void setValues(List<String> values) {
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
        Objects.equals(this.code, germplasmAttributeDef.code) &&
        Objects.equals(this.datatype, germplasmAttributeDef.datatype) &&
        Objects.equals(this.description, germplasmAttributeDef.description) &&
        Objects.equals(this.name, germplasmAttributeDef.name) &&
        Objects.equals(this.uri, germplasmAttributeDef.uri) &&
        Objects.equals(this.values, germplasmAttributeDef.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeCategoryDbId, attributeDbId, code, datatype, description, name, uri, values);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmAttributeDef {\n");
    
    sb.append("    attributeCategoryDbId: ").append(toIndentedString(attributeCategoryDbId)).append("\n");
    sb.append("    attributeDbId: ").append(toIndentedString(attributeDbId)).append("\n");
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

