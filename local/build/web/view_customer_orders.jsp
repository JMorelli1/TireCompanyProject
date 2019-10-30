<%-- 
    Document   : view_customer_orders
    Created on : Sep 25, 2019, 2:44:52 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Business.*" %>
<%@page import = "java.sql.*" %>
<%--<%Customer c = (Customer) session.getAttribute("customer");
    String oid = c.getOID();
    String cid = c.getCID();
    String fn = c.getFN();
    String ln = c.getLN();
    String username = c.getUsername();
    String pass = c.getPassword();
    String addr = c.getAddress();
    String phone = c.getPhone();
    String card_info = c.getCreditCardInfo();
    String exp_date = c.getExpireDate();
    String sec_code = c.getSecurityCode();%>--%>

<%
    
Order o = new Order();
DBAccess dba = new DBAccess();
String sql = "Select * from Order";

ResultSet rs = dba.SelectDB(sql);
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
            <%
            while (rs.next()){
                String oid = rs.getString("OrderID");
                String cid = rs.getString("CustomerID");
                String status = rs.getString("status");
                String sid = rs.getString("ShipperID");
            
            %>
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
        <a href="shipper_homepage.jsp"><button>Return to Your Home Page</button></a>
    </body>
</html>
