package com.DreamGhar.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class GenerateTokenUtil {
	
	public String generateToken() {
		
		UUID uuid = UUID.randomUUID();
		
		return uuid.toString();
	}

}
