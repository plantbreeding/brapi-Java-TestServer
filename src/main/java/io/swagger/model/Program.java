package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Program
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class Program   {
  @JsonProperty("abbreviation")
  private String abbreviation = null;

  @JsonProperty("leadPerson")
  private String leadPerson = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("objective")
  private String objective = null;

  @JsonProperty("programDbId")
  private String programDbId = null;

  public Program abbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
    return this;
  }

   /**
   * An abbreviation which represnts this program
   * @return abbreviation
  **/
  @ApiModelProperty(value = "An abbreviation which represnts this program")


  public String getAbbreviation() {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public Program leadPerson(String leadPerson) {
    this.leadPerson = leadPerson;
    return this;
  }

   /**
   * The name or identifier of the program leader
   * @return leadPerson
  **/
  @ApiModelProperty(value = "The name or identifier of the program leader")


  public String getLeadPerson() {
    return leadPerson;
  }

  public void setLeadPerson(String leadPerson) {
    this.leadPerson = leadPerson;
  }

  public Program name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Human readable name of the program
   * @return name
  **/
  @ApiModelProperty(value = "Human readable name of the program")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Program objective(String objective) {
    this.objective = objective;
    return this;
  }

   /**
   * The primary objective of the program
   * @return objective
  **/
  @ApiModelProperty(value = "The primary objective of the program")


  public String getObjective() {
    return objective;
  }

  public void setObjective(String objective) {
    this.objective = objective;
  }

  public Program programDbId(String programDbId) {
    this.programDbId = programDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies the program
   * @return programDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies the program")


  public String getProgramDbId() {
    return programDbId;
  }

  public void setProgramDbId(String programDbId) {
    this.programDbId = programDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Program program = (Program) o;
    return Objects.equals(this.abbreviation, program.abbreviation) &&
        Objects.equals(this.leadPerson, program.leadPerson) &&
        Objects.equals(this.name, program.name) &&
        Objects.equals(this.objective, program.objective) &&
        Objects.equals(this.programDbId, program.programDbId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(abbreviation, leadPerson, name, objective, programDbId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Program {\n");
    
    sb.append("    abbreviation: ").append(toIndentedString(abbreviation)).append("\n");
    sb.append("    leadPerson: ").append(toIndentedString(leadPerson)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    objective: ").append(toIndentedString(objective)).append("\n");
    sb.append("    programDbId: ").append(toIndentedString(programDbId)).append("\n");
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

