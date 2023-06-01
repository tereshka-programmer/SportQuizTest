package com.example.sportquiz.ui.gameScreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sportquiz.R
import com.example.sportquiz.databinding.FragmentGameBinding
import com.example.sportquiz.domain.entities.Question
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class GameFragment() : Fragment(R.layout.fragment_game) {

    private lateinit var binding: FragmentGameBinding

    private val viewModel by viewModels<GameViewModel>()

    private val args: GameFragmentArgs by navArgs()

    private var trueAnswer = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGameBinding.bind(view)

        viewModel.initQuestionsByLevel(args.level)

        observeQuestions()
        observeReturnEvent()

        binding.btSubmit.setOnClickListener {
            viewModel.nextQuestion()
            returnDefaultColorForButton()
            activateAnswerButtons()
        }

        binding.btFirstAnswer.setOnClickListener(answersListener)

        binding.btSecondAnswer.setOnClickListener(answersListener)

        binding.btThirdAnswer.setOnClickListener(answersListener)

        binding.btFourAnswer.setOnClickListener(answersListener)

    }

    private val answersListener = View.OnClickListener { view ->
        val button = view as Button
        disableAnswerButtons()
        if (button.text == trueAnswer){
            button.background.setTint(ContextCompat.getColor(requireContext(), R.color.green))
            viewModel.addScore()
        } else {
            button.background.setTint(ContextCompat.getColor(requireContext(), R.color.red))
        }
    }

    private fun observeReturnEvent() {
        lifecycleScope.launchWhenStarted {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.eventOfReturn.collect {
                    findNavController().navigateUp()
                }
            }
        }
    }

    private fun observeQuestions() {
        lifecycleScope.launchWhenCreated {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.question.collect { question ->
                    trueAnswer = question.trueAnswer
                    withContext(Dispatchers.Main) {
                        setQuestion(question)
                    }
                }
            }
        }
    }

    private fun setQuestion(question: Question) {
        binding.tvQuestion.text = question.question
        val answers = question.answers.shuffled()
        binding.btFirstAnswer.text = answers[0]
        binding.btSecondAnswer.text = answers[1]
        binding.btThirdAnswer.text = answers[2]
        binding.btFourAnswer.text = answers[3]
    }

    private fun activateAnswerButtons() {
        binding.btFirstAnswer.isClickable = true
        binding.btSecondAnswer.isClickable = true
        binding.btThirdAnswer.isClickable = true
        binding.btFourAnswer.isClickable = true
    }

    private fun disableAnswerButtons() {
        binding.btFirstAnswer.isClickable = false
        binding.btSecondAnswer.isClickable = false
        binding.btThirdAnswer.isClickable = false
        binding.btFourAnswer.isClickable = false
    }

    private fun returnDefaultColorForButton() {
        binding.btFirstAnswer.background.setTint(ContextCompat.getColor(requireContext(), R.color.gray))
        binding.btSecondAnswer.background.setTint(ContextCompat.getColor(requireContext(), R.color.gray))
        binding.btThirdAnswer.background.setTint(ContextCompat.getColor(requireContext(), R.color.gray))
        binding.btFourAnswer.background.setTint(ContextCompat.getColor(requireContext(), R.color.gray))
    }


}