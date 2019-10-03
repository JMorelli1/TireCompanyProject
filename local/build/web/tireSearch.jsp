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
        <link rel="stylesheet" href="stylesheet.css"/>
        <%@page import="Business.TireList" %>
        <title>Tire Search Page</title>
    </head>
    <body>
        <%
            TireList list = new TireList();
            list = list.generateTireList();
            
            %>
        <div id = "interiorbox">
        <h1>Tire Search Page</h1>
        <nav>
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="tireSearch.jsp">Tire Search</a></li>
            </ul>
        </nav>
        
            <div class="wrapper">
                <table>
            <tr>
                <th>Tire ID</th>
                <th>Tire Type</th>
                <th>Size of Tire</th>
                <th>Brand</th>
                <th>Stock Amount</th>
                <th>Price</th>
                <th>Vehicle Type</th>
            </tr>
		<%
                for(int i=0; i<list.listSize(); i++){
                    %>
            <tr>
                <td><%=list.tireList.get(i).getStockID()%></td>
                <td><%=list.tireList.get(i).getType()%></td>
                <td><%=list.tireList.get(i).getSize()%></td>
                <td><%=list.tireList.get(i).getBrand()%></td>
                <td><%=list.tireList.get(i).getStock()%></td>
                <td><%=list.tireList.get(i).getPrice()%></td>
                <td><%=list.tireList.get(i).getVehicleType()%></td>
            </tr>
                    <%
                     }
                    %>
                </table>
                <div class="lowerpad"></div>
            </div>
        </div>
    </body>
</html>
