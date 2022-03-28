package com.DreamGhar.model;

import java.util.HashMap;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Segment")
public class Segment {
	
	HashMap<String, String> values;

}
