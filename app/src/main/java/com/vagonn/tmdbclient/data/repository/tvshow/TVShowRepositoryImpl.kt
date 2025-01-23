package com.vagonn.tmdbclient.data.repository.tvshow

import android.util.Log
import com.vagonn.tmdbclient.data.model.tvshow.TVShow
import com.vagonn.tmdbclient.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.vagonn.tmdbclient.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.vagonn.tmdbclient.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.vagonn.tmdbclient.domain.repository.TvShowRepository

class TVShowRepositoryImpl(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowCacheDataSource: TVShowCacheDataSource,
) : TvShowRepository {
    override suspend fun getTvShows(): List<TVShow>? {
        return getTVShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TVShow>? {
        val newListOfTVShows = getTVShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTVShows)
        tvShowCacheDataSource.saveTVShowsToCache(newListOfTVShows)
        return newListOfTVShows
    }

    suspend fun getTVShowsFromAPI(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>

        try {
            val response = tvShowRemoteDataSource.getTVShows()
            val body = response.body()

            if (body != null) {
                tvShowList = body.tvShows
            }

        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return tvShowList
    }

    suspend fun getTVShowsFromDB(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShowFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTVShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTVShowsFromCache(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>

        try {
            tvShowList = tvShowCacheDataSource.getTVShowsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTVShowsFromDB()
            tvShowCacheDataSource.saveTVShowsToCache(tvShowList)
        }

        return tvShowList
    }
}