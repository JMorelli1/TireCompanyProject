<%-- 
    Document   : shipper_change_status
    Created on : Oct 23, 2019, 12:17:53 AM
    Author     : Elijah Badger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="Business.*"%>

<%
    
Order o = (Order) session.getAttribute("order_search");

String oid = o.getOrderID();
String cid = o.getCustomerID();
String status = o.getStatus();
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
        <h1>Choose a new status:</h1>
        <form action="http://localhost:8080/TiresRUs/modifyOrderServlet" method="post">
                         <select name = "list" id = "list">
               <option value = "Processing">Processing</option>
               <option value = "In Transit">Transit</option>
               <option value = "Completed">Completed</option>
             </select>
        
        <input type = "submit" name = "send" value="Edit Status" />
        </form>
    </body>
</html>
