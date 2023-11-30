package com.example.movie_posters_app.ui_layer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.movie_posters_app.model.Movie

@Composable
fun MovieListScreen(viewModel: MovieViewModel = hiltViewModel(), onMovieClicked : (String) -> Unit) {

    val result = viewModel.movieList.value

    if (result.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    if (result.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = result.error)
        }
    }

    result.data?.let {
        LazyColumn {
            items(result.data!!) {
                MovieItem(it){
                    onMovieClicked(it.id.toString())
                }
            }
        }
    }

}

@Composable
fun MovieItem(it: Movie, onMovieClicked : () -> Unit) {
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w500/${it.poster_path}", contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp).clickable {
                onMovieClicked()
            }
            .padding(vertical = 4.dp), contentScale = ContentScale.Crop
    )
}