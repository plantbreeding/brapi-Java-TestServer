package org.brapi.test.BrAPITestServer.model.entity.pheno;

import io.swagger.model.OntologyReferenceTypeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "ontology_ref")
public class OntologyReferenceEntity extends BrAPIBaseEntity {
	@Column
	private String URL;
	@Column
	private OntologyReferenceTypeEnum type;

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public OntologyReferenceTypeEnum getType() {
		return type;
	}

	public void setType(OntologyReferenceTypeEnum type) {
		this.type = type;
	}

}