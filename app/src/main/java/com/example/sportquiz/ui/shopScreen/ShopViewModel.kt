package com.example.sportquiz.ui.shopScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportquiz.domain.repository.BackgroundsRepository
import com.example.sportquiz.domain.repository.SharedCacheRepository
import com.example.sportquiz.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(
    private val sharedCacheRepository: SharedCacheRepository,
    private val backgroundsRepository: BackgroundsRepository,
) : ViewModel() {

    private val _backgroundImage = MutableSharedFlow<Map<Int, Int>>(replay = 1)
    val backgroundImage: SharedFlow<Map<Int, Int>> = _backgroundImage

    init {
        viewModelScope.launch {
            _backgroundImage.emit(backgroundsRepository.getBackgroundImages())
        }
    }

    fun butBackImg(id: Int) {
        backgroundsRepository.buyAndSetBackgroundImage(id)
        val score = sharedCacheRepository.getScore()
        if (score > 0) {
            sharedCacheRepository.setScore(score-Constants.DEFAULT_INCREASE_OF_SCORE)
        }
    }

}