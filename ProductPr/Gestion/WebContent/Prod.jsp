<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products list</title>
</head>
<body>
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
</body>
</html>