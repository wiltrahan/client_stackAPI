package com.client_stack_ang.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClientRestExceptionHandler {
	
	
		//Add an exception handler for bad id
		@ExceptionHandler
		public ResponseEntity<ClientErrorResponse> handleException(ClientNotFoundException exc) {
			
			//create a ClientErrorResponse
			ClientErrorResponse error = new ClientErrorResponse(
												HttpStatus.NOT_FOUND.value(),
												exc.getMessage(),
												System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		
		//handle any other exception
		@ExceptionHandler
		public ResponseEntity<ClientErrorResponse> handleException(Exception exc) {
			
			ClientErrorResponse error = new ClientErrorResponse(
												HttpStatus.BAD_REQUEST.value(),
												exc.getMessage(),
												System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}	
}
