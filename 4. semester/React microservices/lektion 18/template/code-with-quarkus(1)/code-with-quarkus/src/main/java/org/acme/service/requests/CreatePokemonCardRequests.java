package org.acme.service.requests;

import org.acme.domain.PokemonCard;

public class CreatePokemonCardRequests {
    private int ID;
    private int height;
    private int width;
    private String name;
    private String description;
    private String elementType;
    private boolean EX;
    private int powerPoints;
    private PokemonCard pokemonCard;

    public CreatePokemonCardRequests(String ID, String height, String width, String name, String description, String elementType, String Ex, String powerPoints) {
        this.pokemonCard = new PokemonCard(Integer.parseInt(ID), name, Integer.parseInt(height), Integer.parseInt(width), description, elementType, Boolean.parseBoolean(Ex), Integer.parseInt(powerPoints));
    }

    public PokemonCard getPokemonCard() {
        return pokemonCard;
    }
}
