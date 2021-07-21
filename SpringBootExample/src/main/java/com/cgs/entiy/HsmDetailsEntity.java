package com.cgs.entiy;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@Entity
@Table(name = "HSM_DETAILS")
@EntityListeners(AuditingEntityListener.class)
public class HsmDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer hsmId;

	@NotEmpty(message = "Please provide a HSM name")
	private String hsmName;

	@NotEmpty(message = "Please provide HSM protocol")
	private String hsmProtocol;

	@NotEmpty(message = "Please provide a HSM type")
	private String hsmType;

	@NotEmpty(message = "Please provide a HSM address")
	private String hsmAddress;

	@NotEmpty(message = "Please provide a HSM port")
	private String hsmPort;

	@NotEmpty(message = "Please provide header length")
	private String headerLen;

	@NotEmpty(message = "Please provide Header type")
	private String headerType;
	
	@NotEmpty(message = "Please provide Hsm header Length")
	private String hsmHeaderLen;

	@NotEmpty(message = "Please provide Hsm time out")
	private String hsmTImeOut;

	@NotEmpty(message = "Please provide Hsm Connection intervel")
	private String connectionIntervel;

	@NotEmpty(message = "Please provide Hsm status")
	private String hsmStatus;

	@NotEmpty(message = "Please provide  added by")
	private String addedBy;

	@CreatedDate
	private Date addedDate;

	private String remarks;
	
	@Column(name = "AUTH_CODE",insertable = false)
	private String authCode;
	
	@Column(name = "AUTH_DATE",insertable = false)
	private Date authDate;
	
	@Column(name = "AUTH_BY",insertable = false)
	private String authBy;

}
