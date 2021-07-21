package com.cgs.service.HsmService;

import java.util.List;

import com.cgs.entiy.HsmDetailsEntity;

public interface HsmService {
	
	Integer saveHsmDetails(HsmDetailsEntity hsmDtlsEntity);
	 List<Object[]> findHsmDetailsWaitingForAuthorize();
}
