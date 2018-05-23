<%@page import="java.util.ArrayList"%>
<%@page import="Package.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Product Page</title>

        <link href="Source/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="Source/js/jquery.js" type="text/javascript"></script>
        <script src="Source/js/bootstrap.bundle.js" type="text/javascript"></script>
    </head>
    <body>
        <%
            ArrayList<Product> listOfProduct = (ArrayList<Product>) session.getAttribute("product");
            session.setAttribute("currentProductID", listOfProduct.get(0).getIdProduct());
        %>
        <div class="container">
            <h2 align="center">PRODUCT MODIFICATION</h2>
            <hr>
            <form action="ControllerUser" method="POST">
                <label class="control-label col-sm-12" for="id">Product ID <i>(Can not be changed): <%=listOfProduct.get(0).getIdProduct()%></i></label>
                <div class="col-sm-10">
                    <input type="hidden" name="modifyProductId" value="<%= listOfProduct.get(0).getIdProduct()%>">
                </div>
                <label class="control-label col-sm-12" for="name">Name: <i>(Before: <%=listOfProduct.get(0).getNameProduct()%>)</i></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name" required>
                </div>
                <label class="control-label col-sm-12" for="price">Price: <i>(Before: <%=listOfProduct.get(0).getPriceProduct()%> </i></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="price" placeholder="Enter price" name="price" required>
                </div>
                <label class="control-label col-sm-12" for="gro">Type: <i>(Before: <%=listOfProduct.get(0).getTypeProduct()%>)</i></label>
                <div class="col-sm-10">
                    <select name="gro" class="form-control" id="gro" placeholder="Enter Name" name="gro" required>
                        <option value="Fastfood">Fastfood</option>
                        <option value="Rice">Rice</option> 
                        <option value="Seafood">Seafood</option>
                        <option value="Pancake">Pancake</option>
                        <option value="Drink">Drink</option>
                    </select>
                </div>

                <label class="control-label col-sm-12" for="dis">Description: <i>(Before: <%=listOfProduct.get(0).getDescriptionProduct()%>)</i></label>
                <div class="col-sm-10">
                    <textarea  class="form-control" id="dis" placeholder="Enter product's description" name="dis" required></textarea>
                </div>
                <label class="control-label col-sm-12" for="image">Image: <i>(Before: <%=listOfProduct.get(0).getImageProduct()%>)</i></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="image" placeholder="Enter image's name" name="image" required>
                </div>
                <label class="control-label col-sm-2" for="quantity">Quantity: <i>(Before: <%=listOfProduct.get(0).getQuantityProduct()%>)</i></label>
                <div class="col-sm-10">          
                    <input type="text" class="form-control" id="image" placeholder="Enter quantity" name="quantity" required>
                </div>
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default" name="action" value="modifyProduct">MODIFY This Product</button>
                </div>
            </form>
        </div>
    </body>
</html>
