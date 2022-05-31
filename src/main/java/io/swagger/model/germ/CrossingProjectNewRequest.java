package io.swagger.model.germ;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ExternalReferences;

import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * CrossingProjectNewRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class CrossingProjectNewRequest {
	@JsonProperty("additionalInfo")
	@Valid
	private Map<String, Object> additionalInfo = null;

	@JsonProperty("commonCropName")
	private String commonCropName = null;

	@JsonProperty("crossingProjectDescription")
	private String crossingProjectDescription = null;

	@JsonProperty("crossingProjectName")
	private String crossingProjectName = null;

	@JsonProperty("externalReferences")
	private ExternalReferences externalReferences = null;

	@JsonProperty("programDbId")
	private String programDbId = null;

	@JsonProperty("programName")
	private String programName = null;

	public CrossingProjectNewRequest additionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = additionalInfo;
		return this;
	}

	public CrossingProjectNewRequest putAdditionalInfoItem(String key, String additionalInfoItem) {
		if (this.additionalInfo == null) {
			this.additionalInfo = new HashMap<String, Object>();
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

	public Map<String, Object> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public CrossingProjectNewRequest commonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
		return this;
	}

	/**
	 * the common name of a crop (for multi-crop systems)
	 * 
	 * @return commonCropName
	 **/
	@ApiModelProperty(example = "Cassava", value = "the common name of a crop (for multi-crop systems)")

	public String getCommonCropName() {
		return commonCropName;
	}

	public void setCommonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
	}

	public CrossingProjectNewRequest crossingProjectDescription(String crossingProjectDescription) {
		this.crossingProjectDescription = crossingProjectDescription;
		return this;
	}

	/**
	 * the description for a crossing project
	 * 
	 * @return crossingProjectDescription
	 **/
	@ApiModelProperty(example = "Crosses between germplasm X and germplasm Y in male nursery study X_2018 and female nursery study Y_2018", value = "the description for a crossing project")

	public String getCrossingProjectDescription() {
		return crossingProjectDescription;
	}

	public void setCrossingProjectDescription(String crossingProjectDescription) {
		this.crossingProjectDescription = crossingProjectDescription;
	}

	public CrossingProjectNewRequest crossingProjectName(String crossingProjectName) {
		this.crossingProjectName = crossingProjectName;
		return this;
	}

	/**
	 * the human readable name for a crossing project
	 * 
	 * @return crossingProjectName
	 **/
	@ApiModelProperty(example = "Ibadan_Crosses_2018", value = "the human readable name for a crossing project")

	public String getCrossingProjectName() {
		return crossingProjectName;
	}

	public void setCrossingProjectName(String crossingProjectName) {
		this.crossingProjectName = crossingProjectName;
	}

	public CrossingProjectNewRequest externalReferences(ExternalReferences externalReferences) {
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

	public CrossingProjectNewRequest programDbId(String programDbId) {
		this.programDbId = programDbId;
		return this;
	}

	/**
	 * the unique identifier for a program
	 * 
	 * @return programDbId
	 **/
	@ApiModelProperty(example = "a088176c", value = "the unique identifier for a program")

	public String getProgramDbId() {
		return programDbId;
	}

	public void setProgramDbId(String programDbId) {
		this.programDbId = programDbId;
	}

	public CrossingProjectNewRequest programName(String programName) {
		this.programName = programName;
		return this;
	}

	/**
	 * the human readable name for a program
	 * 
	 * @return programName
	 **/
	@ApiModelProperty(example = "IITA Cassava", value = "the human readable name for a program")

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CrossingProjectNewRequest crossingProjectNewRequest = (CrossingProjectNewRequest) o;
		return Objects.equals(this.commonCropName, crossingProjectNewRequest.commonCropName)
				&& Objects.equals(this.crossingProjectDescription, crossingProjectNewRequest.crossingProjectDescription)
				&& Objects.equals(this.crossingProjectName, crossingProjectNewRequest.crossingProjectName)
				&& Objects.equals(this.externalReferences, crossingProjectNewRequest.externalReferences)
				&& Objects.equals(this.programDbId, crossingProjectNewRequest.programDbId)
				&& Objects.equals(this.programName, crossingProjectNewRequest.programName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(commonCropName, crossingProjectDescription, crossingProjectName, externalReferences,
				programDbId, programName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CrossingProjectNewRequest {\n");

		sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
		sb.append("    crossingProjectDescription: ").append(toIndentedString(crossingProjectDescription)).append("\n");
		sb.append("    crossingProjectName: ").append(toIndentedString(crossingProjectName)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    programDbId: ").append(toIndentedString(programDbId)).append("\n");
		sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
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
