package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * AsynchStatusMetadata
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class AsynchStatusMetadata   {
  @JsonProperty("asynchStatus")
  private Object asynchStatus = null;

  public AsynchStatusMetadata asynchStatus(Object asynchStatus) {
    this.asynchStatus = asynchStatus;
    return this;
  }

  /**
   * Get asynchStatus
   * @return asynchStatus
  **/
  @ApiModelProperty(value = "")


  public Object getAsynchStatus() {
    return asynchStatus;
  }

  public void setAsynchStatus(Object asynchStatus) {
    this.asynchStatus = asynchStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AsynchStatusMetadata asynchStatusMetadata = (AsynchStatusMetadata) o;
    return Objects.equals(this.asynchStatus, asynchStatusMetadata.asynchStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(asynchStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AsynchStatusMetadata {\n");
    
    sb.append("    asynchStatus: ").append(toIndentedString(asynchStatus)).append("\n");
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

