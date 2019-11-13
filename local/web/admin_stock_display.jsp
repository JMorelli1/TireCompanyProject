<%-- 
    Document   : admin_stock_display
    Created on : Oct 24, 2019, 3:08:50 AM
    Author     : Elijah Badger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "Business.*" %>

<%Tire t = (Tire) session.getAttribute("adminSearchTire");
    String type = t.getType();
    String size = t.getSize();
    String brand = t.getBrand();
    String stock = t.getStock();
    String price = t.getPrice();
    String id = t.getStockID();
    String vtype = t.getVehicleType();%>



<%Admin a = (Admin) session.getAttribute("admin");
    String empn = a.getEmpNumber();
    String pass = a.getPassword();
    String username = a.getUsername();%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link rel="stylesheet" href="style.css">
        <title>Stock Lookup</title>
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
        <h1>Welcome, <%=username%>!</h1>
        <form action="stockModifyServlet">
            <table>
                
                <tr><td>Type:</td><td><input type = "text" name = "Modifytype" value = <%=type%> /></td></tr>
                <tr><td>Size:</td><td><input type = "text" name = "Modifysize" value = <%=size%> /></td></tr>
                <tr><td>Brand:</td><td><input type = "text" name = "Modifybrand" value = <%=brand%> /></td></tr>
                <tr><td>Stock:</td><td><input type = "text" name = "Modifystock" value = <%=stock%> /></td></tr>
                <tr><td>Price:</td><td><input type = "text" name = "Modifyprice" value = <%=price%> /></td></tr>
                <tr><td>Vehicle Type:</td><td><input type = "text" name = "Modifyvtype" value = <%=vtype%> /></td></tr>

            </table>
                <input type="submit" value="Modify" />
            </form>
    </body>
</html>
