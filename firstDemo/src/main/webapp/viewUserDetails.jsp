<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.chainsys.firstDemo.model.UserDetails" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
<h2>User Details</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Actions</th>
    </tr>
    <%
        List<UserDetails> users = (List<UserDetails>) request.getAttribute("users");
        if (users != null) {
            for (UserDetails user : users) {
    %>
                <tr>
                    <td><%= user.getId() %></td>
                    <td><%= user.getName() %></td>
                    <td><%= user.getAge() %></td>
                    <td>
                        <a href="updateUser.jsp?id=<%= user.getId() %>&name=<%= user.getName() %>&age=<%= user.getAge() %>">Update</a>
                        <form action="/deleteUser" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="<%= user.getId() %>">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
