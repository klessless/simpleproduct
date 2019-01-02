<%@page import="com.dao.ProductOp"%>
<%@page import="java.util.Iterator"%>
<%@ page import="com.bean.ProductBean" %>
<%@ page import="com.dao.Product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products list</title>
</head>
<body>
	<%
		ProductBean bean ;
		if(request.getAttribute("modele") != null){
			bean = (ProductBean)request.getAttribute("modele");
		}else{
			ProductOp operation = new ProductOp();
			bean = new ProductBean();
			bean.setListProduct(operation.getListProducts()); 
			
		}

	%>
	<h3>Products</h3>
	<form action="productGet" method="post">
	<table>
		<tr>
			<td>Name</td>
			<td><input type="text" name="Prodname"/></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><input type="text" name="Proddescription"/></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><input type="text" name="Prodprice"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="OK"/></td>
		</tr>
		
	</table>
	</form>
	<table border="1" width="70%">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Description</th>
		<th>Price</th>
		<th>Options</th>
	</tr>
	<%
		Iterator<Product> productList = bean.getListProduct().iterator();
		while(productList.hasNext()){
			Product p = productList.next();
			 %>
	<tr>
		<td><%= p.getId() %></td>
		<td><%= p.getName() %></td>
		<td><%= p.getDescription() %></td>
		<td><%= p.getPrice() %></td>
		<td>
			<form action="productGet" method="post">
				<input type="hidden" name="id" value="<%= p.getId() %>"/>
				<input type="hidden" name="action" value="Delete"/>
				<input type="submit" value="Delete"/>
			</form>
		</td>
	</tr>
		<% }
	
	%>
	</table>
</body>
</html>