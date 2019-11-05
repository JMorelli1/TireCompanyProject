<%-- 
    Document   : admin_homepage
    Created on : Sep 25, 2019, 2:39:29 PM
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
        <title>Your Home Page</title>
    </head>
    <body>
        <h1>Tires R' Us</h1>
        <ul>
            <a href="index.html"><li>Home Page</li></a>
            <a href="about.jsp"><li>Help</li></a>
        </ul>
        <h1>Welcome, <%=username%>!</h1>
        <a href="admin_profile.jsp"> <button>View/Edit Profile</button></a>
        <a href="admin_stock_lookup.jsp"> <button>Lookup Stock</button></a>
        <a href="admin_add_stock.jsp"> <button>Add To Stock</button></a>   


    </body>
</html>
