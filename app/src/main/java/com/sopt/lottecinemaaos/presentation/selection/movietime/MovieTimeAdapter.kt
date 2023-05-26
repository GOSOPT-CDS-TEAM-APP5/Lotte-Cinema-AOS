package com.sopt.lottecinemaaos.presentation.selection.movietime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.data.entity.MultiplexList
import com.sopt.lottecinemaaos.databinding.ItemSelectionTimetableBinding
import com.sopt.lottecinemaaos.util.ItemDiffCallback

class MovieTimeAdapter :
    ListAdapter<MultiplexList.ScheduleList, MovieTimeAdapter.MovieTimeViewHolder>(
        ItemDiffCallback<MultiplexList.ScheduleList>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new }
        )
    ) {
    inner class MovieTimeViewHolder(private val binding: ItemSelectionTimetableBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: MultiplexList.ScheduleList) {
            binding.tvMovietimeStart.text = data.startTime
            binding.tvMovietimeEnd.text = buildString {
                append("~")
                append(data.endTime)
            }
            binding.tvMovietimeMaxPeople.text = buildString {
                append("/")
                append(data.maxPeople)
            }
            binding.tvMovietimeCurrentPeople.text = data.currentPeople
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieTimeViewHolder {
        val binding =
            ItemSelectionTimetableBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MovieTimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieTimeViewHolder, position: Int) {
        val movieTime = getItem(position) as MultiplexList.ScheduleList
        holder.onBind(movieTime)
    }
}
