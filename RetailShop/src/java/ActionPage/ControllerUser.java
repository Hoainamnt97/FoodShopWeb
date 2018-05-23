package ActionPage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Package.DatabaseService;
import Package.Product;
import Package.SessionService;
import Package.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class ControllerUser extends HttpServlet {

    public ArrayList<User> TestListUser = new ArrayList<>();
    public ArrayList<Product> TestListProduct = new ArrayList<>();
    public String SearchUser;
    public String SearchProduct;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ArrayList<Product> searchedProduct = new ArrayList<>();

        DatabaseService connector = new DatabaseService();

        // Call Servlet Context
        ServletContext sc = getServletContext();

        // Call session
        HttpSession session = request.getSession();

        // Declare requestDispatcher
        RequestDispatcher rd;

        String action = request.getParameter("action");

        switch (action) {
            case "removeUser": {
                String idd = request.getParameter("removeUserID");
                int id = Integer.parseInt(idd);
                connector.removeUser(id);
                TestListUser = connector.getAllUser();
                if (SearchUser != null) {
                    TestListUser = connector.getUserFromSearch(SearchUser);
                }
                request.setAttribute("userManagement", TestListUser);
                request.getRequestDispatcher("userResultPage.jsp").forward(request, response);
//                session.setAttribute("listUser", connector.getAllUser());
//                response.sendRedirect("/RetailShop/userResultPage.jsp");
//                // Add news function
                break;
            }
            case "activateUser": {
                String idd = request.getParameter("activateUserID");
                int id = Integer.parseInt(idd);
                connector.activateUser(id);
//                session.setAttribute("listUser", connector.getAllUser());
                TestListUser = connector.getAllUser();
                if (SearchUser != null) {
                    TestListUser = connector.getUserFromSearch(SearchUser);
                }
                request.setAttribute("userManagement", TestListUser);
                request.getRequestDispatcher("userResultPage.jsp").forward(request, response);
//                response.sendRedirect("/RetailShop/userResultPage.jsp");
//                // Add news function
                break;
            }
            case "deActivateUser": {
                String idd = request.getParameter("deActivateUserID");
                int id = Integer.parseInt(idd);
                connector.deActivateUser(id);
                TestListUser = connector.getAllUser();
                if (SearchUser != null) {
                    TestListUser = connector.getUserFromSearch(SearchUser);
                }
//                TestListUser = connector.getAllUser();
                request.setAttribute("userManagement", TestListUser);
                request.getRequestDispatcher("userResultPage.jsp").forward(request, response);
//                session.setAttribute("listUser", connector.getAllUser());
//                response.sendRedirect("/RetailShop/userResultPage.jsp");
                break;
            }

            case "searchUser": {
                ArrayList<User> listUser = connector.getUserFromSearch(request.getParameter("searchUserName"));
                TestListUser = listUser;
                SearchUser = request.getParameter("searchUserName");
//                rd = sc.getRequestDispatcher("/userResultPage.jsp");
//                rd.forward(request, response);
                request.setAttribute("userManagement", TestListUser);
                request.getRequestDispatcher("userResultPage.jsp").forward(request, response);
                break;
            }

            case "searchProduct": {
                ArrayList<Product> listProduct = connector.getProductFromSearch(request.getParameter("searchProductName"));
                TestListProduct = listProduct;
                SearchProduct = request.getParameter("searchProductName");
                request.setAttribute("productManagement", TestListProduct);
                request.getRequestDispatcher("productList.jsp").forward(request, response);

//                session.setAttribute("productSearch", listProduct);
//                rd = sc.getRequestDispatcher("/productList.jsp");
//                rd.forward(request, response);
                break;
            }

            case "searchTypeProduct": {
                ArrayList<Product> listProduct = connector.getProductFromTypeSearch(request.getParameter("typeProduct"));
                TestListProduct = listProduct;
                SearchProduct = request.getParameter("searchProductName");
                request.setAttribute("productManagement", TestListProduct);
                request.getRequestDispatcher("productList.jsp").forward(request, response);
                break;
            }

            case "addProduct": {
                String nameProduct = request.getParameter("name");    // product name
                String priceProduct = request.getParameter("price");  // product price
                String typeProduct = request.getParameter("gro");   // group
                String descriptionProduct = request.getParameter("dis");    // product discription
                String imageProduct = "Source/img/" + request.getParameter("image") + ".jpg";   // link product's image
                int quantityProduct = Integer.parseInt(request.getParameter("quantity"));
                // Add to database
                connector.addProduct(nameProduct, priceProduct, typeProduct, descriptionProduct, imageProduct, quantityProduct);
                ArrayList<Product> listProduct = connector.getAllProduct();
                TestListProduct = listProduct;
                SearchProduct = null;
                request.setAttribute("productManagement", listProduct);
                request.getRequestDispatcher("productList.jsp").forward(request, response);
                break;
            }
            case "modifyProduct": {
                int idProduct = (int) session.getAttribute("currentProductID");
                String nameProduct = request.getParameter("name");    // product name
                String priceProduct = request.getParameter("price");  // product price
                String typeProduct = request.getParameter("gro");   // group
                String descriptionProduct = request.getParameter("dis");    // product discription
                String imageProduct = "Source/img/" + request.getParameter("image") + ".jpg";   // link product's image
                int quantityProduct = 5;
                // Add to database
                connector.modifyProduct(idProduct, nameProduct, priceProduct, typeProduct, descriptionProduct, imageProduct, quantityProduct);
                ArrayList<Product> listProduct = connector.getAllProduct();
                TestListProduct = listProduct;
                SearchProduct = null;
                request.setAttribute("productManagement", listProduct);
                request.getRequestDispatcher("productList.jsp").forward(request, response);
                break;
            }

            case "showAllUser": {
                ArrayList<User> listUser = connector.getAllUser();
//                session.setAttribute("listUser", listUser);
                TestListUser = listUser;
                SearchUser = null;
                request.setAttribute("userManagement", listUser);
                request.getRequestDispatcher("userResultPage.jsp").forward(request, response);
//                rd = sc.getRequestDispatcher("/userResultPage.jsp");
//                rd.forward(request, response);
                break;
            }

            case "showAllProduct": {
                ArrayList<Product> listProduct = connector.getAllProduct();
                TestListProduct = listProduct;
                SearchProduct = null;
                request.setAttribute("productManagement", listProduct);
                request.getRequestDispatcher("productList.jsp").forward(request, response);
                break;
            }

            case "addToCart": {
                int pid = Integer.parseInt(request.getParameter("addId"));
                SessionService ss = new SessionService(request.getSession());
                //if you have an ArrayList of product --> ss.addProductListToCart(list);
                //if you add only one product --> ss.addProductToCart(list);

                ArrayList<Product> listProduct = connector.getProduct(pid);
                ss.addCart(listProduct.get(0));

                response.sendRedirect("cartPage.jsp");

//                String nameProduct = request.getParameter("name");    // product name
//                String priceProduct = request.getParameter("price");  // product price
//                String typeProduct = request.getParameter("gro");   // group
//                String descriptionProduct = request.getParameter("dis");    // product discription
//                String imageProduct = "Source/img/" + request.getParameter("image") + ".jpg";   // link product's image
//                // Add to database
//                connector.addProduct(nameProduct, priceProduct, typeProduct, descriptionProduct, imageProduct);
//                ArrayList<Product> listProduct = connector.getAllProduct();
//                TestListProduct = listProduct;
//                SearchProduct = null;
//                request.setAttribute("productManagement", listProduct);
//                request.getRequestDispatcher("productList.jsp").forward(request, response);
                break;
            }

            case "deleteFromCart": {
                int id_of_delete_item = Integer.parseInt(request.getParameter("deleteId"));

                SessionService ss = new SessionService(request.getSession());
                ArrayList<Product> currentCart = ss.getCart();

                removeItemFromCart(id_of_delete_item, currentCart);

                rd = sc.getRequestDispatcher("/cartPage.jsp");
                rd.forward(request, response);
                break;
            }
            case "deleteProduct": {
                String idd = request.getParameter("deleteProductId");
                int id = Integer.parseInt(idd);
                connector.removeProduct(id);
                response.sendRedirect("index.jsp");
//                session.setAttribute("listUser", connector.getAllUser());
//                response.sendRedirect("/RetailShop/userResultPage.jsp");
//                // Add news function
                break;
            }
            

            case "checkout": {
                int uid = 0;
                if (session.getAttribute("uid") != null) {
                    uid = (int) session.getAttribute("uid");
                }

                ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
                String banking = request.getParameter("banking");
                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                connector.makeOrder(cart, uid, banking, address, phone);
                System.out.println("[+] Make order OK!");
                response.sendRedirect("Thanks.jsp");
                break;
            }

            case "addComment": {
                String username = null;
                if (session.getAttribute("ad") != null) {
                    username = (String) session.getAttribute("ad");
                } else if (session.getAttribute("us") != null) {
                    username = (String) session.getAttribute("us");
                }

                int pid = Integer.parseInt(request.getParameter("addIdComment"));
                int uid = 0;
                if (session.getAttribute("uid") != null) {
                    uid = (int) session.getAttribute("uid");
                }
                String comment = request.getParameter("comment");
                
                connector.addComment(pid, uid, username, comment);

                session.removeAttribute("pid");
                session.setAttribute("pid", pid);
                response.sendRedirect("productPage.jsp");

                break;
            }

            case "details": {
                ArrayList<Product> product = (ArrayList<Product>) connector.getProduct(Integer.parseInt(request.getParameter("viewproducts")));
                session.setAttribute("product", product);
//                response.sendRedirect("/RetailShop/productPage.jsp");
                rd = sc.getRequestDispatcher("/productPage.jsp");
                rd.forward(request, response);
                break;
            }
            default:
                break;

        }
        
        
        

    }

    public void removeItemFromCart(int product_id, ArrayList<Product> cart) {
        ArrayList<Product> itemBin = new ArrayList<Product>();
        for (Product p : cart) {
            if (p.getIdProduct() == product_id) {
                itemBin.add(p);
            }
        }
        cart.removeAll(itemBin);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
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
