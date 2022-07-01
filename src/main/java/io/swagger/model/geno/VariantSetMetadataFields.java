package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VariantSetMetadataFields {

	@JsonProperty("dataType")
	private DataTypePrimitives dataType = null;

	@JsonProperty("fieldAbbreviation")
	private String fieldAbbreviation = null;

	@JsonProperty("fieldName")
	private String fieldName = null;

	public VariantSetMetadataFields dataType(DataTypePrimitives dataType) {
		this.dataType = dataType;
		return this;
	}

	public DataTypePrimitives getDataType() {
		return dataType;
	}

	public void setDataType(DataTypePrimitives dataType) {
		this.dataType = dataType;
	}

	public VariantSetMetadataFields fieldAbbreviation(String fieldAbbreviation) {
		this.fieldAbbreviation = fieldAbbreviation;
		return this;
	}

	public String getFieldAbbreviation() {
		return fieldAbbreviation;
	}

	public void setFieldAbbreviation(String fieldAbbreviation) {
		this.fieldAbbreviation = fieldAbbreviation;
	}

	public VariantSetMetadataFields fieldName(String fieldName) {
		this.fieldName = fieldName;
		return this;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		VariantSetMetadataFields variantSetMetadataFields = (VariantSetMetadataFields) o;
		return Objects.equals(this.dataType, variantSetMetadataFields.dataType)
				&& Objects.equals(this.fieldAbbreviation, variantSetMetadataFields.fieldAbbreviation)
				&& Objects.equals(this.fieldName, variantSetMetadataFields.fieldName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataType, fieldAbbreviation, fieldName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class VariantSetMetadataFields {\n");

		sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
		sb.append("    fieldAbbreviation: ").append(toIndentedString(fieldAbbreviation)).append("\n");
		sb.append("    fieldName: ").append(toIndentedString(fieldName)).append("\n");
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
