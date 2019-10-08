<%-- 
    Document   : login
    Created on : Oct 8, 2019, 11:10:08 AM
    Author     : jacob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="align-content: center">
            <form action="LoginServlet" method="post">
                Username: <input type="text" name="username" id="username" value="" />
                <br/><br/>
                password: <input type="password" name="password" id="password" />
               <br/><br/>
                <input type="Submit" value="Login" />
                <input type="Reset" value="Clear" />                
            </form>
            <form action="Create_Account.jsp">
            <input type="submit" value="Create Account" />
            </form>
        </div>
    </body>
</html>
