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

                        <div class="flex-sb-m w-full p-b-30">
                            <div class="contact100-form-checkbox">
                                <input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
                                <label class="label-checkbox100" for="ckb1">
                                    Remember me
                                </label>
                            </div>

                            <div>
                                <a href="#" class="txt1">
                                    Forgot Password?
                                </a>
                            </div>
                        </div>

                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn">
                                Login
                            </button>
                        </div>

                </div>
                </form>
                <div class="container-login100-form-btn">
                    <a href="admin_login.jsp"><button class="login100-form-btn">
                            Login as Admin
                        </button></a>
                </div>
                <div class="container-login100-form-btn">
                    <a href="shipper_login.jsp"><button class="login100-form-btn">
                            Login as Shipper
                        </button></a>
                </div>
                    
                    <a href="create_account.jsp"><button>Create Account</button></a>

            </div>
        </div>
    </div>
</div>
</body>
</html>