package com.cgs.currency.service;

import java.util.List;


import com.cgs.currency.dto.CurrencyFundsDto;

public interface CurrencyService {
	
	boolean saveCurrencyDetails(CurrencyFundsDto dto);
	List<CurrencyFundsDto> findAll();
	CurrencyFundsDto findById(Integer currencyId);
}
