package com.example.movie_posters_app.di

import com.example.movie_posters_app.data.MovieDataSource
import com.example.movie_posters_app.data.MovieRepository
import com.example.movie_posters_app.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideDataSource(apiService: ApiService): MovieDataSource {
        return MovieDataSource(apiService)
    }

    @Provides
    fun provideMovieRepo(datasource: MovieDataSource): MovieRepository {
        return MovieRepository(datasource)
    }


}