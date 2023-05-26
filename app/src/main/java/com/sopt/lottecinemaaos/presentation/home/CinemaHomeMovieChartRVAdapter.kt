package com.sopt.lottecinemaaos.presentation.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.data.model.response.ResponseHomeMovieChartDto
import com.sopt.lottecinemaaos.databinding.ItemHomeMovieChartAdBinding
import com.sopt.lottecinemaaos.databinding.ItemHomeMovieChartBinding
import com.sopt.lottecinemaaos.presentation.detail.MovieDetailActivity

class CinemaHomeMovieChartRVAdapter(context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var itemList: ArrayList<ResponseHomeMovieChartDto> = arrayListOf()

    companion object {
        const val MOVIE_VIEW_TYPE = 1
        const val AD_VIEW_TYPE = 2
    }

    class MovieViewHolder(private val binding: ItemHomeMovieChartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val context = binding.root.context
        fun bind(itemList: ResponseHomeMovieChartDto) {
            with(binding) {
                tvMovieTitle.text =
                    if (itemList.movieName.length >= 7) itemList.movieName.substring(0..6) + ".."
                    else itemList.movieName
                tvReservationRate.text = itemList.reservationRatio.toString()
                if (itemList.release) {
                    layoutStar.visibility = View.VISIBLE
                    layoutDay.visibility = View.GONE
                    tvGrade.text = itemList.scoreOfStar.toString()
                } else {
                    layoutDay.visibility = View.VISIBLE
                    layoutStar.visibility = View.GONE
                    tvDayNum.text = itemList.releaseDate.toString()
                }
                ivMovieImage.setOnClickListener {
                    val intent = Intent(context, MovieDetailActivity::class.java)
                    intent.run { context.startActivity(this) }
                }
                btnMovieButton.setOnClickListener {
                    val intent = Intent(context, MovieDetailActivity::class.java)
                    intent.run { context.startActivity(this) }
                }
            }
        }
    }

    class AdViewHolder(private val binding: ItemHomeMovieChartAdBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position != 0 && position % 2 == 0) {
            holder as AdViewHolder
        } else {
            holder as MovieViewHolder
            holder.bind(itemList[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == AD_VIEW_TYPE) {
            val binding = ItemHomeMovieChartAdBinding.inflate(inflater, parent, false)
            AdViewHolder(binding)
        } else {
            val binding = ItemHomeMovieChartBinding.inflate(inflater, parent, false)
            MovieViewHolder(binding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position != 0 && position % 2 == 0) AD_VIEW_TYPE
        else MOVIE_VIEW_TYPE
    }

    fun setItemList(itemList: ArrayList<ResponseHomeMovieChartDto>) {
        this.itemList = itemList
    }
}
