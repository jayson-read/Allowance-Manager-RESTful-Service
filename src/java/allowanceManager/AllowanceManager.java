/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allowanceManager;

import BackendHelpers.DatabaseConnection;
import allowanceManagerChild.Child;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
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
    
    /**
     * Retrieves representation of an instance of allowanceManager.AllowanceManager
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        String response = "This should work";
        String query = "{ call ChildReturnAll() }";
        
        ResultSet rs;
        Set <Child> children = new HashSet<>();
        

        try(Connection conn = DatabaseConnection.GetDBConnection()){
            CallableStatement stmt = conn.prepareCall(query);
            rs = stmt.executeQuery();
            while (rs.next()){
                Child child = new Child();
                child.setChildID(rs.getInt("ChildID"));
                child.setChildFirstName(rs.getString("FirstName"));
                child.setChildLastName(rs.getString("LastName"));
                child.setChildFullName(rs.getString("FullName"));
                child.setChildBirthDate(rs.getDate("BirthDay"));
                
                children.add(child);
                response = response + child.toString() + " " + Integer.toString(children.size());
            }
        }catch(SQLException e) {
            response = e.toString();
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
