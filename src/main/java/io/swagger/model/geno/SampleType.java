package io.swagger.model.geno;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;



public enum SampleType {
	DNA("DNA"),

	RNA("RNA"),

	TISSUE("TISSUE"),

	MIXED("MIXED");

	private String value;

	SampleType(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static SampleType fromValue(String text) {
		for (SampleType b : SampleType.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
