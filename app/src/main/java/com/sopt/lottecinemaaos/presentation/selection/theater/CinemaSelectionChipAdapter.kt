package com.sopt.lottecinemaaos.presentation.selection.theater

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.data.entity.Theater
import com.sopt.lottecinemaaos.databinding.ItemSelectionChipBinding
import com.sopt.lottecinemaaos.presentation.selection.theater.CinemaSelectionChipAdapter.CinemaChipViewHolder
import com.sopt.lottecinemaaos.util.ItemDiffCallback

class CinemaSelectionChipAdapter(
    private val selectedCinemaItemList: List<Int>
) :
    ListAdapter<Theater, CinemaChipViewHolder>(
        ItemDiffCallback<Theater>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new }
        )
    ) {

    inner class CinemaChipViewHolder(
        private val binding: ItemSelectionChipBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Theater) {
            binding.tvSelectionChip.text = "테스트"
            Log.d("현재", selectedCinemaItemList.toString())
            if (selectedCinemaItemList.isNotEmpty()) {
                binding.tvSelectionChip.visibility = View.VISIBLE
            } else {
                binding.tvSelectionChip.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaChipViewHolder {
        val binding =
            ItemSelectionChipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CinemaChipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CinemaChipViewHolder, position: Int) {
        val cinema = getItem(position)
        holder.onBind(cinema)
    }
}
