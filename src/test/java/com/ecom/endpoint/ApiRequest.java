package com.ecom.endpoint;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import java.io.File;
import java.io.IOException;

import com.ecom.payload.LoginDetails;
import com.ecom.utilities.Utiles;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ApiRequest extends Utiles {
	
	                static  String UserId;
	                static String AuthToken;
	                static String ProductId;
	                static String OrderId;
	
	public static Response LoginRequest(LoginDetails Payload) {
		
		Response response= given()
		                         .body(Payload)
		                         .contentType(ContentType.JSON)
      		  
		               .when()
		                         .post(Endpoint.LoginUrl)
		 		  
		               .then()  		                        
		                         .extract().response();
	                              UserId= response.jsonPath().getString("userId");
	                              AuthToken= response.jsonPath().getString("token");
	  return response;
				
	}
	
	public static Response AddProductRequest() throws IOException {
		
	Response response=  given(ReqResBuilder.getRequestSpec(AuthToken))
			                         .formParams(ProductPayload(UserId))
			                         .contentType(ContentType.MULTIPART)
			                         .multiPart("productImage",new File("shopping.jpg"))			                              		  
			           .when()
			                         .post(Endpoint.CreateProductUrl)
			 		  
			           .then().spec(ReqResBuilder.getResposeSpec())
			                         .extract().response();
	                                  ProductId= response.jsonPath().getString("productId");
		 return response;
					
		}
	
	public static Response CreateOrderRequest() {
		
    Response response = given(ReqResBuilder.getRequestSpec(AuthToken))
					                .contentType(ContentType.JSON)
					                .log().body()
					                .body(Orderpayload(ProductId))
		         
		         
		             .when()
		             				.post(Endpoint.CreateOrderUrl)
		         
		             .then().spec(ReqResBuilder.getResposeSpec())
		                             .extract().response();
    								  OrderId = response.jsonPath().getString("orders[0]");

		return response;
		
		
	}
	
	
	public static Response ViewOrderRequest() {
				            
	 Response response = given(ReqResBuilder.getRequestSpec(AuthToken))
		                              .queryParams("id", OrderId)
		      
		                .when()
		                             .get(Endpoint.ViewOrderUrl)
		                .then().spec(ReqResBuilder.getResposeSpec())
		                             .extract().response();
		
		
		 return response;
	}
	
	
	public static Response DeleteProductRequest() {
		
		 Response response =given(ReqResBuilder.getRequestSpec(AuthToken))
		                                 .pathParam("productOrderedId", ProductId)		
		                   .when()
		                                 .delete(Endpoint.DeleteOrderUrl)                   				
		                   .then()
		                                 .extract().response();
		
		return response;
		
	}

}
