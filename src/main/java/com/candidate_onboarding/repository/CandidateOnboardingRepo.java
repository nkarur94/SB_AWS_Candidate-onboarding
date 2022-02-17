package com.candidate_onboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.candidate_onboarding.entity.CandidateOnboardingEntity;

public interface CandidateOnboardingRepo extends JpaRepository<CandidateOnboardingEntity, Long> {

}
