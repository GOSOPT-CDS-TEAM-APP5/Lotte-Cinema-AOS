package com.sopt.lottecinemaaos.presentation.selection.movietime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.data.model.response.ResponseScheduleDto
import com.sopt.lottecinemaaos.databinding.ItemSelectionTheaterTimetableBinding
import com.sopt.lottecinemaaos.util.ItemDiffCallback

class MovieTimeSelectionTimeTableAdapter :
    ListAdapter<ResponseScheduleDto.Cinema, MovieTimeSelectionTimeTableAdapter.TimeTableViewHolder>(
        ItemDiffCallback<ResponseScheduleDto.Cinema>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new }
        )
    ) {

    inner class TimeTableViewHolder(
        private val binding: ItemSelectionTheaterTimetableBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(
            data: ResponseScheduleDto.Cinema,
            firstAdapter: MovieTimeAdapter,
            secondAdapter: MovieTimeAdapter,
            thirdAdapter: MovieTimeAdapter
        ) {
            firstAdapter.submitList(data.multiplexList[0].scheduleList)
            secondAdapter.submitList(data.multiplexList[1].scheduleList)
            thirdAdapter.submitList(data.multiplexList[2].scheduleList)
            with(binding) {
                rcvMovietimeTimetable1.adapter = firstAdapter
                rcvMovietimeTimetable2.adapter = secondAdapter
                rcvMovietimeTimetable3.adapter = thirdAdapter
                tvMovietimeTheater.text = data.theaterName
                tvMovietimeType.text = data.multiplexList[0].movieType
                tvMovietimeType2.text = data.multiplexList[1].movieType
                tvMovietimeType3.text = data.multiplexList[2].movieType
                tvMovietimePlace.text = data.multiplexList[0].multiplexLocation
                tvMovietimePlace2.text = data.multiplexList[1].multiplexLocation
                tvMovietimePlace3.text = data.multiplexList[2].multiplexLocation
            }
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
        val timeTable = getItem(position) as ResponseScheduleDto.Cinema
        val firstAdapter = MovieTimeAdapter()
        val secondAdapter = MovieTimeAdapter()
        val thirdAdapter = MovieTimeAdapter()
        holder.onBind(timeTable, firstAdapter, secondAdapter, thirdAdapter)
    }
}
