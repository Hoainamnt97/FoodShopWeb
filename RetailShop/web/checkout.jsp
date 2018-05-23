<%-- 
    Document   : checkout
    Created on : Dec 18, 2017, 10:27:32 PM
    Author     : Cpt_Snag
--%>

<%@page import="Package.User"%>
<%@page import="Package.SessionService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Package.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Page</title>
        
        
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

        <link href="Source/css/agency.css" rel="stylesheet" type="text/css"/>
        <link href="Source/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Source/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <style>
            a.logo{
                text-shadow: 2px 0 black, -2px 0 black, 0 2px black, 0 -2px black, 1px 1px black, -1px -1px black, -1px 1px black, 1px -1px black;
            }
            .logoutButton{
                border-radius: 6px;
            }
        </style>
    </head>
    <body id="page-top">
         <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger logo" href="index.jsp">Nam Food Shop</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fa fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ml-auto">
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#page-top">Main Page</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="cartPage.jsp">Cart</a>
                        </li>
                        <%
                            if (session.getAttribute("admin") != null) {
                        %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="AdminPage.jsp" name="action" value="AdminPage">Admin</a>
                        </li>
                        <%
                            }
                        %>

                        <%
                            if (session.getAttribute("admin") == null && session.getAttribute("user") == null) {
                        %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="loginPage.jsp">Register</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="loginPage.jsp">Login</a>
                        </li>

                        <%
                        } else {
                        %>
                        <%
                            ArrayList<User> currentUser = (ArrayList<User>) session.getAttribute("currentUser");
                        %>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#page-top">Welcome <%=currentUser.get(0).getEmailUser()%></a>
                        </li>

                        <li class="nav-item">
                            <form role="form" action="logout" method="post" class="nav-link js-scroll-trigger">
                                <input type="submit" value="Logout" class="logoutButton">
                            </form>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Header -->
        <header class="masthead">
            <div class="container" style="height: 100vh">
                <div class="intro-text">
                    <div class="intro-lead-in">Welcome To Nam's Food Shop :) !</div>
                    <div class="intro-heading text-uppercase">It's Nice To Meet You</div>
                    <a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="#product">Tell Me More</a>
                </div>
            </div>
        </header>
                        
        <h1>Checkout: </h1>
        <%
            SessionService ss = new SessionService(request.getSession());
            ArrayList<Product> list = ss.getCart();
            double total = 0;
            if (list != null)
            {
        %>
        <form action="ControllerUser" method="POST">
            <table border="1" width="80%">
                <tr>
                    <th>Image</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
                <%
                    for (Product p : list)
                    {
                        total += p.getPriceProduct() * p.getQuantityProduct();
                %>
                <tr align="center">
                    <td><img src="<%= p.getImageProduct()%>" alt="Smiley face" height="42" width="42"></td>
                    <td><%= p.getNameProduct()%></td>
                    <td><%= p.getQuantityProduct()%></td>
                    <td><%= p.getPriceProduct()%></td>
                </tr>
                <%
                    }
                %>
                <tr align="center">
                    <td></td>
                    <td></td>
                    <td><b>Total price</b></td>
                    <td><b><%= total%></b></td>
                </tr>
            </table>
            <hr>
            <b>Bank-Account:</b> <input type="text" name="banking" size="30%"><br>
            <b>Delivery-Addres </b><input type="text" name="address" size="50%"><br>
            <b>Delivery-Phonenumber </b><input type="text" name="phone" size="50%"><br>
            <button type="submit" name="action" value="checkout">Make an order!</button>
        </form>
        <%
            }
        %>
    </body>
</html>
