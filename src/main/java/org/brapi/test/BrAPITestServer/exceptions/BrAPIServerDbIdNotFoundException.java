package org.brapi.test.BrAPITestServer.exceptions;

import org.springframework.http.HttpStatus;

public class BrAPIServerDbIdNotFoundException extends BrAPIServerException {
	private static final long serialVersionUID = -8000903005649088467L;

	public BrAPIServerDbIdNotFoundException(String msg, HttpStatus status) {
		super(status, "");
	}
	
	public BrAPIServerDbIdNotFoundException(String entityName, String dbidValue, HttpStatus status) {
		super(status, "");
		String msg = "The " + entityName + " \"" + dbidValue + "\" is not available in this database. \nPlease choose a different "+ entityName +"DbId or contact the server administrator to resolve this issue.";
		this.setResponseMessage(msg);
	}
	
	public BrAPIServerDbIdNotFoundException(String entityName, String dbidValue, String dbidName, HttpStatus status) {
		super(status, "");
		String msg = "The " + entityName + " \"" + dbidValue + "\" is not available in this database. \nPlease choose a different "+ dbidName +" or contact the server administrator to resolve this issue.";
		this.setResponseMessage(msg);
	}

}
