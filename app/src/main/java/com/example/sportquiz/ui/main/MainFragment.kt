package com.example.sportquiz.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.sportquiz.R
import com.example.sportquiz.databinding.FragmentMainBinding
import com.example.sportquiz.domain.repository.QuestionsRepository
import com.example.sportquiz.domain.repository.SharedCacheRepository
import com.example.sportquiz.ui.common.LevelsOfQuestions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment(): Fragment(R.layout.fragment_main) {

   @Inject lateinit var sharedCacheRepository: SharedCacheRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBinding.bind(view)

        binding.btEasyLevel.setOnClickListener { navigateToEasyLevel() }
        binding.btMediumLevel.setOnClickListener { navigateToMediumLevel() }
        binding.btHardLevel.setOnClickListener { navigateToHardLevel() }

        val score = sharedCacheRepository.getScore()

        Log.d("RESTAG", "SCORE IN MAIN FRAGMENT: $score")

        binding.tvScore.text = sharedCacheRepository.getScore().toString()
    }

    private fun navigateToEasyLevel() {
        val action = MainFragmentDirections.actionMainFragmentToGameFragment(LevelsOfQuestions.EASY_LEVEL)
        findNavController().navigate(action)
    }

    private fun navigateToMediumLevel() {
        val action = MainFragmentDirections.actionMainFragmentToGameFragment(LevelsOfQuestions.MEDIUM_LEVEL)
        findNavController().navigate(action)
    }

    private fun navigateToHardLevel() {
        val action = MainFragmentDirections.actionMainFragmentToGameFragment(LevelsOfQuestions.HARD_LEVEL)
        findNavController().navigate(action)
    }

}