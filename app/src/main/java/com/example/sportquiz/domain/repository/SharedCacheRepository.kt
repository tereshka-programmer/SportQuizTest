package com.example.sportquiz.domain.repository

interface SharedCacheRepository {

    fun getScore(): Int

    fun setScore(score: Int)

    fun setIdBackground(id: Int)

    fun getBackgroundId(): Int

}