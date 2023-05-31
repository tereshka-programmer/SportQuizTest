package com.example.sportquiz.domain.entities

import androidx.room.PrimaryKey

data class Question(
    val id: Long,
    val question: String,
    val answers: List<String>,
    val trueAnswer: String,
    val level: String
)