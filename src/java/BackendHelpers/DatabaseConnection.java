/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendHelpers;

import allowanceManager.AllowanceManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaysonread
 */
public class DatabaseConnection {
    
    private static final String HOST = "jdbc:mysql://localhost:3306/allowance_manager";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    public static Connection GetDBConnection(){
        
        // Instantiates the jdbc driver and makes the connection to the local mySQL
        // database provided the connection information
        // TODO: Move the connection information to a configuration file
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AllowanceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        try (Connection conn = DriverManager.getConnection(HOST, USERNAME, PASSWORD)) {
            return conn;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}