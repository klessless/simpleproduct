package com.test;

import java.util.Iterator;

import com.dao.Product;
import com.dao.ProductOp;

public class ProductTest {

	public static void main(String[] args) {
		Product p = new Product();
		ProductOp op = new ProductOp();
		
		Product p1 = new Product(1L, "Product1", "The first product on the list", "10");
		Product p2 = new Product(1L, "Product2", "The second product on the list", "200");
		Product p3 = new Product(1L, "Product3", "The third product on the list", "3000");
		
		op.addProduct(p1);
		op.addProduct(p2);
		op.addProduct(p3);
		op.removeProduct(1L);
		op.addProduct(p2);
		
		
		Iterator<Product> list = op.getAllProducts().iterator();
		while(list.hasNext()) {
			p=list.next();
			System.out.println(p.toString());
		}
	}

}
