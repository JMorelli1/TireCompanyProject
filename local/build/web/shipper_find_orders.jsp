<%-- 
    Document   : shipper_find_orders
    Created on : Sep 25, 2019, 2:42:26 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Search Page</title>
    </head>
    <body>
        <h1>Tires R' Us</h1>
        <ul>
            <a href="shipper_homepage.jsp"><li>Your Home Page</li></a>
            <a href="index.html"><li>Home Page</li></a>
            <a href="about.jsp"><li>Help</li></a>
        </ul>
        <h1>Welcome, Shipper!</h1>
<form action="http://localhost:8080/TiresRUs/findOrdersServlet" method="post">
        <input type = "text" id = "oid_field" value = "" />
        <input type = "submit" id = "send" value="Submit"/>
</form>
    </body>
</html>
