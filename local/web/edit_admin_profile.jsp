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
        <link rel="stylesheet" href="style.css">
        <title><%=username%>'s Profile</title>
    </head>
    <body>
    <nav>
        <div class="logo">
            <a class="mm" href="index.jsp"><h4>T1tires</h4></a>
        </div>
        <ul class="nav-links">
            <li><a href="admin_homepage.jsp">Homepage</a></li> 
            <li><a href="faq.jsp">Help</a></li>
        </ul>
    </nav>
       
        <h1 class="h1ap">Welcome, <%=username%>!</h1>
        <h3 class="h1ap"> Change Username and password</h3>
        <form action="http://localhost:8080/TiresRUs/adminProfileSeverlet" method = post>
            <table class="aast">
            <tr><td>Username:</td><td><input type = "text" name = "username" value = ""/></td></tr>
            <tr><td>Password:</td><td><input type = "text" name = "password" value = ""/></td></tr>
            </table>

             <div class="inputasl">
            <input  type = "submit" name = "enter" value="Submit Changes"/>
             </div>
        </form>
    </body>
</html>
