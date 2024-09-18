package com.ecom.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class OrderDetails {
	
	@JsonProperty("country")
	private String country;
	@JsonProperty("productOrderedId")
	private String productOrderedId;

	@JsonProperty("country")
	public String getCountry() {
	return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
	this.country = country;
	}

	@JsonProperty("productOrderedId")
	public String getProductOrderedId() {
	return productOrderedId;
	}

	@JsonProperty("productOrderedId")
	public void setProductOrderedId(String productOrderedId) {
	this.productOrderedId = productOrderedId;
	}

	}


