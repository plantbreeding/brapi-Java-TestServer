package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.pheno.TraitBaseClass;

import org.springframework.validation.annotation.Validated;

/**
 * Trait
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class Trait extends TraitBaseClass  {
  @JsonProperty("traitDbId")
  private String traitDbId = null;

  public Trait traitDbId(String traitDbId) {
    this.traitDbId = traitDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a trait
   * @return traitDbId
  **/
  @ApiModelProperty(example = "9b2e34f5", value = "The ID which uniquely identifies a trait")
  
    public String getTraitDbId() {
    return traitDbId;
  }

  public void setTraitDbId(String traitDbId) {
    this.traitDbId = traitDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Trait trait = (Trait) o;
    return Objects.equals(this.traitDbId, trait.traitDbId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(traitDbId, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Trait {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    traitDbId: ").append(toIndentedString(traitDbId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
