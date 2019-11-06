<%-- 
    Document   : edit_customer_profile
    Created on : Sep 25, 2019, 2:44:22 PM
    Author     : ebadger
--%>

<%@page import="Business.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


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
        <title>Edit Profile</title>
    </head>
    <body>
        <h1>Tires R' Us</h1>
        <ul>
            <a href="customer_homepage.jsp"><li>Your Home Page</li></a>
            <a href="index.html"><li>Home Page</li></a>
            <a href="about.jsp"><li>Help</li></a>
        </ul>
        <h1>Welcome, Customer!</h1>
        <form action="customerProfileServlet" method="post">
            <table><tr><td>Enter new username:</td>
                    <td><input type = "text" name = "username_field" value = <%=username%> /></td>
                </tr><tr><td>Enter new password:</td>
                    <td><input type = "text" name = "password_field" value =<%=pass%>  /></td>
                </tr><tr><td>Enter new first name:</td>
                    <td><input type = "text" name = "fname_field" value = <%=fn%> /></td>
                </tr><tr><td>Enter new last name:</td>
                    <td><input type = "text" name = "lname_field" value = <%=ln%> /></td>
                </tr><tr><td>Enter new address:</td>
                    <td><input type = "text" name = "addr_field" value = <%=addr%> /></td>
                </tr><tr><td>Enter new phone number:</td>
                    <td><input type = "text" name = "phone_field" value = <%=phone%> /></td>
                </tr><tr><td>Enter new card number:</td>
                    <td><input type = "text" name = "cardnumber_field" value = <%=card_info%> /></td>
                </tr><tr><td>Enter new expiration date:</td>
                    <td><input type = "text" name = "expire_field" value = <%=exp_date%> /></td>
                </tr><tr><td>Enter new security code:</td>
                    <td><input type = "text" name = "security_field" value = <%=sec_code%> /></td>
                </tr>
            </table>
            <input type="submit" value="Done">

        </form>        

    </body>
</html>
