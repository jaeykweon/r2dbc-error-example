package org.idd.r2dbcexample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SongController(
    private val songService: SongService
) {
    @GetMapping("/songs")
    suspend fun getSongs(
        @RequestParam category: Song.Category?
    ): List<SongResponse> {
        return songService.getSongs()
    }

    @GetMapping("/songs/{id}")
    suspend fun getSong(@PathVariable id: Long): SongResponse {
        return songService.getSong(id)
    }

    @GetMapping("/songs/count")
    suspend fun getSongsCount(
        @RequestParam category: Song.Category?
    ): Long {
        return if (category != null) {
            songService.getSongCountByCategory(category)
        } else {
            songService.getSongCount()
        }
    }

    @GetMapping("/songs/exists")
    suspend fun existsByCategory(
        @RequestParam category: Song.Category
    ): Boolean {
        return songService.existsByCategory(category)
    }
}
