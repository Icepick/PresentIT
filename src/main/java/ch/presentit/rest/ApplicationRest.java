package ch.presentit.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.presentit.model.Version;
import ch.presentit.service.VersionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Component
@Path("/app")
@Api(value = "/app", description = "Operations about the presentit app")
public class ApplicationRest {

	/** The logger. */
	private final Logger LOGGER;
	
	/** The VersionService. */
	@Autowired
	private VersionService versionService;
	
	/**
	 * Instantiate a new application rest.
	 */
	public ApplicationRest() {
		this.LOGGER = Logger.getLogger(ApplicationRest.class);
	}

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "application/json" media type.
	 *
	 * @return String that will be returned as a json response.
	 * @throws JsonProcessingException
	 */
	@GET
	@Path("/version")
	@ApiOperation(value = "retrieve the version resource")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getVersion() throws JsonProcessingException {
		Version version = versionService.find(new Long(1));
		LOGGER.debug("version object retrieved : (" + version.toString() + ")");
		return Response.status(200).entity(version).build();
	}

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "application/json" media type.
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
		LOGGER.debug("HelloWorld retrieved : (" + world + ")");
		return Response.status(200).entity(mapper.writeValueAsString(world)).build();
	}

}
