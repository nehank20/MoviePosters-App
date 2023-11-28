package com.example.movie_posters_app.data

import com.example.movie_posters_app.network.ApiService

class MovieDataSource(private  val apiService: ApiService) {

    suspend fun getMoviesList() = apiService.getMovies("db36dcf5ff1d3d43758acfcfa3376bbf")
}