package com.vagonn.tmdbclient.data.api

import com.vagonn.tmdbclient.data.model.artist.ArtistList
import com.vagonn.tmdbclient.data.model.movie.MovieList
import com.vagonn.tmdbclient.data.model.tvshow.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(@Query("api_key") apiKey: String): Response<TVShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String): Response<ArtistList>
}