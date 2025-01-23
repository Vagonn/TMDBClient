package com.vagonn.tmdbclient.data.repository.tvshow.datasourceImpl

import com.vagonn.tmdbclient.data.model.tvshow.TVShow
import com.vagonn.tmdbclient.data.repository.tvshow.datasource.TVShowCacheDataSource

class TVShowCacheDataSourceImpl : TVShowCacheDataSource {
    private var tvShowList = ArrayList<TVShow>()

    override suspend fun getTVShowsFromCache(): List<TVShow> {
        return tvShowList
    }

    override suspend fun saveTVShowsToCache(tvShows: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}