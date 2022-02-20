package com.candidate_onboarding.DTO;

import javax.validation.constraints.Pattern;

public class QualificationInfoDTO {
	
	public boolean diploma;
	public String degree;
	public String field;
	
	@Pattern(regexp = "^[1-9]{1}[0-9]{3}$",message="not a proper year format")
	public String yearOfPassing;
	public String finalPercentage;
	public String aggrPercentage;
	public String enggCertificate;
	public String finalCertificate;
	public String trainingInstitute;
	public String trainingDuration;
	public String course;
	

}
