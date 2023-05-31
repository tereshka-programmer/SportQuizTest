package com.example.sportquiz.data.room

import com.example.sportquiz.data.room.questions.QuestionsDao
import com.example.sportquiz.data.room.questions.RoomQuestionsSource
import com.example.sportquiz.data.room.questions.entities.QuestionDbEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomQuestionsSourceImpl @Inject constructor(
    private val questionsDao: QuestionsDao
): RoomQuestionsSource {

    override suspend fun getAllQuestionsEntities(): List<QuestionDbEntity> {
        return questionsDao.getAllQuestions()
    }

    override suspend fun getAllQuestionsEntitiesByLevel(level: String): List<QuestionDbEntity> {
        return questionsDao.getQuestionsByLevel(level)
    }
}