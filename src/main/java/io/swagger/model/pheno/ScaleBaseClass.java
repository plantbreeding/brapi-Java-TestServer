package io.swagger.model.pheno;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ExternalReferences;
import io.swagger.model.OntologyReference;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * Scale metadata
 */
@ApiModel(description = "Scale metadata")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class ScaleBaseClass {
	@JsonProperty("additionalInfo")
	@Valid
	private Optional<Map<String, Object>> additionalInfo = null;
	@JsonProperty("dataType")
	private Optional<TraitDataType> dataType = null;

	@JsonProperty("decimalPlaces")
	private Optional<Integer> decimalPlaces = null;

	@JsonProperty("externalReferences")
	private Optional<ExternalReferences> externalReferences = null;

	@JsonProperty("ontologyReference")
	private Optional<OntologyReference> ontologyReference = null;

	@JsonProperty("scaleName")
	private Optional<String> scaleName = null;

	@JsonProperty("validValues")
	private Optional<ScaleBaseClassValidValues> validValues = null;

	public ScaleBaseClass additionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = UpdateUtility.setField(additionalInfo);
		return this;
	}

	public ScaleBaseClass putAdditionalInfoItem(String key, String additionalInfoItem) {
		if (this.additionalInfo == null) {
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

	public ScaleBaseClass dataType(TraitDataType dataType) {
		this.dataType = UpdateUtility.setField(dataType);
		return this;
	}

	/**
	 * Get dataType
	 * 
	 * @return dataType
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public Optional<TraitDataType> getDataType() {
		return dataType;
	}

	public void setDataType(TraitDataType dataType) {
		this.dataType = UpdateUtility.setField(dataType);
	}

	public ScaleBaseClass decimalPlaces(Integer decimalPlaces) {
		this.decimalPlaces = UpdateUtility.setField(decimalPlaces);
		return this;
	}

	/**
	 * For numerical, number of decimal places to be reported
	 * 
	 * @return decimalPlaces
	 **/
	@ApiModelProperty(example = "2", value = "For numerical, number of decimal places to be reported")

	public Optional<Integer> getDecimalPlaces() {
		return decimalPlaces;
	}

	public void setDecimalPlaces(Integer decimalPlaces) {
		this.decimalPlaces = UpdateUtility.setField(decimalPlaces);
	}

	public ScaleBaseClass externalReferences(ExternalReferences externalReferences) {
		this.externalReferences = UpdateUtility.setField(externalReferences);
		return this;
	}

	/**
	 * Get externalReferences
	 * 
	 * @return externalReferences
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public Optional<ExternalReferences> getExternalReferences() {
		return externalReferences;
	}

	public void setExternalReferences(ExternalReferences externalReferences) {
		this.externalReferences = UpdateUtility.setField(externalReferences);
	}

	public ScaleBaseClass ontologyReference(OntologyReference ontologyReference) {
		this.ontologyReference = UpdateUtility.setField(ontologyReference);
		return this;
	}

	/**
	 * Get ontologyReference
	 * 
	 * @return ontologyReference
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public Optional<OntologyReference> getOntologyReference() {
		return ontologyReference;
	}

	public void setOntologyReference(OntologyReference ontologyReference) {
		this.ontologyReference = UpdateUtility.setField(ontologyReference);
	}

	public ScaleBaseClass scaleName(String scaleName) {
		this.scaleName = UpdateUtility.setField(scaleName);
		return this;
	}

	public Optional<String> getScaleName() {
		return scaleName;
	}

	public void setScaleName(String scaleName) {
		this.scaleName = UpdateUtility.setField(scaleName);
	}

	public ScaleBaseClass validValues(ScaleBaseClassValidValues validValues) {
		this.validValues = UpdateUtility.setField(validValues);
		return this;
	}

	/**
	 * Get validValues
	 * 
	 * @return validValues
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public Optional<ScaleBaseClassValidValues> getValidValues() {
		return validValues;
	}

	public void setValidValues(ScaleBaseClassValidValues validValues) {
		this.validValues = UpdateUtility.setField(validValues);
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ScaleBaseClass scaleBaseClass = (ScaleBaseClass) o;
		return Objects.equals(this.dataType, scaleBaseClass.dataType)
				&& Objects.equals(this.decimalPlaces, scaleBaseClass.decimalPlaces)
				&& Objects.equals(this.externalReferences, scaleBaseClass.externalReferences)
				&& Objects.equals(this.ontologyReference, scaleBaseClass.ontologyReference)
				&& Objects.equals(this.scaleName, scaleBaseClass.scaleName)
				&& Objects.equals(this.validValues, scaleBaseClass.validValues);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataType, decimalPlaces, externalReferences, ontologyReference, scaleName, validValues);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ScaleBaseClass {\n");

		sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
		sb.append("    decimalPlaces: ").append(toIndentedString(decimalPlaces)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    ontologyReference: ").append(toIndentedString(ontologyReference)).append("\n");
		sb.append("    scaleName: ").append(toIndentedString(scaleName)).append("\n");
		sb.append("    validValues: ").append(toIndentedString(validValues)).append("\n");
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
