package com.candidate_onboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<ResponseDTO> addCandidate(@RequestBody CandidateOnboardingDTO candidateDTO) {
		ResponseDTO response = iCandidateOnboradingService.addCandidateOnboardingDetails(candidateDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PostMapping("/addbank")
	public ResponseEntity<ResponseDTO> addBank(@RequestBody BankInfoDTO bankDTO) {
		ResponseDTO response = iCandidateOnboradingService.addBankInfoDetails(bankDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PostMapping("/addqualification")
	public ResponseEntity<ResponseDTO> addQualification(@RequestBody QualificationInfoDTO qualificationDTO) {
		ResponseDTO response = iCandidateOnboradingService.addQualificationInfoDetails(qualificationDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping("/getcandidate")
	public ResponseEntity<ResponseDTO> viewCandidate() {
		ResponseDTO response = iCandidateOnboradingService.viewAllCandidateDetailsOnboarding();
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping("/getbank")
	public ResponseEntity<ResponseDTO> viewbank() {
		ResponseDTO response = iCandidateOnboradingService.viewAllBankDetails();
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping("/getqualification")
	public ResponseEntity<ResponseDTO> viewQualification() {
		ResponseDTO response = iCandidateOnboradingService.viewAllQualificationDetails();
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCandidate/{id}")
	public ResponseEntity<ResponseDTO> deleteCandidate(@PathVariable Long id) {
		ResponseDTO response = iCandidateOnboradingService.deleteCandidateDetails(id);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deletebank/{bId}")
	public ResponseEntity<ResponseDTO> deleteBank(@PathVariable Long bId) {
		ResponseDTO response = iCandidateOnboradingService.deleteBankInfoDetails(bId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCandidate/{qId}")
	public ResponseEntity<ResponseDTO> deleteQualification(@PathVariable Long qId) {
		ResponseDTO response = iCandidateOnboradingService.deleteQualificationDetails(qId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PutMapping("/updatebank/{bId}")
	public ResponseEntity<ResponseDTO> updateBankInfo(@PathVariable Long bId, @RequestBody BankInfoDTO bankDTO) {
		ResponseDTO response = iCandidateOnboradingService.updateBankInfoById(bId, bankDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PutMapping("/updatequalification/{qId}")
	public ResponseEntity<ResponseDTO> updateQualificationInfo(@PathVariable Long qId,
			@RequestBody QualificationInfoDTO qualificationDTO) {
		ResponseDTO response = iCandidateOnboradingService.updateQualificationById(qId, qualificationDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PutMapping("/updatecandidate/{id}")
	public ResponseEntity<ResponseDTO> updateCandidateInfo(@PathVariable Long id,
			@RequestBody CandidateOnboardingDTO candidtaeDTO) {
		ResponseDTO response = iCandidateOnboradingService.updateCandidateOnboardingById(id, candidtaeDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getbyCandidateid/{id}")
	public ResponseEntity<ResponseDTO> getByCId(@PathVariable Long id){
		ResponseDTO response = iCandidateOnboradingService.viewCandidateById(id);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	}
	
	@GetMapping("/getbybankid/{bId}")
	public ResponseEntity<ResponseDTO> getByBId(@PathVariable Long bId){
		ResponseDTO response = iCandidateOnboradingService.viewBankInfoById(bId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	}
	@GetMapping("/getbyqualificationid/{qId}")
	public ResponseEntity<ResponseDTO> getByQId(@PathVariable Long qId){
		ResponseDTO response = iCandidateOnboradingService.viewQualificationInfoById(qId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	}

}
