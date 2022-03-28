package com.DreamGhar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DreamGhar.model.OtpVerificationRequest;
import com.DreamGhar.model.OtpVerificationResponse;
import com.DreamGhar.model.SendOtpRequest;
import com.DreamGhar.model.SendOtpResponse;
import com.DreamGhar.model.UpdateUserRequest;
import com.DreamGhar.model.UpdateUserResponse;
import com.DreamGhar.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/sendOtp")
	public ResponseEntity<SendOtpResponse> sendOtp(@RequestBody SendOtpRequest request)
	{
		SendOtpResponse response = userservice.sendOtp(request);
		
		return ResponseEntity.ok(response);
	}
	
	
	@PostMapping("/verify")
	public ResponseEntity<OtpVerificationResponse> verifyOtp(@RequestBody OtpVerificationRequest request)
	{
		OtpVerificationResponse response =userservice.verifyOtp(request);
		return ResponseEntity.ok(response);	
	}
	
	@PostMapping("/update")
	public ResponseEntity<UpdateUserResponse> updateUserDetails(@RequestBody UpdateUserRequest request)
	{
		UpdateUserResponse response=userservice.updateUserDetails(request);
		return ResponseEntity.ok(response);	
	}
	
	

}
