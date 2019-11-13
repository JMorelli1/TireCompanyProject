<%-- 
    Document   : faq
    Author     : miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>T1Tires</title>
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
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-form-title" style="background-image: url(tires.jpg);">
                        <span class="login100-form-title-1">
                            Sign Into T1Tires
                        </span>
                    </div>

                    <form class="login100-form validate-form" action="LoginServlet" method="post">
                        <div class="wrap-input100 validate-input m-b-26" data-validate="Username is required">
                            <span class="label-input100">Username</span>
                            <input class="input100" type="text" name="username" placeholder="Enter username">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-18" data-validate = "Password is required">
                            <span class="label-input100">Password</span>
                            <input class="input100" type="password" name="pass" placeholder="Enter password">
                            <span class="focus-input100"></span>
                        </div>

                        

                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn">
                                Login
                            </button>
                        </div>

                </div>
                </form>
                
                    <br />
                    <br />
                    <br />
                    
                
                    
                    <a href="createAccount.jsp"><button>Create Account</button></a>

            </div>
        </div>
    </div>
</div>


      
        
        
        
 
        
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
