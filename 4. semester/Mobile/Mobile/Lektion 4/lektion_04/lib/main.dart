import 'package:flutter/material.dart';

import 'movieList.dart';

void main() {
  runApp(const Movies());
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
