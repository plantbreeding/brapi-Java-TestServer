package io.swagger.model.geno;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum GenoFileDataFormatEnum {
    DARTSEQ("DartSeq"),
    VCF("VCF"),
    HAPMAP("Hapmap"),
    TABULAR("tabular"),
    JSON("JSON");

    private String value;

    GenoFileDataFormatEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GenoFileDataFormatEnum fromValue(String text) {
      for (GenoFileDataFormatEnum b : GenoFileDataFormatEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
}
