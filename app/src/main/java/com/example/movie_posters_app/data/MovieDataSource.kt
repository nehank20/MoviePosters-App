package com.example.movie_posters_app.data

import com.example.movie_posters_app.network.ApiService

class MovieDataSource(private  val apiService: ApiService) {

    suspend fun getMoviesList() = apiService.getMovies(API_KEY)

    suspend fun getMovieDetails(id: String) = apiService.getMovieDetails(id, API_KEY)
}

const val API_KEY = "db36dcf5ff1d3d43758acfcfa3376bbf"