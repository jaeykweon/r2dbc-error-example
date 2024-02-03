package org.idd.r2dbcexample

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface SongRepository: CoroutineCrudRepository<Song, Long> {
    suspend fun countByCategory(category: Song.Category): Long
    suspend fun existsByCategory(category: Song.Category): Boolean
}
