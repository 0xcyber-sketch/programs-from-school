import 'package:flutter/material.dart';
import 'package:lektion_04/movie.dart';

class Details extends StatelessWidget {
  final Movie movie;
  const Details({Key? key, required this.movie}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text(movie.title),
        ),
        body: Container(
          padding: const EdgeInsets.fromLTRB(16, 8, 16, 8),
          child: Column(
            children: [
              Row(
                children: [
                  Container(
                    child: ClipRRect(
                      child: Image.asset("assets/images/${movie.poster}.jpg",
                          width: 110),
                      borderRadius: const BorderRadius.all(Radius.circular(12)),
                    ),
                    decoration: const BoxDecoration(
                        borderRadius: BorderRadius.all(Radius.circular(20)),
                        boxShadow: [
                          BoxShadow(
                              color: Colors.blueGrey,
                              offset: Offset(1.0, 1.0),
                              blurRadius: 7.0,
                              spreadRadius: 1.0),
                          BoxShadow(
                              color: Colors.white,
                              offset: Offset(0.0, 0.0),
                              blurRadius: 0.0,
                              spreadRadius: 0.0)
                        ]),
                  ),
                  Expanded(
                      child: Container(
                    padding: const EdgeInsets.only(left: 10),
                    child: Column(
                      children: [
                        Text(movie.year + ", " + movie.country),
                        const SizedBox(height: 3),
                        Text(movie.genre),
                        const SizedBox(height: 3),
                        Text(movie.runtime),
                        const SizedBox(height: 3),
                        Text(movie.awards),
                      ],
                    ),
                  )),
                  FavoriteMovie(movie: movie),
                ],
              ),
              const SizedBox(height: 15),
              Column(
                children: [
                  const Text("Directed by:"),
                  const SizedBox(height: 8),
                  Text(
                    movie.director,
                    style: const TextStyle(fontWeight: FontWeight.bold),
                  ),
                  const SizedBox(height: 8),
                  const Text("Actors:"),
                  const SizedBox(height: 8),
                  Text(movie.actors,
                      style: const TextStyle(fontWeight: FontWeight.bold)),
                  const SizedBox(height: 12),
                  const Divider(),
                  const SizedBox(height: 8),
                  Text(movie.plot)
                ],
              )
            ],
          ),
        ));
  }
}

class FavoriteMovie extends StatefulWidget {
  final Movie movie;

  const FavoriteMovie({Key? key, required this.movie}) : super(key: key);

  @override
  State<FavoriteMovie> createState() => _FavoriteMovieState();
}

class _FavoriteMovieState extends State<FavoriteMovie> {
  @override
  Widget build(BuildContext context) {
    if (widget.movie.favorite) {
      return IconButton(
          onPressed: () => {
                setState(() {
                  widget.movie.changeFavorite();
                })
              },
          icon: const Icon(Icons.favorite, color: Colors.red));
    } else {
      return IconButton(
          onPressed: () => {
                setState(
                  () {
                    widget.movie.changeFavorite();
                  },
                )
              },
          icon: const Icon(Icons.favorite_border));
    }
  }
}
