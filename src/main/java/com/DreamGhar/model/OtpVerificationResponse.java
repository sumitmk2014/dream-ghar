package com.DreamGhar.model;

 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtpVerificationResponse {
	
	private String userid;
	private String token;
	private Integer status;

}
