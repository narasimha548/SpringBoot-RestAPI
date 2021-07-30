package com.cgs.currency.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cgs.currency.entity.GlobalCurrencyEntity;
import com.cgs.currency.sql.constants.GlobalCurrencySqlConstants;

public interface GlobalCurrencyRepository extends JpaRepository<GlobalCurrencyEntity, Integer>{
	
	@Query(value = GlobalCurrencySqlConstants.GLOBAL_CURRENCY_WAITING_FOR_AUTHORIZE_QUERY,nativeQuery = true)
	List<Object[]> findGlobalCurrencyDetailsWaitingforAuthorize();

}
