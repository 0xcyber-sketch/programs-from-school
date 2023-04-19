import 'dart:convert';
import 'dart:ffi';
import 'dart:io';

import 'package:path_provider/path_provider.dart';
import 'package:shared_preferences/shared_preferences.dart';

import 'movie.dart';

class FileService {
  addMovieListToDisk(List<Movie> movies) async {
    SharedPreferences sp = await SharedPreferences.getInstance();

    String key = "movies";
    final json = movies.map((e) => e.toJSON()).toList();

    sp.setString(key, jsonEncode(json));
  }

  Future<List<Movie>> getMovieListFromDisk() async {
    SharedPreferences sp = await SharedPreferences.getInstance();
    String _content = sp.getString('movies') ?? "";

    if (_content == "") {
      return [];
    }

    final List<dynamic> _jsonData = jsonDecode(_content);
    final List<Movie> _movies = _jsonData
        .map(
          (e) => Movie.fromJSON(e as Map<String, dynamic>),
        )
        .toList();
    return _movies;
  }

  /*
  FileService._privateConstructor();
  static final FileService instance = FileService._privateConstructor();

  static File? _file;
  static final _fileName = "movies.txt";

  Future<File> get file async {
    if (_file != null) return _file!;

    _file = await _initFile();
    return _file!;
  }

  Future<File> _initFile() async {
    final _directory = await getApplicationDocumentsDirectory();
    final _path = _directory.path;
    return File('$_path/$_fileName');
  }*/
}
