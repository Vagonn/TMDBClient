package com.vagonn.tmdbclient.data

import com.google.gson.annotations.SerializedName

data class TVShowList(
    @SerializedName("results")
    val results: List<TVShow>
)
