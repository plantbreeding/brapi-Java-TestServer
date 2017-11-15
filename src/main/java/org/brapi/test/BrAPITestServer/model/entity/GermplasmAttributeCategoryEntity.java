package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="germplasm_attribute_category")
public class GermplasmAttributeCategoryEntity extends BaseEntity{
	@Column
	private String name;
	
	@OneToMany(mappedBy="attributeCategory", targetEntity=GermplasmAttributeEntity.class)
	private List<GermplasmAttributeEntity> germplasmAttributeEntities;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<GermplasmAttributeEntity> getGermplasmAttributeEntities() {
		return germplasmAttributeEntities;
	}
	public void setGermplasmAttributeEntities(List<GermplasmAttributeEntity> germplasmAttributeEntities) {
		this.germplasmAttributeEntities = germplasmAttributeEntities;
	}
	
}
