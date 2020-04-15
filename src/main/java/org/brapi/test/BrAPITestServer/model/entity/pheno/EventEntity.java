package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;

@Entity
@Table(name = "event")
public class EventEntity extends BrAPIPrimaryEntity {
	@ElementCollection
	private List<Date> dates;
	@Column
	private String eventDescription;
	@OneToMany(mappedBy="event")
	private List<EventParameterEntity> eventParameters;
	@Column
	private String eventType = null;
	@Column
	private String eventTypeDbId = null;
	@ManyToMany
	@JoinTable
	private List<ObservationUnitEntity> observationUnits;
	@ManyToOne
	private StudyEntity study;

	public List<Date> getDates() {
		return dates;
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public List<EventParameterEntity> getEventParameters() {
		return eventParameters;
	}

	public void setEventParameters(List<EventParameterEntity> eventParameters) {
		this.eventParameters = eventParameters;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventTypeDbId() {
		return eventTypeDbId;
	}

	public void setEventTypeDbId(String eventTypeDbId) {
		this.eventTypeDbId = eventTypeDbId;
	}

	public List<ObservationUnitEntity> getObservationUnits() {
		return observationUnits;
	}

	public void setObservationUnits(List<ObservationUnitEntity> observationUnits) {
		this.observationUnits = observationUnits;
	}

	public StudyEntity getStudy() {
		return study;
	}

	public void setStudy(StudyEntity study) {
		this.study = study;
	}

}
