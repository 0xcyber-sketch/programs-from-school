package org.acme.ressource;

import org.acme.domain.PokemonCard;
import org.acme.service.PokemonCardService;
import org.acme.service.requests.CreatePokemonCardRequests;
import org.jboss.logging.annotations.Pos;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/pokemon")
public class PokemonCardRessorce {

    private PokemonCardService service;

    @Inject
    PokemonCardRessorce(PokemonCardService service) {
        this.service = service;
    }

    @Path("/allcards")
    @Consumes(MediaType.APPLICATION_JSON)
    @GET
    public Response AllCards() {

    return Response.ok().entity(service.getPokemonCardList()).build();
    }

    @Path("/create-pokemon")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response CreatePokemon(CreatePokemonCardRequests requests) {
return null;
    }
}
