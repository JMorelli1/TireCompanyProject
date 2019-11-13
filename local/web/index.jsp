<!DOCTYPE html>
<html>  
    <head>
        <title>Team1Tires</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css">
        <%@page import="Business.*" %>
    </head>
    <% Customer customer = (Customer)session.getAttribute("customer");
       Admin admin = (Admin)session.getAttribute("admin");
       Shipper shipper = (Shipper)session.getAttribute("shipper");
       String URL = request.getRequestURL().toString();
       String logoutURL = URL.substring(0, URL.length() - 9) + "LogoutServlet";
    %>
    <body>
    <nav>
        <div class="logo">
            <a class="mm" href="index.html"><h4>T1tires</h4></a>
        </div>
        <ul class="nav-links">
            <%if(customer != null){%>
            <li><a href="customer_homepage.jsp">Homepage</a></li>
            <li><a href="tireSearch.jsp">Search</a></li> 
            <li><a href="about.jsp">About</a></li>
            <li><a href="faq.jsp">FAQ</a></li>
            <li><a href="<%=logoutURL%>">Logout</a></li>
            <%}else if(admin != null){%>
            <li><a href="admin_homepage.jsp">Homepage</a></li>
            <li><a href="tireSearch.jsp">Search</a></li> 
            <li><a href="about.jsp">About</a></li>
            <li><a href="faq.jsp">FAQ</a></li>    
            <li><a href="<%=logoutURL%>">Logout</a></li>
            <%}else if(shipper != null){%>
            <li><a href="shipper_homepage.jsp">Homepage</a></li>
            <li><a href="tireSearch.jsp">Search</a></li> 
            <li><a href="about.jsp">About</a></li>
            <li><a href="faq.jsp">FAQ</a></li>
            <li><a href="<%=logoutURL%>">Logout</a></li>
            <%}else{%>
            <li><a href="login.jsp">Login</a></li>
            <li><a href="tireSearch.jsp">Search</a></li> 
            <li><a href="about.jsp">About</a></li>
            <li><a href="faq.jsp">FAQ</a></li>
            <%}%>
        </ul>
    </nav>
            <img src="https://s3.amazonaws.com/simpletire/homepage_hero_region_images/high_res/236.jpg" style="width:100%" height="580" alt="picture header found on website">>
            
            <section class="section2">
                <p>
               300+ BRANDS
                </p>
                    <img src="photos/tires logo.png" class="logos4tires">
                    <p>
                       <button onclick="location.href='tireSearch.jsp'; " class="shopt" type="button">SHOP TIRES!</button>  
                    </p>
                  
            </section>
            
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


        
            
    </body>
</html>
