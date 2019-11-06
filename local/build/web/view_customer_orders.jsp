<%-- 
    Document   : view_customer_orders
    Created on : Sep 25, 2019, 2:44:52 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Business.*" %>
<%@page import = "java.sql.*" %>

<%
Order order = new Order();
OrderList orders = new OrderList();
orders = order.findOrders();
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
            <tr>
                <th>Order ID:</th>
                <th>Customer ID:</th>
                <th>Status:</th>
            </tr>
            <%
                for(int i = 0; i < orders.listSize(); i++){
            %>
            <tr>
                <td><%=orders.getOrder(i).getOrderID()%></td>
                <td><%=orders.getOrder(i).getCustomerID()%></td>
                <td><%=orders.getOrder(i).getStatus()%></td>
            </tr>
            <%}%>
        </table>
        <form action="UpdateStatus">
            <label>Update Status of Order</label>
            <label>Enter Order ID: </label>
            <input type="text" name="orderID"/>
            <label>Select New Status:</label>
            <select name = "newStatus" id = "list">
               <option value = "Processing">Processing</option>
               <option value = "In Transit">In Transit</option>
               <option value = "Complete">Complete</option>
             </select>
            <input type="submit" value="Update" />
        </form>
        <a href="shipper_homepage.jsp"><button>Return to Your Home Page</button></a>
    </body>
</html>
