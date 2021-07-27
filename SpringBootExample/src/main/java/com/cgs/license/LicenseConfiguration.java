package com.cgs.license;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cgs.aes.algorithm.FileEncryption;
import com.cgs.exception.InstitutionNotFoundException;

/**
 * This class represents to read the License file
 * 
 * 
 * 
 * @author prasad
 * @version 1.0
 * @since 08-07-2021
 * 
 *
 */

@Component
public class LicenseConfiguration {

	@Value("${License-path}")
	private String licensePath;

	@Autowired
	private FileEncryption fileEncryption;

	/**
	 * This method is used to call the file encryption method to encrypt the file
	 * 
	 * 
	 * 
	 * @return ResponseEntity<String>
	 */
	public ResponseEntity<String> encryptLicenseFile(String instId) {

		System.out.println("licensePath  ******** " + licensePath);

		String filename = licensePath + instId + "License.txt".trim();
		String encryptFile = (licensePath + instId + "_enctrypted_License.txt");

		Map<String, String> resMap = fileEncryption.fileEncryption(filename, encryptFile);

		System.out.println(resMap);

		// Equivalent JAVA-8 Code below
		Entry<String, String> orElseThrow = resMap.entrySet().parallelStream()
				.filter(cuiid -> cuiid.getKey().equals("SCC-0")).findFirst()
				.orElseThrow(() -> new InstitutionNotFoundException(
						"Instituation Not Found !! Please check the Inst Id !!!"));
		
	

		return new ResponseEntity<>(orElseThrow.getValue(), HttpStatus.CREATED);

		// Find JAVA 7 Code below

		/*
		 * for (Map.Entry<String, String> entry : resMap.entrySet()) { keyRes =
		 * entry.getKey();
		 * 
		 * System.out.println("Key set from map " + keyRes); if
		 * (keyRes.equals("ERR-05")) throw new
		 * InstitutionNotFoundException("Instituation Not Found !! Please check the Inst Id !!!"
		 * ); else if (keyRes.equals("SCC-0")) { return new
		 * ResponseEntity<>(entry.getValue(), HttpStatus.CREATED); } }
		 */
		// return null;

	}

}
