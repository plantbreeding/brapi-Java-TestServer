package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * GermplasmNewRequestSynonyms
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class GermplasmNewRequestSynonyms   {
  @JsonProperty("synonym")
  private String synonym = null;

  @JsonProperty("type")
  private String type = null;

  public GermplasmNewRequestSynonyms synonym(String synonym) {
    this.synonym = synonym;
    return this;
  }

  /**
   * Alternative name or ID used to reference this germplasm
   * @return synonym
  **/
  @ApiModelProperty(example = "variety_1", value = "Alternative name or ID used to reference this germplasm")
  
    public String getSynonym() {
    return synonym;
  }

  public void setSynonym(String synonym) {
    this.synonym = synonym;
  }

  public GermplasmNewRequestSynonyms type(String type) {
    this.type = type;
    return this;
  }

  /**
   * A descriptive classification for this synonym
   * @return type
  **/
  @ApiModelProperty(example = "Pre-Code", value = "A descriptive classification for this synonym")
  
    public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GermplasmNewRequestSynonyms germplasmNewRequestSynonyms = (GermplasmNewRequestSynonyms) o;
    return Objects.equals(this.synonym, germplasmNewRequestSynonyms.synonym) &&
        Objects.equals(this.type, germplasmNewRequestSynonyms.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(synonym, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmNewRequestSynonyms {\n");
    
    sb.append("    synonym: ").append(toIndentedString(synonym)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
