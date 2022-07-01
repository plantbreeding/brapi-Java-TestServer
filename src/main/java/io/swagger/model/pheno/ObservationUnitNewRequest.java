package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;
import java.util.ArrayList;
import java.util.List;

public class ObservationUnitNewRequest extends BrAPIDataModel {

	@JsonProperty("germplasmDbId")
	private String germplasmDbId = null;

	@JsonProperty("germplasmName")
	private String germplasmName = null;
	
	@JsonProperty("crossDbId")
	private String crossDbId = null;

	@JsonProperty("crossName")
	private String crossName = null;

	@JsonProperty("locationDbId")
	private String locationDbId = null;

	@JsonProperty("locationName")
	private String locationName = null;

	@JsonProperty("observationUnitName")
	private String observationUnitName = null;

	@JsonProperty("observationUnitPUI")
	private String observationUnitPUI = null;

	@JsonProperty("observationUnitPosition")
	private ObservationUnitPosition observationUnitPosition = null;

	@JsonProperty("programDbId")
	private String programDbId = null;

	@JsonProperty("programName")
	private String programName = null;

	@JsonProperty("seedLotDbId")
	private String seedLotDbId = null;

	@JsonProperty("seedLotName")
	private String seedLotName = null;

	@JsonProperty("studyDbId")
	private String studyDbId = null;

	@JsonProperty("studyName")
	private String studyName = null;

	@JsonProperty("treatments")
	private List<ObservationTreatment> treatments = null;

	@JsonProperty("trialDbId")
	private String trialDbId = null;

	@JsonProperty("trialName")
	private String trialName = null;

	public String getCrossDbId() {
		return crossDbId;
	}

	public void setCrossDbId(String crossDbId) {
		this.crossDbId = crossDbId;
	}

	public String getCrossName() {
		return crossName;
	}

	public void setCrossName(String crossName) {
		this.crossName = crossName;
	}

	public String getSeedLotName() {
		return seedLotName;
	}

	public void setSeedLotName(String seedLotName) {
		this.seedLotName = seedLotName;
	}

