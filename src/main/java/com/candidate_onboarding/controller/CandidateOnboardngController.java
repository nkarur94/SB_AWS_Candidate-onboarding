package com.candidate_onboarding.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	public ResponseEntity<ResponseDTO> addCandidate(
		@RequestHeader String token,@Valid	@RequestBody CandidateOnboardingDTO candidateDTO) {
		ResponseDTO response = iCandidateOnboradingService.addCandidateOnboardingDetails(token, candidateDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PostMapping("/addbank")
	public ResponseEntity<ResponseDTO> addBank(@RequestHeader String token,@Valid @RequestBody BankInfoDTO bankDTO) {
		ResponseDTO response = iCandidateOnboradingService.addBankInfoDetails(token,bankDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PostMapping("/addqualification")
	public ResponseEntity<ResponseDTO> addQualification(@RequestHeader String token,@Valid @RequestBody QualificationInfoDTO qualificationDTO) {
		ResponseDTO response = iCandidateOnboradingService.addQualificationInfoDetails(token,qualificationDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping("/getcandidate")
	public ResponseEntity<ResponseDTO> viewCandidate(@RequestHeader String token) {
		ResponseDTO response = iCandidateOnboradingService.viewAllCandidateDetailsOnboarding(token);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping("/getbank")
	public ResponseEntity<ResponseDTO> viewbank(@RequestHeader String token) {
		ResponseDTO response = iCandidateOnboradingService.viewAllBankDetails(token);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping("/getqualification")
	public ResponseEntity<ResponseDTO> viewQualification(@RequestHeader String token) {
		ResponseDTO response = iCandidateOnboradingService.viewAllQualificationDetails(token);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCandidate/{id}")
	public ResponseEntity<ResponseDTO> deleteCandidate(@RequestHeader String token, @PathVariable Long id) {
		ResponseDTO response = iCandidateOnboradingService.deleteCandidateDetails(token,id);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deletebank/{bId}")
	public ResponseEntity<ResponseDTO> deleteBank(@RequestHeader String token, @PathVariable Long bId) {
		ResponseDTO response = iCandidateOnboradingService.deleteBankInfoDetails(token,bId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCandidate/{qId}")
	public ResponseEntity<ResponseDTO> deleteQualification(@RequestHeader String token, @PathVariable Long qId) {
		ResponseDTO response = iCandidateOnboradingService.deleteQualificationDetails(token,qId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PutMapping("/updatebank/{bId}")
	public ResponseEntity<ResponseDTO> updateBankInfo(@RequestHeader String token, @PathVariable Long bId,@Valid @RequestBody BankInfoDTO bankDTO) {
		ResponseDTO response = iCandidateOnboradingService.updateBankInfoById(token, bId, bankDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PutMapping("/updatequalification/{qId}")
	public ResponseEntity<ResponseDTO> updateQualificationInfo(@RequestHeader String token, @PathVariable Long qId,
			@Valid @RequestBody QualificationInfoDTO qualificationDTO) {
		ResponseDTO response = iCandidateOnboradingService.updateQualificationById(token, qId, qualificationDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@PutMapping("/updatecandidate/{id}")
	public ResponseEntity<ResponseDTO> updateCandidateInfo(@RequestHeader String token, @PathVariable Long id,
			@Valid @RequestBody CandidateOnboardingDTO candidtaeDTO) {
		ResponseDTO response = iCandidateOnboradingService.updateCandidateOnboardingById(token, id, candidtaeDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getbyCandidateid/{id}")
	public ResponseEntity<ResponseDTO> getByCId(@RequestHeader String token, @PathVariable Long id){
		ResponseDTO response = iCandidateOnboradingService.viewCandidateById(token, id);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	}
	
	@GetMapping("/getbybankid/{bId}")
	public ResponseEntity<ResponseDTO> getByBId(@RequestHeader String token, @PathVariable Long bId){
		ResponseDTO response = iCandidateOnboradingService.viewBankInfoById(token,bId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	}
	@GetMapping("/getbyqualificationid/{qId}")
	public ResponseEntity<ResponseDTO> getByQId(@RequestHeader String token, @PathVariable Long qId){
		ResponseDTO response = iCandidateOnboradingService.viewQualificationInfoById(token, qId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	}

}
