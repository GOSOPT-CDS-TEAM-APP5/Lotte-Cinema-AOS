package com.sopt.lottecinemaaos.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.databinding.ItemHomeMovieChartAdBinding
import com.sopt.lottecinemaaos.databinding.ItemHomeMovieChartBinding
import com.sopt.lottecinemaaos.domain.model.MovieChart

class CinemaHomeMovieChartRVAdapter(context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private val itemList: List<MovieChart> = listOf(
        MovieChart(1, "가디언즈 오브 갤...", 9.6, true, null, null),
        MovieChart(1, "분노의 질주:라이...", 9.6, true, null, null),
        MovieChart(2, null, null, null, null, null)
    )

    companion object {
        const val MOVIE_VIEW_TYPE = 1
        const val AD_VIEW_TYPE = 2
    }

    class MovieViewHolder(private val binding: ItemHomeMovieChartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemList: MovieChart) {
            with(binding) {
                tvMovieTitle.text = itemList.title
            }
        }
    }

    class AdViewHolder(private val binding: ItemHomeMovieChartAdBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (itemList[position].viewType == MOVIE_VIEW_TYPE) {
            holder as MovieViewHolder
            holder.bind(itemList[position])
        } else {
            holder as AdViewHolder
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == MOVIE_VIEW_TYPE) {
            val binding = ItemHomeMovieChartBinding.inflate(inflater, parent, false)
            MovieViewHolder(binding)
        } else {
            val binding = ItemHomeMovieChartAdBinding.inflate(inflater, parent, false)
            AdViewHolder(binding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].viewType
    }
}