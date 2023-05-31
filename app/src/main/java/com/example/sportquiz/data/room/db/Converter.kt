package com.example.sportquiz.data.room.db

import androidx.room.TypeConverter

class Converter {
    @TypeConverter
    fun fromAnswersList(value: List<String>): String {
        return value.joinToString(",")
    }

    @TypeConverter
    fun toAnswersList(value: String): List<String> {
        return value.split(',')
    }
}