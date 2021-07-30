package com.cgs.currency.service;

import java.util.List;

import com.cgs.currency.dto.GlobalCurrencyDto;

public interface GlobalCurrencyService {
	
	Integer saveGlobalCurrencyDetails(GlobalCurrencyDto dto);
	
    List<GlobalCurrencyDto> findGlobalCurrencyAUthorizationDetails();

}
