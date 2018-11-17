package org.brapi.test.BrAPITestServer.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidPagingException extends BrAPIServerException {
	private static final long serialVersionUID = 6250184179200451757L;
		
	public InvalidPagingException(String field) {
		super(HttpStatus.BAD_REQUEST, "\'" + field + "\' value is invalid");
	}
	
}
