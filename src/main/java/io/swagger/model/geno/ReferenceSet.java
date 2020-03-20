package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * A &#x60;ReferenceSet&#x60; is a set of &#x60;Reference&#x60; s which typically comprise a reference assembly, such as &#x60;GRCH_38&#x60;. A &#x60;ReferenceSet&#x60; defines a common coordinate space for comparing reference-aligned experimental data.
 */
@ApiModel(description = "A `ReferenceSet` is a set of `Reference` s which typically comprise a reference assembly, such as `GRCH_38`. A `ReferenceSet` defines a common coordinate space for comparing reference-aligned experimental data.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class ReferenceSet   {
  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("assemblyPUI")
  private String assemblyPUI = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isDerived")
  private Boolean isDerived = null;

  @JsonProperty("md5checksum")
  private String md5checksum = null;

  @JsonProperty("referenceSetDbId")
  private String referenceSetDbId = null;

  @JsonProperty("referenceSetName")
  private String referenceSetName = null;

  @JsonProperty("sourceAccessions")
  @Valid
  private List<String> sourceAccessions = null;

  @JsonProperty("sourceURI")
  private String sourceURI = null;

  @JsonProperty("species")
  private OntologyTerm species = null;

  public ReferenceSet additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public ReferenceSet putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = new HashMap<String, String>();
    }
    this.additionalInfo.put(key, additionalInfoItem);
    return this;
  }

  /**
   * Additional arbitrary info
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Additional arbitrary info")
  
    public Map<String, String> getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public ReferenceSet assemblyPUI(String assemblyPUI) {
    this.assemblyPUI = assemblyPUI;
    return this;
  }

  /**
   * The remaining information is about the source of the sequences Public id of this reference set, such as `GRCH_37`.
   * @return assemblyPUI
  **/
  @ApiModelProperty(value = "The remaining information is about the source of the sequences Public id of this reference set, such as `GRCH_37`.")
  
    public String getAssemblyPUI() {
    return assemblyPUI;
  }

  public void setAssemblyPUI(String assemblyPUI) {
    this.assemblyPUI = assemblyPUI;
  }

  public ReferenceSet description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Optional free text description of this reference set.
   * @return description
  **/
  @ApiModelProperty(value = "Optional free text description of this reference set.")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ReferenceSet isDerived(Boolean isDerived) {
    this.isDerived = isDerived;
    return this;
  }

  /**
   * A reference set may be derived from a source if it contains additional sequences, or some of the sequences within it are derived (see the definition of `isDerived` in `Reference`).
   * @return isDerived
  **/
  @ApiModelProperty(value = "A reference set may be derived from a source if it contains additional sequences, or some of the sequences within it are derived (see the definition of `isDerived` in `Reference`).")
  
    public Boolean isIsDerived() {
    return isDerived;
  }

  public void setIsDerived(Boolean isDerived) {
    this.isDerived = isDerived;
  }

  public ReferenceSet md5checksum(String md5checksum) {
    this.md5checksum = md5checksum;
    return this;
  }

  /**
   * Order-independent MD5 checksum which identifies this `ReferenceSet`.  To compute this checksum, make a list of `Reference.md5checksum` for all `Reference` s in this set. Then sort that list, and take the MD5 hash of all the strings concatenated together. Express the hash as a lower-case hexadecimal string.
   * @return md5checksum
  **/
  @ApiModelProperty(value = "Order-independent MD5 checksum which identifies this `ReferenceSet`.  To compute this checksum, make a list of `Reference.md5checksum` for all `Reference` s in this set. Then sort that list, and take the MD5 hash of all the strings concatenated together. Express the hash as a lower-case hexadecimal string.")
  
    public String getMd5checksum() {
    return md5checksum;
  }

  public void setMd5checksum(String md5checksum) {
    this.md5checksum = md5checksum;
  }

  public ReferenceSet referenceSetDbId(String referenceSetDbId) {
    this.referenceSetDbId = referenceSetDbId;
    return this;
  }

  /**
   * The reference set ID. Unique in the repository.
   * @return referenceSetDbId
  **/
  @ApiModelProperty(value = "The reference set ID. Unique in the repository.")
  
    public String getReferenceSetDbId() {
    return referenceSetDbId;
  }

  public void setReferenceSetDbId(String referenceSetDbId) {
    this.referenceSetDbId = referenceSetDbId;
  }

  public ReferenceSet referenceSetName(String referenceSetName) {
    this.referenceSetName = referenceSetName;
    return this;
  }

  /**
   * The reference set name.
   * @return referenceSetName
  **/
  @ApiModelProperty(value = "The reference set name.")
  
    public String getReferenceSetName() {
    return referenceSetName;
  }

  public void setReferenceSetName(String referenceSetName) {
    this.referenceSetName = referenceSetName;
  }

  public ReferenceSet sourceAccessions(List<String> sourceAccessions) {
    this.sourceAccessions = sourceAccessions;
    return this;
  }

  public ReferenceSet addSourceAccessionsItem(String sourceAccessionsItem) {
    if (this.sourceAccessions == null) {
      this.sourceAccessions = new ArrayList<String>();
    }
    this.sourceAccessions.add(sourceAccessionsItem);
    return this;
  }

  /**
   * All known corresponding accession IDs in INSDC (GenBank/ENA/DDBJ) ideally with a version number, e.g. `NC_000001.11`.
   * @return sourceAccessions
  **/
  @ApiModelProperty(value = "All known corresponding accession IDs in INSDC (GenBank/ENA/DDBJ) ideally with a version number, e.g. `NC_000001.11`.")
  
    public List<String> getSourceAccessions() {
    return sourceAccessions;
  }

  public void setSourceAccessions(List<String> sourceAccessions) {
    this.sourceAccessions = sourceAccessions;
  }

  public ReferenceSet sourceURI(String sourceURI) {
    this.sourceURI = sourceURI;
    return this;
  }

  /**
   * Specifies a FASTA format file/string.
   * @return sourceURI
  **/
  @ApiModelProperty(value = "Specifies a FASTA format file/string.")
  
    public String getSourceURI() {
    return sourceURI;
  }

  public void setSourceURI(String sourceURI) {
    this.sourceURI = sourceURI;
  }

  public ReferenceSet species(OntologyTerm species) {
    this.species = species;
    return this;
  }

  /**
   * Get species
   * @return species
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public OntologyTerm getSpecies() {
    return species;
  }

  public void setSpecies(OntologyTerm species) {
    this.species = species;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReferenceSet referenceSet = (ReferenceSet) o;
    return Objects.equals(this.additionalInfo, referenceSet.additionalInfo) &&
        Objects.equals(this.assemblyPUI, referenceSet.assemblyPUI) &&
        Objects.equals(this.description, referenceSet.description) &&
        Objects.equals(this.isDerived, referenceSet.isDerived) &&
        Objects.equals(this.md5checksum, referenceSet.md5checksum) &&
        Objects.equals(this.referenceSetDbId, referenceSet.referenceSetDbId) &&
        Objects.equals(this.referenceSetName, referenceSet.referenceSetName) &&
        Objects.equals(this.sourceAccessions, referenceSet.sourceAccessions) &&
        Objects.equals(this.sourceURI, referenceSet.sourceURI) &&
        Objects.equals(this.species, referenceSet.species);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, assemblyPUI, description, isDerived, md5checksum, referenceSetDbId, referenceSetName, sourceAccessions, sourceURI, species);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReferenceSet {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    assemblyPUI: ").append(toIndentedString(assemblyPUI)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isDerived: ").append(toIndentedString(isDerived)).append("\n");
    sb.append("    md5checksum: ").append(toIndentedString(md5checksum)).append("\n");
    sb.append("    referenceSetDbId: ").append(toIndentedString(referenceSetDbId)).append("\n");
    sb.append("    referenceSetName: ").append(toIndentedString(referenceSetName)).append("\n");
    sb.append("    sourceAccessions: ").append(toIndentedString(sourceAccessions)).append("\n");
    sb.append("    sourceURI: ").append(toIndentedString(sourceURI)).append("\n");
    sb.append("    species: ").append(toIndentedString(species)).append("\n");
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
