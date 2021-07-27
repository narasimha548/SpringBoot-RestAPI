package com.cgs.dto;

import java.util.Date;


import lombok.Data;

@Data
public class HsmDetailsDto {

	
	
	private Integer hsmId;
	private String hsmName;
	private String hsmProtocol;
	private String hsmType;
	private String hsmAddress;
	private String hsmPort;
	private String headerLen;
	private String headerType;
	private String hsmHeaderLen;
	private String hsmTImeOut;
	private String connectionIntervel;
	private String hsmStatus;
	private String addedBy;
	private Date addedDate;
	private String remarks;
	private String authCode;
	private Date authDate;
	private String authBy;

}
