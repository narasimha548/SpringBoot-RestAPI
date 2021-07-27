package com.cgs.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cgs.entiy.HsmDetailsEntity;

public interface HsmDetailsRepository extends JpaRepository<HsmDetailsEntity, Integer> {

	@Query(value = "SELECT HSM_ID,ADDED_BY,ADDED_DATE,AUTH_BY,AUTH_CODE,AUTH_DATE,CONNECTION_INTERVEL,"
			+ "HEADER_LEN,HEADER_TYPE,HSM_ADDRESS,HSM_HEADER_LEN,HSM_NAME,HSM_PORT,HSM_PROTOCOL,HSM_STATUS,"
			+ "HSMTIME_OUT,HSM_TYPE,REMARKS "
			+ " FROM HSM_DETAILS H WHERE ADDED_BY!='SUPERADMIN2' AND AUTH_CODE IS NULL", nativeQuery = true)
	List<Object[]> findUnauthorizedHsmDetails();

	List<HsmDetailsEntity> findAll();

	@Modifying
	@Query(value = "UPDATE  HSM_DETAILS H SET H.AUTH_CODE=:authCode,H.AUTH_DATE=:authDate,H.AUTH_BY=:authBy where H.HSM_ID=:hsmId ", nativeQuery = true)
	Integer authorizeHsmDetailsById(@Param("authCode") String authCode, @Param("authDate") Date authDate,
			@Param("authBy")String authBy, @Param("hsmId") Integer hsmId);

}
