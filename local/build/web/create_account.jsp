<%-- 
    Document   : create_account
    Created on : Sep 25, 2019, 2:37:53 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Home Page</title>
    </head>
    <body>
        <h1>Tires R' Us</h1>
        <ul>
            <a href="index.html"><li>Home Page</li></a>
            <a href="about.jsp"><li>Help</li></a>
        </ul>
        <h1>Enter Your Details Below</h1>
        <form action="http://localhost:8080/TiresRUs/CreateCustomerAcct" method="post">
        
        <table>
            <tr><td>Username:</td><td>
                    <input type = "text" name = "username_field" value = "" /></td>
            <tr>
                <td>Password:</td>
                <td><input type = "text" name = "password_field" value = "" /></td>
            </tr>
            <tr><td>First Name:</td>
                <td><input type = "text" name = "fname_field" value = "" /></td>
            </tr>
            <tr><td>Last Name:</td>
                <td><input type = "text" name = "lname_field" value = "" /></td>
            </tr>
            <tr><td>Address:</td>
                <td><input type = "text" name = "addr_field" value = "" /></td>
            </tr>
            <tr><td>Phone Number:</td>
                <td><input type = "text" name = "phone_field" value = "" /></td>
            </tr>
            <tr><td>Credit/Debit Card Number:</td>
                <td><input type = "text" name = "cardnumber_field" value = "" /></td>
            </tr>
            <tr><td>Expiration Date:</td>
                <td><input type = "text" name = "expire_field" value = "" /></td>
            </tr>
            <tr><td>Security Code:</td>
                <td><input type = "text" name = "security_field" value = "" /></td>
            </tr>
        </table>
            <input type="submit" value="Done">
</form>
    </body>
</html>
