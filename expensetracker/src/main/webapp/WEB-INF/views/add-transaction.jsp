<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Transaction</title></head>
<body>
<h2> Add Transaction </h2> <br><br>
   <form method="post" action="/transactions/add">
    Type:
    <select name="type">
        <option value="income">Income</option>
        <option value="expense">Expense</option>
    </select><br>

    Amount: <input type="number" name="amount" step="0.01" required><br>
    Date: <input type="date" name="date" required><br>
    Description: <input type="text" name="category" required><br>
    Category ID: <input type="text" name="categoryId" required><br>
    User ID: <input type="text" name="userId" required><br>

    <button type="submit">Add Transaction</button>
    <br>
</form>
    
    <br><a href="index.jsp">Return to Home</a>
</body>
</html>