<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.jsp.expensetracker.DTO.User"%>
<%
User user = (User) session.getAttribute("user");
if (user == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>
</head>
<body>
	<h2>
		Welcome,
		<%=user.getName()%></h2>

	<h3>Quick Actions:</h3>
	<ul>
		<li><a href="add-category.jsp">Add Category</a></li>
		<li><a href="category-list.jsp">View Categories</a></li>
		<li><a href="add-transaction.jsp">Add Transaction</a></li>
		<li><a href="transaction-list.jsp">View Transactions</a></li>
	</ul>

	<br>
	<br>
	<form action="logout" method="post">
		<button type="submit">Logout</button>
	</form>
</body>
</html>
