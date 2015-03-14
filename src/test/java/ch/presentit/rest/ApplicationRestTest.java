package ch.presentit.rest;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import ch.presentit.rest.ApplicationRest;

public class ApplicationRestTest extends JerseyTest {

	@Override
    protected Application configure() {
		return new ResourceConfig(ApplicationRest.class);
    }

	/**
     * Test to see that the app version is sent in the response.
     */
    @Test
    public void testVersion() {
        final String responseMsg = target().path("app/version").request().get(String.class);

        assertEquals("0.1", responseMsg);
    }
	
	/**
     * Test to see that the message "Hello Word!" is sent in the response.
     */
    @Test
    public void testHelloWorld() {
        final String responseMsg = target().path("app/helloworld").request().get(String.class);

        assertEquals("Hello World!", responseMsg);
    }
}
