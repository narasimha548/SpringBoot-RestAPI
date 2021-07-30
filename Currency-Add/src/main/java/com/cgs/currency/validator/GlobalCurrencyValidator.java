package com.cgs.currency.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cgs.currency.dto.GlobalCurrencyDto;

@Component
public class GlobalCurrencyValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return GlobalCurrencyDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		GlobalCurrencyDto dto = (GlobalCurrencyDto) target;
		
		if(dto.getCurrencyCode()==null || "".equals(dto.getCurrencyCode())) {
			errors.rejectValue("Currency Code", "ERR-01", "Currency code empty ! Please enter Currency Code !!!");
		}else if(dto.getCurrencyCode().length() >6) {
			errors.rejectValue("Currency Code", "ERR-02", "Currency Code should be 6 characters !! please Enter correct code");
		}
		
		if(dto.getCurrencyDesc()==null || "".equals(dto.getCurrencyDesc())) {
			errors.rejectValue("Currency Desc", "ERR-03", "Currency Description should not be null");
		}
		
		if(dto.getNumericCode()==null || "".equals(dto.getNumericCode())) {
			errors.rejectValue("Numeric Code", "ERR-04", "Numeric Code should not be null");
		}else if(dto.getCurrencyCode().length() >6) {
			errors.rejectValue("Currency Code", "ERR-05", "Numeric Code should be 6 characters !! please Enter correct code");
		}
		
		if(!StringUtils.hasLength(dto.getCurrencySymbol())) {
			errors.rejectValue("Currency Symbol", "ERR-06", "Currency Symbol should should not be null !!");
		}
		
		if(dto.getCurrencyStatus()==null) {
			errors.rejectValue("Currency status", "ERR-07", "Currency status should should not be null !!");
		}
		
		

	}
	
	private String validate() {
		return null;
	}

}
