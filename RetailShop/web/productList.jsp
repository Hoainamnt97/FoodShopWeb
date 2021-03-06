<%-- 
    Document   : productList
    Created on : Jan 8, 2018, 12:01:02 PM
    Author     : Admin
--%>

<%@page import="Package.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Package.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>

        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

        <link href="Source/css/agency.css" rel="stylesheet" type="text/css"/>
        <link href="Source/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Source/css/font-awesome.css" rel="stylesheet" type="text/css"/>

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
                    
        <!-- End of Nav -->     
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



        <div class="container">

            <div class="row">

                <div class="col-lg-3">

                    <h1 class="my-4"><a name="product">Food Gallery</a></h1>
                    <div class="list-group">
                        <a href="/RetailShop/ControllerUser?&action=showAllProduct" class="list-group-item">All</a>
                        <a href="/RetailShop/ControllerUser?typeProduct=Rice&action=searchTypeProduct" class="list-group-item">Rice</a>
                        <a href="/RetailShop/ControllerUser?typeProduct=Seafood&action=searchTypeProduct" class="list-group-item">Seafood</a>
                        <a href="/RetailShop/ControllerUser?typeProduct=Fastfood&action=searchTypeProduct" class="list-group-item">Fastfood</a>
                        <a href="/RetailShop/ControllerUser?typeProduct=Pancake&action=searchTypeProduct" class="list-group-item">Pancake</a>
                        <a href="/RetailShop/ControllerUser?typeProduct=Drink&action=searchTypeProduct" class="list-group-item">Drink</a>
                        <a class="list-group-item">
                            <form action="ControllerUser" method="POST">
                                <input type="text" placeholder="Search for Items" name="searchProductName" id="searchProductName">
                                <button type="submit" name="action" value="searchProduct">Search</button>
                            </form>
                        </a>
                    </div>

                </div>

                <div class="col-lg-9">


                    <div class="row">

                        <%
                            Object Test;
                            Test = request.getAttribute("productManagement");

                            if (Test != null) {
                                ArrayList<Product> listOfProduct = (ArrayList<Product>) Test;
                                for (int i = 0; i < listOfProduct.size(); i++) {
                        %>

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="/RetailShop/ControllerUser?viewproducts=<%=listOfProduct.get(i).getIdProduct()%>&action=details"><img class="card-img-top" src="<%=listOfProduct.get(i).getImageProduct()%>" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="/RetailShop/ControllerUser?viewproducts=<%=i + 1%>&action=details"><%=listOfProduct.get(i).getNameProduct()%></a>
                                    </h4>

                                    <!--<p class="card-text"><%=listOfProduct.get(i).getDescriptionProduct()%></p>-->
                                </div>
                                <div class="card-footer">
                                    <h5>$<%=listOfProduct.get(i).getPriceProduct()%></h5>
                                    <!--<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>-->
                                </div>
                            </div>
                        </div>

                        <% }
                            } else {
                                out.println("NULL");
                            }

                        %>


                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.col-lg-9 -->

            </div>
            <!-- /.row -->

        </div>

        <!-- Footer -->
        <footer class="py-5 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
            </div>
            <!-- /.container -->
        </footer>

        <!-- Bootstrap core JavaScript -->

        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
        <script src="Source/js/jquery.js" type="text/javascript"></script>
        <script src="Source/js/bootstrap.bundle.js" type="text/javascript"></script>
        <script src="Source/js/jquery.easing.js" type="text/javascript"></script>
        <script src="Source/js/agency.js" type="text/javascript"></script>
    </body>
</html>
