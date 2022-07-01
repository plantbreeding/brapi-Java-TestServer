package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CallGenotypeMetadata {

	@JsonProperty("dataType")
	private DataTypePrimitives dataType = null;

	@JsonProperty("fieldAbbreviation")
	private String fieldAbbreviation = null;

	@JsonProperty("fieldName")
	private String fieldName = null;

	@JsonProperty("fieldValue")
	private String fieldValue = null;

	public CallGenotypeMetadata dataType(DataTypePrimitives dataType) {
		this.dataType = dataType;
		return this;
	}

	public DataTypePrimitives getDataType() {
		return dataType;
	}

	public void setDataType(DataTypePrimitives dataType) {
		this.dataType = dataType;
	}

	public CallGenotypeMetadata fieldAbbreviation(String fieldAbbreviation) {
		this.fieldAbbreviation = fieldAbbreviation;
		return this;
	}

	public String getFieldAbbreviation() {
		return fieldAbbreviation;
	}

	public void setFieldAbbreviation(String fieldAbbreviation) {
		this.fieldAbbreviation = fieldAbbreviation;
	}

	public CallGenotypeMetadata fieldName(String fieldName) {
		this.fieldName = fieldName;
		return this;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public CallGenotypeMetadata fieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
		return this;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CallGenotypeMetadata callGenotypeMetadata = (CallGenotypeMetadata) o;
		return Objects.equals(this.dataType, callGenotypeMetadata.dataType)
				&& Objects.equals(this.fieldAbbreviation, callGenotypeMetadata.fieldAbbreviation)
				&& Objects.equals(this.fieldName, callGenotypeMetadata.fieldName)
				&& Objects.equals(this.fieldValue, callGenotypeMetadata.fieldValue);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataType, fieldAbbreviation, fieldName, fieldValue);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CallGenotypeMetadata {\n");

		sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
		sb.append("    fieldAbbreviation: ").append(toIndentedString(fieldAbbreviation)).append("\n");
		sb.append("    fieldName: ").append(toIndentedString(fieldName)).append("\n");
		sb.append("    fieldValue: ").append(toIndentedString(fieldValue)).append("\n");
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
