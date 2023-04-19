// view model

import 'package:flutter/foundation.dart';
import 'package:lektion_6/network_service.dart';
import 'package:lektion_6/pokemon.dart';

class PokemonController extends ChangeNotifier {
  List<Pokemon> _pokemons = [];
  final NetworkService _networkService = NetworkService();

  static const String JSONPokemonURL =
      'https://pokeapi.co/api/v2/pokemon/?limit=50';

  _fetchJSON() async {
    dynamic json = await _networkService.fetchJSONFrom(url: JSONPokemonURL);
    List<dynamic> JSONPokemons = json['results'];
    for (int i = 0; i < JSONPokemons.length; i++) {
      var pokemon = JSONPokemons[i];
      _pokemons.add(Pokemon.fromJSON(pokemon));
    }
    notifyListeners();
  }

  PokemonController() {
    _fetchJSON();
  }

  int get numberOfPokemons {
    return _pokemons.length;
  }

  List<Pokemon> get pokemons {
    return _pokemons;
  }
}
