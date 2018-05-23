<%@page import="Package.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Package.DatabaseService"%>
<%@page import="java.sql.*"%>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Admin Management Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <style>
            a.logo{
                text-shadow: 2px 0 black, -2px 0 black, 0 2px black, 0 -2px black, 1px 1px black, -1px -1px black, -1px 1px black, 1px -1px black;
            }

            body{
                background-color:#EEEEEE;
            }

            table,th,td
            {
                text-align:center; 
                vertical-align:middle;
            }
        </style>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

<!-- asdas -->
    </head>

    <body>
        <%
            if (session.getAttribute("admin") == null) {
                response.sendRedirect("index.jsp");
            }
        %>

        <div>
            <%
                DatabaseService dao = new DatabaseService();
                ArrayList<User> currentUser = (ArrayList<User>) session.getAttribute("currentUser");
            %>
            <h1 align="center">Admin Management Page</h1>
            <h1 align="center">Welcome Admin: <%=currentUser.get(0).getEmailUser()%></h1>
            
            <hr>
            
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <h1 class="my-4"><a>Search</a></h1>
                        <div class="list-group">
                            <a class="list-group-item">
                                <form action="ControllerUser" method="POST"> 
                                    <input type="text" placeholder="Search for Users" name="searchUserName" id="searchUserName">
                                    <button type="submit" class="btn btn-default" name="action" value="searchUser"><span class="glyphicon glyphicon-search"></span> Search</button>
                                </form>
                            </a>
                            <a class="list-group-item">
                                <form action="ControllerUser" method="POST">
                                    <input type="text" placeholder="Search for Products" name="searchProductName" id="searchProductName">
                                    <button type="submit" class="btn btn-default" name="action" value="searchProduct"><span class="glyphicon glyphicon-search"></span> Search</button>
                                </form>
                            </a>
                        </div>

                    </div>
                    <div class="col-lg-6">

                        <h1 class="my-4"><a>Show All</a></h1>
                        <div class="list-group">
                            <a class="list-group-item">
                                <form action="ControllerUser" method="POST"> 
                                    <button type="submit" class="btn btn-default" name="action" value="showAllUser"><span class="glyphicon glyphicon-th"></span> Show All User</button>
                                </form>
                            </a>
                            <a class="list-group-item">
                                <form action="ControllerUser" method="POST"> 
                                    <button type="submit" class="btn btn-default" name="action" value="showAllProduct"><span class="glyphicon glyphicon-th"></span> Show All Product</button>
                                </form>
                            </a>
                            <a class="list-group-item">
                                <form action="addProduct.jsp"> 
                                    <button type="submit" class="btn btn-default" name="action"><span class="glyphicon glyphicon-plus"></span> Add Product</button>
                                </form>
                            </a>
                            <a class="list-group-item">
                                <form action="index.jsp"> 
                                    <button type="submit" class="btn btn-default" name="action"><span class="glyphicon glyphicon-home"></span> HOMEPAGE</button>
                                </form>
                            </a>
                        </div>

                    </div>


                </div>
            </div>

            <br>

            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    </body>


</html>