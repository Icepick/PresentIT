package ch.presentit.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("app")
public class ApplicationRest {

	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/version")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getVersion() {
    	String version = "0.1";
		return Response.status(200).entity(version).build();
    }
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/helloworld")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getHelloWorld() {
        return "Hello World!";
    }
	
}
