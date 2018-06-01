package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * DataLink
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class DataLink   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("url")
  private String url = null;

  public DataLink name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the external data link
   * @return name
  **/
  @ApiModelProperty(value = "The name of the external data link")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DataLink type(String type) {
    this.type = type;
    return this;
  }

   /**
   * The type of external data link
   * @return type
  **/
  @ApiModelProperty(value = "The type of external data link")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public DataLink url(String url) {
    this.url = url;
    return this;
  }

   /**
   * The URL which links to external data
   * @return url
  **/
  @ApiModelProperty(value = "The URL which links to external data")


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataLink dataLink = (DataLink) o;
    return Objects.equals(this.name, dataLink.name) &&
        Objects.equals(this.type, dataLink.type) &&
        Objects.equals(this.url, dataLink.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataLink {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

