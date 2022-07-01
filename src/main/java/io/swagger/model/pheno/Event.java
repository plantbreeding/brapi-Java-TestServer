package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;

import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;

public class Event extends BrAPIDataModel {

	@JsonProperty("date")
	private List<OffsetDateTime> date = null;

	@JsonProperty("eventDateRange")
	private EventDateRange eventDateRange = null;

	@JsonProperty("eventDbId")
	private String eventDbId = null;

	@JsonProperty("eventDescription")
	private String eventDescription = null;

	@JsonProperty("eventParameters")
	private List<EventParameters> eventParameters = null;

	@JsonProperty("eventType")
	private String eventType = null;

	@JsonProperty("eventTypeDbId")
	private String eventTypeDbId = null;

	@JsonProperty("observationUnitDbIds")
	private List<String> observationUnitDbIds = null;

	@JsonProperty("studyDbId")
	private String studyDbId = null;

	@JsonProperty("studyName")
	private String studyName = null;

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public Event date(List<OffsetDateTime> date) {
		this.date = date;
		return this;
	}

	public Event addDateItem(OffsetDateTime dateItem) {
		if (this.date == null) {
			this.date = new ArrayList<OffsetDateTime>();
		}
		this.date.add(dateItem);
		return this;
	}

	public List<OffsetDateTime> getDate() {
		return date;
	}

	public void setDate(List<OffsetDateTime> date) {
		this.date = date;
	}

	public Event eventDateRange(EventDateRange eventDateRange) {
		this.eventDateRange = eventDateRange;
		return this;
	}

	public EventDateRange getEventDateRange() {
		return eventDateRange;
	}

	public void setEventDateRange(EventDateRange eventDateRange) {
		this.eventDateRange = eventDateRange;
	}

	public Event eventDbId(String eventDbId) {
		this.eventDbId = eventDbId;
		return this;
	}

	public String getEventDbId() {
		return eventDbId;
	}

	public void setEventDbId(String eventDbId) {
		this.eventDbId = eventDbId;
	}

	public Event eventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
		return this;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public Event eventParameters(List<EventParameters> eventParameters) {
		this.eventParameters = eventParameters;
		return this;
	}

	public Event addEventParametersItem(EventParameters eventParametersItem) {
		if (this.eventParameters == null) {
			this.eventParameters = new ArrayList<EventParameters>();
		}
		this.eventParameters.add(eventParametersItem);
		return this;
	}

	public List<EventParameters> getEventParameters() {
		return eventParameters;
	}

	public void setEventParameters(List<EventParameters> eventParameters) {
		this.eventParameters = eventParameters;
	}

	public Event eventType(String eventType) {
		this.eventType = eventType;
		return this;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Event eventTypeDbId(String eventTypeDbId) {
		this.eventTypeDbId = eventTypeDbId;
		return this;
	}

	public String getEventTypeDbId() {
		return eventTypeDbId;
	}

	public void setEventTypeDbId(String eventTypeDbId) {
		this.eventTypeDbId = eventTypeDbId;
	}

	public Event observationUnitDbIds(List<String> observationUnitDbIds) {
		this.observationUnitDbIds = observationUnitDbIds;
		return this;
	}

	public Event addObservationUnitDbIdsItem(String observationUnitDbIdsItem) {
		if (this.observationUnitDbIds == null) {
			this.observationUnitDbIds = new ArrayList<String>();
		}
		this.observationUnitDbIds.add(observationUnitDbIdsItem);
		return this;
	}

	public List<String> getObservationUnitDbIds() {
		return observationUnitDbIds;
	}

	public void setObservationUnitDbIds(List<String> observationUnitDbIds) {
		this.observationUnitDbIds = observationUnitDbIds;
	}

	public Event studyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
		return this;
	}

	public String getStudyDbId() {
		return studyDbId;
	}

	public void setStudyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Event event = (Event) o;
		return Objects.equals(this.additionalInfo, event.additionalInfo) && Objects.equals(this.date, event.date)
				&& Objects.equals(this.eventDbId, event.eventDbId)
				&& Objects.equals(this.eventDescription, event.eventDescription)
				&& Objects.equals(this.eventParameters, event.eventParameters)
				&& Objects.equals(this.eventType, event.eventType)
				&& Objects.equals(this.eventTypeDbId, event.eventTypeDbId)
				&& Objects.equals(this.observationUnitDbIds, event.observationUnitDbIds)
				&& Objects.equals(this.studyDbId, event.studyDbId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, date, eventDbId, eventDescription, eventParameters, eventType,
				eventTypeDbId, observationUnitDbIds, studyDbId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Event {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    date: ").append(toIndentedString(date)).append("\n");
		sb.append("    eventDbId: ").append(toIndentedString(eventDbId)).append("\n");
		sb.append("    eventDescription: ").append(toIndentedString(eventDescription)).append("\n");
		sb.append("    eventParameters: ").append(toIndentedString(eventParameters)).append("\n");
		sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
		sb.append("    eventTypeDbId: ").append(toIndentedString(eventTypeDbId)).append("\n");
		sb.append("    observationUnitDbIds: ").append(toIndentedString(observationUnitDbIds)).append("\n");
		sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
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
