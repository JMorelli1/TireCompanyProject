<%-- 
    Document   : faq
    Created on : Oct 14, 2019, 9:58:49 AM
    Author     : miguel
--%>

<%-- 
    Document   : faq
    Edited on : Nov 4, 2019, 11:04:40 AM
    Author     : Jhalp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">   
          <link rel="stylesheet" href="style.css">
        <title>FAQ Page</title>
        <style>

  
  .accordion {
  background-color: #004E98;
  color: #EBEBEB;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
  transition: 0.4s;
}

.active, .accordion:hover {
  background-color: #FF6700; 
}

.panel {
  padding: 0 18px;
  display: none;
  background-color: white;
  overflow: hidden;
}
</style>
    </head>
    <body>
           <nav>
        <div class="logo">
            <a class="mm" href="index.html"<h4>T1tires</h4></a>
        </div>
        <ul class="nav-links">
            <li>
                <a href="login.jsp">Login</a>
            </li> 
              <li>
                <a href="tireSearch.jsp">Search</a>
            </li> 
            <li>
                <a href="about.jsp">About</a>
            </li>
            <li>
                <a href="faq.jsp">FAQ</a>
            </li>
        </ul>
    </nav>
        </br>
        
        <h2> Team1 Tires FAQ</h2>
        
        </br>
        
                    

<button class="accordion">Creating an Account/Logging in</button>
<div class="panel">
<p>If you have an account, simply enter in your username and password and click "Login":</p>
<img src="photos/login.png" alt="login" style="width:500px;height:300px;">
<p>If you don't have an account, click on the "Create Account" button below, enter in all the details it asks you for, submit and you should be good to go :</p>
<img src="photos/createaccount.png" alt="create" style="width:500px;height:300px;">
</div>

<button class="accordion">Searching and Ordering Tires</button>
<div class="panel">
<p>First use the filters on the left side to find what kind of tires your car needs, then press submit:</p>
<img src="photos/TireSearch1.png" alt="Tire 1" style="width:500px;height:300px;">
<p>Once you find the tire you need, click on the text box next to it and then "add tire":</p>
<img src="photos/TireSearch2.png" alt="Tire 2" style="width:500px;height:300px;">
<p>If you have everything you want in the checkout list, click on the "order" button so the site can process your order  ":</p>
<img src="photos/TireSearch3.png" alt="Tire 3" style="width:500px;height:300px;">
</div>

<button class="accordion">Edit Profile</button>
<div class="panel">
  <p>First login into your account and you should be brought to your homepage.</p>
  <img src="photos/homepage1.png" alt="home1" style="width:500px;height:300px;">
  <p>Click on the "View/Edit Profile" button and it'll bring you to your customer profile page. Click on "edit" button and you'' be able to edit any details you'd like.</p>
  <img src="photos/profile.png" alt="home1" style="width:500px;height:300px;">
  <p>Once you made all the changes you want, click done and your account will now reflect the changes you made to it.</p>
  
</div>

<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
}
</script>


<%-- 
    easiest way to bring the footer all the way down to the page -miguel
--%>

</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>

    </body>
    
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
</html>
