package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class EventParameters implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("code")
	private String code = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("key")
	private String key = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("rdfValue")
	private String rdfValue = null;

	@JsonProperty("units")
	private String units = null;

	@JsonProperty("value")
	private String value = null;

	@JsonProperty("valueDescription")
	private String valueDescription = null;

	@JsonProperty("valuesByDate")
	private List<String> valuesByDate = null;

	public EventParameters code(String code) {
		this.code = code;
		return this;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public EventParameters description(String description) {
		this.description = description;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EventParameters key(String key) {
		this.key = key;
		return this;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public EventParameters name(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EventParameters rdfValue(String rdfValue) {
		this.rdfValue = rdfValue;
		return this;
	}

	public String getRdfValue() {
		return rdfValue;
	}

	public void setRdfValue(String rdfValue) {
		this.rdfValue = rdfValue;
	}

	public EventParameters units(String units) {
		this.units = units;
		return this;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public EventParameters value(String value) {
		this.value = value;
		return this;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public EventParameters valueDescription(String valueDescription) {
		this.valueDescription = valueDescription;
		return this;
	}

	public String getValueDescription() {
		return valueDescription;
	}

	public void setValueDescription(String valueDescription) {
		this.valueDescription = valueDescription;
	}

	public EventParameters valuesByDate(List<String> valuesByDate) {
		this.valuesByDate = valuesByDate;
		return this;
	}

	public EventParameters addValuesByDateItem(String valuesByDateItem) {
		if (this.valuesByDate == null) {
			this.valuesByDate = new ArrayList<String>();
		}
		this.valuesByDate.add(valuesByDateItem);
		return this;
	}

	public List<String> getValuesByDate() {
		return valuesByDate;
	}

	public void setValuesByDate(List<String> valuesByDate) {
		this.valuesByDate = valuesByDate;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EventParameters eventEventParameters = (EventParameters) o;
		return Objects.equals(this.code, eventEventParameters.code)
				&& Objects.equals(this.description, eventEventParameters.description)
				&& Objects.equals(this.key, eventEventParameters.key)
				&& Objects.equals(this.name, eventEventParameters.name)
				&& Objects.equals(this.rdfValue, eventEventParameters.rdfValue)
				&& Objects.equals(this.units, eventEventParameters.units)
				&& Objects.equals(this.value, eventEventParameters.value)
				&& Objects.equals(this.valueDescription, eventEventParameters.valueDescription)
				&& Objects.equals(this.valuesByDate, eventEventParameters.valuesByDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, description, key, name, rdfValue, units, value, valueDescription, valuesByDate);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EventEventParameters {\n");

		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    key: ").append(toIndentedString(key)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    rdfValue: ").append(toIndentedString(rdfValue)).append("\n");
		sb.append("    units: ").append(toIndentedString(units)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
		sb.append("    valueDescription: ").append(toIndentedString(valueDescription)).append("\n");
		sb.append("    valuesByDate: ").append(toIndentedString(valuesByDate)).append("\n");
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
