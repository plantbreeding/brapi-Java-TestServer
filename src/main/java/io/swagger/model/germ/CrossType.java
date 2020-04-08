package io.swagger.model.germ;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CrossType {
    BIPARENTAL("BIPARENTAL"),
    
    SELF("SELF"),
    
    OPEN_POLLINATED("OPEN_POLLINATED"),
    
    BULK("BULK"),
    
    BULK_SELFED("BULK_SELFED"),
    
    BULK_OPEN_POLLINATED("BULK_OPEN_POLLINATED"),
    
    DOUBLE_HAPLOID("DOUBLE_HAPLOID");

    private String value;

    CrossType(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CrossType fromValue(String text) {
      for (CrossType b : CrossType.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
}
