package ActionPage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Package.DatabaseService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            DatabaseService callFunction = new DatabaseService();
            String checkPass = callFunction.getPassword(request.getParameter("username"));//em kiểm tra xem cái người login thì account cua~ ho. active chua :)
            String checkStatus = callFunction.getStatus(request.getParameter("username"));//Y la sao 2 dong nay giong nhau? de~ em nho' em lam gi da` xD
            if (checkPass.equals(request.getParameter("password")) && checkStatus.equals("1")) {
                HttpSession session = request.getSession();

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Logout</title>");
                out.println("</head>");
                out.println("<body>");

                if (request.getParameter("username").equals("admin") && checkPass.equals("admin")) {
                    session.removeAttribute("user");
                    session.removeAttribute("us");
                    session.setAttribute("admin", callFunction.getAdmin());
                    session.setAttribute("ad", request.getParameter("username"));
                    session.setAttribute("uid", callFunction.getID(request.getParameter("username")));
                } else //Not admin
                {
                    session.removeAttribute("admin");
                    session.removeAttribute("ad");
                    session.setAttribute("user", callFunction.getAllUser());
                    session.setAttribute("us", request.getParameter("username"));
                    session.setAttribute("uid", callFunction.getID(request.getParameter("username")));
                }
                out.println("<h1>Login successfully </h1><br>");
                session.setAttribute("currentUser", callFunction.getUserByName(request.getParameter("username")));
                out.println("<h2>Welcome: " + request.getParameter("username") + "</h2>");
                out.print("<a href=\"index.jsp\"><input type=\"button\" class=\"btn btn-lg btn-primary\" value=\"Main Page\"></a>");
            } else if (checkPass.equals(request.getParameter("password")) && checkStatus != "1") {
                out.println("<h1>Login FAIL, The User HASN'T been ACTIVATED</h1>");
                out.print("<a href=\"index.jsp\"><input type=\"button\" class=\"btn btn-lg btn-primary\" value=\"Main Page\"></a>");
            } else {
                out.println("<h1>Login FAIL, The User HASN'T been CREATED</h1>");
                out.print("<a href=\"index.jsp\"><input type=\"button\" class=\"btn btn-lg btn-primary\" value=\"Main Page\"></a>");
            }
            out.println("</body>");
            out.println("</html>");

        } catch (SQLException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
