import 'package:flutter/material.dart';
import 'package:lektion_6/pokemon_list.dart';
import 'pokemon_controller.dart';
import 'package:provider/provider.dart';

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
      title: 'Pokemons',
      theme: ThemeData(primarySwatch: Colors.teal),
      home: const PokemonList(),
    );
  }
}
