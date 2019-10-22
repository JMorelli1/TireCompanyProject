<%-- 
    Document   : tireSearch
    Created on : Oct 2, 2019, 9:05:35 PM
    Author     : morel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <%@page import="Business.TireList" %>
        <title>Tire Search Page</title>
    </head>
    <body>
        <%
            TireList fullList;
            TireList filteredList;
            filteredList = (TireList)session.getAttribute("filteredList");
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


<div class="row">
  <div class="column left" >
    <p style="border-bottom: 2px solid #1e1e1e; padding-bottom:10px;">Filters</p>
                <form  action="FilterTireSearchServlet" method="post">
                    <label  class="call" >Tire Brands</label>
                    <div class="lefta">
                    <input type="checkbox" name="TireBrands" value="Firestone" /> Firestone   </br> 
                    <input type="checkbox" name="TireBrands" value="Michelin" /> Michelin     </br>
                    <input type="checkbox" name="TireBrands" value="Provider" /> Provider     </br>
                    <input type="checkbox" name="TireBrands" value="Barum" /> Barum   </br>
                    <input type="checkbox" name="TireBrands" value="Kumho" /> Kumho   </br>
                    <input type="checkbox" name="TireBrands" value="Bridgestone" /> Bridgestone   </br>
                    <br />
                    <label>Price Ranges</label>
                    <input type="checkbox" name="PriceRange" value="Range1" /> $10 - $100 </br> 
                    <input type="checkbox" name="PriceRange" value="Range2" /> $100 - $200 </br> 
                    <input type="checkbox" name="PriceRange" value="Range3" /> $200 - $300 </br> 
                    <br />
                    <label>Vehicle Type</label>
                    <input type="checkbox" name="VehicleType" value="Nissan" /> Nissan </br> 
                    <input type="checkbox" name="VehicleType" value="Infiniti" /> Infiniti </br> 
                    <input type="checkbox" name="VehicleType" value="Toyota" /> Toyota </br> 
                    <input type="checkbox" name="VehicleType" value="Jeep" /> Jeep </br> 
                    <input type="submit" value="Filter" value="Firestone" /> </br> 
                </form>
        </div>
            </div>
  <div class="column right" >
       <p style="border-bottom: 2px solid #1e1e1e; padding-bottom:10px;">.</p>
     <table class="calign" >
                    <tr class="">
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
                        for(int i=0; i<filteredList.listSize(); i++){
                    %>
                    <tr>
                        <td><input type="checkbox" name="<%=filteredList.tireList.get(i).getStockID()%>" value="test"></td>
                        <td><img src="tire2.jpg" alt="tire1" width="200" height="200"><%=filteredList.tireList.get(i).getStockID()%></td>
                        <td><%=filteredList.tireList.get(i).getType()%></td>
                        <td><%=filteredList.tireList.get(i).getSize()%></td>
                        <td><%=filteredList.tireList.get(i).getBrand()%></td>
                        <td><%=filteredList.tireList.get(i).getStock()%></td>
                        <td><%=filteredList.tireList.get(i).getPrice()%></td>
                        <td><%=filteredList.tireList.get(i).getVehicleType()%></td>
                    </tr>
                        <%
                         }
                        %>
                </table>
  </div>
</div>

        </main>
    </body>
</html>
