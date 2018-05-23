<%-- 
    Document   : addProduct
    Created on : Jan 10, 2018, 10:32:38 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product Page</title>

        <link href="Source/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="Source/js/jquery.js" type="text/javascript"></script>
        <script src="Source/js/bootstrap.bundle.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <h2 align="center">Add product </h2>
            <hr>
            <form action="ControllerUser" method="POST">
                <label class="control-label col-sm-2" for="name">Name: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name" required>
                </div>
                <label class="control-label col-sm-2" for="price">Price: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="price" placeholder="Enter price" name="price" required>
                </div>
                <label class="control-label col-sm-2" for="gro">Type </label>
                <div class="col-sm-10">
                    <select name="gro" class="form-control" id="gro" placeholder="Enter Name" name="gro" required>
                        <option value="fastfood">Fastfood</option>
                        <option value="rice">Rice</option> 
                        <option value="seafood">Seafood</option>
                        <option value="pancake">Pancake</option>
                        <option value="drink">Drink</option>
                    </select>
                </div>

                <label class="control-label col-sm-2" for="dis">Description: </label>
                <div class="col-sm-10">
                    <textarea  class="form-control" id="dis" placeholder="Enter product's description" name="dis" required></textarea>
                </div>
                <label class="control-label col-sm-2" for="image">Image: </label>
                <div class="col-sm-10">          
                    <input type="text" class="form-control" id="image" placeholder="Enter image's name" name="image" required>
                </div>
                <label class="control-label col-sm-2" for="quantity">Quantity: </label>
                <div class="col-sm-10">          
                    <input type="text" class="form-control" id="image" placeholder="Enter quantity" name="quantity" required>
                </div>
                
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default" name="action" value="addProduct">Add This Product</button>
                </div>
            </form>
        </div>
    </body>
</html>
