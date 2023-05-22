package com.sopt.lottecinemaaos.presentation.selection.theater

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.data.entity.Cinema
import com.sopt.lottecinemaaos.databinding.ItemSelectionCinemaBinding
import com.sopt.lottecinemaaos.util.ItemDiffCallback

class CinemaSelectionListAdapter(
    private val selectItem: (Int) -> Unit,
    private val unselectItem: (Int) -> Unit
) :
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
        return CinemaViewHolder(binding, selectItem, unselectItem)
    }

    override fun onBindViewHolder(holder: CinemaViewHolder, position: Int) {
        holder.onBind(getItem(position), position)
    }

    inner class CinemaViewHolder(
        private val binding: ItemSelectionCinemaBinding,
        private val selectItem: (Int) -> Unit,
        private val unselectItem: (Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        private var isItemSelected = false

        fun onBind(data: Cinema, position: Int) {
            with(binding) {
                tvItemCinema.text = data.name
                clItemCinema.setOnClickListener {
                    isItemSelected = !isItemSelected
                    selectedItemPosition = bindingAdapterPosition
                    if (isItemSelected) {
                        binding.clItemCinema.setBackgroundColor(Color.parseColor("#EC6680"))
                        binding.tvItemCinema.setTextColor(Color.parseColor("#FFFFFF"))
                        selectItem(selectedItemPosition)
                    } else {
                        binding.clItemCinema.setBackgroundColor(Color.parseColor("#EBEBEB"))
                        binding.tvItemCinema.setTextColor(Color.parseColor("#000000"))
                        unselectItem(selectedItemPosition)
                    }
                }
            }
        }
    }
}
