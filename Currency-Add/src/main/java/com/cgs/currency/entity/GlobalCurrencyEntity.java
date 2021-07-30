package com.cgs.currency.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name = "GLOBAL_CURRENCY")
@Data
@EntityListeners(AuditingEntityListener.class)
public class GlobalCurrencyEntity {
	
	@Id
	@GeneratedValue(generator="global_cur_id_gen")
	@GenericGenerator(name="global_cur_id_gen",strategy="increment")
	private Integer globalCurrencyId;
	
	private String currencyDesc;
	private String currencyCode;
	private String numericCode;
	private String currencySymbol;
	private String currencyStatus;
	private String authCode;
	private String authBy;
	private String addedBy;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE",updatable = false)
	private Date addedDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE",insertable =  false)
	private Date authDate; 
	
	
	private String remarks;
	
}
