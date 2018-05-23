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
        <title>Login Page</title>
        <link href="Source/css/bootstrap.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        
        
        <br>
        <div class="container-fluid"><a name="register"></a><a name="login"></a>
            <div class="container">
                <h2 class="text-center" id="title">Login</h2>
                <hr>
                <div class="row">

                    <div class="col-md-12">
                        <form role="form" action="login" method="post">
                            <fieldset>							
                                <p class="text-uppercase"> Login using your account: </p>	

                                <div class="form-group">
                                    <input type="text" name="username" id="username" class="form-control input-lg" placeholder="Username">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password">
                                </div>
                                <div>
                                    <input type="submit" class="btn btn-md" value="Sign In">
                                </div>

                            </fieldset>
                        </form>	
                    </div>
                </div>
            </div>
        </div> 
    </body>
</html>
