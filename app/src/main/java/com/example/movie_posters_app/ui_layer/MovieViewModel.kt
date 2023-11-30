package com.example.movie_posters_app.ui_layer

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie_posters_app.common.Resource
import com.example.movie_posters_app.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    val movieList = mutableStateOf(MutableMovieStateHolder())

    init {
        movieList.value = MutableMovieStateHolder(isLoading = true)
        getMovies()
    }

    private fun getMovies() = viewModelScope.launch {
        when (val result = repository.getMovies()) {
            is Resource.Success -> {
                movieList.value  = MutableMovieStateHolder(data = result.data)
            }

            is Resource.Error -> {
                movieList.value = MutableMovieStateHolder(error = result.message.toString())
            }

            else -> {

            }
        }
    }

}