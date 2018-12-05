package com.servlet;

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
 * Servlet implementation class ServletProduct
 */
@WebServlet("/ServletProduct")
public class ServletProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductOp operation;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("Prodname");
		String description = request.getParameter("Proddescription");
		String price = request.getParameter("Prodprice");
		
		Product p = new Product(1L,name, description, price);
		ProductBean bean = new ProductBean();
		
		operation.addProduct(p);
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
