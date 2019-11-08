<%-- 
    Document   : tireSearch
    Created on : Oct 2, 2019, 9:05:35 PM
    Author     : morel
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <%@page import="Business.*" %>
        <%@page import="java.text.NumberFormat" %>
        <title>Tire Search Page</title>
    </head>
    <body>
        <%
            Customer customer = (Customer)session.getAttribute("customer");
            TireList fullList;
            TireList filteredList;
            filteredList = (TireList)session.getAttribute("filteredList");
            NumberFormat formater = new DecimalFormat("#0.00");
            if(filteredList == null){
                filteredList = new TireList();
                fullList = new TireList();
                filteredList = filteredList.generateTireList();
                fullList=filteredList;
                session.setAttribute("tireSearchList", fullList);
            }
            %>
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


<div class="row" >
    <p style="border-bottom: 2px solid #1e1e1e; padding-bottom:5px; padding-left: 1%;">Filters Active:</p>
  <div class="column left" >
                <form  action="FilterTireSearchServlet" method="post">
                    <label  class="call" >Tire Brands</label>
                    <div class="lefta">
                    <input type="checkbox" name="TireBrands" value="Barum" /> Barum   </br>
                    <input type="checkbox" name="TireBrands" value="Bridgestone" /> Bridgestone   </br>
                    <input type="checkbox" name="TireBrands" value="Corsa" /> Corsa   </br>
                    <input type="checkbox" name="TireBrands" value="Firestone" /> Firestone   </br> 
                    <input type="checkbox" name="TireBrands" value="Goodyear" /> Goodyear   </br>
                    <input type="checkbox" name="TireBrands" value="Kumho" /> Kumho   </br>
                    <input type="checkbox" name="TireBrands" value="Michelin" /> Michelin     </br>
                    <input type="checkbox" name="TireBrands" value="Provider" /> Provider     </br>
                    <input type="checkbox" name="TireBrands" value="Road Hugger" /> Road Hugger   </br>
                    <br />
                    <label class="call">Price Ranges</label>
                    <input type="checkbox" name="PriceRange" value="Range1" /> $10 - $100 </br> 
                    <input type="checkbox" name="PriceRange" value="Range2" /> $100 - $200 </br> 
                    <input type="checkbox" name="PriceRange" value="Range3" /> $200 - $300 </br>
                    <br />
                    <label class="call">Vehicle Type</label>
                    <input type="checkbox" name="VehicleType" value="Ford" /> Ford </br> 
                    <input type="checkbox" name="VehicleType" value="Honda" /> Honda </br> 
                    <input type="checkbox" name="VehicleType" value="Infiniti" /> Infiniti </br> 
                    <input type="checkbox" name="VehicleType" value="Jeep" /> Jeep </br> 
                    <input type="checkbox" name="VehicleType" value="Lexus" /> Lexus </br> 
                    <input type="checkbox" name="VehicleType" value="Mazda" /> Mazda </br> 
                    <input type="checkbox" name="VehicleType" value="Mitsubishi" /> Mitsubishi </br> 
                    <input type="checkbox" name="VehicleType" value="Nissan" /> Nissan </br> 
                    <input type="checkbox" name="VehicleType" value="Toyota" /> Toyota </br> 
                    <input type="submit" /> </br> 
                </form>
        </div>
            </div>
  <div class="column right" >
       <form action="AddTiresServlet" method="post">
     <table class="calign" >
                    <tr class="">
                        <th></th>
                        <th>Purchase</th>
                        <th>Quantity</th>
                        <th>Tire ID</th>
                        <th>Tire Type</th>
                        <th>Size of Tire</th>
                        <th>Brand</th>
                        <th>Stock Amount</th>
                        <th>Price</th>
                        <th>Vehicle Type</th>
                    </tr>
                    <%
                        for(int i=0; i<filteredList.listSize(); i++){
                    %>
                    <tr>
                        <td><img src="photos/tire2.jpg" alt="tire1" width="200" height="200"></td>
                        <td><input type="checkbox" value="<%=filteredList.tireList.get(i).getStockID()%>" name="selectedTires"></td>
                        <td><input type="number" name="quantity" min="1" max="100" value="1"></td>
                        <td><%=filteredList.tireList.get(i).getStockID()%></td>
                        <td><%=filteredList.tireList.get(i).getType()%></td>
                        <td><%=filteredList.tireList.get(i).getSize()%></td>
                        <td><%=filteredList.tireList.get(i).getBrand()%></td>
                        <td><%=filteredList.tireList.get(i).getStock()%></td>
                        <td><%=formater.format(Double.parseDouble(filteredList.tireList.get(i).getPrice()))%></td>
                        <td><%=filteredList.tireList.get(i).getVehicleType()%></td>
                    </tr>
                        <%
                         }
                        %>
                        <input type="submit" value="Add Tires" />
                </table>
        </form>
  </div>
</div>

        </main>
    </body>
</html>
