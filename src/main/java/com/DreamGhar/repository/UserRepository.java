package com.DreamGhar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.DreamGhar.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	

	

	public User findByUserid(String userid);

}
