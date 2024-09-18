package com.ecom.payload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadClass {
	
	  public static LoginDetails ValidCredential () {
	    	
		  LoginDetails lg =new LoginDetails();
	    	
	    	lg.setUserEmail("pratap.sdet@gmail.com");
	    	lg.setUserPassword("Pratap@321");
	    	
	    	return lg;
	    	
	    	
	    }
	  
	  public static LoginDetails InValidCredential () {
	    	
		  LoginDetails lg =new LoginDetails();
	    	
	    	lg.setUserEmail("pratap.sde@gmail.com");
	    	lg.setUserPassword("Pratap@320");
	    	
	    	return lg;
	    	
	    	
	    }
	
	
	public static HashMap<String, String> ProductPayload(String UserId) throws JsonProcessingException {
		
		HashMap<String, String> product =new HashMap<String, String>();
		                 
		product.put("productName", "Women Ethic Dress");
		product.put("productAddedBy", UserId);

		product.put("productCategory", "Women Dress");

		product.put("productSubCategory", "Western Style");

		product.put("productPrice", "1500");

		product.put("productDescription", "Mutipurpose, regular, wedding use dress");

		product.put("productFor", "women");
		
        ObjectMapper mapper=new ObjectMapper();
		
		String JSON= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(product);
		
		System.out.println(JSON);
	

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
