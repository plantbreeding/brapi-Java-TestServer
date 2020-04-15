package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OntologyReferenceTypeEnum {
    OBO("OBO"),
    RDF("RDF"),
    WEBPAGE("WEBPAGE");

    private String value;

    OntologyReferenceTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OntologyReferenceTypeEnum fromValue(String text) {
      for (OntologyReferenceTypeEnum b : OntologyReferenceTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
}
