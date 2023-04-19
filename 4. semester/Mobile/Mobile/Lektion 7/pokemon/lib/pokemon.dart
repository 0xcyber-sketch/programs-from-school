import 'networkService.dart';

class Pokemon {
  final String name;
  final int dex;
  final List<String> abilities;
  final int height;
  final List<String> types;
  final int weight;
  String? img;
  List<String>? typeWeakness;

  NetworkService networkService = NetworkService();

  Pokemon(
      {required this.name,
      required this.dex,
      required this.height,
      required this.weight,
      required this.types,
      required this.abilities,
      this.img,
      this.typeWeakness});

  factory Pokemon.fromJSON(Map<String, dynamic> json) {
    List<String> types = [];
    List<String> abilities = [];
    types.add(json['types'][0]['type']['name']);

    abilities.add(json['abilities'][0]['ability']['name']);
    if (json['types'].length > 1) {
      types.add(json['types'][1]['type']['name']);
    }
    if (json['abilities'].length > 1) {
      abilities.add(json['abilities'][1]['ability']['name']);
    }
    String img = "";
    try {
      img = json['sprites']['other']['official-artwork']['front_default'];
    } catch (e) {
      if (json['sprites']['front_default'] == null) {
        img = "";
      } else {
        img = json['sprites']['front_default'];
      }
    }

    return Pokemon(
        name: json['name'],
        dex: json['id'],
        height: json['height'],
        weight: json['weight'],
        types: types,
        abilities: abilities,
        img: img);
  }

  List<String> get abillities {
    return abilities;
  }

  void fetchWeekness() async {
    typeWeakness = [];
    Map<String, dynamic> json = networkService.fetchJSONFrom(url: typePath);

    print(json);
  }
}
