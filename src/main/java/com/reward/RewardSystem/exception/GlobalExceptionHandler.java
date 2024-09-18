package com.reward.RewardSystem.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex){
		ApiError apiError=new ApiError(HttpStatus.NOT_FOUND,ex.getMessage(),"Entity not found");
		return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions(Exception ex){
		ApiError apiError=new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage(),"An error occured");
		return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
