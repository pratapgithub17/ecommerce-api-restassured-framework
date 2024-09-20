package com.ecom.testcase;

import com.ecom.endpoint.ApiRequest;
import com.ecom.payload.AddProductResponse;

import com.ecom.payload.LoginRespose;
import com.ecom.payload.NewOrderResponse;
import com.ecom.payload.ViewProductResponse;
import com.ecom.utilities.Utiles;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class EcomTestCase extends Utiles {
	
	
	static String ProductId;
	static String UserId;
	  
	@Test (priority=1)
    public static void NotAbleToLogin() throws IOException {
		
       Response Res =ApiRequest.LoginRequest(InValidCredential());
       
		                     Assert.assertEquals(Res.statusCode(), 400);		                     
		                     LoginRespose   LoginResponse = Res.as(LoginRespose.class); 
		                     Assert.assertEquals(LoginResponse.getMessage(), "Incorrect email or password.");
		                     	                          
	}
	
	@Test (priority=2)
	public static void ShouldAbleTologin() throws IOException {
		
	   Response Res =ApiRequest.LoginRequest(ValidCredential());
	   
                           Assert.assertEquals(Res.statusCode(), 200);       
                           LoginRespose   LoginResponse = Res.as(LoginRespose.class);  
	                       UserId=  LoginResponse.getUserId();
                           Assert.assertEquals(LoginResponse.getMessage(), "Login Successfully");
        		           
	}
	
	@Test (priority=3)

	public static void ShouldAbleToAddProduct() throws IOException {
		
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
	public static void ViewOrderById() throws IOException {
				
	  Response Res =ApiRequest.ViewOrderRequest();
	  
				          Assert.assertEquals(Res.statusCode(), 200);
				          ViewProductResponse   ViewOrderResponse = Res.as(ViewProductResponse.class);	          
				          Assert.assertEquals(ViewOrderResponse.getData().getProductOrderedId(), ProductId);
				          Assert.assertEquals(ViewOrderResponse.getData().getOrderBy(), ValidCredential().getUserEmail());
				          Assert.assertEquals(ViewOrderResponse.getData().getOrderById(), UserId);
				          Assert.assertEquals(ViewOrderResponse.getMessage(), "Orders fetched for customer Successfully");
	          		
	}
	
	
//	@Test (priority=6)
	public static void DeleteProduct() {
		
	Response Res = ApiRequest.DeleteProductRequest();
		
		                 Assert.assertEquals(Res.statusCode(), 200);
		                 Assert.assertEquals(Res.jsonPath().getString("message"), "Product Deleted Successfully");  
		
	}

}
