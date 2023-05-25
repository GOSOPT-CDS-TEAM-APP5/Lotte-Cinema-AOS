package com.sopt.lottecinemaaos.presentation.selection.movietime

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.data.entity.Calendar
import com.sopt.lottecinemaaos.databinding.ItemSelectionDateBinding
import com.sopt.lottecinemaaos.util.ItemDiffCallback

class MovieTimeSelectionCalendarAdapter :
    ListAdapter<Calendar, MovieTimeSelectionCalendarAdapter.MovieTimeCalendarViewHolder>(
        ItemDiffCallback<Calendar>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new }
        )
    ) {

    inner class MovieTimeCalendarViewHolder(
        private val binding: ItemSelectionDateBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Calendar) {
            binding.tvItemDate.text = data.num.toString()
            binding.tvItemDay.text = data.day
            when (data.num) {
                8 -> {
                    binding.tvItemDate.setTextColor(Color.parseColor("#FFFFFF"))
                    binding.tvItemDay.setTextColor(Color.parseColor("#FFFFFF"))
                    binding.clItemDateBackground.setBackgroundResource(R.drawable.bg_select_r4_gradient)
                }
                7, 13 -> {
                    binding.tvItemDay.setTextColor(Color.parseColor("#3761CD"))
                }
                14 -> {
                    binding.tvItemDay.setTextColor(Color.parseColor("#E14137"))
                }
                else -> {
                    binding.tvItemDay.setTextColor(Color.parseColor("#000000"))
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieTimeCalendarViewHolder {
        val binding =
            ItemSelectionDateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieTimeCalendarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieTimeCalendarViewHolder, position: Int) {
        val cinema = getItem(position)
        holder.onBind(cinema)
    }
}
