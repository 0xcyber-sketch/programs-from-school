import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'movieList.dart';
import 'movie_controller.dart';

void main() {
  runApp(ChangeNotifierProvider(
    create: (context) => Movie_Controller(),
    child: const Movies(),
  ));
}

class Movies extends StatelessWidget {
  const Movies({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Movies',
      theme: ThemeData(primaryColor: Colors.blue),
      home: const MovieList(),
    );
  }
}
