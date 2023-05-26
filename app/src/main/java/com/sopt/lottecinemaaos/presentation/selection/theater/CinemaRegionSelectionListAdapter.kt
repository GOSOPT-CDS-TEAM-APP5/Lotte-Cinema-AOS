package com.sopt.lottecinemaaos.presentation.selection.theater

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.databinding.ItemSelectionRegionBinding
import com.sopt.lottecinemaaos.domain.model.Region
import com.sopt.lottecinemaaos.util.ItemDiffCallback

class CinemaRegionSelectionListAdapter(private val viewmodel: CinemaSelectionViewModel) :
    ListAdapter<Region, CinemaRegionSelectionListAdapter.RegionViewHolder>(
        ItemDiffCallback<Region>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new }
        )
    ) {
    private var selectedItemPosition = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionViewHolder {
        val binding =
            ItemSelectionRegionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RegionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RegionViewHolder, position: Int) {
        holder.onBind(getItem(position)) as Region
    }

    inner class RegionViewHolder(private val binding: ItemSelectionRegionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var isItemSelected = false

        fun onBind(data: Region) {
            with(binding) {
                tvItemRegion.text = data.regionName
                tvItemRegionCount.text = "(${data.theaterCount})"
                clItemRegion.setOnClickListener {
                    isItemSelected = !isItemSelected
                    selectedItemPosition = absoluteAdapterPosition
                    viewmodel.updateRegionItemSelected(isItemSelected)
                    Log.d("recyclerView", selectedItemPosition.toString())
                    if (isItemSelected) {
                        binding.clItemRegion.setBackgroundColor(Color.parseColor("#EBEBEB"))
                    } else {
                        binding.clItemRegion.setBackgroundColor(Color.WHITE)
                    }
                }
            }
        }
    }
}
