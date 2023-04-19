package org.acme;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.acme.dto.CreatePerson;

import java.util.logging.Logger;

@Path("/")
public class Opgave1 {

    private static Logger LOG = Logger.getLogger("Opgave1");

    //@Produces(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    //@Consumes(MediaType.APPLICATION_JSON)
    @POST
    @Path("/posts")
    public String postRequest(CreatePerson p) {
        //CreatePerson person = new CreatePerson(p.name, p.age);
        LOG.info("Post created");
        return "200";
    }

    //@Produces(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    @Path("/test")
    public String test() {
        return "This is a test";
    }
}
