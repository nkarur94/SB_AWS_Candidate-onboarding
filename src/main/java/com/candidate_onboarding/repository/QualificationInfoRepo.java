package com.candidate_onboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.candidate_onboarding.entity.QualificationInfoEntity;

public interface QualificationInfoRepo extends JpaRepository<QualificationInfoEntity, Long> {

}
