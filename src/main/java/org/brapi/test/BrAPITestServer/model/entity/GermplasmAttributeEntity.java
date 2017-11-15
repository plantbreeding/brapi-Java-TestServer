package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="germplasm_attribute")
public class GermplasmAttributeEntity extends BaseEntity{
	@ManyToOne
	private GermplasmAttributeCategoryEntity attributeCategory;
	@Column(name="germplasm_dbid")
	private String germplasmDbId;
	@Column
	private String code;
	@Column
	private String uri;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private String datatype;
	@OneToMany(mappedBy="germplasmAttributeDbId", targetEntity=GermplasmAttributeValueEntity.class)
	private List<GermplasmAttributeValueEntity> values;
	public GermplasmAttributeCategoryEntity getAttributeCategory() {
		return attributeCategory;
	}
	public void setAttributeCategory(GermplasmAttributeCategoryEntity attributeCategory) {
		this.attributeCategory = attributeCategory;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDatatype() {
		return datatype;
	}
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	public List<GermplasmAttributeValueEntity> getValues() {
		return values;
	}
	public void setValues(List<GermplasmAttributeValueEntity> values) {
		this.values = values;
	}
	
}
