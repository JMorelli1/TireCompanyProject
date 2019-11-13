<%-- 
    Document   : customer_homepage
    Created on : Sep 25, 2019, 2:43:38 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "Business.*" %>

<%Customer customer = (Customer) session.getAttribute("customer");
    String username = customer.getUsername();
    String orderStatus = "";
    String URL = request.getRequestURL().toString();
    String logoutURL = URL.substring(0, URL.length() - 21) + "LogoutServlet";
    orderStatus = (String)session.getAttribute("orderStatus");
%>

<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="style.css">
        <title>Your Home Page</title>
    </head>
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
            <li><a href="<%=logoutURL%>">Logout</a></li>
            <li><a class="photonav" href="checkout.jsp"><img src="photos/cart.png"></a></li>   
        </ul>
    </nav>
            <h1 class="h1asl">Welcome, <%=username%>!</h1>
            
            <div class="chp">
        <a href="customer_profile.jsp"><button>View/Edit Profile</button></a>
<!--        <a href="add_customer_order.jsp"><button>Place Order</button></a>-->
        <%--<a href="browse_tire_criteria.jsp"><button>Browse Tires</button></a> --%>
        <a href="tireSearch.jsp"><button>Browse Tires</button></a>
        <a href="view_orders.jsp"><button>View Orders</button></a>
            </div>
        
        
        
        <% if(orderStatus != null && orderStatus.equals("completed")){  %>
        <p>Your order has been completed! Thank you for choosing T1Tires!</p>
        <%}%>
    </body>
</html>
