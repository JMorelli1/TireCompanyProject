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
          <link rel="stylesheet" href="style.css">
        <title>Your Home Page</title>
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
                <a href="FAQ.jsp">Help</a>
            </li>
        </ul>
    </nav>
        
    
        </br>
         </br>
         
        <h1 class="h1-admin">Welcome, <%=username%>!</h1>
        
        
         </br> </br>
         
         <div class="vas">
             
             
        <img  src="edit.png" name="e" >
        <img  src="search.png" name="s">
        <img  src="add.png" name="a">
          </div>
     
         <div class="vasB">
        <a href="admin_profile.jsp"> <button>View/Edit Profile</button></a>
        <a href="admin_stock_lookup.jsp"> <button>Lookup Stock</button></a>
        <a href="admin_add_stock.jsp"> <button>Add To Stock</button></a>   
         </div>

    </body>
</html>
