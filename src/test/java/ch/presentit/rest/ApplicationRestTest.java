package ch.presentit.rest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.presentit.model.Version;
import ch.presentit.rest.ApplicationRest;

public class ApplicationRestTest extends JerseyTest {
	
	@Override
    protected Application configure() {
		ResourceConfig config = new ResourceConfig();
		config.register(ApplicationRest.class);
        config.property("contextConfigLocation", "classpath:testContext.xml");
        return config;
    }

	/**
     * Test to see that the app version is sent in the response.
	 * @throws IOException 
     */
    @Test
    public void testVersion() throws IOException {
        final String responseMsg = target().path("app/version").request().get(String.class);
        System.out.println(responseMsg);
        ObjectMapper mapper = new ObjectMapper();
        Version version = mapper.readValue(responseMsg, Version.class);
        assertEquals(version.getName(), "Present IT");
        assertEquals(version.getRelease(), "1.0.1");
        assertEquals(version.getLicense(), "MIT");
        assertEquals(version.getAuthor(), "Icepick & Winnefoo");
    }
	
	/**
     * Test to see that the message "Hello Word!" is sent in the response.
	 * @throws JsonProcessingException 
     */
    @Test
    public void testHelloWorld() throws JsonProcessingException {
        final String responseMsg = target().path("app/helloworld").request().get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString("Hello World!");
        assertEquals(json, responseMsg);
    }
}
