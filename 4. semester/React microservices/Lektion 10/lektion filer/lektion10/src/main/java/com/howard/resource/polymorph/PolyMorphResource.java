package com.howard.resource.polymorph;

import com.howard.service.polymorph.BestPoly;
import com.howard.service.polymorph.PolyMorphService;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestScoped
@Path("/polys")
public class PolyMorphResource {

    @Inject
    Logger log;

    @BestPoly
    //@Named("PolyExtra")
    PolyMorphService service;

    @Inject
    public PolyMorphResource(PolyMorphService polyMorphService) {
        this.service = polyMorphService;
    }

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getPoly() {
        log.info("Customer resource getCustomers called on object " + this.toString());
        return service.getValues();
    }
}
