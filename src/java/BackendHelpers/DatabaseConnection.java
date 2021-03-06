/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendHelpers;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author jaysonread
 */
public class DatabaseConnection {
    
    private static final String HOST = "jdbc:mysql://localhost:3306/allowance_manager";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static Connection sharedConnection;
    

    public static Connection GetDBConnection(){
        
        // Instantiates the jdbc driver and makes the connection to the local mySQL
        // database provided the connection information
        // TODO: Move the connection information to a configuration file
        Connection connect;
        try {
            Class.forName(DRIVER);
            connect = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            sharedConnection = connect;
            return connect;
        } catch (Exception e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}