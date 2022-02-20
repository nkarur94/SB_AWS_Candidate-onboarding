package com.candidate_onboarding.DTO;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.candidate_onboarding.entity.BankInfoEntity;
import com.candidate_onboarding.entity.QualificationInfoEntity;

public class CandidateOnboardingDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "candidate firstname is invalid")
	public String firstName;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{1,}$", message = "candidate middle is invalid")
	public String middleName;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "candidate firstname is invalid")
	public String lastName;

	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "invalid email address")
	public String email;

	@Pattern(regexp="^[7-9][0-9]{9}",message="mobile no is not valid ")
	public String mobileNo;
	public String hireCity;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Parent name is invalid")
	public String parentName;
	
	@Pattern(regexp="^[7-9][0-9]{9}",message="mobile no is not valid ")
	public String parentMobile;
	
	public String temporaryAddress;
	public String permanentAddress;
	public String parentOccupation;
	
	@Min(value=500,message = "minimum wage should be more then 500")
	public String parentAnnualSalary;
	public String profileImage;
	public String folderId;
	public String status;
	
	public Long bId;
	public Long qId;
	
	
	
	

}
