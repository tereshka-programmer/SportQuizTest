package com.example.sportquiz.data.room.questions

import com.example.sportquiz.data.room.questions.entities.QuestionDbEntity

interface RoomQuestionsSource {

    suspend fun getAllQuestionsEntities(): List<QuestionDbEntity>

    suspend fun getAllQuestionsEntitiesByLevel(level: String): List<QuestionDbEntity>

}