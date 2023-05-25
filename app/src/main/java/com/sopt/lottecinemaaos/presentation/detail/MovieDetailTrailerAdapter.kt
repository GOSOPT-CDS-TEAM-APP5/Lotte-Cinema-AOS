package com.sopt.lottecinemaaos.presentation.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.lottecinemaaos.databinding.ItemDetailTrailerBinding
import com.sopt.lottecinemaaos.domain.model.Trailer

class MovieDetailTrailerAdapter(context: Context) :RecyclerView.Adapter<MovieDetailTrailerAdapter.DetailTrailerViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var itemList: List<Trailer> = emptyList()

    class DetailTrailerViewHolder(private var binding: ItemDetailTrailerBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun onBind(item: Trailer) {
                    with (binding) {
                        imgItemTrailer.setImageDrawable(root.context.getDrawable(item.src))
                        tvItemTrailer.text = item.title
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailTrailerViewHolder {
        val binding : ItemDetailTrailerBinding = ItemDetailTrailerBinding.inflate(inflater, parent, false)
        return DetailTrailerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailTrailerViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setList(trailerList: List<Trailer>) {
        this.itemList = trailerList.toList()
        notifyDataSetChanged()
    }
}