package com.example.sportquiz.domain.repository

interface BackgroundsRepository {

    fun getBackgroundImages(): Map<Int, Int>

    fun buyAndSetBackgroundImage(id: Int)

}