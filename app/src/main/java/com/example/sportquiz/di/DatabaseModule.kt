package com.example.sportquiz.di

import android.content.Context
import androidx.room.Room
import com.example.sportquiz.data.room.db.AppDatabase
import com.example.sportquiz.data.room.questions.QuestionsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideQuestionDao(appDatabase: AppDatabase): QuestionsDao {
        return appDatabase.getQuestionsDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, "database.db")
            .createFromAsset("questions_init.db")
            .build()
    }

}