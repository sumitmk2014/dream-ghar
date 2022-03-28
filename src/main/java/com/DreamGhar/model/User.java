package com.DreamGhar.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
	
	@Transient   //so that it will not persist in db
	public static final String SEQUENCE_NAME="User_sequence";
	
	@Id
	private String userid;
	private String name;
	private Date dob;
	private String profession;
	private String mob_no;
	private String alternate_mob_no;
	private String email;
	private String gender;
	private String password;
	

}
