package com.candidate_onboarding.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidate_onboarding.DTO.BankInfoDTO;
import com.candidate_onboarding.DTO.CandidateOnboardingDTO;
import com.candidate_onboarding.DTO.QualificationInfoDTO;
import com.candidate_onboarding.DTO.ResponseDTO;
import com.candidate_onboarding.entity.BankInfoEntity;
import com.candidate_onboarding.entity.CandidateOnboardingEntity;
import com.candidate_onboarding.entity.QualificationInfoEntity;
import com.candidate_onboarding.exception.CandidateOnboardingException;
import com.candidate_onboarding.repository.BankInfoRepo;
import com.candidate_onboarding.repository.CandidateOnboardingRepo;
import com.candidate_onboarding.repository.QualificationInfoRepo;

@Service
public class CandidateOnboardingService implements ICandidateOnboardingService {

	@Autowired
	CandidateOnboardingRepo candidateRepo;

	@Autowired
	BankInfoRepo bankRepo;

	@Autowired
	QualificationInfoRepo qualificationRepo;

	@Override
	public ResponseDTO addCandidateOnboardingDetails(CandidateOnboardingDTO candidateDTO) {
		// TODO Auto-generated method stub
		CandidateOnboardingEntity entity = new CandidateOnboardingEntity(candidateDTO);

		entity.setCreatorStamp(LocalDate.now());

		candidateRepo.save(entity);

		ResponseDTO response = new ResponseDTO("saved candidate onboarding details", entity);
		return response;
	}

	@Override
	public ResponseDTO addBankInfoDetails(BankInfoDTO bankDTO) {
		// TODO Auto-generated method stub
		BankInfoEntity entity = new BankInfoEntity(bankDTO);

		entity.setCreatorStamp(LocalDate.now());

		bankRepo.save(entity);

		ResponseDTO response = new ResponseDTO("saved Bank Details ", entity);
		return response;

	}

	@Override
	public ResponseDTO addQualificationInfoDetails(QualificationInfoDTO qualificationDTO) {
		// TODO Auto-generated method stub
		QualificationInfoEntity entity = new QualificationInfoEntity(qualificationDTO);

		qualificationRepo.save(entity);

		ResponseDTO response = new ResponseDTO("saved Qualification Details ", entity);
		return response;

	}

	@Override
	public ResponseDTO viewAllCandidateDetailsOnboarding() {
		// TODO Auto-generated method stub
		List<CandidateOnboardingEntity> entity = candidateRepo.findAll();

		ResponseDTO response = new ResponseDTO("details of all candidate that is onborded ", entity);
		return response;

	}

	@Override
	public ResponseDTO viewAllBankDetails() {
		// TODO Auto-generated method stub
		List<BankInfoEntity> entity = bankRepo.findAll();

		ResponseDTO response = new ResponseDTO("details of all bank  details on DB ", entity);
		return response;

	}

	@Override
	public ResponseDTO viewAllQualificationDetails() {
		// TODO Auto-generated method stub
		List<QualificationInfoEntity> entity = qualificationRepo.findAll();

		ResponseDTO response = new ResponseDTO("details of all Qualification details on DB ", entity);
		return response;

	}

	@Override
	public ResponseDTO deleteCandidateDetails(Long id) {
		// TODO Auto-generated method stub
		CandidateOnboardingEntity entity = candidateRepo.findById(id)
				.orElseThrow(() -> new CandidateOnboardingException("id not found"));
		candidateRepo.delete(entity);

		ResponseDTO response = new ResponseDTO("deleted successfully ");
		return response;
	}

	@Override
	public ResponseDTO deleteBankInfoDetails(Long bId) {

		BankInfoEntity entity = bankRepo.findById(bId)
				.orElseThrow(() -> new CandidateOnboardingException("id not found"));
		bankRepo.delete(entity);

		ResponseDTO response = new ResponseDTO("deleted successfully ");
		return response;
		
	}

	@Override
	public ResponseDTO deleteQualificationDetails(Long qId) {
		// TODO Auto-generated method stub
		QualificationInfoEntity entity = qualificationRepo.findById(qId).
				orElseThrow(() -> new CandidateOnboardingException("id not found"));
		qualificationRepo.delete(entity);
		
		ResponseDTO response = new ResponseDTO("deleted successfully ");
		return response;
	}

}
