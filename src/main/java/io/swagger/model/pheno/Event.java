package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.pheno.EventEventParameters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;


/**
 * Event
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class Event   {
  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, Object> additionalInfo = null;

  @JsonProperty("date")
  @Valid
  private List<OffsetDateTime> date = null;

  @JsonProperty("eventDbId")
  private String eventDbId = null;

  @JsonProperty("eventDescription")
  private String eventDescription = null;

  @JsonProperty("eventParameters")
  @Valid
  private List<EventEventParameters> eventParameters = null;

  @JsonProperty("eventType")
  private String eventType = null;

  @JsonProperty("eventTypeDbId")
  private String eventTypeDbId = null;

  @JsonProperty("observationUnitDbIds")
  @Valid
  private List<String> observationUnitDbIds = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  public Event additionalInfo(Map<String, Object> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public Event putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = new HashMap<String, Object>();
    }
    this.additionalInfo.put(key, additionalInfoItem);
    return this;
  }

  /**
   * Additional arbitrary info
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Additional arbitrary info")
  
    public Map<String, Object> getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Map<String, Object> additionalInfo) {
    this.additionalInfo = additionalInfo;
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

  /**
   * A list of dates when the event occured  MIAPPE V1.1 (DM-68) Event date - Date and time of the event.
   * @return date
  **/
  @ApiModelProperty(example = "[\"2018-10-08T18:15:11Z\",\"2018-11-09T18:16:12Z\"]", value = "A list of dates when the event occured  MIAPPE V1.1 (DM-68) Event date - Date and time of the event.")
      @Valid
    public List<OffsetDateTime> getDate() {
    return date;
  }

  public void setDate(List<OffsetDateTime> date) {
    this.date = date;
  }

  public Event eventDbId(String eventDbId) {
    this.eventDbId = eventDbId;
    return this;
  }

  /**
   * Internal database identifier
   * @return eventDbId
  **/
  @ApiModelProperty(example = "8566d4cb", required = true, value = "Internal database identifier")
      

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

  /**
   * A detailed, human-readable description of this event  MIAPPE V1.1 (DM-67) Event description - Description of the event, including details such as amount applied and possibly duration of the event. 
   * @return eventDescription
  **/
  @ApiModelProperty(example = "A set of plots was watered", value = "A detailed, human-readable description of this event  MIAPPE V1.1 (DM-67) Event description - Description of the event, including details such as amount applied and possibly duration of the event. ")
  
    public String getEventDescription() {
    return eventDescription;
  }

  public void setEventDescription(String eventDescription) {
    this.eventDescription = eventDescription;
  }

  public Event eventParameters(List<EventEventParameters> eventParameters) {
    this.eventParameters = eventParameters;
    return this;
  }

  public Event addEventParametersItem(EventEventParameters eventParametersItem) {
    if (this.eventParameters == null) {
      this.eventParameters = new ArrayList<EventEventParameters>();
    }
    this.eventParameters.add(eventParametersItem);
    return this;
  }

  /**
   * A list of objects describing additional event parameters. Each of the following accepts a human-readable value or URI
   * @return eventParameters
  **/
  @ApiModelProperty(example = "[{\"key\":\"http://www.example.fr/vocabulary/2018#hasContact,\",\"value\":\"http://www.example.fr/id/agent/marie,\",\"valueRdfType\":\"http://xmlns.com/foaf/0.1/Agent,\"},{\"key\":\"fertilizer\",\"value\":\"nitrogen\"}]", value = "A list of objects describing additional event parameters. Each of the following accepts a human-readable value or URI")
      @Valid
    public List<EventEventParameters> getEventParameters() {
    return eventParameters;
  }

  public void setEventParameters(List<EventEventParameters> eventParameters) {
    this.eventParameters = eventParameters;
  }

  public Event eventType(String eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * General category for this event (e.g. Sowing, Watering, Rain). Each eventType should correspond to exactly one eventTypeDbId, if provided.  MIAPPE V1.1 (DM-65) Event type - Short name of the event.
   * @return eventType
  **/
  @ApiModelProperty(example = "Watering", required = true, value = "General category for this event (e.g. Sowing, Watering, Rain). Each eventType should correspond to exactly one eventTypeDbId, if provided.  MIAPPE V1.1 (DM-65) Event type - Short name of the event.")
      

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

  /**
   * An identifier for this event type, in the form of an ontology class reference  MIAPPE V1.1 (DM-66) Event accession number - Accession number of the event type in a suitable controlled vocabulary (Crop Ontology).
   * @return eventTypeDbId
  **/
  @ApiModelProperty(example = "4e7d691e", value = "An identifier for this event type, in the form of an ontology class reference  MIAPPE V1.1 (DM-66) Event accession number - Accession number of the event type in a suitable controlled vocabulary (Crop Ontology).")
  
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

  /**
   * A list of the affected observation units. If this parameter is not given, it is understood that the event affected all units in the study
   * @return observationUnitDbIds
  **/
  @ApiModelProperty(example = "[\"8439eaff\",\"d7682e7a\",\"305ae51c\"]", value = "A list of the affected observation units. If this parameter is not given, it is understood that the event affected all units in the study")
  
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

  /**
   * The study in which the event occurred
   * @return studyDbId
  **/
  @ApiModelProperty(example = "2cc2001f", value = "The study in which the event occurred")
  
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
    return Objects.equals(this.additionalInfo, event.additionalInfo) &&
        Objects.equals(this.date, event.date) &&
        Objects.equals(this.eventDbId, event.eventDbId) &&
        Objects.equals(this.eventDescription, event.eventDescription) &&
        Objects.equals(this.eventParameters, event.eventParameters) &&
        Objects.equals(this.eventType, event.eventType) &&
        Objects.equals(this.eventTypeDbId, event.eventTypeDbId) &&
        Objects.equals(this.observationUnitDbIds, event.observationUnitDbIds) &&
        Objects.equals(this.studyDbId, event.studyDbId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, date, eventDbId, eventDescription, eventParameters, eventType, eventTypeDbId, observationUnitDbIds, studyDbId);
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
