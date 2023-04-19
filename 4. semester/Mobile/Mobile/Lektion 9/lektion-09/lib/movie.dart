class Movie {
  String title;
  String year;
  String runtime;
  String genre;
  String director;
  String actors;
  String plot;
  String country;
  String awards;
  String poster;

  bool favorite = false;

  Movie(this.title, this.year, this.runtime, this.genre, this.director,
      this.actors, this.plot, this.country, this.awards, this.poster);

// Named constructor function (Global/local)
// Add factory if this should return other than movies
  Movie.fromJSON(Map<String, dynamic> json)
      : title = json["title"],
        year = json["year"],
        runtime = json["runtime"],
        genre = json["genre"],
        director = json["director"],
        actors = json["actors"],
        plot = json["plot"],
        country = json["country"],
        awards = json["awards"],
        poster = json["poster"];
  // Initializer list starter før alt andet startes
  void changeFavorite() {
    favorite = !favorite;
  }

  Map<String, dynamic> toJSON() {
    return {
      'title': title,
      'year': year,
      'runtime': runtime,
      'genre': genre,
      'director': director,
      'actors': actors,
      'plot': plot,
      'country': country,
      'awards': awards,
      'poster': poster,
      'farvorite': favorite
    };
  }
}
