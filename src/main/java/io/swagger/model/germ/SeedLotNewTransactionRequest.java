package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class SeedLotNewTransactionRequest extends BrAPIDataModel {
	@JsonProperty("amount")
	private BigDecimal amount = null;

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

	public SeedLotNewTransactionRequest amount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public SeedLotNewTransactionRequest fromSeedLotDbId(String fromSeedLotDbId) {
		this.fromSeedLotDbId = fromSeedLotDbId;
		return this;
	}

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
		return Objects.equals(this.additionalInfo, seedLotNewTransactionRequest.additionalInfo)
				&& Objects.equals(this.amount, seedLotNewTransactionRequest.amount)
				&& Objects.equals(this.externalReferences, seedLotNewTransactionRequest.externalReferences)
				&& Objects.equals(this.fromSeedLotDbId, seedLotNewTransactionRequest.fromSeedLotDbId)
				&& Objects.equals(this.toSeedLotDbId, seedLotNewTransactionRequest.toSeedLotDbId)
				&& Objects.equals(this.transactionDescription, seedLotNewTransactionRequest.transactionDescription)
				&& Objects.equals(this.transactionTimestamp, seedLotNewTransactionRequest.transactionTimestamp)
				&& Objects.equals(this.units, seedLotNewTransactionRequest.units);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, amount, externalReferences, fromSeedLotDbId, toSeedLotDbId,
				transactionDescription, transactionTimestamp, units);
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

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
