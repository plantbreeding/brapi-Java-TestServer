package org.brapi.test.BrAPITestServer.model.entity.pheno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "event_param")
public class EventParameterEntity extends BrAPIBaseEntity {
	@Column
	private String key;
	@Column
	private String rdfValue;
	@Column
	private String value;
	@ManyToOne
	private EventEntity event;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getRdfValue() {
		return rdfValue;
	}

	public void setRdfValue(String rdfValue) {
		this.rdfValue = rdfValue;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public EventEntity getEvent() {
		return event;
	}

	public void setEvent(EventEntity event) {
		this.event = event;
	}
}
