package io.swagger.model.geno;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum VendorServicePlatformMarkerTypeEnum {
    FIXED("FIXED"),
    DISCOVERABLE("DISCOVERABLE");

    private String value;

    VendorServicePlatformMarkerTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static VendorServicePlatformMarkerTypeEnum fromValue(String text) {
      for (VendorServicePlatformMarkerTypeEnum b : VendorServicePlatformMarkerTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
}
