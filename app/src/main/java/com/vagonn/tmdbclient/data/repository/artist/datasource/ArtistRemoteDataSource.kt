package com.vagonn.tmdbclient.data.repository.artist.datasource

import com.vagonn.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}