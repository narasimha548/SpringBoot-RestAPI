package com.cgs.currency.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgs.currency.custom.exception.CurrencyFundFailedException;
import com.cgs.currency.dto.CurrencyFundsDto;
import com.cgs.currency.service.CurrencyService;



@RestController
@RequestMapping("/currency")
public class CurrencyRestController {

	@Autowired
	private CurrencyService service;

	@RequestMapping(value = "/addCurrency", method = RequestMethod.POST)
	public ResponseEntity<String> saveCurrencyDetails(@RequestBody CurrencyFundsDto dto) {

		boolean saveCurrencyDetails = service.saveCurrencyDetails(dto);

		if (saveCurrencyDetails)
			return new ResponseEntity<String>("Currency Code added successfully", HttpStatus.CREATED);
		else
			throw new CurrencyFundFailedException("Failed to Save currency details ....");

	}

}
