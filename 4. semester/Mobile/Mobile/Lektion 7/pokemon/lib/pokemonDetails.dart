import 'package:flutter/material.dart';

import 'pokemon.dart';

class PokemonDetails extends StatelessWidget {
  const PokemonDetails({Key? key, required this.pokemon}) : super(key: key);

  final Pokemon pokemon;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text(pokemon.name)),
      body: Column(
          children: [pokemonIMG(pokemon), Text(pokemon.name.toUpperCase())]),
    );
  }

  pokemonIMG(Pokemon pokemon) {
    if (pokemon.img != null) {
      String temp = pokemon.img as String;
      return Image.network(temp);
    }
    return const Icon(Icons.image);
  }
}
