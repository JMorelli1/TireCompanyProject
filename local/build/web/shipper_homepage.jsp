<%-- 
    Document   : shipper_homepage
    Created on : Sep 25, 2019, 2:41:28 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "Business.*" %>
<%Shipper s = (Shipper) session.getAttribute("shipper");
    String URL = request.getRequestURL().toString();
    String logoutURL = URL.substring(0, URL.length() - 20) + "LogoutServlet";
    String username = s.getUsername();%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shipper Home Page</title>
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
    <nav>
        <div class="logo">
            <a class="mm" href="index.jsp"><h4>T1tires</h4></a>
        </div>
        <ul class="nav-links">
            <li><a href="shipper_homepage.jsp">Homepage</a></li> 
            <li><a href="faq.jsp">Help</a></li>
            <li><a href="<%=logoutURL%>">Logout</a></li>
        </ul>
    </nav>
        <h1>Welcome, <%=username%>!</h1>
        <a href="view_customer_orders.jsp"><button>View Orders</button></a>
    </body>
</html>
