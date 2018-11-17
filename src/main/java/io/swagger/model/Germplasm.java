package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GermplasmDonors;
import io.swagger.model.TaxonID;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Germplasm
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-06T17:40:52.157-05:00[America/New_York]")

public class Germplasm   {
  @JsonProperty("accessionNumber")
  private String accessionNumber = null;

  @JsonProperty("acquisitionDate")
  private LocalDate acquisitionDate = null;

  @JsonProperty("biologicalStatusOfAccessionCode")
  private Integer biologicalStatusOfAccessionCode = null;

  @JsonProperty("breedingMethodDbId")
  private String breedingMethodDbId = null;

  @JsonProperty("commonCropName")
  private String commonCropName = null;

  @JsonProperty("countryOfOriginCode")
  private String countryOfOriginCode = null;

  @JsonProperty("defaultDisplayName")
  private String defaultDisplayName = null;

  @JsonProperty("documentationURL")
  private String documentationURL = null;

  @JsonProperty("donors")
  @Valid
  private List<GermplasmDonors> donors = null;

  @JsonProperty("genus")
  private String genus = null;

  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("germplasmGenus")
  private String germplasmGenus = null;

  @JsonProperty("germplasmName")
  private String germplasmName = null;

  @JsonProperty("germplasmPUI")
  private String germplasmPUI = null;

  @JsonProperty("germplasmSpecies")
  private String germplasmSpecies = null;

  @JsonProperty("instituteCode")
  private String instituteCode = null;

  @JsonProperty("instituteName")
  private String instituteName = null;

  @JsonProperty("pedigree")
  private String pedigree = null;

  @JsonProperty("seedSource")
  private String seedSource = null;

  @JsonProperty("species")
  private String species = null;

  @JsonProperty("speciesAuthority")
  private String speciesAuthority = null;

  @JsonProperty("subtaxa")
  private String subtaxa = null;

  @JsonProperty("subtaxaAuthority")
  private String subtaxaAuthority = null;

  @JsonProperty("synonyms")
  @Valid
  private List<String> synonyms = null;

  @JsonProperty("taxonIds")
  @Valid
  private List<TaxonID> taxonIds = null;

  @JsonProperty("typeOfGermplasmStorageCode")
  @Valid
  private List<String> typeOfGermplasmStorageCode = null;

  public Germplasm accessionNumber(String accessionNumber) {
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

  public Germplasm acquisitionDate(LocalDate acquisitionDate) {
    this.acquisitionDate = acquisitionDate;
    return this;
  }

  /**
   * The date this germplasm was aquired by the genebank (MCPD)
   * @return acquisitionDate
  **/
  @ApiModelProperty(value = "The date this germplasm was aquired by the genebank (MCPD)")

  @Valid

  public LocalDate getAcquisitionDate() {
    return acquisitionDate;
  }

  public void setAcquisitionDate(LocalDate acquisitionDate) {
    this.acquisitionDate = acquisitionDate;
  }

  public Germplasm biologicalStatusOfAccessionCode(Integer biologicalStatusOfAccessionCode) {
    this.biologicalStatusOfAccessionCode = biologicalStatusOfAccessionCode;
    return this;
  }

  /**
   * The 3 digit code representing the biological status of the accession (MCPD)
   * @return biologicalStatusOfAccessionCode
  **/
  @ApiModelProperty(value = "The 3 digit code representing the biological status of the accession (MCPD)")


  public Integer getBiologicalStatusOfAccessionCode() {
    return biologicalStatusOfAccessionCode;
  }

  public void setBiologicalStatusOfAccessionCode(Integer biologicalStatusOfAccessionCode) {
    this.biologicalStatusOfAccessionCode = biologicalStatusOfAccessionCode;
  }

  public Germplasm breedingMethodDbId(String breedingMethodDbId) {
    this.breedingMethodDbId = breedingMethodDbId;
    return this;
  }

  /**
   * The unique identifier for the breeding method used to create this germplasm
   * @return breedingMethodDbId
  **/
  @ApiModelProperty(value = "The unique identifier for the breeding method used to create this germplasm")


  public String getBreedingMethodDbId() {
    return breedingMethodDbId;
  }

  public void setBreedingMethodDbId(String breedingMethodDbId) {
    this.breedingMethodDbId = breedingMethodDbId;
  }

  public Germplasm commonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
    return this;
  }

  /**
   * Common name for the crop (MCPD)
   * @return commonCropName
  **/
  @ApiModelProperty(value = "Common name for the crop (MCPD)")


  public String getCommonCropName() {
    return commonCropName;
  }

