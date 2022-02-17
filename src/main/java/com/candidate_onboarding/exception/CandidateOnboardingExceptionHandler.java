package com.candidate_onboarding.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.candidate_onboarding.DTO.ResponseDTO;

@ControllerAdvice
public class CandidateOnboardingExceptionHandler {

	@ExceptionHandler(CandidateOnboardingException.class)
	public ResponseEntity<ResponseDTO> handleCandidateOnboardingException(CandidateOnboardingException exception) {
		ResponseDTO response = new ResponseDTO("ERROR while running API",exception.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}
}
