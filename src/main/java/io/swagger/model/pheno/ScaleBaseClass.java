package io.swagger.model.pheno;

import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;
import io.swagger.model.OntologyReference;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;

public class ScaleBaseClass extends BrAPIDataModel {

	@JsonProperty("dataType")
	private Optional<TraitDataType> dataType = null;

	@JsonProperty("decimalPlaces")
	private Optional<Integer> decimalPlaces = null;

	@JsonProperty("units")
	private Optional<String> units = null;

	@JsonProperty("ontologyReference")
	private Optional<OntologyReference> ontologyReference = null;

	@JsonProperty("scaleName")
	private Optional<String> scaleName = null;

	@JsonProperty("scalePUI")
	private Optional<String> scalePUI = null;

	@JsonProperty("validValues")
	private Optional<ScaleBaseClassValidValues> validValues = null;

	public ScaleBaseClass dataType(TraitDataType dataType) {
		this.dataType = UpdateUtility.setField(dataType);
		return this;
	}

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

	public Optional<Integer> getDecimalPlaces() {
		return decimalPlaces;
	}

	public void setDecimalPlaces(Integer decimalPlaces) {
		this.decimalPlaces = UpdateUtility.setField(decimalPlaces);
	}

	public ScaleBaseClass units(String units) {
		this.units = UpdateUtility.setField(units);
		return this;
	}

	public Optional<String> getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = UpdateUtility.setField(units);
	}

	public ScaleBaseClass ontologyReference(OntologyReference ontologyReference) {
		this.ontologyReference = UpdateUtility.setField(ontologyReference);
		return this;
	}

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

	public ScaleBaseClass scalePUI(String scalePUI) {
		this.scalePUI = UpdateUtility.setField(scalePUI);
		return this;
	}

	public Optional<String> getScalePUI() {
		return scalePUI;
	}

	public void setScalePUI(String scalePUI) {
		this.scalePUI = UpdateUtility.setField(scalePUI);
	}

	public ScaleBaseClass validValues(ScaleBaseClassValidValues validValues) {
		this.validValues = UpdateUtility.setField(validValues);
		return this;
	}

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

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
