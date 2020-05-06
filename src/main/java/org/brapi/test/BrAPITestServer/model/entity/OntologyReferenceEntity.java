package org.brapi.test.BrAPITestServer.model.entity;

import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.model.OntologyReferenceDocumentationLinks.TypeEnum;

import com.fasterxml.jackson.annotation.JsonCreator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ontology_ref")
public class OntologyReferenceEntity extends BaseEntity {
	@Column
	private String URL;
	@Column
	private TypeEnum type;
	


	public String getURL() {
		return URL;
	}


	public void setURL(String uRL) {
		URL = uRL;
	}


	public TypeEnum getType() {
		return type;
	}


	public void setType(TypeEnum type) {
		this.type = type;
	}

}