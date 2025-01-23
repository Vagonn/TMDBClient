package com.vagonn.tmdbclient.data.repository.tvshow.datasource

import com.vagonn.tmdbclient.data.model.tvshow.TVShow

interface TVShowCacheDataSource {
    suspend fun getTVShowsFromCache(): List<TVShow>
    suspend fun saveTVShowsToCache(tvShows: List<TVShow>)
}