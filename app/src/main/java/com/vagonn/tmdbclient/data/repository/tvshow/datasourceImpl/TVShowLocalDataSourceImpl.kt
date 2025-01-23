package com.vagonn.tmdbclient.data.repository.tvshow.datasourceImpl

import com.vagonn.tmdbclient.data.db.TVShowDao
import com.vagonn.tmdbclient.data.model.tvshow.TVShow
import com.vagonn.tmdbclient.data.repository.tvshow.datasource.TVShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImpl(private val tvShowDao: TVShowDao) : TVShowLocalDataSource {
    override suspend fun getTvShowFromDB(): List<TVShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvshows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvshows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}