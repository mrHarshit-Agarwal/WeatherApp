<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category List</title>
</head>
<body>
	<h2>Category List</h2>

	<c:forEach var="category" items="${categories}">
		<tr>
			<td>${category.id}</td>
			<td>${category.name}</td>
			<td><a href="/categories/edit/${category.id}">Edit</a> | <a
				href="/categories/delete/${category.id}">Delete</a></td>
		</tr>
	</c:forEach>



	<br>
	<a href="index.jsp">Return to Home</a>

</body>
</html>