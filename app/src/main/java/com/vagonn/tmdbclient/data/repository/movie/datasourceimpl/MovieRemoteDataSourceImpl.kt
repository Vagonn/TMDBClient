package com.vagonn.tmdbclient.data.repository.movie.datasourceimpl

import com.vagonn.tmdbclient.data.api.TMDBService
import com.vagonn.tmdbclient.data.model.movie.MovieList
import com.vagonn.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}