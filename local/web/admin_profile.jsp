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
        <table>
        <tr><td>ID:</td><td><input type = "text" name = "emp_id" value = <%=empn%> /></td></tr>
        <tr><td>Username:</td><td><input type = "text" name = "username" value = <%=username%> /></td></tr>
        <tr><td>Password:</td><td><input type = "text" name = "password" value = <%=pass%> /></td></tr> 
        </table>
        <a href="edit_admin_profile.jsp"><input type="submit" name = "enter" value="Edit Profile"/></a>

    </body>
</html>
