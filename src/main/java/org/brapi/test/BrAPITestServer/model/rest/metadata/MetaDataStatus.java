package org.brapi.test.BrAPITestServer.model.rest.metadata;

public class MetaDataStatus {
	private String message;
	private String code;
	
	public MetaDataStatus(String code, String message) {
		setCode(code);
		setMessage(message);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
