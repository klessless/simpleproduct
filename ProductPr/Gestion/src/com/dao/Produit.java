package com.dao;

public class Produit {
	
	private Long id;
	private String name,description,price;
	
	
	/**
	 * Constructors
	 * 
	 */
	
	public Produit(String name, String description, String price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Produit(Long id, String name, String description, String price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	
	/**
	 * Getters and setters
	 *
	 */
	
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
}
