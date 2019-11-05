<%-- 
    Document   : admin_add_stock
    Created on : Sep 25, 2019, 2:39:54 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "Business.*" %>

<%Admin a = (Admin) session.getAttribute("admin");
    String empn = a.getEmpNumber();
    String pass = a.getPassword();
    String username = a.getUsername();%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Stock</title>
    </head>
    <body>
        <h1>T1 Tires</h1>
        <ul>
            <a href="admin_homepage.jsp"><li>Your Home Page</li></a>
            <a href="index.html"><li>Home Page</li></a>
            <a href="about.jsp"><li>Help</li></a>
        </ul>
        <h1>Welcome, <%=username%>!</h1>
        <form action="http://localhost:8080/TiresRUs/addStockServlet" method="post">
            <table>
                <tr><td>Type:</td><td><input type = "text" name = "type" value = ""/></td></tr>
                <tr><td>Size:</td><td><input type = "text" name = "size" value = ""/></td></tr>
                <tr><td>Brand:</td><td><input type = "text" name = "brand" value = ""/></td></tr>
                <tr><td>Stock:</td><td><input type = "text" name = "stock" value = ""/></td></tr>
                <tr><td>Price:</td><td><input type = "text" name = "price" value = ""/></td></tr>
                <tr><td>Vehicle Type:</td><td><input type = "text" name = "vtype" value = ""/></td></tr>
                <tr><td>ID:</td><td><input type = "text" name = "id" value = ""/></td></tr>

            </table>
            <input type = "submit" name = "Add" value="Add"/>
        </form>
    </body>
</html>
