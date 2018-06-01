package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.PedigreeSiblings;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Pedigree
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class Pedigree   {
  @JsonProperty("crossingPlan")
  private String crossingPlan = null;

  @JsonProperty("crossingYear")
  private String crossingYear = null;

  @JsonProperty("defaultDisplayName")
  private String defaultDisplayName = null;

  @JsonProperty("familyCode")
  private String familyCode = null;

  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("parent1DbId")
  private String parent1DbId = null;

  @JsonProperty("parent1Id")
  private String parent1Id = null;

  @JsonProperty("parent1Name")
  private String parent1Name = null;

  /**
   * The type of parent the first parent is. ex. 'MALE', 'FEMALE', 'SELF', 'POPULATION', etc.
   */
  public enum Parent1TypeEnum {
    MALE("MALE"),
    
    FEMALE("FEMALE"),
    
    SELF("SELF"),
    
    POPULATION("POPULATION");

    private String value;

    Parent1TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static Parent1TypeEnum fromValue(String text) {
      for (Parent1TypeEnum b : Parent1TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("parent1Type")
  private Parent1TypeEnum parent1Type = null;

  @JsonProperty("parent2DbId")
  private String parent2DbId = null;

  @JsonProperty("parent2Id")
  private String parent2Id = null;

  @JsonProperty("parent2Name")
  private String parent2Name = null;

  /**
   * The type of parent the second parent is. ex. 'MALE', 'FEMALE', 'SELF', 'POPULATION', etc.
   */
  public enum Parent2TypeEnum {
    MALE("MALE"),
    
    FEMALE("FEMALE"),
    
    SELF("SELF"),
    
    POPULATION("POPULATION");

    private String value;

    Parent2TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static Parent2TypeEnum fromValue(String text) {
      for (Parent2TypeEnum b : Parent2TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("parent2Type")
  private Parent2TypeEnum parent2Type = null;

  @JsonProperty("pedigree")
  private String pedigree = null;

  @JsonProperty("siblings")
  @Valid
  private List<PedigreeSiblings> siblings = null;

  public Pedigree crossingPlan(String crossingPlan) {
    this.crossingPlan = crossingPlan;
    return this;
  }

   /**
   * The crossing strategy used to generate this germplasm
   * @return crossingPlan
  **/
  @ApiModelProperty(value = "The crossing strategy used to generate this germplasm")


  public String getCrossingPlan() {
    return crossingPlan;
  }

  public void setCrossingPlan(String crossingPlan) {
    this.crossingPlan = crossingPlan;
  }

  public Pedigree crossingYear(String crossingYear) {
    this.crossingYear = crossingYear;
    return this;
  }

   /**
   * The year the parents were originally crossed
   * @return crossingYear
  **/
  @ApiModelProperty(value = "The year the parents were originally crossed")


  public String getCrossingYear() {
    return crossingYear;
  }

  public void setCrossingYear(String crossingYear) {
    this.crossingYear = crossingYear;
  }

  public Pedigree defaultDisplayName(String defaultDisplayName) {
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

  public Pedigree familyCode(String familyCode) {
    this.familyCode = familyCode;
    return this;
  }

   /**
   * The code representing the family
   * @return familyCode
  **/
  @ApiModelProperty(value = "The code representing the family")


  public String getFamilyCode() {
    return familyCode;
  }

  public void setFamilyCode(String familyCode) {
    this.familyCode = familyCode;
  }

  public Pedigree germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

   /**
   *  The ID which uniquely identifies a germplasm
   * @return germplasmDbId
  **/
  @ApiModelProperty(value = " The ID which uniquely identifies a germplasm")


  public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public Pedigree parent1DbId(String parent1DbId) {
    this.parent1DbId = parent1DbId;
    return this;
  }

   /**
   * The germplasm DbId of the first parent of this germplasm
   * @return parent1DbId
  **/
  @ApiModelProperty(value = "The germplasm DbId of the first parent of this germplasm")


  public String getParent1DbId() {
    return parent1DbId;
  }

  public void setParent1DbId(String parent1DbId) {
    this.parent1DbId = parent1DbId;
  }

  public Pedigree parent1Id(String parent1Id) {
    this.parent1Id = parent1Id;
    return this;
  }

   /**
   * **Deprecated** use parent1DbId
   * @return parent1Id
  **/
  @ApiModelProperty(value = "**Deprecated** use parent1DbId")


  public String getParent1Id() {
    return parent1Id;
  }

  public void setParent1Id(String parent1Id) {
    this.parent1Id = parent1Id;
  }

  public Pedigree parent1Name(String parent1Name) {
    this.parent1Name = parent1Name;
    return this;
  }

   /**
   * the human readable name of the first parent of this germplasm
   * @return parent1Name
  **/
  @ApiModelProperty(value = "the human readable name of the first parent of this germplasm")


  public String getParent1Name() {
    return parent1Name;
  }

  public void setParent1Name(String parent1Name) {
    this.parent1Name = parent1Name;
  }

  public Pedigree parent1Type(Parent1TypeEnum parent1Type) {
    this.parent1Type = parent1Type;
    return this;
  }

   /**
   * The type of parent the first parent is. ex. 'MALE', 'FEMALE', 'SELF', 'POPULATION', etc.
   * @return parent1Type
  **/
  @ApiModelProperty(value = "The type of parent the first parent is. ex. 'MALE', 'FEMALE', 'SELF', 'POPULATION', etc.")


  public Parent1TypeEnum getParent1Type() {
    return parent1Type;
  }

  public void setParent1Type(Parent1TypeEnum parent1Type) {
    this.parent1Type = parent1Type;
  }

  public Pedigree parent2DbId(String parent2DbId) {
    this.parent2DbId = parent2DbId;
    return this;
  }

   /**
   * The germplasm DbId of the second parent of this germplasm
   * @return parent2DbId
  **/
  @ApiModelProperty(value = "The germplasm DbId of the second parent of this germplasm")


  public String getParent2DbId() {
    return parent2DbId;
  }

  public void setParent2DbId(String parent2DbId) {
    this.parent2DbId = parent2DbId;
  }

  public Pedigree parent2Id(String parent2Id) {
    this.parent2Id = parent2Id;
    return this;
  }

   /**
   * **Deprecated** use parent2DbId
   * @return parent2Id
  **/
  @ApiModelProperty(value = "**Deprecated** use parent2DbId")


  public String getParent2Id() {
    return parent2Id;
  }

  public void setParent2Id(String parent2Id) {
    this.parent2Id = parent2Id;
  }

  public Pedigree parent2Name(String parent2Name) {
    this.parent2Name = parent2Name;
    return this;
  }

   /**
   * The human readable name of the second parent of this germplasm
   * @return parent2Name
  **/
  @ApiModelProperty(value = "The human readable name of the second parent of this germplasm")


  public String getParent2Name() {
    return parent2Name;
  }

  public void setParent2Name(String parent2Name) {
    this.parent2Name = parent2Name;
  }

  public Pedigree parent2Type(Parent2TypeEnum parent2Type) {
    this.parent2Type = parent2Type;
    return this;
  }

   /**
   * The type of parent the second parent is. ex. 'MALE', 'FEMALE', 'SELF', 'POPULATION', etc.
   * @return parent2Type
  **/
  @ApiModelProperty(value = "The type of parent the second parent is. ex. 'MALE', 'FEMALE', 'SELF', 'POPULATION', etc.")


  public Parent2TypeEnum getParent2Type() {
    return parent2Type;
  }

  public void setParent2Type(Parent2TypeEnum parent2Type) {
    this.parent2Type = parent2Type;
  }

  public Pedigree pedigree(String pedigree) {
    this.pedigree = pedigree;
    return this;
  }

   /**
   * The string representation of the pedigree.
   * @return pedigree
  **/
  @ApiModelProperty(value = "The string representation of the pedigree.")


  public String getPedigree() {
    return pedigree;
  }

  public void setPedigree(String pedigree) {
    this.pedigree = pedigree;
  }

  public Pedigree siblings(List<PedigreeSiblings> siblings) {
    this.siblings = siblings;
    return this;
  }

  public Pedigree addSiblingsItem(PedigreeSiblings siblingsItem) {
    if (this.siblings == null) {
      this.siblings = new ArrayList<PedigreeSiblings>();
    }
    this.siblings.add(siblingsItem);
    return this;
  }

   /**
   * List of sibling germplasm 
   * @return siblings
  **/
  @ApiModelProperty(value = "List of sibling germplasm ")

  @Valid

  public List<PedigreeSiblings> getSiblings() {
    return siblings;
  }

  public void setSiblings(List<PedigreeSiblings> siblings) {
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
    Pedigree pedigree = (Pedigree) o;
    return Objects.equals(this.crossingPlan, pedigree.crossingPlan) &&
        Objects.equals(this.crossingYear, pedigree.crossingYear) &&
        Objects.equals(this.defaultDisplayName, pedigree.defaultDisplayName) &&
        Objects.equals(this.familyCode, pedigree.familyCode) &&
        Objects.equals(this.germplasmDbId, pedigree.germplasmDbId) &&
        Objects.equals(this.parent1DbId, pedigree.parent1DbId) &&
        Objects.equals(this.parent1Id, pedigree.parent1Id) &&
        Objects.equals(this.parent1Name, pedigree.parent1Name) &&
        Objects.equals(this.parent1Type, pedigree.parent1Type) &&
        Objects.equals(this.parent2DbId, pedigree.parent2DbId) &&
        Objects.equals(this.parent2Id, pedigree.parent2Id) &&
        Objects.equals(this.parent2Name, pedigree.parent2Name) &&
        Objects.equals(this.parent2Type, pedigree.parent2Type) &&
        Objects.equals(this.pedigree, pedigree.pedigree) &&
        Objects.equals(this.siblings, pedigree.siblings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crossingPlan, crossingYear, defaultDisplayName, familyCode, germplasmDbId, parent1DbId, parent1Id, parent1Name, parent1Type, parent2DbId, parent2Id, parent2Name, parent2Type, pedigree, siblings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pedigree {\n");
    
    sb.append("    crossingPlan: ").append(toIndentedString(crossingPlan)).append("\n");
    sb.append("    crossingYear: ").append(toIndentedString(crossingYear)).append("\n");
    sb.append("    defaultDisplayName: ").append(toIndentedString(defaultDisplayName)).append("\n");
    sb.append("    familyCode: ").append(toIndentedString(familyCode)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    parent1DbId: ").append(toIndentedString(parent1DbId)).append("\n");
    sb.append("    parent1Id: ").append(toIndentedString(parent1Id)).append("\n");
    sb.append("    parent1Name: ").append(toIndentedString(parent1Name)).append("\n");
    sb.append("    parent1Type: ").append(toIndentedString(parent1Type)).append("\n");
    sb.append("    parent2DbId: ").append(toIndentedString(parent2DbId)).append("\n");
    sb.append("    parent2Id: ").append(toIndentedString(parent2Id)).append("\n");
    sb.append("    parent2Name: ").append(toIndentedString(parent2Name)).append("\n");
    sb.append("    parent2Type: ").append(toIndentedString(parent2Type)).append("\n");
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

