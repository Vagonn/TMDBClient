package com.vagonn.tmdbclient.data.repository.tvshow.datasourceImpl

import com.vagonn.tmdbclient.data.api.TMDBService
import com.vagonn.tmdbclient.data.model.tvshow.TVShowList
import com.vagonn.tmdbclient.data.repository.tvshow.datasource.TVShowRemoteDataSource
import retrofit2.Response

class TVShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TVShowRemoteDataSource {
    override suspend fun getTVShows(): Response<TVShowList> {
        return tmdbService.getPopularTVShows(apiKey)
    }
}
