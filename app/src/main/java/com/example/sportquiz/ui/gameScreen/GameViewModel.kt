package com.example.sportquiz.ui.gameScreen

import androidx.lifecycle.ViewModel
import com.example.sportquiz.domain.repository.QuestionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val questionsRepository: QuestionsRepository
) : ViewModel() {



}