package com.vagonn.tmdbclient.data.repository.tvshow.datasource

import com.vagonn.tmdbclient.data.model.tvshow.TVShowList
import retrofit2.Response

interface TVShowRemoteDataSource {
    suspend fun getTVShows(): Response<TVShowList>
}