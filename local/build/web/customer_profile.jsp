<%-- 
    Document   : customer_profile
    Created on : Sep 25, 2019, 2:44:00 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Business.*" %>

<%Customer c = (Customer) session.getAttribute("customer");
    String cid = c.getCID();
    String fn = c.getFN();
    String ln = c.getLN();
    String username = c.getUsername();
    String pass = c.getPassword();
    String addr = c.getAddress();
    String phone = c.getPhone();
    String card_info = c.getCreditCardInfo();
    String exp_date = c.getExpireDate();
    String sec_code = c.getSecurityCode();%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="style.css">
        <title>Your Profile</title>
    </head>
    <body>
    <nav>
        <div class="logo">
            <a class="mm" href="index.jsp"><h4>T1tires</h4></a>
        </div>
        <ul class="nav-links">
            <li><a href="customer_homepage.jsp">Homepage</a></li>
            <li><a href="tireSearch.jsp">Search</a></li> 
            <li><a href="about.jsp">About</a></li>
            <li><a href="faq.jsp">FAQ</a></li>
        </ul>
    </nav>

        <h1 class="h1asl">Welcome, <%=fn%>!</h1>
        <div class="cpt">
        <table>
            <tr>
                <td>Customer ID number:</td>
                <td><input type = "text" id = "id_field" value = <%=cid%> readonly/></td>
            </tr>
            <tr><td>Username:</td><td>
                    <input type = "text" id = "username_field" value = <%=username%> readonly/></td>
            <tr>
                <td>Password:</td>
                <td><input type = "text" id = "password_field" value = <%=pass%> readonly/></td>
            </tr>
            <tr><td>First Name:</td>
                <td><input type = "text" id = "fname_field" value = <%=fn%> readonly/></td>
            </tr>
            <tr><td>Last Name:</td>
                <td><input type = "text" id = "lname_field" value = <%=ln%> readonly/></td>
            </tr>
            <tr><td>Address:</td>
                <td><input type = "text" id = "addr_field" value = <%=addr%> readonly/></td>
            </tr>
            <tr><td>Phone Number:</td>
                <td><input type = "text" id = "phone_field" value = <%=phone%> readonly/></td>
            </tr>
            <tr><td>Card Number:</td>
                <td><input type = "text" id = "cardnumber_field" value = <%=card_info%> readonly/></td>
            </tr>
            <tr><td>Expiration Date:</td>
                <td><input type = "text" id = "expire_field" value = <%=exp_date%> readonly/></td>
            </tr>
            <tr><td>Security Code:</td>
                <td><input type = "text" id = "security_field" value = <%=sec_code%> readonly/></td>
            </tr>
        </table>
        </div>
            
            <div class="cpb">
        <a href="edit_customer_profile.jsp"><button>Edit</button></a>
            </div>
  

    </body>
   
    
</html>
