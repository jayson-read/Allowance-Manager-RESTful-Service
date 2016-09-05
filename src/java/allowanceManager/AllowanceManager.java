/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allowanceManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author jaysonread
 */
@Path("allowanceManager")
public class AllowanceManager {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AllowanceManager
     */
    public AllowanceManager() {
    }
    
    private final String _host = "jdbc:mysql://localhost:3306/allowance_manager";
    private final String _username = "root";
    private final String _password = "";
    /**
     * Retrieves representation of an instance of allowanceManager.AllowanceManager
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        String response;
        response = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AllowanceManager.class.getName()).log(Level.SEVERE, null, ex);
            response = ex.toString();
        }
        try (Connection connection = DriverManager.getConnection(_host, _username, _password)) {
            response = "Database connected";
        } catch (SQLException e) {
            //throw new IllegalStateException("Cannot connect the database!", e);
            response = "Cannot connect to database" + e.toString();
        }
        
        return response;
    }

    /**
     * PUT method for updating or creating an instance of AllowanceManager
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
