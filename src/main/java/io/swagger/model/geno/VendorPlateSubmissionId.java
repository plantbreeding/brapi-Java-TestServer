package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;


/**
 * Response to an order request
 */
@ApiModel(description = "Response to an order request")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class VendorPlateSubmissionId   {
  @JsonProperty("submissionId")
  private String submissionId = null;

  public VendorPlateSubmissionId submissionId(String submissionId) {
    this.submissionId = submissionId;
    return this;
  }

  /**
   * A unique, alpha-numeric ID which identifies a set of plates which have been successfully submitted.
   * @return submissionId
  **/
  @ApiModelProperty(example = "f8f409e0", required = true, value = "A unique, alpha-numeric ID which identifies a set of plates which have been successfully submitted.")
      

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
    VendorPlateSubmissionId vendorPlateSubmissionId = (VendorPlateSubmissionId) o;
    return Objects.equals(this.submissionId, vendorPlateSubmissionId.submissionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(submissionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorPlateSubmissionId {\n");
    
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
