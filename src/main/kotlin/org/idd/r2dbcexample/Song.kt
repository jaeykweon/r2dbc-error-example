package org.idd.r2dbcexample

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("song")
data class Song(
    @Id
    val pk: Long,
    val title: String,
    val artist: String,
    val category: Category
) {
    enum class Category(val rubyValue: String) {
        ELECTRONIC("SONG::ELECTRONIC"),
        RAP("SONG::RAP"),
        BALLAD("SONG::BALLAD"),
        ETC("SONG::ETC")
        ;
        companion object {
            fun fromRubyString(ruby: String): Category {
                return entries.first { it.rubyValue == ruby }
            }
        }
    }
}
