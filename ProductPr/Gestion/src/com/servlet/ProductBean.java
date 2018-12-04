package com.servlet;

import java.util.ArrayList;

import com.dao.Product;

public class ProductBean {
	
	private Product product = new Product();
	private ArrayList<Product> listProduct = new ArrayList<Product>();
	
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public ArrayList<Product> getListProduct() {
		return listProduct;
	}
	
	public void setListProduct(ArrayList<Product> listProduct) {
		this.listProduct = listProduct;
	}
	
	
}
