package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Call
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class Call   {
  @JsonProperty("call")
  private String call = null;

  @JsonProperty("datatypes")
  @Valid
  private List<String> datatypes = new ArrayList<String>();

  @JsonProperty("methods")
  @Valid
  private List<String> methods = new ArrayList<String>();

  /**
   * Gets or Sets versions
   */
  public enum VersionsEnum {
    _0("1.0"),
    
    _1("1.1"),
    
    _2("1.2"),
    
    _3("1.3");

    private String value;

    VersionsEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static VersionsEnum fromValue(String text) {
      for (VersionsEnum b : VersionsEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("versions")
  @Valid
  private List<VersionsEnum> versions = null;

  public Call call(String call) {
    this.call = call;
    return this;
  }

   /**
   * The name of the available call as recorded in the documentation
   * @return call
  **/
  @ApiModelProperty(required = true, value = "The name of the available call as recorded in the documentation")
  @NotNull


  public String getCall() {
    return call;
  }

  public void setCall(String call) {
    this.call = call;
  }

  public Call datatypes(List<String> datatypes) {
    this.datatypes = datatypes;
    return this;
  }

  public Call addDatatypesItem(String datatypesItem) {
    this.datatypes.add(datatypesItem);
    return this;
  }

   /**
   * The possible data formats returned by the available call
   * @return datatypes
  **/
  @ApiModelProperty(required = true, value = "The possible data formats returned by the available call")
  @NotNull


  public List<String> getDatatypes() {
    return datatypes;
  }

  public void setDatatypes(List<String> datatypes) {
    this.datatypes = datatypes;
  }

  public Call methods(List<String> methods) {
    this.methods = methods;
    return this;
  }

  public Call addMethodsItem(String methodsItem) {
    this.methods.add(methodsItem);
    return this;
  }

   /**
   * The possible HTTP Methods to be used with the available call
   * @return methods
  **/
  @ApiModelProperty(required = true, value = "The possible HTTP Methods to be used with the available call")
  @NotNull


  public List<String> getMethods() {
    return methods;
  }

  public void setMethods(List<String> methods) {
    this.methods = methods;
  }

  public Call versions(List<VersionsEnum> versions) {
    this.versions = versions;
    return this;
  }

  public Call addVersionsItem(VersionsEnum versionsItem) {
    if (this.versions == null) {
      this.versions = new ArrayList<VersionsEnum>();
    }
    this.versions.add(versionsItem);
    return this;
  }

   /**
   * The supported versions of a particular call
   * @return versions
  **/
  @ApiModelProperty(value = "The supported versions of a particular call")


  public List<VersionsEnum> getVersions() {
    return versions;
  }

  public void setVersions(List<VersionsEnum> versions) {
    this.versions = versions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Call call = (Call) o;
    return Objects.equals(this.call, call.call) &&
        Objects.equals(this.datatypes, call.datatypes) &&
        Objects.equals(this.methods, call.methods) &&
        Objects.equals(this.versions, call.versions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(call, datatypes, methods, versions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Call {\n");
    
    sb.append("    call: ").append(toIndentedString(call)).append("\n");
    sb.append("    datatypes: ").append(toIndentedString(datatypes)).append("\n");
    sb.append("    methods: ").append(toIndentedString(methods)).append("\n");
    sb.append("    versions: ").append(toIndentedString(versions)).append("\n");
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

