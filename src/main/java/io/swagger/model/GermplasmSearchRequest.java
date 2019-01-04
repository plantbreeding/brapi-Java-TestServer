package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * GermplasmSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class GermplasmSearchRequest   {
  @JsonProperty("accessionNumbers")
  @Valid
  private List<String> accessionNumbers = null;

  @JsonProperty("commonCropNames")
  @Valid
  private List<String> commonCropNames = null;

  @JsonProperty("germplasmDbIds")
  @Valid
  private List<String> germplasmDbIds = null;

  @JsonProperty("germplasmGenus")
  @Valid
  private List<String> germplasmGenus = null;

  @JsonProperty("germplasmNames")
  @Valid
  private List<String> germplasmNames = null;

  @JsonProperty("germplasmPUIs")
  @Valid
  private List<String> germplasmPUIs = null;

  @JsonProperty("germplasmSpecies")
  @Valid
  private List<String> germplasmSpecies = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("pageSize")
  private Integer pageSize = null;

  public GermplasmSearchRequest accessionNumbers(List<String> accessionNumbers) {
    this.accessionNumbers = accessionNumbers;
    return this;
  }

  public GermplasmSearchRequest addAccessionNumbersItem(String accessionNumbersItem) {
    if (this.accessionNumbers == null) {
      this.accessionNumbers = new ArrayList<String>();
    }
    this.accessionNumbers.add(accessionNumbersItem);
    return this;
  }

  /**
   * List unique identifiers for accessions within a genebank
   * @return accessionNumbers
  **/
  @ApiModelProperty(value = "List unique identifiers for accessions within a genebank")


  public List<String> getAccessionNumbers() {
    return accessionNumbers;
  }

  public void setAccessionNumbers(List<String> accessionNumbers) {
    this.accessionNumbers = accessionNumbers;
  }

  public GermplasmSearchRequest commonCropNames(List<String> commonCropNames) {
    this.commonCropNames = commonCropNames;
    return this;
  }

  public GermplasmSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
    if (this.commonCropNames == null) {
      this.commonCropNames = new ArrayList<String>();
    }
    this.commonCropNames.add(commonCropNamesItem);
    return this;
  }

  /**
   * List crops to search by
   * @return commonCropNames
  **/
  @ApiModelProperty(value = "List crops to search by")


  public List<String> getCommonCropNames() {
    return commonCropNames;
  }

  public void setCommonCropNames(List<String> commonCropNames) {
    this.commonCropNames = commonCropNames;
  }

  public GermplasmSearchRequest germplasmDbIds(List<String> germplasmDbIds) {
    this.germplasmDbIds = germplasmDbIds;
    return this;
  }

  public GermplasmSearchRequest addGermplasmDbIdsItem(String germplasmDbIdsItem) {
    if (this.germplasmDbIds == null) {
      this.germplasmDbIds = new ArrayList<String>();
    }
    this.germplasmDbIds.add(germplasmDbIdsItem);
    return this;
  }

  /**
   * List of IDs which uniquely identify germplasm
   * @return germplasmDbIds
  **/
  @ApiModelProperty(value = "List of IDs which uniquely identify germplasm")


  public List<String> getGermplasmDbIds() {
    return germplasmDbIds;
  }

  public void setGermplasmDbIds(List<String> germplasmDbIds) {
    this.germplasmDbIds = germplasmDbIds;
  }

  public GermplasmSearchRequest germplasmGenus(List<String> germplasmGenus) {
    this.germplasmGenus = germplasmGenus;
    return this;
  }

  public GermplasmSearchRequest addGermplasmGenusItem(String germplasmGenusItem) {
    if (this.germplasmGenus == null) {
      this.germplasmGenus = new ArrayList<String>();
    }
    this.germplasmGenus.add(germplasmGenusItem);
    return this;
  }

  /**
   * List of Genus names to identify germplasm
   * @return germplasmGenus
  **/
  @ApiModelProperty(value = "List of Genus names to identify germplasm")


  public List<String> getGermplasmGenus() {
    return germplasmGenus;
  }

  public void setGermplasmGenus(List<String> germplasmGenus) {
    this.germplasmGenus = germplasmGenus;
  }

  public GermplasmSearchRequest germplasmNames(List<String> germplasmNames) {
    this.germplasmNames = germplasmNames;
    return this;
  }

  public GermplasmSearchRequest addGermplasmNamesItem(String germplasmNamesItem) {
    if (this.germplasmNames == null) {
      this.germplasmNames = new ArrayList<String>();
    }
    this.germplasmNames.add(germplasmNamesItem);
    return this;
  }

  /**
   * List of human readable names to identify germplasm
   * @return germplasmNames
  **/
  @ApiModelProperty(value = "List of human readable names to identify germplasm")


  public List<String> getGermplasmNames() {
    return germplasmNames;
  }

  public void setGermplasmNames(List<String> germplasmNames) {
    this.germplasmNames = germplasmNames;
  }

  public GermplasmSearchRequest germplasmPUIs(List<String> germplasmPUIs) {
    this.germplasmPUIs = germplasmPUIs;
    return this;
  }

  public GermplasmSearchRequest addGermplasmPUIsItem(String germplasmPUIsItem) {
    if (this.germplasmPUIs == null) {
      this.germplasmPUIs = new ArrayList<String>();
    }
    this.germplasmPUIs.add(germplasmPUIsItem);
    return this;
  }

  /**
   * List of Permanent Unique Identifiers to identify germplasm
   * @return germplasmPUIs
  **/
  @ApiModelProperty(value = "List of Permanent Unique Identifiers to identify germplasm")


  public List<String> getGermplasmPUIs() {
    return germplasmPUIs;
  }

  public void setGermplasmPUIs(List<String> germplasmPUIs) {
    this.germplasmPUIs = germplasmPUIs;
  }

  public GermplasmSearchRequest germplasmSpecies(List<String> germplasmSpecies) {
    this.germplasmSpecies = germplasmSpecies;
    return this;
  }

  public GermplasmSearchRequest addGermplasmSpeciesItem(String germplasmSpeciesItem) {
    if (this.germplasmSpecies == null) {
      this.germplasmSpecies = new ArrayList<String>();
    }
    this.germplasmSpecies.add(germplasmSpeciesItem);
    return this;
  }

  /**
   * List of Species names to identify germplasm
   * @return germplasmSpecies
  **/
  @ApiModelProperty(value = "List of Species names to identify germplasm")


  public List<String> getGermplasmSpecies() {
    return germplasmSpecies;
  }

  public void setGermplasmSpecies(List<String> germplasmSpecies) {
    this.germplasmSpecies = germplasmSpecies;
  }

  public GermplasmSearchRequest page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Which page of the \"data\" array to return. The page indexing starts at 0 (page=0 will return the first page). Default is 0.
   * @return page
  **/
  @ApiModelProperty(value = "Which page of the \"data\" array to return. The page indexing starts at 0 (page=0 will return the first page). Default is 0.")


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public GermplasmSearchRequest pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * The maximum number of items to return per page of the \"data\" array. Default is 1000.
   * @return pageSize
  **/
  @ApiModelProperty(value = "The maximum number of items to return per page of the \"data\" array. Default is 1000.")


  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GermplasmSearchRequest germplasmSearchRequest = (GermplasmSearchRequest) o;
    return Objects.equals(this.accessionNumbers, germplasmSearchRequest.accessionNumbers) &&
        Objects.equals(this.commonCropNames, germplasmSearchRequest.commonCropNames) &&
        Objects.equals(this.germplasmDbIds, germplasmSearchRequest.germplasmDbIds) &&
        Objects.equals(this.germplasmGenus, germplasmSearchRequest.germplasmGenus) &&
        Objects.equals(this.germplasmNames, germplasmSearchRequest.germplasmNames) &&
        Objects.equals(this.germplasmPUIs, germplasmSearchRequest.germplasmPUIs) &&
        Objects.equals(this.germplasmSpecies, germplasmSearchRequest.germplasmSpecies) &&
        Objects.equals(this.page, germplasmSearchRequest.page) &&
        Objects.equals(this.pageSize, germplasmSearchRequest.pageSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessionNumbers, commonCropNames, germplasmDbIds, germplasmGenus, germplasmNames, germplasmPUIs, germplasmSpecies, page, pageSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmSearchRequest {\n");
    
    sb.append("    accessionNumbers: ").append(toIndentedString(accessionNumbers)).append("\n");
    sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
    sb.append("    germplasmDbIds: ").append(toIndentedString(germplasmDbIds)).append("\n");
    sb.append("    germplasmGenus: ").append(toIndentedString(germplasmGenus)).append("\n");
    sb.append("    germplasmNames: ").append(toIndentedString(germplasmNames)).append("\n");
    sb.append("    germplasmPUIs: ").append(toIndentedString(germplasmPUIs)).append("\n");
    sb.append("    germplasmSpecies: ").append(toIndentedString(germplasmSpecies)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
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

