package com.vagonn.tmdbclient.data.repository.artist

import android.util.Log
import com.vagonn.tmdbclient.data.model.artist.Artist
import com.vagonn.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.vagonn.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.vagonn.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.vagonn.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistsRemoteDataSource: ArtistRemoteDataSource,
    private val artistsLocalDataSource: ArtistLocalDataSource,
    private val artistsCacheDataSource: ArtistCacheDataSource,
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistsLocalDataSource.clearAll()
        artistsLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistsCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistsRemoteDataSource.getArtists()
            val body = response.body()

            if (body != null) {
                artistList = body.artists
            }

        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistsLocalDataSource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistsLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistsLocalDataSource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistsCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList
    }
}