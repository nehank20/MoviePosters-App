package com.example.movie_posters_app.ui_layer

import com.example.movie_posters_app.model.Movie

class MutableMovieStateHolder(
    var isLoading: Boolean = false,
    var data: List<Movie>? = null,
    var error: String = ""
) {
}