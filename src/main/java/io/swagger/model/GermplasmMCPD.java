package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GermplasmMCPDBreedingInstitutes;
import io.swagger.model.GermplasmMCPDCollectingInfo;
import io.swagger.model.GermplasmMCPDDonorInfo;
import io.swagger.model.GermplasmMCPDSafetyDuplicateInstitues;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * GermplasmMCPD
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class GermplasmMCPD   {
  @JsonProperty("accessionNames")
  @Valid
  private List<String> accessionNames = null;

  @JsonProperty("accessionNumber")
  private String accessionNumber = null;

  @JsonProperty("acquisitionDate")
  private String acquisitionDate = null;

  /**
   * MCPD (v2.1) (COLLSRC) 21. The coding scheme proposed can be used at 2 different levels of detail: either by using the general codes (in boldface) such as 10, 20, 30, 40, etc., or by using the more specific codes, such as 11, 12, etc. 10) Wild habitat 11) Forest or woodland 12) Shrubland 13) Grassland 14) Desert or tundra 15) Aquatic habitat 20) Farm or cultivated habitat 21) Field 22) Orchard 23) Backyard, kitchen or home garden (urban, peri-urban or rural) 24) Fallow land 25) Pasture 26) Farm store 27) Threshing floor 28) Park 30) Market or shop 40) Institute, Experimental station, Research organization, Genebank 50) Seed company 60) Weedy, disturbed or ruderal habitat 61) Roadside 62) Field margin 99) Other (Elaborate in REMARKS field) 
   */
  public enum AcquisitionSourceCodeEnum {
    _10("10"),
    
    _11("11"),
    
    _12("12"),
    
    _13("13"),
    
    _14("14"),
    
    _15("15"),
    
    _20("20"),
    
    _21("21"),
    
    _22("22"),
    
    _23("23"),
    
    _24("24"),
    
    _25("25"),
    
    _26("26"),
    
    _27("27"),
    
    _28("28"),
    
    _30("30"),
    
    _40("40"),
    
    _50("50"),
    
    _60("60"),
    
    _61("61"),
    
    _62("62"),
    
    _99("99");

    private String value;

    AcquisitionSourceCodeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AcquisitionSourceCodeEnum fromValue(String text) {
      for (AcquisitionSourceCodeEnum b : AcquisitionSourceCodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("acquisitionSourceCode")
  private AcquisitionSourceCodeEnum acquisitionSourceCode = null;

  @JsonProperty("alternateIDs")
  @Valid
  private List<String> alternateIDs = null;

  @JsonProperty("ancestralData")
  private String ancestralData = null;

  /**
   * MCPD (v2.1) (SAMPSTAT) 19. The coding scheme proposed can be used at 3 different levels of detail: either by using the general codes (in boldface) such as 100, 200, 300, 400, or by using the more specific codes such as 110, 120, etc. 100) Wild 110) Natural 120) Semi-natural/wild 130) Semi-natural/sown 200) Weedy 300) Traditional cultivar/landrace 400) Breeding/research material 410) Breeders line 411) Synthetic population 412) Hybrid 413) Founder stock/base population 414) Inbred line (parent of hybrid cultivar) 415) Segregating population 416) Clonal selection 420) Genetic stock 421) Mutant (e.g. induced/insertion mutants, tilling populations) 422) Cytogenetic stocks (e.g. chromosome addition/substitution, aneuploids,  amphiploids) 423) Other genetic stocks (e.g. mapping populations) 500) Advanced or improved cultivar (conventional breeding methods) 600) GMO (by genetic engineering) 999) Other (Elaborate in REMARKS field)
   */
  public enum BiologicalStatusOfAccessionCodeEnum {
    _100("100"),
    
    _110("110"),
    
    _120("120"),
    
    _130("130"),
    
    _200("200"),
    
    _300("300"),
    
    _400("400"),
    
    _410("410"),
    
    _411("411"),
    
    _412("412"),
    
    _413("413"),
    
    _414("414"),
    
    _415("415"),
    
    _416("416"),
    
    _420("420"),
    
    _421("421"),
    
    _422("422"),
    
    _423("423"),
    
    _500("500"),
    
    _600("600"),
    
    _999("999");

    private String value;

    BiologicalStatusOfAccessionCodeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static BiologicalStatusOfAccessionCodeEnum fromValue(String text) {
      for (BiologicalStatusOfAccessionCodeEnum b : BiologicalStatusOfAccessionCodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("biologicalStatusOfAccessionCode")
  private BiologicalStatusOfAccessionCodeEnum biologicalStatusOfAccessionCode = null;

  @JsonProperty("breedingInstitutes")
  @Valid
  private List<GermplasmMCPDBreedingInstitutes> breedingInstitutes = null;

  @JsonProperty("collectingInfo")
  private GermplasmMCPDCollectingInfo collectingInfo = null;

  @JsonProperty("commonCropName")
  private String commonCropName = null;

  @JsonProperty("countryOfOrigin")
  private String countryOfOrigin = null;

  @JsonProperty("donorInfo")
  private GermplasmMCPDDonorInfo donorInfo = null;

  @JsonProperty("genus")
  private String genus = null;

  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("germplasmPUI")
  private String germplasmPUI = null;

  @JsonProperty("instituteCode")
  private String instituteCode = null;

  /**
   * MCPD (v2.1) (MLSSTAT) 27. The status of an accession with regards to the Multilateral System (MLS) of the International Treaty on Plant Genetic Resources for Food and Agriculture. Leave the value empty if the status is not known 0 No (not included) 1 Yes (included) 99 Other (elaborate in REMARKS field, e.g. \"under development\")
   */
  public enum MlsStatusEnum {
    EMPTY(""),
    
    _0("0"),
    
    _1("1"),
    
    _99("99");

    private String value;

    MlsStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MlsStatusEnum fromValue(String text) {
      for (MlsStatusEnum b : MlsStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("mlsStatus")
  private MlsStatusEnum mlsStatus = null;

  @JsonProperty("remarks")
  private String remarks = null;

  @JsonProperty("safetyDuplicateInstitues")
  @Valid
  private List<GermplasmMCPDSafetyDuplicateInstitues> safetyDuplicateInstitues = null;

  @JsonProperty("species")
  private String species = null;

  @JsonProperty("speciesAuthority")
  private String speciesAuthority = null;

  /**
   * Gets or Sets storageTypeCodes
   */
  public enum StorageTypeCodesEnum {
    _10("10"),
    
    _11("11"),
    
    _12("12"),
    
    _13("13"),
    
    _20("20"),
    
    _30("30"),
    
    _40("40"),
    
    _50("50"),
    
    _99("99");

    private String value;

    StorageTypeCodesEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StorageTypeCodesEnum fromValue(String text) {
      for (StorageTypeCodesEnum b : StorageTypeCodesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("storageTypeCodes")
  @Valid
  private List<StorageTypeCodesEnum> storageTypeCodes = null;

  @JsonProperty("subtaxon")
  private String subtaxon = null;

  @JsonProperty("subtaxonAuthority")
  private String subtaxonAuthority = null;

  public GermplasmMCPD accessionNames(List<String> accessionNames) {
    this.accessionNames = accessionNames;
    return this;
  }

  public GermplasmMCPD addAccessionNamesItem(String accessionNamesItem) {
    if (this.accessionNames == null) {
      this.accessionNames = new ArrayList<String>();
    }
    this.accessionNames.add(accessionNamesItem);
    return this;
  }

  /**
   * MCPD (v2.1) (ACCENAME) 11. Either a registered or other designation given to the material received, other than the donors accession number (23) or collecting number (3). First letter uppercase. Multiple names are separated by a semicolon without space. Example: Accession name: Bogatyr;Symphony;Emma.
   * @return accessionNames
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (ACCENAME) 11. Either a registered or other designation given to the material received, other than the donors accession number (23) or collecting number (3). First letter uppercase. Multiple names are separated by a semicolon without space. Example: Accession name: Bogatyr;Symphony;Emma.")


  public List<String> getAccessionNames() {
    return accessionNames;
  }

  public void setAccessionNames(List<String> accessionNames) {
    this.accessionNames = accessionNames;
  }

  public GermplasmMCPD accessionNumber(String accessionNumber) {
    this.accessionNumber = accessionNumber;
    return this;
  }

  /**
   * MCPD (v2.1) (ACCENUMB) 2. This is the unique identifier for accessions within a genebank, and is assigned when a sample is entered into the genebank collection (e.g. \"PI 113869\").
   * @return accessionNumber
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (ACCENUMB) 2. This is the unique identifier for accessions within a genebank, and is assigned when a sample is entered into the genebank collection (e.g. \"PI 113869\").")


  public String getAccessionNumber() {
    return accessionNumber;
  }

  public void setAccessionNumber(String accessionNumber) {
    this.accessionNumber = accessionNumber;
  }

  public GermplasmMCPD acquisitionDate(String acquisitionDate) {
    this.acquisitionDate = acquisitionDate;
    return this;
  }

  /**
   * MCPD (v2.1) (ACQDATE) 12. Date on which the accession entered the collection [YYYYMMDD] where YYYY is the year, MM is the month and DD is the day. Missing data (MM or DD) should be indicated with hyphens or \"00\" [double zero].
   * @return acquisitionDate
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (ACQDATE) 12. Date on which the accession entered the collection [YYYYMMDD] where YYYY is the year, MM is the month and DD is the day. Missing data (MM or DD) should be indicated with hyphens or \"00\" [double zero].")


  public String getAcquisitionDate() {
    return acquisitionDate;
  }

  public void setAcquisitionDate(String acquisitionDate) {
    this.acquisitionDate = acquisitionDate;
  }

  public GermplasmMCPD acquisitionSourceCode(AcquisitionSourceCodeEnum acquisitionSourceCode) {
    this.acquisitionSourceCode = acquisitionSourceCode;
    return this;
  }

  /**
   * MCPD (v2.1) (COLLSRC) 21. The coding scheme proposed can be used at 2 different levels of detail: either by using the general codes (in boldface) such as 10, 20, 30, 40, etc., or by using the more specific codes, such as 11, 12, etc. 10) Wild habitat 11) Forest or woodland 12) Shrubland 13) Grassland 14) Desert or tundra 15) Aquatic habitat 20) Farm or cultivated habitat 21) Field 22) Orchard 23) Backyard, kitchen or home garden (urban, peri-urban or rural) 24) Fallow land 25) Pasture 26) Farm store 27) Threshing floor 28) Park 30) Market or shop 40) Institute, Experimental station, Research organization, Genebank 50) Seed company 60) Weedy, disturbed or ruderal habitat 61) Roadside 62) Field margin 99) Other (Elaborate in REMARKS field) 
   * @return acquisitionSourceCode
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (COLLSRC) 21. The coding scheme proposed can be used at 2 different levels of detail: either by using the general codes (in boldface) such as 10, 20, 30, 40, etc., or by using the more specific codes, such as 11, 12, etc. 10) Wild habitat 11) Forest or woodland 12) Shrubland 13) Grassland 14) Desert or tundra 15) Aquatic habitat 20) Farm or cultivated habitat 21) Field 22) Orchard 23) Backyard, kitchen or home garden (urban, peri-urban or rural) 24) Fallow land 25) Pasture 26) Farm store 27) Threshing floor 28) Park 30) Market or shop 40) Institute, Experimental station, Research organization, Genebank 50) Seed company 60) Weedy, disturbed or ruderal habitat 61) Roadside 62) Field margin 99) Other (Elaborate in REMARKS field) ")


  public AcquisitionSourceCodeEnum getAcquisitionSourceCode() {
    return acquisitionSourceCode;
  }

  public void setAcquisitionSourceCode(AcquisitionSourceCodeEnum acquisitionSourceCode) {
    this.acquisitionSourceCode = acquisitionSourceCode;
  }

  public GermplasmMCPD alternateIDs(List<String> alternateIDs) {
    this.alternateIDs = alternateIDs;
    return this;
  }

  public GermplasmMCPD addAlternateIDsItem(String alternateIDsItem) {
    if (this.alternateIDs == null) {
      this.alternateIDs = new ArrayList<String>();
    }
    this.alternateIDs.add(alternateIDsItem);
    return this;
  }

  /**
   * MCPD (v2.1) (OTHERNUMB) 24. Any other identifiers known to exist in other collections for this accession. Use the following format: INSTCODE:ACCENUMB;INSTCODE:identifier;INSTCODE and identifier are separated by a colon without space. Pairs of INSTCODE and identifier are separated by a semicolon without space. When the institute is not known, the identifier should be preceded by a colon. 
   * @return alternateIDs
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (OTHERNUMB) 24. Any other identifiers known to exist in other collections for this accession. Use the following format: INSTCODE:ACCENUMB;INSTCODE:identifier;INSTCODE and identifier are separated by a colon without space. Pairs of INSTCODE and identifier are separated by a semicolon without space. When the institute is not known, the identifier should be preceded by a colon. ")


  public List<String> getAlternateIDs() {
    return alternateIDs;
  }

  public void setAlternateIDs(List<String> alternateIDs) {
    this.alternateIDs = alternateIDs;
  }

  public GermplasmMCPD ancestralData(String ancestralData) {
    this.ancestralData = ancestralData;
    return this;
  }

  /**
   * MCPD (v2.1) (ANCEST) 20. Information about either pedigree or other description of ancestral information (e.g. parent variety in case of mutant or selection). For example a pedigree 'Hanna/7*Atlas//Turk/8*Atlas' or a description 'mutation found in Hanna', 'selection from Irene' or 'cross involving amongst others Hanna and Irene'.
   * @return ancestralData
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (ANCEST) 20. Information about either pedigree or other description of ancestral information (e.g. parent variety in case of mutant or selection). For example a pedigree 'Hanna/7*Atlas//Turk/8*Atlas' or a description 'mutation found in Hanna', 'selection from Irene' or 'cross involving amongst others Hanna and Irene'.")


  public String getAncestralData() {
    return ancestralData;
  }

  public void setAncestralData(String ancestralData) {
    this.ancestralData = ancestralData;
  }

  public GermplasmMCPD biologicalStatusOfAccessionCode(BiologicalStatusOfAccessionCodeEnum biologicalStatusOfAccessionCode) {
    this.biologicalStatusOfAccessionCode = biologicalStatusOfAccessionCode;
    return this;
  }

  /**
   * MCPD (v2.1) (SAMPSTAT) 19. The coding scheme proposed can be used at 3 different levels of detail: either by using the general codes (in boldface) such as 100, 200, 300, 400, or by using the more specific codes such as 110, 120, etc. 100) Wild 110) Natural 120) Semi-natural/wild 130) Semi-natural/sown 200) Weedy 300) Traditional cultivar/landrace 400) Breeding/research material 410) Breeders line 411) Synthetic population 412) Hybrid 413) Founder stock/base population 414) Inbred line (parent of hybrid cultivar) 415) Segregating population 416) Clonal selection 420) Genetic stock 421) Mutant (e.g. induced/insertion mutants, tilling populations) 422) Cytogenetic stocks (e.g. chromosome addition/substitution, aneuploids,  amphiploids) 423) Other genetic stocks (e.g. mapping populations) 500) Advanced or improved cultivar (conventional breeding methods) 600) GMO (by genetic engineering) 999) Other (Elaborate in REMARKS field)
   * @return biologicalStatusOfAccessionCode
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (SAMPSTAT) 19. The coding scheme proposed can be used at 3 different levels of detail: either by using the general codes (in boldface) such as 100, 200, 300, 400, or by using the more specific codes such as 110, 120, etc. 100) Wild 110) Natural 120) Semi-natural/wild 130) Semi-natural/sown 200) Weedy 300) Traditional cultivar/landrace 400) Breeding/research material 410) Breeders line 411) Synthetic population 412) Hybrid 413) Founder stock/base population 414) Inbred line (parent of hybrid cultivar) 415) Segregating population 416) Clonal selection 420) Genetic stock 421) Mutant (e.g. induced/insertion mutants, tilling populations) 422) Cytogenetic stocks (e.g. chromosome addition/substitution, aneuploids,  amphiploids) 423) Other genetic stocks (e.g. mapping populations) 500) Advanced or improved cultivar (conventional breeding methods) 600) GMO (by genetic engineering) 999) Other (Elaborate in REMARKS field)")


  public BiologicalStatusOfAccessionCodeEnum getBiologicalStatusOfAccessionCode() {
    return biologicalStatusOfAccessionCode;
  }

  public void setBiologicalStatusOfAccessionCode(BiologicalStatusOfAccessionCodeEnum biologicalStatusOfAccessionCode) {
    this.biologicalStatusOfAccessionCode = biologicalStatusOfAccessionCode;
  }

  public GermplasmMCPD breedingInstitutes(List<GermplasmMCPDBreedingInstitutes> breedingInstitutes) {
    this.breedingInstitutes = breedingInstitutes;
    return this;
  }

  public GermplasmMCPD addBreedingInstitutesItem(GermplasmMCPDBreedingInstitutes breedingInstitutesItem) {
    if (this.breedingInstitutes == null) {
      this.breedingInstitutes = new ArrayList<GermplasmMCPDBreedingInstitutes>();
    }
    this.breedingInstitutes.add(breedingInstitutesItem);
    return this;
  }

  /**
   * Get breedingInstitutes
   * @return breedingInstitutes
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<GermplasmMCPDBreedingInstitutes> getBreedingInstitutes() {
    return breedingInstitutes;
  }

  public void setBreedingInstitutes(List<GermplasmMCPDBreedingInstitutes> breedingInstitutes) {
    this.breedingInstitutes = breedingInstitutes;
  }

  public GermplasmMCPD collectingInfo(GermplasmMCPDCollectingInfo collectingInfo) {
    this.collectingInfo = collectingInfo;
    return this;
  }

  /**
   * Get collectingInfo
   * @return collectingInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public GermplasmMCPDCollectingInfo getCollectingInfo() {
    return collectingInfo;
  }

  public void setCollectingInfo(GermplasmMCPDCollectingInfo collectingInfo) {
    this.collectingInfo = collectingInfo;
  }

  public GermplasmMCPD commonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
    return this;
  }

  /**
   * MCPD (v2.1) (CROPNAME) 10. Common name of the crop. Example: \"malting barley\", \"macadamia\", \"mas\". 
   * @return commonCropName
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (CROPNAME) 10. Common name of the crop. Example: \"malting barley\", \"macadamia\", \"mas\". ")


  public String getCommonCropName() {
    return commonCropName;
  }

  public void setCommonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
  }

  public GermplasmMCPD countryOfOrigin(String countryOfOrigin) {
    this.countryOfOrigin = countryOfOrigin;
    return this;
  }

  /**
   * MCPD (v2.1) (ORIGCTY) 13. 3-letter ISO 3166-1 code of the country in which the sample was originally collected (e.g. landrace, crop wild relative, farmers\" variety), bred or selected (breeding lines, GMOs, segregating populations, hybrids, modern cultivars, etc.). Note: Descriptors 14 to 16 below should be completed accordingly only if it was \"collected\".
   * @return countryOfOrigin
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (ORIGCTY) 13. 3-letter ISO 3166-1 code of the country in which the sample was originally collected (e.g. landrace, crop wild relative, farmers\" variety), bred or selected (breeding lines, GMOs, segregating populations, hybrids, modern cultivars, etc.). Note: Descriptors 14 to 16 below should be completed accordingly only if it was \"collected\".")


  public String getCountryOfOrigin() {
    return countryOfOrigin;
  }

  public void setCountryOfOrigin(String countryOfOrigin) {
    this.countryOfOrigin = countryOfOrigin;
  }

  public GermplasmMCPD donorInfo(GermplasmMCPDDonorInfo donorInfo) {
    this.donorInfo = donorInfo;
    return this;
  }

  /**
   * Get donorInfo
   * @return donorInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public GermplasmMCPDDonorInfo getDonorInfo() {
    return donorInfo;
  }

  public void setDonorInfo(GermplasmMCPDDonorInfo donorInfo) {
    this.donorInfo = donorInfo;
  }

  public GermplasmMCPD genus(String genus) {
    this.genus = genus;
    return this;
  }

  /**
   * MCPD (v2.1) (GENUS) 5. Genus name for taxon. Initial uppercase letter required.
   * @return genus
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (GENUS) 5. Genus name for taxon. Initial uppercase letter required.")


  public String getGenus() {
    return genus;
  }

  public void setGenus(String genus) {
    this.genus = genus;
  }

  public GermplasmMCPD germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

  /**
   * A unique identifier which identifies a germplasm in this database
   * @return germplasmDbId
  **/
  @ApiModelProperty(value = "A unique identifier which identifies a germplasm in this database")


  public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public GermplasmMCPD germplasmPUI(String germplasmPUI) {
    this.germplasmPUI = germplasmPUI;
    return this;
  }

  /**
   * MCPD (v2.1) (PUID) 0. Any persistent, unique identifier assigned to the accession so it can be unambiguously referenced at the global level and the information associated with it harvested through automated means. Report one PUID for each accession. The Secretariat of the International Treaty on Plant Genetic Resources for Food and Agriculture (PGRFA) is facilitating the assignment of a persistent unique identifier (PUID), in the form of a DOI, to PGRFA at the accession level (http://www.planttreaty.org/doi). Genebanks not applying a true PUID to their accessions should use, and request recipients to use, the concatenation of INSTCODE, ACCENUMB, and GENUS as a globally unique identifier similar in most respects to the PUID whenever they exchange information on accessions with third parties (e.g. NOR017:NGB17773:ALLIUM).
   * @return germplasmPUI
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (PUID) 0. Any persistent, unique identifier assigned to the accession so it can be unambiguously referenced at the global level and the information associated with it harvested through automated means. Report one PUID for each accession. The Secretariat of the International Treaty on Plant Genetic Resources for Food and Agriculture (PGRFA) is facilitating the assignment of a persistent unique identifier (PUID), in the form of a DOI, to PGRFA at the accession level (http://www.planttreaty.org/doi). Genebanks not applying a true PUID to their accessions should use, and request recipients to use, the concatenation of INSTCODE, ACCENUMB, and GENUS as a globally unique identifier similar in most respects to the PUID whenever they exchange information on accessions with third parties (e.g. NOR017:NGB17773:ALLIUM).")


  public String getGermplasmPUI() {
    return germplasmPUI;
  }

  public void setGermplasmPUI(String germplasmPUI) {
    this.germplasmPUI = germplasmPUI;
  }

  public GermplasmMCPD instituteCode(String instituteCode) {
    this.instituteCode = instituteCode;
    return this;
  }

  /**
   * MCPD (v2.1) (INSTCODE) 1. FAO WIEWS code of the institute where the accession is maintained. The codes consist of the 3-letter ISO 3166 country code of the country where the institute is located plus a number (e.g. COL001). The current set of institute codes is available from http://www.fao.org/wiews. For those institutes not yet having an FAO Code, or for those with \"obsolete\" codes, see \"Common formatting rules (v)\".
   * @return instituteCode
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (INSTCODE) 1. FAO WIEWS code of the institute where the accession is maintained. The codes consist of the 3-letter ISO 3166 country code of the country where the institute is located plus a number (e.g. COL001). The current set of institute codes is available from http://www.fao.org/wiews. For those institutes not yet having an FAO Code, or for those with \"obsolete\" codes, see \"Common formatting rules (v)\".")


  public String getInstituteCode() {
    return instituteCode;
  }

  public void setInstituteCode(String instituteCode) {
    this.instituteCode = instituteCode;
  }

  public GermplasmMCPD mlsStatus(MlsStatusEnum mlsStatus) {
    this.mlsStatus = mlsStatus;
    return this;
  }

  /**
   * MCPD (v2.1) (MLSSTAT) 27. The status of an accession with regards to the Multilateral System (MLS) of the International Treaty on Plant Genetic Resources for Food and Agriculture. Leave the value empty if the status is not known 0 No (not included) 1 Yes (included) 99 Other (elaborate in REMARKS field, e.g. \"under development\")
   * @return mlsStatus
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (MLSSTAT) 27. The status of an accession with regards to the Multilateral System (MLS) of the International Treaty on Plant Genetic Resources for Food and Agriculture. Leave the value empty if the status is not known 0 No (not included) 1 Yes (included) 99 Other (elaborate in REMARKS field, e.g. \"under development\")")


  public MlsStatusEnum getMlsStatus() {
    return mlsStatus;
  }

  public void setMlsStatus(MlsStatusEnum mlsStatus) {
    this.mlsStatus = mlsStatus;
  }

  public GermplasmMCPD remarks(String remarks) {
    this.remarks = remarks;
    return this;
  }

  /**
   * MCPD (v2.1) (REMARKS) 28. The remarks field is used to add notes or to elaborate on descriptors with value 99 or 999 (= Other). Prefix remarks with the field name they refer to and a colon (:) without space (e.g. COLLSRC:riverside). Distinct remarks referring to different fields are separated by semicolons without space.
   * @return remarks
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (REMARKS) 28. The remarks field is used to add notes or to elaborate on descriptors with value 99 or 999 (= Other). Prefix remarks with the field name they refer to and a colon (:) without space (e.g. COLLSRC:riverside). Distinct remarks referring to different fields are separated by semicolons without space.")


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public GermplasmMCPD safetyDuplicateInstitues(List<GermplasmMCPDSafetyDuplicateInstitues> safetyDuplicateInstitues) {
    this.safetyDuplicateInstitues = safetyDuplicateInstitues;
    return this;
  }

  public GermplasmMCPD addSafetyDuplicateInstituesItem(GermplasmMCPDSafetyDuplicateInstitues safetyDuplicateInstituesItem) {
    if (this.safetyDuplicateInstitues == null) {
      this.safetyDuplicateInstitues = new ArrayList<GermplasmMCPDSafetyDuplicateInstitues>();
    }
    this.safetyDuplicateInstitues.add(safetyDuplicateInstituesItem);
    return this;
  }

  /**
   * Get safetyDuplicateInstitues
   * @return safetyDuplicateInstitues
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<GermplasmMCPDSafetyDuplicateInstitues> getSafetyDuplicateInstitues() {
    return safetyDuplicateInstitues;
  }

  public void setSafetyDuplicateInstitues(List<GermplasmMCPDSafetyDuplicateInstitues> safetyDuplicateInstitues) {
    this.safetyDuplicateInstitues = safetyDuplicateInstitues;
  }

  public GermplasmMCPD species(String species) {
    this.species = species;
    return this;
  }

  /**
   * MCPD (v2.1) (SPECIES) 6. Specific epithet portion of the scientific name in lowercase letters. Only the following abbreviation is allowed: \"sp.\" 
   * @return species
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (SPECIES) 6. Specific epithet portion of the scientific name in lowercase letters. Only the following abbreviation is allowed: \"sp.\" ")


  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public GermplasmMCPD speciesAuthority(String speciesAuthority) {
    this.speciesAuthority = speciesAuthority;
    return this;
  }

  /**
   * MCPD (v2.1) (SPAUTHOR) 7. Provide the authority for the species name.
   * @return speciesAuthority
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (SPAUTHOR) 7. Provide the authority for the species name.")


  public String getSpeciesAuthority() {
    return speciesAuthority;
  }

  public void setSpeciesAuthority(String speciesAuthority) {
    this.speciesAuthority = speciesAuthority;
  }

  public GermplasmMCPD storageTypeCodes(List<StorageTypeCodesEnum> storageTypeCodes) {
    this.storageTypeCodes = storageTypeCodes;
    return this;
  }

  public GermplasmMCPD addStorageTypeCodesItem(StorageTypeCodesEnum storageTypeCodesItem) {
    if (this.storageTypeCodes == null) {
      this.storageTypeCodes = new ArrayList<StorageTypeCodesEnum>();
    }
    this.storageTypeCodes.add(storageTypeCodesItem);
    return this;
  }

  /**
   * MCPD (v2.1) (STORAGE) 26. If germplasm is maintained under different types of storage, multiple choices are allowed, separated by a semicolon (e.g. 20;30). (Refer to FAO/IPGRI Genebank Standards 1994 for details on storage type.) 10) Seed collection 11) Short term 12) Medium term 13) Long term 20) Field collection 30) In vitro collection 40) Cryopreserved collection 50) DNA collection 99) Other (elaborate in REMARKS field)
   * @return storageTypeCodes
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (STORAGE) 26. If germplasm is maintained under different types of storage, multiple choices are allowed, separated by a semicolon (e.g. 20;30). (Refer to FAO/IPGRI Genebank Standards 1994 for details on storage type.) 10) Seed collection 11) Short term 12) Medium term 13) Long term 20) Field collection 30) In vitro collection 40) Cryopreserved collection 50) DNA collection 99) Other (elaborate in REMARKS field)")


  public List<StorageTypeCodesEnum> getStorageTypeCodes() {
    return storageTypeCodes;
  }

  public void setStorageTypeCodes(List<StorageTypeCodesEnum> storageTypeCodes) {
    this.storageTypeCodes = storageTypeCodes;
  }

  public GermplasmMCPD subtaxon(String subtaxon) {
    this.subtaxon = subtaxon;
    return this;
  }

  /**
   * MCPD (v2.1) (SUBTAXA) 8. Subtaxon can be used to store any additional taxonomic identifier. The following abbreviations are allowed: \"subsp.\" (for subspecies); \"convar.\" (for convariety); \"var.\" (for variety); \"f.\" (for form); \"Group\" (for \"cultivar group\").
   * @return subtaxon
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (SUBTAXA) 8. Subtaxon can be used to store any additional taxonomic identifier. The following abbreviations are allowed: \"subsp.\" (for subspecies); \"convar.\" (for convariety); \"var.\" (for variety); \"f.\" (for form); \"Group\" (for \"cultivar group\").")


  public String getSubtaxon() {
    return subtaxon;
  }

  public void setSubtaxon(String subtaxon) {
    this.subtaxon = subtaxon;
  }

  public GermplasmMCPD subtaxonAuthority(String subtaxonAuthority) {
    this.subtaxonAuthority = subtaxonAuthority;
    return this;
  }

  /**
   * MCPD (v2.1) (SUBTAUTHOR) 9. Provide the subtaxon authority at the most detailed taxonomic level.
   * @return subtaxonAuthority
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (SUBTAUTHOR) 9. Provide the subtaxon authority at the most detailed taxonomic level.")


  public String getSubtaxonAuthority() {
    return subtaxonAuthority;
  }

  public void setSubtaxonAuthority(String subtaxonAuthority) {
    this.subtaxonAuthority = subtaxonAuthority;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GermplasmMCPD germplasmMCPD = (GermplasmMCPD) o;
    return Objects.equals(this.accessionNames, germplasmMCPD.accessionNames) &&
        Objects.equals(this.accessionNumber, germplasmMCPD.accessionNumber) &&
        Objects.equals(this.acquisitionDate, germplasmMCPD.acquisitionDate) &&
        Objects.equals(this.acquisitionSourceCode, germplasmMCPD.acquisitionSourceCode) &&
        Objects.equals(this.alternateIDs, germplasmMCPD.alternateIDs) &&
        Objects.equals(this.ancestralData, germplasmMCPD.ancestralData) &&
        Objects.equals(this.biologicalStatusOfAccessionCode, germplasmMCPD.biologicalStatusOfAccessionCode) &&
        Objects.equals(this.breedingInstitutes, germplasmMCPD.breedingInstitutes) &&
        Objects.equals(this.collectingInfo, germplasmMCPD.collectingInfo) &&
        Objects.equals(this.commonCropName, germplasmMCPD.commonCropName) &&
        Objects.equals(this.countryOfOrigin, germplasmMCPD.countryOfOrigin) &&
        Objects.equals(this.donorInfo, germplasmMCPD.donorInfo) &&
        Objects.equals(this.genus, germplasmMCPD.genus) &&
        Objects.equals(this.germplasmDbId, germplasmMCPD.germplasmDbId) &&
        Objects.equals(this.germplasmPUI, germplasmMCPD.germplasmPUI) &&
        Objects.equals(this.instituteCode, germplasmMCPD.instituteCode) &&
        Objects.equals(this.mlsStatus, germplasmMCPD.mlsStatus) &&
        Objects.equals(this.remarks, germplasmMCPD.remarks) &&
        Objects.equals(this.safetyDuplicateInstitues, germplasmMCPD.safetyDuplicateInstitues) &&
        Objects.equals(this.species, germplasmMCPD.species) &&
        Objects.equals(this.speciesAuthority, germplasmMCPD.speciesAuthority) &&
        Objects.equals(this.storageTypeCodes, germplasmMCPD.storageTypeCodes) &&
        Objects.equals(this.subtaxon, germplasmMCPD.subtaxon) &&
        Objects.equals(this.subtaxonAuthority, germplasmMCPD.subtaxonAuthority);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessionNames, accessionNumber, acquisitionDate, acquisitionSourceCode, alternateIDs, ancestralData, biologicalStatusOfAccessionCode, breedingInstitutes, collectingInfo, commonCropName, countryOfOrigin, donorInfo, genus, germplasmDbId, germplasmPUI, instituteCode, mlsStatus, remarks, safetyDuplicateInstitues, species, speciesAuthority, storageTypeCodes, subtaxon, subtaxonAuthority);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmMCPD {\n");
    
    sb.append("    accessionNames: ").append(toIndentedString(accessionNames)).append("\n");
    sb.append("    accessionNumber: ").append(toIndentedString(accessionNumber)).append("\n");
    sb.append("    acquisitionDate: ").append(toIndentedString(acquisitionDate)).append("\n");
    sb.append("    acquisitionSourceCode: ").append(toIndentedString(acquisitionSourceCode)).append("\n");
    sb.append("    alternateIDs: ").append(toIndentedString(alternateIDs)).append("\n");
    sb.append("    ancestralData: ").append(toIndentedString(ancestralData)).append("\n");
    sb.append("    biologicalStatusOfAccessionCode: ").append(toIndentedString(biologicalStatusOfAccessionCode)).append("\n");
    sb.append("    breedingInstitutes: ").append(toIndentedString(breedingInstitutes)).append("\n");
    sb.append("    collectingInfo: ").append(toIndentedString(collectingInfo)).append("\n");
    sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
    sb.append("    countryOfOrigin: ").append(toIndentedString(countryOfOrigin)).append("\n");
    sb.append("    donorInfo: ").append(toIndentedString(donorInfo)).append("\n");
    sb.append("    genus: ").append(toIndentedString(genus)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    germplasmPUI: ").append(toIndentedString(germplasmPUI)).append("\n");
    sb.append("    instituteCode: ").append(toIndentedString(instituteCode)).append("\n");
    sb.append("    mlsStatus: ").append(toIndentedString(mlsStatus)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
    sb.append("    safetyDuplicateInstitues: ").append(toIndentedString(safetyDuplicateInstitues)).append("\n");
    sb.append("    species: ").append(toIndentedString(species)).append("\n");
    sb.append("    speciesAuthority: ").append(toIndentedString(speciesAuthority)).append("\n");
    sb.append("    storageTypeCodes: ").append(toIndentedString(storageTypeCodes)).append("\n");
    sb.append("    subtaxon: ").append(toIndentedString(subtaxon)).append("\n");
    sb.append("    subtaxonAuthority: ").append(toIndentedString(subtaxonAuthority)).append("\n");
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

