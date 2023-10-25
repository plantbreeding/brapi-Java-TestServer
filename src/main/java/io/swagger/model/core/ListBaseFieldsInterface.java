package io.swagger.model.core;

import java.time.OffsetDateTime;

import io.swagger.model.ExternalReferences;

public interface ListBaseFieldsInterface {

	public ListBaseFieldsInterface additionalInfo(Object additionalInfo);

	public Object getAdditionalInfo();

	public void setAdditionalInfo(Object additionalInfo);

	public ListBaseFieldsInterface dateCreated(OffsetDateTime dateCreated);

	public OffsetDateTime getDateCreated();

	public void setDateCreated(OffsetDateTime dateCreated);

	public ListBaseFieldsInterface dateModified(OffsetDateTime dateModified);

	public OffsetDateTime getDateModified();

	public void setDateModified(OffsetDateTime dateModified);

	public ListBaseFieldsInterface externalReferences(ExternalReferences externalReferences);

	public ExternalReferences getExternalReferences();

	public void setExternalReferences(ExternalReferences externalReferences);

	public ListBaseFieldsInterface listDescription(String listDescription);

	public String getListDescription();

	public void setListDescription(String listDescription);

	public ListBaseFieldsInterface listName(String listName);

	public String getListName();

	public void setListName(String listName);

	public ListBaseFieldsInterface listOwnerName(String listOwnerName);

	public String getListOwnerName();

	public void setListOwnerName(String listOwnerName);

	public ListBaseFieldsInterface listOwnerPersonDbId(String listOwnerPersonDbId);

	public String getListOwnerPersonDbId();

	public void setListOwnerPersonDbId(String listOwnerPersonDbId);

	public ListBaseFieldsInterface listSize(Integer listSize);

	public Integer getListSize();

	public void setListSize(Integer listSize);

	public ListBaseFieldsInterface listSource(String listSource);

	public String getListSource();

	public void setListSource(String listSource);

	public ListBaseFieldsInterface listType(ListTypes listType);

	public ListTypes getListType();

	public void setListType(ListTypes listType);

}
