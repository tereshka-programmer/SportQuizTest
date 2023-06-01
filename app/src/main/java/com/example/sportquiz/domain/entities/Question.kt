package com.example.sportquiz.domain.entities


data class Question(
    val id: Long,
    val question: String,
    val answers: List<String>,
    val trueAnswer: String,
    val level: String
)