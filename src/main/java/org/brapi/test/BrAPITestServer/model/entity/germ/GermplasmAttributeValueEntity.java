package org.brapi.test.BrAPITestServer.model.entity.germ;

import java.util.Date;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

@Entity
@Table(name="germplasm_attribute_value")
public class GermplasmAttributeValueEntity extends BrAPIPrimaryEntity{
	@ManyToOne(fetch = FetchType.LAZY)
	private GermplasmAttributeDefinitionEntity attribute;
	@ManyToOne(fetch = FetchType.LAZY)
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
