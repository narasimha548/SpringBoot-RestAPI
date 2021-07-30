package com.cgs.currency.service;

import java.util.List;

import com.cgs.currency.dto.GlobalCurrencyDto;

public interface GlobalCurrencyService {

	Integer saveGlobalCurrencyDetails(GlobalCurrencyDto dto);

	List<GlobalCurrencyDto> findGlobalCurrencyAUthorizationDetails();

	GlobalCurrencyDto findById(Integer globalCurrencyId);

	Integer authorizeGlobalCurrencyDetails(Integer id,String authBy,String authCode,String currencyStatus);

}
