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
        <title>Your Home Page</title>
    </head>
    <body>
        <h1>Tires R' Us</h1>
        <ul>
            <a href="index.html"><li>Home Page</li></a>
            <a href="about.jsp"><li>Help</li></a>
        </ul>
        <h1>Enter Your Details Below</h1>
        <form action="http://localhost:8080/TiresRUs/CreateAdminAcct" method="post">
        
        <table>
            <tr><td>Username:</td><td>
                    <input type = "text" name = "username_field" value = "" /></td>
            <tr>
                <td>Password:</td>
                <td><input type = "text" name = "password_field" value = "" /></td>
            </tr>
        </table>
            <input type="submit" value="Done">
</form>
    </body>
</html>
