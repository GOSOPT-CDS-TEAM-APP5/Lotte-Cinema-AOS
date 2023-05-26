package com.sopt.lottecinemaaos.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.data.model.response.ResponseHomeMovieChartDto
import com.sopt.lottecinemaaos.databinding.FragmentCinemaHomeBinding
import com.sopt.lottecinemaaos.util.base.BindingFragment

class CinemaHomeFragment :
    BindingFragment<FragmentCinemaHomeBinding>(R.layout.fragment_cinema_home) {
    private val viewModel by viewModels<CinemaHomeViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMovieChartData()
        setViewPager()
        setMovieFeedRV()
        setEventFragment()
        setEventBtn()
    }

    private fun getMovieChartData() {
        viewModel.getMovieChart()
        viewModel.movieChartData.observe(requireActivity()) {
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
        }
    }

    private fun setEventFragment() {
        changeChildFragment(CinemaHomeEventSubFragment())
    }

    private fun setMovieChartRV(data: ArrayList<ResponseHomeMovieChartDto>) {
        with(binding) {
            rvMovieChart.adapter = CinemaHomeMovieChartRVAdapter(requireContext()).apply {
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
                changeChildFragment(CinemaHomeEventSubFragment())
            }
            btnMovie.setOnClickListener {
                changeChildFragment(CinemaHomeEventOtherFragment())
            }
            btnAlliance.setOnClickListener {
                changeChildFragment(CinemaHomeEventOtherFragment())
            }
        }
    }

    private fun changeChildFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.fc_child_fragment, fragment)
            .commit()
    }
}