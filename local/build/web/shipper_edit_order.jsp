<%-- 
    Document   : shipper_edit_order
    Created on : Sep 25, 2019, 2:42:59 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="Business.*"%>

<%
    
Order o = (Order) session.getAttribute("order_search");

String oid = o.getOrderID();
String cid = o.getCustomerID();
String status = o.getStatus();
String sid = o.getShipperID();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Oder</title>
    </head>
    <body>
        <h1>Tires R' Us</h1>
        <ul>
            <a href="shipper_homepage.jsp"><li>Your Home Page</li></a>
            <a href="index.html"><li>Home Page</li></a>
            <a href="about.jsp"><li>Help</li></a>
        </ul>
        <h1>Search Results:</h1>
        <form action="modifyOrderServlet" method="post">
             <select name = "list">
               <option value = "Processing">Processing</option>
               <option value = "In Transit">Transit</option>
               <option value = "Complete">Complete</option>
             </select>
        
        <input type = "submit" name = "send" value="Edit Status" />
    </body>
</html>
