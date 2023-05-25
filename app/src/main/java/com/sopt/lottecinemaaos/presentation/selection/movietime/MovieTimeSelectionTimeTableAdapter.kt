package com.sopt.lottecinemaaos.presentation.selection.movietime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.databinding.ItemSelectionTheaterTimetableBinding
import com.sopt.lottecinemaaos.domain.model.TimeTable
import com.sopt.lottecinemaaos.util.ItemDiffCallback

class MovieTimeSelectionTimeTableAdapter :
    ListAdapter<TimeTable, MovieTimeSelectionTimeTableAdapter.TimeTableViewHolder>(
        ItemDiffCallback<TimeTable>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new }
        )
    ) {

    inner class TimeTableViewHolder(
        private val binding: ItemSelectionTheaterTimetableBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: TimeTable) {
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TimeTableViewHolder {
        val binding =
            ItemSelectionTheaterTimetableBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return TimeTableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TimeTableViewHolder, position: Int) {
        val timeTable = getItem(position)
        holder.onBind(timeTable)
    }
}
