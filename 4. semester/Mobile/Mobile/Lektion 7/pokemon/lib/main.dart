import 'package:flutter/material.dart';
import 'package:pokemon/networkService.dart';
import 'package:provider/provider.dart';
import 'pokemonController.dart';
import 'pokemonList.dart';

void main() {
  runApp(
    ChangeNotifierProvider(
      create: ((context) => PokemonController()),
      child: const Pokemons(),
    ),
  );
}

class Pokemons extends StatelessWidget {
  const Pokemons({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Pokemons'.toUpperCase(),
      theme: ThemeData(primarySwatch: Colors.blue),
      home: const PokemonList(),
    );
  }
}
