<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add category</title>
</head>
<body>
<h2>Add Category</h2>
    <form method="post" action="/categories">
        Name: <input type="text" name="name" required><br>
        <button type="submit">Add Category</button>
    </form>
    <br><a href="index.jsp">Return to Home</a>
</body>
</html>