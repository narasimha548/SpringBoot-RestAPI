package com.cgs.service.HsmService;

import java.util.List;

import com.cgs.dto.HsmDetailsDto;
import com.cgs.entiy.HsmDetailsEntity;

/**
 * This interface is used to provide the functions of HSM Module
 * 
 * @author Prasad
 * @version 1.0
 * @since JDK 8
 * @Date 26-07-2021
 * 
 *
 */
public interface HsmService {
    
	/**
	 * This method is used  save HSM Entity details
	 * 
	 * @param hsmDtlsEntity
	 * @return Integer
	 */
	Integer saveHsmDetails(HsmDetailsEntity hsmDtlsEntity);

	/*
	 * Returns List of HSMDetailsDto objects 
	 * 
	 * @return List<HsmDetailsDto>
	 */
	List<HsmDetailsDto> findHsmDetailsWaitingForAuthorize();

	/*
	 * This method is used to  authorize  HSMdetails
	 * 
	 * @return Integer
	 */
	Integer authorizeHsmDetailsById(Integer hsmId, String authBy, String authCode);
	
	
	
	/*
	 * Returns List of HSMDetailsDto objects 
	 * 
	 * @return List<HsmDetailsDto>
	 */
	List<HsmDetailsDto> findAll();
	
    
	/**
	 * This method is used to edit/update HSM details
	 * @return Integer
	 */
	Integer  updateHsmDetails(Integer hsmId);
	
	/**
	 * This method is used to find the HSM details by Id
	 * 
	 * @param hsmId
	 * @return HsmDetailsDto
	 */
	HsmDetailsDto findById(Integer hsmId);
	
}
