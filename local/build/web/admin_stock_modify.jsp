<%-- 
    Document   : admin_stock_lookup
    Created on : Sep 25, 2019, 2:41:02 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "Business.*" %>

<%Tire adminSearchTire = (Tire) session.getAttribute("adminSearchTire");
    String type = adminSearchTire.getType();
    String size = adminSearchTire.getSize();
    String brand = adminSearchTire.getBrand();
    String stock = adminSearchTire.getStock();
    String price = adminSearchTire.getPrice();
    String id = adminSearchTire.getStockID();
    String vtype = adminSearchTire.getVehicleType();%>



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
        <form action="stockModifyServlet" method="post">
            <table>
                <tr><td>Type:</td><td><input type = "text" name = "type" value = ""/></td></tr>
                <tr><td>Size:</td><td><input type = "text" name = "size" value = ""/></td></tr>
                <tr><td>Brand:</td><td><input type = "text" name = "brand" value = ""/></td></tr>
                <tr><td>Stock:</td><td><input type = "text" name = "stock" value = ""/></td></tr>
                <tr><td>Price:</td><td><input type = "text" name = "price" value = ""/></td></tr>
                <tr><td>Vehicle Type:</td><td><input type = "text" name = "vtype" value = ""/></td></tr>

            </table>


            <input type = "submit" name = "Modify" value="Modify"/>
            </form>

    </body>
</html>
