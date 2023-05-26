package com.sopt.lottecinemaaos.presentation.detail

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.databinding.ActivityMovieDetailBinding
import com.sopt.lottecinemaaos.presentation.selection.main.MainActivity
import com.sopt.lottecinemaaos.presentation.selection.theater.CinemaSelectionActivity
import com.sopt.lottecinemaaos.util.base.BindingActivity

class MovieDetailActivity :
    BindingActivity<ActivityMovieDetailBinding>(R.layout.activity_movie_detail) {
    private val viewModel by viewModels<MovieDetailViewModel>()
    private lateinit var viewinformation: MovieInformationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)

        setToolbar()

        viewinformation = ViewModelProvider(this).get(MovieInformationViewModel::class.java)
        viewinformation.getMovieDetail()
        setInformation()

        setTrailer()
        setPoster()

        clickFabButton()
    }

    private fun setToolbar() {
        binding.btnDetailBack.setOnClickListener {
            Intent(this, MainActivity::class.java).apply { startActivity(this) }
        }
    }

    private fun setInformation() {
        viewinformation.detailInformationData.observe(this) { movieData ->
            val starScore = movieData?.data?.scoreOfStar
            val reservationRatio = movieData?.data?.reservationRatio

            val informationBinding = binding.layoutViewModel
            informationBinding.tvNumRating.text = starScore.toString()
            informationBinding.tvNumReservation.text = reservationRatio.toString()
        }
    }

    private fun setTrailer() {
        val trailerAdapter = MovieDetailTrailerAdapter(this)
        trailerAdapter.setList(viewModel.trailerList)

        with(binding) {
            rcvDetailTrailer.adapter = trailerAdapter
        }
    }

    private fun setPoster() {
        val posterAdapter = MovieDetailPosterAdapter(this)
        posterAdapter.setList(viewModel.posterList)

        with(binding) {
            rcvDetailPoster.adapter = posterAdapter
        }
    }

    private fun clickFabButton() {
        binding.clFab.setOnClickListener {
            Intent(this, CinemaSelectionActivity::class.java).apply { startActivity(this) }
        }
    }
}
