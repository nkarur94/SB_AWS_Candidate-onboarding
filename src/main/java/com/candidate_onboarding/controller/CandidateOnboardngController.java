package com.candidate_onboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidate_onboarding.DTO.BankInfoDTO;
import com.candidate_onboarding.DTO.CandidateOnboardingDTO;
import com.candidate_onboarding.DTO.QualificationInfoDTO;
import com.candidate_onboarding.DTO.ResponseDTO;
import com.candidate_onboarding.service.ICandidateOnboardingService;

@RestController
@RequestMapping("/candidateonboarding")
public class CandidateOnboardngController {
	
	@Autowired
	ICandidateOnboardingService iCandidateOnboradingService;
	
	@PostMapping("/addcandidate")
	public ResponseEntity<ResponseDTO> addCandidate(@RequestBody CandidateOnboardingDTO candidateDTO){
		ResponseDTO response = iCandidateOnboradingService.addCandidateOnboardingDetails(candidateDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	@PostMapping("/addbank")
	public ResponseEntity<ResponseDTO> addBank(@RequestBody BankInfoDTO bankDTO){
		ResponseDTO response = iCandidateOnboradingService.addBankInfoDetails(bankDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	} 
	
	@PostMapping("/addqualification")
	public ResponseEntity<ResponseDTO> addQualification(@RequestBody QualificationInfoDTO qualificationDTO){
		ResponseDTO response = iCandidateOnboradingService.addQualificationInfoDetails(qualificationDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	} 
	
	
	@GetMapping("/getcandidate")
	public ResponseEntity<ResponseDTO> viewCandidate(){
		ResponseDTO response = iCandidateOnboradingService.viewAllCandidateDetailsOnboarding();
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	} 
	
	@GetMapping("/getbank")
	public ResponseEntity<ResponseDTO> viewbank(){
		ResponseDTO response = iCandidateOnboradingService.viewAllBankDetails();
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	} 
	
	@GetMapping("/getqualification")
	public ResponseEntity<ResponseDTO> viewQualification(){
		ResponseDTO response = iCandidateOnboradingService.viewAllQualificationDetails();
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	} 
	
	
	@DeleteMapping("/deleteCandidate/{id}")
	public ResponseEntity<ResponseDTO> deleteCandidate(@PathVariable Long id){
		ResponseDTO response = iCandidateOnboradingService.deleteCandidateDetails(id);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deletebank/{bId}")
	public ResponseEntity<ResponseDTO> deleteBank(@PathVariable Long bId){
		ResponseDTO response = iCandidateOnboradingService.deleteBankInfoDetails(bId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	@DeleteMapping("/deleteCandidate/{qId}")
	public ResponseEntity<ResponseDTO> deleteQualification(@PathVariable Long qId){
		ResponseDTO response = iCandidateOnboradingService.deleteQualificationDetails(qId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
}
