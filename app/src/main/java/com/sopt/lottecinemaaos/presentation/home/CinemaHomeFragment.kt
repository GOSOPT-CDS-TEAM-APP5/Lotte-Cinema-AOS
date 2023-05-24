package com.sopt.lottecinemaaos.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.data.model.response.ResponseHomeMovieChartDto
import com.sopt.lottecinemaaos.databinding.FragmentCinemaHomeBinding
import com.sopt.lottecinemaaos.util.base.BindingFragment


class CinemaHomeFragment :
    BindingFragment<FragmentCinemaHomeBinding>(R.layout.fragment_cinema_home) {
    private val viewModel by viewModels <CinemaHomeViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewPager()
        setMovieFeedRV()
        setEventFragment()
        setEventBtn()
        viewModel.getMovieChart()
        viewModel.movieChartData.observe(requireActivity()){
            setMovieChartRV(it)
        }
    }

    private fun setViewPager() {
        with(binding) {
            layoutTopViewpager.adapter = CinemaHomeVPAdapter().apply {
                setItemList(
                    listOf(
                        R.drawable.img_home_viewpager1,
                        R.drawable.img_home_viewpager2,
                        R.drawable.img_home_viewpager3
                    )
                )
            }
            wormDotsIndicator.attachTo(layoutTopViewpager)
        }
    }

    private fun setEventFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.fc_child_fragment, CinemaHomeEventSubFragment())
            .commit()
    }

    private fun setMovieChartRV(data : ArrayList<ResponseHomeMovieChartDto>) {
        with(binding) {
            rvMovieChart.adapter = CinemaHomeMovieChartRVAdapter(requireContext()).apply{
                this.setItemList(data)
            }
            rvMovieChart.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setMovieFeedRV() {
        with(binding) {
            rvMovieFeed.adapter = CinemaHomePickRVAdapter(requireContext())
            rvMovieChart.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setEventBtn() {
        with(binding) {
            btnRecommend.setOnClickListener {
                childFragmentManager.beginTransaction()
                    .replace(R.id.fc_child_fragment, CinemaHomeEventSubFragment()).commit()
            }
            btnMovie.setOnClickListener {
                childFragmentManager.beginTransaction()
                    .replace(R.id.fc_child_fragment, CinemaHomeEventOtherFragment()).commit()
            }
            btnAlliance.setOnClickListener {
                childFragmentManager.beginTransaction()
                    .replace(R.id.fc_child_fragment, CinemaHomeEventOtherFragment()).commit()
            }
        }
    }
}
