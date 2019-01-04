package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Class of the scale, entries can be     \"Code\" -  This scale class is exceptionally used to express complex traits. Code is a nominal             scale that combines the expressions of the different traits composing the complex             trait. For exemple a severity trait might be expressed by a 2 digit and 2 character             code. The first 2 digits are the percentage of the plant covered by a fungus and the 2             characters refer to the delay in development, e.g. \"75VD\" means \"75%\" of the plant is              Crop Ontology & Integrated Breeding Platform | Curation Guidelines | 5/6/2016 9             infected and the plant is very delayed.      \"Date\" - The date class is for events expressed in a time format, e.g. yyyymmddThh:mm:ssZ or dd/mm/yy      \"Duration\" - The Duration class is for time elapsed between two events expressed in a time format, e.g. days, hours, months      \"Nominal\" - Categorical scale that can take one of a limited and fixed number of categories. There is no intrinsic ordering to the categories      \"Numerical\" - Numerical scales express the trait with real numbers. The numerical scale defines the unit e.g. centimeter, ton per hectar, branches      \"Ordinal\" - Ordinal scales are scales composed of ordered categories      \"Text\" - A free text is used to express the trait.   
 */
public enum TraitDataType {
  
  CODE("Code"),
  
  DURATION("Duration"),
  
  NOMINAL("Nominal"),
  
  NUMERICAL("Numerical"),
  
  ORDINAL("Ordinal"),
  
  TEXT("Text"),
  
  DATE("Date");

  private String value;

  TraitDataType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static TraitDataType fromValue(String text) {
    for (TraitDataType b : TraitDataType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

