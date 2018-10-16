package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * TraitSummary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class TraitSummary   {
  @JsonProperty("defaultValue")
  private String defaultValue = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("observationVariables")
  @Valid
  private List<String> observationVariables = null;

  @JsonProperty("traitDbId")
  private String traitDbId = null;

  @JsonProperty("traitId")
  private String traitId = null;

  public TraitSummary defaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
    return this;
  }

   /**
   * The default value of a trait (if applicable) ex. \"0\", \"\", \"null\"
   * @return defaultValue
  **/
  @ApiModelProperty(value = "The default value of a trait (if applicable) ex. \"0\", \"\", \"null\"")


  public String getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }

  public TraitSummary description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of a trait
   * @return description
  **/
  @ApiModelProperty(value = "The description of a trait")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TraitSummary name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The human readable name of a trait
   * @return name
  **/
  @ApiModelProperty(value = "The human readable name of a trait")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TraitSummary observationVariables(List<String> observationVariables) {
    this.observationVariables = observationVariables;
    return this;
  }

  public TraitSummary addObservationVariablesItem(String observationVariablesItem) {
    if (this.observationVariables == null) {
      this.observationVariables = new ArrayList<String>();
    }
    this.observationVariables.add(observationVariablesItem);
    return this;
  }

   /**
   * List of observation variable DbIds which include this trait
   * @return observationVariables
  **/
  @ApiModelProperty(value = "List of observation variable DbIds which include this trait")


  public List<String> getObservationVariables() {
    return observationVariables;
  }

  public void setObservationVariables(List<String> observationVariables) {
    this.observationVariables = observationVariables;
  }

  public TraitSummary traitDbId(String traitDbId) {
    this.traitDbId = traitDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies a trait
   * @return traitDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a trait")


  public String getTraitDbId() {
    return traitDbId;
  }

  public void setTraitDbId(String traitDbId) {
    this.traitDbId = traitDbId;
  }

  public TraitSummary traitId(String traitId) {
    this.traitId = traitId;
    return this;
  }

   /**
   * <strong>DEPRECATED</strong> The ID which uniquely identifies a trait
   * @return traitId
  **/
  @ApiModelProperty(value = "<strong>DEPRECATED</strong> The ID which uniquely identifies a trait")


  public String getTraitId() {
    return traitId;
  }

  public void setTraitId(String traitId) {
    this.traitId = traitId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TraitSummary traitSummary = (TraitSummary) o;
    return Objects.equals(this.defaultValue, traitSummary.defaultValue) &&
        Objects.equals(this.description, traitSummary.description) &&
        Objects.equals(this.name, traitSummary.name) &&
        Objects.equals(this.observationVariables, traitSummary.observationVariables) &&
        Objects.equals(this.traitDbId, traitSummary.traitDbId) &&
        Objects.equals(this.traitId, traitSummary.traitId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultValue, description, name, observationVariables, traitDbId, traitId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TraitSummary {\n");
    
    sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    observationVariables: ").append(toIndentedString(observationVariables)).append("\n");
    sb.append("    traitDbId: ").append(toIndentedString(traitDbId)).append("\n");
    sb.append("    traitId: ").append(toIndentedString(traitId)).append("\n");
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

