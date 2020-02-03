package com.springboot.app.item.models;

public class Item {
	private Product product;
	private Integer amount;
	private Double total;

	public Item() {}

	public Item(Product product, Integer amount, Double total) {	
		this.product = product;
		this.amount = amount;
		this.total=total;
	}	
	
	public Item(Product product, Integer amount) {	
		this.product = product;
		this.amount = amount;		
	}


	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}	

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getTotal() {
		return product.getPrice()*amount.doubleValue();	
	}	
}
