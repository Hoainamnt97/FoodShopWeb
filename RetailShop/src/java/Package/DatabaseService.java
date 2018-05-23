/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junnguyen
 */
public class DatabaseService {

    private Connection conn;
    private PreparedStatement preparedStatement;

    public DatabaseService() {
        preparedStatement = null;
        conn = Connector.getConn();
        //conn = Connector.getConn();
        System.out.println("[+] Conn is okie || " + conn);
    }

    public String getPassword(String name) throws SQLException {

        String sqlQuery = "SELECT * FROM user WHERE nameUser = ?"; //mydb = $Database_Name
        //Ghi dòng Query cần Update hay Delete hay Select ở đây
        //Chỗ ? sẽ input vào sau vì vấn đ�? Security
        String passwd = null; //Anh dùng method này để check password từ DB với input_Pass
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(sqlQuery);//Dùng PreparedStatement để input vào ?
            preparedStatement.setString(1, name);// ? thứ 1 sẽ input từ parameter email.

            ResultSet rs = preparedStatement.executeQuery();
            ///If no data return prepareStmt.executeUpdate(); sao no hieu dc :S
            while (rs.next()) {
                passwd = rs.getString("passUser");//Get giá trị nằm ở Collumn password
                System.out.println("PASS IS " + passwd);//Debug lỗi

            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return passwd;
    }

    public String getUsername(String name) throws SQLException {

        String sqlQuery = "SELECT * FROM user WHERE nameUser = ?"; //mydb = $Database_Name
        //Ghi dòng Query cần Update hay Delete hay Select ở đây
        //Chỗ ? sẽ input vào sau vì vấn đ�? Security
        String username = null; //Anh dùng method này để check password từ DB với input_Pass
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(sqlQuery);//Dùng PreparedStatement để input vào ?
            preparedStatement.setString(1, name);// ? thứ 1 sẽ input từ parameter email.

            ResultSet rs = preparedStatement.executeQuery();
            ///If no data return prepareStmt.executeUpdate(); sao no hieu dc :S
            while (rs.next()) {
                username = rs.getString("nameUser");//Get giá trị nằm ở Collumn password

            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return username;
    }

    public int getID(String name) throws SQLException {

        String sqlQuery = "SELECT * FROM user WHERE nameUser = ?";
        int id = 0;
        try {
            conn = Connector.createConnection();
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("idUser");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return id;
    }

    public String getStatus(String name) throws SQLException {

        String sqlQuery = "SELECT * FROM user WHERE nameUser = ?";
        String status = null; //Anh dùng method này để check password từ DB với input_Pass
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(sqlQuery);//Dùng PreparedStatement để input vào ?
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                status = rs.getString("pendingUser");

            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return status;
    }

    public int getProductID(String name) throws SQLException {

        String sqlQuery = "SELECT * FROM product WHERE nameProduct = ?";
        int id = 0;
        try {
            conn = Connector.createConnection();
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("productUser");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return id;
    }

    public void importValue(String name, String email, String pass, String status) throws SQLException {

        String sqlQuery = "INSERT INTO user "
                + "(nameUser, emailUser, passUser, pendingUser) "
                + "VALUES(?, ?, ?, ?)";//Khoi can ; cung dc. 
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(sqlQuery);//Dùng PreparedStatement để input vào ?
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, pass);
            preparedStatement.setString(4, status);
            preparedStatement.executeUpdate();
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
    }

    public void removeUser(int counter) throws SQLException {
        String sqlQuery = "DELETE FROM user "
                + "WHERE idUser = ?";//Khoi can ; cung dc. 
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(sqlQuery);//Dùng PreparedStatement để input vào ?
            preparedStatement.setInt(1, counter);
            preparedStatement.executeUpdate();
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
    }
    public void removeProduct(int counter) throws SQLException {
        String sqlQuery = "DELETE FROM product "
                + "WHERE idProduct  = ?";//Khoi can ; cung dc. 
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(sqlQuery);//Dùng PreparedStatement để input vào ?
            preparedStatement.setInt(1, counter);
            preparedStatement.executeUpdate();
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
    }

    public void activateUser(int counter) throws SQLException {
        String sqlQuery = "UPDATE retailshop.user "
                + "SET pendingUser = 1 "
                + "WHERE idUser = ?";//Khoi can ; cung dc. 
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(sqlQuery);//Dùng PreparedStatement để input vào ?
            preparedStatement.setInt(1, counter);
            preparedStatement.executeUpdate();
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
    }

    public void deActivateUser(int counter) throws SQLException {
        String sqlQuery = "UPDATE retailshop.user "
                + "SET pendingUser = 0 "
                + "WHERE idUser = ?";//Khoi can ; cung dc. 
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(sqlQuery);//Dùng PreparedStatement để input vào ?
            preparedStatement.setInt(1, counter);
            preparedStatement.executeUpdate();
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
    }

    public void modifyProduct(int idProduct, String nameProduct, String priceProduct, String typeProduct, String descriptionProduct, String imageProduct, int quantityProduct) throws SQLException {
//        UPDATE `retailshop`.`product` SET `nameProduct`='HoaiNam123123', `priceProduct`='122', `typeProduct`='Pancake', `descriptionProduct`='Test Description 23123', `imageProduct`='Source/img/product99.jpg', `quantityProduct`='155' WHERE `idProduct`='8';

        String sqlQuery = "UPDATE retailshop.product "
                + "SET nameProduct=?, priceProduct=?, typeProduct=?, descriptionProduct=?, imageProduct=?, quantityProduct=? "
                + "WHERE idProduct=?";
        try {
            conn = Connector.createConnection();
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, nameProduct);
            preparedStatement.setString(2, priceProduct);
            preparedStatement.setString(3, typeProduct);
            preparedStatement.setString(4, descriptionProduct);
            preparedStatement.setString(5, imageProduct);
            preparedStatement.setInt(6, quantityProduct);
            preparedStatement.setInt(7, idProduct);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
    }

    public ArrayList<User> getUser(int n) throws SQLException {
        ArrayList<User> listOfUser = new ArrayList<>();
        String query = "SELECT * FROM retailshop.user WHERE idUser = ?";
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, n);
            ResultSet rs = preparedStatement.executeQuery();
            ///If no data return prepareStmt.executeUpdate(); sao no hieu dc :S
            while (rs.next()) {
                int id = rs.getInt("idUser");
                String name = rs.getString("nameUser");
                String email = rs.getString("emailUser");
                String pass = rs.getString("passUser");
                int status = rs.getInt("pendingUser");
                User user = new User(id, name, email, pass, status);
                listOfUser.add(user);
            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return listOfUser;
    }

    public ArrayList<User> getAdmin() throws SQLException {
        ArrayList<User> listOfUser = new ArrayList<>();
        String query = "SELECT * FROM retailshop.user WHERE nameUser = admin";
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ///If no data return prepareStmt.executeUpdate(); sao no hieu dc :S
            while (rs.next()) {
                int id = rs.getInt("idUser");
                String name = rs.getString("nameUser");
                String email = rs.getString("emailUser");
                String pass = rs.getString("passUser");
                int status = rs.getInt("pendingUser");
                User user = new User(id, name, email, pass, status);
                listOfUser.add(user);
            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return listOfUser;
    }

    public ArrayList<User> getUserByName(String loginName) throws SQLException {
        ArrayList<User> listOfUser = new ArrayList<>();
        String query = "SELECT * FROM retailshop.user WHERE nameUser = ?";
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, loginName);

            ResultSet rs = preparedStatement.executeQuery();
            ///If no data return prepareStmt.executeUpdate(); sao no hieu dc :S
            while (rs.next()) {
                int id = rs.getInt("idUser");
                String name = rs.getString("nameUser");
                String email = rs.getString("emailUser");
                String pass = rs.getString("passUser");
                int status = rs.getInt("pendingUser");
                User user = new User(id, name, email, pass, status);
                listOfUser.add(user);
            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return listOfUser;
    }

    public ArrayList<User> getAllUser() throws SQLException {
        ArrayList<User> listOfUser = new ArrayList<>();
        String query = "SELECT * FROM retailshop.user";
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ///If no data return prepareStmt.executeUpdate(); sao no hieu dc :S
            while (rs.next()) {
                int id = rs.getInt("idUser");
                String name = rs.getString("nameUser");
                String email = rs.getString("emailUser");
                String pass = rs.getString("passUser");
                int status = rs.getInt("pendingUser");
                User user = new User(id, name, email, pass, status);
                listOfUser.add(user);
            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return listOfUser;
    }

    public ArrayList<User> getUserFromSearch(String search) throws SQLException {
        ArrayList<User> listOfUser = new ArrayList<>();
        String query = "SELECT * FROM retailshop.user WHERE locate(?, nameUser)>0";
//        String query = "SELECT * FROM retailshop.user WHERE locate('" + search + "', nameUser)>0";
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, search);
            ResultSet rs = preparedStatement.executeQuery();
            ///If no data return prepareStmt.executeUpdate(); sao no hieu dc :S
            while (rs.next()) {
                int id = rs.getInt("idUser");
                String name = rs.getString("nameUser");
                String email = rs.getString("emailUser");
                String pass = rs.getString("passUser");
                int status = rs.getInt("pendingUser");
                User user = new User(id, name, email, pass, status);
                listOfUser.add(user);
            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return listOfUser;
    }

    public ArrayList<Product> getProductFromSearch(String search) throws SQLException {
        ArrayList<Product> listOfProduct = new ArrayList<>();
        String query = "SELECT * FROM retailshop.product WHERE locate(?, nameProduct)>0";
//        String query = "SELECT * FROM retailshop.user WHERE locate('" + search + "', nameUser)>0";
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, search);
            ResultSet rs = preparedStatement.executeQuery();
            ///If no data return prepareStmt.executeUpdate(); sao no hieu dc :S
            while (rs.next()) {
                int id = rs.getInt("idProduct");
                String name = rs.getString("nameProduct");
                double price = rs.getDouble("priceProduct");
                String type = rs.getString("typeProduct");
                String description = rs.getString("descriptionProduct");
                String image = rs.getString("imageProduct");
                int quantity = rs.getInt("quantityProduct");
                Product product = new Product(id, name, price, type, description, image, quantity);
                listOfProduct.add(product);
            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return listOfProduct;
    }

    public ArrayList<Product> getProductFromTypeSearch(String search) throws SQLException {
        ArrayList<Product> listOfProduct = new ArrayList<>();
        String query = "SELECT * FROM retailshop.product WHERE locate(?, typeProduct)>0";
//        String query = "SELECT * FROM retailshop.user WHERE locate('" + search + "', nameUser)>0";
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, search);
            ResultSet rs = preparedStatement.executeQuery();
            ///If no data return prepareStmt.executeUpdate(); sao no hieu dc :S
            while (rs.next()) {
                int id = rs.getInt("idProduct");
                String name = rs.getString("nameProduct");
                double price = rs.getDouble("priceProduct");
                String type = rs.getString("typeProduct");
                String description = rs.getString("descriptionProduct");
                String image = rs.getString("imageProduct");
                int quantity = rs.getInt("quantityProduct");
                Product product = new Product(id, name, price, type, description, image, quantity);
                listOfProduct.add(product);
            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return listOfProduct;
    }

    public void addProduct(String nameProduct, String priceProduct, String typeProduct, String descriptionProduct, String imageProduct, int quantityProduct) throws SQLException {

        String sqlQuery = "INSERT INTO product (nameProduct, priceProduct, typeProduct, descriptionProduct, imageProduct, quantityProduct) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = Connector.createConnection();
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, nameProduct);
            preparedStatement.setString(2, priceProduct);
            preparedStatement.setString(3, typeProduct);
            preparedStatement.setString(4, descriptionProduct);
            preparedStatement.setString(5, imageProduct);
            preparedStatement.setInt(6, quantityProduct);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    public ArrayList<Product> getAllProduct() throws SQLException {
        ArrayList<Product> listOfProduct = new ArrayList<>();
        String query = "SELECT * FROM retailshop.product";
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ///If no data return prepareStmt.executeUpdate(); sao no hieu dc :S
            while (rs.next()) {
                int id = rs.getInt("idProduct");
                String name = rs.getString("nameProduct");
                double price = rs.getDouble("priceProduct");
                String type = rs.getString("typeProduct");
                String description = rs.getString("descriptionProduct");
                String image = rs.getString("imageProduct");
                int quantity = rs.getInt("quantityProduct");
                Product product = new Product(id, name, price, type, description, image, quantity);
                listOfProduct.add(product);
            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return listOfProduct;
    }

    public ArrayList<Product> getProduct(int n) throws SQLException {
        ArrayList<Product> listOfProduct = new ArrayList<>();
        String query = "SELECT * FROM retailshop.product WHERE idProduct = ?";
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, n);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idProduct");
                String name = rs.getString("nameProduct");
                double price = rs.getDouble("priceProduct");
                String type = rs.getString("typeProduct");
                String description = rs.getString("descriptionProduct");
                String image = rs.getString("imageProduct");
                int quantity = rs.getInt("quantityProduct");
                Product product = new Product(id, name, price, type, description, image, quantity);
                listOfProduct.add(product);
            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return listOfProduct;
    }

    public ArrayList<Comment> getCommentByPID(int pid) throws SQLException {
        ArrayList<Comment> listOfProduct = new ArrayList<>();
        String query = "SELECT * FROM retailshop.comment "
                + "WHERE idProduct = ?";
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, pid);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                Date date = rs.getDate("date");
                String comment = rs.getString("comment");

                Comment c = new Comment(username, date, comment);
                listOfProduct.add(c);
            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return listOfProduct;
    }

    public Integer getNumberCommentByPID(int pid) throws SQLException {
        Integer num = 0;
        String query = "SELECT * FROM retailshop.comment "
                + "WHERE idProduct=?";
        try {
            conn = Connector.createConnection(); //Tạo connect từ cái Connector.java
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, pid);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                num++;

            }
        } //Dưới đây là mấy cái try-catch gì đó 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return num;
    }

    public void addComment(int pid, int uid, String username, String comment) throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        String dateTime = dateFormat.format(date);

        String sqlQuery = "INSERT INTO retailshop.comment "
                + "(idUser, idProduct, usernameComment, dateComment, valueComment) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            conn = Connector.createConnection();
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, uid);
            preparedStatement.setInt(2, pid);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, dateTime);
            preparedStatement.setString(5, comment);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }
        }

    }

    public void makeOrder(ArrayList<Product> cart, int uid, String banking, String address, String phone) throws SQLException {

        for (Product p : cart) {
            String sqlQuery = "INSERT INTO retailshop.order (idUser, idProduct, quantityOrder, bankingOrder, addressOrder, phoneOrder) VALUES (?, ?, ?, ?, ?, ?)";

            try {
                conn = Connector.createConnection();
                preparedStatement = conn.prepareStatement(sqlQuery);
                preparedStatement.setInt(1, uid);
                preparedStatement.setInt(2, p.getIdProduct());
                preparedStatement.setInt(3, p.getQuantityProduct());
                preparedStatement.setString(4, banking);
                preparedStatement.setString(5, address);
                preparedStatement.setString(6, phone);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (conn != null) {
                    conn.close();
                }
            }
        }

    }

}
