<%-- 
    Document   : admin_profile
    Created on : Sep 25, 2019, 2:40:13 PM
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
        <title><%=username%>'s Profile</title>
    </head>
    <body>
        <h1>Tires R' Us</h1>
        <ul>
            <a href="admin_homepage.jsp"><li>Your Home Page</li></a>
            <a href="index.html"><li>Home Page</li></a>
            <a href="about.jsp"><li>Help</li></a>
        </ul>
        <h1>Welcome, <%=username%>!</h1>
        <form action="http://localhost:8080/TiresRUs/adminProfileSeverlet" method = post>
            <table>
            <tr><td>Username:</td><td><input type = "text" name = "username" value = ""/></td></tr>
            <tr><td>Password:</td><td><input type = "text" name = "password" value = ""/></td></tr>
            </table>

            <input type = "submit" name = "enter" value="Submit Changes"/>
        </form>
    </body>
</html>
