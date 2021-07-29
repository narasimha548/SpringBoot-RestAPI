package com.cgs.currency.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgs.currency.entity.CurrencyFundsEntity;

public interface CurrencyRepository extends JpaRepository<CurrencyFundsEntity, Integer>{

}
