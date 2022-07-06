package io.swagger.model.pheno;

import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import org.brapi.test.BrAPITestServer.service.UpdateUtility;

public class ScaleBaseClassValidValues {
	@JsonProperty("categories")
	private Optional<List<ScaleBaseClassValidValuesCategories>> categories = null;

	@JsonProperty("max")
	private Optional<Integer> max = null;

	@JsonProperty("min")
	private Optional<Integer> min = null;

	@JsonProperty("maximumValue")
	private Optional<String> maximumValue = null;

	@JsonProperty("minimumValue")
	private Optional<String> minimumValue = null;

	public ScaleBaseClassValidValues categories(List<ScaleBaseClassValidValuesCategories> categories) {
		this.categories = UpdateUtility.setField(categories);
		return this;
	}

	public ScaleBaseClassValidValues addCategoriesItem(ScaleBaseClassValidValuesCategories categoriesItem) {
		if (this.categories == null) {
			this.categories = UpdateUtility.setField(new ArrayList<ScaleBaseClassValidValuesCategories>());
		}
		this.categories.get().add(categoriesItem);
		return this;
	}

	public Optional<List<ScaleBaseClassValidValuesCategories>> getCategories() {
		return categories;
	}

	public void setCategories(List<ScaleBaseClassValidValuesCategories> categories) {
		this.categories = UpdateUtility.setField(categories);
	}

	public ScaleBaseClassValidValues max(Integer max) {
		this.max = UpdateUtility.setField(max);
		return this;
	}

	public Optional<Integer> getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = UpdateUtility.setField(max);
	}

	public ScaleBaseClassValidValues min(Integer min) {
		this.min = UpdateUtility.setField(min);
		return this;
	}

	public Optional<Integer> getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = UpdateUtility.setField(min);
	}

	public ScaleBaseClassValidValues maximumValue(String maximumValue) {
		this.maximumValue = UpdateUtility.setField(maximumValue);
		return this;
	}

	public Optional<String> getMaximumValue() {
		return maximumValue;
	}

	public void setMaximumValue(String maximumValue) {
		this.maximumValue = UpdateUtility.setField(maximumValue);
	}

	public ScaleBaseClassValidValues minimumValue(String minimumValue) {
		this.minimumValue = UpdateUtility.setField(minimumValue);
		return this;
	}

	public Optional<String> getMinimumValue() {
		return minimumValue;
	}

	public void setMinimumValue(String minimumValue) {
		this.minimumValue = UpdateUtility.setField(minimumValue);
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ScaleBaseClassValidValues scaleBaseClassValidValues = (ScaleBaseClassValidValues) o;
		return Objects.equals(this.categories, scaleBaseClassValidValues.categories)
				&& Objects.equals(this.max, scaleBaseClassValidValues.max)
				&& Objects.equals(this.min, scaleBaseClassValidValues.min)
				&& Objects.equals(this.maximumValue, scaleBaseClassValidValues.maximumValue)
				&& Objects.equals(this.minimumValue, scaleBaseClassValidValues.minimumValue);
	}

	@Override
	public int hashCode() {
		return Objects.hash(categories, max, min, maximumValue, minimumValue);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ScaleBaseClassValidValues {\n");

		sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
		sb.append("    max: ").append(toIndentedString(max)).append("\n");
		sb.append("    min: ").append(toIndentedString(min)).append("\n");
		sb.append("    maximumValue: ").append(toIndentedString(maximumValue)).append("\n");
		sb.append("    minimumValue: ").append(toIndentedString(minimumValue)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
