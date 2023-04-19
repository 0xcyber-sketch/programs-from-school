package org.acme.ressource;

import org.acme.ressource.dto.CarDTO;
import org.acme.ressource.dto.CreateCarDTO;
import org.acme.ressource.dto.UpdateCarDTO;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/cars")
public class CarResource {


    @Inject
    Logger logger;
    // CarResource is ApplicationScoped that's why this array persists
    //hack  man skal ikke gemme data her
    private  List<CarDTO> cars = new ArrayList<>();

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<CarDTO> getCars()
    {
        logger.info("calling getCArs");
        return cars;
    }
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{sn}")
    public CarDTO getCar(@PathParam("sn") String sn) {
        logger.info("calling getCAr");
        return cars.stream()
                .filter(car -> car.getSerialNumber().equals(sn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("No car with serial %s", sn)));
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public CarDTO createCar(CreateCarDTO createCarDTO) {
        String serial = Integer.toString(cars.size() + 1);
        CarDTO car = new CarDTO(serial, createCarDTO.getType(), createCarDTO.getModel(), createCarDTO.getProductionYear(), createCarDTO.getStatus());
        cars.add(car);
        return car;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    @Path("/{sn}")
    public CarDTO updateCar(@PathParam("sn") String sn, UpdateCarDTO updateCarDTO) {
        CarDTO carDTO = cars.stream()
                .filter(car -> car.getSerialNumber().equals(sn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("No car with serial %s", sn)));
        cars.remove(carDTO);
        CarDTO car = new CarDTO(sn, updateCarDTO.getModel(), updateCarDTO.getType(), updateCarDTO.getProductionYear(), updateCarDTO.getStatus());
        cars.add(car);
        return car;
    }
}
