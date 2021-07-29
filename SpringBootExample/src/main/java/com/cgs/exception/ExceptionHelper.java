package com.cgs.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.cgs.error.response.ErrorResponse;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class ExceptionHelper {

	private List<String> errors;

	@ExceptionHandler(InstitutionNotFoundException.class)
	public final ResponseEntity<Object> institutionNotFound(InstitutionNotFoundException instExce, WebRequest webReq)
			throws Exception {
		List<String> details = new ArrayList<>();
		details.add(instExce.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Instituation", details);
		ObjectMapper objectMap = new ObjectMapper();
		objectMap.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String json = objectMap.writeValueAsString(error);
		return new ResponseEntity<Object>(json, HttpStatus.NOT_FOUND);

	}

	
	@ExceptionHandler(BeanPropertyValidationException.class)
	public final ResponseEntity<Object> beanPropertyValidationException(BeanPropertyBindingResult bindResult,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		
		Map<String, Object> body=new HashMap<>();
		body.put("timestamp", new Date());
		body.put("Status", status.value());
		
		errors = bindResult.getAllErrors().stream().map(fun->fun.getDefaultMessage()).collect(Collectors.toList());
		body.put("Exception",errors);
		
		return new ResponseEntity<Object>(body,headers,status);

	}
	
	@ExceptionHandler(HsmEntityToDtoConversionException.class)
	public final ResponseEntity<Object>  entityToDtoConversionException(HsmEntityToDtoConversionException exce,WebRequest req) throws Exception{
		List<String> lst=Arrays.asList(exce.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("HSmEntityToDTOCOnversion", lst);
		
		ObjectMapper objectMap = new ObjectMapper();
		objectMap.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String json = objectMap.writeValueAsString(error);
		return new ResponseEntity<Object>(json, HttpStatus.NOT_FOUND);
	}
	
	
	

}
