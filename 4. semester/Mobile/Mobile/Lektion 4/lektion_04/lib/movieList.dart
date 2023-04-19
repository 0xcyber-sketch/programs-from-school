import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart' show rootBundle;
import 'package:lektion_04/movieRow.dart';
import 'movie.dart';

class MovieList extends StatefulWidget {
  const MovieList({Key? key}) : super(key: key);

  @override
  State<MovieList> createState() => _MovieListState();
}

class _MovieListState extends State<MovieList> {
  Future<List<Movie>> loadJSONData() async {
    List<Movie> movies = [];
    var jsonTxet = await rootBundle
        .loadString('assets/json/Movies.json'); // læs json fr filesystem
    //List<dynamic> movieList = json.decode(jsonTxet);
    List<dynamic> movieList = json.decode(jsonTxet);
    for (var element in movieList) {
      movies.add(Movie.fromJSON(element));
    }
    return movies;
  }

  // Don't do this this

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Movies'),
      ),
      body: FutureBuilder<List>(
        future: loadJSONData(),
        builder: (context, AsyncSnapshot<List> snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const CircularProgressIndicator();
          } else if (snapshot.connectionState == ConnectionState.done) {
            if (snapshot.hasError) {
              return const Text("Error");
            } else if (snapshot.hasData) {
              return ListView.builder(
                itemCount: snapshot.data?.length,
                itemBuilder: (context, index) {
                  return MovieRow(movie: snapshot.data?[index]);
                },
              );
            } else {
              return const Text("Empty dataset");
            }
          } else {
            return Text('State: + ${snapshot.connectionState}');
          }
        }, // Byg en future
      ),
    );
  }
}
