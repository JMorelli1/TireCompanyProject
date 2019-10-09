<%-- 
    Document   : Create_Account
    Created on : Oct 8, 2019, 11:33:40 AM
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
            <form action="createAcctServlet" method="post">
                Username: <input type="text" name="username" id="username" value="" />
                <br/><br/>
                Password: <input type="password" name="password" id="password" />
                <br/><br/>
                ID: <input type="text" name="ID" id="ID" value="" />
                <br/><br/>
                First Name: <input type="text" name="fname" id="fname" value="" />
                <br/><br/>
                Last Night: <input type="text" name="lname" id="lname" value="" />
                <br/><br/>
                Address: <input type="text" name="address" id="address" value="" />
                <br/><br/>
                Phone: <input type="text" name="phone" id="phone" value="" />
                <br/><br/>
                Credit Card Number: <input type="text" name="creditCardInfo" id="creditCardInfo" value="" />
                <br/><br/>
                Credit Card Expiration Date: <input type="date" name="expireDate" id="expireDate" value="2019-01-01"
                min="2019-01-01" max="2029-12-31" />
                <br/><br/>
                Credit Card Security Code: <input type="text" name="securityCode" id="securityCode" value="" />
                <br/><br/>
               
                <input type="submit" value="Create" />
                <input type="reset" value="Clear" />
            </form>
        </div>
    </body>
</html>
