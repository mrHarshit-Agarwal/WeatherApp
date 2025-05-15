<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Transaction</title></head>
<body>
    <h2>Edit Transaction</h2>
    
    <form method="post" action="/transactions/update">
    <input type="hidden" name="id" value="${transaction.id}" />

    Type:
    <select name="type">
        <option value="income" ${transaction.type == 'income' ? 'selected' : ''}>Income</option>
        <option value="expense" ${transaction.type == 'expense' ? 'selected' : ''}>Expense</option>
    </select><br>

    Amount: <input type="number" name="amount" step="0.01" value="${transaction.amount}" required><br>
    Date: <input type="date" name="date" value="${transaction.date}" required><br>
    Description: <input type="text" name="category" value="${transaction.category}" required><br>
    Category ID: <input type="text" name="categoryId" value="${transaction.categry.id}" required><br>
    User ID: <input type="text" name="userId" value="${transaction.user.id}" required><br>

    <button type="submit">Update</button>
</form>
    
    <br><a href="index.jsp">Return to Home</a>
</body>
</html>