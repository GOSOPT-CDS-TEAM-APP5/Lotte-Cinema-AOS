package com.sopt.lottecinemaaos.presentation.selection.theater

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.databinding.ActivityCinemaSelectionBinding
import com.sopt.lottecinemaaos.util.base.BindingActivity

class CinemaSelectionActivity :
    BindingActivity<ActivityCinemaSelectionBinding>(R.layout.activity_cinema_selection) {
    private val viewModel by viewModels<CinemaSelectionViewModel>()
    private lateinit var cinemaAdapter: CinemaSelectionListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val regionAdapter = CinemaRegionSelectionListAdapter(viewModel)
        cinemaAdapter = CinemaSelectionListAdapter(::clickCinemaItem, ::unclickCinemaItem)
        val chipAdapter = CinemaSelectionChipAdapter(viewModel.testList)

        initAdapter(regionAdapter, cinemaAdapter, chipAdapter)
        observeRegionItemSelected()
    }

    private fun initAdapter(
        regionAdapter: CinemaRegionSelectionListAdapter,
        cinemaAdapter: CinemaSelectionListAdapter,
        chipAdapter: CinemaSelectionChipAdapter
    ) {
        regionAdapter.submitList(viewModel.regionList)
        cinemaAdapter.submitList(viewModel.cinemaList)
        chipAdapter.submitList(viewModel.cinemaList)
        with(binding) {
            rcvSelectionRegion.adapter = regionAdapter
            rcvSelectionCinema.adapter = cinemaAdapter
            rcvSelectionChip.adapter = chipAdapter
        }
    }

    private fun observeRegionItemSelected() {
        viewModel.isRegionItemSelected.observe(this) { isItemSelected ->
            if (isItemSelected) {
                binding.rcvSelectionCinema.visibility = View.VISIBLE
            } else {
                binding.rcvSelectionCinema.visibility = View.INVISIBLE
            }
        }
    }

    private fun clickCinemaItem(itemPosition: Int) =
        viewModel.addCinemaItemSelected(itemPosition)

    private fun unclickCinemaItem(itemPosition: Int) =
        viewModel.removeCinemaItemSelected(itemPosition)
}
