package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class AlleleMatrixDataMatrices {
	@JsonProperty("dataMatrix")
	private List<List<String>> dataMatrix = null;

	@JsonProperty("dataMatrixAbbreviation")
	private String dataMatrixAbbreviation = null;

	@JsonProperty("dataMatrixName")
	private String dataMatrixName = null;

	@JsonProperty("dataType")
	private DataTypePrimitives dataType = null;

	public AlleleMatrixDataMatrices dataMatrix(List<List<String>> dataMatrix) {
		this.dataMatrix = dataMatrix;
		return this;
	}

	public AlleleMatrixDataMatrices addDataMatrixItem(List<String> dataMatrixItem) {
		if (this.dataMatrix == null) {
			this.dataMatrix = new ArrayList<List<String>>();
		}
		this.dataMatrix.add(dataMatrixItem);
		return this;
	}

	public List<List<String>> getDataMatrix() {
		return dataMatrix;
	}

	public void setDataMatrix(List<List<String>> dataMatrix) {
		this.dataMatrix = dataMatrix;
	}

	public AlleleMatrixDataMatrices dataMatrixAbbreviation(String dataMatrixAbbreviation) {
		this.dataMatrixAbbreviation = dataMatrixAbbreviation;
		return this;
	}

	public String getDataMatrixAbbreviation() {
		return dataMatrixAbbreviation;
	}

	public void setDataMatrixAbbreviation(String dataMatrixAbbreviation) {
		this.dataMatrixAbbreviation = dataMatrixAbbreviation;
	}

	public AlleleMatrixDataMatrices dataMatrixName(String dataMatrixName) {
		this.dataMatrixName = dataMatrixName;
		return this;
	}

	public String getDataMatrixName() {
		return dataMatrixName;
	}

	public void setDataMatrixName(String dataMatrixName) {
		this.dataMatrixName = dataMatrixName;
	}

	public AlleleMatrixDataMatrices dataType(DataTypePrimitives dataType) {
		this.dataType = dataType;
		return this;
	}

	public DataTypePrimitives getDataType() {
		return dataType;
	}

	public void setDataType(DataTypePrimitives dataType) {
		this.dataType = dataType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AlleleMatrixDataMatrices alleleMatrixDataMatrices = (AlleleMatrixDataMatrices) o;
		return Objects.equals(this.dataMatrix, alleleMatrixDataMatrices.dataMatrix)
				&& Objects.equals(this.dataMatrixAbbreviation, alleleMatrixDataMatrices.dataMatrixAbbreviation)
				&& Objects.equals(this.dataMatrixName, alleleMatrixDataMatrices.dataMatrixName)
				&& Objects.equals(this.dataType, alleleMatrixDataMatrices.dataType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataMatrix, dataMatrixAbbreviation, dataMatrixName, dataType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AlleleMatrixDataMatrices {\n");

		sb.append("    dataMatrix: ").append(toIndentedString(dataMatrix)).append("\n");
		sb.append("    dataMatrixAbbreviation: ").append(toIndentedString(dataMatrixAbbreviation)).append("\n");
		sb.append("    dataMatrixName: ").append(toIndentedString(dataMatrixName)).append("\n");
		sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
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
