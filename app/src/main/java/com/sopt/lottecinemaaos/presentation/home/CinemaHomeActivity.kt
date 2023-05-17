package com.sopt.lottecinemaaos.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.databinding.ActivityCinemaHomeBinding
import com.sopt.lottecinemaaos.util.base.BindingActivity

class CinemaHomeActivity :
    BindingActivity<ActivityCinemaHomeBinding>(R.layout.activity_cinema_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewHolder()
    }

    private fun setViewHolder() {
        with(binding) {
            layoutTopViewpager.adapter = CinemaHomeVPAdapter().apply {
                setItemList(
                    listOf(
                        R.drawable.img_home_viewpager2,
                        R.drawable.img_home_viewpager3,
                        R.drawable.img_home_viewpager1
                    )
                )
            }
            wormDotsIndicator.attachTo(layoutTopViewpager)
        }
    }
}
