package com.vagonn.tmdbclient.data

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Movie>
)