package com.ecom.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ecom.payload.LoginDetails;
import com.ecom.payload.OrderDetails;
import com.ecom.payload.OrderList;
import com.fasterxml.jackson.core.JsonProcessingException;




	public class Utiles extends ReadExcel{
		
		
		  public static LoginDetails ValidCredential () throws IOException {
		    	
			  LoginDetails lg =new LoginDetails();
		    	
			    lg.setUserEmail(getData("userEmail","UserData"));
		    	lg.setUserPassword(getData("userPassword","UserData"));
		    	
		    	return lg;
		    	
		    	
		    }
		  
		  public static LoginDetails InValidCredential () throws IOException {
		    	
			  LoginDetails lg =new LoginDetails();
		    	
		    	lg.setUserEmail(getData("InvalidUserEmail","UserData"));
		    	lg.setUserPassword(getData("InvalidUserPassword","UserData"));
		    	
		    	return lg;
		    	
		    	
		    }
		
		
		  public static HashMap<String, String> ProductPayload(String UserId) throws IOException {
				
				HashMap<String, String> product =new HashMap<String, String>();
				                 
				product.put("productName", getData("productName","ProductData"));
				product.put("productAddedBy", UserId);

				product.put("productCategory", getData("productCategory","ProductData"));

				product.put("productSubCategory", getData("productSubCategory","ProductData"));

				product.put("productPrice", "1500");

				product.put("productDescription", getData("productDescription","ProductData"));

				product.put("productFor", getData("productFor","ProductData"));
				
		        
			

				return product;
				
			
			}
		
		public static HashMap<String, String> InvalidProductPayload(String UserId) throws JsonProcessingException {
			
			HashMap<String, String> product =new HashMap<String, String>();
			                 
			product.put("productName", "Apple iPhone 15 Pro (256 GB) - Blue Titanium");
			product.put("productAddedBy", UserId);

			product.put("productCategory", "electronics");

			product.put("productSubCategory", "mobile");

			product.put("productPrice", "150000");

			product.put("productDescription", "Apple iPhone 15 Pro Max ");

			product.put("productFor", "All");
			
	     
			return product;
			
		
		}
		
		public static OrderList Orderpayload(String ProductOrderedId)  {
			
			
		OrderDetails  Details= new OrderDetails();
		
		  Details.setCountry("India");
		   Details.setProductOrderedId(ProductOrderedId);

		   
		  List<OrderDetails> OrderArry= new ArrayList<OrderDetails>();
		  OrderArry.add(Details);
		  
		  OrderList list=new OrderList();
		  list.setOrders(OrderArry);
		  
		  
		
		  
		  return list;
		  

	}



	

	}
