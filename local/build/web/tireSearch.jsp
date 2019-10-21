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
        <link rel="stylesheet" type="text/css" href="stylesheet.css"/>
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
        <h1>Tire Search Page</h1>
        <nav>
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="tireSearch.jsp">Tire Search</a></li>
            </ul>
        </nav>
        <main>
            <div action="FilteTireSearchServlet" id="largecolumn">
                <p style="border-bottom: 2px solid #1e1e1e; padding-bottom:10px;">Filters</p>
                <form method="post">
                    <label>Tire Brands</label>
                    <input type="checkbox" name="TireBrands" value="Firestone" /> Firestone 
                    <input type="checkbox" name="TireBrands" value="Michelin" /> Michelin
                    <input type="checkbox" name="TireBrands" value="Provider" /> Provider
                    <input type="checkbox" name="TireBrands" value="Barum" /> Barum
                    <input type="checkbox" name="TireBrands" value="Kumho" /> Kumho
                    <input type="checkbox" name="TireBrands" value="Bridgestone" /> Bridgestone
                    <br />
                    <label>Price Ranges</label>
                    <input type="checkbox" name="PriceRange" value="Range1" /> $10 - $100
                    <input type="checkbox" name="PriceRange" value="Range2" /> $100 - $200
                    <input type="checkbox" name="PriceRange" value="Range3" /> $200 - $300
                    <br />
                    <label>Vehicle Type</label>
                    <input type="checkbox" name="VehicleType" value="Nissan" /> Nissan
                    <input type="checkbox" name="VehicleType" value="Infiniti" /> Infiniti
                    <input type="checkbox" name="VehicleType" value="Toyota" /> Toyota
                    <input type="checkbox" name="VehicleType" value="Jeep" /> Jeep
                    <input type="submit" value="Filter" />
                </form>
            </div>
            <div id="smallcolumn">
                <form action="AddTiresServlet" method="post">
                <table action="AddTiresServlet">
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
                        for(int i=0; i<filteredList.listSize(); i++){
                    %>
                    <tr>
                        <td><input type="checkbox" value="test" name="selectedTires"></td>
                        <td><%=filteredList.tireList.get(i).getStockID()%></td>
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
                        <input type="submit" value="Add Tires" /> 
                </form>
                <div class="lowerpad"></div>
            </div>
        </main>
    </body>
</html>
