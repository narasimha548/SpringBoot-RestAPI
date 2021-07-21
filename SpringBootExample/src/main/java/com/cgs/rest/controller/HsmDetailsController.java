package com.cgs.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgs.entiy.HsmDetailsEntity;
import com.cgs.service.HsmService.HsmService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/hsmDetails")
public class HsmDetailsController {
	
	@Autowired
	private HsmService hsmService;
	
	@RequestMapping(value = "/saveHsmDetails", method = RequestMethod.POST)
	public ResponseEntity<String>   saveHsmDetails(@Valid @RequestBody HsmDetailsEntity hsmDtls){
		
		
		  Integer hsmId = hsmService.saveHsmDetails(hsmDtls);
		  
		  if(hsmId !=null)
			  return new ResponseEntity<String>(hsmId+" HSM details saved successfully ",HttpStatus.CREATED);
		  else
			  return new ResponseEntity<String>("HSM Details not Saved!!!!",HttpStatus.NOT_MODIFIED);
		
		
	}
	
	@GetMapping("/getHsmDtls")
	public String hsmAu() {
		    
		if(hsmService.findHsmDetailsWaitingForAuthorize().size() >0) {
			System.out.println(" details are :::: ");
		}else
			return null;
		return null;
		    
		  
		
	}

}
