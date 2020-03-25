package org.brapi.test.BrAPITestServer;

import java.util.ArrayList;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.swagger.model.common.Metadata;
import io.swagger.model.common.Status;
import io.swagger.model.common.Status.MessageTypeEnum;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	    String error = ex.getParameterName() + " parameter is missing";
	    
	    return buildErrorResponse(HttpStatus.BAD_REQUEST, error);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = {BrAPIServerException.class})
	protected ResponseEntity<Object> handleBrAPIException(BrAPIServerException ex, WebRequest request){
		String message = ex.getResponseMessage().replaceAll("\"", "\'");
	    return new ResponseEntity<Object>("\"" + message + "\"", ex.getResponseStatus());		
	}
	
	private ResponseEntity<Object> buildErrorResponse(HttpStatus code, String message){
	    Status statusRes = new Status();
	    statusRes.setMessageType(MessageTypeEnum.ERROR);
	    statusRes.setMessage(String.valueOf(code.value()) + " - " + message);
	    
	    Metadata apiError = new Metadata();
	    apiError.setStatus(new ArrayList<>());
	    apiError.getStatus().add(statusRes);
	    
	    return new ResponseEntity<Object>(apiError, code);
	}
}
