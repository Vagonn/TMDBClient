package com.vagonn.tmdbclient.domain.usecase

import com.vagonn.tmdbclient.data.model.movie.Movie
import com.vagonn.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}