package com.pms_spring_rest_data_jpa_project.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Map<String, Object> responseError = new HashMap<String, Object>();
		responseError.put("timestamp", LocalDateTime.now());
		List<String> allFieldErrorMsgs = new ArrayList<String>();
		ex.getBindingResult().getFieldErrors().forEach(fieldError -> allFieldErrorMsgs.add(fieldError.getField() + " " + fieldError.getDefaultMessage()));
		responseError.put("errors", allFieldErrorMsgs);
		return new ResponseEntity<Object>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Map> customHandlerForProductNotFound(ProductNotFoundException pe){
		Map<String, Object> responseError = new HashMap<String, Object>();
		responseError.put("timestamp", LocalDateTime.now());
		responseError.put("errMsg", pe.getMessage());
		return new ResponseEntity<Map>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
	}	
}
