package com.sopt.lottecinemaaos.presentation.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.databinding.FragmentHomeEventRecommendBinding
import com.sopt.lottecinemaaos.util.base.BindingFragment

class CinemaHomeEventSubFragment:BindingFragment<FragmentHomeEventRecommendBinding>(R.layout.fragment_home_event_recommend){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setEventRV()
    }

    private fun setEventRV(){
        with(binding){
            rvEvent.adapter=CinemaHomeEventRVAdapter()
            rvEvent.layoutManager=LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL,false)
        }
    }
}
