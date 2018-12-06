package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Response to an order request
 */
@ApiModel(description = "Response to an order request")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class VendorPlatesSubmissionResponse   {
  @JsonProperty("submissionId")
  private String submissionId = null;

  public VendorPlatesSubmissionResponse submissionId(String submissionId) {
    this.submissionId = submissionId;
    return this;
  }

  /**
   * A unique, alpha-numeric ID which identifies a set of plates which have been successfully submitted.
   * @return submissionId
  **/
  @ApiModelProperty(value = "A unique, alpha-numeric ID which identifies a set of plates which have been successfully submitted.")


  public String getSubmissionId() {
    return submissionId;
  }

  public void setSubmissionId(String submissionId) {
    this.submissionId = submissionId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorPlatesSubmissionResponse vendorPlatesSubmissionResponse = (VendorPlatesSubmissionResponse) o;
    return Objects.equals(this.submissionId, vendorPlatesSubmissionResponse.submissionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(submissionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorPlatesSubmissionResponse {\n");
    
    sb.append("    submissionId: ").append(toIndentedString(submissionId)).append("\n");
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

