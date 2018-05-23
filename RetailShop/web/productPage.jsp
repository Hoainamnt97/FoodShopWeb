<%@page import="Package.Comment"%>
<%@page import="Package.User"%>
<%@page import="Package.DatabaseService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Package.Product"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Detail Product</title>


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

        <div class="container-fluid"><a name="product"></a>
            <div class="row content">

                <%
//                    DatabaseService dao = new DatabaseService();
                    ArrayList<Product> listOfProduct = (ArrayList<Product>) session.getAttribute("product");
                %>

                <hr>
                <div class="col-sm-9">


                    <h2><%=listOfProduct.get(0).getNameProduct()%></h2>
                    <!--<h5><button type="submit" class="label label-danger" >dislike</button>  <button type="submit"   class="label label-primary" >Like</button></h5><br>-->
                    <p><%=listOfProduct.get(0).getDescriptionProduct()%></p>
                    <br>
                    <br>
                    <p><i>Quantity Left: <%=listOfProduct.get(0).getQuantityProduct()%></i></p>


                </div>
                <div class="col-sm-3 sidenav">
                    <div class="panel panel-primary">
                        <div class="panel-heading"><%=listOfProduct.get(0).getNameProduct()%> </div>
                        <div class="panel-body"><img src="<%=listOfProduct.get(0).getImageProduct()%>" class="img-responsive" style="width:100%" alt="Image"></div>
                        <div class="panel-footer"><b>$<%=listOfProduct.get(0).getPriceProduct()%> </b>

                            <%
                                if (session.getAttribute("admin") != null || session.getAttribute("user") != null) {

                            %>
                            <form action="ControllerUser" method="POST">
                                <input type="hidden" name="addId" value="<%= listOfProduct.get(0).getIdProduct()%>">
                                <button type="submit" name="action" value="addToCart">Add to cart</button> 
                            </form>

                            <% }
                            %>


                            <%
                                if (session.getAttribute("admin") != null) {

                            %>
                            
                            <form action="modifyProduct.jsp">
                                <button type="submit" name="action">Modify Product</button> 
                            </form>
                            
                            <form action="ControllerUser" method="POST">
                            <input type="hidden" name="deleteProductId" value="<%=listOfProduct.get(0).getIdProduct()%>">
                            <button type="submit" name="action" value="deleteProduct" >Remove Product</button> 
                        </form>
                            

                            <% }
                            %>


                        </div>
                    </div>
                </div>

                <div class="col-sm-9">
                    <h4>Leave a Comment:</h4>
                    <form action="ControllerUser" method="POST">
                        <div class="form-group">
                            <textarea name="comment" class="form-control" rows="3" required></textarea>
                        </div>
                        <input type="hidden" name="addIdComment" value="<%= listOfProduct.get(0).getIdProduct()%>">
                        <button type="submit" name="action" value="addComment"  class="btn btn-success" >Submit</button>
                    </form>
                    <br><br>

                    <%
                        DatabaseService dbs = new DatabaseService();
                        HttpSession hs = request.getSession();
                    %>

                    <%
                        Integer num = dbs.getNumberCommentByPID(listOfProduct.get(0).getIdProduct());
                        Integer pid = 0;
                        if (hs.getAttribute("pid") != null) {
                            pid = (Integer) hs.getAttribute("pid");
                            num = dbs.getNumberCommentByPID(pid);
                        }
                    %>
                    <p><span class="badge"> <%= num%> </span> Comments:</p> <br>

                    <div class="row">
                        <div class="col-sm-10">
                            <%
                                ArrayList<Comment> listOfComment = null;
                                if (hs.getAttribute("pid") != null) {
                                    pid = (Integer) hs.getAttribute("pid");
                                    listOfComment = dbs.getCommentByPID(pid);
                                } else {
                                    // System.out.println("[+] Product by " + product.getProid());
                                    listOfComment = dbs.getCommentByPID(listOfProduct.get(0).getIdProduct());
                                }

                                if (listOfComment != null) {
                                    for (Comment c : listOfComment) {
                            %>

                            <%  if (c.getUsername() != null && !c.getUsername().isEmpty() && !c.getUsername().equals("null")) {
                            %>
                            <h4 style="margin-left: 30%"><%= c.getUsername()%> <small style="margin-left: 30%"><%= c.getDate()%></small></h4>
                                <%
                                } else {
                                %>

                            <h4 style="margin-left: 30%">Unknown <small style="margin-left: 30%"><%= c.getDate()%></small></h4>
                                <%
                                    }
                                %>

                            <p style="margin-left: 30%"><%= c.getComment()%></p>
                            <br>
                            <hr>


                            <%
                                    }
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>



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
