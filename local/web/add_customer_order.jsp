<%-- 
    Document   : add_customer_order
    Created on : Sep 25, 2019, 2:46:10 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Order</title>
    </head>
    <body>
        <h1>T1 Tires</h1>
        <ul>
            <a href="customer_homepage.jsp"><li>Your Home Page</li></a>
            <a href="index.html"><li>Home Page</li></a>
            <a href="about.jsp"><li>Help</li></a>
        </ul>
        <form action="http://localhost:8080/TiresRUs/customerProfileServlet" method="post">
            <input type = "text" name = "oid_field" value = "" />
            <input type = "text" name = "tid_field" value = "" />
            <input type = "text" name = "quantity_field" value = "" />

            <input type = "submit" name = "send" value="Submit"/>
        </form>
    </body>
</html>
