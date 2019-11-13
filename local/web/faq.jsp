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
          <link rel="stylesheet" href="style.css">s
        <title>FAQ Page</title>
        <style>

  
  .accordion {
  background-color: #eee;
  color: #444;
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
  background-color: #ccc; 
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
                <a href="tireSearch.jsp">Search</a>
            </li> 
            <li>
                <a href="about.jsp">About</a>
            </li>
        </ul>
    </nav>
        <h2>Team1 Tires FAQ</h2>
        <button class="accordion">Shipping/Ordering</button>
        <div class="panel">
            <p>Q: Where do I find my Order number?</p>
            <p>A: Once your order has been processed, log into your account and press the "View Orders" button to find all the information you need about your orders.</p>
            <br/>
            <p>Q: How long does shipping usually take?</p>
            <p>A: Shipping generally takes 2 business days depending on the distribution center we ship from.</p>
            <br/>
            <p>Q: How do I check the status of my order online?</p>
            <p>A: The quickest way to check your order status is to login to your account and click the "View Orders" button to see the status of any of your orders.</p>
            <br/>
            <p>Q: How long are my return labels good for?</p>
            <p>A: A return label is good for 30 days from the date it is issued. If for some reason 30 days is not sufficient, we will re-issue the label or wait until you are ready to ship to issue it.</p>
            <br/>
            <p>Q: When will my order ship?</p>
            <p>A: We make every effort to have your order shipped within 24 hours of processing, however our shippers do not pick up shipments on weekends or holidays. They will pick up shipments the following business day.</p>
            <br/>
            <p>Q: How do I process a return?</p>
            <p>A: You will need to call us at 1-800-555-7473 to process a return.</p>
        </div>
        
        <button class="accordion">Warranty</button>
        <div class="panel">
            <p>Q: Do I get physical certificates when I purchase Certificates for Refund or Replacement?</p>
            <p>A: Our Certificate for refund or replacement is not an actual certificate but rather a virtual certificate which will be a line item on your invoice. We will keep the information on our 
                database and you can request a replacement invoice showing that you purchased the certificates at any time</p>
            <br/>
            <p>Q: How long does the Certificate for Refund or Replacement last?</p>
            <p>A: Tires are covered for 3 years from date of purchase and must have at least 3/32” of tread depth. T1 Tires reserves the right to have the customer ship back the tire for inspection prior to replacement.</p>
            
        </div>
        
        <button class="accordion">Installation</button>
        <div class="panel">
            <p>Q: To what pressure do I inflate my new tires?</p>
            <p>A: As long as we have your vehicle’s information, we will print your tire's recommended air pressure on the invoice. Correct pressure can also be located on the driver’s door jamb. Sometimes the pressure will be different than listed if you are using a tire size that is different than the size recommended by the vehicle manufacturer.</p>
            <br/>
            <p>Q: How much does installation cost?</p>
            <p>A: The installation of your tires and wheels can vary in price based on the installer you decide to use. T1 Tires offer the most competitive pricing at the highest quality industry standard, but you can use any installer you prefer.</p>
            <br/>
            <p>Q: Where can I find installers?</p>
            <p>A: You can have your tires and wheels installed at any T1 Tire store near you. If you do not have a store in your area, we have a list of other installers available at our customer service number: 1-800-555-7473.</p>
        </div>
        <h2>Team1 Tires FAQ</h2>

<button class="accordion">Creating an Account/Logging in</button>
<div class="panel">
<p>If you have an account, simply enter in your username and password and click "Login":</p>
<img src="login.png" alt="login" style="width:500px;height:300px;">
<p>If you don't have an account, click on the "Create Account" button below, enter in all the details it asks you for, submit and you should be good to go :</p>
</div>

<button class="accordion">Searching and Ordering Tires</button>
<div class="panel">
<p>First use the filters on the left side to find what kind of tires your car needs, then press submit:</p>
<img src="TireSearch1.png" alt="Tire 1" style="width:500px;height:300px;">
<p>Once you find the tire you need, click on the text box next to it and then "add tire":</p>
<img src="TireSearch2.png" alt="Tire 2" style="width:500px;height:300px;">
<p>If you have everything you want in the checkout list, click on the "order" button so the site can process your order  ":</p>
<img src="TireSearch3.png" alt="Tire 3" style="width:500px;height:300px;">
</div>

<button class="accordion">Edit Profile</button>
<div class="panel">
  <p>First login into your account and you should be brought to your homepage.</p>
  <img src="homepage1.png" alt="home1" style="width:500px;height:300px;">
  <p>Click on the "View/Edit Profile" button and it'll bring you to your customer profile page. Click on "edit" button and you'' be able to edit any details you'd like.</p>
  <img src="profile.png" alt="home1" style="width:500px;height:300px;">
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

    </body>
</html>