	public ObservationUnitNewRequest germplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
		return this;
	}

	public String getGermplasmDbId() {
		return germplasmDbId;
	}

	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}

	public ObservationUnitNewRequest germplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
		return this;
	}

	public String getGermplasmName() {
		return germplasmName;
	}

	public void setGermplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
	}

	public ObservationUnitNewRequest locationDbId(String locationDbId) {
		this.locationDbId = locationDbId;
		return this;
	}

	public String getLocationDbId() {
		return locationDbId;
	}

	public void setLocationDbId(String locationDbId) {
		this.locationDbId = locationDbId;
	}

	public ObservationUnitNewRequest locationName(String locationName) {
		this.locationName = locationName;
		return this;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public ObservationUnitNewRequest observationUnitName(String observationUnitName) {
		this.observationUnitName = observationUnitName;
		return this;
	}

	public String getObservationUnitName() {
		return observationUnitName;
	}

	public void setObservationUnitName(String observationUnitName) {
		this.observationUnitName = observationUnitName;
	}

	public ObservationUnitNewRequest observationUnitPUI(String observationUnitPUI) {
		this.observationUnitPUI = observationUnitPUI;
		return this;
	}

	public String getObservationUnitPUI() {
		return observationUnitPUI;
	}

	public void setObservationUnitPUI(String observationUnitPUI) {
		this.observationUnitPUI = observationUnitPUI;
	}

	public ObservationUnitNewRequest observationUnitPosition(ObservationUnitPosition observationUnitPosition) {
		this.observationUnitPosition = observationUnitPosition;
		return this;
	}

	public ObservationUnitPosition getObservationUnitPosition() {
		return observationUnitPosition;
	}

	public void setObservationUnitPosition(ObservationUnitPosition observationUnitPosition) {
		this.observationUnitPosition = observationUnitPosition;
	}

	public ObservationUnitNewRequest programDbId(String programDbId) {
		this.programDbId = programDbId;
		return this;
	}

	public String getProgramDbId() {
		return programDbId;
	}

	public void setProgramDbId(String programDbId) {
		this.programDbId = programDbId;
	}

	public ObservationUnitNewRequest programName(String programName) {
		this.programName = programName;
		return this;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public ObservationUnitNewRequest seedLotDbId(String seedLotDbId) {
		this.seedLotDbId = seedLotDbId;
		return this;
	}

	public String getSeedLotDbId() {
		return seedLotDbId;
	}

	public void setSeedLotDbId(String seedLotDbId) {
		this.seedLotDbId = seedLotDbId;
	}

	public ObservationUnitNewRequest studyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
		return this;
	}

	public String getStudyDbId() {
		return studyDbId;
	}

	public void setStudyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
	}

	public ObservationUnitNewRequest studyName(String studyName) {
		this.studyName = studyName;
		return this;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public ObservationUnitNewRequest treatments(List<ObservationTreatment> treatments) {
		this.treatments = treatments;
		return this;
	}

	public ObservationUnitNewRequest addTreatmentsItem(ObservationTreatment treatmentsItem) {
		if (this.treatments == null) {
			this.treatments = new ArrayList<ObservationTreatment>();
		}
		this.treatments.add(treatmentsItem);
		return this;
	}

	public List<ObservationTreatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<ObservationTreatment> treatments) {
		this.treatments = treatments;
	}

	public ObservationUnitNewRequest trialDbId(String trialDbId) {
		this.trialDbId = trialDbId;
		return this;
	}

	public String getTrialDbId() {
		return trialDbId;
	}

	public void setTrialDbId(String trialDbId) {
		this.trialDbId = trialDbId;
	}

	public ObservationUnitNewRequest trialName(String trialName) {
		this.trialName = trialName;
		return this;
	}

	public String getTrialName() {
		return trialName;
	}

	public void setTrialName(String trialName) {
		this.trialName = trialName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ObservationUnitNewRequest observationUnitNewRequest = (ObservationUnitNewRequest) o;
		return Objects.equals(this.additionalInfo, observationUnitNewRequest.additionalInfo)
				&& Objects.equals(this.externalReferences, observationUnitNewRequest.externalReferences)
				&& Objects.equals(this.germplasmDbId, observationUnitNewRequest.germplasmDbId)
				&& Objects.equals(this.germplasmName, observationUnitNewRequest.germplasmName)
				&& Objects.equals(this.locationDbId, observationUnitNewRequest.locationDbId)
				&& Objects.equals(this.locationName, observationUnitNewRequest.locationName)
				&& Objects.equals(this.observationUnitName, observationUnitNewRequest.observationUnitName)
				&& Objects.equals(this.observationUnitPUI, observationUnitNewRequest.observationUnitPUI)
				&& Objects.equals(this.observationUnitPosition, observationUnitNewRequest.observationUnitPosition)
				&& Objects.equals(this.programDbId, observationUnitNewRequest.programDbId)
				&& Objects.equals(this.programName, observationUnitNewRequest.programName)
				&& Objects.equals(this.seedLotDbId, observationUnitNewRequest.seedLotDbId)
				&& Objects.equals(this.studyDbId, observationUnitNewRequest.studyDbId)
				&& Objects.equals(this.studyName, observationUnitNewRequest.studyName)
				&& Objects.equals(this.treatments, observationUnitNewRequest.treatments)
				&& Objects.equals(this.trialDbId, observationUnitNewRequest.trialDbId)
				&& Objects.equals(this.trialName, observationUnitNewRequest.trialName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, externalReferences, germplasmDbId, germplasmName, locationDbId,
				locationName, observationUnitName, observationUnitPUI, observationUnitPosition, programDbId,
				programName, seedLotDbId, studyDbId, studyName, treatments, trialDbId, trialName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ObservationUnitNewRequest {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
		sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
		sb.append("    locationDbId: ").append(toIndentedString(locationDbId)).append("\n");
		sb.append("    locationName: ").append(toIndentedString(locationName)).append("\n");
		sb.append("    observationUnitName: ").append(toIndentedString(observationUnitName)).append("\n");
		sb.append("    observationUnitPUI: ").append(toIndentedString(observationUnitPUI)).append("\n");
		sb.append("    observationUnitPosition: ").append(toIndentedString(observationUnitPosition)).append("\n");
		sb.append("    programDbId: ").append(toIndentedString(programDbId)).append("\n");
		sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
		sb.append("    seedLotDbId: ").append(toIndentedString(seedLotDbId)).append("\n");
		sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
		sb.append("    studyName: ").append(toIndentedString(studyName)).append("\n");
		sb.append("    treatments: ").append(toIndentedString(treatments)).append("\n");
		sb.append("    trialDbId: ").append(toIndentedString(trialDbId)).append("\n");
		sb.append("    trialName: ").append(toIndentedString(trialName)).append("\n");
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
