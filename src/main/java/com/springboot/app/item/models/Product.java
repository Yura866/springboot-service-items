package com.springboot.app.item.models;

import java.util.Date;


public class Product {	
	private Long id;	
	private String name;	
	private Double price;	
	private Date createAt;
	private Integer port;
	
	public Product() {}
	
	public Product(Long id, String name, Double price, Date createAt) {		
		this.id = id;
		this.name = name;
		this.price = price;
		this.createAt = createAt;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
}
