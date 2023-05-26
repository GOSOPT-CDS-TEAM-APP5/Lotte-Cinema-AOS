package com.sopt.lottecinemaaos.presentation.selection.main

import android.os.Bundle
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.databinding.ActivityMainBinding
import com.sopt.lottecinemaaos.util.base.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        clickFloatingBtn()
    }
    private fun clickFloatingBtn() {
        with(binding) {
            btnReserve.setOnClickListener {
                bottomNavMain.selectedItemId = R.id.menu_reserve
            }
        }
    }
}