package com.DreamGhar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.DreamGhar.model.Token;

@Repository
public interface TokenRepository extends MongoRepository<Token, String> {

	Token findByToken(String token);

}
