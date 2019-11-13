<%-- 
    Document   : admin_stock_lookup
    Created on : Sep 25, 2019, 2:41:02 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>   <link rel="stylesheet" href="style.css">
<!DOCTYPE html>
<%@page import = "Business.*" %>

<%Admin a = (Admin) session.getAttribute("admin");
    String empn = a.getEmpNumber();
    String pass = a.getPassword();
    String username = a.getUsername();%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stock Lookup</title>
    </head>
    <body>
    <nav>
        <div class="logo">
            <a class="mm" href="index.jsp"><h4>T1tires</h4></a>
        </div>
        <ul class="nav-links">
            <li><a href="admin_homepage.jsp">Homepage</a></li> 
            <li><a href="faq.jsp">Help</a></li>
        </ul>
    </nav>

        
        <h1 class="h1asl">Welcome, <%=username%>! Enter stock ID number.</h1>



        <form action="adminStockLookup" method="post">

             <div class="inputasl">
            <input type = "text" name = "stock" value = ""/>
          
            <div class="inputasl">
             <input type = "submit" name = "enter" value="Submit"/>
            </div>
    </body>
</html>
