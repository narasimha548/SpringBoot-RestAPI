package com.cgs.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.cgs.dto.HsmDetailsDto;
import com.cgs.entiy.HsmDetailsEntity;

/**
 * This class is used to convert the List of Object data to DTO List
 * 
 * @author Prasad
 * @version 1.0
 * @since JDK-8
 * @Date 27-07-2021
 *
 */
public class HsmDetailsMapper {

	/**
	 * This method is used to process List of Object to Custom List Objects
	 * 
	 * @param hsmDtlsObjArray
	 * @return List<HsmDetailsDto>
	 */
	public static List<HsmDetailsDto> processEntityToDto(List<HsmDetailsEntity> hsmDtlsList) {

		return hsmDtlsList.stream().map(dto -> {
			HsmDetailsDto hsmDto = new HsmDetailsDto();
			hsmDto.setHsmId(dto.getHsmId());
			hsmDto.setAddedBy(dto.getAddedBy());
			hsmDto.setAddedDate(dto.getAddedDate());
			hsmDto.setAuthBy(dto.getAuthBy());
			hsmDto.setAuthCode(dto.getAuthCode());
			hsmDto.setAuthDate(dto.getAuthDate());
			hsmDto.setConnectionIntervel(dto.getConnectionIntervel());
			hsmDto.setHeaderLen(dto.getHeaderLen());
			hsmDto.setHeaderType(dto.getHeaderType());
			hsmDto.setHsmAddress(dto.getHsmAddress());
			hsmDto.setHsmHeaderLen(dto.getHsmHeaderLen());
			hsmDto.setHsmName(dto.getHsmName());
			hsmDto.setHsmPort(dto.getHsmPort());
			hsmDto.setHsmProtocol(dto.getHsmProtocol());
			hsmDto.setHsmStatus(dto.getHsmStatus());
			hsmDto.setHsmTImeOut(dto.getHsmTImeOut());
			hsmDto.setHsmType(dto.getHsmType());
			hsmDto.setRemarks(dto.getRemarks());
			return hsmDto;
		}).collect(Collectors.toList());
	}

	/**
	 * This method is used to process List of Object Arrays to Custom List Objects
	 * 
	 * @param hsmDtlsObjArray
	 * @return List<HsmDetailsDto>
	 */
	public static List<HsmDetailsDto> processEnityToHsmDto(List<Object[]> hsmDtlsObjArray) {

		return hsmDtlsObjArray.stream().map(curObj -> {
			HsmDetailsDto dto = new HsmDetailsDto();
			dto.setHsmId(Integer.parseInt(((BigDecimal) curObj[0]).toString()));
			// dto.setHsmId((Integer) curObj[0]);
			dto.setAddedBy((String) curObj[1]);
			dto.setAddedDate((Date) curObj[2]);
			dto.setAuthBy((String) curObj[3]);
			dto.setAuthCode((String) curObj[4]);
			dto.setAuthDate((Date) curObj[5]);
			dto.setConnectionIntervel((String) curObj[6]);
			dto.setHeaderLen((String) curObj[7]);
			dto.setHeaderType((String) curObj[8]);
			dto.setHsmAddress((String) curObj[9]);
			dto.setHsmHeaderLen((String) curObj[10]);
			dto.setHsmName((String) curObj[11]);
			dto.setHsmPort((String) curObj[12]);
			dto.setHsmProtocol((String) curObj[13]);
			dto.setHsmStatus((String) curObj[14]);
			dto.setHsmTImeOut((String) curObj[15]);
			dto.setHsmType((String) curObj[16]);
			dto.setRemarks((String) curObj[17]);

			return dto;
		}).collect(Collectors.toList());

	}

}
