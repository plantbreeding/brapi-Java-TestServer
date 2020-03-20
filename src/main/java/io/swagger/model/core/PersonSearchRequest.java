package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.common.SearchRequestParametersPaging;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * PersonSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class PersonSearchRequest extends SearchRequestParametersPaging  {
  @JsonProperty("externalReferenceIDs")
  @Valid
  private List<String> externalReferenceIDs = null;

  @JsonProperty("externalReferenceSources")
  @Valid
  private List<String> externalReferenceSources = null;

  @JsonProperty("emailAddresses")
  @Valid
  private List<String> emailAddresses = null;

  @JsonProperty("firstNames")
  @Valid
  private List<String> firstNames = null;

  @JsonProperty("lastNames")
  @Valid
  private List<String> lastNames = null;

  @JsonProperty("mailingAddresses")
  @Valid
  private List<String> mailingAddresses = null;

  @JsonProperty("middleNames")
  @Valid
  private List<String> middleNames = null;

  @JsonProperty("personDbIds")
  @Valid
  private List<String> personDbIds = null;

  @JsonProperty("phoneNumbers")
  @Valid
  private List<String> phoneNumbers = null;

  @JsonProperty("userIDs")
  @Valid
  private List<String> userIDs = null;

  public PersonSearchRequest externalReferenceIDs(List<String> externalReferenceIDs) {
    this.externalReferenceIDs = externalReferenceIDs;
    return this;
  }

  public PersonSearchRequest addExternalReferenceIDsItem(String externalReferenceIDsItem) {
    if (this.externalReferenceIDs == null) {
      this.externalReferenceIDs = new ArrayList<String>();
    }
    this.externalReferenceIDs.add(externalReferenceIDsItem);
    return this;
  }

  /**
   * List of external references for the trait to search for
   * @return externalReferenceIDs
  **/
  @ApiModelProperty(example = "[\"http://purl.obolibrary.org/obo/ro.owl\",\"14a19841\"]", value = "List of external references for the trait to search for")
  
    public List<String> getExternalReferenceIDs() {
    return externalReferenceIDs;
  }

  public void setExternalReferenceIDs(List<String> externalReferenceIDs) {
    this.externalReferenceIDs = externalReferenceIDs;
  }

  public PersonSearchRequest externalReferenceSources(List<String> externalReferenceSources) {
    this.externalReferenceSources = externalReferenceSources;
    return this;
  }

  public PersonSearchRequest addExternalReferenceSourcesItem(String externalReferenceSourcesItem) {
    if (this.externalReferenceSources == null) {
      this.externalReferenceSources = new ArrayList<String>();
    }
    this.externalReferenceSources.add(externalReferenceSourcesItem);
    return this;
  }

  /**
   * List of external references sources for the trait to search for
   * @return externalReferenceSources
  **/
  @ApiModelProperty(example = "[\"OBO Library\",\"Field App Name\"]", value = "List of external references sources for the trait to search for")
  
    public List<String> getExternalReferenceSources() {
    return externalReferenceSources;
  }

  public void setExternalReferenceSources(List<String> externalReferenceSources) {
    this.externalReferenceSources = externalReferenceSources;
  }

  public PersonSearchRequest emailAddresses(List<String> emailAddresses) {
    this.emailAddresses = emailAddresses;
    return this;
  }

  public PersonSearchRequest addEmailAddressesItem(String emailAddressesItem) {
    if (this.emailAddresses == null) {
      this.emailAddresses = new ArrayList<String>();
    }
    this.emailAddresses.add(emailAddressesItem);
    return this;
  }

  /**
   * email address for this person
   * @return emailAddresses
  **/
  @ApiModelProperty(example = "[\"bob@bob.com\",\"rob@bob.com\"]", value = "email address for this person")
  
    public List<String> getEmailAddresses() {
    return emailAddresses;
  }

  public void setEmailAddresses(List<String> emailAddresses) {
    this.emailAddresses = emailAddresses;
  }

  public PersonSearchRequest firstNames(List<String> firstNames) {
    this.firstNames = firstNames;
    return this;
  }

  public PersonSearchRequest addFirstNamesItem(String firstNamesItem) {
    if (this.firstNames == null) {
      this.firstNames = new ArrayList<String>();
    }
    this.firstNames.add(firstNamesItem);
    return this;
  }

  /**
   * Persons first name
   * @return firstNames
  **/
  @ApiModelProperty(example = "[\"Bob\",\"Rob\"]", value = "Persons first name")
  
    public List<String> getFirstNames() {
    return firstNames;
  }

  public void setFirstNames(List<String> firstNames) {
    this.firstNames = firstNames;
  }

  public PersonSearchRequest lastNames(List<String> lastNames) {
    this.lastNames = lastNames;
    return this;
  }

  public PersonSearchRequest addLastNamesItem(String lastNamesItem) {
    if (this.lastNames == null) {
      this.lastNames = new ArrayList<String>();
    }
    this.lastNames.add(lastNamesItem);
    return this;
  }

  /**
   * Persons last name
   * @return lastNames
  **/
  @ApiModelProperty(example = "[\"Robertson\",\"Smith\"]", value = "Persons last name")
  
    public List<String> getLastNames() {
    return lastNames;
  }

  public void setLastNames(List<String> lastNames) {
    this.lastNames = lastNames;
  }

  public PersonSearchRequest mailingAddresses(List<String> mailingAddresses) {
    this.mailingAddresses = mailingAddresses;
    return this;
  }

  public PersonSearchRequest addMailingAddressesItem(String mailingAddressesItem) {
    if (this.mailingAddresses == null) {
      this.mailingAddresses = new ArrayList<String>();
    }
    this.mailingAddresses.add(mailingAddressesItem);
    return this;
  }

  /**
   * physical address of this person
   * @return mailingAddresses
  **/
  @ApiModelProperty(example = "[\"123 Main Street\",\"456 Side Street\"]", value = "physical address of this person")
  
    public List<String> getMailingAddresses() {
    return mailingAddresses;
  }

  public void setMailingAddresses(List<String> mailingAddresses) {
    this.mailingAddresses = mailingAddresses;
  }

  public PersonSearchRequest middleNames(List<String> middleNames) {
    this.middleNames = middleNames;
    return this;
  }

  public PersonSearchRequest addMiddleNamesItem(String middleNamesItem) {
    if (this.middleNames == null) {
      this.middleNames = new ArrayList<String>();
    }
    this.middleNames.add(middleNamesItem);
    return this;
  }

  /**
   * Persons middle name
   * @return middleNames
  **/
  @ApiModelProperty(example = "[\"Danger\",\"Fight\"]", value = "Persons middle name")
  
    public List<String> getMiddleNames() {
    return middleNames;
  }

  public void setMiddleNames(List<String> middleNames) {
    this.middleNames = middleNames;
  }

  public PersonSearchRequest personDbIds(List<String> personDbIds) {
    this.personDbIds = personDbIds;
    return this;
  }

  public PersonSearchRequest addPersonDbIdsItem(String personDbIdsItem) {
    if (this.personDbIds == null) {
      this.personDbIds = new ArrayList<String>();
    }
    this.personDbIds.add(personDbIdsItem);
    return this;
  }

  /**
   * Unique ID for this person
   * @return personDbIds
  **/
  @ApiModelProperty(example = "[\"1e7731ab\",\"bc28cff8\"]", value = "Unique ID for this person")
  
    public List<String> getPersonDbIds() {
    return personDbIds;
  }

  public void setPersonDbIds(List<String> personDbIds) {
    this.personDbIds = personDbIds;
  }

  public PersonSearchRequest phoneNumbers(List<String> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
    return this;
  }

  public PersonSearchRequest addPhoneNumbersItem(String phoneNumbersItem) {
    if (this.phoneNumbers == null) {
      this.phoneNumbers = new ArrayList<String>();
    }
    this.phoneNumbers.add(phoneNumbersItem);
    return this;
  }

  /**
   * phone number of this person
   * @return phoneNumbers
  **/
  @ApiModelProperty(example = "[\"9995555555\",\"8884444444\"]", value = "phone number of this person")
  
    public List<String> getPhoneNumbers() {
    return phoneNumbers;
  }

  public void setPhoneNumbers(List<String> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }

  public PersonSearchRequest userIDs(List<String> userIDs) {
    this.userIDs = userIDs;
    return this;
  }

  public PersonSearchRequest addUserIDsItem(String userIDsItem) {
    if (this.userIDs == null) {
      this.userIDs = new ArrayList<String>();
    }
    this.userIDs.add(userIDsItem);
    return this;
  }

  /**
   * A systems user ID associated with this person. Different from personDbId because you could have a person who is not a user of the system.
   * @return userIDs
  **/
  @ApiModelProperty(example = "[\"bob\",\"rob\"]", value = "A systems user ID associated with this person. Different from personDbId because you could have a person who is not a user of the system.")
  
    public List<String> getUserIDs() {
    return userIDs;
  }

  public void setUserIDs(List<String> userIDs) {
    this.userIDs = userIDs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonSearchRequest personSearchRequest = (PersonSearchRequest) o;
    return Objects.equals(this.externalReferenceIDs, personSearchRequest.externalReferenceIDs) &&
        Objects.equals(this.externalReferenceSources, personSearchRequest.externalReferenceSources) &&
        Objects.equals(this.emailAddresses, personSearchRequest.emailAddresses) &&
        Objects.equals(this.firstNames, personSearchRequest.firstNames) &&
        Objects.equals(this.lastNames, personSearchRequest.lastNames) &&
        Objects.equals(this.mailingAddresses, personSearchRequest.mailingAddresses) &&
        Objects.equals(this.middleNames, personSearchRequest.middleNames) &&
        Objects.equals(this.personDbIds, personSearchRequest.personDbIds) &&
        Objects.equals(this.phoneNumbers, personSearchRequest.phoneNumbers) &&
        Objects.equals(this.userIDs, personSearchRequest.userIDs) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalReferenceIDs, externalReferenceSources, emailAddresses, firstNames, lastNames, mailingAddresses, middleNames, personDbIds, phoneNumbers, userIDs, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonSearchRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    externalReferenceIDs: ").append(toIndentedString(externalReferenceIDs)).append("\n");
    sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
    sb.append("    emailAddresses: ").append(toIndentedString(emailAddresses)).append("\n");
    sb.append("    firstNames: ").append(toIndentedString(firstNames)).append("\n");
    sb.append("    lastNames: ").append(toIndentedString(lastNames)).append("\n");
    sb.append("    mailingAddresses: ").append(toIndentedString(mailingAddresses)).append("\n");
    sb.append("    middleNames: ").append(toIndentedString(middleNames)).append("\n");
    sb.append("    personDbIds: ").append(toIndentedString(personDbIds)).append("\n");
    sb.append("    phoneNumbers: ").append(toIndentedString(phoneNumbers)).append("\n");
    sb.append("    userIDs: ").append(toIndentedString(userIDs)).append("\n");
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
