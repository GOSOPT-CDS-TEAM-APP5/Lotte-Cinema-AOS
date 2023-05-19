package com.sopt.lottecinemaaos.presentation.selection

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.data.entity.Cinema
import com.sopt.lottecinemaaos.databinding.ItemSelectionCinemaBinding
import com.sopt.lottecinemaaos.util.ItemDiffCallback

class CinemaSelectionListAdapter :
    ListAdapter<Cinema, CinemaSelectionListAdapter.CinemaViewHolder>(
        ItemDiffCallback<Cinema>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new }
        )
    ) {
    private var selectedItemPosition = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaViewHolder {
        val binding =
            ItemSelectionCinemaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CinemaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CinemaViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class CinemaViewHolder(private val binding: ItemSelectionCinemaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var isItemSelected = false

        fun onBind(data: Cinema) {
            binding.tvItemCinema.text = data.name
            binding.clItemCinema.setOnClickListener {
                isItemSelected = !isItemSelected
                selectedItemPosition = bindingAdapterPosition
                Log.d("recyclerView", selectedItemPosition.toString())
                if (isItemSelected) {
                    binding.clItemCinema.setBackgroundColor(Color.parseColor("#EC6680"))
                } else {
                    binding.clItemCinema.setBackgroundColor(Color.parseColor("#EBEBEB"))
                }
            }
        }
    }
}
