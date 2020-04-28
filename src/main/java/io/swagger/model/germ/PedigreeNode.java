package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.germ.PedigreeNodeParents;
import io.swagger.model.germ.PedigreeNodeSiblings;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;


/**
 * PedigreeNode
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class PedigreeNode   {
  @JsonProperty("crossingProjectDbId")
  private String crossingProjectDbId = null;

  @JsonProperty("crossingYear")
  private Integer crossingYear = null;

  @JsonProperty("familyCode")
  private String familyCode = null;

  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("germplasmName")
  private String germplasmName = null;

  @JsonProperty("parents")
  @Valid
  private List<PedigreeNodeParents> parents = null;

  @JsonProperty("pedigree")
  private String pedigree = null;

  @JsonProperty("siblings")
  @Valid
  private List<PedigreeNodeSiblings> siblings = null;

  public PedigreeNode crossingProjectDbId(String crossingProjectDbId) {
    this.crossingProjectDbId = crossingProjectDbId;
    return this;
  }

  /**
   * The crossing project used to generate this germplasm
   * @return crossingProjectDbId
  **/
  @ApiModelProperty(example = "625e745a", value = "The crossing project used to generate this germplasm")
  
    public String getCrossingProjectDbId() {
    return crossingProjectDbId;
  }

  public void setCrossingProjectDbId(String crossingProjectDbId) {
    this.crossingProjectDbId = crossingProjectDbId;
  }

  public PedigreeNode crossingYear(Integer crossingYear) {
    this.crossingYear = crossingYear;
    return this;
  }

  /**
   * The year the parents were originally crossed
   * @return crossingYear
  **/
  @ApiModelProperty(example = "2005", value = "The year the parents were originally crossed")
  
    public Integer getCrossingYear() {
    return crossingYear;
  }

  public void setCrossingYear(Integer crossingYear) {
    this.crossingYear = crossingYear;
  }

  public PedigreeNode familyCode(String familyCode) {
    this.familyCode = familyCode;
    return this;
  }

  /**
   * The code representing the family
   * @return familyCode
  **/
  @ApiModelProperty(example = "F0000203", value = "The code representing the family")
  
    public String getFamilyCode() {
    return familyCode;
  }

  public void setFamilyCode(String familyCode) {
    this.familyCode = familyCode;
  }

  public PedigreeNode germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a germplasm
   * @return germplasmDbId
  **/
  @ApiModelProperty(example = "1098ebaf", required = true, value = "The ID which uniquely identifies a germplasm")
      

    public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public PedigreeNode germplasmName(String germplasmName) {
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

  public PedigreeNode parents(List<PedigreeNodeParents> parents) {
    this.parents = parents;
    return this;
  }

  public PedigreeNode addParentsItem(PedigreeNodeParents parentsItem) {
    if (this.parents == null) {
      this.parents = new ArrayList<PedigreeNodeParents>();
    }
    this.parents.add(parentsItem);
    return this;
  }

  /**
   * List of parent nodes in the pedigree tree.
   * @return parents
  **/
  @ApiModelProperty(example = "[{\"germplasmDbId\":\"b66958de\",\"germplasmName\":\"A0000592\",\"parentType\":\"MALE\"},{\"germplasmDbId\":\"a55847ed\",\"germplasmName\":\"A0000592\",\"parentType\":\"FEMALE\"}]", value = "List of parent nodes in the pedigree tree.")
      @Valid
    public List<PedigreeNodeParents> getParents() {
    return parents;
  }

  public void setParents(List<PedigreeNodeParents> parents) {
    this.parents = parents;
  }

  public PedigreeNode pedigree(String pedigree) {
    this.pedigree = pedigree;
    return this;
  }

  /**
   * The string representation of the pedigree.
   * @return pedigree
  **/
  @ApiModelProperty(example = "A0000001/A0000002", value = "The string representation of the pedigree.")
  
    public String getPedigree() {
    return pedigree;
  }

  public void setPedigree(String pedigree) {
    this.pedigree = pedigree;
  }

  public PedigreeNode siblings(List<PedigreeNodeSiblings> siblings) {
    this.siblings = siblings;
    return this;
  }

  public PedigreeNode addSiblingsItem(PedigreeNodeSiblings siblingsItem) {
    if (this.siblings == null) {
      this.siblings = new ArrayList<PedigreeNodeSiblings>();
    }
    this.siblings.add(siblingsItem);
    return this;
  }

  /**
   * List of sibling germplasm
   * @return siblings
  **/
  @ApiModelProperty(example = "[{\"germplasmDbId\":\"334f53a3\",\"germplasmName\":\"A0021005\"},{\"germplasmDbId\":\"7bbbda8c\",\"germplasmName\":\"A0021006\"},{\"germplasmDbId\":\"ab1d9b26\",\"germplasmName\":\"A0021007\"}]", value = "List of sibling germplasm")
      @Valid
    public List<PedigreeNodeSiblings> getSiblings() {
    return siblings;
  }

  public void setSiblings(List<PedigreeNodeSiblings> siblings) {
    this.siblings = siblings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PedigreeNode pedigreeNode = (PedigreeNode) o;
    return Objects.equals(this.crossingProjectDbId, pedigreeNode.crossingProjectDbId) &&
        Objects.equals(this.crossingYear, pedigreeNode.crossingYear) &&
        Objects.equals(this.familyCode, pedigreeNode.familyCode) &&
        Objects.equals(this.germplasmDbId, pedigreeNode.germplasmDbId) &&
        Objects.equals(this.germplasmName, pedigreeNode.germplasmName) &&
        Objects.equals(this.parents, pedigreeNode.parents) &&
        Objects.equals(this.pedigree, pedigreeNode.pedigree) &&
        Objects.equals(this.siblings, pedigreeNode.siblings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crossingProjectDbId, crossingYear, familyCode, germplasmDbId, germplasmName, parents, pedigree, siblings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PedigreeNode {\n");
    
    sb.append("    crossingProjectDbId: ").append(toIndentedString(crossingProjectDbId)).append("\n");
    sb.append("    crossingYear: ").append(toIndentedString(crossingYear)).append("\n");
    sb.append("    familyCode: ").append(toIndentedString(familyCode)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
    sb.append("    parents: ").append(toIndentedString(parents)).append("\n");
    sb.append("    pedigree: ").append(toIndentedString(pedigree)).append("\n");
    sb.append("    siblings: ").append(toIndentedString(siblings)).append("\n");
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
