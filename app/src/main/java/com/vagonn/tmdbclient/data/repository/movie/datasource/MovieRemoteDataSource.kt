package com.vagonn.tmdbclient.data.repository.movie.datasource

import com.vagonn.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}