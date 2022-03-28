package com.DreamGhar.model;

 
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "otp")
public class Otp {
	
	@Id
	private String mobile;
	private String otp;
	
	

}
