<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Transaction</title>
</head>
<body>
	<h2>Delete Transaction</h2>
	<h2>Delete Transaction</h2>
	<p>Are you sure you want to delete transaction #${transaction.id} for ${transaction.amount}?</p>
	<form method="post" action="/transactions/delete/${transaction.id}">
		<button type="submit">Yes, Delete</button>
	</form>
	<a href="/transactions">Cancel</a>
	<br>
	<a href="index.jsp">Return to Home</a>
</body>
</html>