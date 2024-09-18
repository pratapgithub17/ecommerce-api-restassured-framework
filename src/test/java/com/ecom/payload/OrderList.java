package com.ecom.payload;

import java.util.Collection;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class OrderList {

@JsonProperty("orders")
private List<OrderDetails> orders;

public List<OrderDetails> getOrders() {
	return orders;
}

public void setOrders(List<OrderDetails> orders) {
	this.orders = orders;
}





}