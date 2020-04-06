package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SearchRequestParametersPaging;

import org.springframework.validation.annotation.Validated;

/**
 * ReferenceSetsSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class ReferenceSetsSearchRequest extends SearchRequestParametersPaging  {
  @JsonProperty("accession")
  private String accession = null;

  @JsonProperty("assemblyPUI")
  private String assemblyPUI = null;

  @JsonProperty("md5checksum")
  private String md5checksum = null;

  public ReferenceSetsSearchRequest accession(String accession) {
    this.accession = accession;
    return this;
  }

  /**
   * If set, return the reference sets for which the `accession` matches this string (case-sensitive, exact match).
   * @return accession
  **/
  @ApiModelProperty(example = "A0009283", value = "If set, return the reference sets for which the `accession` matches this string (case-sensitive, exact match).")
  
    public String getAccession() {
    return accession;
  }

  public void setAccession(String accession) {
    this.accession = accession;
  }

  public ReferenceSetsSearchRequest assemblyPUI(String assemblyPUI) {
    this.assemblyPUI = assemblyPUI;
    return this;
  }

  /**
   * If set, return the reference sets for which the `assemblyId` matches this string (case-sensitive, exact match).
   * @return assemblyPUI
  **/
  @ApiModelProperty(example = "doi:10.15454/312953986E3", value = "If set, return the reference sets for which the `assemblyId` matches this string (case-sensitive, exact match).")
  
    public String getAssemblyPUI() {
    return assemblyPUI;
  }

  public void setAssemblyPUI(String assemblyPUI) {
    this.assemblyPUI = assemblyPUI;
  }

  public ReferenceSetsSearchRequest md5checksum(String md5checksum) {
    this.md5checksum = md5checksum;
    return this;
  }

  /**
   * If set, return the reference sets for which the `md5checksum` matches this string (case-sensitive, exact match).
   * @return md5checksum
  **/
  @ApiModelProperty(example = "c2365e900c81a89cf74d83dab60df146", value = "If set, return the reference sets for which the `md5checksum` matches this string (case-sensitive, exact match).")
  
    public String getMd5checksum() {
    return md5checksum;
  }

  public void setMd5checksum(String md5checksum) {
    this.md5checksum = md5checksum;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReferenceSetsSearchRequest referenceSetsSearchRequest = (ReferenceSetsSearchRequest) o;
    return Objects.equals(this.accession, referenceSetsSearchRequest.accession) &&
        Objects.equals(this.assemblyPUI, referenceSetsSearchRequest.assemblyPUI) &&
        Objects.equals(this.md5checksum, referenceSetsSearchRequest.md5checksum) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accession, assemblyPUI, md5checksum, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReferenceSetsSearchRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    accession: ").append(toIndentedString(accession)).append("\n");
    sb.append("    assemblyPUI: ").append(toIndentedString(assemblyPUI)).append("\n");
    sb.append("    md5checksum: ").append(toIndentedString(md5checksum)).append("\n");
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
