package io.swagger.model.germ;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class SeedLotNewRequest extends BrAPIDataModel {
	@JsonProperty("amount")
	private BigDecimal amount = null;

	@JsonProperty("createdDate")
	private OffsetDateTime createdDate = null;

	@JsonProperty("germplasmDbId")
	private String germplasmDbId = null;

	@JsonProperty("lastUpdated")
	private OffsetDateTime lastUpdated = null;

	@JsonProperty("locationDbId")
	private String locationDbId = null;

	@JsonProperty("locationName")
	private String locationName = null;

	@JsonProperty("programDbId")
	private String programDbId = null;

	@JsonProperty("programName")
	private String programName = null;

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

	@JsonProperty("contentMixture")
	private List<SeedLotContentMixture> contentMixture = null;

	public List<SeedLotContentMixture> getContentMixture() {
		return contentMixture;
	}

	public void setContentMixture(List<SeedLotContentMixture> contentMixture) {
		this.contentMixture = contentMixture;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public SeedLotNewRequest amount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

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

	public OffsetDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(OffsetDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public SeedLotNewRequest germplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
		return this;
	}

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
		return Objects.equals(this.additionalInfo, seedLotNewRequest.additionalInfo)
				&& Objects.equals(this.amount, seedLotNewRequest.amount)
				&& Objects.equals(this.createdDate, seedLotNewRequest.createdDate)
				&& Objects.equals(this.externalReferences, seedLotNewRequest.externalReferences)
				&& Objects.equals(this.germplasmDbId, seedLotNewRequest.germplasmDbId)
				&& Objects.equals(this.lastUpdated, seedLotNewRequest.lastUpdated)
				&& Objects.equals(this.locationDbId, seedLotNewRequest.locationDbId)
				&& Objects.equals(this.programDbId, seedLotNewRequest.programDbId)
				&& Objects.equals(this.seedLotDescription, seedLotNewRequest.seedLotDescription)
				&& Objects.equals(this.seedLotName, seedLotNewRequest.seedLotName)
				&& Objects.equals(this.sourceCollection, seedLotNewRequest.sourceCollection)
				&& Objects.equals(this.storageLocation, seedLotNewRequest.storageLocation)
				&& Objects.equals(this.units, seedLotNewRequest.units);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, amount, createdDate, externalReferences, germplasmDbId, lastUpdated,
				locationDbId, programDbId, seedLotDescription, seedLotName, sourceCollection, storageLocation, units);
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

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
