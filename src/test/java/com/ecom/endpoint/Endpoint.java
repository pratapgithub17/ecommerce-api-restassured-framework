package com.ecom.endpoint;

public class Endpoint {
	
	

	public static String BaseUrl= "https://rahulshettyacademy.com";
	
	public static String LoginUrl=BaseUrl+ "/api/ecom/auth/login";
	
	public static String CreateProductUrl=BaseUrl+ "/api/ecom/product/add-product";
	
	public static String CreateOrderUrl=BaseUrl+ "/api/ecom/order/create-order";
	
	public static String ViewOrderUrl=BaseUrl+ "/api/ecom/order/get-orders-details";
	
	public static String DeleteOrderUrl= BaseUrl+"/api/ecom/product/delete-product/{productOrderedId}";
	

}   

