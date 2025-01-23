package com.vagonn.tmdbclient.domain.usecase

import com.vagonn.tmdbclient.data.model.artist.Artist
import com.vagonn.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}