  public void setCommonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
  }

  public Germplasm countryOfOriginCode(String countryOfOriginCode) {
    this.countryOfOriginCode = countryOfOriginCode;
    return this;
  }

  /**
   * 3-letter ISO 3166-1 code of the country in which the sample was originally collected (MCPD)
   * @return countryOfOriginCode
  **/
  @ApiModelProperty(value = "3-letter ISO 3166-1 code of the country in which the sample was originally collected (MCPD)")


  public String getCountryOfOriginCode() {
    return countryOfOriginCode;
  }

  public void setCountryOfOriginCode(String countryOfOriginCode) {
    this.countryOfOriginCode = countryOfOriginCode;
  }

  public Germplasm defaultDisplayName(String defaultDisplayName) {
    this.defaultDisplayName = defaultDisplayName;
    return this;
  }

  /**
   * Human readable name used for display purposes
   * @return defaultDisplayName
  **/
  @ApiModelProperty(value = "Human readable name used for display purposes")


  public String getDefaultDisplayName() {
    return defaultDisplayName;
  }

  public void setDefaultDisplayName(String defaultDisplayName) {
    this.defaultDisplayName = defaultDisplayName;
  }

  public Germplasm documentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
    return this;
  }

  /**
   * A URL to the human readable documentation of this object
   * @return documentationURL
  **/
  @ApiModelProperty(value = "A URL to the human readable documentation of this object")


  public String getDocumentationURL() {
    return documentationURL;
  }

  public void setDocumentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
  }

  public Germplasm donors(List<GermplasmDonors> donors) {
    this.donors = donors;
    return this;
  }

  public Germplasm addDonorsItem(GermplasmDonors donorsItem) {
    if (this.donors == null) {
      this.donors = new ArrayList<GermplasmDonors>();
    }
    this.donors.add(donorsItem);
    return this;
  }

  /**
   * List of donor institutes (MCPD)
   * @return donors
  **/
  @ApiModelProperty(value = "List of donor institutes (MCPD)")

  @Valid

  public List<GermplasmDonors> getDonors() {
    return donors;
  }

  public void setDonors(List<GermplasmDonors> donors) {
    this.donors = donors;
  }

  public Germplasm genus(String genus) {
    this.genus = genus;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - see \"germplasmGenus\"
   * @return genus
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - see \"germplasmGenus\"")


  public String getGenus() {
    return genus;
  }

  public void setGenus(String genus) {
    this.genus = genus;
  }

  public Germplasm germplasmDbId(String germplasmDbId) {
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

  public Germplasm germplasmGenus(String germplasmGenus) {
    this.germplasmGenus = germplasmGenus;
    return this;
  }

  /**
   * Genus name for taxon. Initial uppercase letter required. (MCPD)
   * @return germplasmGenus
  **/
  @ApiModelProperty(value = "Genus name for taxon. Initial uppercase letter required. (MCPD)")


  public String getGermplasmGenus() {
    return germplasmGenus;
  }

  public void setGermplasmGenus(String germplasmGenus) {
    this.germplasmGenus = germplasmGenus;
  }

  public Germplasm germplasmName(String germplasmName) {
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

  public Germplasm germplasmPUI(String germplasmPUI) {
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

  public Germplasm germplasmSpecies(String germplasmSpecies) {
    this.germplasmSpecies = germplasmSpecies;
    return this;
  }

  /**
   * Specific epithet portion of the scientific name in lowercase letters. (MCPD)
   * @return germplasmSpecies
  **/
  @ApiModelProperty(value = "Specific epithet portion of the scientific name in lowercase letters. (MCPD)")


  public String getGermplasmSpecies() {
    return germplasmSpecies;
  }

  public void setGermplasmSpecies(String germplasmSpecies) {
    this.germplasmSpecies = germplasmSpecies;
  }

  public Germplasm instituteCode(String instituteCode) {
    this.instituteCode = instituteCode;
    return this;
  }

  /**
   * The code for the Institute that has bred the material. (MCPD)
   * @return instituteCode
  **/
  @ApiModelProperty(value = "The code for the Institute that has bred the material. (MCPD)")


  public String getInstituteCode() {
    return instituteCode;
  }

  public void setInstituteCode(String instituteCode) {
    this.instituteCode = instituteCode;
  }

  public Germplasm instituteName(String instituteName) {
    this.instituteName = instituteName;
    return this;
  }

  /**
   * The name of the institution which bred the material (MCPD)
   * @return instituteName
  **/
  @ApiModelProperty(value = "The name of the institution which bred the material (MCPD)")


  public String getInstituteName() {
    return instituteName;
  }

  public void setInstituteName(String instituteName) {
    this.instituteName = instituteName;
  }

  public Germplasm pedigree(String pedigree) {
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

  public Germplasm seedSource(String seedSource) {
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

  public Germplasm species(String species) {
    this.species = species;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - see \"germplasmSpecies\"
   * @return species
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - see \"germplasmSpecies\"")


  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public Germplasm speciesAuthority(String speciesAuthority) {
    this.speciesAuthority = speciesAuthority;
    return this;
  }

  /**
   * The authority organization responsible for tracking and maintaining the species name (MCPD)
   * @return speciesAuthority
  **/
  @ApiModelProperty(value = "The authority organization responsible for tracking and maintaining the species name (MCPD)")


  public String getSpeciesAuthority() {
    return speciesAuthority;
  }

  public void setSpeciesAuthority(String speciesAuthority) {
    this.speciesAuthority = speciesAuthority;
  }

  public Germplasm subtaxa(String subtaxa) {
    this.subtaxa = subtaxa;
    return this;
  }

  /**
   * Subtaxon can be used to store any additional taxonomic identifier. (MCPD)
   * @return subtaxa
  **/
  @ApiModelProperty(value = "Subtaxon can be used to store any additional taxonomic identifier. (MCPD)")


  public String getSubtaxa() {
    return subtaxa;
  }

  public void setSubtaxa(String subtaxa) {
    this.subtaxa = subtaxa;
  }

  public Germplasm subtaxaAuthority(String subtaxaAuthority) {
    this.subtaxaAuthority = subtaxaAuthority;
    return this;
  }

  /**
   *  The authority organization responsible for tracking and maintaining the subtaxon information (MCPD)
   * @return subtaxaAuthority
  **/
  @ApiModelProperty(value = " The authority organization responsible for tracking and maintaining the subtaxon information (MCPD)")


  public String getSubtaxaAuthority() {
    return subtaxaAuthority;
  }

  public void setSubtaxaAuthority(String subtaxaAuthority) {
    this.subtaxaAuthority = subtaxaAuthority;
  }

  public Germplasm synonyms(List<String> synonyms) {
    this.synonyms = synonyms;
    return this;
  }

  public Germplasm addSynonymsItem(String synonymsItem) {
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

  public Germplasm taxonIds(List<TaxonID> taxonIds) {
    this.taxonIds = taxonIds;
    return this;
  }

  public Germplasm addTaxonIdsItem(TaxonID taxonIdsItem) {
    if (this.taxonIds == null) {
      this.taxonIds = new ArrayList<TaxonID>();
    }
    this.taxonIds.add(taxonIdsItem);
    return this;
  }

  /**
   * The list of IDs for this SPECIES from different sources. If present, NCBI Taxon should be always listed as \"ncbiTaxon\" preferably with a purl. The rank of this ID should be species.
   * @return taxonIds
  **/
  @ApiModelProperty(value = "The list of IDs for this SPECIES from different sources. If present, NCBI Taxon should be always listed as \"ncbiTaxon\" preferably with a purl. The rank of this ID should be species.")

  @Valid

  public List<TaxonID> getTaxonIds() {
    return taxonIds;
  }

  public void setTaxonIds(List<TaxonID> taxonIds) {
    this.taxonIds = taxonIds;
  }

  public Germplasm typeOfGermplasmStorageCode(List<String> typeOfGermplasmStorageCode) {
    this.typeOfGermplasmStorageCode = typeOfGermplasmStorageCode;
    return this;
  }

  public Germplasm addTypeOfGermplasmStorageCodeItem(String typeOfGermplasmStorageCodeItem) {
    if (this.typeOfGermplasmStorageCode == null) {
      this.typeOfGermplasmStorageCode = new ArrayList<String>();
    }
    this.typeOfGermplasmStorageCode.add(typeOfGermplasmStorageCodeItem);
    return this;
  }

  /**
   * The 2 digit code representing the type of storage this germplasm is kept in at a genebank. (MCPD)
   * @return typeOfGermplasmStorageCode
  **/
  @ApiModelProperty(value = "The 2 digit code representing the type of storage this germplasm is kept in at a genebank. (MCPD)")


  public List<String> getTypeOfGermplasmStorageCode() {
    return typeOfGermplasmStorageCode;
  }

  public void setTypeOfGermplasmStorageCode(List<String> typeOfGermplasmStorageCode) {
    this.typeOfGermplasmStorageCode = typeOfGermplasmStorageCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Germplasm germplasm = (Germplasm) o;
    return Objects.equals(this.accessionNumber, germplasm.accessionNumber) &&
        Objects.equals(this.acquisitionDate, germplasm.acquisitionDate) &&
        Objects.equals(this.biologicalStatusOfAccessionCode, germplasm.biologicalStatusOfAccessionCode) &&
        Objects.equals(this.breedingMethodDbId, germplasm.breedingMethodDbId) &&
        Objects.equals(this.commonCropName, germplasm.commonCropName) &&
        Objects.equals(this.countryOfOriginCode, germplasm.countryOfOriginCode) &&
        Objects.equals(this.defaultDisplayName, germplasm.defaultDisplayName) &&
        Objects.equals(this.documentationURL, germplasm.documentationURL) &&
        Objects.equals(this.donors, germplasm.donors) &&
        Objects.equals(this.genus, germplasm.genus) &&
        Objects.equals(this.germplasmDbId, germplasm.germplasmDbId) &&
        Objects.equals(this.germplasmGenus, germplasm.germplasmGenus) &&
        Objects.equals(this.germplasmName, germplasm.germplasmName) &&
        Objects.equals(this.germplasmPUI, germplasm.germplasmPUI) &&
        Objects.equals(this.germplasmSpecies, germplasm.germplasmSpecies) &&
        Objects.equals(this.instituteCode, germplasm.instituteCode) &&
        Objects.equals(this.instituteName, germplasm.instituteName) &&
        Objects.equals(this.pedigree, germplasm.pedigree) &&
        Objects.equals(this.seedSource, germplasm.seedSource) &&
        Objects.equals(this.species, germplasm.species) &&
        Objects.equals(this.speciesAuthority, germplasm.speciesAuthority) &&
        Objects.equals(this.subtaxa, germplasm.subtaxa) &&
        Objects.equals(this.subtaxaAuthority, germplasm.subtaxaAuthority) &&
        Objects.equals(this.synonyms, germplasm.synonyms) &&
        Objects.equals(this.taxonIds, germplasm.taxonIds) &&
        Objects.equals(this.typeOfGermplasmStorageCode, germplasm.typeOfGermplasmStorageCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessionNumber, acquisitionDate, biologicalStatusOfAccessionCode, breedingMethodDbId, commonCropName, countryOfOriginCode, defaultDisplayName, documentationURL, donors, genus, germplasmDbId, germplasmGenus, germplasmName, germplasmPUI, germplasmSpecies, instituteCode, instituteName, pedigree, seedSource, species, speciesAuthority, subtaxa, subtaxaAuthority, synonyms, taxonIds, typeOfGermplasmStorageCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Germplasm {\n");
    
    sb.append("    accessionNumber: ").append(toIndentedString(accessionNumber)).append("\n");
    sb.append("    acquisitionDate: ").append(toIndentedString(acquisitionDate)).append("\n");
    sb.append("    biologicalStatusOfAccessionCode: ").append(toIndentedString(biologicalStatusOfAccessionCode)).append("\n");
    sb.append("    breedingMethodDbId: ").append(toIndentedString(breedingMethodDbId)).append("\n");
    sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
    sb.append("    countryOfOriginCode: ").append(toIndentedString(countryOfOriginCode)).append("\n");
    sb.append("    defaultDisplayName: ").append(toIndentedString(defaultDisplayName)).append("\n");
    sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
    sb.append("    donors: ").append(toIndentedString(donors)).append("\n");
    sb.append("    genus: ").append(toIndentedString(genus)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    germplasmGenus: ").append(toIndentedString(germplasmGenus)).append("\n");
    sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
    sb.append("    germplasmPUI: ").append(toIndentedString(germplasmPUI)).append("\n");
    sb.append("    germplasmSpecies: ").append(toIndentedString(germplasmSpecies)).append("\n");
    sb.append("    instituteCode: ").append(toIndentedString(instituteCode)).append("\n");
    sb.append("    instituteName: ").append(toIndentedString(instituteName)).append("\n");
    sb.append("    pedigree: ").append(toIndentedString(pedigree)).append("\n");
    sb.append("    seedSource: ").append(toIndentedString(seedSource)).append("\n");
    sb.append("    species: ").append(toIndentedString(species)).append("\n");
    sb.append("    speciesAuthority: ").append(toIndentedString(speciesAuthority)).append("\n");
    sb.append("    subtaxa: ").append(toIndentedString(subtaxa)).append("\n");
    sb.append("    subtaxaAuthority: ").append(toIndentedString(subtaxaAuthority)).append("\n");
    sb.append("    synonyms: ").append(toIndentedString(synonyms)).append("\n");
    sb.append("    taxonIds: ").append(toIndentedString(taxonIds)).append("\n");
    sb.append("    typeOfGermplasmStorageCode: ").append(toIndentedString(typeOfGermplasmStorageCode)).append("\n");
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

