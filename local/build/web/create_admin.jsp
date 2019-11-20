<%-- 
    Document   : create_admin
    Created on : Oct 22, 2019, 4:18:59 PM
    Author     : Elijah Badger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Your Home Page</title>
    </head>
    <body>
      <nav>
        <div class="logo">
            <h4>T1tires</h4>
        </div>
        <ul class="nav-links">
            <li>
                <a href="login.jsp">Login</a>
            </li> 
              <li>
                <a href="tireSearch.jsp">Search</a>
            </li> 
            <li>
                <a href="about.jsp">About</a>
            </li>
            <li>
                <a href="faq.jsp">FAQ</a>
            </li>
        </ul>
    </nav>
       
        <form action="CreateAdminAcct" method="post">
        
             <div class="login-box">
    <img src="avatar.png" class="avatar">
        <h1>Enter your information</h1>
            <form>
                <label>Username</label>
                <input type="text" name="username_field" placeholder="Enter Username">
                <label>Password</label>
                <input type="password" name="password_field" placeholder="Enter Password">
                <input type="submit" name="submit" value="SIGN UP">
             
            </form>
        
        
        </div>
      
</form>
    </body>
</html>
