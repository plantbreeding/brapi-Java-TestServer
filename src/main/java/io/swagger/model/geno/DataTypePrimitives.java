package io.swagger.model.geno;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DataTypePrimitives {
	STRING("string"),

	INTEGER("integer"),

	FLOAT("float"),

	BOOLEAN("boolean");

	private String value;

	DataTypePrimitives(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static DataTypePrimitives fromValue(String text) {
		for (DataTypePrimitives b : DataTypePrimitives.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
