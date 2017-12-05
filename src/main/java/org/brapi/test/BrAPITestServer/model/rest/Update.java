package org.brapi.test.BrAPITestServer.model.rest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Update {
	private String version;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
	private Date timestamp;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
