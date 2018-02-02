package org.brapi.test.BrAPITestServer.model.rest.vendor;

import javax.persistence.Column;

import org.brapi.test.BrAPITestServer.model.entity.BaseEntity;

public class VendorSpecDeliverable{
    private String name;
    private String description;
    private String format;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
}
