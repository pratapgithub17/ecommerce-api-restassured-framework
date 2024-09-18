package com.ecom.payload;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class NewOrderResponse {

@JsonProperty("orders")
private List<String> orders;
@JsonProperty("productOrderId")
private List<String> productOrderId;
@JsonProperty("message")
private String message;



@JsonProperty("orders")
public List<String> getOrders() {
return orders;
}

@JsonProperty("orders")
public void setOrders(List<String> orders) {
this.orders = orders;
}

@JsonProperty("productOrderId")
public List<String> getProductOrderId() {
return productOrderId;
}

@JsonProperty("productOrderId")
public void setProductOrderId(List<String> productOrderId) {
this.productOrderId = productOrderId;
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