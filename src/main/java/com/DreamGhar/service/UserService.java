package com.DreamGhar.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DreamGhar.model.Otp;
import com.DreamGhar.model.OtpVerificationRequest;
import com.DreamGhar.model.OtpVerificationResponse;
import com.DreamGhar.model.SendOtpRequest;
import com.DreamGhar.model.SendOtpResponse;
import com.DreamGhar.model.Token;
import com.DreamGhar.model.UpdateUserRequest;
import com.DreamGhar.model.UpdateUserResponse;
import com.DreamGhar.model.User;
import com.DreamGhar.repository.OtpRepository;
import com.DreamGhar.repository.TokenRepository;
import com.DreamGhar.repository.UserRepository;
import com.DreamGhar.util.GenerateTokenUtil;
import com.DreamGhar.util.SendOtpUtil;
import com.DreamGhar.util.UseridGenerationUtil;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OtpRepository otpRepository;

	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private UseridGenerationUtil useridGenerationUtil;

	@Autowired
	private SendOtpUtil sendOtpUtil;

	@Autowired
	private GenerateTokenUtil generateTokenutil;

	// **************Send otp
	public SendOtpResponse sendOtp(SendOtpRequest request) {

		String otp = sendOtpUtil.sendOtp(request.getMobileno());
		Otp o = new Otp();
		o.setOtp(otp);
		o.setMobile(request.getMobileno());	
		
		otpRepository.save(o);
		SendOtpResponse response=new SendOtpResponse();
		response.setMobileno(request.getMobileno());
		return response;
	}
	
	
	

    ////***otp verification  ******
	public OtpVerificationResponse verifyOtp(OtpVerificationRequest request) {
		
		Otp otp=otpRepository.findByMobileAndOtp(request.getMobile(), request.getOtp());
		OtpVerificationResponse response=new OtpVerificationResponse();
		if(otp!=null)
		{
			//generating userid
			Long id=Long.valueOf("22000000000");
			Integer sequenceNumber = useridGenerationUtil.getSequenceNumber(User.SEQUENCE_NAME);
			Long longSequenceNumber = Long.valueOf(sequenceNumber);
			 id= id + longSequenceNumber;
			 String userId=Long.toString(id);
			 
			 //generating token
			 Token token =new Token();
			 String tokenString = generateTokenutil.generateToken();
			 token.setToken(tokenString);
			 token.setUserid(userId);
			 token.setTokenGenarationTime(new Date());
			 tokenRepository.save(token);
			 
			 //Creating user
			 User user=new User();
			 user.setUserid(userId);
			 user.setMob_no(request.getMobile());
			 userRepository.save(user);
			 
			 //generating response
			 response.setUserid(userId);
			 response.setToken(tokenString);
			 response.setStatus(1);
			 
			
			return response;
		}
		else
		{
			response.setStatus(-1);
			return response;
		}
		
	}

	
	
	
	
	// update user****
	public UpdateUserResponse updateUserDetails(UpdateUserRequest request) {
		Token token = tokenRepository.findByToken(request.getToken());
		UpdateUserResponse response = new UpdateUserResponse();
		if (!(token == null)) {
			// updating user
			User user = userRepository.findByUserid(token.getUserid());
			user.setName(request.getName());
			userRepository.save(user);

			// generating response
			response.setName(request.getName());
			return response;
		}

		return response;
	}

}
