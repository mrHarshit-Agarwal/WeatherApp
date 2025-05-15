<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction List</title>
</head>
<body>
	<h2>Transaction List</h2>
	<table border="2">
		<tr>
			<th>ID</th>
			<th>Type</th>
			<th>Amount</th>
			<th>Date</th>
			<th>Description</th>
			<th>Category</th>
			<th>User</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="transaction" items="${transactions}">
			<tr>
				<td>${transaction.id}</td>
				<td>${transaction.type}</td>
				<td>${transaction.amount}</td>
				<td>${transaction.date}</td>
				<td>${transaction.category}</td>
				<td>${transaction.categry.name}</td>
				<td>${transaction.user.name}</td>
				<td><a href="/transactions/edit/${transaction.id}">Edit</a> | <a
					href="/transactions/delete/${transaction.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="index.jsp">Return to Home</a>

</body>
</html>