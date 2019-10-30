<%-- 
    Document   : admin_stock_display
    Created on : Oct 24, 2019, 3:08:50 AM
    Author     : Elijah Badger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "Business.*" %>

<%Tire t = (Tire) session.getAttribute("tire");
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
        <title>Stock Lookup</title>
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
                <tr><td>Type:</td><td><input type = "text" name = "type" value = <%=type%> /></td></tr>
                <tr><td>Size:</td><td><input type = "text" name = "size" value = <%=size%> /></td></tr>
                <tr><td>Brand:</td><td><input type = "text" name = "brand" value = <%=brand%> /></td></tr>
                <tr><td>Stock:</td><td><input type = "text" name = "stock" value = <%=stock%> /></td></tr>
                <tr><td>Price:</td><td><input type = "text" name = "price" value = <%=price%> /></td></tr>
                <tr><td>Vehicle Type:</td><td><input type = "text" name = "vtype" value = <%=vtype%> /></td></tr>

            </table>


                <a href="admin_stock_modify.jsp"><button>Modify</button></a>

    </body>
</html>
