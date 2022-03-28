package com.DreamGhar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
	
	
	private String name;
	private String token;

}
