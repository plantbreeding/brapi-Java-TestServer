package org.brapi.test.BrAPITestServer.model.entity.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name="external_reference")
public class ExternalReferenceEntity extends BrAPIBaseEntity{
	@Column
	private String externalReferenceId;
	@Column
	private String externalReferenceSource;
	public String getExternalReferenceId() {
		return externalReferenceId;
	}
	public void setExternalReferenceId(String externalReferenceId) {
		this.externalReferenceId = externalReferenceId;
	}
	public String getExternalReferenceSource() {
		return externalReferenceSource;
	}
	public void setExternalReferenceSource(String externalReferenceSource) {
		this.externalReferenceSource = externalReferenceSource;
	}
	
}
