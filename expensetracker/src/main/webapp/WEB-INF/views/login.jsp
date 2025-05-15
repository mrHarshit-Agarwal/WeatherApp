<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login user</title>
</head>
<body>
<h2> Login </h2>
<br>

	<form action="/users/login" method="post">
    Email: <input type="text" name="username" /><br><br>
    Password: <input type="password" name="password" /><br><br>
    <input type="submit" value="Login" />
</form>
	
	


	<br>
	<a href="index.jsp">Return to Home</a>
</body>
</html>