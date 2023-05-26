package com.sopt.lottecinemaaos.presentation.selection.theater

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.databinding.ActivityCinemaSelectionBinding
import com.sopt.lottecinemaaos.presentation.detail.MovieDetailActivity
import com.sopt.lottecinemaaos.presentation.selection.movietime.MovieTimeSelectionActivity
import com.sopt.lottecinemaaos.util.ViewModelFactory
import com.sopt.lottecinemaaos.util.base.BindingActivity

class CinemaSelectionActivity :
    BindingActivity<ActivityCinemaSelectionBinding>(R.layout.activity_cinema_selection) {
    private val viewModel: CinemaSelectionViewModel by viewModels { ViewModelFactory(this) }
    private lateinit var cinemaAdapter: CinemaSelectionListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val regionAdapter = CinemaRegionSelectionListAdapter(viewModel)
        cinemaAdapter = CinemaSelectionListAdapter(::clickCinemaItem, ::unclickCinemaItem)
        initAdapter(regionAdapter, cinemaAdapter)
        observeRegionItemSelected()
        clickSelectedButton()
        clickBackButton()
    }

    private fun initAdapter(
        regionAdapter: CinemaRegionSelectionListAdapter,
        cinemaAdapter: CinemaSelectionListAdapter
    ) {
        viewModel.regionData.observe(this) {
            binding.rcvSelectionRegion.adapter = regionAdapter
            regionAdapter.submitList(it)
        }
        viewModel.theaterData.observe(this) {
            binding.rcvSelectionCinema.adapter = cinemaAdapter
            cinemaAdapter.submitList(it)
        }
        viewModel.selectedCinemaItemList.observe(this) { selectedCinemaList ->
            val chipAdapter = CinemaSelectionChipAdapter(
                viewModel.selectedCinemaItemList.value.orEmpty(),
                viewModel.theaterData.value.orEmpty()
            )
            chipAdapter.submitList(selectedCinemaList)
            binding.rcvSelectionChip.adapter = chipAdapter
            Log.d("cinema", selectedCinemaList.toString())
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

    private fun clickSelectedButton() {
        binding.btnSelectionComplete.setOnClickListener {
            Intent(this, MovieTimeSelectionActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    private fun clickBackButton() {
        binding.btnSelectionBack.setOnClickListener {
            Intent(this, MovieDetailActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}