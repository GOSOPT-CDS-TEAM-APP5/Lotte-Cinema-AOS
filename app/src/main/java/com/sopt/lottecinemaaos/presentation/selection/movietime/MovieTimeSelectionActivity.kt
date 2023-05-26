package com.sopt.lottecinemaaos.presentation.selection.movietime

import android.os.Bundle
import androidx.activity.viewModels
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.databinding.ActivityMovieTimeSelectionBinding
import com.sopt.lottecinemaaos.util.ViewModelFactory
import com.sopt.lottecinemaaos.util.base.BindingActivity

class MovieTimeSelectionActivity :
    BindingActivity<ActivityMovieTimeSelectionBinding>(R.layout.activity_movie_time_selection) {
    private val viewModel: MovieTimeSelectionViewModel by viewModels { ViewModelFactory(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val cinemaChipAdapter = MovieTimeSelectionChipAdapter()
        val cinemaCalendarAdapter = MovieTimeSelectionCalendarAdapter()
        val cinemaTimeTableAdapter = MovieTimeSelectionTimeTableAdapter()

        initAdapter(
            cinemaChipAdapter,
            cinemaCalendarAdapter,
            cinemaTimeTableAdapter
        )
    }

    private fun initAdapter(
        chipAdapter: MovieTimeSelectionChipAdapter,
        calendarAdapter: MovieTimeSelectionCalendarAdapter,
        timeTableAdapter: MovieTimeSelectionTimeTableAdapter
    ) {
        chipAdapter.submitList(viewModel.cinemaList)
        calendarAdapter.submitList(viewModel.dateList)
        viewModel.timeTableData.observe(this) {
            binding.rcvMovietimeTimetable.adapter = timeTableAdapter
            timeTableAdapter.submitList(it)
        }
        /*
        viewModel.theaterData.observe(this) {
            with(binding) {
                rcvSelectionCinema.adapter = cinemaAdapter
                rcvSelectionChip.adapter = chipAdapter
            }
            cinemaAdapter.submitList(it)
            chipAdapter.submitList(it)
        }
         */
        with(binding) {
            rcvMovietimeChip.adapter = chipAdapter
            rcvMovietimeCalendar.adapter = calendarAdapter
        }
    }
}
