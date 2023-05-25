package com.sopt.lottecinemaaos.presentation.selection.movietime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.databinding.ItemSelectionChipBinding
import com.sopt.lottecinemaaos.domain.model.Theater
import com.sopt.lottecinemaaos.util.ItemDiffCallback

class MovieTimeSelectionChipAdapter :
    ListAdapter<Theater, MovieTimeSelectionChipAdapter.MovieTimeCinemaChipViewHolder>(
        ItemDiffCallback<Theater>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new }
        )
    ) {

    inner class MovieTimeCinemaChipViewHolder(
        private val binding: ItemSelectionChipBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Theater) {
            binding.tvSelectionChip.text = data.name
//            Log.d("현재", selectedCinemaItemList.toString())
//            if (selectedCinemaItemList.isNotEmpty()) {
//                binding.tvSelectionChip.visibility = View.VISIBLE
//            } else {
//                binding.tvSelectionChip.visibility = View.GONE
//            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieTimeCinemaChipViewHolder {
        val binding =
            ItemSelectionChipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieTimeCinemaChipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieTimeCinemaChipViewHolder, position: Int) {
        val cinema = getItem(position)
        holder.onBind(cinema)
    }
}
