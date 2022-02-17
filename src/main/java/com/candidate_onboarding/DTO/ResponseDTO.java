package com.candidate_onboarding.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseDTO {

	
	public String message;
	public Object data;
	
	public ResponseDTO(String message) {
		super();
		this.message = message;
	}
	
}
