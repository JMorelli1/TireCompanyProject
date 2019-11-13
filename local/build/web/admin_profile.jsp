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
        
       
        <table class="center" >
        <tr><td >ID:</td><td><input type = "text" name = "emp_id" value = <%=empn%> readonly /></td></tr>
        <tr><td>Username:</td><td><input type = "text" name = "username" value = <%=username%> readonly /></td></tr>
        <tr><td>Password:</td><td><input type = "text" name = "password" value = <%=pass%> readonly /></td></tr> 
        </table>
        </br>
        
        
        
         <div class="adpbtn">
             <a href="edit_admin_profile.jsp"<button class="adpbtn1"> Edit Profile</button></a>
        </div>
        
        </div>
    </body>
</html>
