package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="location_additional_info")
public class LocationAdditionalInfoEntity extends BaseEntity{
	@Column
	private String locationDbId;
	@Column
	private String key;
	@Column
	private String value;
	public String getLocationDbId() {
		return locationDbId;
	}
	public void setLocationDbId(String locationDbId) {
		this.locationDbId = locationDbId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
