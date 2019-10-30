<%-- 
    Document   : login
    Created on : Sep 25, 2019, 2:36:51 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tires R Us Log-in Page</title>
    </head>
    <body>
        <h1>Tires R' Us</h1>
        <ul>
            <li><a href="">Home Page</a></li>
            <li><a href="">Help</a></li>
        </ul>
        
        <table>
            <tr>
                <td><label>Log-in ID:</label></td>
                <td><input type = "text" id = "ID" value = "ID here" /></td>
            </tr>
            <tr>
                <td><label>Log-in Password:</label></td>
                <td><input type = "text" id = "password" value = "Password here" /></td>
            </tr>
            <tr>
            <td><input type="submit" value="Send"/></td>
            <td><input type="reset" value="Clear"/></td>
            </tr>
        </table>
        <button type="button"><a href="">Create An Account</a></button>
    </body>
</html>
