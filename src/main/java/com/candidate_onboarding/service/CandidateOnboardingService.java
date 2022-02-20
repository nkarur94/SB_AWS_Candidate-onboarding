package com.candidate_onboarding.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

	@Autowired
	RestTemplate restTemplate;

	@Override
	public ResponseDTO addCandidateOnboardingDetails(String token, CandidateOnboardingDTO candidateDTO) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateOnboardingException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);

			if (verifiedOrNot != true) {
				throw new CandidateOnboardingException("admin not verified");

			} else {
				CandidateOnboardingEntity entity = new CandidateOnboardingEntity(candidateDTO);

				entity.setCreatorStamp(LocalDate.now());
				BankInfoEntity bankEntity = bankRepo.findById(candidateDTO.bId).
						orElseThrow(() -> new CandidateOnboardingException("Bank id not found"));
				entity.setBankEntity(bankEntity);

				QualificationInfoEntity qualificationEntity = qualificationRepo.findById(candidateDTO.qId)
						.orElseThrow(() -> new CandidateOnboardingException("Qualification id not found"));
				entity.setQualificationEntity(qualificationEntity);

				candidateRepo.save(entity);

				ResponseDTO response = new ResponseDTO("saved candidate onboarding details", entity);
				return response;
			}
		}

	}

	@Override
	public ResponseDTO addBankInfoDetails(String token, BankInfoDTO bankDTO) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateOnboardingException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);

			if (verifiedOrNot != true) {
				throw new CandidateOnboardingException("admin not verified");

			} else {
				BankInfoEntity entity = new BankInfoEntity(bankDTO);

				entity.setCreatorStamp(LocalDate.now());

				bankRepo.save(entity);

				ResponseDTO response = new ResponseDTO("saved Bank Details ", entity);
				return response;
			}
		}

	}

	@Override
	public ResponseDTO addQualificationInfoDetails(String token, QualificationInfoDTO qualificationDTO) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateOnboardingException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);

			if (verifiedOrNot != true) {
				throw new CandidateOnboardingException("admin not verified");

			} else {
				QualificationInfoEntity entity = new QualificationInfoEntity(qualificationDTO);

				qualificationRepo.save(entity);

				ResponseDTO response = new ResponseDTO("saved Qualification Details ", entity);
				return response;
			}
		}

	}

	@Override
	public ResponseDTO viewAllCandidateDetailsOnboarding(String token) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateOnboardingException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);

			if (verifiedOrNot != true) {
				throw new CandidateOnboardingException("admin not verified");

			} else {
				List<CandidateOnboardingEntity> entity = candidateRepo.findAll();

				ResponseDTO response = new ResponseDTO("details of all candidate that is onborded ", entity);
				return response;

			}
		}

	}

	@Override
	public ResponseDTO viewAllBankDetails(String token) {
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateOnboardingException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);

			if (verifiedOrNot != true) {
				throw new CandidateOnboardingException("admin not verified");

			} else {
				List<BankInfoEntity> entity = bankRepo.findAll();

				ResponseDTO response = new ResponseDTO("details of all bank  details on DB ", entity);
				return response;
			}
		}

	}

	@Override
	public ResponseDTO viewAllQualificationDetails(String token) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateOnboardingException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);

			if (verifiedOrNot != true) {
				throw new CandidateOnboardingException("admin not verified");

			} else {
				List<QualificationInfoEntity> entity = qualificationRepo.findAll();

				ResponseDTO response = new ResponseDTO("details of all Qualification details on DB ", entity);
				return response;
			}
		}

	}

	@Override
	public ResponseDTO deleteCandidateDetails(String token, Long id) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateOnboardingException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);

			if (verifiedOrNot != true) {
				throw new CandidateOnboardingException("admin not verified");

			} else {
				CandidateOnboardingEntity entity = candidateRepo.findById(id)
						.orElseThrow(() -> new CandidateOnboardingException("id not found"));
				candidateRepo.delete(entity);

				ResponseDTO response = new ResponseDTO("deleted successfully ");
				return response;
			}
		}

	}

	@Override
	public ResponseDTO deleteBankInfoDetails(String token, Long bId) {
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateOnboardingException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);

			if (verifiedOrNot != true) {
				throw new CandidateOnboardingException("admin not verified");

			} else {
				BankInfoEntity entity = bankRepo.findById(bId)
						.orElseThrow(() -> new CandidateOnboardingException("id not found"));
				bankRepo.delete(entity);

				ResponseDTO response = new ResponseDTO("deleted successfully ");
				return response;
			}
		}

	}

	@Override
	public ResponseDTO deleteQualificationDetails(String token, Long qId) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateOnboardingException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);

			if (verifiedOrNot != true) {
				throw new CandidateOnboardingException("admin not verified");

			} else {
				QualificationInfoEntity entity = qualificationRepo.findById(qId)
						.orElseThrow(() -> new CandidateOnboardingException("id not found"));
				qualificationRepo.delete(entity);

				ResponseDTO response = new ResponseDTO("deleted successfully ");
				return response;

			}
		}

	}

	@Override
	public ResponseDTO updateBankInfoById(String token, Long bId, BankInfoDTO bankDTO) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateOnboardingException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);

			if (verifiedOrNot != true) {
				throw new CandidateOnboardingException("admin not verified");

			} else {
				BankInfoEntity entity = new BankInfoEntity(bankDTO);
				bankRepo.findById(bId).orElseThrow(() -> new CandidateOnboardingException("candidate id not found"));

				entity.setBId(bId);
				bankRepo.save(entity);

				ResponseDTO response = new ResponseDTO("bank details updated", entity);

				return response;
			}
		}
	}

	@Override
	public ResponseDTO updateQualificationById(String token, Long qId, QualificationInfoDTO qualificationDTO) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateOnboardingException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);

			if (verifiedOrNot != true) {
				throw new CandidateOnboardingException("admin not verified");

			} else {
				QualificationInfoEntity entity = new QualificationInfoEntity(qualificationDTO);
				qualificationRepo.findById(qId)
						.orElseThrow(() -> new CandidateOnboardingException("candidate id not found"));

				entity.setQId(qId);
				qualificationRepo.save(entity);

				ResponseDTO response = new ResponseDTO("qualification details updated", entity);

				return response;
			}
		}

	}

	@Override
	public ResponseDTO updateCandidateOnboardingById(String token, Long id, CandidateOnboardingDTO candidateDTO) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateOnboardingException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);

			if (verifiedOrNot != true) {
				throw new CandidateOnboardingException("admin not verified");

			} else {
				CandidateOnboardingEntity entity = new CandidateOnboardingEntity(candidateDTO);
				candidateRepo.findById(id)
						.orElseThrow(() -> new CandidateOnboardingException("candidate id not found"));

				entity.setId(id);

				BankInfoEntity bankEntity = bankRepo.findById(candidateDTO.bId).
						orElseThrow(() -> new CandidateOnboardingException("Bank id not found"));;
				entity.setBankEntity(bankEntity);

				QualificationInfoEntity qualificationEntity = qualificationRepo.findById(candidateDTO.qId).
						orElseThrow(() -> new CandidateOnboardingException("Qualification id not found"));;
				entity.setQualificationEntity(qualificationEntity);

				candidateRepo.save(entity);

				ResponseDTO response = new ResponseDTO("candidate details updated", entity);

				return response;
			}
		}

	}

	@Override
	public ResponseDTO viewCandidateById(String token, Long id) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateOnboardingException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);

			if (verifiedOrNot != true) {
				throw new CandidateOnboardingException("admin not verified");

			} else {
				CandidateOnboardingEntity entity = candidateRepo.findById(id)
						.orElseThrow(() -> new CandidateOnboardingException("candidate id not found"));

				ResponseDTO response = new ResponseDTO("candidate details of id:" + id, entity);

				return response;
			}
		}

	}

	@Override
	public ResponseDTO viewBankInfoById(String token, Long bId) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateOnboardingException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);

			if (verifiedOrNot != true) {
				throw new CandidateOnboardingException("admin not verified");

			} else {
				BankInfoEntity entity = bankRepo.findById(bId)
						.orElseThrow(() -> new CandidateOnboardingException("candidate id not found"));

				ResponseDTO response = new ResponseDTO("Bank details of id:" + bId, entity);

				return response;
			}
		}

	}

	@Override
	public ResponseDTO viewQualificationInfoById(String token, Long qId) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateOnboardingException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);

			if (verifiedOrNot != true) {
				throw new CandidateOnboardingException("admin not verified");

			} else {
				QualificationInfoEntity entity = qualificationRepo.findById(qId)
						.orElseThrow(() -> new CandidateOnboardingException("candidate id not found"));

				ResponseDTO response = new ResponseDTO("Qualification details of id:" + qId, entity);

				return response;
			}
		}

	}

}
