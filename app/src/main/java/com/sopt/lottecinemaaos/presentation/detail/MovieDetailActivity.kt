package com.sopt.lottecinemaaos.presentation.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.databinding.ActivityMovieDetailBinding
import com.sopt.lottecinemaaos.presentation.main.MainActivity
import com.sopt.lottecinemaaos.util.base.BindingActivity

class MovieDetailActivity : BindingActivity<ActivityMovieDetailBinding>(R.layout.activity_movie_detail) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       // binding.toolbar.setNavigationIcon(R.drawable.img_icon_toolbarbackbtn)
        binding.toolbar.setNavigationIcon(R.drawable.drawable_resize)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbar.setNavigationOnClickListener { finish() }
        binding.toolbar.title = "가디언즈 오브 갤럭시.."

        setTrailer()
        setPoster()


    }


    private  val viewModel by viewModels<MovieDetailViewModel>()

    private fun setTrailer() {
        val trailerAdapter = MovieDetailTrailerAdapter(this)
        trailerAdapter.setList(viewModel.trailerList)

        with (binding) {
            rcvDetailTrailer.adapter = trailerAdapter
            rcvDetailTrailer.layoutManager = LinearLayoutManager(this@MovieDetailActivity, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setPoster() {
        val posterAdapter = MovieDetailPosterAdapter(this)
        posterAdapter.setList(viewModel.posterList)

        with (binding) {
            rcvDetailPoster.adapter = posterAdapter
            rcvDetailPoster.layoutManager = LinearLayoutManager(this@MovieDetailActivity, LinearLayoutManager.HORIZONTAL, false)
        }
    }


}
