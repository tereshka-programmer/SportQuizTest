package com.example.sportquiz.data.repositoryImpl

import android.util.Log
import com.example.sportquiz.data.BackgroundsSource
import com.example.sportquiz.domain.repository.BackgroundsRepository
import com.example.sportquiz.domain.repository.SharedCacheRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BackgroundsRepositoryImpl @Inject constructor(
    private val sharedCacheRepository: SharedCacheRepository
) : BackgroundsRepository {

    override fun getBackgroundImages(): Map<Int, Int> {
        return BackgroundsSource.mapOfBackgrounds
    }

    override fun buyAndSetBackgroundImage(id: Int) {
        sharedCacheRepository.setIdBackground(id)
        Log.d("RESTAG", "JUST SETED")
    }
}