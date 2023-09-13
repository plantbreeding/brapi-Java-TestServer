package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.List;

import javax.persistence.*;

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
	@Column
	private String code;
	@Column
	private String description;
	@Column
	private String name;
	@Column
	private String units;
	@Column
	private String valueDescription;
	@ElementCollection
	private List<String> valuesByDate;
	@ManyToOne(fetch = FetchType.LAZY)
	private EventEntity event;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getValueDescription() {
		return valueDescription;
	}

	public void setValueDescription(String valueDescription) {
		this.valueDescription = valueDescription;
	}

	public List<String> getValuesByDate() {
		return valuesByDate;
	}

	public void setValuesByDate(List<String> valuesByDate) {
		this.valuesByDate = valuesByDate;
	}

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
