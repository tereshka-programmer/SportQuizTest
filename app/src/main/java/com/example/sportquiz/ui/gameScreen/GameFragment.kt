package com.example.sportquiz.ui.gameScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sportquiz.R
import com.example.sportquiz.databinding.FragmentGameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameFragment() : Fragment(R.layout.fragment_game) {

    private lateinit var binding: FragmentGameBinding

    private val viewModel by viewModels<GameViewModel>()

    private val args: GameFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGameBinding.bind(view)

        viewModel.initQuestionsByLevel(args.level)
        binding.btSubmit.setOnClickListener { viewModel.nextQuestion() }

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


}