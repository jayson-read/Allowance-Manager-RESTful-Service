/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allowanceManagerChild;

import java.util.Set;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import javax.ws.rs.PathParam;


/**
 * REST Web Service
 *
 * @author jaysonread
 */
@Path("allowanceManagerChild")
public class AllowanceManagerChild {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AllowanceManagerChild
     */
    public AllowanceManagerChild() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {

        String response = "";
        Set<Child> children = Child.GetAllChildInfo();
        for (Child child : children){
            Gson gson = new Gson();
            String json = gson.toJson(child);
            response = response + json;
        }
        return response;
    }
    
    @GET
    @Path("/{childID}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("childID") int childID) {
        String response = "";
        try{
            Set<Child> children = Child.GetChildInfo(childID);
            //response = Integer.toString(children.size());
            for (Child child : children){
                Gson gson = new Gson();
                String json = gson.toJson(child);
                response = response + json;
            }
        }
        catch(Exception e){
            response = e.toString();
        }
        return response;
    }

    /**
     * PUT method for updating or creating an instance of AllowanceManagerChild
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
