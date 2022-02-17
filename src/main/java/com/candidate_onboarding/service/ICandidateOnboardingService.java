package com.candidate_onboarding.service;

import com.candidate_onboarding.DTO.BankInfoDTO;
import com.candidate_onboarding.DTO.CandidateOnboardingDTO;
import com.candidate_onboarding.DTO.QualificationInfoDTO;
import com.candidate_onboarding.DTO.ResponseDTO;

public interface ICandidateOnboardingService {
	
	public ResponseDTO addCandidateOnboardingDetails(CandidateOnboardingDTO candidateDTO);
	public ResponseDTO addBankInfoDetails(BankInfoDTO bankDTO);
	public ResponseDTO addQualificationInfoDetails(QualificationInfoDTO qualificationDTO);
	
	public ResponseDTO viewAllCandidateDetailsOnboarding();
	public ResponseDTO viewAllBankDetails();
	public ResponseDTO viewAllQualificationDetails();
	
	public ResponseDTO deleteCandidateDetails(Long id);
	public ResponseDTO deleteBankInfoDetails(Long bId);
	public ResponseDTO deleteQualificationDetails(Long qId);
	

}