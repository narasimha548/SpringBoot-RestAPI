package com.cgs.currency.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cgs.currency.custom.exception.GlobalCurrencyDTOConversionException;
import com.cgs.currency.dto.GlobalCurrencyDto;
import com.cgs.currency.entity.GlobalCurrencyEntity;
import com.cgs.currency.mapper.GlobalCurrencyMapper;
import com.cgs.currency.repository.GlobalCurrencyRepository;

@Service
public class GlobalCurrencyServiceImpl implements GlobalCurrencyService {

	@Autowired
	private GlobalCurrencyRepository repo;

	@Override
	public Integer saveGlobalCurrencyDetails(GlobalCurrencyDto dto) {

		GlobalCurrencyEntity entity = new GlobalCurrencyEntity();
		BeanUtils.copyProperties(dto, entity);
		GlobalCurrencyEntity globalCurrEntity = repo.save(entity);

		if (globalCurrEntity.getGlobalCurrencyId() != null)
			return globalCurrEntity.getGlobalCurrencyId();
		return null;
	}

	@Override
	public List<GlobalCurrencyDto> findGlobalCurrencyAUthorizationDetails() {
		List<GlobalCurrencyDto> globalCurrencyList = null;

		try {
			globalCurrencyList = GlobalCurrencyMapper
					.processGLobalCurrencyList(repo.findGlobalCurrencyDetailsWaitingforAuthorize());
		} catch (GlobalCurrencyDTOConversionException exce) {
			exce.getMessage();
		}
		return globalCurrencyList;
	}

	@Override
	public GlobalCurrencyDto findById(Integer globalCurrencyId) {

		Optional<GlobalCurrencyEntity> globalCurEntity = repo.findById(globalCurrencyId);
		
		if(globalCurEntity.isPresent()) {
			  GlobalCurrencyDto dto=new GlobalCurrencyDto();
			  BeanUtils.copyProperties(globalCurEntity.get(), dto);
			  return dto;
		}

		return null;
	}

	@Override
	public Integer authorizeGlobalCurrencyDetails(Integer id, String authBy, String authCode, String currencyStatus) {
		
		    Optional<GlobalCurrencyEntity> entity = repo.findById(id);
		    
		    if(entity.isPresent()) {
		    	GlobalCurrencyEntity globalCurrencyEntity = entity.get();
		    	globalCurrencyEntity.setAuthBy(authBy);
		    	globalCurrencyEntity.setAuthCode(authCode);
		    	globalCurrencyEntity.setCurrencyStatus(currencyStatus);
		    	return repo.save(globalCurrencyEntity).getGlobalCurrencyId();
		    }
		
		return null;
	}
}
