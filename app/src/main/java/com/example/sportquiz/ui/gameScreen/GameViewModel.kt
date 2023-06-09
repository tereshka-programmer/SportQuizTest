package com.example.sportquiz.ui.gameScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportquiz.domain.entities.Question
import com.example.sportquiz.domain.repository.QuestionsRepository
import com.example.sportquiz.domain.repository.SharedCacheRepository
import com.example.sportquiz.utils.Constants
import com.example.sportquiz.utils.Event
import com.example.sportquiz.utils.publishEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val questionsRepository: QuestionsRepository,
    private val sharedCacheRepository: SharedCacheRepository
) : ViewModel() {

    private var listOfQuestions: List<Question> = listOf()
    private var questionsCounter = 0

    private val _question = MutableSharedFlow<Question>(replay = 1)
    val question: SharedFlow<Question> = _question

    private val _eventOfReturn = MutableSharedFlow<Event<Unit>>()
    val eventOfReturn: SharedFlow<Event<Unit>> = _eventOfReturn

    fun initQuestionsByLevel(level: String) {
        viewModelScope.launch {
            listOfQuestions = questionsRepository.getQuestionsByLevel(level).shuffled()
            nextQuestion()
        }
    }

    fun nextQuestion() {
        viewModelScope.launch {
            _question.emit(listOfQuestions[questionsCounter])
            if (listOfQuestions.size-1 > questionsCounter) questionsCounter++
            else _eventOfReturn.publishEvent(Event(Unit))
        }
    }

    fun addScore() {
        val currentScore = sharedCacheRepository.getScore()
        sharedCacheRepository.setScore(currentScore + Constants.DEFAULT_INCREASE_OF_SCORE)
    }

}