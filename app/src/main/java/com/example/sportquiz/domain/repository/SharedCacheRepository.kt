package com.example.sportquiz.domain.repository

interface SharedCacheRepository {

    fun getScore(): Int

    fun setScore(score: Int)

}