<%-- 
    Document   : shipper_homepage
    Created on : Sep 25, 2019, 2:41:28 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "Business.*" %>
<%Shipper s = (Shipper) session.getAttribute("shipper");
    String empn = s.getSID();
    String pass = s.getPassword();
    String username = s.getUsername();%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shipper Home Page</title>
    </head>
    <body>
        <h1>Tires R' Us</h1>
        <ul>
            <a href="index.html"><li>Home Page</li></a>
            <a href="about.jsp"><li>Help</li></a>
        </ul>
        <h1>Welcome, <%=username%>!</h1>
        <a href="view_customer_orders.jsp"><button>View Orders</button></a>
    </body>
</html>
