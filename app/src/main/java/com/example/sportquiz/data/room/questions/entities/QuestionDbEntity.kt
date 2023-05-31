package com.example.sportquiz.data.room.questions.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sportquiz.domain.entities.Question

@Entity(
    tableName = "questions"
)
data class QuestionDbEntity(
    @PrimaryKey val id: Long,
    val question: String,
    val answers: List<String>,
    val trueAnswer: String,
    val level: String
) {
    fun toQuestionEntity(): Question = Question(
        id = id,
        question = question,
        answers = answers,
        trueAnswer = trueAnswer,
        level = level
    )
}
