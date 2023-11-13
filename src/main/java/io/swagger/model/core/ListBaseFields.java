package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ExternalReferences;

import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * ListBaseFields
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class ListBaseFields implements ListBaseFieldsInterface  {
  @JsonProperty("additionalInfo")
  @Valid
  private Object additionalInfo = null;

  @JsonProperty("dateCreated")
  private OffsetDateTime dateCreated = null;

  @JsonProperty("dateModified")
  private OffsetDateTime dateModified = null;

  @JsonProperty("externalReferences")
  private ExternalReferences externalReferences = null;

  @JsonProperty("listDescription")
  private String listDescription = null;

  @JsonProperty("listName")
  private String listName = null;

  @JsonProperty("listOwnerName")
  private String listOwnerName = null;

  @JsonProperty("listOwnerPersonDbId")
  private String listOwnerPersonDbId = null;

  @JsonProperty("listSize")
  private Integer listSize = null;

  @JsonProperty("listSource")
  private String listSource = null;

  @JsonProperty("listType")
  private ListTypes listType = null;

  public ListBaseFields additionalInfo(Object additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Additional arbitrary info
   *
   * @return additionalInfo
   **/
  @ApiModelProperty(example = "{}", value = "Additional arbitrary info")
  
    public Object getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Object additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public ListBaseFields dateCreated(OffsetDateTime dateCreated) {
    this.dateCreated = dateCreated;
    return this;
  }

  /**
   * Timestamp when the entity was first created
   * @return dateCreated
  **/
  @ApiModelProperty(value = "Timestamp when the entity was first created")
  
    @Valid
    public OffsetDateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(OffsetDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  public ListBaseFields dateModified(OffsetDateTime dateModified) {
    this.dateModified = dateModified;
    return this;
  }

  /**
   * Timestamp when the entity was last updated
   * @return dateModified
  **/
  @ApiModelProperty(value = "Timestamp when the entity was last updated")
  
    @Valid
    public OffsetDateTime getDateModified() {
    return dateModified;
  }

  public void setDateModified(OffsetDateTime dateModified) {
    this.dateModified = dateModified;
  }

  public ListBaseFields externalReferences(ExternalReferences externalReferences) {
    this.externalReferences = externalReferences;
    return this;
  }

  /**
   * Get externalReferences
   * @return externalReferences
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ExternalReferences getExternalReferences() {
    return externalReferences;
  }

  public void setExternalReferences(ExternalReferences externalReferences) {
    this.externalReferences = externalReferences;
  }

  public ListBaseFields listDescription(String listDescription) {
    this.listDescription = listDescription;
    return this;
  }

  /**
   * Description of a List
   * @return listDescription
  **/
  @ApiModelProperty(example = "This is a list of germplasm I would like to investigate next season", value = "Description of a List")
  
    public String getListDescription() {
    return listDescription;
  }

  public void setListDescription(String listDescription) {
    this.listDescription = listDescription;
  }

  public ListBaseFields listName(String listName) {
    this.listName = listName;
    return this;
  }

  /**
   * Human readable name of a List
   * @return listName
  **/
  @ApiModelProperty(example = "MyGermplasm_Sept_2020", value = "Human readable name of a List")
  
    public String getListName() {
    return listName;
  }

  public void setListName(String listName) {
    this.listName = listName;
  }

  public ListBaseFields listOwnerName(String listOwnerName) {
    this.listOwnerName = listOwnerName;
    return this;
  }

  /**
   * Human readable name of a List Owner. (usually a user or person)
   * @return listOwnerName
  **/
  @ApiModelProperty(example = "Bob Robertson", value = "Human readable name of a List Owner. (usually a user or person)")
  
    public String getListOwnerName() {
    return listOwnerName;
  }

  public void setListOwnerName(String listOwnerName) {
    this.listOwnerName = listOwnerName;
  }

  public ListBaseFields listOwnerPersonDbId(String listOwnerPersonDbId) {
    this.listOwnerPersonDbId = listOwnerPersonDbId;
    return this;
  }

  /**
   * The unique identifier for a List Owner. (usually a user or person)
   * @return listOwnerPersonDbId
  **/
  @ApiModelProperty(example = "58db0628", value = "The unique identifier for a List Owner. (usually a user or person)")
  
    public String getListOwnerPersonDbId() {
    return listOwnerPersonDbId;
  }

  public void setListOwnerPersonDbId(String listOwnerPersonDbId) {
    this.listOwnerPersonDbId = listOwnerPersonDbId;
  }

  public ListBaseFields listSize(Integer listSize) {
    this.listSize = listSize;
    return this;
  }

  /**
   * The number of elements in a List
   * @return listSize
  **/
  @ApiModelProperty(example = "53", value = "The number of elements in a List")
  
    public Integer getListSize() {
    return listSize;
  }

  public void setListSize(Integer listSize) {
    this.listSize = listSize;
  }

  public ListBaseFields listSource(String listSource) {
    this.listSource = listSource;
    return this;
  }

  /**
   * The description of where a List originated from
   * @return listSource
  **/
  @ApiModelProperty(example = "GeneBank Repository 1.3", value = "The description of where a List originated from")
  
    public String getListSource() {
    return listSource;
  }

  public void setListSource(String listSource) {
    this.listSource = listSource;
  }

  public ListBaseFields listType(ListTypes listType) {
    this.listType = listType;
    return this;
  }

  /**
   * Get listType
   * @return listType
  **/
  @ApiModelProperty(required = true, value = "")
      

    @Valid
    public ListTypes getListType() {
    return listType;
  }

  public void setListType(ListTypes listType) {
    this.listType = listType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListBaseFields listBaseFields = (ListBaseFields) o;
    return Objects.equals(this.additionalInfo, listBaseFields.additionalInfo) &&
        Objects.equals(this.dateCreated, listBaseFields.dateCreated) &&
        Objects.equals(this.dateModified, listBaseFields.dateModified) &&
        Objects.equals(this.externalReferences, listBaseFields.externalReferences) &&
        Objects.equals(this.listDescription, listBaseFields.listDescription) &&
        Objects.equals(this.listName, listBaseFields.listName) &&
        Objects.equals(this.listOwnerName, listBaseFields.listOwnerName) &&
        Objects.equals(this.listOwnerPersonDbId, listBaseFields.listOwnerPersonDbId) &&
        Objects.equals(this.listSize, listBaseFields.listSize) &&
        Objects.equals(this.listSource, listBaseFields.listSource) &&
        Objects.equals(this.listType, listBaseFields.listType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, dateCreated, dateModified, externalReferences, listDescription, listName, listOwnerName, listOwnerPersonDbId, listSize, listSource, listType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListBaseFields {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
    sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
    sb.append("    listDescription: ").append(toIndentedString(listDescription)).append("\n");
    sb.append("    listName: ").append(toIndentedString(listName)).append("\n");
    sb.append("    listOwnerName: ").append(toIndentedString(listOwnerName)).append("\n");
    sb.append("    listOwnerPersonDbId: ").append(toIndentedString(listOwnerPersonDbId)).append("\n");
    sb.append("    listSize: ").append(toIndentedString(listSize)).append("\n");
    sb.append("    listSource: ").append(toIndentedString(listSource)).append("\n");
    sb.append("    listType: ").append(toIndentedString(listType)).append("\n");
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
