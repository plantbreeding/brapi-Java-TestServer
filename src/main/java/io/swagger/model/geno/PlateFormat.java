package io.swagger.model.geno;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;



/**
 * Enum for plate formats, usually \"PLATE_96\" for a 96 well plate or \"TUBES\" for plateless format
 */
public enum PlateFormat {
  PLATE_96("PLATE_96"),
    TUBES("TUBES");

  private String value;

  PlateFormat(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static PlateFormat fromValue(String text) {
    for (PlateFormat b : PlateFormat.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
