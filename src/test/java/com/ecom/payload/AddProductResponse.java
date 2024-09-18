package com.ecom.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class AddProductResponse {

@JsonProperty("productId")
private String productId;
@JsonProperty("message")
private String message;

@JsonProperty("productId")
public String getProductId() {
return productId;
}

@JsonProperty("productId")
public void setProductId(String productId) {
this.productId = productId;
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