package com.cgs.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cgs.license.LicenseConfiguration;

/**
 * This Class represents the reading original license file and encrypt the file
 * 
 * 
 * 
 * @author Prasad
 * @version 1.0
 * @since 08-07-2021
 *
 */



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class LicenseManagerRestcontroller {

	@Autowired
	private LicenseConfiguration licenseConfiguration;

	@RequestMapping(value = "/getInstId", method = RequestMethod.GET)
	public ResponseEntity<String> encryptFile( @RequestParam String instid) {

		System.out.println("Instid is ::::  " + instid);
		System.out.println("Instid is length ::::  " + instid.length());

		  if(instid.isEmpty() || instid.equalsIgnoreCase("null")) {

				return new ResponseEntity<String>("Instituation Id Value not Found " ,HttpStatus.NOT_FOUND);
		  } else {
			return licenseConfiguration.encryptLicenseFile(instid);
		  }
	}

}
