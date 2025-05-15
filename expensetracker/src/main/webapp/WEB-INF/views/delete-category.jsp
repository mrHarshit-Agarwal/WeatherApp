<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Category</title>
</head>
<body>
	<h2>Delete Category</h2>
	<p>Are you sure you want to delete category: ${category.name}?</p>
	<form method="post" action="/categories/delete/${category.id}">
		<button type="submit">Yes, Delete</button>
	</form>
	<a href="/categories">Cancel</a>

	<br>
	<a href="index.jsp">Return to Home</a>
</body>
</html>