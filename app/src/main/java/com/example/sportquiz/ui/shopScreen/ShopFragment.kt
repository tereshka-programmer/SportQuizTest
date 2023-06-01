package com.example.sportquiz.ui.shopScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportquiz.R
import com.example.sportquiz.databinding.FragmentShopBinding
import com.example.sportquiz.domain.repository.SharedCacheRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ShopFragment() : Fragment(R.layout.fragment_shop) {

    private var adapter: ShopAdapter = ShopAdapter(object : ActionListener {
        override fun buy(id: Int) {
            viewModel.butBackImg(id)
        }

        override fun returnToHome() {
            findNavController().navigateUp()
        }

    })

    private val viewModel by viewModels<ShopViewModel>()

    private lateinit var binding: FragmentShopBinding

    @Inject lateinit var sharedCacheRepository: SharedCacheRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShopBinding.bind(view)

        observeBackgroundsMap()

        val layoutManager = LinearLayoutManager(requireContext())
        binding.tvScore.text = sharedCacheRepository.getScore().toString()
        binding.rcvShopItems.layoutManager = layoutManager
        binding.rcvShopItems.adapter = adapter

    }

    private fun observeBackgroundsMap() {
        lifecycleScope.launchWhenCreated {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.backgroundImage.collect{
                    adapter.mapOfBackgrounds = it
                }
            }
        }
    }
}