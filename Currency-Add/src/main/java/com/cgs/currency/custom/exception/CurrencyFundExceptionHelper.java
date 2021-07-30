package com.cgs.currency.custom.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.cgs.currency.error.response.ErrorResponse;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class CurrencyFundExceptionHelper {

	@ExceptionHandler(CurrencyFundFailedException.class)
	public final ResponseEntity<Object> currencyFundFailed(CurrencyFundFailedException currException, WebRequest webReq)
			throws Exception {
		List<String> lst = Arrays.asList(currException.getLocalizedMessage());
		ErrorResponse errorRes = new ErrorResponse("CurrencyFundFailedException", lst);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String jsonErrorRes = mapper.writeValueAsString(errorRes);
		return new ResponseEntity<Object>(jsonErrorRes, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(GlobalCurrencyDTOConversionException.class)
	public final ResponseEntity<Object> dtoConversionException(GlobalCurrencyDTOConversionException exce,
			WebRequest req) throws Exception {
		List<String> lst = Arrays.asList(exce.getLocalizedMessage());
		ErrorResponse errorRes = new ErrorResponse("CurrencyFundFailedException", lst);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String jsonErrorRes = mapper.writeValueAsString(errorRes);
		return new ResponseEntity<Object>(jsonErrorRes, HttpStatus.NOT_FOUND);
	}

}
