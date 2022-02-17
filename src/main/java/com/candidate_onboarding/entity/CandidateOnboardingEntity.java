package com.candidate_onboarding.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.candidate_onboarding.DTO.CandidateOnboardingDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="candidate_onboarding")
public class CandidateOnboardingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String mobileNo;
	private String hireCity;
	private String parentName;
	private String parentMobile;
	private String temporaryAddress;
	private String permanentAddress;
	private String parentOccupation;
	private String parentAnnualSalary;
	private String profileImage;
	private String folderId;
	private String status;
	private LocalDate creatorStamp;
	private LocalDate updateStamp;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "bId")
	private BankInfoEntity bankEntity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "qId")
	private QualificationInfoEntity qualificationEntity;
	
	
	public CandidateOnboardingEntity(CandidateOnboardingDTO candidateDTO) {
		super();
		this.firstName = candidateDTO.firstName;
		this.middleName = candidateDTO.middleName;
		this.lastName = candidateDTO.lastName;
		this.email = candidateDTO.email;
		this.mobileNo = candidateDTO.mobileNo;
		this.hireCity = candidateDTO.hireCity;
		this.parentName = candidateDTO.parentName;
		this.parentMobile = candidateDTO.parentMobile;
		this.temporaryAddress = candidateDTO.temporaryAddress;
		this.permanentAddress = candidateDTO.permanentAddress;
		this.parentOccupation = candidateDTO.parentOccupation;
		this.parentAnnualSalary = candidateDTO.parentAnnualSalary;
		this.profileImage = candidateDTO.profileImage;
		this.folderId = candidateDTO.folderId;
		this.status = candidateDTO.status;
		
	}
	
	
}
