package com.example.sportquiz.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.sportquiz.R
import com.example.sportquiz.domain.repository.QuestionsRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment(): Fragment(R.layout.fragment_main) {

    @Inject lateinit var repository: QuestionsRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        lifecycleScope.launchWhenCreated {
            val list = repository.getQuestions()
            Log.d("RESTAG", list.toString())
        }
    }

}