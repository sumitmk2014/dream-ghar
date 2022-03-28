package com.DreamGhar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.DreamGhar.model.Otp;


@Repository
public interface OtpRepository extends MongoRepository<Otp, String> {

	Otp findByMobileAndOtp(String mobileno, String otp);

	
}
