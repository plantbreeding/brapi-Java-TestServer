package io.swagger.model.pheno;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ObservationUnitHierarchyLevelEnum {
    STUDY("study"),
    FIELD("field"),
    ENTRY("entry"),
    REP("rep"),
    BLOCK("block"),
    SUB_BLOCK("sub-block"),
    PLOT("plot"),
    SUB_PLOT("sub-plot"),
    PLANT("plant"),
    POT("pot"),
    SAMPLE("sample");

    private String value;

    ObservationUnitHierarchyLevelEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ObservationUnitHierarchyLevelEnum fromValue(String text) {
      for (ObservationUnitHierarchyLevelEnum b : ObservationUnitHierarchyLevelEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
}
