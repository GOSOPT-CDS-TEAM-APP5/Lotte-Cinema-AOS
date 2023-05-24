package com.sopt.lottecinemaaos.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.data.model.response.ResponseHomeMovieChartDto
import com.sopt.lottecinemaaos.databinding.ItemHomeMovieChartAdBinding
import com.sopt.lottecinemaaos.databinding.ItemHomeMovieChartBinding

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
        fun bind(itemList: ResponseHomeMovieChartDto) {
            with(binding) {
                tvMovieTitle.text = if (itemList.movieName.length >= 7) {
                    itemList.movieName.substring(0..6) + ".."
                } else {
                    itemList.movieName
                }
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
            }
        }
    }

    class AdViewHolder(private val binding: ItemHomeMovieChartAdBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as MovieViewHolder
        holder.bind(itemList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemHomeMovieChartBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding)
    }

    fun setItemList(itemList: ArrayList<ResponseHomeMovieChartDto>) {
        this.itemList = itemList
    }
}