package com.dao;

import java.util.ArrayList;

public class ProductOp {
	
	private ArrayList<Product> listProducts = new ArrayList<Product>();

	public ArrayList<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(ArrayList<Product> listProducts) {
		this.listProducts = listProducts;
	}
	
	/**
	 * Add a product
	 * 
	 * @param p
	 */
	public void addProduct (Product p) {
		listProducts.add(p);
	}
	
	/**
	 * Remove a product
	 * 
	 * @param id
	 */
	public void removeProduct (Long id) {
		for(Product p : listProducts) {
			if(p.getId() == id) {
				listProducts.remove(p);
				break;
			}
			break;
		}
	}
	
	public ArrayList<Product> getAllProducts () {
		return listProducts;
	}
	
}
