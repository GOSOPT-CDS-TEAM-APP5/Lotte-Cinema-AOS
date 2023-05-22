package com.sopt.lottecinemaaos.presentation.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.databinding.ItemDetailPosterBinding
import com.sopt.lottecinemaaos.data.entity.Poster

class MovieDetailPosterAdapter(context: Context) :RecyclerView.Adapter<MovieDetailPosterAdapter.DetailPosterViewHolder>() {

    private val inflater by lazy { LayoutInflater.from(context) }

    private var itemList: List<Poster> = emptyList()

    class DetailPosterViewHolder(private val binding: ItemDetailPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Poster) {
            binding.imgItemPoster.setImageDrawable(binding.root.context.getDrawable(item.src))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailPosterViewHolder {
        val binding: ItemDetailPosterBinding = ItemDetailPosterBinding.inflate(inflater, parent, false)
        return DetailPosterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailPosterViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setList(posterList: List<Poster>) {
        this.itemList = posterList.toList()
        notifyDataSetChanged()
    }
}