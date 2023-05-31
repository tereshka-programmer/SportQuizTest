package com.example.sportquiz.domain.repository

import com.example.sportquiz.domain.entities.Question

interface QuestionsRepository {

    suspend fun getQuestions(): List<Question>

    suspend fun getQuestionsByLevel(level: String): List<Question>

}