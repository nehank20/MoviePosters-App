package com.example.movie_posters_app.ui_layer

import com.example.movie_posters_app.model.Movie
import com.example.movie_posters_app.model.MovieDetails

class MutableMovieDetailStateHolder(
    var isLoading: Boolean = false,
    var data: MovieDetails? = null,
    var error: String = ""
) {
}