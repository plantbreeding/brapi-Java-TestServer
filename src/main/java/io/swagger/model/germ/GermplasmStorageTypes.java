package io.swagger.model.germ;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.springframework.validation.annotation.Validated;

/**
 * GermplasmNewRequestStorageTypes
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public enum GermplasmStorageTypes   {
  /**
   * The 2 digit code representing the type of storage this germplasm is kept in at a genebank.   MCPD (v2.1) (STORAGE) 26. If germplasm is maintained under different types of storage, multiple choices are allowed, separated by a semicolon (e.g. 20;30). (Refer to FAO/IPGRI Genebank Standards 1994 for details on storage type.)   10) Seed collection  11) Short term  12) Medium term  13) Long term  20) Field collection  30) In vitro collection  40) Cryo-preserved collection  50) DNA collection  99) Other (elaborate in REMARKS field)
   */
    _10("10", "Seed collection"),    
    _11("11", "Short term"),    
    _12("12", "Medium term"),    
    _13("13", "Long term"),    
    _20("20", "Field collection"),    
    _30("30", "In vitro collection"),    
    _40("40", "Cryo-preserved collection"),    
    _50("50", "DNA collection"),    
    _99("99", "Other");

    private String value;
    private String description;

    GermplasmStorageTypes(String value, String description) {
      this.value = value;
      this.description = description;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GermplasmStorageTypes fromValue(String text) {
      for (GermplasmStorageTypes b : GermplasmStorageTypes.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public String getDescription() {
    return description;
  }

}
