package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SearchRequestParametersPaging;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ReferenceSetsSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-24T19:42:22.574Z[GMT]")
public class ReferenceSetsSearchRequest extends SearchRequestParametersPaging  {
  @JsonProperty("accession")
  @Valid
  private List<String> accession = null;

  @JsonProperty("assemblyPUI")
  @Valid
  private List<String> assemblyPUI = null;

  @JsonProperty("md5checksum")
  @Valid
  private List<String> md5checksum = null;

  @JsonProperty("referenceSetDbIds")
  @Valid
  private List<String> referenceSetDbIds = null;

  public ReferenceSetsSearchRequest accession(List<String> accession) {
    this.accession = accession;
    return this;
  }

  public ReferenceSetsSearchRequest addAccessionItem(String accessionItem) {
    if (this.accession == null) {
      this.accession = new ArrayList<String>();
    }
    this.accession.add(accessionItem);
    return this;
  }

  /**
   * If set, return the reference sets for which the `accession` matches this string (case-sensitive, exact match).
   * @return accession
  **/
  @ApiModelProperty(example = "[\"A0009283\",\"A0006657\"]", value = "If set, return the reference sets for which the `accession` matches this string (case-sensitive, exact match).")
  
    public List<String> getAccession() {
    return accession;
  }

  public void setAccession(List<String> accession) {
    this.accession = accession;
  }

  public ReferenceSetsSearchRequest assemblyPUI(List<String> assemblyPUI) {
    this.assemblyPUI = assemblyPUI;
    return this;
  }

  public ReferenceSetsSearchRequest addAssemblyPUIItem(String assemblyPUIItem) {
    if (this.assemblyPUI == null) {
      this.assemblyPUI = new ArrayList<String>();
    }
    this.assemblyPUI.add(assemblyPUIItem);
    return this;
  }

  /**
   * If set, return the reference sets for which the `assemblyId` matches this string (case-sensitive, exact match).
   * @return assemblyPUI
  **/
  @ApiModelProperty(example = "[\"doi:10.15454/312953986E3\",\"doi:10.15454/312953986E3\"]", value = "If set, return the reference sets for which the `assemblyId` matches this string (case-sensitive, exact match).")
  
    public List<String> getAssemblyPUI() {
    return assemblyPUI;
  }

  public void setAssemblyPUI(List<String> assemblyPUI) {
    this.assemblyPUI = assemblyPUI;
  }

  public ReferenceSetsSearchRequest md5checksum(List<String> md5checksum) {
    this.md5checksum = md5checksum;
    return this;
  }

  public ReferenceSetsSearchRequest addMd5checksumItem(String md5checksumItem) {
    if (this.md5checksum == null) {
      this.md5checksum = new ArrayList<String>();
    }
    this.md5checksum.add(md5checksumItem);
    return this;
  }

  /**
   * If set, return the reference sets for which the `md5checksum` matches this string (case-sensitive, exact match).
   * @return md5checksum
  **/
  @ApiModelProperty(example = "[\"c2365e900c81a89cf74d83dab60df146\"]", value = "If set, return the reference sets for which the `md5checksum` matches this string (case-sensitive, exact match).")
  
    public List<String> getMd5checksum() {
    return md5checksum;
  }

  public void setMd5checksum(List<String> md5checksum) {
    this.md5checksum = md5checksum;
  }

  public ReferenceSetsSearchRequest referenceSetDbIds(List<String> referenceSetDbIds) {
    this.referenceSetDbIds = referenceSetDbIds;
    return this;
  }

  public ReferenceSetsSearchRequest addReferenceSetDbIdsItem(String referenceSetDbIdsItem) {
    if (this.referenceSetDbIds == null) {
      this.referenceSetDbIds = new ArrayList<String>();
    }
    this.referenceSetDbIds.add(referenceSetDbIdsItem);
    return this;
  }

  /**
   * The `ReferenceSets` to search.
   * @return referenceSetDbIds
  **/
  @ApiModelProperty(example = "[\"32a19dd7\",\"2c182c18\"]", value = "The `ReferenceSets` to search.")
  
    public List<String> getReferenceSetDbIds() {
    return referenceSetDbIds;
  }

  public void setReferenceSetDbIds(List<String> referenceSetDbIds) {
    this.referenceSetDbIds = referenceSetDbIds;
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
        Objects.equals(this.referenceSetDbIds, referenceSetsSearchRequest.referenceSetDbIds) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accession, assemblyPUI, md5checksum, referenceSetDbIds, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReferenceSetsSearchRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    accession: ").append(toIndentedString(accession)).append("\n");
    sb.append("    assemblyPUI: ").append(toIndentedString(assemblyPUI)).append("\n");
    sb.append("    md5checksum: ").append(toIndentedString(md5checksum)).append("\n");
    sb.append("    referenceSetDbIds: ").append(toIndentedString(referenceSetDbIds)).append("\n");
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
