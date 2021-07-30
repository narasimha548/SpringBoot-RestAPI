package com.cgs.currency.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalCurrencyDto {
	private Integer globalCurrencyId;
	private String currencyDesc;
	private String currencyCode;
	private String numericCode;
	private String currencySymbol;
	private String currencyStatus;
	private String authCode;
	private String authBy;
	private String addedBy;
	private String remarks;
}
