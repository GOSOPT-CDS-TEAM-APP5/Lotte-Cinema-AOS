package com.sopt.lottecinemaaos.presentation.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.databinding.ActivityMovieDetailBinding
import com.sopt.lottecinemaaos.util.base.BindingActivity

class MovieDetailActivity : BindingActivity<ActivityMovieDetailBinding>(R.layout.activity_movie_detail) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setTrailer()
        setPoster()

        //setContentView(R.layout.activity_movie_detail)
    }

    private  val viewModel by viewModels<MovieDetailViewModel>()

    private fun setTrailer() {
        val trailerAdapter = MovieDetailTrailerAdapter(this)   //
        trailerAdapter.setList(viewModel.trailerList)                      //

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
