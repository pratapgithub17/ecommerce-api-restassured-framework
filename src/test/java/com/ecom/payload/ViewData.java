package com.ecom.payload;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewData {
	
	
	@JsonProperty("_id")
	private String id;
	@JsonProperty("orderById")
	private String orderById;
	@JsonProperty("orderBy")
	private String orderBy;
	@JsonProperty("productOrderedId")
	private String productOrderedId;
	@JsonProperty("productName")
	private String productName;
	@JsonProperty("country")
	private String country;
	@JsonProperty("productDescription")
	private String productDescription;
	@JsonProperty("productImage")
	private String productImage;
	@JsonProperty("orderPrice")
	private String orderPrice;
	@JsonProperty("__v")
	private Integer v;

	@JsonProperty("_id")
	public String getId() {
	return id;
	}

	@JsonProperty("_id")
	public void setId(String id) {
	this.id = id;
	}

	@JsonProperty("orderById")
	public String getOrderById() {
	return orderById;
	}

	@JsonProperty("orderById")
	public void setOrderById(String orderById) {
	this.orderById = orderById;
	}

	@JsonProperty("orderBy")
	public String getOrderBy() {
	return orderBy;
	}

	@JsonProperty("orderBy")
	public void setOrderBy(String orderBy) {
	this.orderBy = orderBy;
	}

	@JsonProperty("productOrderedId")
	public String getProductOrderedId() {
	return productOrderedId;
	}

	@JsonProperty("productOrderedId")
	public void setProductOrderedId(String productOrderedId) {
	this.productOrderedId = productOrderedId;
	}

	@JsonProperty("productName")
	public String getProductName() {
	return productName;
	}

	@JsonProperty("productName")
	public void setProductName(String productName) {
	this.productName = productName;
	}

	@JsonProperty("country")
	public String getCountry() {
	return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
	this.country = country;
	}

	@JsonProperty("productDescription")
	public String getProductDescription() {
	return productDescription;
	}

	@JsonProperty("productDescription")
	public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
	}

	@JsonProperty("productImage")
	public String getProductImage() {
	return productImage;
	}

	@JsonProperty("productImage")
	public void setProductImage(String productImage) {
	this.productImage = productImage;
	}

	@JsonProperty("orderPrice")
	public String getOrderPrice() {
	return orderPrice;
	}

	@JsonProperty("orderPrice")
	public void setOrderPrice(String orderPrice) {
	this.orderPrice = orderPrice;
	}

	@JsonProperty("__v")
	public Integer getV() {
	return v;
	}

	@JsonProperty("__v")
	public void setV(Integer v) {
	this.v = v;
	}

}
