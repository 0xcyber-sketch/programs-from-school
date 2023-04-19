import 'package:flutter/material.dart';
import 'package:lektion_6/pokemon.dart';

class PokemonDetails extends StatelessWidget {
  const PokemonDetails({Key? key, required this.pokemon}) : super(key: key);

  final Pokemon pokemon;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text(pokemon.name)),
      body: Column(children: [
        FutureBuilder(
          future: pokemon.fetchImageURL(),
          builder: (context, AsyncSnapshot<String> snapshot) {
            if (snapshot.hasData) {
              return Image(image: NetworkImage(snapshot.data as String));
            } else {
              return const Icon(Icons.image);
            }
          },
        ),
        Text(pokemon.name.toUpperCase())
      ]),
    );
  }
}
