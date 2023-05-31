package com.example.sportquiz.data.room.questions

import androidx.room.Dao
import androidx.room.Query
import com.example.sportquiz.data.room.questions.entities.QuestionDbEntity

@Dao
interface QuestionsDao {

    @Query("SELECT * FROM questions")
    suspend fun getAllQuestions(): List<QuestionDbEntity>

    @Query("SELECT * FROM questions WHERE level = :level")
    suspend fun getQuestionsByLevel(level: String): List<QuestionDbEntity>

}