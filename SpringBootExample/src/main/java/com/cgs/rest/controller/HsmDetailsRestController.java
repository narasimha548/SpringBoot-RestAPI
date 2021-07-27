package com.cgs.rest.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgs.dto.HsmDetailsDto;
import com.cgs.entiy.HsmDetailsEntity;
import com.cgs.service.HsmService.HsmService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


/**
 * This Class Represents the Implement the Hsm functionality
 * 
 * 
 * @author Prasad
 * @since JDK-8.0
 * @version 1.0
 * @Date 27-7-2021
 * 
 * 
 */
@RestController
@RequestMapping("/hsmDetails")
public class HsmDetailsRestController {

	@Autowired
	private HsmService hsmService;

	public HsmDetailsRestController(HsmService hsmService) {
		this.hsmService = hsmService;
	}
	
	

	@RequestMapping(value = "/saveHsmDetails", method = RequestMethod.POST)
	public ResponseEntity<String> saveHsmDetails(@Valid @RequestBody HsmDetailsEntity hsmDtls) {

		Integer hsmId = hsmService.saveHsmDetails(hsmDtls);

		if (hsmId != null)
			return new ResponseEntity<String>(hsmId + " HSM details saved successfully ", HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("HSM Details not Saved!!!!", HttpStatus.NOT_MODIFIED);

	}

	@GetMapping("/getHsmDtls")
	public ResponseEntity<Object> hsmDetailWaitingForAuthorization() {

		List<HsmDetailsDto> hsmDetailsWaitingForAuthorize = hsmService.findHsmDetailsWaitingForAuthorize();
		if (hsmDetailsWaitingForAuthorize.size() > 0)
			return new ResponseEntity<Object>(hsmDetailsWaitingForAuthorize, HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No HSM details to be authorized!!!!", HttpStatus.NOT_FOUND);

	}

	@GetMapping("/authorizeHsmDetails/{hsmId}/{authCode}/{authBy}")
	public String authorizeHsmDetails(@PathVariable Integer hsmId, @PathVariable String authCode,
			@PathVariable String authBy) {
		Integer id = hsmService.authorizeHsmDetailsById(hsmId, authBy, authCode);
		return "Authorized HSM details with the HSM ID " + id;
	}
	
	
	@GetMapping("/findAllHsmDetails")
	public ResponseEntity<List<HsmDetailsDto>> findAllHsmDetails(){
		return new ResponseEntity<List<HsmDetailsDto>>(hsmService.findAll(),HttpStatus.OK);
	}
	
	
	@PutMapping("/updateHsmDetails/{hsmId}")
	public ResponseEntity<String> updateHsmDetailsByHsmId(@PathVariable Integer hsmId){
		Integer id=hsmService.updateHsmDetails(hsmId);
		if(id==0) 
			return new ResponseEntity<String>("Failed Edit the HSM details for the HSM id "+hsmId,HttpStatus.NOT_FOUND);
		else
		return new ResponseEntity<String>("Hsm Details Edit with ID : "+id,HttpStatus.CREATED);
		
	}
	

}
