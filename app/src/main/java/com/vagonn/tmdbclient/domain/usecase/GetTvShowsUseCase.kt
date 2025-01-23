package com.vagonn.tmdbclient.domain.usecase

import com.vagonn.tmdbclient.data.model.tvshow.TVShow
import com.vagonn.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute() : List<TVShow>? = tvShowRepository.getTvShows();
}