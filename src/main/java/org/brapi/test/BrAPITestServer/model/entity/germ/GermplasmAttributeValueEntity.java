package org.brapi.test.BrAPITestServer.model.entity.germ;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

@Entity
@Table(name="germplasm_attribute_value")
public class GermplasmAttributeValueEntity extends BrAPIPrimaryEntity{
	@ManyToOne
	private GermplasmAttributeDefinitionEntity attribute;
	@ManyToOne
	private GermplasmEntity germplasm;
	@Column
	private String value;
	@Column
	private Date determinedDate;
	
	
	public GermplasmAttributeDefinitionEntity getAttribute() {
		return attribute;
	}
	public void setAttribute(GermplasmAttributeDefinitionEntity attribute) {
		this.attribute = attribute;
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
