package com.cgs.dto;

import java.util.Date;

import lombok.Data;


@Data
public class HsmDetailsDto {
	
	
	

	public HsmDetailsDto(Object[] objects) {
		
	}
	
	
	public HsmDetailsDto(Integer hsmId, String hsmName, String hsmProtocol, String hsmType, String hsmAddress,
			String hsmPort, String headerLen, String headerType, String hsmHeaderLen, String hsmTImeOut,
			String connectionIntervel, String hsmStatus, String addedBy, Date addedDate, String remarks,
			String authCode, Date authDate, String authBy) {
		super();
		this.hsmId = hsmId;
		this.hsmName = hsmName;
		this.hsmProtocol = hsmProtocol;
		this.hsmType = hsmType;
		this.hsmAddress = hsmAddress;
		this.hsmPort = hsmPort;
		this.headerLen = headerLen;
		this.headerType = headerType;
		this.hsmHeaderLen = hsmHeaderLen;
		this.hsmTImeOut = hsmTImeOut;
		this.connectionIntervel = connectionIntervel;
		this.hsmStatus = hsmStatus;
		this.addedBy = addedBy;
		this.addedDate = addedDate;
		this.remarks = remarks;
		this.authCode = authCode;
		this.authDate = authDate;
		this.authBy = authBy;
	}


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
