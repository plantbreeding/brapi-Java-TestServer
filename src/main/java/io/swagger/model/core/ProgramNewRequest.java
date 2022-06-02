package io.swagger.model.core;

import java.util.Objects;
import java.util.Optional;

import org.brapi.test.BrAPITestServer.service.UpdateUtility;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ExternalReferences;

import java.util.HashMap;
import java.util.Map;

public class ProgramNewRequest {
	@JsonProperty("abbreviation")
	private Optional<String> abbreviation = null;

	@JsonProperty("additionalInfo")
	private Optional<Map<String, Object>> additionalInfo = null;

	@JsonProperty("commonCropName")
	private Optional<String> commonCropName = null;

	@JsonProperty("documentationURL")
	private Optional<String> documentationURL = null;

	@JsonProperty("externalReferences")
	private Optional<ExternalReferences> externalReferences = null;

	@JsonProperty("leadPersonDbId")
	private Optional<String> leadPersonDbId = null;

	@JsonProperty("leadPersonName")
	private Optional<String> leadPersonName = null;

	@JsonProperty("objective")
	private Optional<String> objective = null;

	@JsonProperty("programName")
	private Optional<String> programName = null;

	@JsonProperty("programType")
	private Optional<String> programType = null;

	@JsonProperty("fundingInformation")
	private Optional<String> fundingInformation = null;

	public ProgramNewRequest abbreviation(String abbreviation) {
		this.abbreviation = UpdateUtility.setField(abbreviation);
		return this;
	}

	/**
	 * An abbreviation which represents this program
	 * 
	 * @return abbreviation
	 **/
	@ApiModelProperty(example = "P1", value = "An abbreviation which represents this program")

