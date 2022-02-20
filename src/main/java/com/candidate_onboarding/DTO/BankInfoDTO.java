package com.candidate_onboarding.DTO;

import java.time.LocalDate;

import javax.validation.constraints.Pattern;

public class BankInfoDTO {

	@Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$",message="enter the correct pan card no")
	public String panNumber;
	
	@Pattern(regexp = "^[2-9]{1}[0-9]{11}$",message="incorrect aadhar number")
	public String aadharNo;
	public String bankName;
	public String bankAccountNumber;
	
	@Pattern(regexp = "^[A-Z]{4}0[0-9]{6}$",message="invalid IFSC code")
	public String ifscCode;
	public String passbookPath;
	public String panPath;
	public String aadharPath;
	
	
}
