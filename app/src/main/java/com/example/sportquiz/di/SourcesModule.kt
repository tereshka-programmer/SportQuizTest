package com.example.sportquiz.di

import com.example.sportquiz.data.room.RoomQuestionsSourceImpl
import com.example.sportquiz.data.room.questions.RoomQuestionsSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SourcesModule {

    @Binds
    abstract fun bindRoomQuestionsSource(
        roomQuestionsSourceImpl: RoomQuestionsSourceImpl
    ): RoomQuestionsSource

}