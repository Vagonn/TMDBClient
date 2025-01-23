package com.vagonn.tmdbclient.data.repository.artist.datasourceImpl

import com.vagonn.tmdbclient.data.api.TMDBService
import com.vagonn.tmdbclient.data.model.artist.ArtistList
import com.vagonn.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}