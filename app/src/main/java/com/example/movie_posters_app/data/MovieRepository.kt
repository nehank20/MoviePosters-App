package com.example.movie_posters_app.data

import com.example.movie_posters_app.common.Resource
import com.example.movie_posters_app.model.Movie
import com.example.movie_posters_app.model.MovieDetails
import retrofit2.Response

class MovieRepository(private val movieDataSource: MovieDataSource) {

    suspend fun getMovies() : Resource<List<Movie>> {
        return try {
            Resource.Success(data = movieDataSource.getMoviesList().results)
        }catch (ex: Exception){
            Resource.Error(message = ex.message.toString())
        }
    }

    suspend fun getMovieDetails(id: String) : Resource<MovieDetails> {
        return try {
            Resource.Success(data = movieDataSource.getMovieDetails(id))
        }catch (ex: Exception){
            Resource.Error(message = ex.message.toString())
        }
    }
}