<%-- 
    Document   : view_orders
    Created on : Oct 24, 2019, 1:31:56 AM
    Author     : Elijah Badger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Business.*" %>
<%@page import = "java.sql.*" %>
<%Customer c = (Customer) session.getAttribute("customer");

    String username = c.getUsername();
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Orders</title>
    </head>
    <body>
        <h1>Tires R' Us</h1>
        <ul>
            <a href="shipper_homepage.jsp"><li>Your Home Page</li></a>
            <a href="index.html"><li>Home Page</li></a>
            <a href="about.jsp"><li>Help</li></a>
        </ul>

        <table>
            
            <%for(int x = 0; x < c.getOrderList().listSize(); x++) {
                    Order holder = c.getOrderList().getOrder(x);
                    String cid = holder.getCustomerID();
                    String oid = holder.getOrderID();
                    String sid = holder.getShipperID();
                    String status = holder.getStatus();%>
            
            <tr><td>Order ID:</td>
                <td><input type="text" value= <%=oid%> name="oid"/></td>
            </tr>
            <tr><td>Customer ID:</td>
                <td><input type="text" value= <%=cid%> name="cid"/></td>
            </tr>
            <tr><td>Status:</td>
                <td><input type="text" value= <%=status%> name="status"/></td>
            </tr>
            <tr><td>Shipper assigned to order:</td>
                <td><input type="text" value= <%=sid%> name="sid"/></td>
            </tr>
            <tr>
                <td><p>---------------------</p></td>
            </tr>
            <%}%>
        </table>
        <a href="customer_homepage.jsp"><button>Return to Your Home Page</button></a>
    </body>
</html>
