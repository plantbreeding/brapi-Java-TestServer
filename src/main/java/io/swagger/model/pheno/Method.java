package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.annotation.Validated;

/**
 * Method
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class Method extends MethodBaseClass  {
  @JsonProperty("methodDbId")
  private String methodDbId = null;

  public Method methodDbId(String methodDbId) {
    this.methodDbId = methodDbId;
    return this;
  }

  /**
   * Method unique identifier
   * @return methodDbId
  **/
  @ApiModelProperty(example = "0adb2764", value = "Method unique identifier")
  
    public String getMethodDbId() {
    return methodDbId;
  }

  public void setMethodDbId(String methodDbId) {
    this.methodDbId = methodDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Method method = (Method) o;
    return Objects.equals(this.methodDbId, method.methodDbId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(methodDbId, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Method {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    methodDbId: ").append(toIndentedString(methodDbId)).append("\n");
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
