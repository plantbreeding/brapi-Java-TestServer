package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.*;

/**
 * BreedingMethod
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class BreedingMethod   {
  @JsonProperty("abbreviation")
  private String abbreviation = null;

  @JsonProperty("breedingMethodDbId")
  private String breedingMethodDbId = null;

  @JsonProperty("breedingMethodName")
  private String breedingMethodName = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  public BreedingMethod abbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
    return this;
  }

  /**
   * an abbreviation for the name of this breeding method
   * @return abbreviation
  **/
  @ApiModelProperty(value = "an abbreviation for the name of this breeding method")


  public String getAbbreviation() {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public BreedingMethod breedingMethodDbId(String breedingMethodDbId) {
    this.breedingMethodDbId = breedingMethodDbId;
    return this;
  }

  /**
   * the unique identifier for this breeding method
   * @return breedingMethodDbId
  **/
  @ApiModelProperty(required = true, value = "the unique identifier for this breeding method")
  @NotNull


  public String getBreedingMethodDbId() {
    return breedingMethodDbId;
  }

  public void setBreedingMethodDbId(String breedingMethodDbId) {
    this.breedingMethodDbId = breedingMethodDbId;
  }

  public BreedingMethod breedingMethodName(String breedingMethodName) {
    this.breedingMethodName = breedingMethodName;
    return this;
  }

  /**
   * human readable name of the breeding method
   * @return breedingMethodName
  **/
  @ApiModelProperty(value = "human readable name of the breeding method")


  public String getBreedingMethodName() {
    return breedingMethodName;
  }

  public void setBreedingMethodName(String breedingMethodName) {
    this.breedingMethodName = breedingMethodName;
  }

  public BreedingMethod description(String description) {
    this.description = description;
    return this;
  }

  /**
   * human readable description of the breeding method
   * @return description
  **/
  @ApiModelProperty(value = "human readable description of the breeding method")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BreedingMethod name(String name) {
    this.name = name;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - Use \"breedingMethodName\"
   * @return name
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - Use \"breedingMethodName\"")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BreedingMethod breedingMethod = (BreedingMethod) o;
    return Objects.equals(this.abbreviation, breedingMethod.abbreviation) &&
        Objects.equals(this.breedingMethodDbId, breedingMethod.breedingMethodDbId) &&
        Objects.equals(this.breedingMethodName, breedingMethod.breedingMethodName) &&
        Objects.equals(this.description, breedingMethod.description) &&
        Objects.equals(this.name, breedingMethod.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(abbreviation, breedingMethodDbId, breedingMethodName, description, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BreedingMethod {\n");
    
    sb.append("    abbreviation: ").append(toIndentedString(abbreviation)).append("\n");
    sb.append("    breedingMethodDbId: ").append(toIndentedString(breedingMethodDbId)).append("\n");
    sb.append("    breedingMethodName: ").append(toIndentedString(breedingMethodName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

