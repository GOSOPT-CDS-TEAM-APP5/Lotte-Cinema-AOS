package com.sopt.lottecinemaaos.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.databinding.ItemHomeHappyEventBinding

class CinemaHomeEventRVAdapter :
    RecyclerView.Adapter<CinemaHomeEventRVAdapter.CinemaHomeEventViewHolder>() {

    private val itemList:List<Int> = listOf(
        R.drawable.img_home_event_happy,
        R.drawable.img_home_event_mario,
        R.drawable.img_home_event_lotte,
        R.drawable.img_home_event_coupon
    )

    class CinemaHomeEventViewHolder(private val binding: ItemHomeHappyEventBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(src:Int){
                binding.ivEvent.setImageResource(src)
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaHomeEventViewHolder {
        val binding = ItemHomeHappyEventBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return CinemaHomeEventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CinemaHomeEventViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}