package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="germplasm_attribute_value")
public class GermplasmAttributeValueEntity extends BaseEntity{
	@Column
	private String germplasmAttributeDbId;
	@Column
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getGermplasmAttributeDbId() {
		return germplasmAttributeDbId;
	}

	public void setGermplasmAttributeDbId(String germplasmAttributeDbId) {
		this.germplasmAttributeDbId = germplasmAttributeDbId;
	}

}
