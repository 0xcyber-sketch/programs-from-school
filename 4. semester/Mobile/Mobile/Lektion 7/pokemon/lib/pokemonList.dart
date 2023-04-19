import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'pokemon.dart';
import 'pokemonController.dart';
import 'package:loading_animations/loading_animations.dart';
import 'pokemonDetails.dart';
import 'typeService.dart';

class PokemonList extends StatelessWidget {
  const PokemonList({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Pokemons"),
      ),
      body: Consumer<PokemonController>(
          builder: (context, _pokemonController, widget) {
        if (context.read<PokemonController>().NumberOfPokemons < 50) {
          return LoadingFlipping.circle(
              borderColor: Colors.cyan,
              borderSize: 3.0,
              size: 30.0,
              backgroundColor: Colors.cyanAccent);
        } else {
          return ListView.builder(
              itemCount: _pokemonController.NumberOfPokemons,
              itemBuilder: (context, index) {
                final Pokemon pokemon = _pokemonController.pokemons[index];
                pokemon.fetchWeekness();
                return pokemonRow(context, pokemon);
              });
        }
      }),
    );
  }
}

pokemonRow(BuildContext context, Pokemon pokemon) {
  return Column(children: [
    Column(children: [
      GestureDetector(
          onTap: () => {
                Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => PokemonDetails(pokemon: pokemon)))
              },
          child: Container(
              margin: const EdgeInsets.all(10.0),
              decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(30),
                  color: const Color.fromARGB(255, 187, 187, 187)),
              child: pokemonIMG(pokemon))),
      const SizedBox(height: 2),
      Text(
        "#" + pokemon.dex.toString().padLeft(3, "0"),
        style: const TextStyle(
            fontWeight: FontWeight.bold,
            fontSize: 14,
            color: Color.fromARGB(255, 63, 63, 63)),
      ),
      const SizedBox(height: 4),
      Text(PokemonController.firstLetterCapital(pokemon.name),
          style: const TextStyle(
              fontWeight: FontWeight.bold, fontSize: 20, color: Colors.black)),
      const SizedBox(height: 4),
      Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: List.generate(
            pokemon.types.length,
            ((index) => Container(
                  padding: const EdgeInsets.fromLTRB(15, 4, 15, 4),
                  margin: const EdgeInsets.only(right: 5),
                  child: Text(
                      PokemonController.firstLetterCapital(
                          pokemon.types[index]),
                      style: const TextStyle(
                          fontWeight: FontWeight.bold,
                          fontSize: 14,
                          color: Colors.white)),
                  decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(5),
                      color: Color(int.parse(typeService()
                          .convertTypeToColor(pokemon.types[index])))),
                )),
          )),
      const SizedBox(height: 4),
    ])
  ]);
}

pokemonIMG(Pokemon pokemon) {
  if (pokemon.img != null) {
    String temp = pokemon.img as String;
    return Image.network(temp);
  }
  return const Icon(Icons.image);
}
