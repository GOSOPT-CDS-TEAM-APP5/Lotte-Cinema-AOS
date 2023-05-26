package com.sopt.lottecinemaaos.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.databinding.ItemHomeMovieFeedBinding
import com.sopt.lottecinemaaos.data.entity.HomeLottePick

class CinemaHomePickRVAdapter(context: Context) :
    RecyclerView.Adapter<CinemaHomePickRVAdapter.CinemaHomePickViewHolder>() {

    private val inflater by lazy { LayoutInflater.from(context) }

    private val itemList:List<HomeLottePick> = listOf(
        HomeLottePick("울지마 엄마","5월 17일 대개봉",R.drawable.img_home_lotte_pick1),
        HomeLottePick("스트리머","5월 10일 대개봉",R.drawable.img_home_lotte_pick2),
        HomeLottePick("문재인입니다","5월 10일 대개봉",R.drawable.img_home_lotte_pick3)
    )

    class CinemaHomePickViewHolder(private val binding: ItemHomeMovieFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item: HomeLottePick){
                with(binding){
                    tvTitle.text = item.title
                    tvDay.text = item.day
                    ivPoster.setImageResource(item.src)
                }
            }
    }

    override fun onBindViewHolder(holder: CinemaHomePickViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaHomePickViewHolder {
       val binding = ItemHomeMovieFeedBinding.inflate(inflater,parent,false)
        return CinemaHomePickViewHolder(binding)
    }

    override fun getItemCount(): Int = itemList.size
}
        
        