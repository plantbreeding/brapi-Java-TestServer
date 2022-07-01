package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;

public class PersonSearchRequest extends SearchRequest {
	@JsonProperty("commonCropNames")
	private List<String> commonCropNames = null;
	@JsonProperty("emailAddresses")
	private List<String> emailAddresses = null;

	@JsonProperty("firstNames")
	private List<String> firstNames = null;

	@JsonProperty("lastNames")
	private List<String> lastNames = null;

	@JsonProperty("mailingAddresses")
	private List<String> mailingAddresses = null;

	@JsonProperty("middleNames")
	private List<String> middleNames = null;

	@JsonProperty("personDbIds")
	private List<String> personDbIds = null;

	@JsonProperty("phoneNumbers")
	private List<String> phoneNumbers = null;

	@JsonProperty("programDbIds")
	private List<String> programDbIds = null;

	@JsonProperty("programNames")
	private List<String> programNames = null;

	@JsonProperty("userIDs")
	private List<String> userIDs = null;

	public PersonSearchRequest commonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
		return this;
	}

	public PersonSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
		if (this.commonCropNames == null) {
			this.commonCropNames = new ArrayList<String>();
		}
		this.commonCropNames.add(commonCropNamesItem);
		return this;
	}

	public List<String> getCommonCropNames() {
		return commonCropNames;
	}

	public void setCommonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
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

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public PersonSearchRequest programDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
		return this;
	}

	public PersonSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
		if (this.programDbIds == null) {
			this.programDbIds = new ArrayList<String>();
		}
		this.programDbIds.add(programDbIdsItem);
		return this;
	}

	public List<String> getProgramDbIds() {
		return programDbIds;
	}

	public void setProgramDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
	}

	public PersonSearchRequest programNames(List<String> programNames) {
		this.programNames = programNames;
		return this;
	}

	public PersonSearchRequest addProgramNamesItem(String programNamesItem) {
		if (this.programNames == null) {
			this.programNames = new ArrayList<String>();
		}
		this.programNames.add(programNamesItem);
		return this;
	}

	public List<String> getProgramNames() {
		return programNames;
	}

	public void setProgramNames(List<String> programNames) {
		this.programNames = programNames;
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
		return Objects.equals(this.commonCropNames, personSearchRequest.commonCropNames)
				&& Objects.equals(this.emailAddresses, personSearchRequest.emailAddresses)
				&& Objects.equals(this.externalReferenceIds, personSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources, personSearchRequest.externalReferenceSources)
				&& Objects.equals(this.firstNames, personSearchRequest.firstNames)
				&& Objects.equals(this.lastNames, personSearchRequest.lastNames)
				&& Objects.equals(this.mailingAddresses, personSearchRequest.mailingAddresses)
				&& Objects.equals(this.middleNames, personSearchRequest.middleNames)
				&& Objects.equals(this.page, personSearchRequest.page)
				&& Objects.equals(this.pageSize, personSearchRequest.pageSize)
				&& Objects.equals(this.personDbIds, personSearchRequest.personDbIds)
				&& Objects.equals(this.phoneNumbers, personSearchRequest.phoneNumbers)
				&& Objects.equals(this.programDbIds, personSearchRequest.programDbIds)
				&& Objects.equals(this.programNames, personSearchRequest.programNames)
				&& Objects.equals(this.userIDs, personSearchRequest.userIDs);
	}

	@Override
	public int hashCode() {
		return Objects.hash(commonCropNames, emailAddresses, externalReferenceIds, externalReferenceSources, firstNames,
				lastNames, mailingAddresses, middleNames, page, pageSize, personDbIds, phoneNumbers, programDbIds,
				programNames, userIDs, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PersonSearchRequest {\n");
	    sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
	    sb.append("    emailAddresses: ").append(toIndentedString(emailAddresses)).append("\n");
	    sb.append("    externalReferenceIds: ").append(toIndentedString(externalReferenceIds)).append("\n");
	    sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
	    sb.append("    firstNames: ").append(toIndentedString(firstNames)).append("\n");
	    sb.append("    lastNames: ").append(toIndentedString(lastNames)).append("\n");
	    sb.append("    mailingAddresses: ").append(toIndentedString(mailingAddresses)).append("\n");
	    sb.append("    middleNames: ").append(toIndentedString(middleNames)).append("\n");
	    sb.append("    page: ").append(toIndentedString(page)).append("\n");
	    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
	    sb.append("    personDbIds: ").append(toIndentedString(personDbIds)).append("\n");
	    sb.append("    phoneNumbers: ").append(toIndentedString(phoneNumbers)).append("\n");
	    sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
	    sb.append("    programNames: ").append(toIndentedString(programNames)).append("\n");
	    sb.append("    userIDs: ").append(toIndentedString(userIDs)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	@Override
	public Integer getTotalParameterCount() {
		Integer count = 0;
		if (this.externalReferenceIds != null)
			count += this.externalReferenceIds.size();
		if (this.externalReferenceSources != null)
			count += this.externalReferenceSources.size();
		if (this.emailAddresses != null)
			count += this.emailAddresses.size();
		if (this.firstNames != null)
			count += this.firstNames.size();
		if (this.lastNames != null)
			count += this.lastNames.size();
		if (this.mailingAddresses != null)
			count += this.mailingAddresses.size();
		if (this.middleNames != null)
			count += this.middleNames.size();
		if (this.personDbIds != null)
			count += this.personDbIds.size();
		if (this.phoneNumbers != null)
			count += this.phoneNumbers.size();
		if (this.userIDs != null)
			count += this.userIDs.size();
		if (this.commonCropNames != null)
			count += this.commonCropNames.size();
		if (this.programDbIds != null)
			count += this.programDbIds.size();
		if (this.programNames != null)
			count += this.programNames.size();
		return count;
	}
}
