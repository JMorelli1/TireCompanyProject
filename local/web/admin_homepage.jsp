<%-- 
    Document   : admin_homepage
    Created on : Sep 25, 2019, 2:39:29 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import = "Business.*" %>

<%Admin a = (Admin) session.getAttribute("admin");
    String username = a.getUsername();
    String URL = request.getRequestURL().toString();
    String logoutURL = URL.substring(0, URL.length() - 18) + "LogoutServlet";%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="style.css">
        <title>Your Home Page</title>
    </head>
    <body>
    <nav>
        <div class="logo">
            <a class="mm" href="index.jsp"><h4>T1tires</h4></a>
        </div>
        <ul class="nav-links">
            <li><a href="admin_homepage.jsp">Homepage</a></li> 
            <li><a href="faq.jsp">Help</a></li>
            <li><a href="<%=logoutURL%>">Logout</a></li>
        </ul>
    </nav>
        
    
        </br>
         </br>
         
        <h1 class="h1-admin">Welcome, <%=username%>!</h1>
        
        
         </br> </br>
         
         <div class="vas">
             
             
        <a href="admin_profile.jsp"><img  src="photos/edit.png" name="e" ></a>
        <a href="admin_stock_lookup.jsp"><img  src="photos/search.png" name="s"></a>
        <a href="admin_add_stock.jsp"><img  src="photos/add.png" name="a"></a>
          </div>
     
         <div class="vasB">
        <a href="admin_profile.jsp"> <button>View/Edit Profile</button></a>
        <a href="admin_stock_lookup.jsp"> <button>Lookup Stock</button></a>
        <a href="admin_add_stock.jsp"> <button>Add To Stock</button></a>   
         </div>

    </body>
    
             <div class="footer">
  <p>© 2019 Team1 Tires, Inc</p> 
  
     <ul class="footer-links">
              <li><a href="about.jsp">About</a></li>
              <li><a href="#">Terms</a></li>
              <li><a href="#">Pricing</a></li>
              <li><a href="#/">Contact</a></li>
              <li><a href="#">Careers</a></li>
            </ul>
          </div>
</html>
