package com.cgs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cgs.entiy.HsmDetailsEntity;

public interface HsmDetailsRepository  extends JpaRepository<HsmDetailsEntity, Integer>{
   
	
      @Query(value="SELECT HSM_ID,ADDED_BY,ADDED_DATE,AUTH_BY,AUTH_CODE,AUTH_DATE,CONNECTION_INTERVEL,"
      		+ "HEADER_LEN,HEADER_TYPE,HSM_ADDRESS,HSM_HEADER_LEN,HSM_NAME,HSM_PORT,HSM_PROTOCOL,HSM_STATUS,"
      		+ "HSMTIME_OUT,HSM_TYPE,REMARKS "
      		+ " FROM HSM_DETAILS H WHERE ADDED_BY!='SUPERADMIN2' AND  HSM_ID=1 ",nativeQuery=true)	
      List<Object[]> findUnauthorizedHsmDetails();
      
      
	  List<HsmDetailsEntity> findAll(); 
	
    
    
}
