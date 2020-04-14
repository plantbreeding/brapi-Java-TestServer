package io.swagger.model.germ;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BiologicalStatusOfAccessionCode {
    _100("100", "Wild"),
    _110("110", "Natural"),
    _120("120", "Semi-natural/wild"),
    _130("130", "Semi-natural/sown"),
    _200("200", "Weedy"),
    _300("300", "Traditional cultivar/landrace"),
    _400("400", "Breeding/research material"),
    _410("410", "Breeders line"),
    _411("411", "Synthetic population"),
    _412("412", "Hybrid"),
    _413("413", "Founder stock/base population"),
    _414("414", "Inbred line (parent of hybrid cultivar)"),
    _415("415", "Segregating population"),
    _416("416", "Clonal selection"),
    _420("420", "Genetic stock"),
    _421("421", "Mutant (e.g. induced/insertion mutants, tilling populations)"),
    _422("422", "Cytogenetic stocks (e.g. chromosome addition/substitution, aneuploids, amphiploids)"),
    _423("423", "Other genetic stocks (e.g. mapping populations)"),
    _500("500", "Advanced or improved cultivar (conventional breeding methods)"),
    _600("600", "GMO (by genetic engineering)"),
    _999("999", "Other (Elaborate in REMARKS field)");

    private String value;
    private String description;

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	BiologicalStatusOfAccessionCode(String value, String description) {
      this.value = value;
      this.description = description;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static BiologicalStatusOfAccessionCode fromValue(String text) {
      for (BiologicalStatusOfAccessionCode b : BiologicalStatusOfAccessionCode.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
}
