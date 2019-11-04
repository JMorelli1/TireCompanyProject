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
    c.findOrders();
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Orders</title>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$( function() {
		$( "#accordion" ).accordion();
		} );
	</script>
    </head>
    <body>
        <h1>Tires R' Us</h1>
        <ul>
            <a href="shipper_homepage.jsp"><li>Your Home Page</li></a>
            <a href="index.html"><li>Home Page</li></a>
            <a href="about.jsp"><li>Help</li></a>
        </ul>

        <div id="accordion">
            <%
                for(int i = 0; i<c.orderList.listSize(); i++){
            %>
            <h1>Order ID: <%=c.orderList.getOrder(i).getOrderID()%>    Order Status: <%=c.orderList.getOrder(i).getStatus()%></h1>
            <div>
                <% 
                    Order tempOrder = c.orderList.getOrder(i);
                    TireList t1;
                    %>
                    <table class="calign" >
                    <tr class="">
                        <th>Quantity Purchased</th>
                        <th>Tire ID</th>
                        <th>Tire Type</th>
                        <th>Size of Tire</th>
                        <th>Brand</th>
                        <th>Stock Amount</th>
                        <th>Price</th>
                        <th>Vehicle Type</th>
                    </tr>
                    <%
                            t1 = new TireList();
                            t1 = tempOrder.findOrderedItems();
                        for(int x=0; x<t1.tireList.size(); x++){
                    %>
                    <tr>
                        <td><%=t1.tireList.get(x).getQuantity()%></td>
                        <td><img src="tire2.jpg" alt="tire1" width="200" height="200"></td>
                        <td><%=t1.tireList.get(x).getStockID()%></td>
                        <td><%=t1.tireList.get(x).getType()%></td>
                        <td><%=t1.tireList.get(x).getSize()%></td>
                        <td><%=t1.tireList.get(x).getBrand()%></td>
                        <td><%=t1.tireList.get(x).getStock()%></td>
                        <td><%=t1.tireList.get(x).getPrice()%></td>
                        <td><%=t1.tireList.get(x).getVehicleType()%></td>
                    </tr>
                        <%
                         }
                        %>
                </table>
            </div>
            <%
                }
            %>
        </div>
        <a href="customer_homepage.jsp"><button>Return to Your Home Page</button></a>
    </body>
</html>
