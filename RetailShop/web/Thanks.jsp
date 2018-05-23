<%-- 
    Document   : Thanks
    Created on : Jan 11, 2018, 4:46:25 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Thank you for purchasing</h1>
        <h1>The item will be delivery to your Address in a week</h1>
        <a href="index.jsp">Homepage</a>
        <%
            session.setAttribute("cart", null);
        %>
    </body>
</html>
