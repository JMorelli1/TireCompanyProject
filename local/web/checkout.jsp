<%-- 
    Document   : checkout
    Created on : Oct 21, 2019, 11:13:09 AM
    Author     : morel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>\
<%@page import="Business.TireList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" />
        <title>Checkout Page</title>
    </head>
    <body>
        <%
            TireList checkoutList;
            checkoutList = (TireList)session.getAttribute("checkoutList");
            if(checkoutList == null){
                checkoutList = new TireList();
            }
            %>
                      <nav>
        <div class="logo">
            <h4>T1tires</h4>
        </div>
        <ul class="nav-links">
             <li>
                <a href="index.html">Home</a>
            </li> 

            <li>
                <a href="login.jsp">Login</a>
            </li> 
            <li>
                <a href="#">About</a>
            </li>
            <li>
                <a href="faq.jsp">FAQ</a>
            </li>
        </ul>
            

    </nav>
        <main>
                <form action="SubmitOrderServlet" method="post">
                <table class="calign">
                    <tr>
                        <th>Purchase</th>
                        <th>Tire ID</th>
                        <th>Tire Type</th>
                        <th>Size of Tire</th>
                        <th>Brand</th>
                        <th>Stock Amount</th>
                        <th>Price</th>
                        <th>Vehicle Type</th>
                    </tr>
                    <%
                        for(int i=0; i<checkoutList.listSize(); i++){
                    %>
                    <tr>
                        <td><img src="photos/tire2.jpg" alt="tire1" width="200" height="200"></td>
                        <td><%=checkoutList.tireList.get(i).getStockID()%></td>
                        <td><%=checkoutList.tireList.get(i).getType()%></td>
                        <td><%=checkoutList.tireList.get(i).getSize()%></td>
                        <td><%=checkoutList.tireList.get(i).getBrand()%></td>
                        <td><%=checkoutList.tireList.get(i).getStock()%></td>
                        <td><%=checkoutList.tireList.get(i).getPrice()%></td>
                        <td><%=checkoutList.tireList.get(i).getVehicleType()%></td>
                    </tr>
                        <%
                         }
                         session.setAttribute("checkoutList", checkoutList);
                        %>
                </table>
                        <input type="submit" value="Order" /> 
            </form>
        </main>
    </body>
</html>
