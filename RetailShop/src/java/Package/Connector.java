/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cpt_Snag
 */
public class Connector
{
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/retailshop?useUnicode=true&characterEncoding=UTF-8&useFastDateParsing=false";
    private static final String USER = "root"; //Usually "root"
    private static final String PASS = "123456"; 
    private static Connection CONN = null;
    ////

    public static Connection createConnection()
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            CONN = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return CONN;
    }

    public static Connection getConn()
    {
        if (CONN == null)
        {
            createConnection();
        }
        return CONN;
    }

}
