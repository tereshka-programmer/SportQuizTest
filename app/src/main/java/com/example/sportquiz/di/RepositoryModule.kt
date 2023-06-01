package com.example.sportquiz.di

import com.example.sportquiz.data.repositoryImpl.BackgroundsRepositoryImpl
import com.example.sportquiz.data.repositoryImpl.QuestionsRepositoryImpl
import com.example.sportquiz.data.repositoryImpl.SharedCacheRepositoryImpl
import com.example.sportquiz.data.room.RoomQuestionsSourceImpl
import com.example.sportquiz.domain.repository.BackgroundsRepository
import com.example.sportquiz.domain.repository.QuestionsRepository
import com.example.sportquiz.domain.repository.SharedCacheRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindQuestionsRepository(
        questionsRepositoryImpl: QuestionsRepositoryImpl
    ): QuestionsRepository

    @Binds
    abstract fun bindSharedCacheRepository(
        sharedCacheRepositoryImpl: SharedCacheRepositoryImpl
    ): SharedCacheRepository

    @Binds
    abstract fun bindBackgroundRepository(
        backgroundsRepositoryImpl: BackgroundsRepositoryImpl
    ): BackgroundsRepository

}