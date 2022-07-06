package org.brapi.test.BrAPITestServer.exceptions;

import org.springframework.http.HttpStatus;

public class BrAPIServerDbIdNotFoundException extends BrAPIServerException {
	private static final long serialVersionUID = -8000903005649088467L;

	public BrAPIServerDbIdNotFoundException(String msg) {
		super(HttpStatus.BAD_REQUEST, msg);
	}
	
	public BrAPIServerDbIdNotFoundException(String entityName, String dbidValue) {
		super(HttpStatus.BAD_REQUEST, null);
		String msg = "The " + entityName + " \"" + dbidValue + "\" is not available in this database. \nPlease choose a different "+ entityName +"DbId or contact the server administrator to resolve this issue.";
		this.setResponseMessage(msg);
	}
	
	public BrAPIServerDbIdNotFoundException(String entityName, String dbidValue, String dbidName) {
		super(HttpStatus.BAD_REQUEST, null);
		String msg = "The " + entityName + " \"" + dbidValue + "\" is not available in this database. \nPlease choose a different "+ dbidName +" or contact the server administrator to resolve this issue.";
		this.setResponseMessage(msg);
	}

}
