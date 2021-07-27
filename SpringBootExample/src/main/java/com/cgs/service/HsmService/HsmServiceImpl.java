package com.cgs.service.HsmService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cgs.dto.HsmDetailsDto;
import com.cgs.entiy.HsmDetailsEntity;
import com.cgs.exception.HsmEntityToDtoConversionException;
import com.cgs.repository.HsmDetailsRepository;
import com.cgs.utils.HsmDetailsMapper;

/**
 * This class is used write the main functionality and handling the exceptions
 * 
 * 
 * @author Prasad
 * @version 1.0
 * @since JDK - 8.0
 * @Date 08-07-2021
 *
 */
@Service
public class HsmServiceImpl implements HsmService {

	private HsmDetailsRepository hsmRepo;

	public HsmServiceImpl(HsmDetailsRepository hsmRepo) {
		this.hsmRepo = hsmRepo;
	}

	/**
	 * This method is used save HSM Entity details
	 * 
	 * @param hsmDtlsEntity
	 * @return Integer
	 */
	@Override
	@Transactional
	public Integer saveHsmDetails(HsmDetailsEntity hsmDtlsEntity) {

		System.out.println("HSM Details object :::: " + hsmDtlsEntity);

		return hsmRepo.save(hsmDtlsEntity).getHsmId();
	}

	/*
	 * Returns List of Un-authorized HSM details object
	 * 
	 * @return List<HsmDetailsDto>
	 */
	@Override
	public List<HsmDetailsDto> findHsmDetailsWaitingForAuthorize() {
		List<Object[]> findUnauthorizedHsmDetails = hsmRepo.findUnauthorizedHsmDetails();
		List<HsmDetailsDto> processEnityToHsmDto = HsmDetailsMapper.processEnityToHsmDto(findUnauthorizedHsmDetails);
		return processEnityToHsmDto;

	}

	/**
	 * This method is used to authorize the HSM details
	 * 
	 * returns Integer
	 */

	@Override
	@Transactional
	public Integer authorizeHsmDetailsById(Integer hsmId, String authBy, String authCode) {
		return hsmRepo.authorizeHsmDetailsById(authCode, new Date(), authBy, hsmId);
	}

	/*
	 * Returns List of HSMDetailsDto objects
	 * 
	 * @return List<HsmDetailsDto>
	 */
	@Override
	public List<HsmDetailsDto> findAll() {

		List<HsmDetailsEntity> hsmEntityList = hsmRepo.findAll();

		List<HsmDetailsDto> processEntityToDto = HsmDetailsMapper.processEntityToDto(hsmEntityList);

		if (processEntityToDto == null || processEntityToDto.isEmpty())
			throw new HsmEntityToDtoConversionException("Bean Conversion Failed !!!! ");
		else
			return processEntityToDto;
	}

	/**
	 * This method is used to find the HSM details by Id
	 * 
	 * @param hsmId
	 * @return HsmDetailsDto
	 */
	@Override
	public HsmDetailsDto findById(Integer hsmId) {

		Optional<HsmDetailsEntity> hsmEntity = hsmRepo.findById(hsmId);

		if (hsmEntity.isPresent()) {
			HsmDetailsDto dto = new HsmDetailsDto();
			BeanUtils.copyProperties(hsmEntity.get(), dto);
			return dto;
		}
		return null;
	}

	/**
	 * This method is used to edit/update HSM details
	 * 
	 * @return Integer
	 */
	@Override
	public Integer updateHsmDetails(Integer hsmId) {

		Optional<HsmDetailsEntity> hsmDtlsEntityId = hsmRepo.findById(hsmId);

		if (hsmDtlsEntityId.isPresent()) {
			HsmDetailsEntity hsmDetailsEntity = hsmDtlsEntityId.get();
			hsmDetailsEntity.setAuthBy(null);
			hsmDetailsEntity.setAuthCode(null);
			hsmDetailsEntity.setAuthDate(null);
			return hsmRepo.save(hsmDetailsEntity).getHsmId();
		}

		return 0;
	}

}
