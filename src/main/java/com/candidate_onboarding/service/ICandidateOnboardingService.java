package com.candidate_onboarding.service;

import com.candidate_onboarding.DTO.BankInfoDTO;
import com.candidate_onboarding.DTO.CandidateOnboardingDTO;
import com.candidate_onboarding.DTO.QualificationInfoDTO;
import com.candidate_onboarding.DTO.ResponseDTO;

public interface ICandidateOnboardingService {
	
	public ResponseDTO addCandidateOnboardingDetails(String token, CandidateOnboardingDTO candidateDTO);
	public ResponseDTO addBankInfoDetails(String token, BankInfoDTO bankDTO);
	public ResponseDTO addQualificationInfoDetails(String token, QualificationInfoDTO qualificationDTO);
	
	public ResponseDTO viewAllCandidateDetailsOnboarding(String token);
	public ResponseDTO viewAllBankDetails(String token);
	public ResponseDTO viewAllQualificationDetails(String token);
	
	public ResponseDTO deleteCandidateDetails(String token,Long id);
	public ResponseDTO deleteBankInfoDetails(String token,Long bId);
	public ResponseDTO deleteQualificationDetails(String token,Long qId);
	
	public ResponseDTO updateBankInfoById(String token,Long bId, BankInfoDTO bankDTO);
	public ResponseDTO updateQualificationById(String token,Long qId, QualificationInfoDTO qualificationDTO);
	public ResponseDTO updateCandidateOnboardingById(String token,Long id, CandidateOnboardingDTO candidateDTO);
	
	
	public ResponseDTO viewCandidateById(String token,Long id);
	public ResponseDTO viewBankInfoById(String token,Long bId);
	public ResponseDTO viewQualificationInfoById(String token,Long qId);
	
	
	

}
