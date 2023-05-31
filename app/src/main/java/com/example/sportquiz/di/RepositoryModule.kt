package com.example.sportquiz.di

import com.example.sportquiz.data.room.RoomQuestionsSourceImpl
import com.example.sportquiz.domain.repository.QuestionsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindQuestionsRepository(
        questionsSourceImpl: RoomQuestionsSourceImpl
    ): QuestionsRepository

}