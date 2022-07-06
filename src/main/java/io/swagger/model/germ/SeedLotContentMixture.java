package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SeedLotContentMixture {
	@JsonProperty("crossDbId")
	private String crossDbId = null;

	@JsonProperty("crossName")
	private String crossName = null;

	@JsonProperty("germplasmDbId")
	private String germplasmDbId = null;

	@JsonProperty("germplasmName")
	private String germplasmName = null;

	@JsonProperty("mixturePercentage")
	private Integer mixturePercentage = null;

	public SeedLotContentMixture crossDbId(String crossDbId) {
		this.crossDbId = crossDbId;
		return this;
	}

	public String getCrossDbId() {
		return crossDbId;
	}

	public void setCrossDbId(String crossDbId) {
		this.crossDbId = crossDbId;
	}

	public SeedLotContentMixture crossName(String crossName) {
		this.crossName = crossName;
		return this;
	}

	public String getCrossName() {
		return crossName;
	}

	public void setCrossName(String crossName) {
		this.crossName = crossName;
	}

	public SeedLotContentMixture germplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
		return this;
	}

	public String getGermplasmDbId() {
		return germplasmDbId;
	}

	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}

	public SeedLotContentMixture germplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
		return this;
	}

	public String getGermplasmName() {
		return germplasmName;
	}

	public void setGermplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
	}

	public SeedLotContentMixture mixturePercentage(Integer mixturePercentage) {
		this.mixturePercentage = mixturePercentage;
		return this;
	}

	public Integer getMixturePercentage() {
		return mixturePercentage;
	}

	public void setMixturePercentage(Integer mixturePercentage) {
		this.mixturePercentage = mixturePercentage;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SeedLotContentMixture seedLotContentMixture = (SeedLotContentMixture) o;
		return Objects.equals(this.crossDbId, seedLotContentMixture.crossDbId)
				&& Objects.equals(this.crossName, seedLotContentMixture.crossName)
				&& Objects.equals(this.germplasmDbId, seedLotContentMixture.germplasmDbId)
				&& Objects.equals(this.germplasmName, seedLotContentMixture.germplasmName)
				&& Objects.equals(this.mixturePercentage, seedLotContentMixture.mixturePercentage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(crossDbId, crossName, germplasmDbId, germplasmName, mixturePercentage);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SeedLotContentMixture {\n");

		sb.append("    crossDbId: ").append(toIndentedString(crossDbId)).append("\n");
		sb.append("    crossName: ").append(toIndentedString(crossName)).append("\n");
		sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
		sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
		sb.append("    mixturePercentage: ").append(toIndentedString(mixturePercentage)).append("\n");
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
