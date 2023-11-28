package com.example.movie_posters_app.network

import com.example.movie_posters_app.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/movie/popular")
    suspend fun getMovies(
        @Query("api_key") apiKey : String
    ) : MovieListResponse

}