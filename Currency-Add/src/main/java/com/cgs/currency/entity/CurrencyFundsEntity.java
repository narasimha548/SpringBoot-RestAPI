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
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "Currency_funds_code")
@EntityListeners(AuditingEntityListener.class)
public class CurrencyFundsEntity {
	
	@Id
	@GeneratedValue(generator="cur_id_gen")
	@GenericGenerator(name="cur_id_gen",strategy="increment")
	private Integer currencyId;
	
	@NotEmpty(message = "Please provide entity")
	private String entity;
	
	@NotEmpty(message = "Please provide currency")
	private String currency;
	
	@NotEmpty(message = "Please provide alphabeticCode")
	private String alphabeticCode;
	
	@NotEmpty(message = "Please provide numericCode")
	private String numericCode;
	
	@NotEmpty(message = "Please provide minorUnit")
	private String minorUnit;
	
	@NotEmpty(message = "Please provide currencySymbol")
	private String currencySymbol;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE",updatable = false)
	private Date creationDate;
	
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE",insertable =  false)
	private Date updationDate;

}
