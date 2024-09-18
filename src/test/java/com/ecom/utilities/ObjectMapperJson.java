package com.ecom.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperJson {
	
	
	public static ObjectMapper PrintJson(Object object) throws JsonProcessingException {
		
		
          ObjectMapper mapper=new ObjectMapper();
		
		String JSON= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		
	        	System.out.println(JSON);
		return mapper;
	}

}
