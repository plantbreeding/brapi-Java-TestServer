package org.brapi.test.BrAPITestServer;

import java.util.ArrayList;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import io.swagger.model.Metadata;
import io.swagger.model.Status;
import io.swagger.model.Status.MessageTypeEnum;

@ControllerAdvice
public class BrapiExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(BrapiExceptionHandler.class);

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getParameterName() + " parameter is missing");
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}

		String message = ex.getMessage();
		if (message.length() > 204)
			message = message.substring(0, 200) + " ...";

//		log.error(message, ex);
		log.debug(message, ex);
		
		return buildErrorResponse(status, message);
	}

	@ExceptionHandler(value = { BrAPIServerException.class })
	protected ResponseEntity<Object> handleBrAPIException(BrAPIServerException e, WebRequest request) {
		String message = e.getResponseMessage().replaceAll("\"", "\'");
		log.error(message);
		log.debug(message, e);
		return new ResponseEntity<Object>("\"" + message + "\"", e.getResponseStatus());
	}

	@ExceptionHandler
	public ResponseEntity<Object> handle(Exception e) {
		String message = "Server Error: \n" + e.getStackTrace()[0].toString() + "\n" + e.getStackTrace()[1].toString()
				+ "\n" + e.getStackTrace()[2].toString() + "\n" + "...";
		log.error(message, e);
		log.debug(message, e);
		return new ResponseEntity<Object>("\"" + message + "\"", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<Object> buildErrorResponse(HttpStatus code, String message) {
		String apiError = String.valueOf(code.value()) + " \n" + code.getReasonPhrase() + " \n" + message;

		return new ResponseEntity<Object>(apiError, code);
	}
}
