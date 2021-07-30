package com.cgs.currency.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cgs.currency.dto.GlobalCurrencyDto;
import com.cgs.currency.service.GlobalCurrencyService;

@RestController
@RequestMapping("/globalCurrency")
public class GlobalCurrencyRestController {

	@Autowired
	private GlobalCurrencyService service;

	@PostMapping("/saveGlobalCurrencyDetails")
	public ResponseEntity<Object> saveGlobalCurrencyService(@RequestBody GlobalCurrencyDto dto) {
		Integer id = null;

		id = service.saveGlobalCurrencyDetails(dto);
		if (id != null)
			return new ResponseEntity<Object>("Global Currency saved with the ID :: " + id, HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Global Currency Failed :: " + id, HttpStatus.NOT_FOUND);

	}

	@GetMapping("/getGlobalCurrency")
	public ResponseEntity<Object> getGlobalCurrencyDetails() {

		List<GlobalCurrencyDto> globalCurrencyAUthorizationDetails = service.findGlobalCurrencyAUthorizationDetails();

		if (globalCurrencyAUthorizationDetails.isEmpty())
			return new ResponseEntity<Object>("No Details Found !! waiting for global currency", HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<Object>("Global Currency Details :: " + globalCurrencyAUthorizationDetails,
					HttpStatus.OK);
	}

}
