package com.ecom.payload;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)


public class ViewProductResponse {
	
	
	@JsonProperty("data")
	private ViewData data;
	@JsonProperty("message")
	private String message;

	@JsonProperty("data")
	public ViewData getData() {
	return data;
	}

	@JsonProperty("data")
	public void setData(ViewData data) {
	this.data = data;
	}

	@JsonProperty("message")
	public String getMessage() {
	return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
	this.message = message;
	}

}
