package org.idd.r2dbcexample

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("song")
data class Song(
    @Id
    val pk: Long,
    val title: String,
    val artist: String,
    private val categoryValue: String
) {
    val category = Category.fromString(categoryValue)

    enum class Category {
        ELECTRONIC,
        RAP,
        BALLAD,
        ETC
        ;

        companion object {
            fun fromString(input: String): Category {
                return entries.first { it.name == input }
            }
        }
    }
}
