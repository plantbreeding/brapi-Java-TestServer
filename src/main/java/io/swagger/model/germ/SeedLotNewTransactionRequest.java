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
 * SeedLotNewTransactionRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class SeedLotNewTransactionRequest   {
  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, Object> additionalInfo = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("externalReferences")
  private ExternalReferences externalReferences = null;

  @JsonProperty("fromSeedLotDbId")
  private String fromSeedLotDbId = null;

  @JsonProperty("toSeedLotDbId")
  private String toSeedLotDbId = null;

  @JsonProperty("transactionDescription")
  private String transactionDescription = null;

  @JsonProperty("transactionTimestamp")
  private OffsetDateTime transactionTimestamp = null;

  @JsonProperty("units")
  private String units = null;

  public SeedLotNewTransactionRequest additionalInfo(Map<String, Object> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public SeedLotNewTransactionRequest putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = new HashMap<String, Object>();
    }
    this.additionalInfo.put(key, additionalInfoItem);
    return this;
  }

  /**
   * Additional arbitrary info
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Additional arbitrary info")
  
    public Map<String, Object> getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Map<String, Object> additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public SeedLotNewTransactionRequest amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The amount of units being transfered. Could be a count (seeds, bulbs, etc) or a weight (kg of seed).
   * @return amount
  **/
  @ApiModelProperty(example = "45", value = "The amount of units being transfered. Could be a count (seeds, bulbs, etc) or a weight (kg of seed).")
  
    @Valid
    public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public SeedLotNewTransactionRequest externalReferences(ExternalReferences externalReferences) {
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

  public SeedLotNewTransactionRequest fromSeedLotDbId(String fromSeedLotDbId) {
    this.fromSeedLotDbId = fromSeedLotDbId;
    return this;
  }

  /**
   * The identifier for the Seed Lot being transfered out of
   * @return fromSeedLotDbId
  **/
  @ApiModelProperty(example = "11eef13b", value = "The identifier for the Seed Lot being transfered out of")
  
    public String getFromSeedLotDbId() {
    return fromSeedLotDbId;
  }

  public void setFromSeedLotDbId(String fromSeedLotDbId) {
    this.fromSeedLotDbId = fromSeedLotDbId;
  }

  public SeedLotNewTransactionRequest toSeedLotDbId(String toSeedLotDbId) {
    this.toSeedLotDbId = toSeedLotDbId;
    return this;
  }

  /**
   * The identifier for the Seed Lot being transfered into
   * @return toSeedLotDbId
  **/
  @ApiModelProperty(example = "59339b90", value = "The identifier for the Seed Lot being transfered into")
  
    public String getToSeedLotDbId() {
    return toSeedLotDbId;
  }

  public void setToSeedLotDbId(String toSeedLotDbId) {
    this.toSeedLotDbId = toSeedLotDbId;
  }

  public SeedLotNewTransactionRequest transactionDescription(String transactionDescription) {
    this.transactionDescription = transactionDescription;
    return this;
  }

  /**
   * A general description of this Seed Lot Transaction
   * @return transactionDescription
  **/
  @ApiModelProperty(example = "f9cd88d2", value = "A general description of this Seed Lot Transaction")
  
    public String getTransactionDescription() {
    return transactionDescription;
  }

  public void setTransactionDescription(String transactionDescription) {
    this.transactionDescription = transactionDescription;
  }

  public SeedLotNewTransactionRequest transactionTimestamp(OffsetDateTime transactionTimestamp) {
    this.transactionTimestamp = transactionTimestamp;
    return this;
  }

  /**
   * The time stamp for when the transaction occured
   * @return transactionTimestamp
  **/
  @ApiModelProperty(value = "The time stamp for when the transaction occured")
  
    @Valid
    public OffsetDateTime getTransactionTimestamp() {
    return transactionTimestamp;
  }

  public void setTransactionTimestamp(OffsetDateTime transactionTimestamp) {
    this.transactionTimestamp = transactionTimestamp;
  }

  public SeedLotNewTransactionRequest units(String units) {
    this.units = units;
    return this;
  }

  /**
   * Description of the things being transfered in this transaction (seeds, bulbs, kg, etc)
   * @return units
  **/
  @ApiModelProperty(example = "seeds", value = "Description of the things being transfered in this transaction (seeds, bulbs, kg, etc)")
  
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
    SeedLotNewTransactionRequest seedLotNewTransactionRequest = (SeedLotNewTransactionRequest) o;
    return Objects.equals(this.additionalInfo, seedLotNewTransactionRequest.additionalInfo) &&
        Objects.equals(this.amount, seedLotNewTransactionRequest.amount) &&
        Objects.equals(this.externalReferences, seedLotNewTransactionRequest.externalReferences) &&
        Objects.equals(this.fromSeedLotDbId, seedLotNewTransactionRequest.fromSeedLotDbId) &&
        Objects.equals(this.toSeedLotDbId, seedLotNewTransactionRequest.toSeedLotDbId) &&
        Objects.equals(this.transactionDescription, seedLotNewTransactionRequest.transactionDescription) &&
        Objects.equals(this.transactionTimestamp, seedLotNewTransactionRequest.transactionTimestamp) &&
        Objects.equals(this.units, seedLotNewTransactionRequest.units);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, amount, externalReferences, fromSeedLotDbId, toSeedLotDbId, transactionDescription, transactionTimestamp, units);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SeedLotNewTransactionRequest {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
    sb.append("    fromSeedLotDbId: ").append(toIndentedString(fromSeedLotDbId)).append("\n");
    sb.append("    toSeedLotDbId: ").append(toIndentedString(toSeedLotDbId)).append("\n");
    sb.append("    transactionDescription: ").append(toIndentedString(transactionDescription)).append("\n");
    sb.append("    transactionTimestamp: ").append(toIndentedString(transactionTimestamp)).append("\n");
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
