package org.brapi.test.BrAPITestServer.model.entity.pheno;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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


	public enum OntologyReferenceTypeEnum {
		OBO("OBO"),

		RDF("RDF"),

		WEBPAGE("WEBPAGE");

		private String value;

		OntologyReferenceTypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static OntologyReferenceTypeEnum fromValue(String text) {
			for (OntologyReferenceTypeEnum b : OntologyReferenceTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

}