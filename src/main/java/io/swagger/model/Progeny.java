package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ProgenyProgeny;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Progeny
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class Progeny   {
  @JsonProperty("defaultDisplayName")
  private String defaultDisplayName = null;

  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("progeny")
  @Valid
  private List<ProgenyProgeny> progeny = null;

  public Progeny defaultDisplayName(String defaultDisplayName) {
    this.defaultDisplayName = defaultDisplayName;
    return this;
  }

  /**
   * A human readable name for a germplasm
   * @return defaultDisplayName
  **/
  @ApiModelProperty(value = "A human readable name for a germplasm")


  public String getDefaultDisplayName() {
    return defaultDisplayName;
  }

  public void setDefaultDisplayName(String defaultDisplayName) {
    this.defaultDisplayName = defaultDisplayName;
  }

  public Progeny germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a germplasm
   * @return germplasmDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a germplasm")


  public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public Progeny progeny(List<ProgenyProgeny> progeny) {
    this.progeny = progeny;
    return this;
  }

  public Progeny addProgenyItem(ProgenyProgeny progenyItem) {
    if (this.progeny == null) {
      this.progeny = new ArrayList<ProgenyProgeny>();
    }
    this.progeny.add(progenyItem);
    return this;
  }

  /**
   * List of germplasm entities which are direct children of this germplasm
   * @return progeny
  **/
  @ApiModelProperty(value = "List of germplasm entities which are direct children of this germplasm")

  @Valid

  public List<ProgenyProgeny> getProgeny() {
    return progeny;
  }

  public void setProgeny(List<ProgenyProgeny> progeny) {
    this.progeny = progeny;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Progeny progeny = (Progeny) o;
    return Objects.equals(this.defaultDisplayName, progeny.defaultDisplayName) &&
        Objects.equals(this.germplasmDbId, progeny.germplasmDbId) &&
        Objects.equals(this.progeny, progeny.progeny);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultDisplayName, germplasmDbId, progeny);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Progeny {\n");
    
    sb.append("    defaultDisplayName: ").append(toIndentedString(defaultDisplayName)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    progeny: ").append(toIndentedString(progeny)).append("\n");
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

