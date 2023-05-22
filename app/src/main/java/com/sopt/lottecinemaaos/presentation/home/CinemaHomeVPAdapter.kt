package com.sopt.lottecinemaaos.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.databinding.ItemHomeViewpagerBinding

class CinemaHomeVPAdapter( _itemList: List<Int> = listOf()) :
    RecyclerView.Adapter<CinemaHomeVPAdapter.CinemaHomeMovieViewHolder>() {

    private var itemList: List<Int> = _itemList
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CinemaHomeVPAdapter.CinemaHomeMovieViewHolder {
        val binding = ItemHomeViewpagerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CinemaHomeMovieViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CinemaHomeMovieViewHolder,
        position: Int
    ) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    class CinemaHomeMovieViewHolder(private val binding: ItemHomeViewpagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(src: Int) {
            binding.ivMoviePoster.setImageResource(src)
        }
    }

    fun setItemList(itemList: List<Int>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }
}