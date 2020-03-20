package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.common.SearchRequestParametersPaging;
import org.springframework.validation.annotation.Validated;

/**
 * ReferencesSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class ReferencesSearchRequest extends SearchRequestParametersPaging  {
  @JsonProperty("accession")
  private String accession = null;

  @JsonProperty("md5checksum")
  private String md5checksum = null;

  @JsonProperty("referenceSetDbId")
  private String referenceSetDbId = null;

  public ReferencesSearchRequest accession(String accession) {
    this.accession = accession;
    return this;
  }

  /**
   * If specified, return the references for which the `accession` matches this string (case-sensitive, exact match).
   * @return accession
  **/
  @ApiModelProperty(example = "A0009283", value = "If specified, return the references for which the `accession` matches this string (case-sensitive, exact match).")
  
    public String getAccession() {
    return accession;
  }

  public void setAccession(String accession) {
    this.accession = accession;
  }

  public ReferencesSearchRequest md5checksum(String md5checksum) {
    this.md5checksum = md5checksum;
    return this;
  }

  /**
   * If specified, return the references for which the `md5checksum` matches this string (case-sensitive, exact match).
   * @return md5checksum
  **/
  @ApiModelProperty(example = "c2365e900c81a89cf74d83dab60df146", value = "If specified, return the references for which the `md5checksum` matches this string (case-sensitive, exact match).")
  
    public String getMd5checksum() {
    return md5checksum;
  }

  public void setMd5checksum(String md5checksum) {
    this.md5checksum = md5checksum;
  }

  public ReferencesSearchRequest referenceSetDbId(String referenceSetDbId) {
    this.referenceSetDbId = referenceSetDbId;
    return this;
  }

  /**
   * The `ReferenceSet` to search.
   * @return referenceSetDbId
  **/
  @ApiModelProperty(example = "04c83ea7", value = "The `ReferenceSet` to search.")
  
    public String getReferenceSetDbId() {
    return referenceSetDbId;
  }

  public void setReferenceSetDbId(String referenceSetDbId) {
    this.referenceSetDbId = referenceSetDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReferencesSearchRequest referencesSearchRequest = (ReferencesSearchRequest) o;
    return Objects.equals(this.accession, referencesSearchRequest.accession) &&
        Objects.equals(this.md5checksum, referencesSearchRequest.md5checksum) &&
        Objects.equals(this.referenceSetDbId, referencesSearchRequest.referenceSetDbId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accession, md5checksum, referenceSetDbId, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReferencesSearchRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    accession: ").append(toIndentedString(accession)).append("\n");
    sb.append("    md5checksum: ").append(toIndentedString(md5checksum)).append("\n");
    sb.append("    referenceSetDbId: ").append(toIndentedString(referenceSetDbId)).append("\n");
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