	public Optional<String> getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = UpdateUtility.setField(abbreviation);
	}

	public ProgramNewRequest additionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = UpdateUtility.setField(additionalInfo);
		return this;
	}

	public ProgramNewRequest putAdditionalInfoItem(String key, String additionalInfoItem) {
		if (this.additionalInfo == null || !this.additionalInfo.isPresent()) {
			this.additionalInfo = UpdateUtility.setField(new HashMap<String, Object>());
		}
		this.additionalInfo.get().put(key, additionalInfoItem);
		return this;
	}

	/**
	 * Additional arbitrary info
	 * 
	 * @return additionalInfo
	 **/
	@ApiModelProperty(value = "Additional arbitrary info")

	public Optional<Map<String, Object>> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = UpdateUtility.setField(additionalInfo);
	}

	public ProgramNewRequest commonCropName(String commonCropName) {
		this.commonCropName = UpdateUtility.setField(commonCropName);
		return this;
	}

	/**
	 * Common name for the crop which this program is for
	 * 
	 * @return commonCropName
	 **/
	@ApiModelProperty(example = "Tomatillo", value = "Common name for the crop which this program is for")

	public Optional<String> getCommonCropName() {
		return commonCropName;
	}

	public void setCommonCropName(String commonCropName) {
		this.commonCropName = UpdateUtility.setField(commonCropName);
	}

	public ProgramNewRequest documentationURL(String documentationURL) {
		this.documentationURL = UpdateUtility.setField(documentationURL);
		return this;
	}

	/**
	 * A URL to the human readable documentation of this object
	 * 
	 * @return documentationURL
	 **/
	@ApiModelProperty(example = "https://wiki.brapi.org", value = "A URL to the human readable documentation of this object")

	public Optional<String> getDocumentationURL() {
		return documentationURL;
	}

	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = UpdateUtility.setField(documentationURL);
	}

	public ProgramNewRequest externalReferences(ExternalReferences externalReferences) {
		this.externalReferences = UpdateUtility.setField(externalReferences);
		return this;
	}

	/**
	 * Get externalReferences
	 * 
	 * @return externalReferences
	 **/
	@ApiModelProperty(value = "")
	public Optional<ExternalReferences> getExternalReferences() {
		return externalReferences;
	}

	public void setExternalReferences(ExternalReferences externalReferences) {
		this.externalReferences = UpdateUtility.setField(externalReferences);
	}

	public ProgramNewRequest leadPersonDbId(String leadPersonDbId) {
		this.leadPersonDbId = UpdateUtility.setField(leadPersonDbId);
		return this;
	}

	/**
	 * The unique identifier of the program leader
	 * 
	 * @return leadPersonDbId
	 **/
	@ApiModelProperty(example = "fe6f5c50", value = "The unique identifier of the program leader")

	public Optional<String> getLeadPersonDbId() {
		return leadPersonDbId;
	}

	public void setLeadPersonDbId(String leadPersonDbId) {
		this.leadPersonDbId = UpdateUtility.setField(leadPersonDbId);
	}

	public ProgramNewRequest leadPersonName(String leadPersonName) {
		this.leadPersonName = UpdateUtility.setField(leadPersonName);
		return this;
	}

	/**
	 * The name of the program leader
	 * 
	 * @return leadPersonName
	 **/
	@ApiModelProperty(example = "Bob Robertson", value = "The name of the program leader")

	public Optional<String> getLeadPersonName() {
		return leadPersonName;
	}

	public void setLeadPersonName(String leadPersonName) {
		this.leadPersonName = UpdateUtility.setField(leadPersonName);
	}

	public ProgramNewRequest objective(String objective) {
		this.objective = UpdateUtility.setField(objective);
		return this;
	}

	/**
	 * The primary objective of the program
	 * 
	 * @return objective
	 **/
	@ApiModelProperty(example = "Make a better tomatillo", value = "The primary objective of the program")

	public Optional<String> getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = UpdateUtility.setField(objective);
	}

	public ProgramNewRequest programName(String programName) {
		this.programName = UpdateUtility.setField(programName);
		return this;
	}

	/**
	 * Human readable name of the program
	 * 
	 * @return programName
	 **/
	@ApiModelProperty(example = "Tomatillo_Breeding_Program", value = "Human readable name of the program")

	public Optional<String> getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = UpdateUtility.setField(programName);
	}

	public ProgramNewRequest programType(String programType) {
		this.programType = UpdateUtility.setField(programType);
		return this;
	}

	public Optional<String> getProgramType() {
		return programType;
	}

	public void setProgramType(String programType) {
		this.programType = UpdateUtility.setField(programType);
	}

	public ProgramNewRequest fundingInformation(String fundingInformation) {
		this.fundingInformation = UpdateUtility.setField(fundingInformation);
		return this;
	}

	public Optional<String> getFundingInformation() {
		return fundingInformation;
	}

	public void setFundingInformation(String fundingInformation) {
		this.fundingInformation = UpdateUtility.setField(fundingInformation);
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProgramNewRequest programNewRequest = (ProgramNewRequest) o;
		return Objects.equals(this.abbreviation, programNewRequest.abbreviation)
				&& Objects.equals(this.additionalInfo, programNewRequest.additionalInfo)
				&& Objects.equals(this.commonCropName, programNewRequest.commonCropName)
				&& Objects.equals(this.documentationURL, programNewRequest.documentationURL)
				&& Objects.equals(this.externalReferences, programNewRequest.externalReferences)
				&& Objects.equals(this.leadPersonDbId, programNewRequest.leadPersonDbId)
				&& Objects.equals(this.leadPersonName, programNewRequest.leadPersonName)
				&& Objects.equals(this.objective, programNewRequest.objective)
				&& Objects.equals(this.programName, programNewRequest.programName)
				&& Objects.equals(this.programType, programNewRequest.programType)
				&& Objects.equals(this.fundingInformation, programNewRequest.fundingInformation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(abbreviation, additionalInfo, commonCropName, documentationURL, externalReferences,
				leadPersonDbId, leadPersonName, objective, programName, programType, fundingInformation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProgramNewRequest {\n");

		sb.append("    abbreviation: ").append(toIndentedString(abbreviation)).append("\n");
		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
		sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    leadPersonDbId: ").append(toIndentedString(leadPersonDbId)).append("\n");
		sb.append("    leadPersonName: ").append(toIndentedString(leadPersonName)).append("\n");
		sb.append("    objective: ").append(toIndentedString(objective)).append("\n");
		sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
		sb.append("    programType: ").append(toIndentedString(programType)).append("\n");
		sb.append("    fundingInformation: ").append(toIndentedString(fundingInformation)).append("\n");
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
