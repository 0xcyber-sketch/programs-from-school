package org.acme.service;

import org.acme.domain.PokemonCard;
import org.acme.interceptor.Cached;
import org.acme.persistance.Rep;
import org.acme.service.requests.CreatePokemonCardRequests;
import org.acme.service.response.CreatePokemonCardResponse;

import javax.enterprise.context.Dependent;
import java.util.List;

@Cached
@Dependent
public class PokemonCardService {

    private Rep rep;

    PokemonCardService(Rep rep) {
        this.rep = rep;
    }


    public List<PokemonCard> getPokemonCardList() {
        return rep.getPokemonCards();
    }

    public CreatePokemonCardResponse createPokemonCard(CreatePokemonCardRequests createPokemonCardRequests) {
        PokemonCard pc = (PokemonCard) (rep.createCard(createPokemonCardRequests.getPokemonCard()));
        return new CreatePokemonCardResponse(pc);
        //rep.createCard()
    }

}
