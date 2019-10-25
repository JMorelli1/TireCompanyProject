<%-- 
    Document   : customer_homepage
    Created on : Sep 25, 2019, 2:43:38 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "Business.*" %>

<%Customer c = (Customer) session.getAttribute("customer");
    String oid = c.getOID();
    String cid = c.getCID();
    String fn = c.getFN();
    String ln = c.getLN();
    String username = c.getUsername();
    String pass = c.getPassword();
    String addr = c.getAddress();
    String phone = c.getPhone();
    String card_info = c.getCreditCardInfo();
    String exp_date = c.getExpireDate();
    String sec_code = c.getSecurityCode();%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Home Page</title>
    </head>
    <body>
        <h1>Tires R' Us</h1>
        <ul>
            <a href="index.html"><li>Home Page</li></a>
            <a href="about.jsp"><li>Help</li></a>
        </ul>
        <h1>Welcome, <%=username%>!</h1>
        <a href="customer_profile.jsp"><button>View/Edit Profile</button></a>
        <a href="add_customer_order.jsp"><button>Place Order</button></a>
        <%--<a href="browse_tire_criteria.jsp"><button>Browse Tires</button></a> --%>
        <a href="tireSearch.jsp"><button>Browse Tires</button></a>
        <a href="view_orders.jsp"><button>View Orders</button></a>


    </body>
</html>
