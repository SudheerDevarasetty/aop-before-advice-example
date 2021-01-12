package com.javatpoint.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseError> handleGenericException(Exception ex, WebRequest request) {
		/*
		 * ResponseError responseError = new ResponseError(LocalDateTime.now(),
		 * HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage());
		 */

		
		  ResponseError responseError = ResponseError.builder()
		  .errorCode(HttpStatus.INTERNAL_SERVER_ERROR) .timestamp(LocalDateTime.now())
		  .details(ex.getLocalizedMessage()) .build();
		 
		 // LOGGER.error("Item Planning Exception caught at Rest Controller Advice.", ex);
		return new ResponseEntity<>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
