package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.germ.ProgenyNodeProgeny;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;


/**
 * ProgenyNode
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class ProgenyNode   {
  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("germplasmName")
  private String germplasmName = null;

  @JsonProperty("progeny")
  @Valid
  private List<ProgenyNodeProgeny> progeny = new ArrayList<ProgenyNodeProgeny>();

  public ProgenyNode germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a germplasm
   * @return germplasmDbId
  **/
  @ApiModelProperty(example = "01b974dc", required = true, value = "The ID which uniquely identifies a germplasm")
      

    public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public ProgenyNode germplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
    return this;
  }

  /**
   * A human readable name for a germplasm
   * @return germplasmName
  **/
  @ApiModelProperty(example = "A0021004", value = "A human readable name for a germplasm")
  
    public String getGermplasmName() {
    return germplasmName;
  }

  public void setGermplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
  }

  public ProgenyNode progeny(List<ProgenyNodeProgeny> progeny) {
    this.progeny = progeny;
    return this;
  }

  public ProgenyNode addProgenyItem(ProgenyNodeProgeny progenyItem) {
    this.progeny.add(progenyItem);
    return this;
  }

  /**
   * List of germplasm entities which are direct children of this germplasm
   * @return progeny
  **/
  @ApiModelProperty(example = "[{\"germplasmDbId\":\"e8d5dad7\",\"germplasmName\":\"A0021011\",\"parentType\":\"FEMALE\"},{\"germplasmDbId\":\"ac07fbd8\",\"germplasmName\":\"A0021012\",\"parentType\":\"FEMALE\"},{\"germplasmDbId\":\"07f45f67\",\"germplasmName\":\"A0021013\",\"parentType\":\"FEMALE\"}]", required = true, value = "List of germplasm entities which are direct children of this germplasm")
      
    @Valid
    public List<ProgenyNodeProgeny> getProgeny() {
    return progeny;
  }

  public void setProgeny(List<ProgenyNodeProgeny> progeny) {
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
    ProgenyNode progenyNode = (ProgenyNode) o;
    return Objects.equals(this.germplasmDbId, progenyNode.germplasmDbId) &&
        Objects.equals(this.germplasmName, progenyNode.germplasmName) &&
        Objects.equals(this.progeny, progenyNode.progeny);
  }

  @Override
  public int hashCode() {
    return Objects.hash(germplasmDbId, germplasmName, progeny);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgenyNode {\n");
    
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
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
