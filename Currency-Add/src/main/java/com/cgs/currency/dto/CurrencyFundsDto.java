package com.cgs.currency.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyFundsDto {
	
	
	private Integer currencyId;
	private String entity;
	private String currency;
	private String alphabeticCode;
	private String numericCode;
	private String minorUnit;
	private String currencySymbol;
	

}
