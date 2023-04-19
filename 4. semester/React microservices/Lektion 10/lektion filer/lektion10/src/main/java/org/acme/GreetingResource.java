package org.acme;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    Logger log;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        log.info("Hello RESTEasy");
        return "Hello RESTEasy";
    }
}