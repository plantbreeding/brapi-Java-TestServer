package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets listTypes
 */
public enum ListTypes {
  
  GERMPLASM("germplasm"),
  
  MARKERS("markers"),
  
  PROGRAMS("programs"),
  
  TRIALS("trials"),
  
  STUDIES("studies"),
  
  OBSERVATIONUNITS("observationUnits"),
  
  OBSERVATIONS("observations"),
  
  OBSERVATIONVARIABLES("observationVariables"),
  
  SAMPLES("samples");

  private String value;

  ListTypes(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ListTypes fromValue(String text) {
    for (ListTypes b : ListTypes.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

