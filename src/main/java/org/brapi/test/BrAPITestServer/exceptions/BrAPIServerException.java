package org.brapi.test.BrAPITestServer.exceptions;

import org.springframework.http.HttpStatus;

public class BrAPIServerException extends Exception {
	private static final long serialVersionUID = 6250184179200451757L;
	
	private String responseMessage;
	private HttpStatus responseStatus;
	
	public BrAPIServerException(HttpStatus responseStatus, String responseMessage) {
		super();
		this.responseMessage = responseMessage;
		this.responseStatus = responseStatus;
	}
	
	public String getResponseMessage() {
		return responseMessage;
	}
	
	public HttpStatus getResponseStatus() {
		return this.responseStatus;
	}
	
}
