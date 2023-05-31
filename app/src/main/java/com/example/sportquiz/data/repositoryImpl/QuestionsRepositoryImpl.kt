package com.example.sportquiz.data.repositoryImpl

import com.example.sportquiz.data.room.questions.RoomQuestionsSource
import com.example.sportquiz.domain.entities.Question
import com.example.sportquiz.domain.repository.QuestionsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuestionsRepositoryImpl @Inject constructor(
    private val questionsSource: RoomQuestionsSource
) : QuestionsRepository {

    override suspend fun getQuestions(): List<Question> {
        return questionsSource.getAllQuestionsEntities().map { it.toQuestionEntity() }
    }

    override suspend fun getQuestionsByLevel(level: String): List<Question> {
        return questionsSource.getAllQuestionsEntitiesByLevel(level).map { it.toQuestionEntity() }
    }
}