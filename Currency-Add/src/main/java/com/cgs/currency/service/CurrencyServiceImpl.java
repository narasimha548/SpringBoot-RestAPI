package com.cgs.currency.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.currency.dto.CurrencyFundsDto;
import com.cgs.currency.entity.CurrencyFundsEntity;
import com.cgs.currency.repository.CurrencyRepository;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyRepository currencyRepo;

	@Override
	public boolean saveCurrencyDetails(CurrencyFundsDto dto) {
		CurrencyFundsEntity entity = new CurrencyFundsEntity();
		BeanUtils.copyProperties(dto, entity);
		CurrencyFundsEntity currencyFundsEntity = currencyRepo.save(entity);
		
		if (currencyFundsEntity.getCurrencyId() != null) 
			return true;
		
		return false;
	}

	@Override
	public CurrencyFundsDto findById(Integer currencyId) {

		return null;
	}

	@Override
	public List<CurrencyFundsDto> findAll() {

		return null;
	}

}
