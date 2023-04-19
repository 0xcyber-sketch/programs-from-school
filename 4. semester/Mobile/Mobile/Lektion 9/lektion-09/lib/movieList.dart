import 'package:flutter/material.dart';
import 'package:lektion_04/movieRow.dart';
import 'package:lektion_04/movie_controller.dart';
import 'package:provider/provider.dart';
import 'create_movie.dart';
import 'movie.dart';

class MovieList extends StatefulWidget {
  const MovieList({Key? key}) : super(key: key);

  @override
  State<MovieList> createState() => _MovieListState();
}

class _MovieListState extends State<MovieList> {
  //Future<List<Movie>>

  // Don't do this this

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Movies'),
          actions: <Widget>[
            FloatingActionButton(
              onPressed: () => {
                Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => const createMovieForm()))
              },
            )
          ],
        ),
        body: Consumer<Movie_Controller>(
            builder: (context, _movieController, widget) {
          return ListView.builder(
              itemCount: _movieController.numberOfMovies,
              itemBuilder: (context, index) {
                final Movie movie = _movieController.movieList[index];
                return MovieRow(movie: movie);
              });
        }));
  }
}
