package com.DreamGhar.util;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.DreamGhar.model.DbSequence;



@Component
public class UseridGenerationUtil {
	
	@Autowired
	private MongoOperations mongoOperations;
	
	public int getSequenceNumber(String sequenceName)
	{
		
		//getting sequence number
		Query query=new Query(Criteria.where("id").is(sequenceName));
		//updating sequence number
		Update update=new Update().inc("seq",1);
		//modify in document
		DbSequence counter=mongoOperations
				.findAndModify(query, update, options().returnNew(true).upsert(true),DbSequence.class);
		return !Objects.isNull(counter)?counter.getSeq():1;
		
	}
	
}
