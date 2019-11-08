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
        <title>Join us today!</title>
    </head>
    <body>
  <nav>
        <div class="logo">
            <a class="mm" href="index.jsp"<h4>T1tires</h4></a>
        </div>
        <ul class="nav-links">
            <li><a href="login.jsp">Login</a></li> 
            <li><a href="tireSearch.jsp">Search</a></li> 
            <li><a href="about.jsp">About</a></li>
            <li><a href="faq.jsp">FAQ</a></li>
        </ul>
    </nav>
        <form action="CreateCustomerAcct" method="post">
        
             <div class="login-box">
    <img src="avatar.png" class="avatar">
        <h1>Enter your information</h1>
            <form>
                <label>Username</label>
                <input type="text" name="username_field" placeholder="">
                <label>Password</label>
                <input type="password" name="password_field" placeholder="">
              
                <label>First Name</label>
                <input type="text" name="fname_field" placeholder="">
                <label>Last Name</label>
                <input type="text" name="lname_field">
                <label>Address</label>
                <input type="text" name="addr_field">
                <label>Phone Number</label>
                <input type="text" name="phone_field">
                <label>Credit Card Number</label>
                <input type="text" name="cardnumber_field">
                <label>Card Expiration Date</label>
                <input type="text" name="expire_field">
                <label>Security Code</label>
                <input type="text" name="security_field">
                <input type="submit" name="submit" value="SIGN UP">
             
            </form>
        </div>
    </form>
    </body>
</html>
