package com.example.sportquiz.data.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sportquiz.data.room.questions.QuestionsDao
import com.example.sportquiz.data.room.questions.entities.QuestionDbEntity


@Database(
    version = 1,
    entities = [
        QuestionDbEntity::class
    ]
)
@TypeConverters(
    Converter::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getQuestionsDao(): QuestionsDao

}