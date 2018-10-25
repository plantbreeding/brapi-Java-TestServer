package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Person
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class Person   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("emailAddress")
  private String emailAddress = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("mailingAddress")
  private String mailingAddress = null;

  @JsonProperty("middleName")
  private String middleName = null;

  @JsonProperty("personDbId")
  private String personDbId = null;

  @JsonProperty("phoneNumber")
  private String phoneNumber = null;

  @JsonProperty("userID")
  private String userID = null;

  public Person description(String description) {
    this.description = description;
    return this;
  }

  /**
   * description of this person
   * @return description
  **/
  @ApiModelProperty(value = "description of this person")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Person emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  /**
   * email address for this person
   * @return emailAddress
  **/
  @ApiModelProperty(value = "email address for this person")


  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public Person firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Persons first name
   * @return firstName
  **/
  @ApiModelProperty(value = "Persons first name")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Person lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Persons last name
   * @return lastName
  **/
  @ApiModelProperty(value = "Persons last name")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Person mailingAddress(String mailingAddress) {
    this.mailingAddress = mailingAddress;
    return this;
  }

  /**
   * physical address of this person
   * @return mailingAddress
  **/
  @ApiModelProperty(value = "physical address of this person")


  public String getMailingAddress() {
    return mailingAddress;
  }

  public void setMailingAddress(String mailingAddress) {
    this.mailingAddress = mailingAddress;
  }

  public Person middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * Persons middle name
   * @return middleName
  **/
  @ApiModelProperty(value = "Persons middle name")


  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public Person personDbId(String personDbId) {
    this.personDbId = personDbId;
    return this;
  }

  /**
   * Unique ID for this person
   * @return personDbId
  **/
  @ApiModelProperty(required = true, value = "Unique ID for this person")
  @NotNull


  public String getPersonDbId() {
    return personDbId;
  }

  public void setPersonDbId(String personDbId) {
    this.personDbId = personDbId;
  }

  public Person phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * phone number of this person
   * @return phoneNumber
  **/
  @ApiModelProperty(value = "phone number of this person")


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Person userID(String userID) {
    this.userID = userID;
    return this;
  }

  /**
   * A systems user ID ascociated with this person. Different from personDbId because you could have a person who is not a user of the system.
   * @return userID
  **/
  @ApiModelProperty(value = "A systems user ID ascociated with this person. Different from personDbId because you could have a person who is not a user of the system.")


  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(this.description, person.description) &&
        Objects.equals(this.emailAddress, person.emailAddress) &&
        Objects.equals(this.firstName, person.firstName) &&
        Objects.equals(this.lastName, person.lastName) &&
        Objects.equals(this.mailingAddress, person.mailingAddress) &&
        Objects.equals(this.middleName, person.middleName) &&
        Objects.equals(this.personDbId, person.personDbId) &&
        Objects.equals(this.phoneNumber, person.phoneNumber) &&
        Objects.equals(this.userID, person.userID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, emailAddress, firstName, lastName, mailingAddress, middleName, personDbId, phoneNumber, userID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    mailingAddress: ").append(toIndentedString(mailingAddress)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    personDbId: ").append(toIndentedString(personDbId)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    userID: ").append(toIndentedString(userID)).append("\n");
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

