<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Category</title></head>
<body>
    <h2>Edit Category</h2>
    <form method="post" action="/categories/update">
        ID: <input type="text" name="id" required><br>
        Name: <input type="text" name="name" required><br>
        <button type="submit">Update</button>
    </form>
    <br><a href="index.jsp">Return to Home</a>

</body>
</html>

