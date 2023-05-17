package com.sopt.lottecinemaaos.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.databinding.FragmentCinemaHomeBinding
import com.sopt.lottecinemaaos.util.base.BindingFragment

class CinemaHomeFragment : BindingFragment<FragmentCinemaHomeBinding>(R.layout.fragment_cinema_home){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewHolder()
        setMovieChartRV()
    }

    private fun setViewHolder() {
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

    private fun setMovieChartRV(){
        with(binding){
            rvMovieChart.adapter = CinemaHomeMovieChartRVAdapter(requireContext())
            rvMovieChart.layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
    }
}
