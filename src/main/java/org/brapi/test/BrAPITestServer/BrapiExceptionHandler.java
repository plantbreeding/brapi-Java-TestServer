package org.brapi.test.BrAPITestServer;

import java.util.ArrayList;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.swagger.model.Metadata;
import io.swagger.model.Status;
import io.swagger.model.Status.MessageTypeEnum;

@ControllerAdvice
public class BrapiExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final Logger log = LoggerFactory.getLogger(BrapiExceptionHandler.class);
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	    String error = ex.getParameterName() + " parameter is missing";
	    
	    return buildErrorResponse(HttpStatus.BAD_REQUEST, error);
	}
	
	@ExceptionHandler(value = {BrAPIServerException.class})
	protected ResponseEntity<Object> handleBrAPIException(BrAPIServerException e, WebRequest request){
		String message = e.getResponseMessage().replaceAll("\"", "\'");
	    log.error(message);
	    log.debug(message, e);
	    return new ResponseEntity<Object>("\"" + message + "\"", e.getResponseStatus());		
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handle(Exception e) {
		String message = "Server Error: \n" 
				+ e.getStackTrace()[0].toString() + "\n"
				+ e.getStackTrace()[1].toString() + "\n"
				+ e.getStackTrace()[2].toString() + "\n"
				+ "...";
	    log.error(message, e);
	    log.debug(message, e);
	    return new ResponseEntity<Object>("\"" + message + "\"", HttpStatus.INTERNAL_SERVER_ERROR);	
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
