<%-- 
    Document   : about.jsp
    Created on : Sep 25, 2019, 2:37:21 PM
    Author     : ebadger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <title>About T1tires</title>
        <%@page import="Business.*" %>
    </head>
    <% Customer customer = (Customer)session.getAttribute("customer");
       Admin admin = (Admin)session.getAttribute("admin");
       Shipper shipper = (Shipper)session.getAttribute("shipper");
    %>
    <body>
    <nav>
        <div class="logo">
            <a class="mm" href="index.html"><h4>T1tires</h4></a>
        </div>
        <ul class="nav-links">

            <li>
                <a href="index.html">T1 Tire</a>
            </li>
            <%if(customer != null){%>
            <li><a href="customer_homepage.jsp">Homepage</a></li>
            <%}if(admin != null){%>
            <li><a href="admin_homepage.jsp">Homepage</a></li>
            <%}if(shipper != null){%>
            <li><a href="shipper_homepage.jsp">Homepage</a></li>
            <%}else{%>
            <li><a href="login.jsp">Login</a></li> 
            <%}%>
              <li>
                <a href="tireSearch.jsp">Search</a>
            </li> 
            <li>
                <a href="faq.jsp">FAQ</a>
            </li>

        </ul>
    </nav>
        <div class="aus">
        <img src="photos/aus.png" width="600" height="600">
             </div>
        
      <div class="aus">
        <p>
            Our Story: How We Started 
        </p>
 
        <p>
            Team1 Tires first opened its doors in 1960, when Bruce T. Halle 
            rented an old plumbing supply building on Stadium Boulevard in Atlanta
            , Georgia. We cleaned out the building, built countertops,
            repainted the sign outside, and displayed his initial six-tire 
            inventory. As the store’s only employee upon its opening, We 
            all served as the tire technicians, cleaning crew, salesman, and 
            accountant. Because he didn’t have an air compressor, We would
            even haul a portable air tank to and from a nearby gas station so 
            that he could inflate the tires he sold. Over time, we nurtured
            that first Team1 Tire store through hard work and a governing 
            philosophy that now serves as Team1 Tire’s founding principles: 
            treat people with respect and fairness, care for those in need, 
            always do what is right, work hard, be responsible, and have fun.
            By the end of the decade, our company grew to six stores and 
            established a strong reputation for customer satisfaction.
        </p></div>
        
                
      </br>
        </br>        
        </br>
        </br>
        
        
        
        <div class="footer">
  <p>© 2019 Team1 Tires, Inc</p> 
  
     <ul class="footer-links">
              <li><a href="about.jsp">About</a></li>
              <li><a href="#">Terms</a></li>
              <li><a href="#">Pricing</a></li>
              <li><a href="#/">Contact</a></li>
              <li><a href="#">Careers</a></li>
            </ul>
          </div>


        
            
</div>
        

        
    </body>
</html>
