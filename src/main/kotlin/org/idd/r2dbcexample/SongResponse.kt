package org.idd.r2dbcexample

data class SongResponse(
    val pk: Long,
    val title: String,
    val artist: String,
    val category: Song.Category
) {
    constructor(song: Song) : this(
        pk = song.pk,
        title = song.title,
        artist = song.artist,
        category = song.category
    )
}