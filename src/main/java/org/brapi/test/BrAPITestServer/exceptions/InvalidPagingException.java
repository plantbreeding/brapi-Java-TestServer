package org.brapi.test.BrAPITestServer.exceptions;

public class InvalidPagingException extends BrAPIServerException {
	private static final long serialVersionUID = 6250184179200451757L;
		
	public InvalidPagingException(String field) {
		super("\'" + field + "\' value is invalid");
	}
	
}
