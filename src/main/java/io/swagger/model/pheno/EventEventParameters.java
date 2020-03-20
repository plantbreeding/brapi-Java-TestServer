package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * EventEventParameters
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class EventEventParameters   {
  @JsonProperty("key")
  private String key = null;

  @JsonProperty("rdfValue")
  private String rdfValue = null;

  @JsonProperty("value")
  private String value = null;

  public EventEventParameters key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Specifies the relationship between the event and the given property. E.g. fertilizer, operator
   * @return key
  **/
  @ApiModelProperty(example = "operator", value = "Specifies the relationship between the event and the given property. E.g. fertilizer, operator")
  
    public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public EventEventParameters rdfValue(String rdfValue) {
    this.rdfValue = rdfValue;
    return this;
  }

  /**
   * The type of the value given above, e.g. http://xmlns.com/foaf/0.1/Agent
   * @return rdfValue
  **/
  @ApiModelProperty(example = "http://xmlns.com/foaf/0.1/Agent", value = "The type of the value given above, e.g. http://xmlns.com/foaf/0.1/Agent")
  
    public String getRdfValue() {
    return rdfValue;
  }

  public void setRdfValue(String rdfValue) {
    this.rdfValue = rdfValue;
  }

  public EventEventParameters value(String value) {
    this.value = value;
    return this;
  }

  /**
   * The value of the property for this event. E.g. nitrogen, John Doe
   * @return value
  **/
  @ApiModelProperty(example = "Bob Robertson", value = "The value of the property for this event. E.g. nitrogen, John Doe")
  
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
    EventEventParameters eventEventParameters = (EventEventParameters) o;
    return Objects.equals(this.key, eventEventParameters.key) &&
        Objects.equals(this.rdfValue, eventEventParameters.rdfValue) &&
        Objects.equals(this.value, eventEventParameters.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, rdfValue, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventEventParameters {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    rdfValue: ").append(toIndentedString(rdfValue)).append("\n");
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
