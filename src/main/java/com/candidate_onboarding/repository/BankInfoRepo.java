package com.candidate_onboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.candidate_onboarding.entity.BankInfoEntity;

public interface BankInfoRepo extends JpaRepository<BankInfoEntity, Long> {

}
