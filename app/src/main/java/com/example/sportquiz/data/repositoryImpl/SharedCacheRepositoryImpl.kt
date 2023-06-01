package com.example.sportquiz.data.repositoryImpl

import android.content.Context
import com.example.sportquiz.domain.repository.SharedCacheRepository
import com.example.sportquiz.utils.Constants
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedCacheRepositoryImpl @Inject constructor(
    @ApplicationContext appContext: Context
) : SharedCacheRepository {

    private val sharedPreferences = appContext.getSharedPreferences("cache", Context.MODE_PRIVATE)

    override fun getScore(): Int = sharedPreferences.getInt(Constants.SCORE_KEY, 0)

    override fun setScore(score: Int) {
        sharedPreferences.edit()
            .putInt(Constants.SCORE_KEY, score)
            .apply()
    }

    override fun setIdBackground(id: Int) {
        sharedPreferences.edit()
            .putInt(Constants.BACKGROUND_KEY, id)
            .apply()
    }

    override fun getBackgroundId(): Int = sharedPreferences.getInt(Constants.BACKGROUND_KEY, 0)
}