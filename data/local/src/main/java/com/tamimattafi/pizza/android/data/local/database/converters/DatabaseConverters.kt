package com.tamimattafi.pizza.android.data.local.database.converters

import androidx.room.TypeConverter

object DatabaseConverters {
    private const val STRING_LIST_SEPARATOR = "|"

    @TypeConverter
    fun fromStringsList(list: List<String>) =
        list.joinToString(STRING_LIST_SEPARATOR)

    @TypeConverter
    fun toStringsList(string: String) =
        string.split(STRING_LIST_SEPARATOR)
}