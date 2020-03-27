package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="scale_valid_value_category")
public class ScaleValidValueCategoryEntity extends BrAPIBaseEntity{
	@ManyToOne
	private ScaleEntity scale;
	@Column
	private String category;

	public ScaleEntity getScale() {
		return scale;
	}
	public void setScale(ScaleEntity scale) {
		this.scale = scale;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
