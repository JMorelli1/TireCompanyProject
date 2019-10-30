<%-- 
    Document   : find_customer_order
    Created on : Sep 25, 2019, 2:46:36 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find Order</title>
    </head>
    <body>
        <h1>Tires R' Us</h1>
        <ul>
            <a href="shipper_homepage.jsp"><li>Your Home Page</li></a>
            <a href="index.html"><li>Home Page</li></a>
            <a href="about.jsp"><li>Help</li></a>
        </ul>
<form action="http://localhost:8080/TiresRUs/findOrdersServlet" method="post">
        <label>Order ID:</label><input type = "text" name = "oid_field" value = "" />


        <input type = "submit" name = "send" value="Search" />
</form>
    </body>
</html>
