package io.swagger.model.germ;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum ParentType {
	MALE("MALE"), FEMALE("FEMALE"), SELF("SELF"), POPULATION("POPULATION"), CLONAL("CLONAL");

	private String value;

	ParentType(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static ParentType fromValue(String text) {
		for (ParentType b : ParentType.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
