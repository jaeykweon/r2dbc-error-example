package org.idd.r2dbcexample

import io.r2dbc.spi.Row
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter

@ReadingConverter
class SongReadConverter: Converter<Row, Song> {
    override fun convert(source: Row): Song {
        val category = Song.Category.fromRubyString(source.get("category") as String)
        return Song(
            pk = source.get("pk") as Long,
            title = source.get("title") as String,
            artist = source.get("artist") as String,
            category = category
        )
    }
}