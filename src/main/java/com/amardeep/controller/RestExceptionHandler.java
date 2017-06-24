package com.amardeep.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amardeep.dto.ErrorPayload;
import com.amardeep.service.business.StudentException;

@ControllerAdvice
public class RestExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorPayload> handleGenericException(Exception ex){
		logger.error("#### handleGenericException ####"+ex);
		ErrorPayload payload=new ErrorPayload();
		payload.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorPayload>(payload,HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<ErrorPayload> handleStudentException(StudentException se){
		ErrorPayload payload=new ErrorPayload();
		payload.setErrorMessage(se.getMessage());
		return new ResponseEntity<ErrorPayload>(payload,HttpStatus.BAD_REQUEST);
	}
}
