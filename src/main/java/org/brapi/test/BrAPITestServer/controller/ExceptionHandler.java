package org.brapi.test.BrAPITestServer.controller;

import java.util.ArrayList;

import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaDataStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	    String error = ex.getParameterName() + " parameter is missing";
	    
	    return buildErrorResponse(HttpStatus.BAD_REQUEST, error);
	}
	
	private ResponseEntity<Object> buildErrorResponse(HttpStatus code, String message){
	    MetaDataStatus statusRes = new MetaDataStatus(code.value() + "", message);
	    
	    MetaData apiError = new MetaData();
	    apiError.setStatus(new ArrayList<>());
	    apiError.getStatus().add(statusRes);
	    
	    return new ResponseEntity<Object>(apiError, code);
	}
}
