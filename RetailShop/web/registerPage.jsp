<%-- 
    Document   : loginPage
    Created on : Dec 20, 2017, 10:44:47 PM
    Author     : Admin
--%>

<%@page import="Package.DatabaseService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link href="Source/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript">
            function checkForm(form)
            {
                if (form.username.value === "") {
                    alert("Error: Username cannot be blank!");
                    form.username.focus();
                    return false;
                }
                
                if (form.password.value === "") {
                    alert("Error: Password cannot be blank!");
                    form.username.focus();
                    return false;
                }
                
                if (form.password2.value === "") {
                    alert("Error: Password Confirm cannot be blank!");
                    form.password2.focus();
                    return false;
                }

                if (form.password.value !== form.password2.value) {
                    alert("Error: Password Confirm must match with Password");
                    form.password2.focus();
                    return false;
                }
                
//                alert("You entered a valid password: " + form.password.value);
                return true;
            }

        </script>

    </head>
    <body>
        
        
        <br>
        <div class="container-fluid"><a name="register"></a><a name="login"></a>
            <div class="container">
                <h2 class="text-center" id="title">Register</h2>
                <hr>
                <div class="row">
                    <div class="col-md-12">
                        <form role="form" method="post" action="register" onsubmit="return checkForm(this);">
                            <fieldset>						
                                <p class="text-uppercase pull-center"> SIGN UP.</p>	
                                <div class="form-group">
                                    <input type="text" name="username" id="username" class="form-control input-lg" placeholder="Username">
                                </div>
                                <div class="form-group">
                                    <input
                                        type="email" name="email"
                                        id="email"
                                        class="form-control input-lg"
                                        placeholder="Email"
                                        required
                                        >
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password2" id="password2" class="form-control input-lg" placeholder="Password Confirm">
                                </div>

                                <div>
                                    <input type="submit" class="btn btn-lg btn-primary"   value="Register">

                                </div>
                            </fieldset>
                        </form>
                    </div>


                </div>
            </div>
        </div> 
    </body>
</html>
