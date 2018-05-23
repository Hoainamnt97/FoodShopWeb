<%@page import="Package.User"%>
<%@ page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
    <head>
    </head>
    <body>
        <table width="90%" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=8 align="center"
                    style="background-color:teal">
                    <b>User Record</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>User ID</b></td>
                <td><b>User Name</b></td>
                <td><b>User Email</b></td>
                <td><b>Password</b></td>
                <td><b>Status</b></td>
                <td colspan=3 align="center"><b>Action</b></td>
            </tr>
            <%
//                session.setAttribute("listUser", request.getAttribute("userManagement"));

                Object Test;
                Test = request.getAttribute("userManagement");

                String color = "#F9EBB3";
//                if (session.getAttribute("listUser") != null) {
//                    ArrayList<User> listOfUser = (ArrayList<User>) session.getAttribute("listUser");
                if (Test != null) {
                    ArrayList<User> listOfUser = (ArrayList<User>) Test;
                    for (int i = 0; i < listOfUser.size(); i++) {
            %>
            <tr style="background-color:<%=color%>;">
                <td><%=listOfUser.get(i).getIdUser()%></td>
                <td><%=listOfUser.get(i).getNameUser()%></td>
                <td><%=listOfUser.get(i).getEmailUser()%></td>
                <td><%=listOfUser.get(i).getPassUser()%></td>
                <td><%if (listOfUser.get(i).getPendingUser() == 1) {
                        out.println("Activated User");
                    } else {
                        out.println("Pending User");
                    }
                    %>
                </td>
                <td>
                    <form action="ControllerUser" method="POST">
                        <input type="hidden" name="activateUserID" value="<%=listOfUser.get(i).getIdUser()%>">
                        <button type="submit" name="action" value="activateUser" >Activate</button> 
                    </form>
                </td>
                <td>
                    <form action="ControllerUser" method="POST">
                        <input type="hidden" name="deActivateUserID" value="<%=listOfUser.get(i).getIdUser()%>">
                        <button type="submit" name="action" value="deActivateUser" >Deactivate</button> 
                    </form>
                </td>
                <td>
                    <form action="ControllerUser" method="POST">
                        <input type="hidden" name="removeUserID" value="<%=listOfUser.get(i).getIdUser()%>">
                        <button type="submit" name="action" value="removeUser" >Remove</button> 
                    </form>
                </td>
            </tr>
            <%
                    }
                } else {
                    out.println("NULL");
                }

            %>
            <tr>
                <td colspan=8 align="center"
                    style="background-color:#eeffee"><b>...End of the List...   
                        <a class="navbar-form navbar-left" href="index.jsp">Back to Home Page </a>      or      
                        <a class="navbar-form navbar-left" href="AdminPage.jsp">Continue Management </a>

                    </b></td>
            </tr>
            <%
            %>
        </table>
    </body>
</html>