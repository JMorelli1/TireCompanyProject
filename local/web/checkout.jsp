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
        <title>JSP Page</title>
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
        <h1>Checkout Page</h1>
        <nav>
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="tireSearch.jsp">Tire Search</a></li>
            </ul>
        </nav>
        <main>
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
        </main>
    </body>
</html>
