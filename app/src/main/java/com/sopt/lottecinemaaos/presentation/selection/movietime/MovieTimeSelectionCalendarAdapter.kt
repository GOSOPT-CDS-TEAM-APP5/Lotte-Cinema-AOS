package com.sopt.lottecinemaaos.presentation.selection.movietime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
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
            with(binding) {
                tvItemDate.text = data.num.toString()
                tvItemDay.text = data.day
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
