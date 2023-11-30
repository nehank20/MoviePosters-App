package com.example.movie_posters_app.ui_layer

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie_posters_app.common.Resource
import com.example.movie_posters_app.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    val movieDetail = mutableStateOf(MutableMovieDetailStateHolder())

    init {

        movieDetail.value = MutableMovieDetailStateHolder(isLoading = true)

        viewModelScope.launch {
            savedStateHandle.getStateFlow("id","0").collectLatest{
                getMovieDetails(it)
            }
        }

    }

    fun getMovieDetails(id : String) = viewModelScope.launch {
        val result = movieRepository.getMovieDetails(id)
        when (result) {
            is Resource.Error -> {
                movieDetail.value = MutableMovieDetailStateHolder(error = result.message.toString())
            }

            is Resource.Success -> {
                movieDetail.value = MutableMovieDetailStateHolder(data = result.data)
            }

            else -> {

            }
        }
    }


}