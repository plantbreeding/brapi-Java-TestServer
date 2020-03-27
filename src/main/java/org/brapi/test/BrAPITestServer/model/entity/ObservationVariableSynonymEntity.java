package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="observation_variable_synonym")
public class ObservationVariableSynonymEntity extends BrAPIBaseEntity{
	@Column
	private String observationVariableDbId;
	@Column
	private String synonym;
	public String getObservationVariableDbId() {
		return observationVariableDbId;
	}
	public void setObservationVariableDbId(String observationVariableDbId) {
		this.observationVariableDbId = observationVariableDbId;
	}
	public String getSynonym() {
		return synonym;
	}
	public void setSynonym(String synonym) {
		this.synonym = synonym;
	}
}
