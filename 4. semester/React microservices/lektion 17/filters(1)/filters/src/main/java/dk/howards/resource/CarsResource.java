package dk.howards.resource;

import dk.howards.resource.dto.CarDTO;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Arrays;
import java.util.List;

@Path("/cars")
public class CarsResource {

    private final Logger logger;

    @Inject
    public CarsResource(Logger logger) {
        this.logger = logger;
    }

    @GET
    public List<CarDTO> getCars() {
        return Arrays.asList(
                new CarDTO("12345", "opel", "astra", 1988),
                new CarDTO("12346", "audi", "a4", 2016)
        );
    }
}
