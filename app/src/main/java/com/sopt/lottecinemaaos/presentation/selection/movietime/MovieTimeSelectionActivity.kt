package com.sopt.lottecinemaaos.presentation.selection.movietime

import android.os.Bundle
import androidx.activity.viewModels
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.databinding.ActivityMovieTimeSelectionBinding
import com.sopt.lottecinemaaos.util.base.BindingActivity

class MovieTimeSelectionActivity :
    BindingActivity<ActivityMovieTimeSelectionBinding>(R.layout.activity_movie_time_selection) {
    private val viewModel by viewModels<MovieTimeSelectionViewModel>()
    private lateinit var cinemaChipAdapter: MovieTimeSelectionChipAdapter
    private lateinit var cinemaCalendarAdapter: MovieTimeSelectionCalendarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        cinemaChipAdapter = MovieTimeSelectionChipAdapter()
        cinemaCalendarAdapter = MovieTimeSelectionCalendarAdapter()
        initAdapter(cinemaChipAdapter, cinemaCalendarAdapter)
    }

    private fun initAdapter(
        chipAdapter: MovieTimeSelectionChipAdapter,
        calendarAdapter: MovieTimeSelectionCalendarAdapter
    ) {
        chipAdapter.submitList(viewModel.cinemaList)
        calendarAdapter.submitList(viewModel.dateList)
        with(binding) {
            rcvMovietimeChip.adapter = chipAdapter
            rcvMovietimeCalendar.adapter = calendarAdapter
        }
    }
}
