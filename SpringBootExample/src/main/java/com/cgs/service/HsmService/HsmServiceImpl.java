package com.cgs.service.HsmService;

import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgs.dto.HsmDetailsDto;
import com.cgs.entiy.HsmDetailsEntity;
import com.cgs.repository.HsmDetailsRepository;

@Service
public class HsmServiceImpl implements HsmService {

	@Autowired
	private HsmDetailsRepository hsmRepo;

	@Override
	@Transactional
	public Integer saveHsmDetails(HsmDetailsEntity hsmDtlsEntity) {

		System.out.println("HSM Details object :::: " + hsmDtlsEntity);

		return hsmRepo.save(hsmDtlsEntity).getHsmId();
	}

	public List<Object[]> findHsmDetailsWaitingForAuthorize() {

		List<Object[]> findUnauthorizedHsmDetails = hsmRepo.findUnauthorizedHsmDetails();
		
		findUnauthorizedHsmDetails.stream().map(HsmDetailsDto::new);

		System.out.println(" Data is ::::: " + findUnauthorizedHsmDetails.get(0)[0]);
		System.out.println(" Data is ::::: " + findUnauthorizedHsmDetails.get(0)[1]);

		System.out.println(" hfhfhfhf  : " + findUnauthorizedHsmDetails);
		return findUnauthorizedHsmDetails;

	}

}
