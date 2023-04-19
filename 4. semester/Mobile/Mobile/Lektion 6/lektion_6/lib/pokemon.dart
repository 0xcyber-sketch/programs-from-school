import 'package:lektion_6/network_service.dart';
import 'package:lektion_6/pokemon_controller.dart';

class Pokemon {
  final String name;
  final String url;
  //final String type;
  bool favorite = false;

  static final NetworkService _networkService = NetworkService();

  Pokemon({required this.name, required this.url});

  // kan returnerer null
  factory Pokemon.fromJSON(Map<String, dynamic> json) {
    return Pokemon(name: json['name'], url: json['url']);
  }

  Future<String> fetchImageURL() async {
    var JSONData = await _networkService.fetchJSONFrom(url: url);

    return JSONData['sprites']['front_default'];
  }
}
