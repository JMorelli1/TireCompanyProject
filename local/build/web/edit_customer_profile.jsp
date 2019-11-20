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
        <link rel="stylesheet" href="style.css" />
        <title>Edit Profile</title>
    </head>
    <body>
    <nav>
        <div class="logo">
            <a class="mm" href="index.jsp"><h4>T1tires</h4></a>
        </div>
        <ul class="nav-links">
            <li><a href="customer_homepage.jsp">Homepage</a></li>
            <li><a href="tireSearch.jsp">Search</a></li> 
            <li><a href="about.jsp">About</a></li>
            <li><a href="faq.jsp">FAQ</a></li>
        </ul>
    </nav>
        <h1 class="h1ap">Update your information below, <%=username%>!</h1>
        <form action="customerProfileServlet" method="post">
          
                <div class="aast">
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
            </div>
                
        </br>
                 <div class="inputasl">   
                  
            <input type="submit" value="Done">
                 </div>
        </form>        

    </body>
</html>
