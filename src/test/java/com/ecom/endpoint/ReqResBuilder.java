package com.ecom.endpoint;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqResBuilder {
	
	
	
	public static RequestSpecification getRequestSpec(String AuthTokan) {
		
		return  new RequestSpecBuilder()
                                         .addHeader("Authorization", AuthTokan)	
                                         .log(LogDetail.BODY)
			                             .build();
				

	}
	
	
	
	public static ResponseSpecification getResposeSpec() {
		
		
		return  new  ResponseSpecBuilder()
		                                   .log(LogDetail.BODY)
		         
		                                   .build();
		
	}
	
	

	  
	 
}
