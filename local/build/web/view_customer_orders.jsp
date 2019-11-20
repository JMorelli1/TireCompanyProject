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
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
    <nav>
        <div class="logo">
            <a class="mm" href="index.jsp"><h4>T1tires</h4></a>
        </div>
        <ul class="nav-links">
            <li><a href="shipper_homepage.jsp">Homepage</a></li> 
            <li><a href="faq.jsp">Help</a></li>
        </ul>
    </nav>
        <table class="vco">
            <tr>
                <th>Order ID:</th>
                <th>Customer ID:</th>
                <th>Status:</th>
                <th>Update order:</th>
            </tr>
            <%
                for(int i = 0; i < orders.listSize(); i++){
            %>
            <tr>
                <td><%=orders.getOrder(i).getOrderID()%></td>
                <td><%=orders.getOrder(i).getCustomerID()%></td>
                <td><%=orders.getOrder(i).getStatus()%></td>
                <td>
                    
                    <form action="UpdateStatus">
            <label>Confirm Order ID: </label>
            <input type="text" name="orderID"/>
            <label>Select New Status:</label>
            <select name = "newStatus" id = "list">
               <option value = "Processing">Processing</option>
               <option value = "In Transit">In Transit</option>
               <option value = "Complete">Complete</option>
             </select>
            
        
                    <div class="vcob">
            <input type="submit" value="Update" />
                    </div>
        </form>
                    
                </td>
            </tr>
            
              

           
            <%}%>
        </table>
        
 
        <a href="shipper_homepage.jsp"><button>Return to Your Home Page</button></a>
    </body>
</html>
