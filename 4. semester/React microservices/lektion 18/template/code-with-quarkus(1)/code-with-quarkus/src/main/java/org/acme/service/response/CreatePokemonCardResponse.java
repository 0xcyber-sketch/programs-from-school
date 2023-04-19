package org.acme.service.response;

import org.acme.domain.PokemonCard;

public class CreatePokemonCardResponse {
    final private PokemonCard pokemonCard;

    public  CreatePokemonCardResponse(PokemonCard pokemonCard) {
        this.pokemonCard =pokemonCard;
    }

    public PokemonCard getPokemonCard() {
        return pokemonCard;
    }
}
