package com.cgs.currency.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.cgs.currency.dto.GlobalCurrencyDto;

public class GlobalCurrencyMapper {
	
	

	public  static List<GlobalCurrencyDto> processGLobalCurrencyList(List<Object[]>  objArray){
		
		 return objArray.stream().map(curObj->{
			 GlobalCurrencyDto dto=new GlobalCurrencyDto();
			 dto.setGlobalCurrencyId(Integer.parseInt(((BigDecimal) curObj[0]).toString()));
			 dto.setCurrencyDesc((String)curObj[1]);
			 dto.setCurrencyCode((String)curObj[2]);
			 dto.setCurrencyStatus((String)curObj[3]);
			 dto.setAuthCode((String)curObj[4]);
			 dto.setAddedBy((String)curObj[5]);
			 dto.setRemarks((String)curObj[6]);
			 
			return dto; 
		 }).collect(Collectors.toList());
		
		
	}
	

}
