package com.vagonn.tmdbclient.data.repository.tvshow.datasource

import com.vagonn.tmdbclient.data.model.tvshow.TVShow

interface TVShowLocalDataSource {
    suspend fun getTvShowFromDB(): List<TVShow>
    suspend fun saveTvShowsToDB(tvShows: List<TVShow>)
    suspend fun clearAll()
}