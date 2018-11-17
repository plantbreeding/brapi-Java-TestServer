package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="scale_valid_value_category")
public class ScaleValidValueCategoryEntity extends BaseEntity{
	@Column
	private String scaleDbId;
	@Column
	private String category;

	public String getScaleDbId() {
		return scaleDbId;
	}
	public void setScaleDbId(String scaleDbId) {
		this.scaleDbId = scaleDbId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
