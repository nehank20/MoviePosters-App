package com.example.movie_posters_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movie_posters_app.ui_layer.MovieDetailsScreen
import com.example.movie_posters_app.ui_layer.MovieListScreen

@Composable
fun MovieNavigation(navController: NavHostController) {


    NavHost(navController = navController, startDestination = MovieNavigationItem.MovieList.route) {
        composable(MovieNavigationItem.MovieList.route) {
            MovieListScreen { id ->
                navController.navigate(MovieNavigationItem.MovieDetails.route + "/$id")
            }
        }

        composable(MovieNavigationItem.MovieDetails.route + "/{id}") {
            val id = it.arguments?.getString("id")
            MovieDetailsScreen()
        }
    }
}