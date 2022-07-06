package io.swagger.model.geno;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.WSMIMEDataTypes;

public class VariantSetAvailableFormats {

	@JsonProperty("dataFormat")
	private GenoFileDataFormatEnum dataFormat = null;

	@JsonProperty("fileFormat")
	private WSMIMEDataTypes fileFormat = null;

	@JsonProperty("fileURL")
	private String fileURL = null;

	@JsonProperty("expandHomozygotes")
	private Boolean expandHomozygotes = null;

	@JsonProperty("sepPhased")
	private String sepPhased = null;

	@JsonProperty("sepUnphased")
	private String sepUnphased = null;

	@JsonProperty("unknownString")
	private String unknownString = null;

	public Boolean getExpandHomozygotes() {
		return expandHomozygotes;
	}

	public void setExpandHomozygotes(Boolean expandHomozygotes) {
		this.expandHomozygotes = expandHomozygotes;
	}

	public String getSepPhased() {
		return sepPhased;
	}

	public void setSepPhased(String sepPhased) {
		this.sepPhased = sepPhased;
	}

	public String getSepUnphased() {
		return sepUnphased;
	}

	public void setSepUnphased(String sepUnphased) {
		this.sepUnphased = sepUnphased;
	}

	public String getUnknownString() {
		return unknownString;
	}

	public void setUnknownString(String unknownString) {
		this.unknownString = unknownString;
	}

	public VariantSetAvailableFormats dataFormat(GenoFileDataFormatEnum dataFormat) {
		this.dataFormat = dataFormat;
		return this;
	}

	public GenoFileDataFormatEnum getDataFormat() {
		return dataFormat;
	}

	public void setDataFormat(GenoFileDataFormatEnum dataFormat) {
		this.dataFormat = dataFormat;
	}

	public VariantSetAvailableFormats fileFormat(WSMIMEDataTypes fileFormat) {
		this.fileFormat = fileFormat;
		return this;
	}

	public WSMIMEDataTypes getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(WSMIMEDataTypes fileFormat) {
		this.fileFormat = fileFormat;
	}

	public VariantSetAvailableFormats fileURL(String fileURL) {
		this.fileURL = fileURL;
		return this;
	}

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		VariantSetAvailableFormats variantSetAvailableFormats = (VariantSetAvailableFormats) o;
		return Objects.equals(this.dataFormat, variantSetAvailableFormats.dataFormat)
				&& Objects.equals(this.fileFormat, variantSetAvailableFormats.fileFormat)
				&& Objects.equals(this.fileURL, variantSetAvailableFormats.fileURL);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataFormat, fileFormat, fileURL);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class VariantSetAvailableFormats {\n");

		sb.append("    dataFormat: ").append(toIndentedString(dataFormat)).append("\n");
		sb.append("    fileFormat: ").append(toIndentedString(fileFormat)).append("\n");
		sb.append("    fileURL: ").append(toIndentedString(fileURL)).append("\n");
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
