package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.BrAPIDataModel;

public class PlateNewRequest extends BrAPIDataModel {

	@JsonProperty("plateBarcode")
	private String plateBarcode = null;

	@JsonProperty("plateFormat")
	private PlateFormat plateFormat = null;

	@JsonProperty("plateName")
	private String plateName = null;

	@JsonProperty("programDbId")
	private String programDbId = null;

	@JsonProperty("sampleType")
	private SampleType sampleType = null;

	@JsonProperty("studyDbId")
	private String studyDbId = null;

	@JsonProperty("trialDbId")
	private String trialDbId = null;

	public PlateNewRequest plateBarcode(String plateBarcode) {
		this.plateBarcode = plateBarcode;
		return this;
	}

	public String getPlateBarcode() {
		return plateBarcode;
	}

	public void setPlateBarcode(String plateBarcode) {
		this.plateBarcode = plateBarcode;
	}

	public PlateNewRequest plateFormat(PlateFormat plateFormat) {
		this.plateFormat = plateFormat;
		return this;
	}

	public PlateFormat getPlateFormat() {
		return plateFormat;
	}

	public void setPlateFormat(PlateFormat plateFormat) {
		this.plateFormat = plateFormat;
	}

	public PlateNewRequest plateName(String plateName) {
		this.plateName = plateName;
		return this;
	}

	public String getPlateName() {
		return plateName;
	}

	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}

	public PlateNewRequest programDbId(String programDbId) {
		this.programDbId = programDbId;
		return this;
	}

	public String getProgramDbId() {
		return programDbId;
	}

	public void setProgramDbId(String programDbId) {
		this.programDbId = programDbId;
	}

	public PlateNewRequest sampleType(SampleType sampleType) {
		this.sampleType = sampleType;
		return this;
	}

	public SampleType getSampleType() {
		return sampleType;
	}

	public void setSampleType(SampleType sampleType) {
		this.sampleType = sampleType;
	}

	public PlateNewRequest studyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
		return this;
	}

	public String getStudyDbId() {
		return studyDbId;
	}

	public void setStudyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
	}

	public PlateNewRequest trialDbId(String trialDbId) {
		this.trialDbId = trialDbId;
		return this;
	}

	public String getTrialDbId() {
		return trialDbId;
	}

	public void setTrialDbId(String trialDbId) {
		this.trialDbId = trialDbId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PlateNewRequest plateNewRequest = (PlateNewRequest) o;
		return Objects.equals(this.additionalInfo, plateNewRequest.additionalInfo)
				&& Objects.equals(this.externalReferences, plateNewRequest.externalReferences)
				&& Objects.equals(this.plateBarcode, plateNewRequest.plateBarcode)
				&& Objects.equals(this.plateFormat, plateNewRequest.plateFormat)
				&& Objects.equals(this.plateName, plateNewRequest.plateName)
				&& Objects.equals(this.programDbId, plateNewRequest.programDbId)
				&& Objects.equals(this.sampleType, plateNewRequest.sampleType)
				&& Objects.equals(this.studyDbId, plateNewRequest.studyDbId)
				&& Objects.equals(this.trialDbId, plateNewRequest.trialDbId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, externalReferences, plateBarcode, plateFormat, plateName, programDbId,
				sampleType, studyDbId, trialDbId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PlateNewRequest {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    plateBarcode: ").append(toIndentedString(plateBarcode)).append("\n");
		sb.append("    plateFormat: ").append(toIndentedString(plateFormat)).append("\n");
		sb.append("    plateName: ").append(toIndentedString(plateName)).append("\n");
		sb.append("    programDbId: ").append(toIndentedString(programDbId)).append("\n");
		sb.append("    sampleType: ").append(toIndentedString(sampleType)).append("\n");
		sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
		sb.append("    trialDbId: ").append(toIndentedString(trialDbId)).append("\n");
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
