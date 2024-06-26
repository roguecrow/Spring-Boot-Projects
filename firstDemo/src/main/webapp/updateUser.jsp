<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body>
<h2>Update User</h2>
<form action="/updateUser" method="post">
    <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="<%= request.getParameter("name") %>"><br><br>
    <label for="age">Age:</label>
    <input type="text" id="age" name="age" value="<%= request.getParameter("age") %>"><br><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
