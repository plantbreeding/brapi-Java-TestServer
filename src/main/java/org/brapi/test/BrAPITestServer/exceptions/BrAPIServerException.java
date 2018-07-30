package org.brapi.test.BrAPITestServer.exceptions;

public class BrAPIServerException extends Exception {
	private static final long serialVersionUID = 6250184179200451757L;
	
	private String responseMessage;
	
	public BrAPIServerException(String responseMessage) {
		super();
		this.responseMessage = responseMessage;
	}
	
	public String getResponseMessage() {
		return responseMessage;
	}
	
}
