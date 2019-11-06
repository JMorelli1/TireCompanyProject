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
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!--	<script>
		$( function() {
		$( "#accordion" ).accordion();
		} );
	</script>-->
        <style>

  
  .accordion {
  background-color: #004E98;
  color: #EBEBEB;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
  transition: 0.4s;
}

.active, .accordion:hover {
  background-color: #FF6700; 
}

.panel {
  padding: 0 18px;
  display: none;
  background-color: white;
  overflow: hidden;
}
</style>
    </head>
    <body>
        <h1>Tires R' Us</h1>
        <ul>
            <a href="customer_homepage.jsp"><li>Your Home Page</li></a>
            <a href="index.html"><li>Home Page</li></a>
            <a href="about.jsp"><li>Help</li></a>
        </ul>

<!--        <div class="accordion">-->
            <%
                for(int i = 0; i<c.orderList.listSize(); i++){
            %>
            <button class="accordion">Order ID: <%=c.orderList.getOrder(i).getOrderID()%>    Order Status: <%=c.orderList.getOrder(i).getStatus()%></button>
            <div class="panel">
                <% 
                    Order tempOrder = c.orderList.getOrder(i);
                    TireList t1;
                    %>
                    <table >
                    <tr>
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
                        <td><img src="photos/tire2.jpg" alt="tire1" width="200" height="200"></td>
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
            <script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
}
</script>
        <a href="customer_homepage.jsp"><button>Return to Your Home Page</button></a>
    </body>
</html>
