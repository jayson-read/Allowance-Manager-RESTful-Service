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

    /**
     * Retrieves representation of an instance of allowanceManagerChild.AllowanceManagerChild
     * @return an instance of java.lang.String
     */
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

    /**
     * PUT method for updating or creating an instance of AllowanceManagerChild
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
