package org.brapi.test.BrAPITestServer.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="germplasm_attribute_value")
public class GermplasmAttributeValueEntity extends BaseEntity{
	@ManyToOne
	private GermplasmAttributeDefinitionEntity germplasmAttributeDefinition;
	@ManyToOne
	private GermplasmEntity germplasm;
	@Column
	private String value;
	@Column
	private Date determinedDate;
	
	
	public GermplasmAttributeDefinitionEntity getGermplasmAttributeDefinition() {
		return germplasmAttributeDefinition;
	}
	public void setGermplasmAttributeDefinition(GermplasmAttributeDefinitionEntity germplasmAttributeDefinition) {
		this.germplasmAttributeDefinition = germplasmAttributeDefinition;
	}
	public GermplasmEntity getGermplasm() {
		return germplasm;
	}
	public void setGermplasm(GermplasmEntity germplasm) {
		this.germplasm = germplasm;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Date getDeterminedDate() {
		return determinedDate;
	}
	public void setDeterminedDate(Date determinedDate) {
		this.determinedDate = determinedDate;
	}


}
