import 'package:flutter/foundation.dart';
import 'package:pokemon/pokemon.dart';

import 'networkService.dart';

class PokemonController extends ChangeNotifier {
  final NetworkService _networkService = NetworkService();
  final Map<String, Map<String, dynamic>> cachedUrl = new Map();
  final List<Pokemon> _pokemonList = [];
  static const String JSONPokemonURL =
      'https://pokeapi.co/api/v2/pokemon/?limit=1126';

  PokemonController() {
    _fetchJSON();
  }

  _fetchJSON() async {
    //if (cachedUrl)
    Map<String, dynamic> json =
        await _networkService.fetchJSONFrom(url: JSONPokemonURL);

    //json['results'].length
    for (int i = 0; i < 100; i++) {
      String url = json['results'][i]['url'];
      Map<String, dynamic> JSONPokemon =
          await _networkService.fetchJSONFrom(url: url);
      try {
        cachedUrl["${json[url]}"] = JSONPokemon;
      } catch (e) {}
      _pokemonList.add(Pokemon.fromJSON(JSONPokemon));
    }
    notifyListeners();
  }

  int get NumberOfPokemons {
    return _pokemonList.length;
  }

  List<Pokemon> get pokemons {
    return _pokemonList;
  }

  static String firstLetterCapital(String s) {
    return "${s[0].toUpperCase()}${s.substring(1).toLowerCase()}";
  }
}
