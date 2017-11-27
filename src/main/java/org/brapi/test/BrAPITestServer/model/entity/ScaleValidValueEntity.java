package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="scale_valid_value")
public class ScaleValidValueEntity extends BaseEntity{
	@Column
	private int min;
	@Column
	private int max;
	@OneToMany(mappedBy="scaleValidValueDbId")
	private List<ScaleValidValueCategoryEntity> categories;
	@OneToMany(mappedBy="validValue")
	private List<ScaleEntity> scales;

	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public List<ScaleValidValueCategoryEntity> getCategories() {
		return categories;
	}
	public void setCategories(List<ScaleValidValueCategoryEntity> categories) {
		this.categories = categories;
	}
}
