import 'package:flutter/material.dart';
import 'package:lektion_04/movie.dart';
import 'package:provider/provider.dart';

import 'movie_controller.dart';

class createMovieForm extends StatefulWidget {
  const createMovieForm({Key? key}) : super(key: key);

  @override
  State<createMovieForm> createState() => _createMovieFormState();
}

class _createMovieFormState extends State<createMovieForm> {
  final _formKey = GlobalKey<FormState>();
  final Movie movie = Movie("", "", "", "", "", "", "", "", "", "No Movie");
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Create movie"),
        centerTitle: true,
      ),
      body: Form(
          key: _formKey,
          child: Column(
            children: [
              TextFormField(
                  decoration: const InputDecoration(labelText: "Title"),
                  onSaved: (value) => setState(() => movie.title = value!),
                  validator: (value) {
                    validateEmpty(value, "Title");
                  }),
              TextFormField(
                  decoration: const InputDecoration(labelText: "Year"),
                  onSaved: (value) => setState(() => movie.year = value!),
                  validator: (value) {
                    validateEmpty(value, "Year");
                  }),
              TextFormField(
                  decoration: const InputDecoration(labelText: "Runtime"),
                  onSaved: (value) => setState(() => movie.runtime = value!),
                  validator: (value) {
                    validateEmpty(value, "Runtime");
                  }),
              TextFormField(
                  decoration: const InputDecoration(labelText: "Genre"),
                  onSaved: (value) => setState(() => movie.genre = value!),
                  validator: (value) {
                    validateEmpty(value, "Genre");
                  }),
              TextFormField(
                  decoration: const InputDecoration(labelText: "Director"),
                  onSaved: (value) => setState(() => movie.director = value!),
                  validator: (value) {
                    validateEmpty(value, "Director");
                  }),
              TextFormField(
                  decoration: const InputDecoration(labelText: "Actors"),
                  onSaved: (value) => setState(() => movie.actors = value!),
                  validator: (value) {
                    validateEmpty(value, "Actors");
                  }),
              TextFormField(
                  decoration: const InputDecoration(labelText: "Plot"),
                  onSaved: (value) => setState(() => movie.plot = value!),
                  validator: (value) {
                    validateEmpty(value, "Plot");
                  }),
              TextFormField(
                  decoration: const InputDecoration(labelText: "Country"),
                  onSaved: (value) => setState(() => movie.country = value!),
                  validator: (value) {
                    validateEmpty(value, "Country");
                  }),
              TextFormField(
                  decoration: const InputDecoration(labelText: "Awards"),
                  onSaved: (value) => setState(() => movie.awards = value!),
                  validator: (value) {
                    validateEmpty(value, "Awards");
                  }),
              ElevatedButton(
                  onPressed: () {
                    final form = _formKey.currentState;
                    if (form!.validate()) {
                      form.save();
                      Provider.of<Movie_Controller>(context, listen: false)
                          .addMovies(movie);
                      Navigator.pop(context);
                    }
                  },
                  child: const Text("Submit"))
            ],
          )),
    );
  }
}

validateEmpty(dynamic value, String textFieldName) {
  if (value.isEmpty) {
    return 'Enter text in ' + textFieldName;
  }
  return null;
}
