package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * PedigreeNodeSiblings
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class PedigreeNodeSiblings   {
  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("germplasmName")
  private String germplasmName = null;

  public PedigreeNodeSiblings germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

  /**
   * the germplasm DbId of the sibling
   * @return germplasmDbId
  **/
  @ApiModelProperty(value = "the germplasm DbId of the sibling")
  
    public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public PedigreeNodeSiblings germplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
    return this;
  }

  /**
   * the germplasm name of the sibling
   * @return germplasmName
  **/
  @ApiModelProperty(value = "the germplasm name of the sibling")
  
    public String getGermplasmName() {
    return germplasmName;
  }

  public void setGermplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PedigreeNodeSiblings pedigreeNodeSiblings = (PedigreeNodeSiblings) o;
    return Objects.equals(this.germplasmDbId, pedigreeNodeSiblings.germplasmDbId) &&
        Objects.equals(this.germplasmName, pedigreeNodeSiblings.germplasmName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(germplasmDbId, germplasmName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PedigreeNodeSiblings {\n");
    
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
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
