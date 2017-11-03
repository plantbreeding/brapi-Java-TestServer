package org.brapi.test.BrAPITestServer.model;

import java.util.List;

public class ValidValue {

	private int min;
	private int max;
	private List<String> categories;

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
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
}
