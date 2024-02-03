package org.idd.r2dbcexample

import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class SongService(
    private val songRepository: SongRepository
) {
    suspend fun getSongs(): List<SongResponse> {
        val songs = songRepository.findAll()
        return songs.map { SongResponse(it) }.toList()
    }

    suspend fun getSong(id: Long): SongResponse {
        val song = songRepository.findById(id) ?: throw IllegalArgumentException()
        return SongResponse(song)
    }

    suspend fun getSongCount(): Long {
        return songRepository.count()
    }

    suspend fun getSongCountByCategory(category: Song.Category): Long {
        return songRepository.countByCategory(category)
    }
}
