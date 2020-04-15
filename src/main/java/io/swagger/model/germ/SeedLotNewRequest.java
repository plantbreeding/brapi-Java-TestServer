package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ExternalReferences;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * SeedLotNewRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class SeedLotNewRequest   {
  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("createdDate")
  private OffsetDateTime createdDate = null;

  @JsonProperty("externalReferences")
  private ExternalReferences externalReferences = null;

  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("lastUpdated")
  private OffsetDateTime lastUpdated = null;

  @JsonProperty("locationDbId")
  private String locationDbId = null;

  @JsonProperty("programDbId")
  private String programDbId = null;

  @JsonProperty("seedLotDescription")
  private String seedLotDescription = null;

  @JsonProperty("seedLotName")
  private String seedLotName = null;

  @JsonProperty("sourceCollection")
  private String sourceCollection = null;

  @JsonProperty("storageLocation")
  private String storageLocation = null;

  @JsonProperty("units")
  private String units = null;

  public SeedLotNewRequest additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public SeedLotNewRequest putAdditionalInfoItem(String key, String additionalInfoItem) {
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

  public SeedLotNewRequest amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Current balance of seeds in this lot. Could be a count (seeds, bulbs, etc) or a weight (kg of seed).
   * @return amount
  **/
  @ApiModelProperty(example = "561", value = "Current balance of seeds in this lot. Could be a count (seeds, bulbs, etc) or a weight (kg of seed).")
  
    @Valid
    public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public SeedLotNewRequest createdDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * The time stamp for when this seed lot was created
   * @return createdDate
  **/
  @ApiModelProperty(value = "The time stamp for when this seed lot was created")
  
    @Valid
    public OffsetDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public SeedLotNewRequest externalReferences(ExternalReferences externalReferences) {
    this.externalReferences = externalReferences;
    return this;
  }

  /**
   * Get externalReferences
   * @return externalReferences
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ExternalReferences getExternalReferences() {
    return externalReferences;
  }

  public void setExternalReferences(ExternalReferences externalReferences) {
    this.externalReferences = externalReferences;
  }

  public SeedLotNewRequest germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

  /**
   * Unique DbId of the Germplasm held in this Seed Lot
   * @return germplasmDbId
  **/
  @ApiModelProperty(example = "029d705d", value = "Unique DbId of the Germplasm held in this Seed Lot")
  
    public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public SeedLotNewRequest lastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * The timestamp for the last update to this Seed Lot (including transactions)
   * @return lastUpdated
  **/
  @ApiModelProperty(value = "The timestamp for the last update to this Seed Lot (including transactions)")
  
    @Valid
    public OffsetDateTime getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public SeedLotNewRequest locationDbId(String locationDbId) {
    this.locationDbId = locationDbId;
    return this;
  }

  /**
   * DbId of the storage location
   * @return locationDbId
  **/
  @ApiModelProperty(example = "7989c44c", value = "DbId of the storage location")
  
    public String getLocationDbId() {
    return locationDbId;
  }

  public void setLocationDbId(String locationDbId) {
    this.locationDbId = locationDbId;
  }

  public SeedLotNewRequest programDbId(String programDbId) {
    this.programDbId = programDbId;
    return this;
  }

  /**
   * Unique DbId of the breeding Program this Seed Lot belongs to
   * @return programDbId
  **/
  @ApiModelProperty(example = "e972d569", value = "Unique DbId of the breeding Program this Seed Lot belongs to")
  
    public String getProgramDbId() {
    return programDbId;
  }

  public void setProgramDbId(String programDbId) {
    this.programDbId = programDbId;
  }

  public SeedLotNewRequest seedLotDescription(String seedLotDescription) {
    this.seedLotDescription = seedLotDescription;
    return this;
  }

  /**
   * A general description of this Seed Lot
   * @return seedLotDescription
  **/
  @ApiModelProperty(example = "This is a description of a seed lot", value = "A general description of this Seed Lot")
  
    public String getSeedLotDescription() {
    return seedLotDescription;
  }

  public void setSeedLotDescription(String seedLotDescription) {
    this.seedLotDescription = seedLotDescription;
  }

  public SeedLotNewRequest seedLotName(String seedLotName) {
    this.seedLotName = seedLotName;
    return this;
  }

  /**
   * A human readable name for this Seed Lot
   * @return seedLotName
  **/
  @ApiModelProperty(example = "Seed Lot Alpha", value = "A human readable name for this Seed Lot")
  
    public String getSeedLotName() {
    return seedLotName;
  }

  public void setSeedLotName(String seedLotName) {
    this.seedLotName = seedLotName;
  }

  public SeedLotNewRequest sourceCollection(String sourceCollection) {
    this.sourceCollection = sourceCollection;
    return this;
  }

  /**
   * The description of the source where this material was originally collected (wild, nursery, etc)
   * @return sourceCollection
  **/
  @ApiModelProperty(example = "nursery", value = "The description of the source where this material was originally collected (wild, nursery, etc)")
  
    public String getSourceCollection() {
    return sourceCollection;
  }

  public void setSourceCollection(String sourceCollection) {
    this.sourceCollection = sourceCollection;
  }

  public SeedLotNewRequest storageLocation(String storageLocation) {
    this.storageLocation = storageLocation;
    return this;
  }

  /**
   * Description the storage location
   * @return storageLocation
  **/
  @ApiModelProperty(example = "The storage location is an massive, underground, bunker.", value = "Description the storage location")
  
    public String getStorageLocation() {
    return storageLocation;
  }

  public void setStorageLocation(String storageLocation) {
    this.storageLocation = storageLocation;
  }

  public SeedLotNewRequest units(String units) {
    this.units = units;
    return this;
  }

  /**
   * Description of the things being counted in this Seed Lot (seeds, bulbs, kg, tree, etc)
   * @return units
  **/
  @ApiModelProperty(example = "seeds", value = "Description of the things being counted in this Seed Lot (seeds, bulbs, kg, tree, etc)")
  
    public String getUnits() {
    return units;
  }

  public void setUnits(String units) {
    this.units = units;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SeedLotNewRequest seedLotNewRequest = (SeedLotNewRequest) o;
    return Objects.equals(this.additionalInfo, seedLotNewRequest.additionalInfo) &&
        Objects.equals(this.amount, seedLotNewRequest.amount) &&
        Objects.equals(this.createdDate, seedLotNewRequest.createdDate) &&
        Objects.equals(this.externalReferences, seedLotNewRequest.externalReferences) &&
        Objects.equals(this.germplasmDbId, seedLotNewRequest.germplasmDbId) &&
        Objects.equals(this.lastUpdated, seedLotNewRequest.lastUpdated) &&
        Objects.equals(this.locationDbId, seedLotNewRequest.locationDbId) &&
        Objects.equals(this.programDbId, seedLotNewRequest.programDbId) &&
        Objects.equals(this.seedLotDescription, seedLotNewRequest.seedLotDescription) &&
        Objects.equals(this.seedLotName, seedLotNewRequest.seedLotName) &&
        Objects.equals(this.sourceCollection, seedLotNewRequest.sourceCollection) &&
        Objects.equals(this.storageLocation, seedLotNewRequest.storageLocation) &&
        Objects.equals(this.units, seedLotNewRequest.units);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, amount, createdDate, externalReferences, germplasmDbId, lastUpdated, locationDbId, programDbId, seedLotDescription, seedLotName, sourceCollection, storageLocation, units);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SeedLotNewRequest {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    locationDbId: ").append(toIndentedString(locationDbId)).append("\n");
    sb.append("    programDbId: ").append(toIndentedString(programDbId)).append("\n");
    sb.append("    seedLotDescription: ").append(toIndentedString(seedLotDescription)).append("\n");
    sb.append("    seedLotName: ").append(toIndentedString(seedLotName)).append("\n");
    sb.append("    sourceCollection: ").append(toIndentedString(sourceCollection)).append("\n");
    sb.append("    storageLocation: ").append(toIndentedString(storageLocation)).append("\n");
    sb.append("    units: ").append(toIndentedString(units)).append("\n");
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
