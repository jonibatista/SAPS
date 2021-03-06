/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.reflect.TypeToken;
import entities.AccessPoint;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import model.SearchAccessPoint;

/**
 * REST Web Service
 *
 * @author jonibatista
 */
@Path("generic")
public class CalculatePosition {

    @Context
    private UriInfo context;

    /** Creates a new instance of CalculatePosition */
    public CalculatePosition() {
    }

    /**
     * Retrieves representation of an instance of service.CalculatePosition
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * Retrieves representation of an instance of service.CalculatePosition
     * @return an instance of java.lang.String
     */
    @GET
    @Path("test/{id}")
    @Produces("application/json")
    public String getPing(@PathParam("id") Integer id) {
        //TODO return proper representation object
        return "pong " + id;
    }

    /**
     * PUT method for updating or creating an instance of CalculatePosition
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     *
    @POST
    @Consumes("application/json")
    public void putJson(String content) {
    }*/
    @POST
    @Consumes({"application/json", "application/xml"})
    public String postCalculatePosition(String content) {
        String store = "";
        ArrayList<AccessPoint> aps = new ArrayList<AccessPoint>();

        Type collection = new TypeToken<ArrayList<AccessPoint>>() {
        }.getType();
        aps = new Gson().fromJson(content, collection);

        SearchAccessPoint s = new SearchAccessPoint(aps);

        if (s.getApIndex("00:1d:73:55:f9:b0") != -1) {
            if (aps.get(s.getApIndex("00:1d:73:55:f9:b0")).getRssi() > -65)
                return "Sala 0.2";
        }

        if (s.getApIndex("00:1d:73:55:fa:0c") != -1) {
            if((s.getApIndex("00:1d:73:55:f9:ac") != -1)){
                if (aps.get(s.getApIndex("00:1d:73:55:fa:0c")).getRssi() > aps.get(s.getApIndex("00:1d:73:55:f9:ac")).getRssi() && aps.get(s.getApIndex("00:1d:73:55:fa:0c")).getRssi() > -65)
                    return "Sala 0.3";
            }else if (aps.get(s.getApIndex("00:1d:73:55:fa:0c")).getRssi() > -65) {
                return "Sala 0.3";
            }
        }

        if ((s.getApIndex("00:1d:73:55:f9:ac") != -1)) {
            if (aps.get(s.getApIndex("00:1d:73:55:f9:ac")).getRssi() > -65) {
                return "Sala 0.4";
            }
        }
        
        return "-";
    }
}
