package io.swagger.model.pheno;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ExternalReferences;
import io.swagger.model.OntologyReference;
import io.swagger.model.pheno.ScaleBaseClassValidValues;
import io.swagger.model.pheno.TraitDataType;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Scale metadata
 */
@ApiModel(description = "Scale metadata")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class ScaleBaseClass {
	@JsonProperty("additionalInfo")
	@Valid
	private Map<String, Object> additionalInfo = null;
	@JsonProperty("dataType")
	private TraitDataType dataType = null;

	@JsonProperty("decimalPlaces")
	private Integer decimalPlaces = null;

	@JsonProperty("externalReferences")
	private ExternalReferences externalReferences = null;

	@JsonProperty("ontologyReference")
	private OntologyReference ontologyReference = null;

	@JsonProperty("scaleName")
	private String scaleName = null;

	@JsonProperty("validValues")
	private ScaleBaseClassValidValues validValues = null;

	public ScaleBaseClass additionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = additionalInfo;
		return this;
	}

	public ScaleBaseClass putAdditionalInfoItem(String key, String additionalInfoItem) {
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

	public ScaleBaseClass dataType(TraitDataType dataType) {
		this.dataType = dataType;
		return this;
	}

	/**
	 * Get dataType
	 * 
	 * @return dataType
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public TraitDataType getDataType() {
		return dataType;
	}

	public void setDataType(TraitDataType dataType) {
		this.dataType = dataType;
	}

	public ScaleBaseClass decimalPlaces(Integer decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
		return this;
	}

	/**
	 * For numerical, number of decimal places to be reported
	 * 
	 * @return decimalPlaces
	 **/
	@ApiModelProperty(example = "2", value = "For numerical, number of decimal places to be reported")

	public Integer getDecimalPlaces() {
		return decimalPlaces;
	}

	public void setDecimalPlaces(Integer decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}

	public ScaleBaseClass externalReferences(ExternalReferences externalReferences) {
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

	public ScaleBaseClass ontologyReference(OntologyReference ontologyReference) {
		this.ontologyReference = ontologyReference;
		return this;
	}

	/**
	 * Get ontologyReference
	 * 
	 * @return ontologyReference
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public OntologyReference getOntologyReference() {
		return ontologyReference;
	}

	public void setOntologyReference(OntologyReference ontologyReference) {
		this.ontologyReference = ontologyReference;
	}

	public ScaleBaseClass scaleName(String scaleName) {
		this.scaleName = scaleName;
		return this;
	}

	public String getScaleName() {
		return scaleName;
	}

	public void setScaleName(String scaleName) {
		this.scaleName = scaleName;
	}

	public ScaleBaseClass validValues(ScaleBaseClassValidValues validValues) {
		this.validValues = validValues;
		return this;
	}

	/**
	 * Get validValues
	 * 
	 * @return validValues
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public ScaleBaseClassValidValues getValidValues() {
		return validValues;
	}

	public void setValidValues(ScaleBaseClassValidValues validValues) {
		this.validValues = validValues;
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
