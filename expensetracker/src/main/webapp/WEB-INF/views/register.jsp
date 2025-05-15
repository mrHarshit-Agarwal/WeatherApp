<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register user</title>
</head>
<body>

		<h2>Sign Up</h2>
	<br><br>

	<form action="/users/register" method="post">
		<label for="name">Name:</label>
		<input type="text" id="name" name="name" required>
		<br><br>

		<label for="email">Email:</label>
		<input type="email" id="email" name="email" required>
		<br><br>

		<label for="password">Password:</label>
		<input type="password" id="password" name="password" required>
		<br><br>

		<input type="submit" value="Register">
	</form>

	<br>
	<a href="index.jsp">Return to Home</a>
</body>
</html>

