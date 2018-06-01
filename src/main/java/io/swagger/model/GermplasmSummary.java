package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * GermplasmSummary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class GermplasmSummary   {
  @JsonProperty("accessionNumber")
  private String accessionNumber = null;

  @JsonProperty("entryNumber")
  private String entryNumber = null;

  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("germplasmName")
  private String germplasmName = null;

  @JsonProperty("germplasmPUI")
  private String germplasmPUI = null;

  @JsonProperty("pedigree")
  private String pedigree = null;

  @JsonProperty("seedSource")
  private String seedSource = null;

  @JsonProperty("synonyms")
  @Valid
  private List<String> synonyms = null;

  public GermplasmSummary accessionNumber(String accessionNumber) {
    this.accessionNumber = accessionNumber;
    return this;
  }

   /**
   * This is the unique identifier for accessions within a genebank, and is assigned when a sample is entered into the genebank collection
   * @return accessionNumber
  **/
  @ApiModelProperty(value = "This is the unique identifier for accessions within a genebank, and is assigned when a sample is entered into the genebank collection")


  public String getAccessionNumber() {
    return accessionNumber;
  }

  public void setAccessionNumber(String accessionNumber) {
    this.accessionNumber = accessionNumber;
  }

  public GermplasmSummary entryNumber(String entryNumber) {
    this.entryNumber = entryNumber;
    return this;
  }

   /**
   * The entry number for this germplasm
   * @return entryNumber
  **/
  @ApiModelProperty(value = "The entry number for this germplasm")


  public String getEntryNumber() {
    return entryNumber;
  }

  public void setEntryNumber(String entryNumber) {
    this.entryNumber = entryNumber;
  }

  public GermplasmSummary germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies a germplasm within the given database server
   * @return germplasmDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a germplasm within the given database server")


  public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public GermplasmSummary germplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
    return this;
  }

   /**
   * Name of the germplasm. It can be the prefered name and does not have to be unique.
   * @return germplasmName
  **/
  @ApiModelProperty(value = "Name of the germplasm. It can be the prefered name and does not have to be unique.")


  public String getGermplasmName() {
    return germplasmName;
  }

  public void setGermplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
  }

  public GermplasmSummary germplasmPUI(String germplasmPUI) {
    this.germplasmPUI = germplasmPUI;
    return this;
  }

   /**
   * The Permanent Unique Identifier which represents a germplasm
   * @return germplasmPUI
  **/
  @ApiModelProperty(value = "The Permanent Unique Identifier which represents a germplasm")


  public String getGermplasmPUI() {
    return germplasmPUI;
  }

  public void setGermplasmPUI(String germplasmPUI) {
    this.germplasmPUI = germplasmPUI;
  }

  public GermplasmSummary pedigree(String pedigree) {
    this.pedigree = pedigree;
    return this;
  }

   /**
   * The cross name and optional selection history.
   * @return pedigree
  **/
  @ApiModelProperty(value = "The cross name and optional selection history.")


  public String getPedigree() {
    return pedigree;
  }

  public void setPedigree(String pedigree) {
    this.pedigree = pedigree;
  }

  public GermplasmSummary seedSource(String seedSource) {
    this.seedSource = seedSource;
    return this;
  }

   /**
   * The source of the seed 
   * @return seedSource
  **/
  @ApiModelProperty(value = "The source of the seed ")


  public String getSeedSource() {
    return seedSource;
  }

  public void setSeedSource(String seedSource) {
    this.seedSource = seedSource;
  }

  public GermplasmSummary synonyms(List<String> synonyms) {
    this.synonyms = synonyms;
    return this;
  }

  public GermplasmSummary addSynonymsItem(String synonymsItem) {
    if (this.synonyms == null) {
      this.synonyms = new ArrayList<String>();
    }
    this.synonyms.add(synonymsItem);
    return this;
  }

   /**
   * List of alternative names or IDs used to reference this germplasm
   * @return synonyms
  **/
  @ApiModelProperty(value = "List of alternative names or IDs used to reference this germplasm")


  public List<String> getSynonyms() {
    return synonyms;
  }

  public void setSynonyms(List<String> synonyms) {
    this.synonyms = synonyms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GermplasmSummary germplasmSummary = (GermplasmSummary) o;
    return Objects.equals(this.accessionNumber, germplasmSummary.accessionNumber) &&
        Objects.equals(this.entryNumber, germplasmSummary.entryNumber) &&
        Objects.equals(this.germplasmDbId, germplasmSummary.germplasmDbId) &&
        Objects.equals(this.germplasmName, germplasmSummary.germplasmName) &&
        Objects.equals(this.germplasmPUI, germplasmSummary.germplasmPUI) &&
        Objects.equals(this.pedigree, germplasmSummary.pedigree) &&
        Objects.equals(this.seedSource, germplasmSummary.seedSource) &&
        Objects.equals(this.synonyms, germplasmSummary.synonyms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessionNumber, entryNumber, germplasmDbId, germplasmName, germplasmPUI, pedigree, seedSource, synonyms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmSummary {\n");
    
    sb.append("    accessionNumber: ").append(toIndentedString(accessionNumber)).append("\n");
    sb.append("    entryNumber: ").append(toIndentedString(entryNumber)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
    sb.append("    germplasmPUI: ").append(toIndentedString(germplasmPUI)).append("\n");
    sb.append("    pedigree: ").append(toIndentedString(pedigree)).append("\n");
    sb.append("    seedSource: ").append(toIndentedString(seedSource)).append("\n");
    sb.append("    synonyms: ").append(toIndentedString(synonyms)).append("\n");
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

