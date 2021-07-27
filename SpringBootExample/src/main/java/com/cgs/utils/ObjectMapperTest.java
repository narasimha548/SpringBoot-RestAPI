package com.cgs.utils;

import java.util.Date;

import com.cgs.dto.HsmDetailsDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperTest {
	
	public static void main(String[] args) throws Exception {
		
		ObjectMapper obj=new ObjectMapper();
		
		HsmDetailsDto dto = new HsmDetailsDto(1, "Test HSM", "TCP/IP", "SafeNet", "172.16.10.21", "4000", "4", "ASCII", "4",
				"30", "30", "1", "superadmin1", new Date(), "hsm test", null, null, null);
		
		String string = obj.writeValueAsString(dto);
		
		System.out.println(" json object "+string);
		
		
	}

}
