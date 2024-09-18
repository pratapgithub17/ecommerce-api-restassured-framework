package com.ecom.testcase;

import com.ecom.endpoint.ApiRequest;
import com.ecom.payload.AddProductResponse;

import com.ecom.payload.LoginRespose;
import com.ecom.payload.NewOrderResponse;
import com.ecom.payload.PayloadClass;
import com.ecom.payload.ViewProductResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class EcomTestCase {
	
	
	static String ProductId;
	static String UserId;
	  
	@Test (priority=1)
    public static void NotAbleToLogin() {
		
       Response Res =ApiRequest.LoginRequest(PayloadClass.InValidCredential());
       
		                     Assert.assertEquals(Res.statusCode(), 400);		                     
		                     LoginRespose   LoginResponse = Res.as(LoginRespose.class); 
		                     Assert.assertEquals(LoginResponse.getMessage(), "Incorrect email or password.");
		                     	                          
	}
	
	@Test (priority=2)
	public static void ShouldAbleTologin() {
		
	   Response Res =ApiRequest.LoginRequest(PayloadClass.ValidCredential());
	   
                           Assert.assertEquals(Res.statusCode(), 200);       
                           LoginRespose   LoginResponse = Res.as(LoginRespose.class);  
	                       UserId=  LoginResponse.getUserId();
                           Assert.assertEquals(LoginResponse.getMessage(), "Login Successfully");
        		
	}
	
	@Test (priority=3)

	public static void ShouldAbleToAddProduct() throws JsonProcessingException {
		
	   Response Res=ApiRequest.AddProductRequest();
	   
                          Assert.assertEquals(Res.statusCode(), 201);                                                      
                          AddProductResponse   addproductResponse = Res.as(AddProductResponse.class);    
                          ProductId=  addproductResponse.getProductId();                                  
                          Assert.assertEquals(addproductResponse.getMessage(), "Product Added Successfully");
                                                        	           		
	}
	
	@Test (priority=4)

	public static void CreateNewOrder() {
		
	   Response Res= ApiRequest.CreateOrderRequest();
	   
		                  Assert.assertEquals(Res.statusCode(), 201);		                                                    		                                                    
		                  NewOrderResponse OrderResponse =  Res.as(NewOrderResponse.class);   		                             
		                  Assert.assertEquals(OrderResponse.getProductOrderId().get(0), ProductId);                  
		
	}
		
	@Test (priority=5)
	public static void ViewOrderById() {
				
	  Response Res =ApiRequest.ViewOrderRequest();
	  
				          Assert.assertEquals(Res.statusCode(), 200);
				          ViewProductResponse   ViewOrderResponse = Res.as(ViewProductResponse.class);	          
				          Assert.assertEquals(ViewOrderResponse.getData().getProductOrderedId(), ProductId);
				          Assert.assertEquals(ViewOrderResponse.getData().getOrderBy(), PayloadClass.ValidCredential().getUserEmail());
				          Assert.assertEquals(ViewOrderResponse.getData().getOrderById(), UserId);
				          Assert.assertEquals(ViewOrderResponse.getMessage(), "Orders fetched for customer Successfully");
	          		
	}
	
	
	@Test (priority=6)
	public static void DeleteProduct() {
		
	Response Res = ApiRequest.DeleteProductRequest();
		
		                 Assert.assertEquals(Res.statusCode(), 200);
		                 Assert.assertEquals(Res.jsonPath().getString("message"), "Product Deleted Successfully");  
		
	}

}
