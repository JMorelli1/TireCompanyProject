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
       <a class="mm" href="index.html"<h4>T1tires</h4></a>
        </div>
        <ul class="nav-links">
            <li>
                <a href="index.html">Home</a>
            </li> 
              <li>
                <a href="admin_homepage.jsp">Your Home page</a>
            </li> 
            <li>
                <a href="faq.jsp">Help</a>
            </li>
        </ul>
    </nav>
       
        <h1>Welcome, <%=username%>! Enter stock ID number.</h1>
        <form action="adminStockLookup" method="post">

            <input type = "text" name = "stock" value = ""/>


            <input type = "submit" name = "enter" value="Submit"/>

    </body>
</html>
