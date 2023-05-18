package com.sopt.lottecinemaaos.presentation.selection

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.data.entity.Region
import com.sopt.lottecinemaaos.databinding.ItemSelectionRegionBinding
import com.sopt.lottecinemaaos.util.ItemDiffCallback

class CinemaRegionSelectionListAdapter :
    ListAdapter<Region, CinemaRegionSelectionListAdapter.RegionViewHolder>(
        ItemDiffCallback<Region>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new }
        )
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionViewHolder {
        val binding =
            ItemSelectionRegionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RegionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RegionViewHolder, position: Int) {
        holder.onBind(
            getItem(position) as Region

        )
    }

    class RegionViewHolder(private val binding: ItemSelectionRegionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var isItemSelected = false

        fun onBind(data: Region) {
            binding.tvItemRegion.text = data.regionName
            binding.tvItemRegionCount.text = "(${data.regionCount})"

            binding.clItemRegion.setOnClickListener {
                isItemSelected = !isItemSelected
                if (isItemSelected) {
                    binding.clItemRegion.setBackgroundColor(Color.parseColor("#EBEBEB"))
                } else {
                    binding.clItemRegion.setBackgroundColor(Color.WHITE)
                }
            }
        }
    }
}
