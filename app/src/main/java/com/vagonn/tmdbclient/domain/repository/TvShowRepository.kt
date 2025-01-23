package com.vagonn.tmdbclient.domain.repository

import com.vagonn.tmdbclient.data.model.tvshow.TVShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TVShow>?
    suspend fun updateTvShows(): List<TVShow>?
}