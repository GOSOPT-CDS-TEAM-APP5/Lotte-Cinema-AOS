package com.sopt.lottecinemaaos.presentation.selection

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.databinding.ActivityCinemaSelectionBinding
import com.sopt.lottecinemaaos.util.base.BindingActivity

class CinemaSelectionActivity :
    BindingActivity<ActivityCinemaSelectionBinding>(R.layout.activity_cinema_selection) {
    private val viewModel by viewModels<CinemaSelectionViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val regionAdapter = CinemaRegionSelectionListAdapter(viewModel)
        val cinemaAdapter = CinemaSelectionListAdapter()
        initAdapter(regionAdapter, cinemaAdapter)
        observeRegionItemSelected()
    }

    private fun initAdapter(
        regionAdapter: CinemaRegionSelectionListAdapter,
        cinemaAdapter: CinemaSelectionListAdapter
    ) {
        regionAdapter.submitList(viewModel.regionList)
        cinemaAdapter.submitList(viewModel.cinemaList)
        binding.rcvSelectionRegion.also {
            it.adapter = regionAdapter
        }
        binding.rcvSelectionCinema.also {
            it.adapter = cinemaAdapter
        }
    }

    private fun observeRegionItemSelected() {
        viewModel.isRegionItemSelected.observe(this) {
            if (viewModel.isRegionItemSelected.value == true) {
                binding.rcvSelectionCinema.visibility = View.VISIBLE
            } else {
                binding.rcvSelectionCinema.visibility = View.INVISIBLE
            }
        }
    }
}
