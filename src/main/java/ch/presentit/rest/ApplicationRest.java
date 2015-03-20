package ch.presentit.rest;

import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ch.presentit.entity.Version;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Path("app")
@Api(value = "/app", description = "Operations about app")
public class ApplicationRest {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a json response.
	 * @throws JsonProcessingException 
	 */
	@GET
	@Path("/version")
	@ApiOperation(value = "retrieve the version resource")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getVersion() throws JsonProcessingException {
		Version version = new Version();
		version.setRelease("1.0.1");
		version.setName("Present IT");
		version.setLicense("MIT");
		version.setAuthor("Icepick & Strikeflare");
		version.setDate(new Date());
		return Response.status(200).entity(version).build();
	}

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a json response.
	 * @throws JsonProcessingException
	 */
	@GET
	@Path("/helloworld")
	@ApiOperation(value = "retrieve the hello world resource")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getHelloWorld() throws JsonProcessingException {
		String world = new String("Hello World!");
		ObjectMapper mapper = new ObjectMapper();
		return Response.status(200).entity(mapper.writeValueAsString(world)).build();
	}

}
