package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.Product;
import com.dao.ProductOp;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductOp operation;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("action") != null) {
			
			operation.removeProduct(Long.parseLong(request.getParameter("id")));
			
		}else {
			
			String name = request.getParameter("Prodname");
			String description = request.getParameter("Proddescription");
			double price = Double.parseDouble(request.getParameter("Prodprice"));
			
			Product p = new Product(1L,name, description, price);
			operation.addProduct(p);
			
		}
		
		ProductBean bean = new ProductBean();
		bean.setListProduct(operation.getListProducts());
		request.setAttribute("modele", bean);
		request.getRequestDispatcher("Prod.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		operation = new ProductOp();
	}
	
	
}
