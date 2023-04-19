import 'package:flutter/material.dart';
import 'package:lektion_04/details.dart';

import 'movie.dart';

class MovieRow extends StatelessWidget {
  final Movie movie;
  const MovieRow({Key? key, required this.movie}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.fromLTRB(16, 8, 16, 8),
      child: Row(
        children: [
          Container(
            child: ClipRRect(
              child:
                  Image.asset("assets/images/${movie.poster}.jpg", width: 110),
              borderRadius: const BorderRadius.all(Radius.circular(12)),
            ),
            decoration: const BoxDecoration(
                borderRadius: BorderRadius.all(Radius.circular(20)),
                boxShadow: [
                  BoxShadow(
                      color: Colors.blueGrey,
                      offset: Offset(8.0, 5.0),
                      blurRadius: 10.0,
                      spreadRadius: 1.5),
                  BoxShadow(
                      color: Colors.white,
                      offset: Offset(0.0, 0.0),
                      blurRadius: 0.0,
                      spreadRadius: 0.0)
                ]),
          ),
          Expanded(
              child: Container(
            padding: const EdgeInsets.only(left: 16),
            child:
                Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
              GestureDetector(
                onTap: () => {
                  Navigator.push(
                      context,
                      MaterialPageRoute(
                          builder: (context) => Details(movie: movie)))
                },
                child: Text(
                  movie.title,
                  style: const TextStyle(
                      fontWeight: FontWeight.bold, fontSize: 24),
                ),
              ),
              const SizedBox(height: 4),
              Text(movie.genre),
              const SizedBox(height: 3),
              Text(movie.runtime)
            ]),
          )),
          const Icon(
            Icons.favorite_border,
            color: Color.fromARGB(255, 0, 0, 0),
          )
        ],
      ),
    );

    /*return ListTile(
        leading: Image.asset(
          "assets/images/${movie.poster}.jpg",
          width: 110,
        ),
        title: Text(movie.title),
        subtitle: Text(movie.genre),
        trailing: IconButton(
          onPressed: () {},
          icon: const Icon(Icons.info),
        ));
  }*/
  }
}
