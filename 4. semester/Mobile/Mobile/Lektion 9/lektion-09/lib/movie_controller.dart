import 'package:flutter/foundation.dart';

import 'movie.dart';
import 'network_service.dart';
import 'FileService.dart';

class Movie_Controller extends ChangeNotifier {
  final FileService fs = FileService();
  List<Movie> _movies = [];

  _fetchJSON() async {
    List<Map<String, dynamic>> movies = await NetworkService.loadJSONData();
    for (var element in movies) {
      Movie m = Movie.fromJSON(element);
      _movies.add(m);
    }
    notifyListeners();
  }

  Movie_Controller() {
    getMoviesFRomDisk();
    //_fetchJSON();
  }

  getMoviesFRomDisk() async {
    List<Movie> content = await fs.getMovieListFromDisk();
    _movies = content;
  }

  List<Movie> get movieList {
    return _movies;
  }

  int get numberOfMovies {
    return _movies.length;
  }

  void addMovies(Movie m) {
    _movies.add(m);
    notifyListeners();
    fs.addMovieListToDisk(_movies);
  }
}
