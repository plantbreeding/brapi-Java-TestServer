package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * A string representation of the reference base alleles.
 */
@ApiModel(description = "A string representation of the reference base alleles.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class ReferenceBases   {
  @JsonProperty("nextPageToken")
  private String nextPageToken = null;

  @JsonProperty("offset")
  private Integer offset = null;

  @JsonProperty("sequence")
  private String sequence = null;

  public ReferenceBases nextPageToken(String nextPageToken) {
    this.nextPageToken = nextPageToken;
    return this;
  }

  /**
   * The continuation token, which is used to page through large result sets. Provide this value in a subsequent request to return the next page of results. This field will be empty if there are not any additional results.
   * @return nextPageToken
  **/
  @ApiModelProperty(value = "The continuation token, which is used to page through large result sets. Provide this value in a subsequent request to return the next page of results. This field will be empty if there are not any additional results.")
  
    public String getNextPageToken() {
    return nextPageToken;
  }

  public void setNextPageToken(String nextPageToken) {
    this.nextPageToken = nextPageToken;
  }

  public ReferenceBases offset(Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * The offset position (0-based) of the given sequence from the start of this `Reference`. This value will differ for each page in a request.
   * @return offset
  **/
  @ApiModelProperty(value = "The offset position (0-based) of the given sequence from the start of this `Reference`. This value will differ for each page in a request.")
  
    public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public ReferenceBases sequence(String sequence) {
    this.sequence = sequence;
    return this;
  }

  /**
   * A sub-string of the bases that make up this reference. Bases are represented as IUPAC-IUB codes; this string matches the regular expression `[ACGTMRWSYKVHDBN]*`.
   * @return sequence
  **/
  @ApiModelProperty(value = "A sub-string of the bases that make up this reference. Bases are represented as IUPAC-IUB codes; this string matches the regular expression `[ACGTMRWSYKVHDBN]*`.")
  
    public String getSequence() {
    return sequence;
  }

  public void setSequence(String sequence) {
    this.sequence = sequence;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReferenceBases referenceBases = (ReferenceBases) o;
    return Objects.equals(this.nextPageToken, referenceBases.nextPageToken) &&
        Objects.equals(this.offset, referenceBases.offset) &&
        Objects.equals(this.sequence, referenceBases.sequence);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nextPageToken, offset, sequence);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReferenceBases {\n");
    
    sb.append("    nextPageToken: ").append(toIndentedString(nextPageToken)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    sequence: ").append(toIndentedString(sequence)).append("\n");
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
