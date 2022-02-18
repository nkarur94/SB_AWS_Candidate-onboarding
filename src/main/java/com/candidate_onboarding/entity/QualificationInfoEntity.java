package com.candidate_onboarding.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.candidate_onboarding.DTO.QualificationInfoDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="qualification_info")
public class QualificationInfoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qId;
	
	private boolean diploma;
	private String degree;
	private String field;
	private String yearOfPassing;
	private String finalPercentage;
	private String aggrPercentage;
	private String enggCertificate;
	private String finalCertificate;
	private String trainingInstitute;
	private String trainingDuration;
	private String course;
	
	
	public QualificationInfoEntity(QualificationInfoDTO qualificationEntity) {
		super();
		this.diploma = qualificationEntity.diploma;
		this.degree = qualificationEntity.degree;
		this.field = qualificationEntity.field;
		this.yearOfPassing = qualificationEntity.yearOfPassing;
		this.finalPercentage = qualificationEntity.finalPercentage;
		this.aggrPercentage = qualificationEntity.aggrPercentage;
		this.enggCertificate = qualificationEntity.enggCertificate;
		this.finalCertificate = qualificationEntity.finalCertificate;
		this.trainingInstitute = qualificationEntity.trainingInstitute;
		this.trainingDuration = qualificationEntity.trainingDuration;
		this.course = qualificationEntity.course;
	}
	
	

}
