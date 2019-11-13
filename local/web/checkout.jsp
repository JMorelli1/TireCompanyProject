<%-- 
    Document   : checkout
    Created on : Oct 21, 2019, 11:13:09 AM
    Author     : morel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" />
        <title>Checkout Page</title>
    </head>
    <%
            Customer customer = (Customer)session.getAttribute("customer");
            TireList checkoutList;
            checkoutList = (TireList)session.getAttribute("checkoutList");
            
            if(checkoutList == null){
                checkoutList = new TireList();
            }
            checkoutList.calculateSubTotal();
            if(checkoutList.countQuantity() <= 10){
                checkoutList.calculateShipping();
            }
            checkoutList.calculateTotal();
            %>
    <body>
    <nav>
        <div class="logo">
            <a class="mm" href="index.jsp"><h4>T1tires</h4></a>
        </div>
        <ul class="nav-links">
            <%
                if(customer != null){
            %>
            <li><a href="customer_homepage.jsp">Homepage</a></li>
            <%}else{%>
            <li><a href="login.jsp">Login</a></li> 
            <%}%>
            <li><a href="tireSearch.jsp">Search</a></li> 
            <li><a href="about.jsp">About</a></li>
            <li><a href="faq.jsp">FAQ</a></li>
            <li><a class="photonav" href="checkout.jsp"><img src="photos/cart.png"></a></li>     
        </ul>
    </nav>
        <main>
                <form action="SubmitOrderServlet" method="post">
                <table class="calign">
                    <tr>
                        <th></th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Tire Type</th>
                        <th>Size of Tire</th>
                        <th>Brand</th>
                        <th>Vehicle Type</th>
                    </tr>
                    <%
                        for(int i=0; i<checkoutList.listSize(); i++){
                    %>
                    <tr>
                        <td><img src="photos/tire2.jpg" alt="tire1" width="200" height="200"></td>
                        <td><%=checkoutList.tireList.get(i).getQuantity()%></td>
                        <td><%=checkoutList.tireList.get(i).getPrice()%></td>
                        <td><%=checkoutList.tireList.get(i).getType()%></td>
                        <td><%=checkoutList.tireList.get(i).getSize()%></td>
                        <td><%=checkoutList.tireList.get(i).getBrand()%></td>
                        <td><%=checkoutList.tireList.get(i).getVehicleType()%></td>
                    </tr>
                        <%
                         }  
                        %>
                </table>
                        <input type="submit" value="Order" /> 
            </form>
                <table>
                    <tr>
                        <td>Subtotal: </td>
                        <td><%=checkoutList.getSubTotal()%></td>
                    </tr>
                    <tr>
                        <td>Shipping Cost: </td>
                        <td><%=checkoutList.getShippingTotal()%></td>
                    </tr>
                    <tr>
                        <td>Total: </td>
                        <td><%=checkoutList.getTotal()%></td>
                    </tr>
                </table>
        </main>
    </body>
</html>
