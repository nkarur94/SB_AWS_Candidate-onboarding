package com.candidate_onboarding.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.candidate_onboarding.DTO.BankInfoDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="bank_info")
public class BankInfoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bId;
	private String panNumber;
	private String aadharNo;
	private String bankName;
	private String bankAccountNumber;
	private String ifscCode;
	private String passbookPath;
	private String panPath;
	private String aadharPath;
	private LocalDate creatorStamp;
	private LocalDate updateStamp;
	
	
	public BankInfoEntity(BankInfoDTO bankDTO) {
		super();
		this.panNumber = bankDTO.panNumber;
		this.aadharNo = bankDTO.aadharNo;
		this.bankName = bankDTO.bankName;
		this.bankAccountNumber = bankDTO.bankAccountNumber;
		this.ifscCode = bankDTO.ifscCode;
		this.passbookPath = bankDTO.passbookPath;
		this.panPath = bankDTO.panPath;
		this.aadharPath = bankDTO.aadharPath;
		
	}
	
	
}
