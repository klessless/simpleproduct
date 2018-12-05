package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductOp {
	
	private ArrayList<Product> listProducts = new ArrayList<Product>();

	public ArrayList<Product> getListProducts() {
		
		ArrayList<Product> list = new ArrayList<Product>();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/products","root","");
			PreparedStatement stat = connection.prepareStatement("SELECT * FROM product");
			ResultSet listSet = stat.executeQuery();
			while(listSet.next()) {
				Product p = new Product();
				p.setId(listSet.getLong("id"));
				p.setName(listSet.getString("Name"));
				p.setDescription(listSet.getString("Description"));
				p.setPrice(listSet.getDouble("Price"));
				list.add(p);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
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
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/products","root","");
			PreparedStatement stat = connection.prepareStatement("INSERT INTO product VALUES(NULL,?,?,?)");
			stat.setString(1,p.getName());
			stat.setString(2,p.getDescription());
			stat.setDouble(3,p.getPrice());
			
			stat.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//listProducts.add(p);
	}
	
	/**
	 * Remove a product
	 * 
	 * @param id
	 */
	public void removeProduct (Long id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/products","root","");
			PreparedStatement stat = connection.prepareStatement("DELETE FROM product WHERE id = ?");
			stat.setLong(1, id);;
			stat.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*for(Product p : listProducts) {
			if(p.getId() == id) {
				listProducts.remove(p);
				break;
			}
			break;
		}*/
	}
	
}
