package io.swagger.model.germ;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ExternalReferences;
import io.swagger.model.germ.CrossNewRequestCrossAttributes;
import io.swagger.model.germ.CrossParent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * CrossNewRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class CrossNewRequest {
	@JsonProperty("additionalInfo")
	@Valid
	private Map<String, String> additionalInfo = null;

	@JsonProperty("crossAttributes")
	@Valid
	private List<CrossNewRequestCrossAttributes> crossAttributes = null;

	@JsonProperty("crossName")
	private String crossName = null;

	@JsonProperty("crossType")
	private CrossType crossType = null;

	@JsonProperty("crossingProjectDbId")
	private String crossingProjectDbId = null;

	@JsonProperty("crossingProjectName")
	private String crossingProjectName = null;

	@JsonProperty("externalReferences")
	private ExternalReferences externalReferences = null;

	@JsonProperty("parent1")
	private CrossParent parent1 = null;

	@JsonProperty("parent2")
	private CrossParent parent2 = null;

	@JsonProperty("pollinationTimeStamp")
	private OffsetDateTime pollinationTimeStamp = null;

	public CrossNewRequest additionalInfo(Map<String, String> additionalInfo) {
		this.additionalInfo = additionalInfo;
		return this;
	}

	public CrossNewRequest putAdditionalInfoItem(String key, String additionalInfoItem) {
		if (this.additionalInfo == null) {
			this.additionalInfo = new HashMap<String, String>();
		}
		this.additionalInfo.put(key, additionalInfoItem);
		return this;
	}

	/**
	 * Additional arbitrary info
	 * 
	 * @return additionalInfo
	 **/
	@ApiModelProperty(value = "Additional arbitrary info")

	public Map<String, String> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Map<String, String> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public CrossNewRequest crossAttributes(List<CrossNewRequestCrossAttributes> crossAttributes) {
		this.crossAttributes = crossAttributes;
		return this;
	}

	public CrossNewRequest addCrossAttributesItem(CrossNewRequestCrossAttributes crossAttributesItem) {
		if (this.crossAttributes == null) {
			this.crossAttributes = new ArrayList<CrossNewRequestCrossAttributes>();
		}
		this.crossAttributes.add(crossAttributesItem);
		return this;
	}

	/**
	 * Set of custom attributes associated with a cross
	 * 
	 * @return crossAttributes
	 **/
	@ApiModelProperty(value = "Set of custom attributes associated with a cross")
	@Valid
	public List<CrossNewRequestCrossAttributes> getCrossAttributes() {
		return crossAttributes;
	}

	public void setCrossAttributes(List<CrossNewRequestCrossAttributes> crossAttributes) {
		this.crossAttributes = crossAttributes;
	}

	public CrossNewRequest crossName(String crossName) {
		this.crossName = crossName;
		return this;
	}

	/**
	 * the human readable name for a cross
	 * 
	 * @return crossName
	 **/
	@ApiModelProperty(example = "my_Ibadan_Crosses_2018_01", value = "the human readable name for a cross")

	public String getCrossName() {
		return crossName;
	}

	public void setCrossName(String crossName) {
		this.crossName = crossName;
	}

	public CrossNewRequest crossType(CrossType crossType) {
		this.crossType = crossType;
		return this;
	}

	/**
	 * the type of cross
	 * 
	 * @return crossType
	 **/
	@ApiModelProperty(example = "BIPARENTAL", value = "the type of cross")

	public CrossType getCrossType() {
		return crossType;
	}

	public void setCrossType(CrossType crossType) {
		this.crossType = crossType;
	}

	public CrossNewRequest crossingProjectDbId(String crossingProjectDbId) {
		this.crossingProjectDbId = crossingProjectDbId;
		return this;
	}

	/**
	 * the unique identifier for a crossing project
	 * 
	 * @return crossingProjectDbId
	 **/
	@ApiModelProperty(example = "696d7c92", value = "the unique identifier for a crossing project")

	public String getCrossingProjectDbId() {
		return crossingProjectDbId;
	}

	public void setCrossingProjectDbId(String crossingProjectDbId) {
		this.crossingProjectDbId = crossingProjectDbId;
	}

	public CrossNewRequest crossingProjectName(String crossingProjectName) {
		this.crossingProjectName = crossingProjectName;
		return this;
	}

	/**
	 * the human readable name for a crossing project
	 * 
	 * @return crossingProjectName
	 **/
	@ApiModelProperty(example = "my_Ibadan_Crosses_2018", value = "the human readable name for a crossing project")

	public String getCrossingProjectName() {
		return crossingProjectName;
	}

	public void setCrossingProjectName(String crossingProjectName) {
		this.crossingProjectName = crossingProjectName;
	}

	public CrossNewRequest externalReferences(ExternalReferences externalReferences) {
		this.externalReferences = externalReferences;
		return this;
	}

	/**
	 * Get externalReferences
	 * 
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

	public CrossNewRequest parent1(CrossParent parent1) {
		this.parent1 = parent1;
		return this;
	}

	/**
	 * Get parent1
	 * 
	 * @return parent1
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public CrossParent getParent1() {
		return parent1;
	}

	public void setParent1(CrossParent parent1) {
		this.parent1 = parent1;
	}

	public CrossNewRequest parent2(CrossParent parent2) {
		this.parent2 = parent2;
		return this;
	}

	/**
	 * Get parent2
	 * 
	 * @return parent2
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public CrossParent getParent2() {
		return parent2;
	}

	public void setParent2(CrossParent parent2) {
		this.parent2 = parent2;
	}

	public CrossNewRequest pollinationTimeStamp(OffsetDateTime pollinationTimeStamp) {
		this.pollinationTimeStamp = pollinationTimeStamp;
		return this;
	}

	/**
	 * the timestamp when the pollination took place
	 * 
	 * @return pollinationTimeStamp
	 **/
	@ApiModelProperty(value = "the timestamp when the pollination took place")

	@Valid
	public OffsetDateTime getPollinationTimeStamp() {
		return pollinationTimeStamp;
	}

	public void setPollinationTimeStamp(OffsetDateTime pollinationTimeStamp) {
		this.pollinationTimeStamp = pollinationTimeStamp;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CrossNewRequest crossNewRequest = (CrossNewRequest) o;
		return Objects.equals(this.additionalInfo, crossNewRequest.additionalInfo)
				&& Objects.equals(this.crossAttributes, crossNewRequest.crossAttributes)
				&& Objects.equals(this.crossName, crossNewRequest.crossName)
				&& Objects.equals(this.crossType, crossNewRequest.crossType)
				&& Objects.equals(this.crossingProjectDbId, crossNewRequest.crossingProjectDbId)
				&& Objects.equals(this.crossingProjectName, crossNewRequest.crossingProjectName)
				&& Objects.equals(this.externalReferences, crossNewRequest.externalReferences)
				&& Objects.equals(this.parent1, crossNewRequest.parent1)
				&& Objects.equals(this.parent2, crossNewRequest.parent2)
				&& Objects.equals(this.pollinationTimeStamp, crossNewRequest.pollinationTimeStamp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, crossAttributes, crossName, crossType, crossingProjectDbId,
				crossingProjectName, externalReferences, parent1, parent2, pollinationTimeStamp);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CrossNewRequest {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    crossAttributes: ").append(toIndentedString(crossAttributes)).append("\n");
		sb.append("    crossName: ").append(toIndentedString(crossName)).append("\n");
		sb.append("    crossType: ").append(toIndentedString(crossType)).append("\n");
		sb.append("    crossingProjectDbId: ").append(toIndentedString(crossingProjectDbId)).append("\n");
		sb.append("    crossingProjectName: ").append(toIndentedString(crossingProjectName)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    parent1: ").append(toIndentedString(parent1)).append("\n");
		sb.append("    parent2: ").append(toIndentedString(parent2)).append("\n");
		sb.append("    pollinationTimeStamp: ").append(toIndentedString(pollinationTimeStamp)).append("\n");
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
