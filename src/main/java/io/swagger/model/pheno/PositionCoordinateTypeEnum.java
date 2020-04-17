package io.swagger.model.pheno;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PositionCoordinateTypeEnum {
    LONGITUDE("LONGITUDE"),
    LATITUDE("LATITUDE"),
    PLANTED_ROW("PLANTED_ROW"),
    PLANTED_INDIVIDUAL("PLANTED_INDIVIDUAL"),
    GRID_ROW("GRID_ROW"),
    GRID_COL("GRID_COL"),
    MEASURED_ROW("MEASURED_ROW"),
    MEASURED_COL("MEASURED_COL");

    private String value;

    PositionCoordinateTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PositionCoordinateTypeEnum fromValue(String text) {
      for (PositionCoordinateTypeEnum b : PositionCoordinateTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
}
