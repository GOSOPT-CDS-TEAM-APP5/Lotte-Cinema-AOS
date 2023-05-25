package com.sopt.lottecinemaaos.presentation.selection.theater

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.databinding.ItemSelectionChipBinding
import com.sopt.lottecinemaaos.domain.model.Theater
import com.sopt.lottecinemaaos.presentation.selection.theater.CinemaSelectionChipAdapter.CinemaChipViewHolder
import com.sopt.lottecinemaaos.util.ItemDiffCallback

class CinemaSelectionChipAdapter(
    private val selectedCinemaItemList: List<Int>,
    private val theaterList: List<Theater>
) :
    ListAdapter<Int, CinemaChipViewHolder>(
        ItemDiffCallback<Int>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new }
        )
    ) {

    inner class CinemaChipViewHolder(
        private val binding: ItemSelectionChipBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Int) {
            val theaterName = theaterList.getOrNull(data - 1)?.name
            if (theaterName != null) {
                binding.tvSelectionChip.text = theaterName
                binding.tvSelectionChip.visibility = View.VISIBLE
            } else {
                binding.tvSelectionChip.visibility = View.GONE
            }
            Log.d("현재", selectedCinemaItemList.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaChipViewHolder {
        val binding =
            ItemSelectionChipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CinemaChipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CinemaChipViewHolder, position: Int) {
        val cinema = getItem(position) as Int
        holder.onBind(cinema)
    }
}
