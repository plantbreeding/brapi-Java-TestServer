package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="germplasm_attribute_category")
public class GermplasmAttributeCategoryEntity extends BrAPIBaseEntity{
	@Column
	private String name;
	
	@OneToMany(mappedBy="attributeCategory", targetEntity=GermplasmAttributeDefinitionEntity.class)
	private List<GermplasmAttributeDefinitionEntity> germplasmAttributeEntities;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<GermplasmAttributeDefinitionEntity> getGermplasmAttributeEntities() {
		return germplasmAttributeEntities;
	}
	public void setGermplasmAttributeEntities(List<GermplasmAttributeDefinitionEntity> germplasmAttributeEntities) {
		this.germplasmAttributeEntities = germplasmAttributeEntities;
	}
	
}
